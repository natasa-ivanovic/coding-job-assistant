package ftn.sbnz.repository.knowledge;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.knowledge.Knowledge;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {

}
