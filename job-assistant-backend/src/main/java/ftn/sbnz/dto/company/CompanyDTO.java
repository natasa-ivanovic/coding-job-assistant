package ftn.sbnz.dto.company;

import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.enums.MedalRank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDTO {
	private Long id;
	private String name;
	private MedalRank medal;
	private float rating;
	
	public CompanyDTO(Company c) {
		this.id = c.getId();
		this.name = c.getName();
		this.medal = c.getMedal();
		this.rating = c.getAverageRating();
	}

}
