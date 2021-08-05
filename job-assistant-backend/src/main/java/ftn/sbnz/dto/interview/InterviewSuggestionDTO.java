package ftn.sbnz.dto.interview;

import ftn.sbnz.model.enums.CVElementType;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.interview.InterviewSuggestion;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewSuggestionDTO {
	
	private Long id;
	private boolean checked;
	private SkillProficiency proficiency;
	private CVElementType cvElement;
	private String subject;
	private String url;
	private String description;
	
	public InterviewSuggestionDTO(InterviewSuggestion is) {
		this.id = is.getId();
		this.proficiency = is.getElementProficiency().getProficiency();
		this.cvElement = is.getElementProficiency().getCvElement().getType();
		this.subject = is.getSubject();
		this.url = is.getUrl();
		this.description = is.getDescription();
	}

}
