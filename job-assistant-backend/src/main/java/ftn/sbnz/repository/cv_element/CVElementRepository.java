package ftn.sbnz.repository.cv_element;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.cv_element.CVElement;

public interface CVElementRepository extends JpaRepository<CVElement, Long> {
	
	public CVElement findOneByName(String name);

}
