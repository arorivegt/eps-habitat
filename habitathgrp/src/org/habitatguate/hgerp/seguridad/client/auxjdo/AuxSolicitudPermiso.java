package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudPermiso implements IsSerializable{
	
    private Long id_permiso;
	
	
    private Long fecha1;	
	
	
    private Long fecha2;

	
    private String Descripcion;
	
	
    private String tipoPermisos;
	
	
    private String JefeInmediatoAceptaSolicitud;
	
	
    private String rrhhAceptaSolicitud;

	
    private Long idEmpleadoSolicitante;
    
    private int bandera_solicitud;

	
	public AuxSolicitudPermiso() {
		super();
	}


	public Long getId_permiso() {
		return id_permiso;
	}


	public void setId_permiso(Long id_permiso) {
		this.id_permiso = id_permiso;
	}


	public Long getFecha1() {
		return fecha1;
	}


	public void setFecha1(Long fecha1) {
		this.fecha1 = fecha1;
	}


	public Long getFecha2() {
		return fecha2;
	}


	public void setFecha2(Long fecha2) {
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


	public String isJefeInmediatoAceptaSolicitud() {
		return JefeInmediatoAceptaSolicitud;
	}


	public void setJefeInmediatoAceptaSolicitud(String jefeInmediatoAceptaSolicitud) {
		JefeInmediatoAceptaSolicitud = jefeInmediatoAceptaSolicitud;
	}


	public int getBandera_solicitud() {
		return bandera_solicitud;
	}


	public void setBandera_solicitud(int bandera_solicitud) {
		this.bandera_solicitud = bandera_solicitud;
	}


	public String isRrhhAceptaSolicitud() {
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
    
	
 
	 
	
}
