package ftn.sbnz.repository.auth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.auth.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findByName(String name);
	List<Authority> findAll();

}
