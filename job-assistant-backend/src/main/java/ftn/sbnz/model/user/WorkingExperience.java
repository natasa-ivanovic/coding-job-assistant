package ftn.sbnz.model.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.sbnz.dto.user.WorkingExperienceDTO;
import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.job_position.JobPosition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "working_experiences")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class WorkingExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "months", unique = false, nullable = false)
	private int months;
	
	@Column(name = "seniority", unique = false, nullable = false)
	@NonNull
	private SeniorityLevel seniority;
		
	@ManyToMany
	private List<CVElement> cvElements;
		
	@ManyToOne
	private JobPosition position;
	
	public WorkingExperience(WorkingExperienceDTO el, List<CVElement> cvElements, JobPosition position) {
		this.months = el.getMonths();
		this.seniority = el.getSeniority();
		this.cvElements = cvElements;
		this.position = position;
	}
}
