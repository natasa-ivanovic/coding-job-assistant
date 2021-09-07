package ftn.sbnz.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.model.company.CompanyReview;

@Transactional
public interface CompanyReviewRepository extends JpaRepository<CompanyReview, Long> {

}
