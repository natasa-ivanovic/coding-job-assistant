package ftn.sbnz.model.programming_language;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.interview.InterviewSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "programming_proficiencies")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProgrammingProficiency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "proficiency", unique = false, nullable = false)
	@NonNull
	private SkillProficiency proficiency;
	
	@ManyToMany
	private Set<JobSeeker> jobSeekers;
	
	@ManyToOne
	private ProgrammingLanguage programmingLanguage;

	@OneToMany
	private Set<InterviewSuggestion> interviewSuggestions;
}
