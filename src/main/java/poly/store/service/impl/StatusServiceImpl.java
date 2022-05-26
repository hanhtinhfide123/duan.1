package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.StatusDAO;
import poly.store.entity.Status;
import poly.store.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	StatusDAO sdao;

	@Override
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return sdao.findAll();
	}

}
