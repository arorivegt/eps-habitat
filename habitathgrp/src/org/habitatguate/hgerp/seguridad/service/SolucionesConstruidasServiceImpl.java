package org.habitatguate.hgerp.seguridad.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudCargaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDocumentoPropiedad;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSituacionEconomica;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionCuarta;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionSegunda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionTercera;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudCargaFamiliar;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudDocumentoPropiedad;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSituacionEconomica;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionCuarta;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionSegunda;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolicitudSupervisionTercera;
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
			String profesionOficio, int dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
			Boolean sabeLeer, Boolean sabeEscribir, Boolean sabeFirmar, 
			String direccionActual, String direccionSolucion, 
			Boolean camion, Boolean carro, Boolean peatonal,
			String lugarTrabajoSolicitante, int telefonoCasaSolicitante, int telefonoTrabajoSolicitante,
			String solucionConstruir, float cuotaPagar,
			String nombreConyuge, int telefonoConyuge, String lugarTrabajoConyuge, int telefonoTrabajoConyuge,
			Boolean garantia, Boolean aprobacion, 
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
		solicitud.setGarantia(garantia);
		solicitud.setAprobacion(garantia);
		solicitud.setPrimeraSupervision(primeraSupervision);
		solicitud.setSegundaSupervision(segundaSupervision);
		solicitud.setTerceraSupervision(terceraSupervision);
		solicitud.setCuartaSupervision(cuartaSupervision);

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
			SegSolicitudDocumentoPropiedad documento = new  SegSolicitudDocumentoPropiedad();

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
			solicitud.getDocumentoPropiedad().add(documento);
			
			solicitud.setGarantia(actualizacionGarantia); // Actualizacion de Valor
			
			valor = documento.getIdDocumentoPropiedad();

			System.out.println("DATOS DOCUMENTO PROPIEDAD ALMACENADO CORRECTAMENTE EN DATASTORE");

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
			primera.setURLFile(URLFile);
			primera.setKeyFile(KeyFile);
			primera.setIdFormulario(idFormulario); // Llave Foranea

			primera.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionPrimera().add(primera);

			solicitud.setPrimeraSupervision(true); // Actualizacion de Valor

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
			Boolean satisfactoria, Boolean noSatisfactoria) throws IllegalArgumentException {

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
			segunda.setIdFormulario(idFormulario); // Llave Foranea

			segunda.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionSegunda().add(segunda);

			solicitud.setSegundaSupervision(true); // Actualizacion de Valor

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
			Boolean satisfactoria, Boolean noSatisfactoria) throws IllegalArgumentException {

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
			tercera.setIdFormulario(idFormulario); // Llave Foranea

			tercera.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionTercera().add(tercera);

			solicitud.setTerceraSupervision(true); // Actualizacion de Valor

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
			Boolean satisfactoria, Boolean noSatisfactoria) throws IllegalArgumentException {

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
			cuarta.setIdFormulario(idFormulario); // Llave Foranea

			cuarta.setSolicitud(solicitud); // Relacion
			solicitud.getSupervisionCuarta().add(cuarta);

			solicitud.setCuartaSupervision(true); // Actualizacion de Valor

			valor = cuarta.getIdSupervisionCuarta();

			System.out.println("DATOS CUARTA SUPERVISION ALMACENADO CORRECTAMENTE EN DATASTORE");

		}finally {  
			Persistencia.close();  
		}
		return valor ;
	}	
	
	// SOLUCIONES

	@SuppressWarnings("unchecked")
	@Override
	public List<AuxSolicitudGeneral> buscarFormulario(char tipo, Long idEmpleado, Long idAfiliado, String nombreSolicitante, String solucionConstruir)throws IllegalArgumentException {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
		List<AuxSolicitudGeneral> valor = new ArrayList<AuxSolicitudGeneral>();
		List<SegSolicitudGeneral> results = new ArrayList<SegSolicitudGeneral>() ;
		
		if(tipo=='1'){
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class,
					"nombreSolicitante == '"+nombreSolicitante+"'" +
					" && idAfiliado == " + idAfiliado +
					" && idEmpleado == " + idEmpleado
					);
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}else if(tipo =='2'){
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class,			// Realiza una busqueda ESPECIFICA
					"idEmpleado == " + idEmpleado +
					" && idAfiliado == " + idAfiliado
					);
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}else if(tipo =='3'){
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class,
					"solucionConstruir == '"+solucionConstruir+"'" +
					" && idAfiliado == " + idAfiliado +
					" && idEmpleado == " + idEmpleado
					);
			results = (List<SegSolicitudGeneral>) q.execute();
			
		}else if(tipo =='4'){
			
			System.out.println("ENTRO EN BUSQUEDA: " + tipo);
			
			Query q = pm.newQuery(SegSolicitudGeneral.class);			// Realiza una busqueda GENERAL
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
				nuevo.setAprobacion(p.getAprobacion());
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
						l.setTotalIngresos(n0.getIngresosTotales());
						l.setTotalEgresos(n0.getTotalEgresos());
						l.setDiferencia(n0.getDiferencia());
						l.setPagosBuro(n0.getPagosBuro());
						l.setCuota(n0.getCuota());
						l.setExcedente(n0.getExcedente());
						l.setAlquilerVivienda(n0.getAlquilerVivienda());
						l.setAlimentacion(n0.getAlquilerVivienda());
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
				
				List<SegSolicitudDocumentoPropiedad> results04 = p.getDocumentoPropiedad();
				if (!results04.isEmpty()) {
					for (SegSolicitudDocumentoPropiedad n0 : results04) {
						AuxSolicitudDocumentoPropiedad l = new AuxSolicitudDocumentoPropiedad();
						
						l.setIdDocumentoPropiedad(n0.getIdDocumentoPropiedad());
						l.setIdFormulario(n0.getIdFormulario());
						l.setEscrituraNoRegistrada(n0.getEscrituraNoRegistrada());
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
						nuevo.getDocumentoPropiedad().add(l); // Agregado a Entidad Principal
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
						nuevo.getSupervisionCuarta().add(l); // Agregado a Entidad Principal
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
			nuevo.setAprobacion(p.getAprobacion());
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
			if (!results0.isEmpty()) {
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
					l.setTotalIngresos(n0.getIngresosTotales());
					l.setTotalEgresos(n0.getTotalEgresos());
					l.setDiferencia(n0.getDiferencia());
					l.setPagosBuro(n0.getPagosBuro());
					l.setCuota(n0.getCuota());
					l.setExcedente(n0.getExcedente());
					l.setAlquilerVivienda(n0.getAlquilerVivienda());
					l.setAlimentacion(n0.getAlquilerVivienda());
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
			
			List<SegSolicitudDocumentoPropiedad> results04 = p.getDocumentoPropiedad();
			if (!results04.isEmpty()) {
				for (SegSolicitudDocumentoPropiedad n0 : results04) {
					AuxSolicitudDocumentoPropiedad l = new AuxSolicitudDocumentoPropiedad();
					
					l.setIdDocumentoPropiedad(n0.getIdDocumentoPropiedad());
					l.setIdFormulario(n0.getIdFormulario());
					l.setEscrituraNoRegistrada(n0.getEscrituraNoRegistrada());
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
					nuevo.getDocumentoPropiedad().add(l); // Agregado a Entidad Principal
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
					nuevo.getSupervisionCuarta().add(l); // Agregado a Entidad Principal
				}
			}			
			
			
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
			String profesionOficio, int dpi, int dpiUnico, int dpiReferencia, String actividadEconomica,
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
			.addChild(SegSolicitudReferenciaFamiliar.class.getSimpleName(), idReferenciaFamiliar)
			.getKey();

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
		Key k = new KeyFactory
				.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
		.addChild(SegSolicitudReferenciaFamiliar.class.getSimpleName(), id)
		.getKey();
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
			.addChild(SegSolicitudReferenciaFamiliar.class.getSimpleName(), idReferenciaFamiliar)
			.getKey();

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
		Key k = new KeyFactory
				.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
		.addChild(SegSolicitudReferenciaFamiliar.class.getSimpleName(), id)
		.getKey();
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
			.addChild(SegSolicitudDatosVivienda.class.getSimpleName(), idDatosVivienda)
			.getKey();

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
			.addChild(SegSolicitudSituacionEconomica.class.getSimpleName(), idSituacionEconomica)
			.getKey();

			SegSolicitudSituacionEconomica f = Persistencia.getObjectById(SegSolicitudSituacionEconomica.class, k);
			f.setIngresosSolicitante(ingresosSolicitante);
			f.setIngresosConyuge(ingresosConyuge);
			f.setOtrosIngresos(otrosIngresos);
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
			.addChild(SegSolicitudDocumentoPropiedad.class.getSimpleName(), idGarantiaHipotecaria)
			.getKey();

			SegSolicitudDocumentoPropiedad f = Persistencia.getObjectById(SegSolicitudDocumentoPropiedad.class, k);
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
	
	
	// SUPERVISION PRIMERA

	@Override
	public Long actualizarSupervisionPrimera(Long idFormulario, Long idSupervisionPrimera,
			Date fechaVisita,
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String  URLFile, String KeyFile) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionPrimera.class.getSimpleName(), idSupervisionPrimera)
			.getKey();

			SegSolicitudSupervisionPrimera f = Persistencia.getObjectById(SegSolicitudSupervisionPrimera.class, k);
			f.setFechaVisita(fechaVisita);
			f.setCheckSi(checkSi);
			f.setCheckNo(checkNo);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);
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
			Boolean satisfactoria, Boolean noSatisfactoria) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionSegunda.class.getSimpleName(), idSupervisionSegunda)
			.getKey();

			SegSolicitudSupervisionSegunda f = Persistencia.getObjectById(SegSolicitudSupervisionSegunda.class, k);
			f.setFechaVisita(fechaVisita);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);

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
			Boolean satisfactoria, Boolean noSatisfactoria) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionTercera.class.getSimpleName(), idSupervisionTercera)
			.getKey();

			SegSolicitudSupervisionTercera f = Persistencia.getObjectById(SegSolicitudSupervisionTercera.class, k);
			f.setFechaVisita(fechaVisita);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);

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
			Boolean satisfactoria, Boolean noSatisfactoria) throws IllegalArgumentException {

		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 

		Long valor = 0L;
		try { 
			Key k = new KeyFactory
					.Builder(SegSolicitudGeneral.class.getSimpleName(), idFormulario)
			.addChild(SegSolicitudSupervisionCuarta.class.getSimpleName(), idSupervisionCuarta)
			.getKey();

			SegSolicitudSupervisionCuarta f = Persistencia.getObjectById(SegSolicitudSupervisionCuarta.class, k);
			f.setFechaVisita(fechaVisita);
			f.setObservaciones(observaciones);
			f.setAcciones(acciones);
			f.setCheckSatisfactoria(satisfactoria);
			f.setCheckNoSatisfactoria(noSatisfactoria);

			valor = f.getIdSupervisionCuarta();

		} finally {
			Persistencia.close();
		}
		return valor ;
	}		
	
	@Override
	public String remove(String key)throws IllegalArgumentException {
		
	    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	    BlobKey blobKey = new BlobKey(key);
	    blobstoreService.delete(blobKey);
		return "eliminado";
	}
	
	
	
}