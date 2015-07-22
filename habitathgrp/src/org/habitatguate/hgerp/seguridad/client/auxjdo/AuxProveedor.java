package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.ArrayList;
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
	
	//nuevos elementos
	

	private String razonSocial;

	private String actividadEcono;

	private String aceptaExencion;

	private String relacionConProv;

	private String tipoProveedor;

	private String productosfrece;

	private String disponibilidadProd;

	private String tiempoEntrega;

	private String regimenTributario;

	private String aceptaDonacion;

	private double porcentDonacion;
	
	private AuxAfiliado auxAfiliado;
	
	private double totalCuentaPorPagar;
	
	
	private ArrayList<AuxCuentaBancariaProv> lista = new ArrayList<AuxCuentaBancariaProv>();

	
	public AuxProveedor() {
		auxAfiliado = new AuxAfiliado();
	}
	
	public AuxAfiliado getAuxAfiliado() {
		return auxAfiliado;
	}

	public void setAuxAfiliado(AuxAfiliado auxAfiliado) {
		this.auxAfiliado = auxAfiliado;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getActividadEcono() {
		return actividadEcono;
	}

	public void setActividadEcono(String actividadEcono) {
		this.actividadEcono = actividadEcono;
	}

	public String getAceptaExencion() {
		return aceptaExencion;
	}

	public void setAceptaExencion(String aceptaExencion) {
		this.aceptaExencion = aceptaExencion;
	}

	public String getRelacionConProv() {
		return relacionConProv;
	}

	public void setRelacionConProv(String relacionConProv) {
		this.relacionConProv = relacionConProv;
	}

	public String getTipoProveedor() {
		return tipoProveedor;
	}

	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	public String getProductosfrece() {
		return productosfrece;
	}

	public void setProductosfrece(String productosfrece) {
		this.productosfrece = productosfrece;
	}

	public String getDisponibilidadProd() {
		return disponibilidadProd;
	}

	public void setDisponibilidadProd(String disponibilidadProd) {
		this.disponibilidadProd = disponibilidadProd;
	}

	public String getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(String tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public String getRegimenTributario() {
		return regimenTributario;
	}

	public void setRegimenTributario(String regimenTributario) {
		this.regimenTributario = regimenTributario;
	}

	public String getAceptaDonacion() {
		return aceptaDonacion;
	}

	public void setAceptaDonacion(String aceptaDonacion) {
		this.aceptaDonacion = aceptaDonacion;
	}

	public double getPorcentDonacion() {
		return porcentDonacion;
	}

	public void setPorcentDonacion(double porcentDonacion) {
		this.porcentDonacion = porcentDonacion;
	}

	public ArrayList<AuxCuentaBancariaProv> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AuxCuentaBancariaProv> lista) {
		this.lista = lista;
	}

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

	public double getTotalCuentaPorPagar() {
		return totalCuentaPorPagar;
	}

	public void setTotalCuentaPorPagar(double totalCuentaPorPagar) {
		this.totalCuentaPorPagar = totalCuentaPorPagar;
	}
	
	

	
}
