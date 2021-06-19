package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.user.JobSeekerRanking;
import ftn.sbnz.repository.company.CompanyRepository;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.util.SessionUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobOffersStatusRulesTest {
	
	@Autowired
    private CompanyRepository companyRepo;
 
    @Autowired
    private JobOfferRepository offerRepo;
    
    @Test
    public void offerStatusBronze() {
        KieSession session = setupSession();
 
        Company company = companyRepo.findById(1L).get();
        company.setMedal(MedalRank.BRONZE);
        session.insert(company);
        
        JobOffer jobOffer = offerRepo.findById(1L).get();
        session.insert(jobOffer);
        
        JobSeekerRanking jsr = new JobSeekerRanking();
        jsr.setJobOffer(jobOffer);
        session.insert(jsr);
        
        session.getAgenda().getAgendaGroup("job-offer-status").setFocus();
        int firedRules = session.fireAllRules();
 
        assertEquals(1, firedRules);
        
        jobOffer = SessionUtil.getOfferFromSession(jobOffer, session);
        
        assertEquals(MedalRank.BRONZE, jobOffer.getMedal());
 
        session.dispose();
    }
    
 
    @Test
    public void offerStatusSilver() {
        KieSession session = setupSession();
 
        Company company = companyRepo.findById(1L).get();
        company.setMedal(MedalRank.SILVER);
        session.insert(company);
        
        JobOffer jobOffer = offerRepo.findById(1L).get();
        session.insert(jobOffer);
        
        JobSeekerRanking jsr = new JobSeekerRanking();
        jsr.setJobOffer(jobOffer);
        session.insert(jsr);
 
        JobSeekerRanking jsr2 = new JobSeekerRanking();
        jsr2.setJobOffer(jobOffer);
        session.insert(jsr2);
        
        session.getAgenda().getAgendaGroup("job-offer-status").setFocus();
        int firedRules = session.fireAllRules();
 
        assertEquals(2, firedRules);
        
        jobOffer = SessionUtil.getOfferFromSession(jobOffer, session);
        
        assertEquals(MedalRank.SILVER, jobOffer.getMedal());
 
        session.dispose();
    }
 
    @Test
    public void offerStatusGold() {
        KieSession session = setupSession();
 
        Company company = companyRepo.findById(1L).get();
        company.setMedal(MedalRank.GOLD);
        session.insert(company);
        
        JobOffer jobOffer = offerRepo.findById(1L).get();
        session.insert(jobOffer);
        
        JobSeekerRanking jsr = new JobSeekerRanking();
        jsr.setJobOffer(jobOffer);
        session.insert(jsr);
 
        JobSeekerRanking jsr2 = new JobSeekerRanking();
        jsr2.setJobOffer(jobOffer);
        session.insert(jsr2);
 
        JobSeekerRanking jsr3 = new JobSeekerRanking();
        jsr3.setJobOffer(jobOffer);
        session.insert(jsr3);
        
        session.getAgenda().getAgendaGroup("job-offer-status").setFocus();
        int firedRules = session.fireAllRules();
 
        assertEquals(3, firedRules);
        
        jobOffer = SessionUtil.getOfferFromSession(jobOffer, session);
        
        assertEquals(MedalRank.GOLD, jobOffer.getMedal());
 
        session.dispose();
    }
 
    
    private KieSession setupSession() {
 
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.setGlobal("programmingLanguageCoefficient", new Integer(10));
        kieSession.setGlobal("technologyCoefficient", new Integer(8));
        kieSession.setGlobal("knowledgeCoefficient", new Integer(5));
        kieSession.setGlobal("monthsExperienceCoefficient", new Float(1));
        return kieSession;
    }

}
