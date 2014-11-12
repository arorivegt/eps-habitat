package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegSolicitudSituacionEconomica implements Serializable {

	public SegSolicitudSituacionEconomica() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idSituacionEconomica;
	
	public Long getIdSituacionEconomica() {
		return idSituacionEconomica.getId();
	}
	
	// Atributos
	
	@Persistent    
    private Date fecrec;
	
	public Date getFecrec() {
		return fecrec;
	}

	public void setFecrec(Date fecrec) {
		this.fecrec = fecrec;
	}
	
	@Persistent
    private float ingresosSolicitante;
	
	public float getIngresosSolicitante() {
		return ingresosSolicitante;
	}

	public void setIngresosSolicitante(float ingresosSolicitante) {
		this.ingresosSolicitante = ingresosSolicitante;
	}

	@Persistent
    private float ingresosConyuge;
	
	public float getIngresosConyuge() {
		return ingresosConyuge;
	}

	public void setIngresosConyuge(float ingresosConyuge) {
		this.ingresosConyuge = ingresosConyuge;
	}
	
	@Persistent
    private float otrosIngresos;
	
	public float getOtrosIngresos() {
		return otrosIngresos;
	}

	public void setOtrosIngresos(float otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}

	@Persistent
    private float ingresosTotales;
	
	public float getIngresosTotales() {
		return ingresosTotales;
	}

	public void setIngresosTotales(float ingresosTotales) {
		this.ingresosTotales = ingresosTotales;
	}

	@Persistent
    private float totalIngresos;
	
	public float getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(float totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	@Persistent
    private float totalEgresos;
	
	public float getTotalEgresos() {
		return totalEgresos;
	}

	public void setTotalEgresos(float totalEgresos) {
		this.totalEgresos = totalEgresos;
	}

	@Persistent
    private float diferencia;
	
	public float getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(float diferencia) {
		this.diferencia = diferencia;
	}

	@Persistent
    private float pagosBuro;
	
	public float getPagosBuro() {
		return pagosBuro;
	}

	public void setPagosBuro(float pagosBuro) {
		this.pagosBuro = pagosBuro;
	}

	@Persistent
    private float cuota;
	
	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	@Persistent
    private float excedente;

	public float getExcedente() {
		return excedente;
	}

	public void setExcedente(float excedente) {
		this.excedente = excedente;
	}

	@Persistent
    private float alquilerVivienda;
	
	public float getAlquilerVivienda() {
		return alquilerVivienda;
	}

	public void setAlquilerVivienda(float alquilerVivienda) {
		this.alquilerVivienda = alquilerVivienda;
	}

	@Persistent
    private float alimentacion;

	public float getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(float alimentacion) {
		this.alimentacion = alimentacion;
	}

	@Persistent
    private float ropa;
	
	public float getRopa() {
		return ropa;
	}

	public void setRopa(float ropa) {
		this.ropa = ropa;
	}

	@Persistent
    private float gastosMedicos;
	
	public float getGastosMedicos() {
		return gastosMedicos;
	}

	public void setGastosMedicos(float gastosMedicos) {
		this.gastosMedicos = gastosMedicos;
	}

	@Persistent
    private float transporte;
	
	public float getTransporte() {
		return transporte;
	}

	public void setTransporte(float transporte) {
		this.transporte = transporte;
	}

	@Persistent
    private float educacion;
	
	public float getEducacion() {
		return educacion;
	}

	public void setEducacion(float educacion) {
		this.educacion = educacion;
	}

	@Persistent
    private float pagoLuzAgua;
	
	public float getPagoLuzAgua() {
		return pagoLuzAgua;
	}

	public void setPagoLuzAgua(float pagoLuzAgua) {
		this.pagoLuzAgua = pagoLuzAgua;
	}

	@Persistent
    private float pagoPrestamos;
	
	public float getPagoPrestamos() {
		return pagoPrestamos;
	}

	public void setPagoPrestamos(float pagoPrestamos) {
		this.pagoPrestamos = pagoPrestamos;
	}

	@Persistent
    private float otrosGastos1;
	
	public float getOtrosGastos1() {
		return otrosGastos1;
	}

	public void setOtrosGastos1(float otrosGastos1) {
		this.otrosGastos1 = otrosGastos1;
	}

	@Persistent
    private float otrosGastos2;
	
	public float getOtrosGastos2() {
		return otrosGastos2;
	}

	public void setOtrosGastos2(float otrosGastos2) {
		this.otrosGastos2 = otrosGastos2;
	}

	@Persistent
    private float egresosTotales;
	
	public float getEgresosTotales() {
		return egresosTotales;
	}

	public void setEgresosTotales(float egresosTotales) {
		this.egresosTotales = egresosTotales;
	}

	// Llave Foranea
	
	private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}

	// Relacion
	
	@Persistent
    private SegSolicitudGeneral solicitud;

	public SegSolicitudGeneral getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SegSolicitudGeneral solicitud) {
		this.solicitud = solicitud;
	}
    
}
