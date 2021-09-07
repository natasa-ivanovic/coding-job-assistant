package ftn.sbnz.dto.interview;

import java.util.ArrayList;
import java.util.List;

import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import ftn.sbnz.model.job_offer.JobOffer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewSuggestionGroupDTO {
	
	private String position;
	private String company;
	private SeniorityLevel seniority;
	private List<InterviewSuggestionStatusDTO> statuses;
	
	public InterviewSuggestionGroupDTO(List<InterviewSuggestionStatus> sts, JobOffer jo) {
		this.position = jo.getPosition().getTitle();
		this.company = jo.getCompany().getName();
		this.seniority = jo.getSeniority();
		this.statuses = new ArrayList<>();
		for (InterviewSuggestionStatus st: sts) {
			statuses.add(new InterviewSuggestionStatusDTO(st));
		}
		
	}

}
