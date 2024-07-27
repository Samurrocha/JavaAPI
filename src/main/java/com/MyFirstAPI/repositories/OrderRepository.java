package com.MyFirstAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyFirstAPI.entities.Orders;
import java.util.List;
import com.MyFirstAPI.entities.Users;



@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	List<Orders>findByClient(Users client);
	
	List<Orders> findByProductContainingAllIgnoringCase(String product);

}