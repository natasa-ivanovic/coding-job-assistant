package ftn.sbnz.dto.job_offer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.CVElementType;
import ftn.sbnz.model.job_offer.JobOfferDifference;
import ftn.sbnz.model.job_offer.JobOfferStatistic;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferStatisticDTO {

	private Long id;
	private Timestamp date;
	private List<JobOfferDifferenceDTO> programmingDifferences;
	private List<JobOfferDifferenceDTO> technologyDifferences;
	private List<JobOfferDifferenceDTO> knowledgeDifferences;
	private List<JobOfferDifferenceDTO> softSkillDifferences;
	private List<JobOfferDifferenceDTO> languageDifferences;

	public JobOfferStatisticDTO(JobOfferStatistic jos) {
		this.id = jos.getId();
		this.date = jos.getDate();
		
		this.programmingDifferences = jos.getDifferences().stream()
				.filter(el -> el.getCvElementType().equals(CVElementType.PROGRAMMING_LANGUAGE))
				.map(el -> new JobOfferDifferenceDTO(el)).collect(Collectors.toList());
		
		this.technologyDifferences = jos.getDifferences().stream()
				.filter(el -> el.getCvElementType().equals(CVElementType.TECHNOLOGY))
				.map(el -> new JobOfferDifferenceDTO(el)).collect(Collectors.toList());
		
		this.knowledgeDifferences = jos.getDifferences().stream()
				.filter(el -> el.getCvElementType().equals(CVElementType.KNOWLEDGE))
				.map(el -> new JobOfferDifferenceDTO(el)).collect(Collectors.toList());
		
		this.softSkillDifferences = jos.getDifferences().stream()
				.filter(el -> el.getCvElementType().equals(CVElementType.SOFT_SKILL))
				.map(el -> new JobOfferDifferenceDTO(el)).collect(Collectors.toList());
		
		this.languageDifferences = jos.getDifferences().stream()
				.filter(el -> el.getCvElementType().equals(CVElementType.LANGUAGE))
				.map(el -> new JobOfferDifferenceDTO(el)).collect(Collectors.toList());

	}
}
