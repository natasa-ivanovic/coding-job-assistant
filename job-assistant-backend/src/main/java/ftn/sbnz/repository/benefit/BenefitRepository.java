package ftn.sbnz.repository.benefit;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.benefit.Benefit;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {

}
