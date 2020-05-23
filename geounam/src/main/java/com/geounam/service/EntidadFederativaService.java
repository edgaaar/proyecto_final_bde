package com.geounam.service;

import java.util.List;
import com.geounam.entity.EntidadFederativa;

public interface EntidadFederativaService {

	public List<EntidadFederativa> findAll();
	
	public void save(EntidadFederativa entidadFederativa);
			
}
