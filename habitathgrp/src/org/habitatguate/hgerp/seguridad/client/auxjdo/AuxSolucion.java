package org.habitatguate.hgerp.seguridad.client.auxjdo;


import java.util.ArrayList;
import java.util.Date;

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
	
	private double costoDirectoPlani;

	private double costoAdministrativo;

	private double costoTotal;
	
	private double costoTotalPlani;

	private double valorContrato;

	private int notaDebito;

	private Date fechaInicio;
	
	private Date fechaFin;
	
	private int anio;
	
	private int trimestre;
	
	private int estadoSolucion;
	
	private int numeroSolucion;
	
	private String departamentoSolucion;
	
	private String municipioSolucion;
	
	private ArrayList<AuxDetalleSolucion> lista = new ArrayList<AuxDetalleSolucion>();
	
	private ArrayList<String> nombreProducto = new ArrayList<String>();
	
	private ArrayList<Double> costoProducto = new ArrayList<Double>();
	
	private ArrayList<String> nombreProductoPlani = new ArrayList<String>();
	
	private ArrayList<Double> costoProductoPlani = new ArrayList<Double>();

	private AuxBeneficiario beneficiario;
	
	private AuxVale vale;
	
	private AuxProveedor proveedor;
	
	
	
	
	public AuxProveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(AuxProveedor proveedor) {
		this.proveedor = proveedor;
	}

	public AuxVale getVale() {
		return vale;
	}

	public void setVale(AuxVale vale) {
		this.vale = vale;
	}

	public ArrayList<String> getNombreProductoPlani() {
		return nombreProductoPlani;
	}

	public void setNombreProductoPlani(ArrayList<String> nombreProductoPlani) {
		this.nombreProductoPlani = nombreProductoPlani;
	}

	public ArrayList<Double> getCostoProductoPlani() {
		return costoProductoPlani;
	}

	public void setCostoProductoPlani(ArrayList<Double> costoProductoPlani) {
		this.costoProductoPlani = costoProductoPlani;
	}

	public Long getIdSolucion() {
		return idSolucion;
	}

	public void setIdSolucion(Long idSolucion) {
		this.idSolucion = idSolucion;
	}

	public String getNomSolucion() {
		return nomSolucion;
	}
	
	

	public int getEstadoSolucion() {
		return estadoSolucion;
	}

	public void setEstadoSolucion(int estadoSolucion) {
		this.estadoSolucion = estadoSolucion;
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

	public ArrayList<AuxDetalleSolucion> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AuxDetalleSolucion> lista) {
		this.lista = lista;
	}

	public ArrayList<String> getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(ArrayList<String> nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public ArrayList<Double> getCostoProducto() {
		return costoProducto;
	}

	public void setCostoProducto(ArrayList<Double> costoProducto) {
		this.costoProducto = costoProducto;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(int trimestre) {
		this.trimestre = trimestre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getNumeroSolucion() {
		return numeroSolucion;
	}

	public void setNumeroSolucion(int numeroSolucion) {
		this.numeroSolucion = numeroSolucion;
	}

	public double getCostoDirectoPlani() {
		return costoDirectoPlani;
	}

	public void setCostoDirectoPlani(double costoDirectoPlani) {
		this.costoDirectoPlani = costoDirectoPlani;
	}

	public double getCostoTotalPlani() {
		return costoTotalPlani;
	}

	public void setCostoTotalPlani(double costoTotalPlani) {
		this.costoTotalPlani = costoTotalPlani;
	}

	public String getDepartamentoSolucion() {
		return departamentoSolucion;
	}

	public void setDepartamentoSolucion(String departamentoSolucion) {
		this.departamentoSolucion = departamentoSolucion;
	}

	public String getMunicipioSolucion() {
		return municipioSolucion;
	}

	public void setMunicipioSolucion(String municipioSolucion) {
		this.municipioSolucion = municipioSolucion;
	}
	
	
	
	
	

	
}
