package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudSupervisionCuarta implements IsSerializable {

	public AuxSolicitudSupervisionCuarta() {
		super();
	}
	
	// Llave Primaria
	
    private Long idSupervisionCuarta;

	public Long getIdSupervisionCuarta() {
		return idSupervisionCuarta;
	}

	public void setIdSupervisionCuarta(Long idSupervisionCuarta) {
		this.idSupervisionCuarta = idSupervisionCuarta;
	}

	// Atributos
	
	private Long fechaVisita;

    public Long getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Long fechaVisita) {
		this.fechaVisita = fechaVisita;
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

	// Llave Foranea
	
	private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
    
}