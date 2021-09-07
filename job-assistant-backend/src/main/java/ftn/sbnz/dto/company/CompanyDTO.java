package ftn.sbnz.dto.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ftn.sbnz.dto.benefit.BenefitDTO;
import ftn.sbnz.dto.job_offer.JobOfferDTO;
import ftn.sbnz.model.benefit.Benefit;
import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.job_offer.JobOffer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDTO {

	private Long id;
	private String name;
	private MedalRank medal;
	private float rating;
	private int offersNumber;
	private List<BenefitDTO> benefits;
	private List<JobOfferDTO> offers;

	public CompanyDTO(Company c) {
		this.id = c.getId();
		this.name = c.getName();
		this.medal = c.getMedal();
		this.rating = c.getAverageRating();
		this.offersNumber = c.getJobOffers().size();
		this.offers = new ArrayList<>();
		for (JobOffer jo: c.getJobOffers()) {
			this.offers.add(new JobOfferDTO(jo));
		}
		this.benefits = new ArrayList<>();
		Iterator<Benefit> it = c.getBenefits().iterator();
		while (it.hasNext()) {
			this.benefits.add(new BenefitDTO(it.next()));
		}
		

	}

}
