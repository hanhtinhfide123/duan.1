package poly.store.service;

import java.util.List;

import poly.store.entity.Strap;

public interface StrapService {

	List<Strap> findAll();

	Strap findById(Integer id);

	Strap create(Strap strap);

	Strap update(Strap strap);

	void delete(Integer id);

}
