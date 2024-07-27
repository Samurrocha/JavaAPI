package com.MyFirstAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.MyFirstAPI.entities.Users;
import com.MyFirstAPI.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
    private UserRepository repository;

	
    public List<Users> findAll() {
        return repository.findAll();
    }
	
    public void saveUser(Users user) {
    	
    	repository.save(user);
    }
    
    public Optional<Users> findById(Long id) {
    	Optional<Users> user = repository.findById(id);
    	
    	return user;
    }
    
    public List<Users> findByName(String name){
    	
    	List<Users> user = repository.findByNameContainingAllIgnoreCase(name);
    	
    	return user;
    }
    
    
}

