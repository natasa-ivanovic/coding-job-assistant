package ftn.sbnz.repository.soft_skill;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.soft_skill.SoftSkill;
import ftn.sbnz.model.soft_skill.SoftSkillProficiency;

public interface SoftSkillProficiencyRepository extends JpaRepository<SoftSkillProficiency, Long> {
	
	SoftSkillProficiency findOneBySoftSkillAndProficiency(SoftSkill softSkill, SkillProficiency proficiency);

}
