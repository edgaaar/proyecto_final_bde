package com.geounam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geounam.dao.EntidadFederativaDao;
import com.geounam.entity.EntidadFederativa;

@Service
public class EntidadFederativaServiceImpl implements EntidadFederativaService {
	
	EntidadFederativaDao entidadFederativaDao;

	@Autowired
	public EntidadFederativaServiceImpl(EntidadFederativaDao entidadFederativaDao) {
		this.entidadFederativaDao = entidadFederativaDao;
	}

	@Override
	public List<EntidadFederativa> findAll() {
		return (List<EntidadFederativa>) entidadFederativaDao.findAll();
	}

	@Override
	public void save(EntidadFederativa entidadFederativa) {
		entidadFederativaDao.save(entidadFederativa);
	}

}
