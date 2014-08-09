package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxReferenciaPersonal implements IsSerializable{
    private Long id_referencia_personal;

	
    private String nombre_referencia;
	
	
    private String telefono;
	
	
    private String puesto_candidato;
	
	
    private String relacion;

	
    private String actitudes_cualidades;
	

	public AuxReferenciaPersonal() {
		super();
	}

	public Long getId_referencia_personal() {
		return id_referencia_personal;
	}

	public void setId_referencia_personal(Long id_referencia_personal) {
		this.id_referencia_personal = id_referencia_personal;
	}

	public String getNombre_referencia() {
		return nombre_referencia;
	}

	public void setNombre_referencia(String nombre_referencia) {
		this.nombre_referencia = nombre_referencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPuesto_candidato() {
		return puesto_candidato;
	}

	public void setPuesto_candidato(String puesto_candidato) {
		this.puesto_candidato = puesto_candidato;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getActitudes_cualidades() {
		return actitudes_cualidades;
	}

	public void setActitudes_cualidades(String actitudes_cualidades) {
		this.actitudes_cualidades = actitudes_cualidades;
	}


    
}
