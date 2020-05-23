package com.geounam.service;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

import com.geounam.dao.MunicipioDao;
import com.geounam.entity.Municipio;

@Service
public class MunicipioServiceImpl implements MunicipioService {

	MunicipioDao municipioDao;
	
	@PersistenceContext
    private EntityManager em;
	
	public MunicipioServiceImpl(MunicipioDao municipioDao) {
		this.municipioDao = municipioDao;
	}
	
	@Override
	public List<Municipio> findAll() {
		return (List<Municipio>) municipioDao.findAll();
	}

	@Override
	public void save(Municipio municipio) {
		municipioDao.save(municipio);
	}

	@Override
	public void saveAll(Set<Municipio> municipios) {
		municipioDao.saveAll(municipios);		
	}

	@Override
	public List<Municipio> findByNombre(String nombre) {
		return municipioDao.findByNombre(nombre);
	}

	@Override
	public Municipio findByClaveMunicipioAndClaveEntidad(int claveMunicipio, int claveEntidad) {
		return municipioDao.findByClaveMunicipioAndClaveEntidad(claveMunicipio, claveEntidad);
	}

	@Override
	public List<Municipio> findByClaveEntidad(int claveEntidad) {
		return municipioDao.findByClaveEntidadOrderByNombreAsc(claveEntidad);
	}

	@Override
	public List<Municipio> findByCoveredBy(Polygon polygon) {
		return municipioDao.findByCoveredBy(polygon);
	}
	
	

}
