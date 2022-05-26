package poly.store.service;

import java.util.List;

import poly.store.entity.Water;

public interface WaterService {

	List<Water> findAll();

	Water findById(Integer id);

	Water create(Water water);

	Water update(Water water);

	void delete(Integer id);

}
