package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxPlantillaSolucion implements IsSerializable {

	private Long idPlantillaSolucion;

	private String nomPlantillaSolucion;
	
	private String tipo;

	private Date fechaCreacion;

	private Double costoFinal;
	
	private List<AuxDetallePlantillaSolucion> listaDetalle;

	
	public AuxPlantillaSolucion(){
		listaDetalle = new ArrayList<AuxDetallePlantillaSolucion>();
	}
	
	public Long getIdPlantillaSolucion() {
		return idPlantillaSolucion;
	}

	public void setIdPlantillaSolucion(Long idPlantillaSolucion) {
		this.idPlantillaSolucion = idPlantillaSolucion;
	}

	public String getNomPlantillaSolucion() {
		return nomPlantillaSolucion;
	}

	public void setNomPlantillaSolucion(String nomPlantillaSolucion) {
		this.nomPlantillaSolucion = nomPlantillaSolucion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<AuxDetallePlantillaSolucion> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<AuxDetallePlantillaSolucion> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public Double getCostoFinal() {
		return costoFinal;
	}

	public void setCostoFinal(Double costoFinal) {
		this.costoFinal = costoFinal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
}
