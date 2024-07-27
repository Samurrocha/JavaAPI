package com.MyFirstAPI.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import com.MyFirstAPI.status.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@CreationTimestamp
	private LocalDateTime moment;
	
	private Double valorTotal;
	private String product;
	@Column
	private Integer status;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "client_Id")
	private Users client;

	@JsonProperty(value = "client_Id")
	public long getClientId() {
		
		return client != null ? client.getId() : null;
	}
	
	@JsonProperty(value = "moment")
	public LocalDateTime getMoment() {
		return this.moment;
	}
	
	
	Orders() {

	}

	public Orders(String product, Users user, Double valorTotal, OrderStatus status) {

		this.valorTotal = valorTotal != null ? valorTotal : 0.0;
		this.setProduct(product);
		this.client = user;
		setStatus(status);

	}

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


	public Users getClient() {
		return client;
	}

	public void setClient(Users client) {
		this.client = client;
	}


	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public OrderStatus getStatus() {
		return OrderStatus.valueOf(status);
	}

	public void setStatus(OrderStatus status) {
		
		this.status = status.getCode() == null ? 0 : status.getCode();
		
	}

}
