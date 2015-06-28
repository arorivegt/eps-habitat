package org.habitatguate.hgerp.seguridad.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudCargaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaSolidario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSituacionEconomica;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionCuarta;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionSegunda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionTercera;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionUbicacion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudCargaFamiliar;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudGarantiaSolidario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSituacionEconomica;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionCuarta;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionSegunda;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionTercera;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionUbicacion;
import org.habitatguate.hgerp.util.PMF;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class SolucionesConstruidasServiceImpl extends RemoteServiceServlet implements SolucionesConstruidasService {

	@Override
	public Long ingresarDatosSolicitante(Long idEmpleado, Long idAfiliado,
			Date fecrec, String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
			String profesionOficio, String dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
			Boolean garantia, Boolean creditoAprobado, Boolean creditoNoAprobado, float montoAprobado, String observacionNoAprobado,
			Boolean primeraSupervision, Boolean segundaSupervision, Boolean terceraSupervision, Boolean cuartaSupervision) throws IllegalArgumentException {

		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		SegSolicitudGeneral solicitud = new SegSolicitudGeneral();
		solicitud.setIdEmpleado(idEmpleado);
		solicitud.setIdAfiliado(idAfiliado);
		solicitud.setFecrec(fecrec); 
		solicitud.setNombreSolicitante(nombreSolicitante);
		solicitud.setEstadoCivil(estadoCivil);
		solicitud.setEdad(edad);
		solicitud.setNacionalidad(nacionalidad);
		solicitud.setProfesionOficio(profesionOficio);
		solicitud.setNumDpi(dpi);
		solicitud.setNumDpiUnico(dpiUnico);
		solicitud.setNumDpiReferencia(dpiReferencia);
		solicitud.setActividadEconomica(actividadEconomica);
		solicitud.setCheckLeer(sabeLeer);
		solicitud.setCheckEscribir(sabeEscribir);
		solicitud.setCheckFirmar(sabeFirmar);
		solicitud.setDireccionActual(direccionActual);
		solicitud.setDireccionSolucion(direccionSolucion);
		solicitud.setCheckCamion(camion);
		solicitud.setCheckCarro(carro);
		solicitud.setCheckPeatonal(peatonal);
		solicitud.setLugarTrabajoSolicitante(lugarTrabajoSolicitante);
		solicitud.setTelefonoCasaSolicitante(telefonoCasaSolicitante);
		solicitud.setTelefonoTrabajoSolicitante(telefonoTrabajoSolicitante);
		solicitud.setSolucionConstruir(solucionConstruir);
		solicitud.setCuotaPagar(cuotaPagar);
		solicitud.setNombreConyuge(nombreConyuge);
		solicitud.setTelefonoConyuge(telefonoConyuge);
		solicitud.setLugarTrabajoConyuge(lugarTrabajoConyuge);
		solicitud.setTelefonoTrabajoConyuge(telefonoTrabajoConyuge);
		solicitud.setGarantia(garantia);										// Existe Garantia
		solicitud.setCreditoAprobado(creditoAprobado);							// Credito Aprobado Solicitud
		solicitud.setCreditoNoAprobado(creditoNoAprobado);						// Credito No Solicitud
		solicitud.setMontoAprobado(montoAprobado);								// Monto Aprobado
		solicitud.setObservacionNoAprobado(observacionNoAprobado);				// Observacion No Aprobado
		solicitud.setPrimeraSupervision(primeraSupervision);					// Existe Primera Supervision	
		solicitud.setSegundaSupervision(segundaSupervision);					// Existe Segunda Supervision
		solicitud.setTerceraSupervision(terceraSupervision);					// Existe Tercera Supervision
		solicitud.setCuartaSupervision(cuartaSupervision);						// Existe Cuarta Supervision		

		try { 
			gestorPersistencia.makePersistent(solicitud); 
			valor = solicitud.getIdFormulario();
			System.out.println("NUEVA SOLICITUD ALMACENADA CORRECTAMENTE EN DATASTORE");

		}finally {  
			gestorPersistencia.close();  
		}
		return valor;
	}	

// CARGAS FAMILIARES	
	
	@Override
	public Long ingresarCargaFamiliar(Date fecrec, Long idFormulario, 
			String nombreFamiliar, int edadFamiliar, String escolaridadFamiliar, String ocupacionFamiliar)
					throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudCargaFamiliar carga = new  SegSolicitudCargaFamiliar();

			carga.setFecrec(fecrec); 
			carga.setNombreFamiliar(nombreFamiliar);
			carga.setEdadFamiliar(edadFamiliar);
			carga.setEscolaridadFamiliar(escolaridadFamiliar);
			carga.setOcupacionFamiliar(ocupacionFamiliar);
			carga.setIdFormulario(idFormulario); // Llave Foranea

			carga.setSolicitud(solicitud);	// Relacion
			solicitud.getCargaFamiliar().add(carga);
			valor = carga.getIdCargaFamiliar();

			System.out.println("CARGA FAMILIAR ALMACENADA CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}	
	
	
// REFERENCIAS FAMILIARES	
	
	@Override
	public Long ingresarReferenciaFamiliar(Date fecrec, Long idFormulario, 
			String nombreFamiliar, int telefonoFamiliar, String parentescoFamiliar, String direccionFamiliar)
					throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudReferenciaFamiliar referencia = new  SegSolicitudReferenciaFamiliar();

			referencia.setFecrec(fecrec); 
			referencia.setNombreFamiliar(nombreFamiliar);
			referencia.setTelefonoFamiliar(telefonoFamiliar);;
			referencia.setParentescoFamiliar(parentescoFamiliar);
			referencia.setDireccionFamiliar(direccionFamiliar);
			referencia.setIdFormulario(idFormulario); // Llave Foranea

			referencia.setSolicitud(solicitud);	// Relacion
			solicitud.getReferenciaFamiliar().add(referencia);
			valor = referencia.getIdReferenciaFamiliar();

			System.out.println("REFERENCIA FAMILIAR ALMACENADA CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}

// DATOS VIVIENDA ACTUAL	
	
	@Override
	public Long ingresarDatosVivienda(Date fecrec, Long idFormulario, 
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudDatosVivienda vivienda = new  SegSolicitudDatosVivienda();

			vivienda.setFecrec(fecrec); 
			vivienda.setDatoVivienda(datosVivienda);
			vivienda.setOtroDatoVivienda(otroDatosVivienda);
			vivienda.setTecho(techo);
			vivienda.setPared(pared);
			vivienda.setCocina(cocina);
			vivienda.setCheckAgua(servicioAgua);
			vivienda.setCheckDrenaje(servicioDrenaje);
			vivienda.setCheckElectricidad(servicioElectricidad);
			vivienda.setCheckSanitario(servicioSanitario);
			vivienda.setBienesInmuebles(bienesInmuebles);
			vivienda.setValorInmueble(valorInmuebles);
			vivienda.setIdFormulario(idFormulario); // Llave Foranea

			vivienda.setSolicitud(solicitud); // Relacion
			solicitud.getDatosVivienda().add(vivienda);
			valor = vivienda.getIdDatosVivienda();

			System.out.println("DATOS VIVIENDA ACTUAL ALMACENADA CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}	
	
	// SITUACION ECONOMICA
	
		@Override
		public Long ingresarSituacionEconomica(Date fecrec, Long idFormulario, 
				float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
				float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
				float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
				float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales) throws IllegalArgumentException {

			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			Long valor = 0L;

			try { 
				final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
				SegSolicitudSituacionEconomica situacion = new  SegSolicitudSituacionEconomica();

				situacion.setFecrec(fecrec); 
				situacion.setIngresosSolicitante(ingresosSolicitante);
				situacion.setIngresosConyuge(ingresosConyuge);
				situacion.setOtrosIngresos(otrosIngresos);
				situacion.setIngresosTotales(ingresosTotales);
				situacion.setTotalIngresos(totalIngresos);
				situacion.setTotalEgresos(totalEgresos);
				situacion.setDiferencia(diferencia);
				situacion.setPagosBuro(pagosBuro);
				situacion.setCuota(cuota);
				situacion.setExcedente(excedente);
				situacion.setAlquilerVivienda(alquilerVivienda);
				situacion.setAlimentacion(alimentacion);
				situacion.setRopa(ropa);
				situacion.setGastosMedicos(gastosMedicos);
				situacion.setTransporte(transporte);
				situacion.setEducacion(educacion);
				situacion.setPagoLuzAgua(pagoLuzAgua);
				situacion.setPagoPrestamos(pagoPrestamos);
				situacion.setOtrosGastos1(otrosGastos1);
				situacion.setOtrosGastos2(otrosGastos2);
				situacion.setEgresosTotales(egresosTotales);
				situacion.setIdFormulario(idFormulario); // Llave Foranea

				situacion.setSolicitud(solicitud); // Relacion
				solicitud.getSituacionEconomica().add(situacion);
				valor = situacion.getIdSituacionEconomica();

				System.out.println("DATOS SITUACION ECONOMICA ALMACENADA CORRECTAMENTE EN DATASTORE");

			}finally {  
				Persistencia.close();  
			}
			return valor ;
		}		
	

// GARANTIA HIPOTECARIA
	
	@Override
	public Long ingresarGarantiaHipotecaria(Date fecrec, Long idFormulario, 
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, int areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona,
			Boolean actualizacionGarantia) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudGarantiaHipotecaria documento = new  SegSolicitudGarantiaHipotecaria();

			documento.setFecrec(fecrec); 
			documento.setEscrituraNoRegistrada(escrituraNoRegistrada);
			documento.setEscrituraRegistrada(escrituraRegistrada);
			documento.setFolioEscritura(folio);
			documento.setLibroEscritura(libro);
			documento.setFincaEscritura(finca);
			documento.setNombreNotario(nombreNotario);
			documento.setAreaTerreno(areaTerreno);
			documento.setValorEstimado(valorTerreno);
			documento.setCheckSi(checkSi);
			documento.setCheckNo(checkNo);
			documento.setNombrePersona(nombrePersona);
			documento.setTelefonoPersona(telefonoPersona);
			documento.setIdFormulario(idFormulario); // Llave Foranea

			documento.setSolicitud(solicitud); // Relacion
			solicitud.getGarantiaHipotecaria().add(documento);
			
			solicitud.setGarantia(actualizacionGarantia); // Actualizacion de Valor. Existe Garantia en Solicitud
			
			valor = documento.getIdDocumentoPropiedad();

			System.out.println("DATOS GARANTIA HIPOTECARIA ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}	
	
// GARANTIA FIDUCIARIA	
	
		@Override
		public Long ingresarGarantiaFiduciaria(Date fecrec, Long idFormulario, 
				String nombre, 
				String estadoCivil, int edad, String nacionalidad,
				String actividad,
				Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
				String direccionActual, String lugarTrabajo,
				int telefonoCasa, int telefonoTrabajo) throws IllegalArgumentException {

			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			Long valor = 0L;

			try { 
				final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
				SegSolicitudGarantiaFiduciaria fiduciaria = new  SegSolicitudGarantiaFiduciaria();

				fiduciaria.setFecrec(fecrec); 
				fiduciaria.setNombre(nombre);
				fiduciaria.setEstadoCivil(estadoCivil);
				fiduciaria.setEdad(edad);
				fiduciaria.setNacionalidad(nacionalidad);
				fiduciaria.setActividadEconomica(actividad);
				fiduciaria.setCheckLeer(sabeLeer);
				fiduciaria.setCheckEscribir(sabeEscribir);
				fiduciaria.setCheckFirmar(sabeFirmar);
				fiduciaria.setDireccionActual(direccionActual);
				fiduciaria.setLugarTrabajo(lugarTrabajo);
				fiduciaria.setTelefonoCasa(telefonoCasa);
				fiduciaria.setTelefonoTrabajo(telefonoTrabajo);
				fiduciaria.setIdFormulario(idFormulario); // Llave Foranea

				fiduciaria.setSolicitud(solicitud);	// Relacion
				solicitud.getGarantiaFiduciaria().add(fiduciaria);
				valor = fiduciaria.getIdGarantiaFiduciaria();

				System.out.println("GARANTIA FIDUCIARIA ALMACENADA CORRECTAMENTE EN DATASTORE");

			}finally {  
				Persistencia.close();  
			}
			return valor ;
		}	
	
	// GARANTIA GRUPO SOLIDARIO	

		@Override
		public Long ingresarGarantiaSolidario(Date fecrec, Long idFormulario, 
				String nombre, int edad, String escolaridad, String ocupacion)
						throws IllegalArgumentException {

			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			Long valor = 0L;

			try { 
				final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
				SegSolicitudGarantiaSolidario solidario = new  SegSolicitudGarantiaSolidario();

				solidario.setFecrec(fecrec); 
				solidario.setNombre(nombre);
				solidario.setEdad(edad);
				solidario.setEscolaridad(escolaridad);
				solidario.setOcupacion(ocupacion);
				solidario.setIdFormulario(idFormulario); // Llave Foranea

				solidario.setSolicitud(solicitud);	// Relacion
				solicitud.getGarantiaSolidario().add(solidario);
				valor = solidario.getIdGarantiaSolidario();

				System.out.println("GRUPO SOLIDARIO ALMACENADO CORRECTAMENTE EN DATASTORE");

			}finally {  
				Persistencia.close();  
			}
			return valor ;
		}			
		

	// SUPERVISION PRIMERA

	@Override
	public Long ingresarSupervisionPrimera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudSupervisionPrimera primera = new  SegSolicitudSupervisionPrimera();

			primera.setFecrec(fecrec); 
			primera.setFechaVisita(fechaVisita);
			primera.setCheckSi(checkSi);
			primera.setCheckNo(checkNo);
			primera.setObservaciones(observaciones);
			primera.setAcciones(acciones);
			primera.setCheckSatisfactoria(satisfactoria);
			primera.setCheckNoSatisfactoria(noSatisfactoria);
			primera.setPromotor(promotor);
			primera.setAlbanil(albanil);
			primera.setRepresentante(representante);
			primera.setURLFile(URLFile);
			primera.setKeyFile(KeyFile);
			primera.setIdFormulario(idFormulario); // Llave Foranea

			primera.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionPrimera().add(primera);

			solicitud.setPrimeraSupervision(true); // Actualizacion de Valor. Existe Supervision en Solicitud

			valor = primera.getIdSupervisionPrimera();

			System.out.println("DATOS PRIMERA SUPERVISION ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}		
	
	// SUPERVISION SEGUNDA

	@Override
	public Long ingresarSupervisionSegunda(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudSupervisionSegunda segunda = new  SegSolicitudSupervisionSegunda();

			segunda.setFecrec(fecrec); 
			segunda.setFechaVisita(fechaVisita);
			segunda.setObservaciones(observaciones);
			segunda.setAcciones(acciones);
			segunda.setCheckSatisfactoria(satisfactoria);
			segunda.setCheckNoSatisfactoria(noSatisfactoria);
			segunda.setPromotor(promotor);
			segunda.setAlbanil(albanil);
			segunda.setRepresentante(representante);
			segunda.setURLFile(URLFile);
			segunda.setKeyFile(KeyFile);
			segunda.setIdFormulario(idFormulario); // Llave Foranea

			segunda.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionSegunda().add(segunda);

			solicitud.setSegundaSupervision(true); // Actualizacion de Valor. Existe Supervision en Solicitud

			valor = segunda.getIdSupervisionSegunda();

			System.out.println("DATOS SEGUNDA SUPERVISION ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}		
	
	// SUPERVISION TERCERA

	@Override
	public Long ingresarSupervisionTercera(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudSupervisionTercera tercera = new  SegSolicitudSupervisionTercera();

			tercera.setFecrec(fecrec); 
			tercera.setFechaVisita(fechaVisita);
			tercera.setObservaciones(observaciones);
			tercera.setAcciones(acciones);
			tercera.setCheckSatisfactoria(satisfactoria);
			tercera.setCheckNoSatisfactoria(noSatisfactoria);
			tercera.setPromotor(promotor);
			tercera.setAlbanil(albanil);
			tercera.setRepresentante(representante);
			tercera.setURLFile(URLFile);
			tercera.setKeyFile(KeyFile);
			tercera.setIdFormulario(idFormulario); // Llave Foranea

			tercera.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionTercera().add(tercera);

			solicitud.setTerceraSupervision(true); // Actualizacion de Valor. Existe Supervision en Solicitud

			valor = tercera.getIdSupervisionTercera();

			System.out.println("DATOS TERCERA SUPERVISION ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}			
	
	// SUPERVISION CUARTA

	@Override
	public Long ingresarSupervisionCuarta(Date fecrec, Long idFormulario, 
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudSupervisionCuarta cuarta = new  SegSolicitudSupervisionCuarta();

			cuarta.setFecrec(fecrec); 
			cuarta.setFechaVisita(fechaVisita);
			cuarta.setObservaciones(observaciones);
			cuarta.setAcciones(acciones);
			cuarta.setCheckSatisfactoria(satisfactoria);
			cuarta.setCheckNoSatisfactoria(noSatisfactoria);
			cuarta.setPromotor(promotor);
			cuarta.setAlbanil(albanil);
			cuarta.setRepresentante(representante);
			cuarta.setURLFile(URLFile);
			cuarta.setKeyFile(KeyFile);
			cuarta.setIdFormulario(idFormulario); // Llave Foranea

			cuarta.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionCuarta().add(cuarta);

			solicitud.setCuartaSupervision(true); // Actualizacion de Valor. Existe Supervision en Solicitud

			valor = cuarta.getIdSupervisionCuarta();

			System.out.println("DATOS CUARTA SUPERVISION ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}	
	
	// SUPERVISION UBICACION

	@Override
	public Long ingresarSupervisionUbicacion(Date fecrec, Long idFormulario, 
			String latitud, String longitud) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudSupervisionUbicacion supervision = new  SegSolicitudSupervisionUbicacion();

			supervision.setFecrec(fecrec); 
			supervision.setLatitud(latitud);
			supervision.setLongitud(longitud);
			supervision.setIdFormulario(idFormulario); // Llave Foranea

			supervision.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionUbicacion().add(supervision);

			valor = supervision.getIdSupervisionUbicacion();

			System.out.println("DATOS UBICACION SUPERVISION ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}	
	
	// ENCUESTA SATISFACCION

	@Override
	public Long ingresarEncuestaSatisfaccion(Date fecrec, Long idFormulario, 
			String preguntaNo1, String preguntaNo2, String preguntaNo3, String preguntaNo4,
			String preguntaNo5, String preguntaNo6, String preguntaNo7, String preguntaNo8,
			String preguntaNo9, String preguntaNo10, String preguntaNo11, String preguntaNo12,
			String preguntaNo13, String preguntaNo14, String preguntaNo15, String preguntaNo16,
			String departamento) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;

		try { 
			final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			SegSolicitudEncuestaSatisfaccion encuesta = new  SegSolicitudEncuestaSatisfaccion();

			encuesta.setFecrec(fecrec); 
			encuesta.setPreguntaNo1(preguntaNo1);
			encuesta.setPreguntaNo2(preguntaNo2);
			encuesta.setPreguntaNo3(preguntaNo3);
			encuesta.setPreguntaNo4(preguntaNo4);
			encuesta.setPreguntaNo5(preguntaNo5);
			encuesta.setPreguntaNo6(preguntaNo6);
			encuesta.setPreguntaNo7(preguntaNo7);
			encuesta.setPreguntaNo8(preguntaNo8);
			encuesta.setPreguntaNo9(preguntaNo9);
			encuesta.setPreguntaNo10(preguntaNo10);
			encuesta.setPreguntaNo11(preguntaNo11);
			encuesta.setPreguntaNo12(preguntaNo12);
			encuesta.setPreguntaNo13(preguntaNo13);
			encuesta.setPreguntaNo14(preguntaNo14);
			encuesta.setPreguntaNo15(preguntaNo15);
			encuesta.setPreguntaNo16(preguntaNo16);
			encuesta.setDepartamento(departamento);
			encuesta.setIdFormulario(idFormulario); // Llave Foranea

			encuesta.setSolicitud(solicitud); // Relacion
			solicitud.getEncuestaSatisfaccion().add(encuesta);

			valor = encuesta.getIdEncuestaSatisfaccion();

			System.out.println("DATOS ENCUESTA SATISFACCION ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}	
	
	
	// ---------------------------------------- SOLUCIONES ---------------------------------------- //

	@SuppressWarnings("unchecked")
	@Override
	public List<AuxSolicitudGeneral> buscarFormulario(char tipo, Long idEmpleado, Long idAfiliado, String nombreSolicitante, String solucionConstruir)throws IllegalArgumentException {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
		List<AuxSolicitudGeneral> valor = new ArrayList<AuxSolicitudGeneral>();
		List<SegSolicitudGeneral> results = new ArrayList<SegSolicitudGeneral>() ;
		
		if(tipo=='1'){
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class,
					"nombreSolicitante == '"+nombreSolicitante+"'" +		// Realiza una busqueda ESPECIFICA, segun un el nombre de solicitante
					" && idAfiliado == " + idAfiliado +
					" && idEmpleado == " + idEmpleado
					);
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}else if(tipo =='2'){												// Obtiene todas las solicitudes de un usuario logeado
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class,			
					"idEmpleado == " + idEmpleado +
					" && idAfiliado == " + idAfiliado
					);
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}else if(tipo =='3'){												// Obtiene una busqueda ESPECIFICA, segun solucion a Construir
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class,
					"solucionConstruir == '"+solucionConstruir+"'" +
					" && idAfiliado == " + idAfiliado +
					" && idEmpleado == " + idEmpleado
					);
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}else if(tipo =='4'){												// Obtiene todas las solicitudes de todos los usuarios
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class);				
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}else if(tipo =='5'){												// Obtiene todas las solicitudes de todos los usuarios, segun solucion a Construir
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class,
					"solucionConstruir == '"+solucionConstruir+"'"
					);				
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}
		
		if(!results.isEmpty())
		{
			for (SegSolicitudGeneral p : results) {
				
				AuxSolicitudGeneral nuevo = new AuxSolicitudGeneral();

				nuevo.setNombreSolicitante(p.getNombreSolicitante());
				nuevo.setEstadoCivil(p.getEstadoCivil());
				nuevo.setEdad(p.getEdad());
				nuevo.setNacionalidad(p.getNacionalidad());
				nuevo.setProfesionOficio(p.getProfesionOficio());
				nuevo.setNumDpi(p.getNumDpi());
				nuevo.setNumDpiUnico(p.getNumDpiUnico());
				nuevo.setNumDpiReferencia(p.getNumDpiReferencia());
				nuevo.setActividadEconomica(p.getActividadEconomica());
				nuevo.setCheckLeer(p.getCheckLeer());
				nuevo.setCheckLeer(p.getCheckLeer());
				nuevo.setCheckFirmar(p.getCheckFirmar());
				nuevo.setDireccionActual(p.getDireccionActual());
				nuevo.setDireccionSolucion(p.getDireccionSolucion());
				nuevo.setCheckCarro(p.getCheckCarro());
				nuevo.setCheckCamion(p.getCheckCamion());
				nuevo.setCheckPeatonal(p.getCheckPeatonal());
				nuevo.setLugarTrabajoSolicitante(p.getLugarTrabajoSolicitante());
				nuevo.setTelefonoCasaSolicitante(p.getTelefonoCasaSolicitante());
				nuevo.setTelefonoTrabajoSolicitante(p.getTelefonoTrabajoSolicitante());
				nuevo.setSolucionConstruir(p.getSolucionConstruir());
				nuevo.setCuotaPagar(p.getCuotaPagar());
				nuevo.setNombreConyuge(p.getNombreConyuge());
				nuevo.setTelefonoConyuge(p.getTelefonoConyuge());
				nuevo.setLugarTrabajoConyuge(p.getLugarTrabajoConyuge());
				nuevo.setTelefonoTrabajoConyuge(p.getTelefonoTrabajoConyuge());
				nuevo.setGarantia(p.getGarantia());
				nuevo.setCreditoAprobado(p.getCreditoAprobado());
				nuevo.setCreditoNoAprobado(p.getCreditoNoAprobado());
				nuevo.setMontoAprobado(p.getMontoAprobado());
				nuevo.setObservacionNoAprobado(p.getObservacionNoAprobado());
				nuevo.setPrimeraSupervision(p.getPrimeraSupervision());
				nuevo.setSegundaSupervision(p.getSegundaSupervision());
				nuevo.setTerceraSupervision(p.getTerceraSupervision());
				nuevo.setCuartaSupervision(p.getCuartaSupervision());
				nuevo.setIdFormulario(p.getIdFormulario());	// ID
				
				List<SegSolicitudCargaFamiliar> results01 = p.getCargaFamiliar();
				if (!results01.isEmpty()) {
					for (SegSolicitudCargaFamiliar n0 : results01) {
						AuxSolicitudCargaFamiliar l = new AuxSolicitudCargaFamiliar();
						l.setIdCargaFamiliar(n0.getIdCargaFamiliar());
						l.setIdFormulario(n0.getIdFormulario());
						l.setNombreFamiliar(n0.getNombreFamiliar());
						l.setEdadFamiliar(n0.getEdadFamiliar());
						l.setEscolaridadFamiliar(n0.getEscolaridadFamiliar());
						l.setOcupacionFamiliar(n0.getOcupacionFamiliar());
						nuevo.getCargaFamiliar().add(l); // Agregado a Entidad Principal
					}
				}				
				
				List<SegSolicitudReferenciaFamiliar> results0 = p.getReferenciaFamiliar();
				if (!results0.isEmpty()) {
					for (SegSolicitudReferenciaFamiliar n0 : results0) {
						AuxSolicitudReferenciaFamiliar l = new AuxSolicitudReferenciaFamiliar();
						l.setIdReferenciaFamiliar(n0.getIdReferenciaFamiliar());
						l.setIdFormulario(n0.getIdFormulario());
						l.setNombreFamiliar(n0.getNombreFamiliar());
						l.setTelefonoFamiliar(n0.getTelefonoFamiliar());
						l.setParentescoFamiliar(n0.getParentescoFamiliar());
						l.setDireccionFamiliar(n0.getDireccionFamiliar());
						nuevo.getReferenciaFamiliar().add(l); // Agregado a Entidad Principal
					}
				}

				List<SegSolicitudDatosVivienda> results02 = p.getDatosVivienda();
				if (!results02.isEmpty()) {
					for (SegSolicitudDatosVivienda n0 : results02) {
						AuxSolicitudDatosVivienda l = new AuxSolicitudDatosVivienda();
						l.setIdDatosVivienda(n0.getIdDatosVivienda());
						l.setIdFormulario(n0.getIdFormulario());
						l.setDatoVivienda(n0.getDatoVivienda());
						l.setOtroDatoVivienda(n0.getOtroDatoVivienda());
						l.setTecho(n0.getTecho());
						l.setPared(n0.getPared());
						l.setCocina(n0.getCocina());
						l.setCheckAgua(n0.getCheckAgua());
						l.setCheckDrenaje(n0.getCheckDrenaje());
						l.setCheckElectricidad(n0.getCheckElectricidad());
						l.setCheckSanitario(n0.getCheckSanitario());
						l.setBienesInmuebles(n0.getBienesInmuebles());
						l.setValorInmueble(n0.getValorInmueble());
						nuevo.getDatosVivienda().add(l); // Agregado a Entidad Principal
					}
				}					
				
				List<SegSolicitudSituacionEconomica> results03 = p.getSituacionEconomica();
				if (!results03.isEmpty()) {
					for (SegSolicitudSituacionEconomica n0 : results03) {
						AuxSolicitudSituacionEconomica l = new AuxSolicitudSituacionEconomica();
						
						l.setIdSituacionEconomica(n0.getIdSituacionEconomica());
						l.setIdFormulario(n0.getIdFormulario());
						l.setIngresosSolicitante(n0.getIngresosSolicitante());
						l.setIngresosConyuge(n0.getIngresosConyuge());
						l.setOtrosIngresos(n0.getOtrosIngresos());
						l.setIngresosTotales(n0.getIngresosTotales());
						l.setTotalIngresos(n0.getTotalIngresos());
						l.setTotalEgresos(n0.getTotalEgresos());
						l.setDiferencia(n0.getDiferencia());
						l.setPagosBuro(n0.getPagosBuro());
						l.setCuota(n0.getCuota());
						l.setExcedente(n0.getExcedente());
						l.setAlquilerVivienda(n0.getAlquilerVivienda());
						l.setAlimentacion(n0.getAlimentacion());
						l.setRopa(n0.getRopa());
						l.setGastosMedicos(n0.getGastosMedicos());
						l.setTransporte(n0.getTransporte());
						l.setEducacion(n0.getEducacion());
						l.setPagoLuzAgua(n0.getPagoLuzAgua());
						l.setPagoPrestamos(n0.getPagoPrestamos());
						l.setOtrosGastos1(n0.getOtrosGastos1());
						l.setOtrosGastos2(n0.getOtrosGastos2());
						l.setEgresosTotales(n0.getEgresosTotales());
						nuevo.getSituacionEconomica().add(l); // Agregado a Entidad Principal
					}
				}			
				
				List<SegSolicitudGarantiaHipotecaria> results04 = p.getGarantiaHipotecaria();
				if (!results04.isEmpty()) {
					for (SegSolicitudGarantiaHipotecaria n0 : results04) {
						AuxSolicitudGarantiaHipotecaria l = new AuxSolicitudGarantiaHipotecaria();
						
						l.setIdGarantiaHipotecaria(n0.getIdDocumentoPropiedad());
						l.setIdFormulario(n0.getIdFormulario());
						l.setEscrituraNoRegistrada(n0.getEscrituraNoRegistrada());
						l.setEscrituraRegistrada(n0.getEscrituraRegistrada());
						l.setFolioEscritura(n0.getFolioEscritura());
						l.setLibroEscritura(n0.getLibroEscritura());
						l.setFincaEscritura(n0.getFincaEscritura());
						l.setNombreNotario(n0.getNombreNotario());
						l.setAreaTerreno(n0.getAreaTerreno());
						l.setValorEstimado(n0.getValorEstimado());
						l.setCheckSi(n0.getCheckSi());
						l.setCheckNo(n0.getCheckNo());
						l.setNombrePersona(n0.getNombrePersona());
						l.setTelefonoPersona(n0.getTelefonoPersona());
						nuevo.getGarantiaHipotecaria().add(l); // Agregado a Entidad Principal
					}
				}	
				
				List<SegSolicitudGarantiaFiduciaria> resultsFiduciaria = p.getGarantiaFiduciaria();
				if (!resultsFiduciaria.isEmpty()) {
					for (SegSolicitudGarantiaFiduciaria n0 : resultsFiduciaria) {
						AuxSolicitudGarantiaFiduciaria l = new AuxSolicitudGarantiaFiduciaria();
						
						l.setIdGarantiaFiduciaria(n0.getIdGarantiaFiduciaria());
						l.setIdFormulario(n0.getIdFormulario());
						l.setNombre(n0.getNombre());
						l.setEstadoCivil(n0.getEstadoCivil());
						l.setEdad(n0.getEdad());
						l.setNacionalidad(n0.getNacionalidad());
						l.setActividadEconomica(n0.getActividadEconomica());
						l.setCheckLeer(n0.getCheckLeer());
						l.setCheckEscribir(n0.getCheckEscribir());
						l.setCheckFirmar(n0.getCheckFirmar());
						l.setDireccionActual(n0.getDireccionActual());
						l.setLugarTrabajo(n0.getLugarTrabajo());
						l.setTelefonoCasa(n0.getTelefonoCasa());
						l.setTelefonoTrabajo(n0.getTelefonoTrabajo());
						nuevo.getGarantiaFiduciaria().add(l); // Agregado a Entidad Principal
					}
				}			
				
				List<SegSolicitudGarantiaSolidario> resultsSolidario = p.getGarantiaSolidario();
				if (!resultsSolidario.isEmpty()) {
					for (SegSolicitudGarantiaSolidario n0 : resultsSolidario) {
						AuxSolicitudGarantiaSolidario l = new AuxSolicitudGarantiaSolidario();
						l.setIdGarantiaSolidario(n0.getIdGarantiaSolidario());
						l.setIdFormulario(n0.getIdFormulario());
						l.setNombre(n0.getNombre());
						l.setEdad(n0.getEdad());
						l.setEscolaridad(n0.getEscolaridad());
						l.setOcupacion(n0.getOcupacion());
						nuevo.getGarantiaSolidario().add(l); // Agregado a Entidad Principal
					}
				}				
				
				List<SegSolicitudSupervisionPrimera> results05 = p.getSupervisionPrimera();
				if (!results05.isEmpty()) {
					for (SegSolicitudSupervisionPrimera n0 : results05) {
						AuxSolicitudSupervisionPrimera l = new AuxSolicitudSupervisionPrimera();
						
						l.setIdSupervisionPrimera(n0.getIdSupervisionPrimera());
						l.setIdFormulario(n0.getIdFormulario());
						l.setFechaVisita(n0.getFechaVisita().getTime());
						l.setCheckSi(n0.getCheckSi());
						l.setCheckNo(n0.getCheckNo());
						l.setObservaciones(n0.getObservaciones());
						l.setAcciones(n0.getAcciones());
						l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
						l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
						l.setPromotor(n0.getPromotor());
						l.setAlbanil(n0.getAlbanil());
						l.setRepresentante(n0.getRepresentante());
						l.setURLFile(n0.getURLFile());
						l.setKeyFile(n0.getKeyFile());
						nuevo.getSupervisionPrimera().add(l); // Agregado a Entidad Principal
					}
				}
				
				List<SegSolicitudSupervisionSegunda> results06 = p.getSupervisionSegunda();
				if (!results06.isEmpty()) {
					for (SegSolicitudSupervisionSegunda n0 : results06) {
						AuxSolicitudSupervisionSegunda l = new AuxSolicitudSupervisionSegunda();
						
						l.setIdSupervisionSegunda(n0.getIdSupervisionSegunda());
						l.setIdFormulario(n0.getIdFormulario());
						l.setFechaVisita(n0.getFechaVisita().getTime());
						l.setObservaciones(n0.getObservaciones());
						l.setAcciones(n0.getAcciones());
						l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
						l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
						l.setPromotor(n0.getPromotor());
						l.setAlbanil(n0.getAlbanil());
						l.setRepresentante(n0.getRepresentante());
						l.setURLFile(n0.getURLFile());
						l.setKeyFile(n0.getKeyFile());
						nuevo.getSupervisionSegunda().add(l); // Agregado a Entidad Principal
					}
				}	
				
				List<SegSolicitudSupervisionTercera> results07 = p.getSupervisionTercera();
				if (!results07.isEmpty()) {
					for (SegSolicitudSupervisionTercera n0 : results07) {
						AuxSolicitudSupervisionTercera l = new AuxSolicitudSupervisionTercera();
						
						l.setIdSupervisionTercera(n0.getIdSupervisionTercera());
						l.setIdFormulario(n0.getIdFormulario());
						l.setFechaVisita(n0.getFechaVisita().getTime());
						l.setObservaciones(n0.getObservaciones());
						l.setAcciones(n0.getAcciones());
						l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
						l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
						l.setPromotor(n0.getPromotor());
						l.setAlbanil(n0.getAlbanil());
						l.setRepresentante(n0.getRepresentante());
						l.setURLFile(n0.getURLFile());
						l.setKeyFile(n0.getKeyFile());
						nuevo.getSupervisionTercera().add(l); // Agregado a Entidad Principal
					}
				}
				
				List<SegSolicitudSupervisionCuarta> results08 = p.getSupervisionCuarta();
				if (!results08.isEmpty()) {
					for (SegSolicitudSupervisionCuarta n0 : results08) {
						AuxSolicitudSupervisionCuarta l = new AuxSolicitudSupervisionCuarta();
						
						l.setIdSupervisionCuarta(n0.getIdSupervisionCuarta());
						l.setIdFormulario(n0.getIdFormulario());
						l.setFechaVisita(n0.getFechaVisita().getTime());
						l.setObservaciones(n0.getObservaciones());
						l.setAcciones(n0.getAcciones());
						l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
						l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
						l.setPromotor(n0.getPromotor());
						l.setAlbanil(n0.getAlbanil());
						l.setRepresentante(n0.getRepresentante());
						l.setURLFile(n0.getURLFile());
						l.setKeyFile(n0.getKeyFile());
						nuevo.getSupervisionCuarta().add(l); // Agregado a Entidad Principal
					}
				}	
				
				List<SegSolicitudSupervisionUbicacion> results09 = p.getSupervisionUbicacion();
				if (!results09.isEmpty()) {
					for (SegSolicitudSupervisionUbicacion n0 : results09) {
						AuxSolicitudSupervisionUbicacion l = new AuxSolicitudSupervisionUbicacion();
						
						l.setIdSupervisionUbicacion(n0.getIdSupervisionUbicacion());
						l.setIdFormulario(n0.getIdFormulario());
						l.setLatitud(n0.getLatitud());
						l.setLongitud(n0.getLongitud());
						nuevo.getSupervisionUbicacion().add(l); // Agregado a Entidad Principal
					}
				}
				
				List<SegSolicitudEncuestaSatisfaccion> resultsEncuesta = p.getEncuestaSatisfaccion();
				if (!resultsEncuesta.isEmpty()) {
					for (SegSolicitudEncuestaSatisfaccion n0 : resultsEncuesta) {
						AuxSolicitudEncuestaSatisfaccion l = new AuxSolicitudEncuestaSatisfaccion();
						
						l.setIdEncuestaSatisfaccion(n0.getIdEncuestaSatisfaccion());
						l.setIdFormulario(n0.getIdFormulario());
						l.setPreguntaNo1(n0.getPreguntaNo1());
						l.setPreguntaNo2(n0.getPreguntaNo2());
						l.setPreguntaNo3(n0.getPreguntaNo3());
						l.setPreguntaNo4(n0.getPreguntaNo4());
						l.setPreguntaNo5(n0.getPreguntaNo5());
						l.setPreguntaNo6(n0.getPreguntaNo6());
						l.setPreguntaNo7(n0.getPreguntaNo7());
						l.setPreguntaNo8(n0.getPreguntaNo8());
						l.setPreguntaNo9(n0.getPreguntaNo9());
						l.setPreguntaNo10(n0.getPreguntaNo10());
						l.setPreguntaNo11(n0.getPreguntaNo11());
						l.setPreguntaNo12(n0.getPreguntaNo12());
						l.setPreguntaNo13(n0.getPreguntaNo13());
						l.setPreguntaNo14(n0.getPreguntaNo14());
						l.setPreguntaNo15(n0.getPreguntaNo15());
						l.setPreguntaNo16(n0.getPreguntaNo16());
						l.setDepartamento(n0.getDepartamento());
						nuevo.getEncuestaSatisfaccion().add(l); // Agregado a Entidad Principal
					}
				}
				
				
				
				valor.add(nuevo);
			}
			return valor;
		}
		return valor;
	}	
	
	@Override
	public AuxSolicitudGeneral obtenerDataFormularioRegistrado(Long idFormulario) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		AuxSolicitudGeneral nuevo = new AuxSolicitudGeneral();
		
		try { 
			
			final SegSolicitudGeneral p = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
			
			nuevo.setNombreSolicitante(p.getNombreSolicitante());
			nuevo.setEstadoCivil(p.getEstadoCivil());
			nuevo.setEdad(p.getEdad());
			nuevo.setNacionalidad(p.getNacionalidad());
			nuevo.setProfesionOficio(p.getProfesionOficio());
			nuevo.setNumDpi(p.getNumDpi());
			nuevo.setNumDpiUnico(p.getNumDpiUnico());
			nuevo.setNumDpiReferencia(p.getNumDpiReferencia());
			nuevo.setActividadEconomica(p.getActividadEconomica());
			nuevo.setCheckLeer(p.getCheckLeer());
			nuevo.setCheckEscribir(p.getCheckEscribir());
			nuevo.setCheckFirmar(p.getCheckFirmar());
			nuevo.setDireccionActual(p.getDireccionActual());
			nuevo.setDireccionSolucion(p.getDireccionSolucion());
			nuevo.setCheckCarro(p.getCheckCarro());
			nuevo.setCheckCamion(p.getCheckCamion());
			nuevo.setCheckPeatonal(p.getCheckPeatonal());
			nuevo.setLugarTrabajoSolicitante(p.getLugarTrabajoSolicitante());
			nuevo.setTelefonoCasaSolicitante(p.getTelefonoCasaSolicitante());
			nuevo.setTelefonoTrabajoSolicitante(p.getTelefonoTrabajoSolicitante());
			nuevo.setSolucionConstruir(p.getSolucionConstruir());
			nuevo.setCuotaPagar(p.getCuotaPagar());
			nuevo.setNombreConyuge(p.getNombreConyuge());
			nuevo.setTelefonoConyuge(p.getTelefonoConyuge());
			nuevo.setLugarTrabajoConyuge(p.getLugarTrabajoConyuge());
			nuevo.setTelefonoTrabajoConyuge(p.getTelefonoTrabajoConyuge());
			nuevo.setGarantia(p.getGarantia());
			nuevo.setCreditoAprobado(p.getCreditoAprobado());
			nuevo.setCreditoNoAprobado(p.getCreditoNoAprobado());
			nuevo.setMontoAprobado(p.getMontoAprobado());
			nuevo.setObservacionNoAprobado(p.getObservacionNoAprobado());
			nuevo.setPrimeraSupervision(p.getPrimeraSupervision());
			nuevo.setSegundaSupervision(p.getSegundaSupervision());
			nuevo.setTerceraSupervision(p.getTerceraSupervision());
			nuevo.setCuartaSupervision(p.getCuartaSupervision());
			nuevo.setIdFormulario(p.getIdFormulario());	// ID
			
			List<SegSolicitudCargaFamiliar> results01 = p.getCargaFamiliar();
			if (!results01.isEmpty()) {
				for (SegSolicitudCargaFamiliar n0 : results01) {
					AuxSolicitudCargaFamiliar l = new AuxSolicitudCargaFamiliar();
					l.setIdCargaFamiliar(n0.getIdCargaFamiliar());
					l.setIdFormulario(n0.getIdFormulario());
					l.setNombreFamiliar(n0.getNombreFamiliar());
					l.setEdadFamiliar(n0.getEdadFamiliar());
					l.setEscolaridadFamiliar(n0.getEscolaridadFamiliar());
					l.setOcupacionFamiliar(n0.getOcupacionFamiliar());
					nuevo.getCargaFamiliar().add(l); // Agregado a Entidad Principal
				}
			}
			
			List<SegSolicitudReferenciaFamiliar> results02 = p.getReferenciaFamiliar();
			if (!results02.isEmpty()) {
				for (SegSolicitudReferenciaFamiliar n0 : results02) {
					AuxSolicitudReferenciaFamiliar l = new AuxSolicitudReferenciaFamiliar();
					l.setIdReferenciaFamiliar(n0.getIdReferenciaFamiliar());
					l.setIdFormulario(n0.getIdFormulario());
					l.setNombreFamiliar(n0.getNombreFamiliar());
					l.setTelefonoFamiliar(n0.getTelefonoFamiliar());
					l.setParentescoFamiliar(n0.getParentescoFamiliar());
					l.setDireccionFamiliar(n0.getDireccionFamiliar());
					nuevo.getReferenciaFamiliar().add(l); // Agregado a Entidad Principal
				}
			}
			
			List<SegSolicitudDatosVivienda> results03 = p.getDatosVivienda();
			if (!results03.isEmpty()) {
				for (SegSolicitudDatosVivienda n0 : results03) {
					AuxSolicitudDatosVivienda l = new AuxSolicitudDatosVivienda();
					l.setIdDatosVivienda(n0.getIdDatosVivienda());
					l.setIdFormulario(n0.getIdFormulario());
					l.setDatoVivienda(n0.getDatoVivienda());
					l.setOtroDatoVivienda(n0.getOtroDatoVivienda());
					l.setTecho(n0.getTecho());
					l.setPared(n0.getPared());
					l.setCocina(n0.getCocina());
					l.setCheckAgua(n0.getCheckAgua());
					l.setCheckDrenaje(n0.getCheckDrenaje());
					l.setCheckElectricidad(n0.getCheckElectricidad());
					l.setCheckSanitario(n0.getCheckSanitario());
					l.setBienesInmuebles(n0.getBienesInmuebles());
					l.setValorInmueble(n0.getValorInmueble());
					nuevo.getDatosVivienda().add(l); // Agregado a Entidad Principal
				}
			}
			
			List<SegSolicitudSituacionEconomica> results04 = p.getSituacionEconomica();
			if (!results04.isEmpty()) {
				for (SegSolicitudSituacionEconomica n0 : results04) {
					AuxSolicitudSituacionEconomica l = new AuxSolicitudSituacionEconomica();
					
					l.setIdSituacionEconomica(n0.getIdSituacionEconomica());
					l.setIdFormulario(n0.getIdFormulario());
					l.setIngresosSolicitante(n0.getIngresosSolicitante());
					l.setIngresosConyuge(n0.getIngresosConyuge());
					l.setOtrosIngresos(n0.getOtrosIngresos());
					l.setIngresosTotales(n0.getIngresosTotales());
					l.setTotalIngresos(n0.getTotalIngresos());
					l.setTotalEgresos(n0.getTotalEgresos());
					l.setDiferencia(n0.getDiferencia());
					l.setPagosBuro(n0.getPagosBuro());
					l.setCuota(n0.getCuota());
					l.setExcedente(n0.getExcedente());
					l.setAlquilerVivienda(n0.getAlquilerVivienda());
					l.setAlimentacion(n0.getAlimentacion());
					l.setRopa(n0.getRopa());
					l.setGastosMedicos(n0.getGastosMedicos());
					l.setTransporte(n0.getTransporte());
					l.setEducacion(n0.getEducacion());
					l.setPagoLuzAgua(n0.getPagoLuzAgua());
					l.setPagoPrestamos(n0.getPagoPrestamos());
					l.setOtrosGastos1(n0.getOtrosGastos1());
					l.setOtrosGastos2(n0.getOtrosGastos2());
					l.setEgresosTotales(n0.getEgresosTotales());
					nuevo.getSituacionEconomica().add(l); // Agregado a Entidad Principal
				}
			}
			
			List<SegSolicitudGarantiaHipotecaria> results05 = p.getGarantiaHipotecaria();
			if (!results05.isEmpty()) {
				for (SegSolicitudGarantiaHipotecaria n0 : results05) {
					AuxSolicitudGarantiaHipotecaria l = new AuxSolicitudGarantiaHipotecaria();
					
					l.setIdGarantiaHipotecaria(n0.getIdDocumentoPropiedad());
					l.setIdFormulario(n0.getIdFormulario());
					l.setEscrituraNoRegistrada(n0.getEscrituraNoRegistrada());
					l.setEscrituraRegistrada(n0.getEscrituraRegistrada());
					l.setFolioEscritura(n0.getFolioEscritura());
					l.setLibroEscritura(n0.getLibroEscritura());
					l.setFincaEscritura(n0.getFincaEscritura());
					l.setNombreNotario(n0.getNombreNotario());
					l.setAreaTerreno(n0.getAreaTerreno());
					l.setValorEstimado(n0.getValorEstimado());
					l.setCheckSi(n0.getCheckSi());
					l.setCheckNo(n0.getCheckNo());
					l.setNombrePersona(n0.getNombrePersona());
					l.setTelefonoPersona(n0.getTelefonoPersona());
					nuevo.getGarantiaHipotecaria().add(l); // Agregado a Entidad Principal
				}
			}	
			
			List<SegSolicitudGarantiaFiduciaria> resultsFiduciaria = p.getGarantiaFiduciaria();
			if (!resultsFiduciaria.isEmpty()) {
				for (SegSolicitudGarantiaFiduciaria n0 : resultsFiduciaria) {
					AuxSolicitudGarantiaFiduciaria l = new AuxSolicitudGarantiaFiduciaria();
					
					l.setIdGarantiaFiduciaria(n0.getIdGarantiaFiduciaria());
					l.setIdFormulario(n0.getIdFormulario());
					l.setNombre(n0.getNombre());
					l.setEstadoCivil(n0.getEstadoCivil());
					l.setEdad(n0.getEdad());
					l.setNacionalidad(n0.getNacionalidad());
					l.setActividadEconomica(n0.getActividadEconomica());
					l.setCheckLeer(n0.getCheckLeer());
					l.setCheckEscribir(n0.getCheckEscribir());
					l.setCheckFirmar(n0.getCheckFirmar());
					l.setDireccionActual(n0.getDireccionActual());
					l.setLugarTrabajo(n0.getLugarTrabajo());
					l.setTelefonoCasa(n0.getTelefonoCasa());
					l.setTelefonoTrabajo(n0.getTelefonoTrabajo());
					nuevo.getGarantiaFiduciaria().add(l); // Agregado a Entidad Principal
				}
			}				
			
			List<SegSolicitudGarantiaSolidario> resultsSolidario = p.getGarantiaSolidario();
			if (!resultsSolidario.isEmpty()) {
				for (SegSolicitudGarantiaSolidario n0 : resultsSolidario) {
					AuxSolicitudGarantiaSolidario l = new AuxSolicitudGarantiaSolidario();
					l.setIdGarantiaSolidario(n0.getIdGarantiaSolidario());
					l.setIdFormulario(n0.getIdFormulario());
					l.setNombre(n0.getNombre());
					l.setEdad(n0.getEdad());
					l.setEscolaridad(n0.getEscolaridad());
					l.setOcupacion(n0.getOcupacion());
					nuevo.getGarantiaSolidario().add(l); // Agregado a Entidad Principal
				}
			}	
			
			List<SegSolicitudSupervisionPrimera> results06 = p.getSupervisionPrimera();
			if (!results06.isEmpty()) {
				for (SegSolicitudSupervisionPrimera n0 : results06) {
					AuxSolicitudSupervisionPrimera l = new AuxSolicitudSupervisionPrimera();
					
					l.setIdSupervisionPrimera(n0.getIdSupervisionPrimera());
					l.setIdFormulario(n0.getIdFormulario());
					l.setFechaVisita(n0.getFechaVisita().getTime());
					l.setCheckSi(n0.getCheckSi());
					l.setCheckNo(n0.getCheckNo());
					l.setObservaciones(n0.getObservaciones());
					l.setAcciones(n0.getAcciones());
					l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
					l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
					l.setPromotor(n0.getPromotor());
					l.setAlbanil(n0.getAlbanil());
					l.setRepresentante(n0.getRepresentante());
					l.setURLFile(n0.getURLFile());
					l.setKeyFile(n0.getKeyFile());
					nuevo.getSupervisionPrimera().add(l); // Agregado a Entidad Principal
				}
			}				
			
			List<SegSolicitudSupervisionSegunda> results07 = p.getSupervisionSegunda();
			if (!results07.isEmpty()) {
				for (SegSolicitudSupervisionSegunda n0 : results07) {
					AuxSolicitudSupervisionSegunda l = new AuxSolicitudSupervisionSegunda();
					
					l.setIdSupervisionSegunda(n0.getIdSupervisionSegunda());
					l.setIdFormulario(n0.getIdFormulario());
					l.setFechaVisita(n0.getFechaVisita().getTime());
					l.setObservaciones(n0.getObservaciones());
					l.setAcciones(n0.getAcciones());
					l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
					l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
					l.setPromotor(n0.getPromotor());
					l.setAlbanil(n0.getAlbanil());
					l.setRepresentante(n0.getRepresentante());
					l.setURLFile(n0.getURLFile());
					l.setKeyFile(n0.getKeyFile());
					nuevo.getSupervisionSegunda().add(l); // Agregado a Entidad Principal
				}
			}	
			
			List<SegSolicitudSupervisionTercera> results08 = p.getSupervisionTercera();
			if (!results08.isEmpty()) {
				for (SegSolicitudSupervisionTercera n0 : results08) {
					AuxSolicitudSupervisionTercera l = new AuxSolicitudSupervisionTercera();
					
					l.setIdSupervisionTercera(n0.getIdSupervisionTercera());
					l.setIdFormulario(n0.getIdFormulario());
					l.setFechaVisita(n0.getFechaVisita().getTime());
					l.setObservaciones(n0.getObservaciones());
					l.setAcciones(n0.getAcciones());
					l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
					l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
					l.setPromotor(n0.getPromotor());
					l.setAlbanil(n0.getAlbanil());
					l.setRepresentante(n0.getRepresentante());
					l.setURLFile(n0.getURLFile());
					l.setKeyFile(n0.getKeyFile());
					nuevo.getSupervisionTercera().add(l); // Agregado a Entidad Principal
				}
			}
			
			List<SegSolicitudSupervisionCuarta> results09 = p.getSupervisionCuarta();
			if (!results09.isEmpty()) {
				for (SegSolicitudSupervisionCuarta n0 : results09) {
					AuxSolicitudSupervisionCuarta l = new AuxSolicitudSupervisionCuarta();
					
					l.setIdSupervisionCuarta(n0.getIdSupervisionCuarta());
					l.setIdFormulario(n0.getIdFormulario());
					l.setFechaVisita(n0.getFechaVisita().getTime());
					l.setObservaciones(n0.getObservaciones());
					l.setAcciones(n0.getAcciones());
					l.setCheckSatisfactoria(n0.getCheckSatisfactoria());
					l.setCheckNoSatisfactoria(n0.getCheckNoSatisfactoria());
					l.setPromotor(n0.getPromotor());
					l.setAlbanil(n0.getAlbanil());
					l.setRepresentante(n0.getRepresentante());
					l.setURLFile(n0.getURLFile());
					l.setKeyFile(n0.getKeyFile());
					nuevo.getSupervisionCuarta().add(l); // Agregado a Entidad Principal
				}
			}	
			
			List<SegSolicitudSupervisionUbicacion> results10 = p.getSupervisionUbicacion();
			if (!results10.isEmpty()) {
				for (SegSolicitudSupervisionUbicacion n0 : results10) {
					AuxSolicitudSupervisionUbicacion l = new AuxSolicitudSupervisionUbicacion();
					
					l.setIdSupervisionUbicacion(n0.getIdSupervisionUbicacion());
					l.setIdFormulario(n0.getIdFormulario());
					l.setLatitud(n0.getLatitud());
					l.setLongitud(n0.getLongitud());
					nuevo.getSupervisionUbicacion().add(l); // Agregado a Entidad Principal
				}
			}
			
			List<SegSolicitudEncuestaSatisfaccion> resultsEncuesta = p.getEncuestaSatisfaccion();
			if (!resultsEncuesta.isEmpty()) {
				for (SegSolicitudEncuestaSatisfaccion n0 : resultsEncuesta) {
					AuxSolicitudEncuestaSatisfaccion l = new AuxSolicitudEncuestaSatisfaccion();
					
					l.setIdEncuestaSatisfaccion(n0.getIdEncuestaSatisfaccion());
					l.setIdFormulario(n0.getIdFormulario());
					l.setPreguntaNo1(n0.getPreguntaNo1());
					l.setPreguntaNo2(n0.getPreguntaNo2());
					l.setPreguntaNo3(n0.getPreguntaNo3());
					l.setPreguntaNo4(n0.getPreguntaNo4());
					l.setPreguntaNo5(n0.getPreguntaNo5());
					l.setPreguntaNo6(n0.getPreguntaNo6());
					l.setPreguntaNo7(n0.getPreguntaNo7());
					l.setPreguntaNo8(n0.getPreguntaNo8());
					l.setPreguntaNo9(n0.getPreguntaNo9());
					l.setPreguntaNo10(n0.getPreguntaNo10());
					l.setPreguntaNo11(n0.getPreguntaNo11());
					l.setPreguntaNo12(n0.getPreguntaNo12());
					l.setPreguntaNo13(n0.getPreguntaNo13());
					l.setPreguntaNo14(n0.getPreguntaNo14());
					l.setPreguntaNo15(n0.getPreguntaNo15());
					l.setPreguntaNo16(n0.getPreguntaNo16());
					l.setDepartamento(n0.getDepartamento());
					nuevo.getEncuestaSatisfaccion().add(l); // Agregado a Entidad Principal
				}
			}
			
			
		}finally {  
			Persistencia.close();  
		}

		return nuevo;
	}    	
	
	
	@Override
	public AuxSolicitudEncuestaSatisfaccion consultaEncuestaSatisfaccion(Long idFormulario, Long idEncuestaSatisfaccion) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		AuxSolicitudEncuestaSatisfaccion nuevo = new AuxSolicitudEncuestaSatisfaccion();
		
		try { 
			
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudEncuestaSatisfaccion.class.getSimpleName(), idEncuestaSatisfaccion).getKey();

			SegSolicitudEncuestaSatisfaccion p = Persistencia.getObjectById(SegSolicitudEncuestaSatisfaccion.class, k);
					
			nuevo.setIdEncuestaSatisfaccion(p.getIdEncuestaSatisfaccion());
			nuevo.setIdFormulario(p.getIdFormulario());
			nuevo.setPreguntaNo1(p.getPreguntaNo1());
			nuevo.setPreguntaNo2(p.getPreguntaNo2());
			nuevo.setPreguntaNo3(p.getPreguntaNo3());
			nuevo.setPreguntaNo4(p.getPreguntaNo4());
			nuevo.setPreguntaNo5(p.getPreguntaNo5());
			nuevo.setPreguntaNo6(p.getPreguntaNo6());
			nuevo.setPreguntaNo7(p.getPreguntaNo7());
			nuevo.setPreguntaNo8(p.getPreguntaNo8());
			nuevo.setPreguntaNo9(p.getPreguntaNo9());
			nuevo.setPreguntaNo10(p.getPreguntaNo10());
			nuevo.setPreguntaNo11(p.getPreguntaNo11());
			nuevo.setPreguntaNo12(p.getPreguntaNo12());
			nuevo.setPreguntaNo13(p.getPreguntaNo13());
			nuevo.setPreguntaNo14(p.getPreguntaNo14());
			nuevo.setPreguntaNo15(p.getPreguntaNo15());
			nuevo.setPreguntaNo16(p.getPreguntaNo16());
			nuevo.setDepartamento(p.getDepartamento());
			
			
		}finally {  
			Persistencia.close();  
		}

		return nuevo;
	}   
	

// METODOS DE ACTUALIZAR Y ELIMINAR		

	// DATOS SOLICITANTE
	
	@Override
	public Long actualizarDatosSolicitante(Long idFormulario, Long idEmpleado, Long idAfiliado,
			String nombreSolicitante, String estadoCivil, int edad, String nacionalidad, 
			String profesionOficio, String dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			 try {  
					 final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
					 	solicitud.setIdEmpleado(idEmpleado);
					 	solicitud.setIdAfiliado(idAfiliado);
						solicitud.setNombreSolicitante(nombreSolicitante);
						solicitud.setEstadoCivil(estadoCivil);
						solicitud.setEdad(edad);
						solicitud.setNacionalidad(nacionalidad);
						solicitud.setProfesionOficio(profesionOficio);
						solicitud.setNumDpi(dpi);
						solicitud.setNumDpiUnico(dpiUnico);
						solicitud.setNumDpiReferencia(dpiReferencia);
						solicitud.setActividadEconomica(actividadEconomica);
						solicitud.setCheckLeer(sabeLeer);
						solicitud.setCheckEscribir(sabeEscribir);
						solicitud.setCheckFirmar(sabeFirmar);
						solicitud.setDireccionActual(direccionActual);
						solicitud.setDireccionSolucion(direccionSolucion);
						solicitud.setCheckCamion(camion);
						solicitud.setCheckCarro(carro);
						solicitud.setCheckPeatonal(peatonal);
						solicitud.setLugarTrabajoSolicitante(lugarTrabajoSolicitante);
						solicitud.setTelefonoCasaSolicitante(telefonoCasaSolicitante);
						solicitud.setTelefonoTrabajoSolicitante(telefonoTrabajoSolicitante);
						solicitud.setSolucionConstruir(solucionConstruir);
						solicitud.setCuotaPagar(cuotaPagar);
						solicitud.setNombreConyuge(nombreConyuge);
						solicitud.setTelefonoConyuge(telefonoConyuge);
						solicitud.setLugarTrabajoConyuge(lugarTrabajoConyuge);
						solicitud.setTelefonoTrabajoConyuge(telefonoTrabajoConyuge); 
		 }finally {  
			 Persistencia.close();  
		 }
		 
		return idFormulario;
	}	
	
	// CARGAS FAMILIARES	

	@Override
	public Long actualizarCargaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
			String nombreFamiliar, int edadFamiliar, 
			String escolaridadFamiliar, String ocupacionFamiliar) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudCargaFamiliar.class.getSimpleName(), idReferenciaFamiliar).getKey();

			SegSolicitudCargaFamiliar f = Persistencia.getObjectById(SegSolicitudCargaFamiliar.class, k);
			f.setNombreFamiliar(nombreFamiliar);
			f.setEdadFamiliar(edadFamiliar);
			f.setEscolaridadFamiliar(escolaridadFamiliar);
			f.setOcupacionFamiliar(ocupacionFamiliar);
			valor =f.getIdCargaFamiliar();
		} finally {
			Persistencia.close();
		}
		return valor ;
	}		


	@Override
	public Long eliminarCargaFamiliar(Long idFormulario, Long id)throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
		Key k = new KeyFactory.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
		.addChild(SegSolicitudCargaFamiliar.class.getSimpleName(), id).getKey(); // Elimina referencia de Solicitud General

		SegSolicitudCargaFamiliar f = Persistencia.getObjectById(SegSolicitudCargaFamiliar.class, k);
		Persistencia.deletePersistent(f);
		return id ;
	}		
	
	// REFERENCIAS FAMILIARES	

	@Override
	public Long actualizarReferenciaFamiliar(Long idFormulario, Long idReferenciaFamiliar,
			String nombreFamiliar, int telefonoFamiliar, 
			String parentescoFamiliar, String direccionFamiliar) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudReferenciaFamiliar.class.getSimpleName(), idReferenciaFamiliar).getKey();

			SegSolicitudReferenciaFamiliar f = Persistencia.getObjectById(SegSolicitudReferenciaFamiliar.class, k);
			f.setNombreFamiliar(nombreFamiliar);
			f.setTelefonoFamiliar(telefonoFamiliar);
			f.setParentescoFamiliar(parentescoFamiliar);
			f.setDireccionFamiliar(direccionFamiliar);
			valor = f.getIdReferenciaFamiliar();
		} finally {
			Persistencia.close();
		}
		return valor ;
	}		


	@Override
	public Long eliminarReferenciaFamiliar(Long idFormulario, Long id)throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
		Key k = new KeyFactory.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
		.addChild(SegSolicitudReferenciaFamiliar.class.getSimpleName(), id).getKey(); // Elimina referencia de Solicitud General
		
		SegSolicitudReferenciaFamiliar f = Persistencia.getObjectById(SegSolicitudReferenciaFamiliar.class, k);
		Persistencia.deletePersistent(f);
		return id ;
	}
	
// DATOS VIVIENDA ACTUAL
	
	@Override
	public Long actualizarDatosViviendaActual(Long idFormulario, Long idDatosVivienda,
			String datosVivienda, String otroDatosVivienda,
			String techo, String pared, String cocina,
			Boolean servicioAgua, Boolean servicioDrenaje, Boolean servicioElectricidad, Boolean servicioSanitario, 
			String bienesInmuebles, float valorInmuebles) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudDatosVivienda.class.getSimpleName(), idDatosVivienda).getKey();

			SegSolicitudDatosVivienda f = Persistencia.getObjectById(SegSolicitudDatosVivienda.class, k);
			f.setDatoVivienda(datosVivienda);
			f.setOtroDatoVivienda(otroDatosVivienda);
			f.setTecho(techo);
			f.setPared(pared);
			f.setCocina(cocina);
			f.setCheckAgua(servicioAgua);
			f.setCheckDrenaje(servicioDrenaje);
			f.setCheckElectricidad(servicioElectricidad);
			f.setCheckSanitario(servicioSanitario);
			f.setBienesInmuebles(bienesInmuebles);
			f.setValorInmueble(valorInmuebles);

			valor = f.getIdDatosVivienda();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}
	
// SITUACION ECONOMICA
	
	@Override
	public Long actualizarSituacionEconomica(Long idFormulario, Long idSituacionEconomica,
			float ingresosSolicitante, float ingresosConyuge, float otrosIngresos, float ingresosTotales,
			float totalIngresos, float totalEgresos, float diferencia, float pagosBuro, float cuota, float excedente,
			float alquilerVivienda, float alimentacion, float ropa, float gastosMedicos, float transporte, float educacion,
			float pagoLuzAgua, float pagoPrestamos, float otrosGastos1, float otrosGastos2, float egresosTotales) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSituacionEconomica.class.getSimpleName(), idSituacionEconomica).getKey();

			SegSolicitudSituacionEconomica f = Persistencia.getObjectById(SegSolicitudSituacionEconomica.class, k);
			f.setIngresosSolicitante(ingresosSolicitante);
			f.setIngresosConyuge(ingresosConyuge);
			f.setOtrosIngresos(otrosIngresos);
			f.setIngresosTotales(ingresosTotales);
			f.setTotalIngresos(totalIngresos);
			f.setTotalEgresos(totalEgresos);
			f.setDiferencia(diferencia);
			f.setPagosBuro(pagosBuro);
			f.setCuota(cuota);
			f.setExcedente(excedente);
			f.setAlquilerVivienda(alquilerVivienda);
			f.setAlimentacion(alimentacion);
			f.setRopa(ropa);
			f.setGastosMedicos(gastosMedicos);
			f.setTransporte(transporte);
			f.setEducacion(educacion);
			f.setPagoLuzAgua(pagoLuzAgua);
			f.setPagoPrestamos(pagoPrestamos);
			f.setOtrosGastos1(otrosGastos1);
			f.setOtrosGastos2(otrosGastos2);
			f.setEgresosTotales(egresosTotales);

			valor = f.getIdSituacionEconomica();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}
	
// GARANTIA HIPOTECARIA
	
	@Override
	public Long actualizarGarantiaHipotecaria(Long idFormulario, Long idGarantiaHipotecaria,
			String escrituraNoRegistrada, String escrituraRegistrada, String folio, String libro, String finca,
			String nombreNotario, int areaTerreno, float valorTerreno,
			Boolean checkSi, Boolean checkNo,
			String nombrePersona, int telefonoPersona) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudGarantiaHipotecaria.class.getSimpleName(), idGarantiaHipotecaria).getKey();

			SegSolicitudGarantiaHipotecaria f = Persistencia.getObjectById(SegSolicitudGarantiaHipotecaria.class, k);
			f.setEscrituraNoRegistrada(escrituraNoRegistrada);
			f.setEscrituraRegistrada(escrituraRegistrada);
			f.setFolioEscritura(folio);
			f.setLibroEscritura(libro);
			f.setFincaEscritura(finca);
			f.setNombreNotario(nombreNotario);
			f.setAreaTerreno(areaTerreno);
			f.setValorEstimado(valorTerreno);
			f.setCheckSi(checkSi);
			f.setCheckNo(checkNo);
			f.setNombrePersona(nombrePersona);
			f.setTelefonoPersona(telefonoPersona);

			valor = f.getIdDocumentoPropiedad();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}
	
	// GARANTIA FIDUCIARIA

	@Override
	public Long actualizarGarantiaFiduciaria(Long idFormulario, Long idGarantiaFiduciaria,
			String nombre, 
			String estadoCivil, int edad, String nacionalidad,
			String actividad,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar,
			String direccionActual, String lugarTrabajo,
			int telefonoCasa, int telefonoTrabajo) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudGarantiaFiduciaria.class.getSimpleName(), idGarantiaFiduciaria).getKey();

			SegSolicitudGarantiaFiduciaria f = Persistencia.getObjectById(SegSolicitudGarantiaFiduciaria.class, k);
			f.setNombre(nombre);
			f.setEstadoCivil(estadoCivil);
			f.setEdad(edad);
			f.setNacionalidad(nacionalidad);
			f.setActividadEconomica(actividad);
			f.setCheckLeer(sabeLeer);
			f.setCheckEscribir(sabeEscribir);
			f.setCheckFirmar(sabeFirmar);
			f.setDireccionActual(direccionActual);
			f.setLugarTrabajo(lugarTrabajo);
			f.setTelefonoCasa(telefonoCasa);
			f.setTelefonoTrabajo(telefonoTrabajo);
			valor = f.getIdGarantiaFiduciaria();
		} finally {
			Persistencia.close();
		}
		return valor ;
	}		


	@Override
	public Long eliminarGarantiaFiduciaria(Long idFormulario, Long id)throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
		Key k = new KeyFactory.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
		.addChild(SegSolicitudGarantiaFiduciaria.class.getSimpleName(), id).getKey(); // Elimina referencia de Solicitud General
		
		SegSolicitudGarantiaFiduciaria f = Persistencia.getObjectById(SegSolicitudGarantiaFiduciaria.class, k);
		Persistencia.deletePersistent(f);
		return id ;
	}	
	
	// GARANTIA GRUPO SOLIDARIO	

	@Override
	public Long actualizarGarantiaSolidario(Long idFormulario, Long idGarantiaSolidario,
			String nombre, int edad, 
			String escolaridad, String ocupacion) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudGarantiaSolidario.class.getSimpleName(), idGarantiaSolidario).getKey();

			SegSolicitudGarantiaSolidario f = Persistencia.getObjectById(SegSolicitudGarantiaSolidario.class, k);
			f.setNombre(nombre);
			f.setEdad(edad);
			f.setEscolaridad(escolaridad);
			f.setOcupacion(ocupacion);
			valor =f.getIdGarantiaSolidario();
		} finally {
			Persistencia.close();
		}
		return valor ;
	}		


	@Override
	public Long eliminarGarantiaSolidario(Long idFormulario, Long id)throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
		Key k = new KeyFactory.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
		.addChild(SegSolicitudGarantiaSolidario.class.getSimpleName(), id).getKey(); // Elimina referencia de Solicitud General

		SegSolicitudGarantiaSolidario f = Persistencia.getObjectById(SegSolicitudGarantiaSolidario.class, k);
		Persistencia.deletePersistent(f);
		return id ;
	}			
	
	
	// SUPERVISION PRIMERA

	@Override
	public Long actualizarSupervisionPrimera(Long idFormulario, Long idSupervisionPrimera,
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionPrimera.class.getSimpleName(), idSupervisionPrimera).getKey();

			SegSolicitudSupervisionPrimera f = Persistencia.getObjectById(SegSolicitudSupervisionPrimera.class, k);
			f.setFechaVisita(fechaVisita);
			f.setCheckSi(checkSi);
			f.setCheckNo(checkNo);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);
			f.setPromotor(promotor);
			f.setAlbanil(albanil);
			f.setRepresentante(representante);
			f.setURLFile(URLFile);
			f.setKeyFile(KeyFile);

			valor = f.getIdSupervisionPrimera();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}	

	// SUPERVISION SEGUNDA

	@Override
	public Long actualizarSupervisionSegunda(Long idFormulario, Long idSupervisionSegunda,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionSegunda.class.getSimpleName(), idSupervisionSegunda).getKey();

			SegSolicitudSupervisionSegunda f = Persistencia.getObjectById(SegSolicitudSupervisionSegunda.class, k);
			f.setFechaVisita(fechaVisita);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);
			f.setPromotor(promotor);
			f.setAlbanil(albanil);
			f.setRepresentante(representante);
			f.setURLFile(URLFile);
			f.setKeyFile(KeyFile);

			valor = f.getIdSupervisionSegunda();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}			
	
	// SUPERVISION TERCERA

	@Override
	public Long actualizarSupervisionTercera(Long idFormulario, Long idSupervisionTercera,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionTercera.class.getSimpleName(), idSupervisionTercera).getKey();

			SegSolicitudSupervisionTercera f = Persistencia.getObjectById(SegSolicitudSupervisionTercera.class, k);
			f.setFechaVisita(fechaVisita);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);
			f.setPromotor(promotor);
			f.setAlbanil(albanil);
			f.setRepresentante(representante);
			f.setURLFile(URLFile);
			f.setKeyFile(KeyFile);

			valor = f.getIdSupervisionTercera();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}		
	
	// SUPERVISION CUARTA

	@Override
	public Long actualizarSupervisionCuarta(Long idFormulario, Long idSupervisionCuarta,
			Date fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionCuarta.class.getSimpleName(), idSupervisionCuarta).getKey();

			SegSolicitudSupervisionCuarta f = Persistencia.getObjectById(SegSolicitudSupervisionCuarta.class, k);
			f.setFechaVisita(fechaVisita);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);
			f.setPromotor(promotor);
			f.setAlbanil(albanil);
			f.setRepresentante(representante);
			f.setURLFile(URLFile);
			f.setKeyFile(KeyFile);

			valor = f.getIdSupervisionCuarta();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}		
	
	// SUPERVISION UBICACION

	@Override
	public Long actualizarSupervisionUbicacion(Long idFormulario, Long idSupervisionUbicacion,
			String latitud, String longitud) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionUbicacion.class.getSimpleName(), idSupervisionUbicacion).getKey();

			SegSolicitudSupervisionUbicacion f = Persistencia.getObjectById(SegSolicitudSupervisionUbicacion.class, k);
			f.setLatitud(latitud);
			f.setLongitud(longitud);

			valor = f.getIdSupervisionUbicacion();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}
	
	
	// ENCUESTA SATISFACCION

	@Override
	public Long actualizarEncuestaSatisfaccion(Long idFormulario, Long idEncuestaSatisfaccion,
			String preguntaNo1, String preguntaNo2, String preguntaNo3, String preguntaNo4,
			String preguntaNo5, String preguntaNo6, String preguntaNo7, String preguntaNo8,
			String preguntaNo9, String preguntaNo10, String preguntaNo11, String preguntaNo12,
			String preguntaNo13, String preguntaNo14, String preguntaNo15, String preguntaNo16,
			String departamento) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudEncuestaSatisfaccion.class.getSimpleName(), idEncuestaSatisfaccion).getKey();

			SegSolicitudEncuestaSatisfaccion f = Persistencia.getObjectById(SegSolicitudEncuestaSatisfaccion.class, k);
			f.setPreguntaNo1(preguntaNo1);
			f.setPreguntaNo2(preguntaNo2);
			f.setPreguntaNo3(preguntaNo3);
			f.setPreguntaNo4(preguntaNo4);
			f.setPreguntaNo5(preguntaNo5);
			f.setPreguntaNo6(preguntaNo6);
			f.setPreguntaNo7(preguntaNo7);
			f.setPreguntaNo8(preguntaNo8);
			f.setPreguntaNo9(preguntaNo9);
			f.setPreguntaNo10(preguntaNo10);
			f.setPreguntaNo11(preguntaNo11);
			f.setPreguntaNo12(preguntaNo12);
			f.setPreguntaNo13(preguntaNo13);
			f.setPreguntaNo14(preguntaNo14);
			f.setPreguntaNo15(preguntaNo15);
			f.setPreguntaNo16(preguntaNo16);
			f.setDepartamento(departamento);

			valor = f.getIdEncuestaSatisfaccion();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}
	
	// BURO CREDITO
	
	@Override
	public Long actualizarDatosAprobacionBuroCredito(Long idFormulario, 
			Boolean creditoAprobado, Boolean creditoNoAprobado, float montoAprobado, String observacionNoAprobado) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			 try {  
					 final SegSolicitudGeneral solicitud = Persistencia.getObjectById(SegSolicitudGeneral.class, idFormulario); 
					 
					 	solicitud.setCreditoAprobado(creditoAprobado);
					 	solicitud.setCreditoNoAprobado(creditoNoAprobado);
					 	solicitud.setMontoAprobado(montoAprobado);
					 	solicitud.setObservacionNoAprobado(observacionNoAprobado);
					 	
		 }finally {  
			 Persistencia.close();  
		 }
		 
		return idFormulario;
	}	
	
		
	// Remover imagen de Blobstore
	
	@Override
	public String remove(String key)throws IllegalArgumentException {
		
	    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	    BlobKey blobKey = new BlobKey(key);
	    blobstoreService.delete(blobKey);
		return "eliminado";
	}
	
	
	
}