package org.habitatguate.hgerp.seguridad.client.auxjdo;


import java.util.Date;
import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudSupervisionSegunda implements IsSerializable {

	public AuxSolicitudSupervisionSegunda() {
		super();
	}
	
	// Llave Primaria
	
    private Long idSupervisionSegunda;
	
    public Long getIdSupervisionSegunda() {
		return idSupervisionSegunda;
	}

	public void setIdSupervisionSegunda(Long idSupervisionSegunda) {
		this.idSupervisionSegunda = idSupervisionSegunda;
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
