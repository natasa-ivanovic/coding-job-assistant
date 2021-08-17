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
import ftn.sbnz.repository.cv_element.CVElementRepository;

@Service
@Transactional
public class CVElementService {

	private CVElementRepository repository;

	@Autowired
	public CVElementService(CVElementRepository repository) {
		this.repository = repository;
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

}
