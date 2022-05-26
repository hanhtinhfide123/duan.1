package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.GlassDAO;
import poly.store.entity.Glass;
import poly.store.service.GlassService;

@Service
public class GlassServiceImpl implements GlassService{
	
	@Autowired
	GlassDAO gdao;

	@Override
	public List<Glass> findAll() {
		// TODO Auto-generated method stub
		return gdao.findAll();
	}

	@Override
	public Glass findById(Integer id) {
		// TODO Auto-generated method stub
		return gdao.findById(id).get();
	}

	@Override
	public Glass create(Glass glass) {
		// TODO Auto-generated method stub
		return gdao.save(glass);
	}

	@Override
	public Glass update(Glass glass) {
		// TODO Auto-generated method stub
		return gdao.save(glass);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		gdao.deleteById(id);
		
	}

}
