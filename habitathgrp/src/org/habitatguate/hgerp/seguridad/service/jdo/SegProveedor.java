package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegProveedor implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key idProveedor;
	@Persistent
	private String nomProveedor;
	@Persistent
	private String dirProveedor;
	@Persistent
	private String telProveedor;
	@Persistent
	private Boolean servicioEntrega;	
	@Persistent
	private Date fechaIngreso;
	@Persistent
	private Boolean aprobadoComision;
	@Persistent
	private String paginaWeb;
	@Persistent
	private String numeroNit;
	@Persistent
	private String personaJuridica;
	@Persistent
	private String observaciones;
	
	//nuevos datos
	@Persistent
	private String razonSocial;
	@Persistent
	private String actividadEcono;
	@Persistent
	private String aceptaExencion;
	@Persistent
	private String relacionConProv;
	@Persistent
	private String tipoProveedor;
	@Persistent
	private String productosfrece;
	@Persistent
	private String disponibilidadProd;
	@Persistent
	private String tiempoEntrega;
	@Persistent
	private String regimenTributario;
	@Persistent
	private String aceptaDonacion;
	@Persistent
	private double porcentDonacion;
	
	@Persistent
    private List <Long> contactoProveedor = new ArrayList<Long>();
	
	@Persistent
	private List <Long> cuentaBancaria = new ArrayList<Long>();
		
	//------
	
	private SegAfiliado afiliado;
	
	@Persistent(mappedBy = "proveedor")
    @Element(dependent = "true")
	private List <SegMaterialCostruccion> materialCostruccion =  new ArrayList<SegMaterialCostruccion>();
	

	
	
	
	public List<Long> getContactoProveedor() {
		return contactoProveedor;
	}
	public void setContactoProveedor(List<Long> contactoProveedor) {
		this.contactoProveedor = contactoProveedor;
	}
	public List<Long> getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(List<Long> cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public Key getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Key idProveedor) {
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
	public SegAfiliado getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(SegAfiliado afiliado) {
		this.afiliado = afiliado;
	}
	public List<SegMaterialCostruccion> getMaterialCostruccion() {
		return materialCostruccion;
	}
	public void setMaterialCostruccion(
			List<SegMaterialCostruccion> materialCostruccion) {
		this.materialCostruccion = materialCostruccion;
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
	
	
	
}
