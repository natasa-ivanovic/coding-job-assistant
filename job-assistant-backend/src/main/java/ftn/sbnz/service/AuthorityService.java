package ftn.sbnz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.model.auth.Authority;
import ftn.sbnz.repository.auth.AuthorityRepository;

@Service
@Transactional
public class AuthorityService {

    private AuthorityRepository authRepository;

    @Autowired
    public AuthorityService(AuthorityRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Authority findOne(long id) {
        return authRepository.getOne(id);
    }

    public Authority findByName(String name) {
        return authRepository.findByName(name);
    }
    
    public Authority create(String name) {
    	Authority role = new Authority(name);
    	return authRepository.save(role);
    }
}
