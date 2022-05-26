package poly.store.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

	List<Order> findAll();

	Order update(Order order);


	void delete(Long id);

	List<Order> sortDate();

	Long getToDayOrder();

	Long totalOrder();

	List<Object[]> getRevenueLast7Days();

//	List<Order> findAll1();








}
