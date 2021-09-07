package ftn.sbnz.repository.cv_element;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.user.JobSeeker;

public interface CVElementProficiencyRepository extends JpaRepository<CVElementProficiency, Long> {
	
	public CVElementProficiency findOneByCvElementAndProficiency(CVElement cvElement, SkillProficiency proficiency);

	public CVElementProficiency findOneByCvElementNameAndProficiency(String cvElementName,
			SkillProficiency proficiency);

	public List<CVElementProficiency> findAllByCvElementId(Long id);
}
