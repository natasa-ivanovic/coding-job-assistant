package ftn.sbnz.repository.language;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.language.Language;
import ftn.sbnz.model.language.LanguageProficiency;

public interface LanguageProficiencyRepository extends JpaRepository<LanguageProficiency, Long> {
	
	LanguageProficiency findOneByLanguageAndProficiency(Language language, SkillProficiency proficiency);

}
