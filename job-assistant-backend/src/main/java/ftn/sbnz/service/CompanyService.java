package ftn.sbnz.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.company.CompanyDTO;
import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.repository.company.CompanyRepository;

@Service
@Transactional
public class CompanyService {

	private CompanyRepository repository;
	private KieSessionService kieSession;

	@Autowired
	public CompanyService(CompanyRepository repository, KieSessionService kieSession) {
		this.repository = repository;
		this.kieSession = kieSession;
	}

	public void save(Company c) {
		this.repository.save(c);
	}
	
	public Company getOne(Long companyId) {
		return this.repository.getOne(companyId);
	}

	private CompanyDTO toDTO(Company c) {
		return new CompanyDTO(c);
	}
	
	public List<CompanyDTO> getAll() {
		return this.repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public Long create(CompanyDTO dto) throws Exception {
		Company check = repository.findOneByName(dto.getName());
		if (check != null)
			throw new Exception("Company name is not unique!");
		Company c = new Company(dto.getName(), MedalRank.NONE);
		c = this.repository.save(c);
		this.kieSession.insert(c);
		return c.getId();
	}

	public void edit(CompanyDTO dto, Long id) throws Exception {
		Company check = repository.findOneByName(dto.getName());
		if (check != null && check.getId() != id)
			throw new Exception("Company name is not unique!");
		Company c = this.repository.getOne(id);
		c.setName(dto.getName());
		this.kieSession.removeCompanyById(c.getId());
		this.kieSession.insert(c);
		this.repository.save(c);
	}

	public void delete(Long id) throws Exception {
		Company c = this.repository.getOne(id);
		if (c.getJobOffers().size() != 0)
			throw new Exception("Company has job offers!");
		for (CompanyReview review : c.getCompanyReviews()) {
			this.kieSession.removeCompanyReviewById(review.getId());			
		}
		this.repository.deleteById(id);
		this.kieSession.removeCompanyById(id);
	}
	
	public CompanyDTO getOneCompany(Long id) {
		Company company = getOne(id);
		CompanyDTO dto = new CompanyDTO(company);
		return dto;
	}

	public Company updateDBFromRule(Company companyDb) {
		Collection<Object> companies = kieSession.getObjectsFromSession(Company.class);
		for (Iterator<Object> it = companies.iterator(); it.hasNext();) {
			Company c = (Company) it.next();
			if (companyDb.getId() == c.getId()) {
				if (!companyDb.getMedal().equals(c.getMedal())) {
					companyDb.setMedal(c.getMedal());;
					this.save(c);
					return c;
				}
				return null;
			}
		}
		return null;
	}

	
}
