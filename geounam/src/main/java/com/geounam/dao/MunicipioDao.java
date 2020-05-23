package com.geounam.dao;

import java.util.List;

import org.locationtech.jts.geom.Polygon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.geounam.entity.Municipio;

public interface MunicipioDao extends CrudRepository<Municipio, Integer> {

	public List<Municipio> findByNombre(String nombre);

	public Municipio findByClaveMunicipioAndClaveEntidad(int claveMunicipio, int claveEntidad);
	
	public List<Municipio> findByClaveEntidadOrderByNombreAsc(int claveEntidad);
	
	@Query(value = "SELECT mun FROM Municipio mun WHERE sdo_filter(ubicacion,:geom)='TRUE'")
	public List<Municipio> findByCoveredBy(@Param("geom") Polygon polygon);
}
