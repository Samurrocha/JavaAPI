package com.MyFirstAPI.UserServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.MyFirstAPI.UserRepositories.UserRepository;
import com.MyFirstAPI.entities.Users;


@Service
public class UserService {
	
	@Autowired
    private UserRepository repository;

	@GetMapping
    public List<Users> findAll() {
        return repository.findAll();
    }
	
    public void saveteste(Users user) {
    	
    	repository.save(user);
    }
    
    public Optional<Users> findById(Long id) {
    	Optional<Users> user = repository.findById(id);
    	
    	return user;
    }
}

