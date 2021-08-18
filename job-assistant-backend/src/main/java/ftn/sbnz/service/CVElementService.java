package ftn.sbnz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.cv_element.CVElementDTO;
import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.repository.cv_element.CVElementProficiencyRepository;
import ftn.sbnz.repository.cv_element.CVElementRepository;

@Service
@Transactional
public class CVElementService {

	private CVElementRepository repository;
	
	private CVElementProficiencyRepository proficiencyRepository;

	@Autowired
	public CVElementService(CVElementRepository repository, CVElementProficiencyRepository proficiencyRepository) {
		this.repository = repository;
		this.proficiencyRepository = proficiencyRepository;
	}

	public Map<String, List<CVElementDTO>> getAllByType() {
		Map<String, List<CVElementDTO>> map = new HashMap<>();
		List<CVElement> elements = this.repository.findAll();
		for (CVElement e : elements) {
			String type = e.getType().toString();
			if (map.containsKey(type)) {
				map.get(type).add(new CVElementDTO(e));
			} else {
				List<CVElementDTO> newList = new ArrayList<>();
				newList.add(new CVElementDTO(e));
				map.put(type, newList);
			}
		}
		return map;
	}

	public CVElementDTO toDTO(CVElement el) {
		return new CVElementDTO(el);
	}
	
	public List<CVElementDTO> getAll() {
		List<CVElement> elements = this.repository.findAll();
		return elements.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public Long create(CVElementDTO dto) throws Exception {
		CVElement check = repository.findOneByName(dto.getName());
		if (check != null)
			throw new Exception("CV Element name is not unique!");
		CVElement element = new CVElement(dto.getName(), dto.getType());
		element = repository.save(element);
		for (SkillProficiency skillProf : SkillProficiency.values()) {
			if (skillProf.equals(SkillProficiency.NONE)) 
				continue;
			CVElementProficiency prof = new CVElementProficiency();
			prof.setCvElement(element);
			prof.setProficiency(skillProf);
			proficiencyRepository.save(prof);
		}
		return element.getId();
	}

	public void edit(CVElementDTO dto, Long id) throws Exception {
		CVElement check = repository.findOneByName(dto.getName());
		if (check != null && check.getId() != id)
			throw new Exception("CV Element name is not unique!");
		CVElement element = repository.getOne(id);
		element.setName(dto.getName());
		element.setType(dto.getType());
		this.repository.save(element);
	}
	
	public void delete(Long id) {
		List<CVElementProficiency> profs = proficiencyRepository.findAllByCvElementId(id);
		for (CVElementProficiency p : profs) {
			this.proficiencyRepository.deleteById(p.getId());
		}
		this.repository.deleteById(id);
	}
	
}
