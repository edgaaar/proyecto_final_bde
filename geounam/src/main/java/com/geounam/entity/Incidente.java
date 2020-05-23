package com.geounam.entity;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "incidente")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Incidente {

	@Id
	private int id;
	@ManyToOne
	private Municipio municipioResidencia;
	private int tipoPaciente;
	@Basic
	@Temporal(TemporalType.DATE)
	private Calendar fechaIngreso;
	@Basic
	@Temporal(TemporalType.DATE)
	private Calendar fechaSintomas;
	@Basic
	@Temporal(TemporalType.DATE)
	private Calendar fechaDefuncion;
	private int edad;
	private int intubado;
	private int neumonia;
	private int embarazo;
	private int diabetes;
	private int asma;
	private int inmunosupresion;
	private int hipertension;
	private int cardiovascular;
	private int obesidad;
	private int epoc;
	private int renalCronica;
	private int tabaquismo;
	private int resultado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Municipio getMunicipioResidencia() {
		return municipioResidencia;
	}

	public void setMunicipioResidencia(Municipio municipioResidencia) {
		this.municipioResidencia = municipioResidencia;
	}

	public int getTipoPaciente() {
		return tipoPaciente;
	}

	public void setTipoPaciente(int tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Calendar getFechaSintomas() {
		return fechaSintomas;
	}

	public void setFechaSintomas(Calendar fechaSintomas) {
		this.fechaSintomas = fechaSintomas;
	}

	public Calendar getFechaDefuncion() {
		return fechaDefuncion;
	}

	public void setFechaDefuncion(Calendar fechaDefuncion) {
		this.fechaDefuncion = fechaDefuncion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIntubado() {
		return intubado;
	}

	public void setIntubado(int intubado) {
		this.intubado = intubado;
	}

	public int getNeumonia() {
		return neumonia;
	}

	public void setNeumonia(int neumonia) {
		this.neumonia = neumonia;
	}

	public int getEmbarazo() {
		return embarazo;
	}

	public void setEmbarazo(int embarazo) {
		this.embarazo = embarazo;
	}

	public int getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(int diabetes) {
		this.diabetes = diabetes;
	}

	public int getAsma() {
		return asma;
	}

	public void setAsma(int asma) {
		this.asma = asma;
	}

	public int getInmunosupresion() {
		return inmunosupresion;
	}

	public void setInmunosupresion(int inmunosupresion) {
		this.inmunosupresion = inmunosupresion;
	}

	public int getHipertension() {
		return hipertension;
	}

	public void setHipertension(int hipertension) {
		this.hipertension = hipertension;
	}

	public int getCardiovascular() {
		return cardiovascular;
	}

	public void setCardiovascular(int cardiovascular) {
		this.cardiovascular = cardiovascular;
	}

	public int getObesidad() {
		return obesidad;
	}

	public void setObesidad(int obesidad) {
		this.obesidad = obesidad;
	}

	public int getEpoc() {
		return epoc;
	}

	public void setEpoc(int epoc) {
		this.epoc = epoc;
	}

	public int getRenalCronica() {
		return renalCronica;
	}

	public void setRenalCronica(int renalCronica) {
		this.renalCronica = renalCronica;
	}

	public int getTabaquismo() {
		return tabaquismo;
	}

	public void setTabaquismo(int tabaquismo) {
		this.tabaquismo = tabaquismo;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public Incidente(int id, Municipio municipioResidencia, int tipoPaciente, Calendar fechaIngreso,
			Calendar fechaSintomas, Calendar fechaDefuncion, int edad, int intubado, int neumonia, int embarazo,
			int diabetes, int asma, int inmunosupresion, int hipertension, int cardiovascular, int obesidad, int epoc,
			int renalCronica, int tabaquismo, int resultado) {
		this.id = id;
		this.municipioResidencia = municipioResidencia;
		this.tipoPaciente = tipoPaciente;
		this.fechaIngreso = fechaIngreso;
		this.fechaSintomas = fechaSintomas;
		this.fechaDefuncion = fechaDefuncion;
		this.edad = edad;
		this.intubado = intubado;
		this.neumonia = neumonia;
		this.embarazo = embarazo;
		this.diabetes = diabetes;
		this.asma = asma;
		this.inmunosupresion = inmunosupresion;
		this.hipertension = hipertension;
		this.cardiovascular = cardiovascular;
		this.obesidad = obesidad;
		this.epoc = epoc;
		this.renalCronica = renalCronica;
		this.tabaquismo = tabaquismo;
		this.resultado = resultado;
	}

	public Incidente() {}

	@Override
	public String toString() {
		return "Incidente [id=" + id + ", municipioResidencia=" + municipioResidencia + ", tipoPaciente=" + tipoPaciente
				+ ", fechaIngreso=" + fechaIngreso + ", fechaSintomas=" + fechaSintomas + ", fechaDefuncion="
				+ fechaDefuncion + ", edad=" + edad + ", intubado=" + intubado + ", neumonia=" + neumonia
				+ ", embarazo=" + embarazo + ", diabetes=" + diabetes + ", asma=" + asma + ", inmunosupresion="
				+ inmunosupresion + ", hipertension=" + hipertension + ", cardiovascular=" + cardiovascular
				+ ", obesidad=" + obesidad + ", epoc=" + epoc + ", renalCronica=" + renalCronica + ", tabaquismo="
				+ tabaquismo + ", resultado=" + resultado + "]";
	}
	
	
}
