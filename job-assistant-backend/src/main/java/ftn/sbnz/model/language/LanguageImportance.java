package ftn.sbnz.model.language;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "language_importances")
@Data
@RequiredArgsConstructor
public class LanguageImportance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "importance", unique = false, nullable = false)
	private int importance;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "language_proficiency_id", nullable = false, unique = false) 
	private LanguageProficiency languageProficiency;
}
