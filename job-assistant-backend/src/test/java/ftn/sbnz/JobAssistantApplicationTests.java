package ftn.sbnz;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@SuiteClasses({
	JobPositionRulesTests.class
})
@TestPropertySource("classpath:application.properties")
class JobAssistantApplicationTests {

}
