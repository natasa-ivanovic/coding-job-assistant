package ftn.sbnz.dto.cv_element;

import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.enums.CVElementType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CVElementDTO {
	private Long id;
	private String name;
	private CVElementType type;

	public CVElementDTO(CVElement el) {
		this.id = el.getId();
		this.name = el.getName();
		this.type = el.getType();
	}

}
