package com.MyFirstAPI.MyFirstAPI.users;

public class Users {

	private int id;
	private String name;
	private String cpf;

	
	public Users(int id, String name, String cpf) {
		
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	};
	
	
	public void setID(int id){
		
		this.id = id;
		
	};
	
	
public void setName(String name){
		
	this.name = name;
		
		
	};
	

public void setCpf(String name){
	
	this.name = name;
	
};

public int getId() {
	
	return this.id;
};

public String getName() {
	
	return this.name;
};

public String getCpf() {
	
	return this.cpf;
};
	
	
	
	
	
};


