package ftn.sbnz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "job_seeker_ranking")
@Data
public class JobSeekerRanking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ranking", unique = false, nullable = false)
	private int ranking;
	
	@ManyToOne
	private JobSeeker jobSeeker;
	
	@ManyToOne
	private JobOffer jobOffer;
}
