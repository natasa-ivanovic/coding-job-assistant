package ftn.sbnz.dto.job_offer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
		this.programmingDifferences = new ArrayList<>();
		this.technologyDifferences = new ArrayList<>();
		this.knowledgeDifferences = new ArrayList<>();
		this.softSkillDifferences = new ArrayList<>();
		this.languageDifferences = new ArrayList<>();
		for (JobOfferDifference d : jos.getProgrammingDifferences()) {
			this.programmingDifferences.add(new JobOfferDifferenceDTO(d));
		}
		for (JobOfferDifference d : jos.getTechnologyDifferences()) {
			this.technologyDifferences.add(new JobOfferDifferenceDTO(d));
		}
		for (JobOfferDifference d : jos.getKnowledgeDifferences()) {
			this.knowledgeDifferences.add(new JobOfferDifferenceDTO(d));
		}
		for (JobOfferDifference d : jos.getSoftSkillDifferences()) {
			this.softSkillDifferences.add(new JobOfferDifferenceDTO(d));
		}
		for (JobOfferDifference d : jos.getLanguageDifferences()) {
			this.languageDifferences.add(new JobOfferDifferenceDTO(d));
		}
	}
}
