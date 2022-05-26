package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.GenderDAO;
import poly.store.entity.Gender;
import poly.store.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService{
	@Autowired
	GenderDAO gdao;

	@Override
	public List<Gender> findAll() {
		// TODO Auto-generated method stub
		return gdao.findAll();
	}

}
