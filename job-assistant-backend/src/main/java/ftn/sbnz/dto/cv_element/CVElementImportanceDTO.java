package ftn.sbnz.dto.cv_element;

import ftn.sbnz.model.cv_element.CVElementImportance;
import ftn.sbnz.model.enums.CVElementType;
import ftn.sbnz.model.enums.SkillProficiency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor	
public class CVElementImportanceDTO {
	
	private String cvElementName;
	private CVElementType cvElementType;
	private SkillProficiency proficiency;
	private boolean optional;
	private int importanceLevel;
	
	public CVElementImportanceDTO(CVElementImportance importance) {
		this.cvElementName = importance.getCvElementProficiency().getCvElement().getName();
		this.cvElementType = importance.getCvElementProficiency().getCvElement().getType();
		this.proficiency = importance.getCvElementProficiency().getProficiency();
		this.optional = importance.isOptional();
		this.importanceLevel = importance.getImportanceLevel();
	}

}
