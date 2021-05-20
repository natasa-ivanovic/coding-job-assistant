package ftn.sbnz.repository.knowledge;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.knowledge.KnowledgeImportance;

public interface KnowledgeImportanceRepository extends JpaRepository<KnowledgeImportance, Long> {

}
