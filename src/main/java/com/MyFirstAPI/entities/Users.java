 package com.MyFirstAPI.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import  jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import  jakarta.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class Users implements Serializable{

	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	
	@OneToMany(mappedBy = "client")
	private List<Orders> orders = new ArrayList<>();

	public Users() {
		
	};
	
	public Users(long id, String name, String cpf) {
		
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	};
	
	
	public void setID(long id){
		
		this.id = id;
		
	};
	
	
public void setName(String name){
		
	this.name = name;
		
		
	};
	

public void setCpf(String cpf){
	
	this.cpf = cpf;
	
};

public long getId() {
	
	return this.id;
};

public String getName() {
	
	return this.name;
};

public String getCpf() {
	
	return this.cpf;
};
	
	
public List<Orders> getOrder(){
	
	return this.orders;
}
	
	
	
};


