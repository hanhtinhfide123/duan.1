package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.store.entity.OrderDetail;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

	@Query("SELECT o FROM Order o ORDER BY o.createDate")
	List<OrderDetail> sortByDate();

}
