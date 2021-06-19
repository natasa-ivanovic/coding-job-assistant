package ftn.sbnz.repository.programming_language;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.programming_language.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
	
	ProgrammingLanguage findOneByName(String name);

}
