package org.habitatguate.hgerp.seguridad.client.auxjdo;


import java.util.Date;

import javax.jdo.annotations.Persistent;

import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudSupervisionPrimera implements IsSerializable {

	public AuxSolicitudSupervisionPrimera() {
		super();
	}
	
	// Llave Primaria
	
    private Long idSupervisionPrimera;
	
	public Long getIdSupervisionPrimera() {
		return idSupervisionPrimera;
	}

	public void setIdSupervisionPrimera(Long idSupervisionPrimera) {
		this.idSupervisionPrimera = idSupervisionPrimera;
	}
	
	// Atributos
	
    private Long fechaVisita;

    public Long getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Long fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	private Boolean checkSi;

	public Boolean getCheckSi() {
		return checkSi;
	}

	public void setCheckSi(Boolean checkSi) {
		this.checkSi = checkSi;
	}

	
    private Boolean checkNo;

	public Boolean getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(Boolean checkNo) {
		this.checkNo = checkNo;
	}

	
    private String observaciones;

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
    private String acciones;
	
	public String getAcciones() {
		return acciones;
	}

	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}
	
	
    private Boolean checkSatisfactoria;

	public Boolean getCheckSatisfactoria() {
		return checkSatisfactoria;
	}

	public void setCheckSatisfactoria(Boolean checkSatisfactoria) {
		this.checkSatisfactoria = checkSatisfactoria;
	}

	
    private Boolean checkNoSatisfactoria;

	public Boolean getCheckNoSatisfactoria() {
		return checkNoSatisfactoria;
	}

	public void setCheckNoSatisfactoria(Boolean checkNoSatisfactoria) {
		this.checkNoSatisfactoria = checkNoSatisfactoria;
	}
   
    private String URLFile;

	public String getURLFile() {
		return URLFile;
	}

	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}
 
    private String KeyFile;
	
	public String getKeyFile() {
		return KeyFile;
	}

	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}

	// Llave Foranea
	
	private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
    
}
