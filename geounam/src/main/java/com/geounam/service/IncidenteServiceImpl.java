package com.geounam.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geounam.dao.IncidenteDao;
import com.geounam.entity.Incidente;
import com.geounam.entity.Municipio;

@Service
public class IncidenteServiceImpl implements IncidenteService {

	@Autowired
	IncidenteDao incidenteDao;

	@Override
	public List<Incidente> findAll() {
		return (List<Incidente>) incidenteDao.findAll();
	}

	@Override
	public void save(Incidente incidente) {
		incidenteDao.save(incidente);
	}

	@Override
	public void saveAll(Set<Incidente> incidentes) {
		incidenteDao.saveAll(incidentes);
	}

	@Override
	public Optional<Incidente> findById(int id) {
		return incidenteDao.findById(id);
	}

	@Override
	public Integer countByMunicipioResidenciaAndResultado(Municipio municipioResidencia, int resultado) {
		return incidenteDao.countByMunicipioResidenciaAndResultado(municipioResidencia, resultado);
	}

	@Override
	public List<String> countByCoveredByAndResultado(Polygon polygon, int resultado) {
		return incidenteDao.countByCoveredByAndResultado(polygon, resultado);
	}

	@Override
	public Integer countByCoveredByAndDiabetes(Polygon polygon, int diabetes) {
		return incidenteDao.countByCoveredByAndDiabetes(polygon, diabetes);
	}

	@Override
	public Integer countByCoveredByAndDefuncion(Polygon polygon) {
		return incidenteDao.countByCoveredByAndDefuncion(polygon);
	}

	@Override
	public Integer countByCoveredByAndIntubado(Polygon polygon, int intubado) {
		return incidenteDao.countByCoveredByAndIntubado(polygon, intubado);
	}

	@Override
	public Integer countByCoveredByAndObesidad(Polygon polygon, int obesidad) {
		return incidenteDao.countByCoveredByAndObesidad(polygon, obesidad);
	}

	@Override
	public Integer countByCoveredByAndHipertension(Polygon polygon, int hipertension) {
		return incidenteDao.countByCoveredByAndHipertension(polygon, hipertension);
	}

	@Override
	public Integer countByCoveredByAndInmunosupresion(Polygon polygon, int inmunosupresion) {
		return incidenteDao.countByCoveredByAndInmunosupresion(polygon, inmunosupresion);
	}

	@Override
	public Integer countByCoveredByAndNeumonia(Polygon polygon, int neumonia) {
		return incidenteDao.countByCoveredByAndNeumonia(polygon, neumonia);
	}

	@Override
	public Integer countByCoveredByAndTabaquismo(Polygon polygon, int tabaquismo) {
		return incidenteDao.countByCoveredByAndTabaquismo(polygon, tabaquismo);
	}

}
