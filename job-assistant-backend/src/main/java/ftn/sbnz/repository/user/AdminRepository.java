package ftn.sbnz.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.user.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
