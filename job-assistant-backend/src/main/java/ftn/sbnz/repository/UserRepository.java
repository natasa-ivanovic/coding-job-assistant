package ftn.sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	User findByKey(String key);
	User findByResetKey(String resetKey);
}
