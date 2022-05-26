package poly.store.service;

import java.util.List;

import poly.store.entity.Brand;

public interface BrandService {

	List<Brand> findAll();

	Brand findById(Integer id);

	Brand create(Brand brand);

	Brand update(Brand brand);

	void delete(Integer id);

}
