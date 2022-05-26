package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.store.dao.ProductDAO;
import poly.store.entity.Product;
import poly.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		return pdao.findByCategoryId(cid);
	}

	@Override
	public Product create(Product p) {
		return pdao.save(p);
	}

	@Override
	public Product update(Product p) {
		return pdao.save(p);
	}

	@Override
	public void delete(Integer id) {
		pdao.deleteById(id);
	}

	@Override
	public List<Product> sortByName() {
		
		return pdao.sortByName();
	}

	@Override
	public List<Product> sortByPriceASC() {
		// TODO Auto-generated method stub
		return pdao.sortByPriceASC();
	}

	@Override
	public List<Product> sortByPriceDESC() {
		// TODO Auto-generated method stub
		return pdao.sortByPriceDESC();
	}

	/* Summary Section */
	@Override
	public Long getAvailable() {
		return pdao.getAvailable();
	}

	@Override
	public Long getTotalProduct() {
		return pdao.count();
	}

	@Override
	public List<Object[]> numberOfProductSoldByType() {
		return pdao.numberOfProductSoldByType();
	}

	@Override
	public List<Object[]> getPercentByCate() {
		return pdao.getPercentByCate();
	}

	@Override
	public List<Object[]> availableRate() {
		return pdao.availableRate();
	}

	@Override
	public List<Object[]> top10Product() {
		return pdao.top10Product();
	}

	@Override
	public List<Product> male() {
		// TODO Auto-generated method stub
		return pdao.male();
	}

	@Override
	public List<Product> female() {
		// TODO Auto-generated method stub
		return pdao.female();
	}

	@Override
	public List<Product> findByBrandId(Integer cid) {
		// TODO Auto-generated method stub
		return pdao.findByBrandId(cid);
	}

	@Override
	public List<Product> findByCollectionId(Integer cid) {
		// TODO Auto-generated method stub
		return pdao.findByCollectionId(cid);
	}

	@Override
	public List<Product> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return pdao.findByKeyword(keyword);
	}

	@Override
	public Page<Product> findByBrandId(Integer cid, Pageable pageable) {
		// TODO Auto-generated method stub
		return pdao.findByBrandId(cid, pageable);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return pdao.findAll(pageable);
	}

	@Override
	public Page<Product> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return pdao.findAll(pageable);
	}



	
}
