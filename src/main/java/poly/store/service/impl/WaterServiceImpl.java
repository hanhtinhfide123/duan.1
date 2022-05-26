package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.WaterDAO;
import poly.store.entity.Water;
import poly.store.service.WaterService;

@Service
public class WaterServiceImpl implements WaterService{
	
	@Autowired
	WaterDAO wdao;

	@Override
	public List<Water> findAll() {
		// TODO Auto-generated method stub
		return wdao.findAll();
	}

	@Override
	public Water findById(Integer id) {
		// TODO Auto-generated method stub
		return wdao.findById(id).get();
	}

	@Override
	public Water create(Water water) {
		// TODO Auto-generated method stub
		return wdao.save(water);
	}

	@Override
	public Water update(Water water) {
		// TODO Auto-generated method stub
		return wdao.save(water);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		wdao.deleteById(id);
		
	}

}
