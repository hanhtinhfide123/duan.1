package poly.store.service;

import java.util.List;

import poly.store.entity.Material;

public interface MaterialService {

	List<Material> findAll();

	Material findById(Integer id);

	Material create(Material material);

	Material update(Material material);

	void delete(Integer id);


}
