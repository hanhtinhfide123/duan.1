package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.StrapDAO;
import poly.store.entity.Strap;
import poly.store.service.StrapService;

@Service
public class StrapServiceImpl implements StrapService {
	@Autowired
	StrapDAO sdao;

	@Override
	public List<Strap> findAll() {
		// TODO Auto-generated method stub
		return sdao.findAll();
	}

	@Override
	public Strap findById(Integer id) {
		// TODO Auto-generated method stub
		return sdao.findById(id).get();
	}

	@Override
	public Strap create(Strap strap) {
		// TODO Auto-generated method stub
		return sdao.save(strap);
	}

	@Override
	public Strap update(Strap strap) {
		// TODO Auto-generated method stub
		return sdao.save(strap);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		sdao.deleteById(id);
		
	}

}
