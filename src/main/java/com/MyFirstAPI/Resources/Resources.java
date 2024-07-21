package com.MyFirstAPI.Resources;

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

import com.MyFirst.ExceptionsTratament.ParametroInvalidoException;
import com.MyFirstAPI.UserRepositories.UserRepository;
import com.MyFirstAPI.UserServices.UserService;
import com.MyFirstAPI.entities.Users;

@RestController
@RequestMapping("/users")
public class Resources {

	@Autowired
	private UserService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Users>> findById(@PathVariable Long id) {

		if(id == null) {throw new ParametroInvalidoException("merdaaaaaaaaaaaaa");};
		
			return ResponseEntity.ok().body(service.findById(id));
			
		
			
		};
		
		@GetMapping
		public ResponseEntity<List<Users>> findAll(){
			
			List<Users> user = service.findAll();
			
			return ResponseEntity.ok().body(user);
		}
	
	
	@PostMapping
	public ResponseEntity<Users> salvarUsuario(@RequestBody Users user) {

	    // Validação do usuario (opcional)

	    service.saveteste(user);

	    return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
	}
	
	
	

	}


