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
public class SegSolicitudDatosVivienda implements Serializable {

	public SegSolicitudDatosVivienda() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idDatosVivienda;
	
	public Long getIdDatosVivienda() {
		return idDatosVivienda.getId();
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
    private String datoVivienda;
	
	public String getDatoVivienda() {
		return datoVivienda;
	}

	public void setDatoVivienda(String datoVivienda) {
		this.datoVivienda = datoVivienda;
	}
	
	@Persistent
    private String otroDatoVivienda;

	public String getOtroDatoVivienda() {
		return otroDatoVivienda;
	}

	public void setOtroDatoVivienda(String otroDatoVivienda) {
		this.otroDatoVivienda = otroDatoVivienda;
	}
	
	@Persistent
    private String techo;
	
	public String getTecho() {
		return techo;
	}

	public void setTecho(String techo) {
		this.techo = techo;
	}

	@Persistent
    private String pared;
	
	public String getPared() {
		return pared;
	}

	public void setPared(String pared) {
		this.pared = pared;
	}

	@Persistent
    private String cocina;

	public String getCocina() {
		return cocina;
	}

	public void setCocina(String cocina) {
		this.cocina = cocina;
	}

	@Persistent
    private Boolean checkAgua;

	public Boolean getCheckAgua() {
		return checkAgua;
	}

	public void setCheckAgua(Boolean checkAgua) {
		this.checkAgua = checkAgua;
	}

	@Persistent
    private Boolean checkDrenaje;
	
	public Boolean getCheckDrenaje() {
		return checkDrenaje;
	}

	public void setCheckDrenaje(Boolean checkDrenaje) {
		this.checkDrenaje = checkDrenaje;
	}

	@Persistent
    private Boolean checkElectricidad;
	
	public Boolean getCheckElectricidad() {
		return checkElectricidad;
	}

	public void setCheckElectricidad(Boolean checkElectricidad) {
		this.checkElectricidad = checkElectricidad;
	}

	@Persistent
    private Boolean checkSanitario;

	public Boolean getCheckSanitario() {
		return checkSanitario;
	}

	public void setCheckSanitario(Boolean checkSanitario) {
		this.checkSanitario = checkSanitario;
	}
	
	@Persistent
    private String bienesInmuebles;

	public String getBienesInmuebles() {
		return bienesInmuebles;
	}

	public void setBienesInmuebles(String bienesInmuebles) {
		this.bienesInmuebles = bienesInmuebles;
	}
	
	@Persistent
    private float valorInmueble;
	
	public float getValorInmueble() {
		return valorInmueble;
	}

	public void setValorInmueble(float valorInmueble) {
		this.valorInmueble = valorInmueble;
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
