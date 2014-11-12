package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudDatosVivienda implements IsSerializable {

	public AuxSolicitudDatosVivienda() {
		super();
	}
	
	// Llave Primaria
	

    private Long idDatosVivienda;
	
	public Long getIdDatosVivienda() {
		return idDatosVivienda;
	}

	public void setIdDatosVivienda(Long idDatosVivienda) {
		this.idDatosVivienda = idDatosVivienda;
	}
	    
	// Atributos
	
    private String datoVivienda;
	
	public String getDatoVivienda() {
		return datoVivienda;
	}

	public void setDatoVivienda(String datoVivienda) {
		this.datoVivienda = datoVivienda;
	}
	
	
    private String otroDatoVivienda;

	public String getOtroDatoVivienda() {
		return otroDatoVivienda;
	}

	public void setOtroDatoVivienda(String otroDatoVivienda) {
		this.otroDatoVivienda = otroDatoVivienda;
	}
	
	
    private String techo;
	
	public String getTecho() {
		return techo;
	}

	public void setTecho(String techo) {
		this.techo = techo;
	}

	
    private String pared;
	
	public String getPared() {
		return pared;
	}

	public void setPared(String pared) {
		this.pared = pared;
	}

	
    private String cocina;

	public String getCocina() {
		return cocina;
	}

	public void setCocina(String cocina) {
		this.cocina = cocina;
	}

	
    private Boolean checkAgua;

	public Boolean getCheckAgua() {
		return checkAgua;
	}

	public void setCheckAgua(Boolean checkAgua) {
		this.checkAgua = checkAgua;
	}

	
    private Boolean checkDrenaje;
	
	public Boolean getCheckDrenaje() {
		return checkDrenaje;
	}

	public void setCheckDrenaje(Boolean checkDrenaje) {
		this.checkDrenaje = checkDrenaje;
	}

	
    private Boolean checkElectricidad;
	
	public Boolean getCheckElectricidad() {
		return checkElectricidad;
	}

	public void setCheckElectricidad(Boolean checkElectricidad) {
		this.checkElectricidad = checkElectricidad;
	}

	
    private Boolean checkSanitario;

	public Boolean getCheckSanitario() {
		return checkSanitario;
	}

	public void setCheckSanitario(Boolean checkSanitario) {
		this.checkSanitario = checkSanitario;
	}
	
	
    private String bienesInmuebles;

	public String getBienesInmuebles() {
		return bienesInmuebles;
	}

	public void setBienesInmuebles(String bienesInmuebles) {
		this.bienesInmuebles = bienesInmuebles;
	}
	
	
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
    
}
