package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegBDPuesto implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_puesto;
	
	@Persistent
    private Date fecha_puesto;
	
	@Persistent
    private String nombre_puesto;
	
	@Persistent
    private String funciones;
	

	public SegBDPuesto() {
		super();
	}

	public Long getId_puesto() {
		return id_puesto.getId();
	}

	public Date getFecha_puesto() {
		return fecha_puesto;
	}

	public void setFecha_puesto(Date fecha_puesto) {
		this.fecha_puesto = fecha_puesto;
	}

	public String getNombre_puesto() {
		return nombre_puesto;
	}

	public void setNombre_puesto(String nombre_puesto) {
		this.nombre_puesto = nombre_puesto;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	
}
