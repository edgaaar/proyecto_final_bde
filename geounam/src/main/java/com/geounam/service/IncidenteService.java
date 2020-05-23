package com.geounam.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.locationtech.jts.geom.Polygon;

import com.geounam.entity.Incidente;
import com.geounam.entity.Municipio;

public interface IncidenteService {

	public List<Incidente> findAll();

	public Optional<Incidente> findById(int id);

	public void save(Incidente incidente);

	public void saveAll(Set<Incidente> incidentes);

	public Integer countByMunicipioResidenciaAndResultado(Municipio municipioResidencia, int resultado);

	public List<String> countByCoveredByAndResultado(Polygon polygon, int resultado);

	public Integer countByCoveredByAndDiabetes(Polygon polygon, int diabetes);

	public Integer countByCoveredByAndDefuncion(Polygon polygon);

	public Integer countByCoveredByAndIntubado(Polygon polygon, int intubado);

	public Integer countByCoveredByAndObesidad(Polygon polygon, int obesidad);

	public Integer countByCoveredByAndHipertension(Polygon polygon, int hipertension);

	public Integer countByCoveredByAndInmunosupresion(Polygon polygon, int inmunosupresion);

	public Integer countByCoveredByAndNeumonia(Polygon polygon, int neumonia);

	public Integer countByCoveredByAndTabaquismo(Polygon polygon, int tabaquismo);

}
