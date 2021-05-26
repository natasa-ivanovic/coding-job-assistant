package ftn.sbnz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.model.Test;

@Service
public class TestService {
	
	@Autowired
	private KieSessionService session;
	
	public Test test() {
		Test test = new Test();
		test.setTest("Test objekat tek kreiran");
		System.out.println("Test poruka pre pravila: " + test.getTest());
		session.insert(test);
		session.fireAllRules();
		session.dispose();
		System.out.println("Test poruka posle pravila: " + test.getTest());
		return test;
	}

}
