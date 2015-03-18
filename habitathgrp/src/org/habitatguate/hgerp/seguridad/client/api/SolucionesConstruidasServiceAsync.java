
package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface SolucionesConstruidasServiceAsync {
	
// DATOS SOLICITANTE	
	
	void ingresarDatosSolicitante(Long idEmpleado, Long idAfiliado,
			Date fecrec, String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
			String profesionOficio, int dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
			Boolean garantia, Boolean aprobacion, 
			Boolean primeraSupervision, Boolean segundaSupervision, Boolean terceraSupervision, Boolean cuartaSupervision,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	 void actualizarDatosSolicitante(Long idFormulario, Long idEmpleado, Long idAfiliado,
			 String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
				String profesionOficio, int dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
				String direccionActual, String direccionSolucion, 
				Boolean camion, Boolean carro, Boolean peatonal,
				String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
				String solucionConstruir, float cuotaPagar,
				String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
				AsyncCallback<Long> callback) throws IllegalArgumentException;	

// CARGAS FAMILIARES
	 
		void ingresarCargaFamiliar(Date fecrec, Long idFormulario, 
				String nombreFamiliar, int edadFamiliar, String escolaridadFamiliar, String ocupacionFamiliar,
				AsyncCallback<Long> callback) throws IllegalArgumentException;

		void actualizarCargaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
				 String nombreFamiliar, int edadFamiliar, 
				 String escolaridadFamiliar, String ocupacionFamiliar,
					AsyncCallback<Long> callback)  throws IllegalArgumentException;	
		
		void eliminarCargaFamiliar(Long idFormulario, Long id, AsyncCallback<Long> callback) throws IllegalArgumentException;		 
	 
// REFERENCIAS FAMILIARES
	 
	void ingresarReferenciaFamiliar(Date fecrec, Long idFormulario, 
			String nombreFamiliar, int edadFamiliar, String escolaridadFamiliar, String ocupacionFamiliar,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarReferenciaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
			 String nombreFamiliar, int telefonoFamiliar, 
			 String parentescoFamiliar, String direccionFamiliar,
				AsyncCallback<Long> callback)  throws IllegalArgumentException;	
	
	void eliminarReferenciaFamiliar(Long idFormulario, Long id, AsyncCallback<Long> callback) throws IllegalArgumentException;	
	
// DATOS VIVIENDA ACTUAL	
	
	void ingresarDatosVivienda(Date fecrec, Long idFormulario, 
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void actualizarDatosViviendaActual(Long idFormulario, Long idDatosVivienda,
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
// SITUACION ECONOMICA

	void ingresarSituacionEconomica(Date fecrec, Long idFormulario, 
			float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales,
			AsyncCallback<Long> callback) throws IllegalArgumentException;	
	
	void actualizarSituacionEconomica(Long idFormulario, Long idDatosVivienda,
			float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
// GARANTIA HIPOTECARIA
	
	void ingresarGarantiaHipotecaria(Date fecrec, Long idFormulario, 
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, int areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			Boolean actualizacionGarantia,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void actualizarGarantiaHipotecaria(Long idFormulario, Long idGarantiaHipotecaria,
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, int areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			AsyncCallback<Long> callback)  throws IllegalArgumentException;
	
// SUPERVISION PRIMERA
	
	void ingresarSupervisionPrimera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void actualizarSupervisionPrimera(Long idFormulario, Long idSupervisionPrimera,
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		

// SUPERVISION SEGUNDA

	void ingresarSupervisionSegunda(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionSegunda(Long idFormulario, Long idSupervisionSegunda,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
// SUPERVISION TERCERA

	void ingresarSupervisionTercera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionTercera(Long idFormulario, Long idSupervisionTercera,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
	// SUPERVISION CUARTA

	void ingresarSupervisionCuarta(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionCuarta(Long idFormulario, Long idSupervisionCuarta,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
	// SUPERVISION UBICACION

	void ingresarSupervisionUbicacion(Date fecrec, Long idFormulario, 
			String latitud, String longitud,
			AsyncCallback<Long> callback) throws IllegalArgumentException;

	void actualizarSupervisionUbicacion(Long idFormulario, Long idSupervisionUbicacion,
			String latitud, String longitud,
			AsyncCallback<Long> callback) throws IllegalArgumentException;		
	
    // SOLUCIONES
 
	void buscarFormulario(char tipo, Long idEmpleado, Long idAfiliado, String nombreSolicitante, String solucionConstruir,
			AsyncCallback<List<AuxSolicitudGeneral>> callback) throws IllegalArgumentException;
    
	 void obtenerDataFormularioRegistrado(Long idFormulario, AsyncCallback<AuxSolicitudGeneral> callback)throws IllegalArgumentException;
		
	// Remover imagen de Blobstore
	 
	 void remove(String fileURL,AsyncCallback<String> callback)throws IllegalArgumentException;

}
