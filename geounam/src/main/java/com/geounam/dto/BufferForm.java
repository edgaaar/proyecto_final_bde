package com.geounam.dto;	

public class BufferForm {
	
	private Integer claveEntidad;
	private Integer claveMunicipio;
	private Float tamanioBuffer;

	public BufferForm(Integer claveEntidad, Integer claveMunicipio, Float tamanioBuffer) {
		this.claveEntidad = claveEntidad;
		this.claveMunicipio = claveMunicipio;
		this.tamanioBuffer = tamanioBuffer;
	}

	public BufferForm() {
	}

	@Override
	public String toString() {
		return "BufferForm [claveEntidad=" + claveEntidad + ", claveMunicipio=" + claveMunicipio + ", tamanioBuffer="
				+ tamanioBuffer + "]";
	}

	public Integer getClaveEntidad() {
		return claveEntidad;
	}

	public void setClaveEntidad(Integer claveEntidad) {
		this.claveEntidad = claveEntidad;
	}

	public Integer getClaveMunicipio() {
		return claveMunicipio;
	}

	public void setClaveMunicipio(Integer claveMunicipio) {
		this.claveMunicipio = claveMunicipio;
	}

	public Float getTamanioBuffer() {
		return tamanioBuffer;
	}

	public void setTamanioBuffer(Float tamanioBuffer) {
		this.tamanioBuffer = tamanioBuffer;
	}

}
