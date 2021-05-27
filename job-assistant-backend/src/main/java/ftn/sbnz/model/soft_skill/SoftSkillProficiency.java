package ftn.sbnz.model.soft_skill;

import java.util.HashSet;
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
@Table(name = "soft_skill_proficiencies")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class SoftSkillProficiency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "proficiency", unique = false, nullable = false)
	@NonNull
	private SkillProficiency proficiency;
	
	@ManyToOne
	private SoftSkill softSkill;

	@OneToMany
	private Set<InterviewSuggestion> interviewSuggestions = new HashSet<>();
}
