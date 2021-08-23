package ftn.sbnz.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.drools.core.ObjectFilter;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.benefit.BenefitDTO;
import ftn.sbnz.dto.company.CompanyStatusConfigTemplateDTO;
import ftn.sbnz.dto.job_offer.JobOfferStatusConfigTemplateDTO;
import ftn.sbnz.dto.user.WorkingExperienceTemplateDTO;
import ftn.sbnz.events.InvalidLoginEvent;
import ftn.sbnz.model.benefit.Benefit;
import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.company.CompanyStatusConfig;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferStatusConfig;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.model.user.WorkingExperience;

@Service
@Transactional
public class KieSessionService {

	private final String templateFolderPath = "../drools-spring-kjar/src/main/resources/sbnz/templates/";
	private final String ruleFolderPath = "../drools-spring-kjar/src/main/resources/sbnz/rules/";

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

	public void createTemplateWorkingExperience(List<WorkingExperience> list) {
		List<Object> objectList = list.stream().map(el -> new WorkingExperienceTemplateDTO(el))
				.collect(Collectors.toList());
		String templatePath = this.templateFolderPath + "job_offer_working_experience.drt";
		String rulePath = this.ruleFolderPath + "job_offer_working_experience.drl";
		this.createTemplate(objectList, templatePath, rulePath);
	}

	public void createTemplateCompanyStatus(List<CompanyStatusConfig> list) {
		List<Object> objectList = list.stream().map(el -> new CompanyStatusConfigTemplateDTO(el))
				.collect(Collectors.toList());
		String templatePath = this.templateFolderPath + "company_status.drt";
		String rulePath = this.ruleFolderPath + "company_status_rules.drl";
		this.createTemplate(objectList, templatePath, rulePath);
	}

	public void createTemplateJobOfferStatus(List<JobOfferStatusConfig> list) {
		List<Object> objectList = list.stream().map(el -> new JobOfferStatusConfigTemplateDTO(el))
				.collect(Collectors.toList());
		String templatePath = this.templateFolderPath + "job_offer_status.drt";
		String rulePath = this.ruleFolderPath + "job_offer_status_rules.drl";
		this.createTemplate(objectList, templatePath, rulePath);
	}

	
//	public void createTemplateBenefit(List<Benefit> list) {
//		List<Object> objectList = list.stream().map(el -> new BenefitDTO(el))
//				.collect(Collectors.toList());
//		String templatePath = this.templateFolderPath + "job_offer_benefit.drt";
//		String rulePath = this.ruleFolderPath + "benefits_rules.drl";
//		try(BufferedReader br = new BufferedReader(new FileReader(templatePath))) {
//			String line;
//			while((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		this.createTemplate(objectList, templatePath, rulePath);
//		
//	}
	
	private void createTemplate(List<Object> list, String templateFilePath, String ruleFilePath) {
		try {
			InputStream templateFile = new FileInputStream(templateFilePath);

			ObjectDataCompiler converter = new ObjectDataCompiler();
			String drl = converter.compile(list, templateFile);

			FileOutputStream ruleFile;
			ruleFile = new FileOutputStream(new File(ruleFilePath));
			ruleFile.write(drl.getBytes());
			ruleFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void recompileRules() {
		try {
			InvocationRequest request = new DefaultInvocationRequest();
			request.setPomFile(new File("../drools-spring-kjar/pom.xml"));
			request.setGoals(Collections.singletonList("install"));
			Invoker invoker = new DefaultInvoker();
			invoker.setMavenHome(new File(System.getenv("M2_HOME")));
			invoker.execute(request);
		} catch (MavenInvocationException e) {
			e.printStackTrace();
		}
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
