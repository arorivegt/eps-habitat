package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.Extension;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegSolicitudGeneral implements Serializable {
	
	public SegSolicitudGeneral() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idFormulario;
	
	public Long getIdFormulario() {
		return idFormulario.getId();
	}
	
	private Long idEmpleado;
	
	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	private Long idAfiliado;
	
	public Long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(Long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	// Atributos
	
	@Persistent
    private String usrName;
	
	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	@Persistent    
    private Date fecrec;
	
	public Date getFecrec() {
		return fecrec;
	}

	public void setFecrec(Date fecrec) {
		this.fecrec = fecrec;
	}
	
	@Persistent    
    private Date fecupdate;
	
	public Date getFecupdate() {
		return fecupdate;
	}

	public void setFecupdate(Date fecupdate) {
		this.fecupdate = fecupdate;
	}

	@Persistent
    private String nombreSolicitante;
	
	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}
	
	@Persistent
    private String estadoCivil;

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Persistent
    private int edad;   

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Persistent
    private String nacionalidad;

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Persistent
    private String profesionOficio;
	
	public String getProfesionOficio() {
		return profesionOficio;
	}

	public void setProfesionOficio(String profesionOficio) {
		this.profesionOficio = profesionOficio;
	}

	@Persistent
    private String numDpi;   
	
    public String getNumDpi() {
		return numDpi;
	}

	public void setNumDpi(String numDpi) {
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

	@Persistent
    private String actividadEconomica;
	
	public String getActividadEconomica() {
		return actividadEconomica;
	}

	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}

	@Persistent
    private Boolean checkLeer;
	
	public Boolean getCheckLeer() {
		return checkLeer;
	}

	public void setCheckLeer(Boolean checkLeer) {
		this.checkLeer = checkLeer;
	}

	@Persistent
    private Boolean checkEscribir;

	public Boolean getCheckEscribir() {
		return checkEscribir;
	}

	public void setCheckEscribir(Boolean checkEscribir) {
		this.checkEscribir = checkEscribir;
	}

	@Persistent
    private Boolean checkFirmar;
	
	public Boolean getCheckFirmar() {
		return checkFirmar;
	}

	public void setCheckFirmar(Boolean checkFirmar) {
		this.checkFirmar = checkFirmar;
	}

	@Persistent    
    private String direccionActual;

	public String getDireccionActual() {
		return direccionActual;
	}

	public void setDireccionActual(String direccionActual) {
		this.direccionActual = direccionActual;
	}

	@Persistent    
    private String direccionSolucion;

	public String getDireccionSolucion() {
		return direccionSolucion;
	}

	public void setDireccionSolucion(String direccionSolucion) {
		this.direccionSolucion = direccionSolucion;
	}

	@Persistent    
    private Boolean checkCamion;

	public Boolean getCheckCamion() {
		return checkCamion;
	}

	public void setCheckCamion(Boolean checkCamion) {
		this.checkCamion = checkCamion;
	}

	@Persistent    
    private Boolean checkCarro;

	public Boolean getCheckCarro() {
		return checkCarro;
	}

	public void setCheckCarro(Boolean checkCarro) {
		this.checkCarro = checkCarro;
	}

	@Persistent    
    private Boolean checkPeatonal;

	public Boolean getCheckPeatonal() {
		return checkPeatonal;
	}

	public void setCheckPeatonal(Boolean checkPeatonal) {
		this.checkPeatonal = checkPeatonal;
	}

	@Persistent    
    private String lugarTrabajoSolicitante;

	public String getLugarTrabajoSolicitante() {
		return lugarTrabajoSolicitante;
	}

	public void setLugarTrabajoSolicitante(String lugarTrabajoSolicitante) {
		this.lugarTrabajoSolicitante = lugarTrabajoSolicitante;
	}	

	@Persistent    
    private int telefonoCasaSolicitante;

	public int getTelefonoCasaSolicitante() {
		return telefonoCasaSolicitante;
	}

	public void setTelefonoCasaSolicitante(int telefonoCasaSolicitante) {
		this.telefonoCasaSolicitante = telefonoCasaSolicitante;
	}

	@Persistent    
    private int telefonoTrabajoSolicitante;

	public int getTelefonoTrabajoSolicitante() {
		return telefonoTrabajoSolicitante;
	}

	public void setTelefonoTrabajoSolicitante(int telefonoTrabajoSolicitante) {
		this.telefonoTrabajoSolicitante = telefonoTrabajoSolicitante;
	}

	@Persistent    
    private String solucionConstruir;

	public String getSolucionConstruir() {
		return solucionConstruir;
	}

	public void setSolucionConstruir(String solucionConstruir) {
		this.solucionConstruir = solucionConstruir;
	}
	
	@Persistent
    private float cuotaPagar;

	public float getCuotaPagar() {
		return cuotaPagar;
	}

	public void setCuotaPagar(float cuotaPagar) {
		this.cuotaPagar = cuotaPagar;
	}
	
	@Persistent    
    private String nombreConyuge;

	public String getNombreConyuge() {
		return nombreConyuge;
	}

	public void setNombreConyuge(String nombreConyuge) {
		this.nombreConyuge = nombreConyuge;
	}

	@Persistent    
    private int telefonoConyuge;

	public int getTelefonoConyuge() {
		return telefonoConyuge;
	}

	public void setTelefonoConyuge(int telefonoConyuge) {
		this.telefonoConyuge = telefonoConyuge;
	}
	
	@Persistent    
    private String lugarTrabajoConyuge;

	public String getLugarTrabajoConyuge() {
		return lugarTrabajoConyuge;
	}

	public void setLugarTrabajoConyuge(String lugarTrabajoConyuge) {
		this.lugarTrabajoConyuge = lugarTrabajoConyuge;
	}

	@Persistent    
    private int telefonoTrabajoConyuge;

	public int getTelefonoTrabajoConyuge() {
		return telefonoTrabajoConyuge;
	}

	public void setTelefonoTrabajoConyuge(int telefonoTrabajoConyuge) {
		this.telefonoTrabajoConyuge = telefonoTrabajoConyuge;
	}

	@Persistent
    private Boolean creditoAprobado;

	public Boolean getCreditoAprobado() {
		return creditoAprobado;
	}

	public void setCreditoAprobado(Boolean creditoAprobado) {
		this.creditoAprobado = creditoAprobado;
	}
	
	@Persistent
    private Boolean creditoNoAprobado;

	public Boolean getCreditoNoAprobado() {
		return creditoNoAprobado;
	}

	public void setCreditoNoAprobado(Boolean creditoNoAprobado) {
		this.creditoNoAprobado = creditoNoAprobado;
	}
	
	@Persistent
    private float montoAprobado;

	public float getMontoAprobado() {
		return montoAprobado;
	}

	public void setMontoAprobado(float montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	@Persistent
    private String observacionNoAprobado;
	
	public String getObservacionNoAprobado() {
		return observacionNoAprobado;
	}

	public void setObservacionNoAprobado(String observacionNoAprobado) {
		this.observacionNoAprobado = observacionNoAprobado;
	}

	@Persistent
    private Boolean PrimeraSupervision;

	public Boolean getPrimeraSupervision() {
		return PrimeraSupervision;
	}

	public void setPrimeraSupervision(Boolean primeraSupervision) {
		PrimeraSupervision = primeraSupervision;
	}

	@Persistent
    private Boolean SegundaSupervision;
	
	public Boolean getSegundaSupervision() {
		return SegundaSupervision;
	}

	public void setSegundaSupervision(Boolean segundaSupervision) {
		SegundaSupervision = segundaSupervision;
	}

	@Persistent
    private Boolean TerceraSupervision;
	
	public Boolean getTerceraSupervision() {
		return TerceraSupervision;
	}

	public void setTerceraSupervision(Boolean terceraSupervision) {
		TerceraSupervision = terceraSupervision;
	}

	@Persistent
    private Boolean CuartaSupervision;
	
	public Boolean getCuartaSupervision() {
		return CuartaSupervision;
	}

	public void setCuartaSupervision(Boolean cuartaSupervision) {
		CuartaSupervision = cuartaSupervision;
	}
	
	@Persistent
    private Boolean UbicacionSupervision;

	public Boolean getUbicacionSupervision() {
		return UbicacionSupervision;
	}

	public void setUbicacionSupervision(Boolean ubicacionSupervision) {
		UbicacionSupervision = ubicacionSupervision;
	}
	
	@Persistent    
    private String URLFile;

	public String getURLFile() {
		return URLFile;
	}

	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}

	@Persistent    
    private String KeyFile;

	public String getKeyFile() {
		return KeyFile;
	}

	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}

	@Persistent
    private String departamentoMunicipioDireccionActual;

	public String getDepartamentoMunicipioDireccionActual() {
		return departamentoMunicipioDireccionActual;
	}

	public void setDepartamentoMunicipioDireccionActual(
			String departamentoMunicipioDireccionActual) {
		this.departamentoMunicipioDireccionActual = departamentoMunicipioDireccionActual;
	}

	@Persistent
    private String departamentoMunicipioDireccionSolucion;
	
	public String getDepartamentoMunicipioDireccionSolucion() {
		return departamentoMunicipioDireccionSolucion;
	}

	public void setDepartamentoMunicipioDireccionSolucion(
			String departamentoMunicipioDireccionSolucion) {
		this.departamentoMunicipioDireccionSolucion = departamentoMunicipioDireccionSolucion;
	}
	
	@Persistent
    private String aldeaDireccionActual;
	
	public String getAldeaDireccionActual() {
		return aldeaDireccionActual;
	}

	public void setAldeaDireccionActual(String aldeaDireccionActual) {
		this.aldeaDireccionActual = aldeaDireccionActual;
	}

	@Persistent
    private String aldeaDireccionSolucion;
	
	public String getAldeaDireccionSolucion() {
		return aldeaDireccionSolucion;
	}

	public void setAldeaDireccionSolucion(String aldeaDireccionSolucion) {
		this.aldeaDireccionSolucion = aldeaDireccionSolucion;
	}

	@Persistent    
    private String direccionLugarTrabajoSolicitante;
	
	public String getDireccionLugarTrabajoSolicitante() {
		return direccionLugarTrabajoSolicitante;
	}

	public void setDireccionLugarTrabajoSolicitante(
			String direccionLugarTrabajoSolicitante) {
		this.direccionLugarTrabajoSolicitante = direccionLugarTrabajoSolicitante;
	}

	@Persistent    
    private String direccionLugarTrabajoConyuge;

	public String getDireccionLugarTrabajoConyuge() {
		return direccionLugarTrabajoConyuge;
	}

	public void setDireccionLugarTrabajoConyuge(String direccionLugarTrabajoConyuge) {
		this.direccionLugarTrabajoConyuge = direccionLugarTrabajoConyuge;
	}
	
	@Persistent
    private Boolean enConstruccion;
	
	public Boolean getEnConstruccion() {
		return enConstruccion;
	}

	public void setEnConstruccion(Boolean enConstruccion) {
		this.enConstruccion = enConstruccion;
	}

	// Mapeo de Llave Foranea
	
	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudCargaFamiliar> cargaFamiliar;

	public List<SegSolicitudCargaFamiliar> getCargaFamiliar() {
		return cargaFamiliar;
	}

	public void setCargaFamiliar(List<SegSolicitudCargaFamiliar> cargaFamiliar) {
		this.cargaFamiliar = cargaFamiliar;
	}

	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudReferenciaFamiliar> referenciaFamiliar;

	public List<SegSolicitudReferenciaFamiliar> getReferenciaFamiliar() {
		return referenciaFamiliar;
	}

	public void setReferenciaFamiliar(
			List<SegSolicitudReferenciaFamiliar> referenciaFamiliar) {
		this.referenciaFamiliar = referenciaFamiliar;
	}
	
	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudDatosVivienda> datosVivienda;

	public List<SegSolicitudDatosVivienda> getDatosVivienda() {
		return datosVivienda;
	}

	public void setDatosVivienda(List<SegSolicitudDatosVivienda> datosVivienda) {
		this.datosVivienda = datosVivienda;
	}

	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudSituacionEconomica> situacionEconomica;

	public List<SegSolicitudSituacionEconomica> getSituacionEconomica() {
		return situacionEconomica;
	}

	public void setSituacionEconomica(
			List<SegSolicitudSituacionEconomica> situacionEconomica) {
		this.situacionEconomica = situacionEconomica;
	}
	
	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudGarantiaHipotecaria> garantiaHipotecaria;

	public List<SegSolicitudGarantiaHipotecaria> getGarantiaHipotecaria() {
		return garantiaHipotecaria;
	}

	public void setGarantiaHipotecaria(
			List<SegSolicitudGarantiaHipotecaria> garantiaHipotecaria) {
		this.garantiaHipotecaria = garantiaHipotecaria;
	}

	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudGarantiaFiduciaria> garantiaFiduciaria;
	
	public List<SegSolicitudGarantiaFiduciaria> getGarantiaFiduciaria() {
		return garantiaFiduciaria;
	}

	public void setGarantiaFiduciaria(
			List<SegSolicitudGarantiaFiduciaria> garantiaFiduciaria) {
		this.garantiaFiduciaria = garantiaFiduciaria;
	}

	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudGarantiaSolidario> garantiaSolidario;
	
	public List<SegSolicitudGarantiaSolidario> getGarantiaSolidario() {
		return garantiaSolidario;
	}

	public void setGarantiaSolidario(
			List<SegSolicitudGarantiaSolidario> garantiaSolidario) {
		this.garantiaSolidario = garantiaSolidario;
	}

	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudSupervisionPrimera> supervisionPrimera;

	public List<SegSolicitudSupervisionPrimera> getSupervisionPrimera() {
		return supervisionPrimera;
	}

	public void setSupervisionPrimera(
			List<SegSolicitudSupervisionPrimera> supervisionPrimera) {
		this.supervisionPrimera = supervisionPrimera;
	}

	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudSupervisionSegunda> supervisionSegunda;

	public List<SegSolicitudSupervisionSegunda> getSupervisionSegunda() {
		return supervisionSegunda;
	}

	public void setSupervisionSegunda(
			List<SegSolicitudSupervisionSegunda> supervisionSegunda) {
		this.supervisionSegunda = supervisionSegunda;
	}
	
	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudSupervisionTercera> supervisionTercera;

	public List<SegSolicitudSupervisionTercera> getSupervisionTercera() {
		return supervisionTercera;
	}

	public void setSupervisionTercera(
			List<SegSolicitudSupervisionTercera> supervisionTercera) {
		this.supervisionTercera = supervisionTercera;
	}
	
	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudSupervisionCuarta> supervisionCuarta;

	public List<SegSolicitudSupervisionCuarta> getSupervisionCuarta() {
		return supervisionCuarta;
	}

	public void setSupervisionCuarta(
			List<SegSolicitudSupervisionCuarta> supervisionCuarta) {
		this.supervisionCuarta = supervisionCuarta;
	}

	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudSupervisionUbicacion> supervisionUbicacion;

	public List<SegSolicitudSupervisionUbicacion> getSupervisionUbicacion() {
		return supervisionUbicacion;
	}

	public void setSupervisionUbicacion(
			List<SegSolicitudSupervisionUbicacion> supervisionUbicacion) {
		this.supervisionUbicacion = supervisionUbicacion;
	}
	
	@Persistent(mappedBy = "solicitud")
	@Element(dependent = "true")
	private List <SegSolicitudEncuestaSatisfaccion> encuestaSatisfaccion;

	public List<SegSolicitudEncuestaSatisfaccion> getEncuestaSatisfaccion() {
		return encuestaSatisfaccion;
	}

	public void setEncuestaSatisfaccion(
			List<SegSolicitudEncuestaSatisfaccion> encuestaSatisfaccion) {
		this.encuestaSatisfaccion = encuestaSatisfaccion;
	}


}
