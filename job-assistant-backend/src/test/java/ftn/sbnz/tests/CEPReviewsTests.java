package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.drools.core.time.SessionPseudoClock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ftn.sbnz.events.DisabledUserEvent;
import ftn.sbnz.events.MaliciousReviewerEvent;
import ftn.sbnz.events.ReviewDeclinedEvent;
import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.enums.ReviewStatus;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.user.JobSeekerRepository;
import ftn.sbnz.util.SessionUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CEPReviewsTests {

	@Autowired
	private JobSeekerRepository jobSeekerRepo;

	@Test
	public void reviewDeclinedEvent() {
		KieSession session = setupSession();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		CompanyReview review1 = createBadReview(js);

		session.insert(review1);

		session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(1, firedRules);

		Collection<Object> events = SessionUtil.getObjectsFromSession(ReviewDeclinedEvent.class, session);

		assertEquals(1, events.size());

		session.dispose();
	}

	@Test
	public void maliciousReviewerEvent() {
		KieSession session = setupSession();
		SessionPseudoClock clock = session.getSessionClock();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		for (int i = 0; i != 2; i++) {
			CompanyReview review = createBadReview(js);
			session.insert(review);
			session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
			int firedRules = session.fireAllRules();
			assertEquals(1, firedRules);

			clock.advanceTime(10, TimeUnit.SECONDS);
		}
		CompanyReview review = createBadReview(js);
		session.insert(review);
		session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
		int firedRules = session.fireAllRules();
		// (ReviewDeclinedEvent + MaliciousReviewer + 3x delete ReviewDeclined)
		assertEquals(5, firedRules);

		Collection<Object> events = SessionUtil.getObjectsFromSession(MaliciousReviewerEvent.class, session);

		assertEquals(1, events.size());
	}

	@Test
	public void userDisabledEvent() {
		KieSession session = setupSession();
		SessionPseudoClock clock = session.getSessionClock();

		long amount = LocalDateTime.now().toInstant(ZoneOffset.ofHours(2)).toEpochMilli() - clock.getCurrentTime();
		clock.advanceTime(amount, TimeUnit.MILLISECONDS);

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		for (int i = 0; i != 2; i++) {
			CompanyReview review = createBadReview(js);
			review.setDate(new Timestamp(clock.getCurrentTime()));
			session.insert(review);
			session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
			int firedRules = session.fireAllRules();
			assertEquals(1, firedRules);
		}
		CompanyReview review = createBadReview(js);
		review.setDate(new Timestamp(clock.getCurrentTime()));
		session.insert(review);
		session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
		int firedRules = session.fireAllRules();
		// (ReviewDeclinedEvent + MaliciousReviewer + 3x delete ReviewDeclined)
		assertEquals(5, firedRules);

		clock.advanceTime(1, TimeUnit.DAYS);

		for (int i = 0; i != 2; i++) {
			review = createBadReview(js);
			review.setDate(new Timestamp(clock.getCurrentTime()));
			session.insert(review);
			session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
			firedRules = session.fireAllRules();
			assertEquals(1, firedRules);

			clock.advanceTime(10, TimeUnit.SECONDS);
		}
		review = createBadReview(js);
		review.setDate(new Timestamp(clock.getCurrentTime()));
		session.insert(review);
		session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
		session.fireAllRules();

		Collection<Object> events = SessionUtil.getObjectsFromSession(MaliciousReviewerEvent.class, session);

		assertEquals(2, events.size());

		Collection<Object> disabledEvents = SessionUtil.getObjectsFromSession(DisabledUserEvent.class, session);

		assertEquals(1, disabledEvents.size());
	}

	@Test
	public void maliciousReviewerReviewDeclinedEvent() {
		KieSession session = setupSession();
		SessionPseudoClock clock = session.getSessionClock();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		for (int i = 0; i != 2; i++) {
			CompanyReview review = createBadReview(js);
			session.insert(review);
			session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
			int firedRules = session.fireAllRules();
			assertEquals(1, firedRules);

			clock.advanceTime(10, TimeUnit.SECONDS);
		}
		CompanyReview review = createBadReview(js);
		session.insert(review);
		session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
		int firedRules = session.fireAllRules();
		// (ReviewDeclinedEvent + MaliciousReviewer + 3x delete ReviewDeclined)
		assertEquals(5, firedRules);

		Collection<Object> events = SessionUtil.getObjectsFromSession(MaliciousReviewerEvent.class, session);

		assertEquals(1, events.size());

		clock.advanceTime(10, TimeUnit.SECONDS);

		review = createBadReview(js);
		session.insert(review);
		session.getAgenda().getAgendaGroup("job-offer-review-added").setFocus();
		firedRules = session.fireAllRules();

		// show that the newly added bad review is not triggering an event because of
		// previous malicious reviewer not expiring

		events = SessionUtil.getObjectsFromSession(ReviewDeclinedEvent.class, session);

		assertEquals(0, events.size());
	}

	private CompanyReview createBadReview(JobSeeker js) {
		CompanyReview review = new CompanyReview();
		Calendar rightNow = Calendar.getInstance();
		review.setDate(new Timestamp(rightNow.getTimeInMillis()));
		review.setStatus(ReviewStatus.DECLINED);
		review.setPoster(js);
		review.setJobOffered(true);
		review.setRecommends(true);
		review.setHired(true);
		review.setRating(1);
		review.setRatedUseful(15);
		review.setRatedNotUseful(0);
		return review;
	}

	private KieSession setupSession() {
		KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
		config.setOption(ClockTypeOption.get("pseudo"));
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("rulesSession", config);
		kieSession.setGlobal("programmingLanguageCoefficient", new Integer(10));
		kieSession.setGlobal("technologyCoefficient", new Integer(8));
		kieSession.setGlobal("knowledgeCoefficient", new Integer(5));
		kieSession.setGlobal("monthsExperienceCoefficient", new Float(1));
		return kieSession;
	}
}
