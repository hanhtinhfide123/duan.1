package poly.store.service;

import java.util.List;


import poly.store.entity.OrderDetail;

public interface OrderDetailService {

	OrderDetail findById(Long id);

	List<OrderDetail> findAll();

	void delete(Long id);

	List<OrderDetail> sortByDate();

	Double getTodayIncome();

	Double getTotalIncome();

	OrderDetail update(OrderDetail orderDetail);



	
}
