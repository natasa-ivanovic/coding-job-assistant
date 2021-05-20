package ftn.sbnz.repository.language;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.language.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
