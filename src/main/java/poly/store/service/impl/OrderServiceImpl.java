package poly.store.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import poly.store.dao.OrderDAO;
import poly.store.dao.OrderDetailDAO;
import poly.store.entity.Order;
import poly.store.entity.OrderDetail;
import poly.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO odao;
	
	@Autowired
	OrderDetailDAO oddao;
	
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		odao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		oddao.saveAll(details);
		
		return order;
	}

	@Override
	public Order findById(Long id) {
		return odao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return odao.findByUsername(username);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return odao.findAll();
	}

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return odao.save(order);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		odao.deleteById(id);
		
	}

	@Override
	public List<Order> sortDate() {
		// TODO Auto-generated method stub
		return odao.sortDate();
	}

/* Summary section */
	
	@Override
	public Long getToDayOrder() {
		return odao.getTodayOrder();
	}
	@Override
	public Long totalOrder() {
		return odao.count();
	}
	@Override
	public List<Object[]> getRevenueLast7Days() {
		return odao.getRevenueLast7Days();
	}

//	@Override
//	public List<Order> findAll1() {
//		// TODO Auto-generated method stub
//		return odao.finAll1();
//	}

	




}
