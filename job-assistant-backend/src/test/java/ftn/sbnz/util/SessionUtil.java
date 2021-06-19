package ftn.sbnz.util;

import java.util.Collection;
import java.util.Iterator;

import org.drools.core.ObjectFilter;
import org.kie.api.runtime.KieSession;

import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.job_offer.JobOffer;

public class SessionUtil {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Collection<Object> getObjectsFromSession(final Class factClass, KieSession session) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				return object.getClass().equals(factClass);
			}
		};

		Collection<Object> results = (Collection<Object>) session.getObjects(filter);
		return results;
	}

	public static Company getCompanyFromSession(Company companyDb, KieSession session) {
		Collection<Object> companies = getObjectsFromSession(Company.class, session);
		for (Iterator<Object> it = companies.iterator(); it.hasNext();) {
			Company c = (Company) it.next();
			if (companyDb.getId() == c.getId()) {
				if (!companyDb.getMedal().equals(c.getMedal())) {
					companyDb.setMedal(c.getMedal());;
				}
				return companyDb;
			}
		}
		return companyDb;
	}	
	
	public static JobOffer getOfferFromSession(JobOffer offerDb, KieSession session) {
        Collection<Object> companies = getObjectsFromSession(JobOffer.class, session);
        for (Iterator<Object> it = companies.iterator(); it.hasNext();) {
            JobOffer c = (JobOffer) it.next();
            if (offerDb.getId() == c.getId()) {
                if (!offerDb.getMedal().equals(c.getMedal())) {
                    offerDb.setMedal(c.getMedal());;
                }
                return offerDb;
            }
        }
        return offerDb;
    } 
}
