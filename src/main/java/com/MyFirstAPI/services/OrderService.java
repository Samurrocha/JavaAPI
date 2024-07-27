package com.MyFirstAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyFirstAPI.entities.Orders;
import com.MyFirstAPI.entities.Users;
import com.MyFirstAPI.repositories.OrderRepository;
import com.MyFirstAPI.repositories.UserRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;

	
	public List<Orders> findAll() {
		return orderRepository.findAll();
	}

	public void saveOrder(Orders order) {

		orderRepository.save(order);
	}

	public Optional<Orders> findById(Long id) {
		Optional<Orders> order = orderRepository.findById(id);

		return order;
	}
	
	
	public List<Orders> findByClient_Id(long clientId){
		
		Optional<Users> user = userRepository.findById(clientId);
		
		Users client = user.get();
		
		List<Orders> order = orderRepository.findByClient(client);
		
	
		
		return order;
	}
	
	
	
public List<Orders> findByProduct(String product){
    	
    	List<Orders> order = orderRepository.findByProductContainingAllIgnoringCase(product);
    	
    	return order;
    }
	
	
	
	
}
