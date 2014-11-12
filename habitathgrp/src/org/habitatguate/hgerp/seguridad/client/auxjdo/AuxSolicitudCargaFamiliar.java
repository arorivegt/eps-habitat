package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudCargaFamiliar implements IsSerializable {

	public AuxSolicitudCargaFamiliar() {
		super();
	}
	
	// Llave Primaria

    private Long idCargaFamiliar;

    public Long getIdCargaFamiliar() {
		return idCargaFamiliar;
	}

	public void setIdCargaFamiliar(Long idCargaFamiliar) {
		this.idCargaFamiliar = idCargaFamiliar;
	}

	// Atributos
	
	private String nombreFamiliar;
	
	public String getNombreFamiliar() {
		return nombreFamiliar;
	}

	public void setNombreFamiliar(String nombreFamiliar) {
		this.nombreFamiliar = nombreFamiliar;
	}
	
    private int edadFamiliar;
	
	public int getEdadFamiliar() {
		return edadFamiliar;
	}

	public void setEdadFamiliar(int edadFamiliar) {
		this.edadFamiliar = edadFamiliar;
	}

    private String escolaridadFamiliar;
	
	public String getEscolaridadFamiliar() {
		return escolaridadFamiliar;
	}

	public void setEscolaridadFamiliar(String escolaridadFamiliar) {
		this.escolaridadFamiliar = escolaridadFamiliar;
	}

    private String ocupacionFamiliar;

	public String getOcupacionFamiliar() {
		return ocupacionFamiliar;
	}

	public void setOcupacionFamiliar(String ocupacionFamiliar) {
		this.ocupacionFamiliar = ocupacionFamiliar;
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
