package ftn.sbnz.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.model.Test;

@Service
public class TestService {
	@Autowired
	private KieContainer kieContainer;
	
	public Test test() {
		Test test = new Test();
		test.setTest("Test objekat tek kreiran");
		System.out.println("Test poruka pre pravila: " + test.getTest());
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(test);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("Test poruka posle pravila: " + test.getTest());
		return test;
	}

}
