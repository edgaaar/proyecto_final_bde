package com.geounam.service;

import java.util.List;
import java.util.Set;

import org.locationtech.jts.geom.Polygon;

import com.geounam.entity.Municipio;

public interface MunicipioService {

	public List<Municipio> findAll();
	
	public void save(Municipio municipio);
	
	public void saveAll(Set<Municipio> municipios);
	
	public List<Municipio> findByNombre(String nombre);
	
	public Municipio findByClaveMunicipioAndClaveEntidad(int claveMunicipio, int claveEntidad);
	
	public List<Municipio> findByClaveEntidad(int claveEntidad);
	
	public List<Municipio> findByCoveredBy(Polygon polygon);
			
}
