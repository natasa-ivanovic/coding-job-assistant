package ftn.sbnz;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.TestPropertySource;

import ftn.sbnz.tests.CEPAccountStatusTests;
import ftn.sbnz.tests.CEPReviewsTests;
import ftn.sbnz.tests.CompanyStatusRulesTests;
import ftn.sbnz.tests.JobOfferRulesTests;
import ftn.sbnz.tests.JobOfferStatisticTest;
import ftn.sbnz.tests.JobOffersStatusRulesTest;
import ftn.sbnz.tests.JobPositionRulesTests;

@RunWith(Suite.class)
@SuiteClasses({
	JobPositionRulesTests.class,
	CompanyStatusRulesTests.class,
	CEPReviewsTests.class,
	CEPAccountStatusTests.class,
	JobOfferRulesTests.class,
	JobOfferStatisticTest.class,
	JobOffersStatusRulesTest.class
})
@TestPropertySource("classpath:application.properties")
class JobAssistantApplicationTests {

}
