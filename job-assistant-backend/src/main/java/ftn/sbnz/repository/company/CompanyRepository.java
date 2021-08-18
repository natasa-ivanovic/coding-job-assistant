package ftn.sbnz.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.company.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	Company findOneByName(String name);

}
