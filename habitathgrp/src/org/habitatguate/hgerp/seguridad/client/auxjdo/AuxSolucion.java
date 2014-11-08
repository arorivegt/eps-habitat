package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxSolucion implements Comparable<AuxSolucion>,IsSerializable {
	
	
    public static final ProvidesKey<AuxSolucion> KEY_PROVIDER = new ProvidesKey<AuxSolucion>() {
        @Override
        public Object getKey(AuxSolucion item) {
          return item == null ? null : item.getIdSolucion();
        }
      };
      @Override
      public int compareTo(AuxSolucion o) {
        return (o == null || o.getIdSolucion() == null) ? -1 : -o.getIdSolucion().compareTo(getIdSolucion());
      }

	private Long idSolucion;

	private String nomSolucion;

	private String disenio;

	private double costoMaterial;

	private double costoDirecto;

	private double costoAdministrativo;

	private double costoTotal;

	private double valorContrato;

	private int notaDebito;

	private Date fechaInicio;
	
	private List<AuxDetalleSolucion> lista = new ArrayList<AuxDetalleSolucion>();

	private AuxBeneficiario beneficiario;
	public Long getIdSolucion() {
		return idSolucion;
	}

	public void setIdSolucion(Long idSolucion) {
		this.idSolucion = idSolucion;
	}

	public String getNomSolucion() {
		return nomSolucion;
	}

	public void setNomSolucion(String nomSolucion) {
		this.nomSolucion = nomSolucion;
	}

	public String getDisenio() {
		return disenio;
	}

	public void setDisenio(String disenio) {
		this.disenio = disenio;
	}

	public double getCostoMaterial() {
		return costoMaterial;
	}

	public void setCostoMaterial(double costoMaterial) {
		this.costoMaterial = costoMaterial;
	}

	public double getCostoDirecto() {
		return costoDirecto;
	}

	public void setCostoDirecto(double costoDirecto) {
		this.costoDirecto = costoDirecto;
	}

	public double getCostoAdministrativo() {
		return costoAdministrativo;
	}

	public void setCostoAdministrativo(double costoAdministrativo) {
		this.costoAdministrativo = costoAdministrativo;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public int getNotaDebito() {
		return notaDebito;
	}

	public void setNotaDebito(int notaDebito) {
		this.notaDebito = notaDebito;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public AuxBeneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(AuxBeneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public List<AuxDetalleSolucion> getLista() {
		return lista;
	}

	public void setLista(List<AuxDetalleSolucion> lista) {
		this.lista = lista;
	}
	
	
	

	
}
