package ftn.sbnz.dto.job_offer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.model.job_offer.JobOfferRating;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.user.JobSeekerRanking;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferSuggestionDTO {
	
	private Long id;
	private Timestamp date;
	private List<JobOfferRatingDTO> offerRatings;
	
	public JobOfferSuggestionDTO(JobOfferSuggestion suggestion, List<JobOfferRatingDTO> ratings) {
		this.id = suggestion.getId();
		this.date = suggestion.getDate();
		this.offerRatings = new ArrayList<>();
		this.offerRatings = ratings;
	}
	
//	public JobOfferSuggestionDTO(JobOfferSuggestion suggestion) {
//		this.id = suggestion.getId();
//		this.date = suggestion.getDate();
//		this.offerRatings = new ArrayList<>();
//		for (JobOfferRating d : suggestion.getOfferRatings()) {
//			String position = sortRankings(d.getJobOffer().getRankings(), suggestion.getJobSeeker().getId());
//			this.offerRatings.add(new JobOfferRatingDTO(d, suggestion.getJobSeeker())); //position));			
//		}
//	}
//	
//	public JobOfferSuggestionDTO(List<JobOfferSuggestion> suggestions) {
//		for (JobOfferSuggestion jos: suggestions) {
//			this.id = jos.getId();
//			this.date = jos.getDate();
//			this.offerRatings = new ArrayList<>();
//			for (JobOfferRating d : jos.getOfferRatings()) {
//				String position = sortRankings(d.getJobOffer().getRankings(), jos.getJobSeeker().getId());
//				this.offerRatings.add(new JobOfferRatingDTO(d, jos.getJobSeeker())); //position));			
//			}
//		}
//	}
	
//	private String sortRankings(List<JobSeekerRanking> rankings, Long jobSeekerId) {
//		int numOfPeople = rankings.size();
//		if (numOfPeople > 0) {
//			rankings = rankings.stream().sorted((item1, item2) -> Long.compare(item2.getRanking(), item1.getRanking()))
//					.collect(Collectors.toList());
//			for (int i = 0; i < numOfPeople; i++) {
//				if (rankings.get(i).getJobSeeker().getId() == jobSeekerId) {
//					int position = i + 1;
//					return position + "/" + numOfPeople;
//				}
//			}
//		}
//		return "1/1";
//	}
}
