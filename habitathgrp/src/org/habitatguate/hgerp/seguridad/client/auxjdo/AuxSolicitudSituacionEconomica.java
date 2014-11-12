package org.habitatguate.hgerp.seguridad.client.auxjdo;


import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudSituacionEconomica implements IsSerializable {

	public AuxSolicitudSituacionEconomica() {
		super();
	}
	
	// Llave Primaria
	
    private Long idSituacionEconomica;
		    
    public Long getIdSituacionEconomica() {
		return idSituacionEconomica;
	}

	public void setIdSituacionEconomica(Long idSituacionEconomica) {
		this.idSituacionEconomica = idSituacionEconomica;
	}
	
	// Atributos
	
    private float ingresosSolicitante;
	
	public float getIngresosSolicitante() {
		return ingresosSolicitante;
	}

	public void setIngresosSolicitante(float ingresosSolicitante) {
		this.ingresosSolicitante = ingresosSolicitante;
	}

	
    private float ingresosConyuge;
	
	public float getIngresosConyuge() {
		return ingresosConyuge;
	}

	public void setIngresosConyuge(float ingresosConyuge) {
		this.ingresosConyuge = ingresosConyuge;
	}
	
	
    private float otrosIngresos;
	
	public float getOtrosIngresos() {
		return otrosIngresos;
	}

	public void setOtrosIngresos(float otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}

	
    private float ingresosTotales;
	
	public float getIngresosTotales() {
		return ingresosTotales;
	}

	public void setIngresosTotales(float ingresosTotales) {
		this.ingresosTotales = ingresosTotales;
	}

	
    private float totalIngresos;
	
	public float getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(float totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	
    private float totalEgresos;
	
	public float getTotalEgresos() {
		return totalEgresos;
	}

	public void setTotalEgresos(float totalEgresos) {
		this.totalEgresos = totalEgresos;
	}

	
    private float diferencia;
	
	public float getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(float diferencia) {
		this.diferencia = diferencia;
	}

	
    private float pagosBuro;
	
	public float getPagosBuro() {
		return pagosBuro;
	}

	public void setPagosBuro(float pagosBuro) {
		this.pagosBuro = pagosBuro;
	}

	
    private float cuota;
	
	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	
    private float excedente;

	public float getExcedente() {
		return excedente;
	}

	public void setExcedente(float excedente) {
		this.excedente = excedente;
	}

	
    private float alquilerVivienda;
	
	public float getAlquilerVivienda() {
		return alquilerVivienda;
	}

	public void setAlquilerVivienda(float alquilerVivienda) {
		this.alquilerVivienda = alquilerVivienda;
	}

	
    private float alimentacion;

	public float getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(float alimentacion) {
		this.alimentacion = alimentacion;
	}

	
    private float ropa;
	
	public float getRopa() {
		return ropa;
	}

	public void setRopa(float ropa) {
		this.ropa = ropa;
	}

	
    private float gastosMedicos;
	
	public float getGastosMedicos() {
		return gastosMedicos;
	}

	public void setGastosMedicos(float gastosMedicos) {
		this.gastosMedicos = gastosMedicos;
	}

	
    private float transporte;
	
	public float getTransporte() {
		return transporte;
	}

	public void setTransporte(float transporte) {
		this.transporte = transporte;
	}

	
    private float educacion;
	
	public float getEducacion() {
		return educacion;
	}

	public void setEducacion(float educacion) {
		this.educacion = educacion;
	}

	
    private float pagoLuzAgua;
	
	public float getPagoLuzAgua() {
		return pagoLuzAgua;
	}

	public void setPagoLuzAgua(float pagoLuzAgua) {
		this.pagoLuzAgua = pagoLuzAgua;
	}

	
    private float pagoPrestamos;
	
	public float getPagoPrestamos() {
		return pagoPrestamos;
	}

	public void setPagoPrestamos(float pagoPrestamos) {
		this.pagoPrestamos = pagoPrestamos;
	}

	
    private float otrosGastos1;
	
	public float getOtrosGastos1() {
		return otrosGastos1;
	}

	public void setOtrosGastos1(float otrosGastos1) {
		this.otrosGastos1 = otrosGastos1;
	}

	
    private float otrosGastos2;
	
	public float getOtrosGastos2() {
		return otrosGastos2;
	}

	public void setOtrosGastos2(float otrosGastos2) {
		this.otrosGastos2 = otrosGastos2;
	}

	
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
    
}
