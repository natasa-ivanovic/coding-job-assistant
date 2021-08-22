package ftn.sbnz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.ConfigDetailsDTO;
import ftn.sbnz.dto.company.CompanyStatusConfigDTO;
import ftn.sbnz.dto.job_offer.JobOfferStatusConfigDTO;
import ftn.sbnz.model.company.CompanyStatusConfig;
import ftn.sbnz.model.job_offer.JobOfferStatusConfig;
import ftn.sbnz.repository.company.CompanyStatusConfigRepository;
import ftn.sbnz.repository.job_offer.JobOfferStatusConfigRepository;

@Service
@Transactional
public class ConfigService {

	private JobOfferStatusConfigRepository offerStatusRepo;

	private CompanyStatusConfigRepository companyStatusRepo;

	private KieSessionService kieService;

	@Autowired
	public ConfigService(JobOfferStatusConfigRepository offerStatusRepo,
			CompanyStatusConfigRepository companyStatusRepo, KieSessionService kieService) {
		this.offerStatusRepo = offerStatusRepo;
		this.companyStatusRepo = companyStatusRepo;
		this.kieService = kieService;
	}

	public ConfigDetailsDTO getDetails() {
		List<JobOfferStatusConfig> offerStatusList = offerStatusRepo.findAll();
		List<CompanyStatusConfig> companyStatusList = companyStatusRepo.findAll();
		return new ConfigDetailsDTO(companyStatusList, offerStatusList);
	}

	public void updateConfig(ConfigDetailsDTO dto) {
		for (CompanyStatusConfigDTO compDTO : dto.getCompanyStatusList()) {
			CompanyStatusConfig c = this.companyStatusRepo.getOne(compDTO.getId());
			c.setAverageRating(compDTO.getAverageRating());
			c.setCompanyMedal(compDTO.getCompanyMedal());
			c.setRatedPositiveDifference(compDTO.getRatedPositiveDifference());
			c.setTotalHired(compDTO.getTotalHired());
			c.setTotalReviews(compDTO.getTotalReviews());
			this.companyStatusRepo.save(c);
		}

		for (JobOfferStatusConfigDTO joDTO : dto.getJobOfferStatusList()) {
			JobOfferStatusConfig jo = this.offerStatusRepo.getOne(joDTO.getId());
			jo.setCompanyMedal(joDTO.getCompanyMedal());
			jo.setDaysSincePosted(joDTO.getDaysSincePosted());
			jo.setOfferMedal(joDTO.getOfferMedal());
			jo.setTotalFollowers(joDTO.getTotalFollowers());
			this.offerStatusRepo.save(jo);
		}
	}

	@Async
	public void updateRules() {
		this.kieService.createTemplateCompanyStatus(this.companyStatusRepo.findAll());
		this.kieService.createTemplateJobOfferStatus(this.offerStatusRepo.findAll());
		// do the same for benefits
		this.kieService.recompileRules();
//		this.kieService.setAgendaFocus("job-offer-status");
//		this.kieService.setAgendaFocus("company-status");
//		this.kieService.fireAllRules();
	}

}
