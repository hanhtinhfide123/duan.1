package poly.store.service;

import java.util.List;

import poly.store.entity.Movement;


public interface MovementService {
	
	List<Movement> findAll();

	Movement findById(Integer id);

	Movement create(Movement movement);

	Movement update(Movement movement);

	void delete(Integer id);



}
