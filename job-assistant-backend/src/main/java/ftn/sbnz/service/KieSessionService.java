package ftn.sbnz.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KieSessionService {

	private KieContainer kieContainer;
	private KieSession kieSession;
	
	@Autowired
	public KieSessionService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
		this.kieSession = this.kieContainer.newKieSession("rulesSession");
		System.out.println("Pokrenut opet Kie Session Service Bean");
	}
	
	public void insert(Object o) {
		this.kieSession.insert(o);
	}
	
	public void fireAllRules() {
		this.kieSession.fireAllRules();
	}
	
	public void dispose() {
		this.kieSession.dispose();
	}
	
	public void setGlobal(String identifier, Object value) {
		this.kieSession.setGlobal(identifier, value);
	}
	
}
