
package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Registro")
public interface SolucionesConstruidasService extends RemoteService {
	
	// DATOS SOLICITANTE		
	
	Long ingresarDatosSolicitante(Long idEmpleado, Long idAfiliado,
			Date fecrec, String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
			String profesionOficio, int dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
			Boolean garantia, Boolean aprobacion, 
			Boolean primeraSupervision, Boolean segundaSupervision, Boolean terceraSupervision, Boolean cuartaSupervision) throws IllegalArgumentException;

	Long actualizarDatosSolicitante(Long idFormulario, Long idEmpleado, Long idAfiliado,
			 String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
				String profesionOficio, int dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
				String direccionActual, String direccionSolucion, 
				Boolean camion, Boolean carro, Boolean peatonal,
				String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
				String solucionConstruir, float cuotaPagar,
				String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge)  throws IllegalArgumentException;	
	
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
			String nombreNotario, int areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			Boolean actualizacionGarantia) throws IllegalArgumentException;
	
	Long actualizarGarantiaHipotecaria(Long idFormulario, Long idGarantiaHipotecaria,
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, int areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona)  throws IllegalArgumentException;		
	

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
	
// SOLUCIONES
    
    List<AuxSolicitudGeneral> buscarFormulario(char tipo, Long idEmpleado, Long idAfiliado, String nombreSolicitante, String solucionConstruir) throws IllegalArgumentException; 
    
    AuxSolicitudGeneral obtenerDataFormularioRegistrado(Long idFormulario) throws IllegalArgumentException;
    
    /**
     * 
     * @param fileURL
     * @return
     * @throws IllegalArgumentException
     */
    String remove(String fileURL)throws IllegalArgumentException;
    
}

