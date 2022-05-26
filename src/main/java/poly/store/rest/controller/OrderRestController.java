package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Movement;
import poly.store.entity.Order;
import poly.store.entity.Product;
import poly.store.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	
	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}
	
	@GetMapping()
	public List<Order> getAll() {
		return orderService.findAll();
	}
	@GetMapping("sort")
	public List<Order> sortDate(){
		return orderService.sortDate();
	}
	
	@GetMapping("{id}")
	public Order getOne(@PathVariable("id")Long id) {
		return orderService.findById(id);
	}


	@PutMapping("{id}")
	public Order put(@PathVariable("id")Long id,@RequestBody Order order) {
		return orderService.update(order);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Long id) {
		orderService.delete(id);
	}
	
}
