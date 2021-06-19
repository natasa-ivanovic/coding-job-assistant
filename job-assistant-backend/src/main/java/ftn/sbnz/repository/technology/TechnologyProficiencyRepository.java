package ftn.sbnz.repository.technology;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.technology.Technology;
import ftn.sbnz.model.technology.TechnologyProficiency;

public interface TechnologyProficiencyRepository extends JpaRepository<TechnologyProficiency, Long> {
	
	TechnologyProficiency findOneByTechnologyAndProficiency(Technology technology, SkillProficiency proficiency);
}
