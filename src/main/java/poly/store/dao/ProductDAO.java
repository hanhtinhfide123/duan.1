package poly.store.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.store.entity.Product;




public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String cid);
	
	@Query("Select p From Product p Where p.brand.id=?1")
	Page<Product> findByBrandId(Integer cid,Pageable pageable);
	
	@Query("SELECT p FROM Product p ORDER BY p.name")
	List<Product> sortByName();
	
	@Query("SELECT p FROM Product p ORDER BY p.price ASC")
	List<Product> sortByPriceDESC();
	
	@Query("SELECT p FROM Product p ORDER BY p.price DESC")
	List<Product> sortByPriceASC();

	/*Summary*/
	@Query("Select Count(p) from Product p where p.available = true")
	Long getAvailable();

	@Query(value="Select c.name, ISNULL(sum(odt.Quantity),0) from Categories c  "
			+ "inner join Products p on c.Id = p.CategoryId "
			+ "inner join OrderDetails odt on p.Id = odt.ProductId "
			+ "inner join Orders o on odt.OrderId = o.Id "
			+ "Where cast(o.CreateDate as date) >= DateAdd(day,-365,cast(getdate() as date)) "
			+ "group by c.name",nativeQuery = true)
	List<Object[]> numberOfProductSoldByType();

	@Query(value="Select c.name, ISNULL(sum(odt.Quantity),0) from Categories c  "
			+ "inner join Products p on c.Id = p.CategoryId "
			+ "inner join OrderDetails odt on p.Id = odt.ProductId "
			+ "inner join Orders o on odt.OrderId = o.Id "
			+ "group by c.name",nativeQuery = true)
	List<Object[]> getPercentByCate();
	@Query(value = "with table1 as ( "
			+ "	Select c.name as catename,  "
			+ "	count(p.Available) as available "
			+ "	from Categories c "
			+ "	inner join Products p on c.Id = p.CategoryId "
			+ "	where p.Available = 1 "
			+ "	group by c.Name "
			+ "), "
			+ "table2 as ( "
			+ "	Select c.name as catename,  "
			+ "	count(p.Available) as unavailable "
			+ "	from Categories c "
			+ "	inner join Products p on c.Id = p.CategoryId "
			+ "	where p.Available = 0 "
			+ "	group by c.Name "
			+ ") "
			+ "Select t1.catename,t1.available,t2.unavailable  "
			+ "from table1 t1 inner join table2 t2 on t1.catename = t2.catename", nativeQuery = true)
	List<Object[]> availableRate();

	@Query(value="Select top 10 p.Name, count(odt.productid) as mostSold "
			+ "From OrderDetails odt inner join Products p  "
			+ "on odt.ProductId = p.Id "
			+ "group by p.Name "
			+ "Order by mostSold desc",nativeQuery = true)
	List<Object[]> top10Product();
	
	@Query("SELECT p FROM Product p where p.gender.id=1")
	List<Product> male();
	@Query("SELECT p FROM Product p where p.gender.id=2")
	List<Product> female();

	@Query("SELECT p FROM Product p WHERE p.brand.id=?1")
	List<Product> findByBrandId(Integer cid);

	@Query("SELECT p FROM Product p WHERE p.collection.id=?1")
	List<Product> findByCollectionId(Integer cid);

	@Query("SELECT p FROM Product p WHERE p.name like %?1%"			)
	List<Product> findByKeyword(String keyword);

	

}
