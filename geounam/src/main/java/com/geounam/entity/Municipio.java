package com.geounam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.geounam.JsonToPointDeserializer;
import com.geounam.PointToJsonSerializer;

@Entity
@Table(name = "municipio")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Municipio {

	@Id
	private Integer id;
	@NotNull
	private String nombre;
	@NotNull
	private Integer claveMunicipio;
	@NotNull
	private Integer claveEntidad;
	@NotNull
	@JsonSerialize(using = PointToJsonSerializer.class)
    @JsonDeserialize(contentUsing = JsonToPointDeserializer.class)
	private Point ubicacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getClaveMunicipio() {
		return claveMunicipio;
	}

	public void setClaveMunicipio(Integer claveMunicipio) {
		this.claveMunicipio = claveMunicipio;
	}

	public Integer getClaveEntidad() {
		return claveEntidad;
	}

	public void setClaveEntidad(Integer claveEntidad) {
		this.claveEntidad = claveEntidad;
	}

	public Point getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Municipio(Integer id, String nombre, Integer claveMunicipio, Integer claveEntidad, Point ubicacion) {
		this.id = id;
		this.nombre = nombre;
		this.claveMunicipio = claveMunicipio;
		this.claveEntidad = claveEntidad;
		this.ubicacion = ubicacion;
	}

	public Municipio() {
	}

	@Override
	public String toString() {
		return "Municipio [id=" + id + ", nombre=" + nombre + ", claveMunicipio=" + claveMunicipio + ", claveEntidad="
				+ claveEntidad + ", ubicacion=" + ubicacion + "]";
	}

}
