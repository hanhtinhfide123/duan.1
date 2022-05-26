package poly.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import poly.store.dao.OrderDetailDAO;
import poly.store.entity.OrderDetail;
import poly.store.service.OrderDetailService;
import poly.store.util.XDate;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailDAO oddao;
	@Override
	public OrderDetail findById(Long id) {
		// TODO Auto-generated method stub
		return oddao.findById(id).get();
	}
	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return oddao.findAll();
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		oddao.deleteById(id);
	}
	@Override
	public List<OrderDetail> sortByDate() {
		// TODO Auto-generated method stub
		return oddao.sortByDate();
	}
	@Autowired
	XDate xdate;
	@Override
	public Double getTodayIncome() {
		return oddao.findAll().stream().filter(e->e.getOrder().getCreateDate().toString().equals(xdate.convertToPattern(new Date(), "yyyy-MM-dd"))).mapToDouble(item->item.getPrice()*item.getQuantity()).sum();
	}
	@Override
	public Double getTotalIncome() {
		return oddao.findAll().stream().mapToDouble(item->item.getPrice()*item.getQuantity()).sum();
	}
	@Override
	public OrderDetail update(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return oddao.save(orderDetail);
	}


}
