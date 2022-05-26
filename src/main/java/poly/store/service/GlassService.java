package poly.store.service;

import java.util.List;

import poly.store.entity.Glass;

public interface GlassService {

	List<Glass> findAll();

	Glass findById(Integer id);

	Glass create(Glass glass);

	Glass update(Glass glass);

	void delete(Integer id);

}
