package poly.store.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.store.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);
	
	Page<Product> findAll(Pageable pageable);
	
	Page<Product> findByBrandId(Integer cid,Pageable pageable);

	Product create(Product p);

	Product update(Product p);

	void delete(Integer id);

	List<Product> sortByName();

	List<Product> sortByPriceASC();

	List<Product> sortByPriceDESC();

	Long getAvailable();

	Long getTotalProduct();

	List<Object[]> numberOfProductSoldByType();

	List<Object[]> getPercentByCate();

	List<Object[]> availableRate();

	List<Object[]> top10Product();

	List<Product> male();

	List<Product> female();

	List<Product> findByBrandId(Integer integer);

	List<Product> findByCollectionId(Integer integer);

	List<Product> findByKeyword(String keyword);
	
	Page<Product> findPaginated(int pageNo, int pageSize);
	
	









}
