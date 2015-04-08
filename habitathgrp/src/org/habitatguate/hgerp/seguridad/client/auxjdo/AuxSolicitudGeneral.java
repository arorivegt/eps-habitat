package org.habitatguate.hgerp.seguridad.client.auxjdo;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxSolicitudGeneral implements IsSerializable {
	
	public AuxSolicitudGeneral() {
		super();
	}
	
	// Llave Primaria
	
    private Long idFormulario;
	
    public Long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(Long idFormulario) {
		this.idFormulario = idFormulario;
	}
	
	// Atributos

    private String nombreSolicitante;
	
	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}
	
    private String estadoCivil;

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
    private int edad;   

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}	
	
    private String nacionalidad;

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
    private String profesionOficio;
	
	public String getProfesionOficio() {
		return profesionOficio;
	}

	public void setProfesionOficio(String profesionOficio) {
		this.profesionOficio = profesionOficio;
	}
	
    private int numDpi;   

	public int getNumDpi() {
		return numDpi;
	}

	public void setNumDpi(int numDpi) {
		this.numDpi = numDpi;
	}
	
    private int numDpiUnico;
    
    public int getNumDpiUnico() {
		return numDpiUnico;
	}

	public void setNumDpiUnico(int numDpiUnico) {
		this.numDpiUnico = numDpiUnico;
	}

	private int numDpiReferencia;

	public int getNumDpiReferencia() {
		return numDpiReferencia;
	}

	public void setNumDpiReferencia(int numDpiReferencia) {
		this.numDpiReferencia = numDpiReferencia;
	}
	
    private String actividadEconomica;
	
	public String getActividadEconomica() {
		return actividadEconomica;
	}

	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}
	
    private Boolean checkLeer;
	
	public Boolean getCheckLeer() {
		return checkLeer;
	}

	public void setCheckLeer(Boolean checkLeer) {
		this.checkLeer = checkLeer;
	}
	
    private Boolean checkEscribir;

	public Boolean getCheckEscribir() {
		return checkEscribir;
	}

	public void setCheckEscribir(Boolean checkEscribir) {
		this.checkEscribir = checkEscribir;
	}
	
    private Boolean checkFirmar;
	
	public Boolean getCheckFirmar() {
		return checkFirmar;
	}

	public void setCheckFirmar(Boolean checkFirmar) {
		this.checkFirmar = checkFirmar;
	}
	    
    private String direccionActual;

	public String getDireccionActual() {
		return direccionActual;
	}

	public void setDireccionActual(String direccionActual) {
		this.direccionActual = direccionActual;
	}
	    
    private String direccionSolucion;

	public String getDireccionSolucion() {
		return direccionSolucion;
	}

	public void setDireccionSolucion(String direccionSolucion) {
		this.direccionSolucion = direccionSolucion;
	}
	    
    private Boolean checkCamion;

	public Boolean getCheckCamion() {
		return checkCamion;
	}

	public void setCheckCamion(Boolean checkCamion) {
		this.checkCamion = checkCamion;
	}
    
    private Boolean checkCarro;

	public Boolean getCheckCarro() {
		return checkCarro;
	}

	public void setCheckCarro(Boolean checkCarro) {
		this.checkCarro = checkCarro;
	}
	    
    private Boolean checkPeatonal;

	public Boolean getCheckPeatonal() {
		return checkPeatonal;
	}

	public void setCheckPeatonal(Boolean checkPeatonal) {
		this.checkPeatonal = checkPeatonal;
	}
	    
    private String lugarTrabajoSolicitante;

	public String getLugarTrabajoSolicitante() {
		return lugarTrabajoSolicitante;
	}

	public void setLugarTrabajoSolicitante(String lugarTrabajoSolicitante) {
		this.lugarTrabajoSolicitante = lugarTrabajoSolicitante;
	}	
	    
    private int telefonoCasaSolicitante;

	public int getTelefonoCasaSolicitante() {
		return telefonoCasaSolicitante;
	}

	public void setTelefonoCasaSolicitante(int telefonoCasaSolicitante) {
		this.telefonoCasaSolicitante = telefonoCasaSolicitante;
	}
	    
    private int telefonoTrabajoSolicitante;

	public int getTelefonoTrabajoSolicitante() {
		return telefonoTrabajoSolicitante;
	}

	public void setTelefonoTrabajoSolicitante(int telefonoTrabajoSolicitante) {
		this.telefonoTrabajoSolicitante = telefonoTrabajoSolicitante;
	}
	    
    private String solucionConstruir;

	public String getSolucionConstruir() {
		return solucionConstruir;
	}

	public void setSolucionConstruir(String solucionConstruir) {
		this.solucionConstruir = solucionConstruir;
	}
		
    private float cuotaPagar;

	public float getCuotaPagar() {
		return cuotaPagar;
	}

	public void setCuotaPagar(float cuotaPagar) {
		this.cuotaPagar = cuotaPagar;
	}
		    
    private String nombreConyuge;

	public String getNombreConyuge() {
		return nombreConyuge;
	}

	public void setNombreConyuge(String nombreConyuge) {
		this.nombreConyuge = nombreConyuge;
	}
	    
    private int telefonoConyuge;

	public int getTelefonoConyuge() {
		return telefonoConyuge;
	}

	public void setTelefonoConyuge(int telefonoConyuge) {
		this.telefonoConyuge = telefonoConyuge;
	}	
	 
    private String lugarTrabajoConyuge;

	public String getLugarTrabajoConyuge() {
		return lugarTrabajoConyuge;
	}

	public void setLugarTrabajoConyuge(String lugarTrabajoConyuge) {
		this.lugarTrabajoConyuge = lugarTrabajoConyuge;
	}
	    
    private int telefonoTrabajoConyuge;

	public int getTelefonoTrabajoConyuge() {
		return telefonoTrabajoConyuge;
	}

	public void setTelefonoTrabajoConyuge(int telefonoTrabajoConyuge) {
		this.telefonoTrabajoConyuge = telefonoTrabajoConyuge;
	}

	
    private Boolean garantia;

	public Boolean getGarantia() {
		return garantia;
	}

	public void setGarantia(Boolean garantia) {
		this.garantia = garantia;
	}

    private Boolean aprobacion;

	public Boolean getAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(Boolean aprobacion) {
		this.aprobacion = aprobacion;
	}
	
    private Boolean PrimeraSupervision;

	public Boolean getPrimeraSupervision() {
		return PrimeraSupervision;
	}

	public void setPrimeraSupervision(Boolean primeraSupervision) {
		PrimeraSupervision = primeraSupervision;
	}
	
    private Boolean SegundaSupervision;
	
	public Boolean getSegundaSupervision() {
		return SegundaSupervision;
	}

	public void setSegundaSupervision(Boolean segundaSupervision) {
		SegundaSupervision = segundaSupervision;
	}

    private Boolean TerceraSupervision;
	
	public Boolean getTerceraSupervision() {
		return TerceraSupervision;
	}

	public void setTerceraSupervision(Boolean terceraSupervision) {
		TerceraSupervision = terceraSupervision;
	}
	
    private Boolean CuartaSupervision;
	
	public Boolean getCuartaSupervision() {
		return CuartaSupervision;
	}

	public void setCuartaSupervision(Boolean cuartaSupervision) {
		CuartaSupervision = cuartaSupervision;
	}	
	
	
	// Relacion
	
	private List <AuxSolicitudCargaFamiliar> cargaFamiliar = new ArrayList<AuxSolicitudCargaFamiliar>();
	
	public List<AuxSolicitudCargaFamiliar> getCargaFamiliar() {
		return cargaFamiliar;
	}

	public void setCargaFamiliar(List<AuxSolicitudCargaFamiliar> cargaFamiliar) {
		this.cargaFamiliar = cargaFamiliar;
	}

	private List <AuxSolicitudReferenciaFamiliar> referenciaFamiliar = new ArrayList<AuxSolicitudReferenciaFamiliar>();

	public List<AuxSolicitudReferenciaFamiliar> getReferenciaFamiliar() {
		return referenciaFamiliar;
	}

	public void setReferenciaFamiliar(
			List<AuxSolicitudReferenciaFamiliar> referenciaFamiliar) {
		this.referenciaFamiliar = referenciaFamiliar;
	}
	
	private List <AuxSolicitudDatosVivienda> datosVivienda = new ArrayList<AuxSolicitudDatosVivienda>();

	public List<AuxSolicitudDatosVivienda> getDatosVivienda() {
		return datosVivienda;
	}

	public void setDatosVivienda(List<AuxSolicitudDatosVivienda> datosVivienda) {
		this.datosVivienda = datosVivienda;
	}

	private List <AuxSolicitudSituacionEconomica> situacionEconomica = new ArrayList<AuxSolicitudSituacionEconomica>();

	public List<AuxSolicitudSituacionEconomica> getSituacionEconomica() {
		return situacionEconomica;
	}

	public void setSituacionEconomica(
			List<AuxSolicitudSituacionEconomica> situacionEconomica) {
		this.situacionEconomica = situacionEconomica;
	}

	private List <AuxSolicitudGarantiaHipotecaria> garantiaHipotecaria = new ArrayList<AuxSolicitudGarantiaHipotecaria>();

	public List<AuxSolicitudGarantiaHipotecaria> getGarantiaHipotecaria() {
		return garantiaHipotecaria;
	}

	public void setGarantiaHipotecaria(
			List<AuxSolicitudGarantiaHipotecaria> garantiaHipotecaria) {
		this.garantiaHipotecaria = garantiaHipotecaria;
	}

	private List <AuxSolicitudGarantiaFiduciaria> garantiaFiduciaria = new ArrayList<AuxSolicitudGarantiaFiduciaria>();
	
	public List<AuxSolicitudGarantiaFiduciaria> getGarantiaFiduciaria() {
		return garantiaFiduciaria;
	}

	public void setGarantiaFiduciaria(
			List<AuxSolicitudGarantiaFiduciaria> garantiaFiduciaria) {
		this.garantiaFiduciaria = garantiaFiduciaria;
	}

	private List <AuxSolicitudGarantiaSolidario> garantiaSolidario = new ArrayList<AuxSolicitudGarantiaSolidario>();
	
	public List<AuxSolicitudGarantiaSolidario> getGarantiaSolidario() {
		return garantiaSolidario;
	}

	public void setGarantiaSolidario(
			List<AuxSolicitudGarantiaSolidario> garantiaSolidario) {
		this.garantiaSolidario = garantiaSolidario;
	}

	private List <AuxSolicitudSupervisionPrimera> supervisionPrimera = new ArrayList<AuxSolicitudSupervisionPrimera>();

	public List<AuxSolicitudSupervisionPrimera> getSupervisionPrimera() {
		return supervisionPrimera;
	}

	public void setSupervisionPrimera(
			List<AuxSolicitudSupervisionPrimera> supervisionPrimera) {
		this.supervisionPrimera = supervisionPrimera;
	}

	private List <AuxSolicitudSupervisionSegunda> supervisionSegunda = new ArrayList<AuxSolicitudSupervisionSegunda>();

	public List<AuxSolicitudSupervisionSegunda> getSupervisionSegunda() {
		return supervisionSegunda;
	}

	public void setSupervisionSegunda(
			List<AuxSolicitudSupervisionSegunda> supervisionSegunda) {
		this.supervisionSegunda = supervisionSegunda;
	}

	private List <AuxSolicitudSupervisionTercera> supervisionTercera = new ArrayList<AuxSolicitudSupervisionTercera>();

	public List<AuxSolicitudSupervisionTercera> getSupervisionTercera() {
		return supervisionTercera;
	}

	public void setSupervisionTercera(
			List<AuxSolicitudSupervisionTercera> supervisionTercera) {
		this.supervisionTercera = supervisionTercera;
	}

	private List <AuxSolicitudSupervisionCuarta> supervisionCuarta = new ArrayList<AuxSolicitudSupervisionCuarta>();

	public List<AuxSolicitudSupervisionCuarta> getSupervisionCuarta() {
		return supervisionCuarta;
	}

	public void setSupervisionCuarta(
			List<AuxSolicitudSupervisionCuarta> supervisionCuarta) {
		this.supervisionCuarta = supervisionCuarta;
	}
	
	private List <AuxSolicitudSupervisionUbicacion> supervisionUbicacion = new ArrayList<AuxSolicitudSupervisionUbicacion>();

	public List<AuxSolicitudSupervisionUbicacion> getSupervisionUbicacion() {
		return supervisionUbicacion;
	}

	public void setSupervisionUbicacion(
			List<AuxSolicitudSupervisionUbicacion> supervisionUbicacion) {
		this.supervisionUbicacion = supervisionUbicacion;
	}
	
	private List <AuxSolicitudEncuestaSatisfaccion> encuestaSatisfaccion = new ArrayList<AuxSolicitudEncuestaSatisfaccion>();

	public List<AuxSolicitudEncuestaSatisfaccion> getEncuestaSatisfaccion() {
		return encuestaSatisfaccion;
	}

	public void setEncuestaSatisfaccion(
			List<AuxSolicitudEncuestaSatisfaccion> encuestaSatisfaccion) {
		this.encuestaSatisfaccion = encuestaSatisfaccion;
	}
	
}
