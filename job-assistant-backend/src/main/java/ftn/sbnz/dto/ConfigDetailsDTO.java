package ftn.sbnz.dto;

import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.dto.company.CompanyStatusConfigDTO;
import ftn.sbnz.dto.job_offer.JobOfferStatusConfigDTO;
import ftn.sbnz.model.company.CompanyStatusConfig;
import ftn.sbnz.model.job_offer.JobOfferStatusConfig;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConfigDetailsDTO {
	private List<CompanyStatusConfigDTO> companyStatusList;
	private List<JobOfferStatusConfigDTO> jobOfferStatusList;
	// private List<BenefitDTO> ...
	
	public ConfigDetailsDTO(List<CompanyStatusConfig> companyList, List<JobOfferStatusConfig> offerList) {
		this.companyStatusList = companyList.stream().map(el -> new CompanyStatusConfigDTO(el)).collect(Collectors.toList());
		this.jobOfferStatusList = offerList.stream().map(el -> new JobOfferStatusConfigDTO(el)).collect(Collectors.toList());
	}
}
