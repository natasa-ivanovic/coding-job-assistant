package ftn.sbnz.dto.interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ftn.sbnz.model.interview.InterviewSuggestion;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewSuggestionStatusDTO {
	
	private Long id;
	private boolean checked;
	private Date dateSuggested;
	private Date dateChecked;
	private List<InterviewSuggestionDTO> interviewSuggestions;
//	private JobSeeker jobSeeker;
//	private JobOfferDifference jobOfferDifference;
	
	
	public InterviewSuggestionStatusDTO(InterviewSuggestionStatus status) {
		this.id = status.getId();
		this.checked = status.isChecked();
		this.dateSuggested = status.getDateSuggested();
		this.dateChecked = status.getDateChecked();
		this.interviewSuggestions = new ArrayList<>();
		for (InterviewSuggestion is : status.getInterviewSuggestions()) {
			this.interviewSuggestions.add(new InterviewSuggestionDTO(is));
		}
	}
}
