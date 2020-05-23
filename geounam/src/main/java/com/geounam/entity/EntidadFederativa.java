package com.geounam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entidad_federativa")
public class EntidadFederativa {

	@Id
	private Integer claveEntidad;
	private String nombreEntidad;
	
	
	public Integer getClaveEntidad() {
		return claveEntidad;
	}

	public void setClaveEntidad(Integer claveEntidad) {
		this.claveEntidad = claveEntidad;
	}

	public String getNombreEntidad() {
		return nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}

	public EntidadFederativa(Integer entidadFederativaId, String nombre) {
		this.claveEntidad = entidadFederativaId;
		this.nombreEntidad = nombre;
	}

	public EntidadFederativa() {}
	@Override
	public String toString() {
		return "EntidadFederativa [entidadFederativaId=" + claveEntidad + ", nombre=" + nombreEntidad + "]";
	}
}
