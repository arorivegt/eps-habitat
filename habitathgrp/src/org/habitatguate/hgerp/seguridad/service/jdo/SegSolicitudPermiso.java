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
public class SegSolicitudPermiso implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_permiso;
	
	@Persistent
    private Date fecha1;	
	
	@Persistent
    private Date fecha2;

	@Persistent
    private String Descripcion;
	
	@Persistent
    private String tipoPermisos;
	
	@Persistent
    private String JefeInmediatoAceptaSolicitud;
	
	@Persistent
    private String rrhhAceptaSolicitud;
	

	@Persistent
    private Long idEmpleadoSolicitante;
	
	
	@Persistent
    private SegEmpleado empleado;
	
	public SegSolicitudPermiso() {
		super();
	}

	public Long getId_permiso() {
		return id_permiso.getId();
	}

	public Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	public Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getTipoPermisos() {
		return tipoPermisos;
	}

	public void setTipoPermisos(String tipoPermisos) {
		this.tipoPermisos = tipoPermisos;
	}

	public String getJefeInmediatoAceptaSolicitud() {
		return JefeInmediatoAceptaSolicitud;
	}

	public void setJefeInmediatoAceptaSolicitud(String jefeInmediatoAceptaSolicitud) {
		JefeInmediatoAceptaSolicitud = jefeInmediatoAceptaSolicitud;
	}

	public String getRrhhAceptaSolicitud() {
		return rrhhAceptaSolicitud;
	}

	public void setRrhhAceptaSolicitud(String rrhhAceptaSolicitud) {
		this.rrhhAceptaSolicitud = rrhhAceptaSolicitud;
	}

	public Long getIdEmpleadoSolicitante() {
		return idEmpleadoSolicitante;
	}

	public void setIdEmpleadoSolicitante(Long idEmpleadoSolicitante) {
		this.idEmpleadoSolicitante = idEmpleadoSolicitante;
	}
	
	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}
	
	
}
