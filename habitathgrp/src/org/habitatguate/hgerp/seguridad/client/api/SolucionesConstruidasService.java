
package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Registro")
public interface SolucionesConstruidasService extends RemoteService {
	
	// DATOS SOLICITANTE		
	
	Long ingresarDatosSolicitante(Long idEmpleado, Long idAfiliado, String usrName,
			Date fecrec, 
			String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
			String profesionOficio, String dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
			Boolean garantia, Boolean creditoAprobado, Boolean creditoNoAprobado, float montoAprobado, String observacionNoAprobado,
			Boolean primeraSupervision, Boolean segundaSupervision, Boolean terceraSupervision, Boolean cuartaSupervision,			
			String aldeaDireccionActual, String aldeaDireccionSolucion,
			String departamentoMunicipioDireccionActual, String departamentoMunicipioDireccionSolucion,
			String direccionLugarTrabajoSolicitante, String direccionLugarTrabajoConyuge) throws IllegalArgumentException;

	Long actualizarDatosSolicitante(Long idFormulario, Long idEmpleado, Long idAfiliado, String usrName,
				Date fecupdate,
			 	String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
				String profesionOficio, String dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
				String direccionActual, String direccionSolucion, 
				Boolean camion, Boolean carro, Boolean peatonal,
				String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
				String solucionConstruir, float cuotaPagar,
				String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
				String aldeaDireccionActual, String aldeaDireccionSolucion,
				String departamentoMunicipioDireccionActual, String departamentoMunicipioDireccionSolucion,
				String direccionLugarTrabajoSolicitante, String direccionLugarTrabajoConyuge) throws IllegalArgumentException;	
	
// CARGAS FAMILIARES 	
	
	Long ingresarCargaFamiliar(Date fecrec, Long idFormulario, 
			String nombreFamiliar, int edadFamiliar, String escolaridadFamiliar, String ocupacionFamiliar) throws IllegalArgumentException;
    
	Long actualizarCargaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
			 String nombreFamiliar, int edadFamiliar, 
			 String escolaridadFamiliar, String ocupacionFamiliar)  throws IllegalArgumentException;	
	
	Long eliminarCargaFamiliar(Long idFormulario, Long id)throws IllegalArgumentException;	
	
// REFERENCIAS FAMILIARES	 	
	
		Long ingresarReferenciaFamiliar(Date fecrec, Long idFormulario, 
				String nombreFamiliar, int edadFamiliar, String escolaridadFamiliar, String ocupacionFamiliar) throws IllegalArgumentException;
	    
		Long actualizarReferenciaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
				 String nombreFamiliar, int telefonoFamiliar, 
				 String parentescoFamiliar, String direccionFamiliar)  throws IllegalArgumentException;	
		
		Long eliminarReferenciaFamiliar(Long idFormulario, Long id)throws IllegalArgumentException;		
	
	
// DATOS VIVIENDA ACTUAL	
	
	Long ingresarDatosVivienda(Date fecrec, Long idFormulario, 
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles) throws IllegalArgumentException;
	
	Long actualizarDatosViviendaActual(Long idFormulario, Long idDatosVivienda,
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles)  throws IllegalArgumentException;	
	

// SITUACION ECONOMICA
	
	Long ingresarSituacionEconomica(Date fecrec, Long idFormulario, 
			float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales) throws IllegalArgumentException;
	
	Long actualizarSituacionEconomica(Long idFormulario, Long idDatosVivienda,
			float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales)  throws IllegalArgumentException;		
	
	
// GARANTIA HIPOTECARIA	
	
	Long ingresarGarantiaHipotecaria(Date fecrec, Long idFormulario, 
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, float areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			Boolean actualizacionGarantia,
			String numDpiPersona, String direccionTerrenoPersona, String aldeaPersona, String departamentoMunicipioDireccionPersona) throws IllegalArgumentException;
	
	Long actualizarGarantiaHipotecaria(Long idFormulario, Long idGarantiaHipotecaria,
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, float areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			String numDpiPersona, String direccionTerrenoPersona, String aldeaPersona, String departamentoMunicipioDireccionPersona) throws IllegalArgumentException;		
	

// GARANTIA FIDUCIARIA	

	Long ingresarGarantiaFiduciaria(Date fecrec, Long idFormulario, 
			String nombre, String numDpi,
			String estadoCivil, int edad, String nacionalidad,
			String actividad,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
			String direccionActual, String lugarTrabajo,
			int telefonoCasa, int telefonoTrabajo,
			String profesionOficio, String direccionLugarTrabajo, String correo,
			int numeroCelular, String telefonoInternacional) throws IllegalArgumentException;

	Long actualizarGarantiaFiduciaria(Long idFormulario, Long idGarantiaHipotecaria,
			String nombre, String numDpi, 
			String estadoCivil, int edad, String nacionalidad,
			String actividad,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
			String direccionActual, String lugarTrabajo,
			int telefonoCasa, int telefonoTrabajo,
			String profesionOficio, String direccionLugarTrabajo, String correo,
			int numeroCelular, String telefonoInternacional)  throws IllegalArgumentException;
	
	Long eliminarGarantiaFiduciaria(Long idFormulario, Long id)throws IllegalArgumentException;		
	
// GARANTIA GRUPO SOLIDARIO	
	
		Long ingresarGarantiaSolidario(Date fecrec, Long idFormulario, 
				String nombre, String numDpi,
				String estadoCivil, int edad, String nacionalidad,
				String actividad,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
				String direccionActual, String lugarTrabajo,
				int telefonoCasa, int telefonoTrabajo,
				String profesionOficio, String direccionLugarTrabajo, String correo,
				int numeroCelular, String telefonoInternacional) throws IllegalArgumentException;
	    
		Long actualizarGarantiaSolidario(Long idFormulario, Long idGarantiaSolidario,
				String nombre, String numDpi, 
				String estadoCivil, int edad, String nacionalidad,
				String actividad,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
				String direccionActual, String lugarTrabajo,
				int telefonoCasa, int telefonoTrabajo,
				String profesionOficio, String direccionLugarTrabajo, String correo,
				int numeroCelular, String telefonoInternacional)  throws IllegalArgumentException;	
		
		Long eliminarGarantiaSolidario(Long idFormulario, Long id)throws IllegalArgumentException;		
	
// SUPERVISION PRIMERA
	
	Long ingresarSupervisionPrimera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;	

	Long actualizarSupervisionPrimera(Long idFormulario, Long idSupervisionPrimera,
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;
	
// SUPERVISION SEGUNDA

	Long ingresarSupervisionSegunda(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;	

	Long actualizarSupervisionSegunda(Long idFormulario, Long idSupervisionSegunda,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;

// SUPERVISION TERCERA

	Long ingresarSupervisionTercera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;	

	Long actualizarSupervisionTercera(Long idFormulario, Long idSupervisionTercera,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;
	
	// SUPERVISION CUARTA

	Long ingresarSupervisionCuarta(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;	

	Long actualizarSupervisionCuarta(Long idFormulario, Long idSupervisionCuarta,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException;	
	
	// SUPERVISION UBICACION

	Long ingresarSupervisionUbicacion(Date fecrec, Long idFormulario, 
			String latitud, String longitud) throws IllegalArgumentException;	

	Long actualizarSupervisionUbicacion(Long idFormulario, Long idSupervisionUbicacion,
			String latitud, String longitud) throws IllegalArgumentException;	

	// ENCUESTA SATISFACCION

	Long ingresarEncuestaSatisfaccion(Date fecrec, Long idFormulario, 
			String preguntaNo1, String preguntaNo2, String preguntaNo3, String preguntaNo4,
			String preguntaNo5, String preguntaNo6, String preguntaNo7, String preguntaNo8,
			String preguntaNo9, String preguntaNo10, String preguntaNo11, String preguntaNo12,
			String preguntaNo13, String preguntaNo14, String preguntaNo15, String preguntaNo16,
			String departamento) throws IllegalArgumentException;
	
	Long actualizarEncuestaSatisfaccion(Long idFormulario, Long idEncuestaSatisfaccion,
			String preguntaNo1, String preguntaNo2, String preguntaNo3, String preguntaNo4,
			String preguntaNo5, String preguntaNo6, String preguntaNo7, String preguntaNo8,
			String preguntaNo9, String preguntaNo10, String preguntaNo11, String preguntaNo12,
			String preguntaNo13, String preguntaNo14, String preguntaNo15, String preguntaNo16,
			String departamento) throws IllegalArgumentException;
	
	// BURO CREDITO
	
	Long actualizarDatosAprobacionBuroCredito(Long idFormulario,
			Boolean creditoAprobado, Boolean creditoNoAprobado, float montoAprobado, String observacionNoAprobado,
			String  URLFile, String KeyFile) throws IllegalArgumentException;
	
	
	// SOLUCIONES
    
    List<AuxSolicitudGeneral> buscarFormulario(char tipo, Long idEmpleado, Long idAfiliado, String nombreSolicitante, String solucionConstruir) throws IllegalArgumentException; 
    
    AuxSolicitudGeneral obtenerDataFormularioRegistrado(Long idFormulario) throws IllegalArgumentException;
    
    AuxSolicitudEncuestaSatisfaccion consultaEncuestaSatisfaccion(Long idFormulario, Long idEncuestaSatisfaccion) throws IllegalArgumentException;
    
    AuxEmpleado consultaEmpleadoRegistrado(Long idEmpleado) throws IllegalArgumentException;
    
    AuxEmpleado consultaEmpleadoAsignacion(String idEmpleado) throws IllegalArgumentException;
    
    String asignarSolicitud(Long idFormulario, Long idEmpleado, String usrName)throws IllegalArgumentException;
    
    // Remover imagen de Blobstore
    
    String remove(String fileURL)throws IllegalArgumentException;
    
}

