package com.geounam.dto;

import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.geounam.JsonToPointDeserializer;
import com.geounam.PointToJsonSerializer;

public class ConsultaAreaCircular {

	@JsonSerialize(using = PointToJsonSerializer.class)
    @JsonDeserialize(contentUsing = JsonToPointDeserializer.class)
	private Point centro;
	private Float radio;

	private Integer numPersonasInfectadas;
	private Integer numPersonasFallecidas;
	private Integer numPersonasObesidad;
	private Integer numPersonasDiabetes;
	private Integer numPersonasIntubadas;
	private Integer numPersonasHipertension;
	private Integer numPersonasInmunosupresion;
	private Integer numPersonasNeumonia;
	private Integer numPersonasTabaquismo;

	public Integer getNumPersonasDiabetes() {
		return numPersonasDiabetes;
	}

	public void setNumPersonasDiabetes(Integer numPersonasDiabetes) {
		this.numPersonasDiabetes = numPersonasDiabetes;
	}

	private Float promEdadPersonasInfectadas;
	private Float promEdadPersonasFallecidas;

	public ConsultaAreaCircular() {}
	
	public ConsultaAreaCircular(Point centro, Float radio) {
		this.centro = centro;
		this.radio = radio;
	}

	public Point getCentro() {
		return centro;
	}

	public void setCentro(Point centro) {
		this.centro = centro;
	}

	public Float getRadio() {
		return radio;
	}

	public void setRadio(Float radio) {
		this.radio = radio;
	}

	public Integer getNumPersonasInfectadas() {
		return numPersonasInfectadas;
	}

	public void setNumPersonasInfectadas(Integer numPersonasInfectadas) {
		this.numPersonasInfectadas = numPersonasInfectadas;
	}

	public Integer getNumPersonasFallecidas() {
		return numPersonasFallecidas;
	}

	public void setNumPersonasFallecidas(Integer numPersonasFallecidas) {
		this.numPersonasFallecidas = numPersonasFallecidas;
	}

	public Integer getNumPersonasObesidad() {
		return numPersonasObesidad;
	}

	public void setNumPersonasObesidad(Integer numPersonasObesidad) {
		this.numPersonasObesidad = numPersonasObesidad;
	}

	public Float getPromEdadPersonasInfectadas() {
		return promEdadPersonasInfectadas;
	}

	public void setPromEdadPersonasInfectadas(Float promEdadPersonasInfectadas) {
		this.promEdadPersonasInfectadas = promEdadPersonasInfectadas;
	}

	public Float getPromEdadPersonasFallecidas() {
		return promEdadPersonasFallecidas;
	}

	public void setPromEdadPersonasFallecidas(Float promEdadPersonasFallecidas) {
		this.promEdadPersonasFallecidas = promEdadPersonasFallecidas;
	}

	public Integer getNumPersonasIntubadas() {
		return numPersonasIntubadas;
	}

	public void setNumPersonasIntubadas(Integer numPersonasIntubadas) {
		this.numPersonasIntubadas = numPersonasIntubadas;
	}

	public Integer getNumPersonasHipertension() {
		return numPersonasHipertension;
	}

	public void setNumPersonasHipertension(Integer numPersonasHipertension) {
		this.numPersonasHipertension = numPersonasHipertension;
	}

	public Integer getNumPersonasInmunosupresion() {
		return numPersonasInmunosupresion;
	}

	public void setNumPersonasInmunosupresion(Integer numPersonasInmunosupresion) {
		this.numPersonasInmunosupresion = numPersonasInmunosupresion;
	}

	public Integer getNumPersonasNeumonia() {
		return numPersonasNeumonia;
	}

	public void setNumPersonasNeumonia(Integer numCasosNeumonia) {
		this.numPersonasNeumonia = numCasosNeumonia;
	}

	public Integer getNumPersonasTabaquismo() {
		return numPersonasTabaquismo;
	}

	public void setNumPersonasTabaquismo(Integer numPersonasTabaquismo) {
		this.numPersonasTabaquismo = numPersonasTabaquismo;
	}
}
