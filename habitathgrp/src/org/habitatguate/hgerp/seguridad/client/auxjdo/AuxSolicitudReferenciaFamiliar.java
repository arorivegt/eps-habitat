package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudReferenciaFamiliar implements IsSerializable {

	public AuxSolicitudReferenciaFamiliar() {
		super();
	}
	
	// Llave Primaria

    private Long idReferenciaFamiliar;
	
	public Long getIdReferenciaFamiliar() {
		return idReferenciaFamiliar;
	}

	public void setIdReferenciaFamiliar(Long idReferenciaFamiliar) {
		this.idReferenciaFamiliar = idReferenciaFamiliar;
	}
	
	// Atributos

    private String nombreFamiliar;
	
	public String getNombreFamiliar() {
		return nombreFamiliar;
	}

	public void setNombreFamiliar(String nombreFamiliar) {
		this.nombreFamiliar = nombreFamiliar;
	}
	
    private int telefonoFamiliar;
	
    public int getTelefonoFamiliar() {
		return telefonoFamiliar;
	}

	public void setTelefonoFamiliar(int telefonoFamiliar) {
		this.telefonoFamiliar = telefonoFamiliar;
	}

	private String parentescoFamiliar;
	
    public String getParentescoFamiliar() {
		return parentescoFamiliar;
	}

	public void setParentescoFamiliar(String parentescoFamiliar) {
		this.parentescoFamiliar = parentescoFamiliar;
	}

	private String direccionFamiliar;
	
    public String getDireccionFamiliar() {
		return direccionFamiliar;
	}

	public void setDireccionFamiliar(String direccionFamiliar) {
		this.direccionFamiliar = direccionFamiliar;
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
