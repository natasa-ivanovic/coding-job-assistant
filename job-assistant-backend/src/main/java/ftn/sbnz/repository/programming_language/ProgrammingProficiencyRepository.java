package ftn.sbnz.repository.programming_language;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.programming_language.ProgrammingLanguage;
import ftn.sbnz.model.programming_language.ProgrammingProficiency;

public interface ProgrammingProficiencyRepository extends JpaRepository<ProgrammingProficiency, Long> {
	
	ProgrammingProficiency findOneByProgrammingLanguageAndProficiency(ProgrammingLanguage programmingLanguage, SkillProficiency proficiency);
}
