package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.Date;


import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxProveedor implements Comparable<AuxProveedor>,IsSerializable{
	
    public static final ProvidesKey<AuxProveedor> KEY_PROVIDER = new ProvidesKey<AuxProveedor>() {
        @Override
        public Object getKey(AuxProveedor item) {
          return item == null ? null : item.getIdProveedor();
        }
      };
	
      @Override
      public int compareTo(AuxProveedor o) {
        return (o == null || o.idProveedor == null) ? -1 : -o.idProveedor.compareTo(idProveedor);
      }
	
	
	private Long idProveedor;
	
	private String nomProveedor;
	
	private String dirProveedor;
	
	private String telProveedor;
	
	private Boolean servicioEntrega;	
	
	private Date fechaIngreso;
	
	private Boolean aprobadoComision;
	
	private String paginaWeb;
	
	private String numeroNit;
	
	private String personaJuridica;
	
	private String observaciones;

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getDirProveedor() {
		return dirProveedor;
	}

	public void setDirProveedor(String dirProveedor) {
		this.dirProveedor = dirProveedor;
	}

	public String getTelProveedor() {
		return telProveedor;
	}

	public void setTelProveedor(String telProveedor) {
		this.telProveedor = telProveedor;
	}

	public Boolean getServicioEntrega() {
		return servicioEntrega;
	}

	public void setServicioEntrega(Boolean servicioEntrega) {
		this.servicioEntrega = servicioEntrega;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getAprobadoComision() {
		return aprobadoComision;
	}

	public void setAprobadoComision(Boolean aprobadoComision) {
		this.aprobadoComision = aprobadoComision;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getNumeroNit() {
		return numeroNit;
	}

	public void setNumeroNit(String numeroNit) {
		this.numeroNit = numeroNit;
	}

	public String getPersonaJuridica() {
		return personaJuridica;
	}

	public void setPersonaJuridica(String personaJuridica) {
		this.personaJuridica = personaJuridica;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
}
