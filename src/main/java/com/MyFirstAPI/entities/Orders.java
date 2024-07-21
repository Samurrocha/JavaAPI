package com.MyFirstAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tbl_orders")
public class Orders implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "client_Id")
	private Users client;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Id == other.Id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Users getClient() {
		return client;
	}

	public void setClient(Users client) {
		this.client = client;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	public Orders(int id, Instant moment, Users user) {
		
		this.Id = id;
		this.moment = moment;
		this.client = user;
		
	}
	
	
	
	public double total(double a1,double a2) {
		
		return a1+a2;
		
	}

}
