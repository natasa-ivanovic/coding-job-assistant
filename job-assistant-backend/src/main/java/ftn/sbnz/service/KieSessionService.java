package ftn.sbnz.service;

import java.util.Collection;

import org.drools.core.ObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.events.InvalidLoginEvent;
import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_position.JobPosition;

@Service
@Transactional
public class KieSessionService {

	private KieContainer kieContainer;
	private KieSession kieSession;

	@Autowired
	public KieSessionService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
		this.kieSession = this.kieContainer.newKieSession("rulesSession");
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

	public void setAgendaFocus(String groupName) {
		this.kieSession.getAgenda().getAgendaGroup(groupName).setFocus();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection<Object> getObjectsFromSession(final Class factClass) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				return object.getClass().equals(factClass);
			}
		};

		Collection<Object> results = (Collection<Object>) kieSession.getObjects(filter);
		return results;
	}

	public void removeLoginEvents(Long userId) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				if (object.getClass().equals(InvalidLoginEvent.class)) {
					InvalidLoginEvent event = (InvalidLoginEvent) object;
					return event.getJobSeekerId().equals(userId);
				}
				return false;
			}
		};
		Collection<FactHandle> events = this.kieSession.getFactHandles(filter);
		for (FactHandle handle : events) {
			this.kieSession.delete(handle);
		}
	}
	
	public void removeCompanyById(Long companyId) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				if (object.getClass().equals(Company.class)) {
					Company c = (Company) object;
					return c.getId().equals(companyId);
				}
				return false;
			}
		};
		Collection<FactHandle> events = this.kieSession.getFactHandles(filter);
		for (FactHandle handle : events) {
			this.kieSession.delete(handle);
		}
	}

	public void removeJobPositionById(Long jpId) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				if (object.getClass().equals(JobPosition.class)) {
					JobPosition jp = (JobPosition) object;
					return jp.getId().equals(jpId);
				}
				return false;
			}
		};
		Collection<FactHandle> events = this.kieSession.getFactHandles(filter);
		for (FactHandle handle : events) {
			this.kieSession.delete(handle);
		}
	}

	public void removeJobOfferById(Long joId) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				if (object.getClass().equals(JobOffer.class)) {
					JobOffer jo = (JobOffer) object;
					return jo.getId().equals(joId);
				}
				return false;
			}
		};
		Collection<FactHandle> events = this.kieSession.getFactHandles(filter);
		for (FactHandle handle : events) {
			this.kieSession.delete(handle);
		}
	}

	public void removeCompanyReviewById(Long id) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				if (object.getClass().equals(CompanyReview.class)) {
					CompanyReview r = (CompanyReview) object;
					return r.getId().equals(id);
				}
				return false;
			}
		};
		Collection<FactHandle> events = this.kieSession.getFactHandles(filter);
		for (FactHandle handle : events) {
			this.kieSession.delete(handle);
		}
	}
}
