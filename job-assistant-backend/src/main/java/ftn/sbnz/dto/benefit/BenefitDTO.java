package ftn.sbnz.dto.benefit;

import ftn.sbnz.model.benefit.Benefit;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class BenefitDTO {
	
	private Long id;
	private String name;
	private Integer levelImportance;
	private String description;
	
	public BenefitDTO(Benefit b) {
		this.id = b.getId();
		this.name = b.getName();
		this.levelImportance = b.getLevelImportance();
		this.description = b.getDescription();
	}

}
