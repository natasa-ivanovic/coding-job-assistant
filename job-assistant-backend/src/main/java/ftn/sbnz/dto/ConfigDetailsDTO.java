package ftn.sbnz.dto;

import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.dto.benefit.BenefitDTO;
import ftn.sbnz.dto.company.CompanyStatusConfigDTO;
import ftn.sbnz.dto.job_offer.JobOfferStatusConfigDTO;
import ftn.sbnz.model.benefit.Benefit;
import ftn.sbnz.model.company.CompanyStatusConfig;
import ftn.sbnz.model.job_offer.JobOfferStatusConfig;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConfigDetailsDTO {
	private List<CompanyStatusConfigDTO> companyStatusList;
	private List<JobOfferStatusConfigDTO> jobOfferStatusList;
	private List<BenefitDTO> benefitsList;
	
	public ConfigDetailsDTO(List<CompanyStatusConfig> companyList, List<JobOfferStatusConfig> offerList, List<Benefit> benefitList) {
		this.companyStatusList = companyList.stream().map(el -> new CompanyStatusConfigDTO(el)).collect(Collectors.toList());
		this.jobOfferStatusList = offerList.stream().map(el -> new JobOfferStatusConfigDTO(el)).collect(Collectors.toList());
		this.benefitsList = benefitList.stream().map(el -> new BenefitDTO(el)).collect(Collectors.toList());
	}
}
