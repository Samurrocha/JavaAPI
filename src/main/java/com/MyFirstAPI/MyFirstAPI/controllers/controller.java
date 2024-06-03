package com.MyFirstAPI.MyFirstAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyFirstAPI.MyFirstAPI.users.Users;

import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/users")

public class controller {
	
	public String daoi = "dfdfdf";
			
	@GetMapping
	
	public ResponseEntity<Users> Teste(){
		
			
		Users u = new Users(1,"sad","454435");
		
		return ResponseEntity.ok().body(u);
		
	}
	
    }
	


