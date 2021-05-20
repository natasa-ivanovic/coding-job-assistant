package ftn.sbnz.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	User findByKey(String key);
	User findByResetKey(String resetKey);
}
