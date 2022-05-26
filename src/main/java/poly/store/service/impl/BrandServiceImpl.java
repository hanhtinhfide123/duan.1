package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.BrandDAO;
import poly.store.entity.Brand;
import poly.store.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	BrandDAO bdao;

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return bdao.findAll();
	}

	@Override
	public Brand findById(Integer id) {
		// TODO Auto-generated method stub
		return bdao.findById(id).get();
	}

	@Override
	public Brand create(Brand brand) {
		// TODO Auto-generated method stub
		return bdao.save(brand);
	}

	@Override
	public Brand update(Brand brand) {
		// TODO Auto-generated method stub
		return bdao.save(brand);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		bdao.deleteById(id);
		
	}

}
