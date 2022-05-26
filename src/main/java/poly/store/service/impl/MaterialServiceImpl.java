package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.MaterialDAO;
import poly.store.entity.Material;
import poly.store.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService{
	@Autowired
	MaterialDAO mdao;
	@Override
	public List<Material> findAll() {
		// TODO Auto-generated method stub
		return mdao.findAll();
	}
	@Override
	public Material findById(Integer id) {
		// TODO Auto-generated method stub
		return mdao.findById(id).get();
	}
	@Override
	public Material create(Material material) {
		// TODO Auto-generated method stub
		return mdao.save(material);
	}
	@Override
	public Material update(Material material) {
		// TODO Auto-generated method stub
		return mdao.save(material);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		mdao.deleteById(id);
		
	}

}
