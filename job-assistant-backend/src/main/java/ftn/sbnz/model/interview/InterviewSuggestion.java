package ftn.sbnz.model.interview;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.cv_element.CVElementProficiency;
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
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "description", unique = false, nullable = false)
	private String description;
	
	@OneToMany
	private List<InterviewSuggestionStatus> statuses;
	
	@ManyToOne
	private CVElementProficiency cvElementProficiency;
	
}
