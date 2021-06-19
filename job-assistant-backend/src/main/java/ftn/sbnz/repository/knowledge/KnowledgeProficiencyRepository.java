package ftn.sbnz.repository.knowledge;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.knowledge.Knowledge;
import ftn.sbnz.model.knowledge.KnowledgeProficiency;

public interface KnowledgeProficiencyRepository extends JpaRepository<KnowledgeProficiency, Long> {
	
	KnowledgeProficiency findOneByKnowledgeAndProficiency(Knowledge knowledge, SkillProficiency proficiency);
}
