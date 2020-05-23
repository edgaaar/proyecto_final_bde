package com.geounam.controller;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geounam.dto.BufferForm;
import com.geounam.dto.ConsultaAreaCircular;
import com.geounam.entity.EntidadFederativa;
import com.geounam.entity.Municipio;
import com.geounam.service.EntidadFederativaService;
import com.geounam.service.IncidenteService;
import com.geounam.service.MunicipioService;

@Controller
@RequestMapping("/")
public class IncidenteController {

	private static final int POSITIVO = 1;
	
	EntidadFederativaService entidadFederativaService;
	MunicipioService municipioService;
	IncidenteService incidenteService;

	@Autowired
	public void IncidenteService(EntidadFederativaService entidadFederativaService, IncidenteService incidenteService,
			MunicipioService municipioService) {
		this.entidadFederativaService = entidadFederativaService;
		this.incidenteService = incidenteService;
		this.municipioService = municipioService;
	}

	@GetMapping
	public String listaIncidentes(Model model) {
		model.addAttribute("entidades", entidadFederativaService.findAll());
		model.addAttribute("bufferForm", new BufferForm());
		return "lista-incidentes";
	}

	@PostMapping(produces = "application/json", consumes = "multipart/form-data")
	public @ResponseBody ConsultaAreaCircular procesaConsulta(Model model, BufferForm bufferForm) {

		Integer claveMunicipio = bufferForm.getClaveMunicipio();
		Integer claveEntidad = bufferForm.getClaveEntidad();
		List<String> cadenaEstadisticas = null;
		String[] estadisticas = new String[2];
		
		Municipio municipioElegido = municipioService.findByClaveMunicipioAndClaveEntidad(claveMunicipio, claveEntidad);
		Point ubicacionMunicipioElegido = municipioElegido.getUbicacion();
		Double bufferAngular = toAngulo(bufferForm.getTamanioBuffer()*1000);
		Polygon zonaConBuffer = (Polygon) ubicacionMunicipioElegido.buffer(bufferAngular);
		
		ConsultaAreaCircular consulta = new ConsultaAreaCircular(municipioElegido.getUbicacion(),
				bufferForm.getTamanioBuffer());
		
		cadenaEstadisticas=incidenteService.countByCoveredByAndResultado(zonaConBuffer, POSITIVO);
		estadisticas = cadenaEstadisticas.get(0).split(",");
		
		Integer numPersonasObesidad = incidenteService.countByCoveredByAndObesidad(zonaConBuffer, POSITIVO);
		Integer numPersonasIntubadas = incidenteService.countByCoveredByAndIntubado(zonaConBuffer, POSITIVO);
		Integer numPersonasHipertension = incidenteService.countByCoveredByAndHipertension(zonaConBuffer, POSITIVO);
		Integer numPersonasInmunosupresion = incidenteService.countByCoveredByAndInmunosupresion(zonaConBuffer, POSITIVO);
		Integer numPersonasNeumonia = incidenteService.countByCoveredByAndNeumonia(zonaConBuffer, POSITIVO);
		Integer numPersonasTabaquismo = incidenteService.countByCoveredByAndTabaquismo(zonaConBuffer, POSITIVO);
		Integer numPersonasFallecidas = incidenteService.countByCoveredByAndDefuncion(zonaConBuffer);
		Integer numPersonasDiabetes = incidenteService.countByCoveredByAndDiabetes(zonaConBuffer, POSITIVO);
		
		consulta.setNumPersonasInfectadas(Integer.parseInt(estadisticas[0]));
		consulta.setPromEdadPersonasInfectadas(Float.parseFloat(estadisticas[1]));
		consulta.setNumPersonasDiabetes(numPersonasDiabetes);
		consulta.setNumPersonasFallecidas(numPersonasFallecidas);
		consulta.setNumPersonasObesidad(numPersonasObesidad);
		consulta.setNumPersonasIntubadas(numPersonasIntubadas);
		consulta.setNumPersonasHipertension(numPersonasHipertension);
		consulta.setNumPersonasInmunosupresion(numPersonasInmunosupresion);
		consulta.setNumPersonasNeumonia(numPersonasNeumonia);
		consulta.setNumPersonasTabaquismo(numPersonasTabaquismo);
		
		return consulta;
	}

	@GetMapping(path = "entidades", produces = "application/json;charset=UTF-8")
	public @ResponseBody List<EntidadFederativa> entidades(Model model) {
		return entidadFederativaService.findAll();
	}

	@GetMapping(path = "municipios/{entidadId}", produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Municipio> municipiosPorEntidad(@PathVariable int entidadId) {
		return municipioService.findByClaveEntidad(entidadId);
	}

	public Double toMetros(Float angulo) {
		return angulo * (Math.PI / 180) * 6378137;
	}

	public Double toAngulo(Float metros) {
		return metros / ((Math.PI / 180) * 6378137);
	}
}
