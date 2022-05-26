package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.MovementDAO;
import poly.store.entity.Movement;
import poly.store.service.MovementService;


@Service
public class MovementServiceImpl implements MovementService{
	
	@Autowired
	MovementDAO mdao;

	@Override
	public List<Movement> findAll() {
		// TODO Auto-generated method stub
		return mdao.findAll();
	}

	@Override
	public Movement findById(Integer id) {
		// TODO Auto-generated method stub
		return mdao.findById(id).get();
	}

	@Override
	public Movement create(Movement movement) {
		// TODO Auto-generated method stub
		return mdao.save(movement);
	}

	@Override
	public Movement update(Movement movement) {
		// TODO Auto-generated method stub
		return mdao.save(movement);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 mdao.deleteById(id);
	}

	
	
	
	

}
