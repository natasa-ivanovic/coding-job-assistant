package ftn.sbnz.model.interview;

import java.util.ArrayList;
import java.util.List;

import ftn.sbnz.model.job_offer.JobOfferDifference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class InterviewSuggestionGroup {
	
	@NonNull
	private JobOfferDifference jobOfferDifference;
	
	@NonNull
	private List<InterviewSuggestion> interviewSuggestions = new ArrayList<>();
}
