package com.MyFirstAPI.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyFirstAPI.ExceptionsTratament.ParametroInvalidoException;
import com.MyFirstAPI.entities.Orders;
import com.MyFirstAPI.entities.Users;
import com.MyFirstAPI.services.OrderService;
import com.MyFirstAPI.services.UserService;
import com.MyFirstAPI.status.OrderStatus;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserController userService;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Orders>> findById(@PathVariable Long id) {

		if (id == null) {
			throw new ParametroInvalidoException("parametro nulo");
		}
		;

		return ResponseEntity.ok().body(orderService.findById(id));

	};

	@GetMapping
	public ResponseEntity<List<Orders>> findAll() {

		List<Orders> order = orderService.findAll();

		return ResponseEntity.ok().body(order);
	}
	
	
	@GetMapping(params = "clientId")
	public ResponseEntity<List<Orders>> findByClient_Id(@RequestParam(value = "clientId",required = false) long clientId){
		
		List<Orders> order = orderService.findByClient_Id(clientId);
		
		return ResponseEntity.ok().body(order);
	}
	
	
	@GetMapping(params = "product")
	public ResponseEntity<List<Orders>> findByProduct(@RequestParam(value = "product",required = false) String product){
		
		List<Orders> orders = orderService.findByProduct(product);
		
		return ResponseEntity.ok(orders);
	}

	

	@PostMapping
	public ResponseEntity<Orders> salvarOrder(@RequestBody Orders orderRequest) {

		// Validação do usuario (opcional)

		Optional<Users> client = userService.findByClient(orderRequest.getClient().getId());

		if (client.isEmpty()) {
			// Retornar erro se o usuário não for encontrado
			return ResponseEntity.notFound().build();
		}
		
		String product = orderRequest.getProduct();
		Double valorTotal = orderRequest.getValorTotal();
		Users user = client.get();
		OrderStatus status = orderRequest.getStatus();
		
		
		Orders o1 = new Orders(product,user,valorTotal,status );
		

		orderService.saveOrder(o1);

		return ResponseEntity.created(URI.create("/orders/" + o1.getId())).body(o1);
	}

}
