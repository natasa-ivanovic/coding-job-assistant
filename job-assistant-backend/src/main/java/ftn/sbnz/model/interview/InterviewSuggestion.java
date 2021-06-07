package ftn.sbnz.model.interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ftn.sbnz.model.enums.CVElement;
import ftn.sbnz.model.enums.SkillProficiency;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interview_suggestions")
@Data
@NoArgsConstructor
public class InterviewSuggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "proficiency")
	private SkillProficiency proficiency;
	
	@Column(name = "cv_element")
	private CVElement cvElement;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "description", unique = false, nullable = false)
	private String description;
	
//	@ManyToMany
//	private List<InterviewSuggestionStatus> statuses = new ArrayList<>();

}
