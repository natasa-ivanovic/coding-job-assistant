package ftn.sbnz.dto.job_offer;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.dto.cv_element.CVElementImportanceDTO;
import ftn.sbnz.model.enums.CVElementType;
import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.job_offer.JobOffer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferDTO {

	private Long id;
	private SeniorityLevel seniority;
	private MedalRank medal;
	private Date datePosted;
	private String companyName;
	private String companyId;
	private String positionName;
	private String positionId;
	private List<CVElementImportanceDTO> programmingImportances;
	private List<CVElementImportanceDTO> technologyImportances;
	private List<CVElementImportanceDTO> knowledgeImportances;
	private List<CVElementImportanceDTO> softSkillImportances;
	private List<CVElementImportanceDTO> languageImportances;
	

	public JobOfferDTO(JobOffer jo) {
		this.id = jo.getId();
		this.seniority = jo.getSeniority();
		this.medal = jo.getMedal();
		this.datePosted = jo.getDatePosted();
		this.companyName = jo.getCompany().getName();
		this.companyId = jo.getCompany().getId().toString();
		this.positionName = jo.getPosition().getTitle();
		this.positionId = jo.getPosition().getId().toString();
		
		this.programmingImportances = jo.getCvElementImportances().stream()
				.filter(el -> el.getCvElementProficiency().getCvElement().getType().equals(CVElementType.PROGRAMMING_LANGUAGE))
				.map(el -> new CVElementImportanceDTO(el)).collect(Collectors.toList());
		
		this.technologyImportances = jo.getCvElementImportances().stream()
				.filter(el -> el.getCvElementProficiency().getCvElement().getType().equals(CVElementType.TECHNOLOGY))
				.map(el -> new CVElementImportanceDTO(el)).collect(Collectors.toList());
		
		this.knowledgeImportances = jo.getCvElementImportances().stream()
				.filter(el -> el.getCvElementProficiency().getCvElement().getType().equals(CVElementType.KNOWLEDGE))
				.map(el -> new CVElementImportanceDTO(el)).collect(Collectors.toList());
		
		this.softSkillImportances = jo.getCvElementImportances().stream()
				.filter(el -> el.getCvElementProficiency().getCvElement().getType().equals(CVElementType.SOFT_SKILL))
				.map(el -> new CVElementImportanceDTO(el)).collect(Collectors.toList());
		
		this.languageImportances = jo.getCvElementImportances().stream()
				.filter(el -> el.getCvElementProficiency().getCvElement().getType().equals(CVElementType.LANGUAGE))
				.map(el -> new CVElementImportanceDTO(el)).collect(Collectors.toList());
	}
	

}
