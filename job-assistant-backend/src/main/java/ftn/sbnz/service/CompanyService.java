package ftn.sbnz.service;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.model.company.Company;
import ftn.sbnz.repository.company.CompanyRepository;

@Service
public class CompanyService {

	private CompanyRepository repository;
	private KieSessionService kieSession;

	@Autowired
	public CompanyService(CompanyRepository repository, KieSessionService kieSession) {
		this.repository = repository;
		this.kieSession = kieSession;
	}

	public void save(Company c) {
		this.repository.save(c);
	}

	public void updateDBFromRule(Company companyDb) {
		Collection<Object> companies = kieSession.getObjectsFromSession(Company.class);
		for (Iterator<Object> it = companies.iterator(); it.hasNext();) {
			Company c = (Company) it.next();
			if (companyDb.getId() == c.getId()) {
				if (!companyDb.getMedal().equals(c.getMedal())) {
					companyDb.setMedal(c.getMedal());;
					this.save(c);
				}
				return;
			}
		}

	}

}
