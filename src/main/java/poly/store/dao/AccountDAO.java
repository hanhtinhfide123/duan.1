package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.store.entity.Account;




public interface AccountDAO extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();
	@Query(value="Select a.Username, a.Fullname, a.email, a.photo, "
			+ "sum(odt.price * odt.quantity) as totalPayment "
			+ "From Accounts a inner join orders o on a.Username = o.Username "
			+ "inner join OrderDetails odt on o.Id = odt.OrderId "
			+ "Group by a.Username, a.Fullname, a.email, a.photo "
			+ "order by totalPayment desc",nativeQuery = true)
	List<Object[]> top10Customer();
}
