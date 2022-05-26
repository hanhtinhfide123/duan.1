package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.CollectionDAO;
import poly.store.entity.Collection;
import poly.store.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService{
	
	@Autowired
	CollectionDAO cdao;

	@Override
	public List<Collection> findAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

	@Override
	public Collection findById(Integer id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}

	@Override
	public Collection create(Collection collection) {
		// TODO Auto-generated method stub
		return cdao.save(collection);
	}

	@Override
	public Collection update(Collection collection) {
		// TODO Auto-generated method stub
		return cdao.save(collection);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		cdao.deleteById(id);
		
	}
	
	

}
