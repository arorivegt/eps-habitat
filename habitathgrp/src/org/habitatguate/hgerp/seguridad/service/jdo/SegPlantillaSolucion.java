package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.OneToMany;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;

import com.google.appengine.datanucleus.annotations.Unowned;



@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegPlantillaSolucion implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long idPlantillaSolucion;
	@Persistent
	private String nomPlantillaSolucion;
	@Persistent
	private Date fechaCreacion;
	@Persistent
	private String tipo;
	@Persistent
	private Double costoFinal;
	@Persistent(mappedBy = "plantillaSolucion")
    @Element(dependent = "true")
	private List<SegDetallePlantillaSolucion> listaDetalle;
	
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getCostoFinal() {
		return costoFinal;
	}
	public void setCostoFinal(Double costoFinal) {
		this.costoFinal = costoFinal;
	}
	public List<SegDetallePlantillaSolucion> getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(List<SegDetallePlantillaSolucion> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}


}
