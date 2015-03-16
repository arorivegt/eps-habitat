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
public class SegSolicitudSupervisionPrimera implements Serializable {

	public SegSolicitudSupervisionPrimera() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idSupervisionPrimera;
	
	public Long getIdSupervisionPrimera() {
		return idSupervisionPrimera.getId();
	}
	
	// Atributos
	
	@Persistent    
    private Date fecrec;
	
	public Date getFecrec() {
		return fecrec;
	}

	public void setFecrec(Date fecrec) {
		this.fecrec = fecrec;
	}
	
	@Persistent
    private Date fechaVisita;
	
	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	@Persistent
    private Boolean checkSi;

	public Boolean getCheckSi() {
		return checkSi;
	}

	public void setCheckSi(Boolean checkSi) {
		this.checkSi = checkSi;
	}

	@Persistent
    private Boolean checkNo;

	public Boolean getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(Boolean checkNo) {
		this.checkNo = checkNo;
	}

	@Persistent
    private String observaciones;

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Persistent
    private String acciones;
	
	public String getAcciones() {
		return acciones;
	}

	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}
	
	@Persistent
    private Boolean checkSatisfactoria;

	public Boolean getCheckSatisfactoria() {
		return checkSatisfactoria;
	}

	public void setCheckSatisfactoria(Boolean checkSatisfactoria) {
		this.checkSatisfactoria = checkSatisfactoria;
	}

	@Persistent
    private Boolean checkNoSatisfactoria;

	public Boolean getCheckNoSatisfactoria() {
		return checkNoSatisfactoria;
	}

	public void setCheckNoSatisfactoria(Boolean checkNoSatisfactoria) {
		this.checkNoSatisfactoria = checkNoSatisfactoria;
	}
	
	@Persistent
    private String promotor;
	
	public String getPromotor() {
		return promotor;
	}

	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}

	@Persistent
    private String albanil;
	
	public String getAlbanil() {
		return albanil;
	}

	public void setAlbanil(String albanil) {
		this.albanil = albanil;
	}

	@Persistent
    private String representante;
	
	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	@Persistent    
    private String URLFile;

	public String getURLFile() {
		return URLFile;
	}

	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}

	@Persistent    
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

	// Relacion
	
	@Persistent
    private SegSolicitudGeneral solicitud;

	public SegSolicitudGeneral getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SegSolicitudGeneral solicitud) {
		this.solicitud = solicitud;
	}
    
}
