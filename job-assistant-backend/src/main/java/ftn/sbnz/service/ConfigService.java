package ftn.sbnz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.ConfigDetailsDTO;
import ftn.sbnz.dto.benefit.BenefitDTO;
import ftn.sbnz.dto.company.CompanyStatusConfigDTO;
import ftn.sbnz.dto.job_offer.JobOfferStatusConfigDTO;
import ftn.sbnz.model.benefit.Benefit;
import ftn.sbnz.model.company.CompanyStatusConfig;
import ftn.sbnz.model.job_offer.JobOfferStatusConfig;
import ftn.sbnz.repository.benefit.BenefitRepository;
import ftn.sbnz.repository.company.CompanyStatusConfigRepository;
import ftn.sbnz.repository.job_offer.JobOfferStatusConfigRepository;

@Service
@Transactional
public class ConfigService {

	private JobOfferStatusConfigRepository offerStatusRepo;

	private CompanyStatusConfigRepository companyStatusRepo;
	
	private BenefitRepository benefitRepo;

	private KieSessionService kieService;

	@Autowired
	public ConfigService(JobOfferStatusConfigRepository offerStatusRepo,
			CompanyStatusConfigRepository companyStatusRepo, KieSessionService kieService, BenefitRepository benefitRepo) {
		this.offerStatusRepo = offerStatusRepo;
		this.companyStatusRepo = companyStatusRepo;
		this.kieService = kieService;
		this.benefitRepo = benefitRepo;
	}

	public ConfigDetailsDTO getDetails() {
		List<JobOfferStatusConfig> offerStatusList = offerStatusRepo.findAll();
		List<CompanyStatusConfig> companyStatusList = companyStatusRepo.findAll();
		List<Benefit> benefitList = benefitRepo.findAll();
		return new ConfigDetailsDTO(companyStatusList, offerStatusList, benefitList);
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

		for (BenefitDTO bDTO : dto.getBenefitsList()) {
			Benefit b = this.benefitRepo.getOne(bDTO.getId());
			b.setDescription(bDTO.getDescription());
			b.setLevelImportance(bDTO.getLevelImportance());
			this.benefitRepo.save(b);
		}
	}

	@Async
	public void updateRules() {
		this.kieService.createTemplateCompanyStatus(this.companyStatusRepo.findAll());
		this.kieService.createTemplateJobOfferStatus(this.offerStatusRepo.findAll());
		this.kieService.createTemplateBenefit(this.benefitRepo.findAll());
		this.kieService.recompileRules();
	}

}
