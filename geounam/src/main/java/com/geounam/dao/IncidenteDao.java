package com.geounam.dao;

import java.util.List;

import org.locationtech.jts.geom.Polygon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.geounam.entity.Incidente;
import com.geounam.entity.Municipio;

public interface IncidenteDao extends CrudRepository<Incidente, Integer> {

	public Integer countByMunicipioResidenciaAndResultado(Municipio municipio, int resultado);

	@Query(value = "SELECT to_char(count(*)) || ',' || "
			+ "to_char(avg(i.edad))"
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.resultado=:res")
	public List<String> countByCoveredByAndResultado(@Param("geom") Polygon polygon,
			@Param("res") int resultado);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.diabetes=:dia")
	public Integer countByCoveredByAndDiabetes(@Param("geom") Polygon polygon,
			@Param("dia") int diabetes);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.fechaDefuncion is not null")
	public Integer countByCoveredByAndDefuncion(@Param("geom") Polygon polygon);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.intubado=:intubado")
	public Integer countByCoveredByAndIntubado(@Param("geom") Polygon polygon, int intubado);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.obesidad = :obesidad")
	public Integer countByCoveredByAndObesidad(@Param("geom") Polygon polygon, int obesidad);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.hipertension = :hipertension")
	public Integer countByCoveredByAndHipertension(@Param("geom") Polygon polygon, int hipertension);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.inmunosupresion = :inmunosupresion")
	public Integer countByCoveredByAndInmunosupresion(@Param("geom") Polygon polygon, int inmunosupresion);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.neumonia = :neumonia")
	public Integer countByCoveredByAndNeumonia(@Param("geom") Polygon polygon, int neumonia);
	
	@Query(value = "SELECT count(*) "
			+ "FROM Incidente i "
			+ "WHERE i.municipioResidencia IN ("
			+ "SELECT mun FROM Municipio mun "
			+ "WHERE sdo_filter(ubicacion,:geom)='TRUE')"
			+ "AND i.tabaquismo = :tabaquismo")
	public Integer countByCoveredByAndTabaquismo(@Param("geom") Polygon polygon, int tabaquismo);
	
	
}
