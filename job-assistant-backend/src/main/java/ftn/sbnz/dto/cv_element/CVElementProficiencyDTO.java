package ftn.sbnz.dto.cv_element;

import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.CVElementType;
import ftn.sbnz.model.enums.SkillProficiency;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CVElementProficiencyDTO {
	private Long id;
	private SkillProficiency proficiency;
	private String elementName;
	private CVElementType elementType;

	public CVElementProficiencyDTO(CVElementProficiency el) {
		this.id = el.getId();
		this.proficiency = el.getProficiency();
		this.elementName = el.getCvElement().getName();
		this.elementType = el.getCvElement().getType();
	}
}
