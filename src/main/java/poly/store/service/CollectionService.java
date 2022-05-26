package poly.store.service;

import java.util.List;

import poly.store.entity.Collection;

public interface CollectionService {

	List<Collection> findAll();

	Collection findById(Integer id);

	Collection create(Collection collection);

	Collection update(Collection collection);

	void delete(Integer id);

}
