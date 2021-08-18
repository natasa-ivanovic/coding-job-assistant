package ftn.sbnz.model.job_offer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.cv_element.CVElementImportance;
import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.model.user.JobSeekerRanking;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "job_offers")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobOffer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "seniority", unique = false, nullable = false)
	@NonNull
	private SeniorityLevel seniority;

	@Column(name = "medal", unique = false, nullable = false)
	@NonNull
	private MedalRank medal;
	
	@Column(name = "datePosted", unique = false, nullable = false)
	@NonNull
	private Date datePosted;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private JobPosition position;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<CVElementImportance> cvElementImportances = new HashSet<>();
	
	@OneToMany
	private List<JobSeekerRanking> rankings = new ArrayList<>();
	
	@OneToMany
	private List<JobOfferStatistic> statistics = new ArrayList<>();
	
	
}
