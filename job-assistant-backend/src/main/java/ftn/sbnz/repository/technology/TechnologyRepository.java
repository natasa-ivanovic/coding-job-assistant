package ftn.sbnz.repository.technology;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.technology.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
	
	Technology findOneByName(String name);

}
