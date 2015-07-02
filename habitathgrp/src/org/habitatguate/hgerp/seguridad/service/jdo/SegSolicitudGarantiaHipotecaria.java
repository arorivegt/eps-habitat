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
public class SegSolicitudGarantiaHipotecaria implements Serializable {

	public SegSolicitudGarantiaHipotecaria() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idDocumentoPropiedad;
	
	public Long getIdDocumentoPropiedad() {
		return idDocumentoPropiedad.getId();
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
    private String escrituraNoRegistrada;

	public String getEscrituraNoRegistrada() {
		return escrituraNoRegistrada;
	}

	public void setEscrituraNoRegistrada(String escrituraNoRegistrada) {
		this.escrituraNoRegistrada = escrituraNoRegistrada;
	}
	
	@Persistent
    private String escrituraRegistrada;
	
	public String getEscrituraRegistrada() {
		return escrituraRegistrada;
	}

	public void setEscrituraRegistrada(String escrituraRegistrada) {
		this.escrituraRegistrada = escrituraRegistrada;
	}

	@Persistent
    private String folioEscritura;
	
	public String getFolioEscritura() {
		return folioEscritura;
	}

	public void setFolioEscritura(String folioEscritura) {
		this.folioEscritura = folioEscritura;
	}

	@Persistent
    private String libroEscritura;
	
	public String getLibroEscritura() {
		return libroEscritura;
	}

	public void setLibroEscritura(String libroEscritura) {
		this.libroEscritura = libroEscritura;
	}

	@Persistent
    private String fincaEscritura;
	
	public String getFincaEscritura() {
		return fincaEscritura;
	}

	public void setFincaEscritura(String fincaEscritura) {
		this.fincaEscritura = fincaEscritura;
	}
	
	@Persistent
    private String nombreNotario;
	
	public String getNombreNotario() {
		return nombreNotario;
	}

	public void setNombreNotario(String nombreNotario) {
		this.nombreNotario = nombreNotario;
	}

	@Persistent
    private float areaTerreno;
	
	public float getAreaTerreno() {
		return areaTerreno;
	}

	public void setAreaTerreno(float areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	@Persistent
    private float valorEstimado;

	public float getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(float valorEstimado) {
		this.valorEstimado = valorEstimado;
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
    private String nombrePersona;
	
	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	
	@Persistent
    private String numDpiPersona;
	
	public String getNumDpiPersona() {
		return numDpiPersona;
	}

	public void setNumDpiPersona(String numDpiPersona) {
		this.numDpiPersona = numDpiPersona;
	}

	@Persistent    
    private String aldeaPersona;

	public String getAldeaPersona() {
		return aldeaPersona;
	}

	public void setAldeaPersona(String aldeaPersona) {
		this.aldeaPersona = aldeaPersona;
	}

	@Persistent    
    private String direccionTerrenoPersona;
	
	public String getDireccionTerrenoPersona() {
		return direccionTerrenoPersona;
	}

	public void setDireccionTerrenoPersona(String direccionTerrenoPersona) {
		this.direccionTerrenoPersona = direccionTerrenoPersona;
	}

	@Persistent
    private String departamentoMunicipioDireccionPersona;
	
	public String getDepartamentoMunicipioDireccionPersona() {
		return departamentoMunicipioDireccionPersona;
	}

	public void setDepartamentoMunicipioDireccionPersona(
			String departamentoMunicipioDireccionPersona) {
		this.departamentoMunicipioDireccionPersona = departamentoMunicipioDireccionPersona;
	}

	@Persistent
    private int telefonoPersona;
	
	public int getTelefonoPersona() {
		return telefonoPersona;
	}

	public void setTelefonoPersona(int telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
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
