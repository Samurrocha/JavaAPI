package com.MyFirstAPI.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyFirstAPI.ExceptionsTratament.ParametroInvalidoException;
import com.MyFirstAPI.entities.Users;
import com.MyFirstAPI.repositories.UserRepository;
import com.MyFirstAPI.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	
	
	public Optional<Users> findByClient(Long id) {

		if(id == null) {throw new ParametroInvalidoException("parametro nulo");};
		
		
		Optional<Users> u3 = service.findById(id);
		
			return u3;
			
		
			
		};
	
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Users>> findById(@PathVariable Long id) {

		if(id == null) {throw new ParametroInvalidoException("parametro nulo");};
		
			return ResponseEntity.ok().body(service.findById(id));
			
		
			
		};
		
		
		
		
		
		@GetMapping("/nome/{name}")
		public ResponseEntity<List<Users>> findByName (@PathVariable String name){
			
			return ResponseEntity.ok().body(service.findByName(name));
		}
			
		
		
		
		@GetMapping
		public ResponseEntity<List<Users>> findAll(){
			
			List<Users> user = service.findAll();
			
			return ResponseEntity.ok().body(user);
		}
		
		
	
	@PostMapping
	public ResponseEntity<Users> salvarUsuario(@RequestBody Users user) {

	    // Validação do usuario (opcional)

	    service.saveUser(user);

	    return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
	}
	
	
	

	}


