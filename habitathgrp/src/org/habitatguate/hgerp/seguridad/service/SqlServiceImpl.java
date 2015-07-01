package org.habitatguate.hgerp.seguridad.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialPagoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.finanzas.Plantilla_Solucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegAfiliado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegBeneficiario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.service.jdo.SegDetalleEjecucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegDetalleSolucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegEmpleado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegEntrevista;
import org.habitatguate.hgerp.seguridad.service.jdo.SegHistorial;
import org.habitatguate.hgerp.seguridad.service.jdo.SegHistorialPagoProv;
import org.habitatguate.hgerp.seguridad.service.jdo.SegMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegParametro;
import org.habitatguate.hgerp.seguridad.service.jdo.SegPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegProveedor;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSolucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegVale;
import org.habitatguate.hgerp.util.ConvertDate;
import org.habitatguate.hgerp.util.PMF;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.i18n.server.testing.Child;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.Persistent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SqlServiceImpl extends RemoteServiceServlet implements SqlService{

	
	//--------------------------------INSERTAR---------------------------------------------------
	@Override
	public String[] Insertar(String nomParam,int codContable,int codUno, int codDos) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(nomParam!=null){
			System.out.println("GUARDANDO PARAMETRO");
			
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			SegParametro nuevo = new SegParametro(nomParam, codContable, codUno, codDos);
			try{
				gestorPersistencia.makePersistent(nuevo);
				System.out.println("PARAMETRO GUARDADO CORRECTAMENTE");
			}finally{
				gestorPersistencia.close();
			}
		}
		return null;
	}
	@Override
	public Long Insertar_Afiliado(String nomAfiliado,String dirAfiliado,String municipio,String departamento) throws IllegalArgumentException{
			 Long valor = 0L;
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			SegAfiliado nuevo = new SegAfiliado();
			nuevo.setNomAfiliado(nomAfiliado);
			nuevo.setDirAfiliado(dirAfiliado);
			nuevo.setMunicipio(municipio);
			nuevo.setDepartamento(departamento);
			
			try{
				gestorPersistencia.makePersistent(nuevo);
				System.out.println("PARAMETRO GUARDADO CORRECTAMENTE");
				valor = nuevo.getIdAfiliado();
			}finally{
				gestorPersistencia.close();
			}
			return valor;
	}

	public Long Insertar_Beneficiario(String nomBeneficiario,String dirBeneficiario,int telBeneficiario,Long idAfiliado) throws IllegalArgumentException{
		 Long valor = 0L;
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		SegAfiliado selectB = gestorPersistencia.getObjectById(SegAfiliado.class,idAfiliado);
		SegBeneficiario nuevo = new SegBeneficiario();
		nuevo.setNomBeneficiario(nomBeneficiario);
		nuevo.setDirBeneficiario(dirBeneficiario);
		nuevo.setTelBeneficiario(telBeneficiario);
		selectB.getSolucion().add(nuevo);
		
		try{
			gestorPersistencia.makePersistent(nuevo);
			System.out.println("BENEFICIARIO GUARDADO CORRECTAMENTE");
			valor = nuevo.getIdBeneficiario().getId();
		}finally{
			gestorPersistencia.close();
		}
		return valor;
}
	
	public Long Insertar_MaterialCostruccion(String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario) throws IllegalArgumentException{
		 Long valor = 0L;
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		//SegProveedor prov = gestorPersistencia.getObjectById(SegProveedor.class,idProveedor);
		SegMaterialCostruccion nuevo = new SegMaterialCostruccion();
		nuevo.setNomMaterialCostruccion(nomMaterialCostruccion);
		nuevo.setPrecioUnit(precioUnitario);
		nuevo.setUnidadMetrica(unidadMetrica);
		Date time=new Date();
		Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
		nuevo.setFechaIngreso(today);
		//nuevo.setProveedor(prov);
		//prov.getMaterialCostruccion().add(nuevo);
		try{
			gestorPersistencia.makePersistent(nuevo);
	//		gestorPersistencia.makePersistent(prov);
			System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
			valor = nuevo.getIdMaterialConstruccion().getId();
		}finally{
			gestorPersistencia.close();
		}
		return valor;
}
	public Long Insertar_PlantillaSolucion(String nomPlantilla,String tipo,Double costoFinal) throws IllegalArgumentException{
		Long valor = 0L;
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		SegPlantillaSolucion nuevo = new SegPlantillaSolucion();
		nuevo.setNomPlantillaSolucion(nomPlantilla);
		nuevo.setTipo(tipo);
		nuevo.setCostoFinal(costoFinal);
		Date time=new Date();
		Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
		nuevo.setFechaCreacion(today);
		try{
			gestorPersistencia.makePersistent(nuevo);
			System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
			valor = nuevo.getIdPlantillaSolucion();
		}finally{
			gestorPersistencia.close();
		}
		return valor;
}

public Long Insertar_DetallePlantillaSolucion(Long idPlantillaSolucion,List<AuxDetallePlantillaSolucion> listaDetallePlantilla){
	 Long valor = 0L;
		System.out.println(listaDetallePlantilla.get(0).getNomMaterialCostruccion());
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		
	try {
		SegPlantillaSolucion plantilla = gestorPersistencia.getObjectById(SegPlantillaSolucion.class,idPlantillaSolucion);
		Iterator<AuxDetallePlantillaSolucion> i = listaDetallePlantilla.iterator();
		while(i.hasNext()){
			
			AuxDetallePlantillaSolucion aux = i.next();
			System.out.println(aux.getNomMaterialCostruccion());
			SegDetallePlantillaSolucion auxSeg = new SegDetallePlantillaSolucion();
			auxSeg.setNomMaterialCostruccion(aux.getNomMaterialCostruccion());
			auxSeg.setPrecioUnit(aux.getPrecioUnit());
			auxSeg.setCantidad(aux.getCantidad());
			auxSeg.setUnidadMetrica(aux.getUnidadMetrica());
			auxSeg.setCostoAcumulado(aux.getCostoAcumulado());
			auxSeg.setSubTotal(aux.getSubTotal());
			auxSeg.setPlantillaSolucion(plantilla);
			plantilla.getListaDetalle().add(auxSeg);
			gestorPersistencia.makePersistent(auxSeg);			
		}
	} finally {
	    valor = idPlantillaSolucion;
	    gestorPersistencia.close();
	}
	
	return valor;
	
	
}

public Long Insertar_UnicoDetallePlantillaSolucion(Long idPlantillaSolucion,AuxDetallePlantillaSolucion auxDetalle) throws IllegalArgumentException{
	 Long valor = 0L;
	 SegPlantillaSolucion plantilla = null;
	 SegMaterialCostruccion materialCos = null;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	try{
		//System.out.println("Plantilla de la que viene " + idPlantillaSolucion);
		plantilla = gestorPersistencia.getObjectById(SegPlantillaSolucion.class,idPlantillaSolucion);
		 Key k = new KeyFactory
			        .Builder(SegProveedor.class.getSimpleName(), auxDetalle.getMaterialCostruccion().getProveedor().getIdProveedor())
		 			.addChild(SegMaterialCostruccion.class.getSimpleName(), auxDetalle.getMaterialCostruccion().getIdMaterialConstruccion())	
			        .getKey();
		materialCos = gestorPersistencia.getObjectById(SegMaterialCostruccion.class,k);
		SegDetallePlantillaSolucion auxSeg = new SegDetallePlantillaSolucion();
			auxSeg.setNomMaterialCostruccion(auxDetalle.getNomMaterialCostruccion());
			auxSeg.setPrecioUnit(auxDetalle.getPrecioUnit());
			auxSeg.setCantidad(auxDetalle.getCantidad());
			auxSeg.setUnidadMetrica(auxDetalle.getUnidadMetrica());
			auxSeg.setCostoAcumulado(auxDetalle.getCostoAcumulado());
			auxSeg.setSubTotal(auxDetalle.getSubTotal());
			auxSeg.setPlantillaSolucion(plantilla);
			auxSeg.setMaterialCostruccion(materialCos);
			plantilla.getListaDetalle().add(auxSeg);	
	       valor = auxSeg.getIdDetallePlantillaSolucion().getId();
	       gestorPersistencia.makePersistent(auxSeg);
	       gestorPersistencia.makePersistent(plantilla);
	}	finally{
		gestorPersistencia.close();
	}
	return valor;
	
	
}

public Long Insertar_Proveedor(Boolean aprobadoComision,
		String dirProveedor,
		Date fechaIngreso,
		String nomProveedor,
		String numeroNit,
		String paginaWeb,
		String personaJuridica,
		Boolean servicioEntrega,
		String telProveedor,
		String observaciones) throws IllegalArgumentException{
	 Long valor = 0L;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	SegProveedor nuevo = new SegProveedor();
	nuevo.setAprobadoComision(aprobadoComision);
	nuevo.setDirProveedor(dirProveedor);
	Calendar c = Calendar.getInstance();
	nuevo.setFechaIngreso(new java.sql.Date(c.getTimeInMillis()));
	nuevo.setNomProveedor(nomProveedor);
	nuevo.setNumeroNit(numeroNit);
	nuevo.setPaginaWeb(paginaWeb);
	nuevo.setPersonaJuridica(personaJuridica);
	nuevo.setServicioEntrega(servicioEntrega);
	nuevo.setTelProveedor(telProveedor);
	nuevo.setObservaciones(observaciones);
	try{
		gestorPersistencia.makePersistent(nuevo);
		System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
		valor = nuevo.getIdProveedor().getId();
	}finally{
		gestorPersistencia.close();
	}
	return valor;
}

public Long Insertar_ProveedorCompleto(Boolean aprobadoComision,
		String dirProveedor,
		Date fechaIngreso,
		String nomProveedor,
		String numeroNit,
		String paginaWeb,
		String personaJuridica,
		Boolean servicioEntrega,
		String telProveedor,
		String observaciones,
		
		String razonSocial,
		String actividadEcono,
		String aceptaExencion,
		String relacionConProv,
		String tipoProveedor,
		String productosfrece,
		String disponibilidadProd,
		String tiempoEntrega,
		String regimenTributario,
		String aceptaDonacion,
		double porcentDonacion		
		) throws IllegalArgumentException{
	 Long valor = 0L;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	SegProveedor nuevo = new SegProveedor();
	nuevo.setAprobadoComision(aprobadoComision);
	nuevo.setDirProveedor(dirProveedor);
	Calendar c = Calendar.getInstance();
	nuevo.setFechaIngreso(new java.sql.Date(c.getTimeInMillis()));
	nuevo.setNomProveedor(nomProveedor);
	nuevo.setNumeroNit(numeroNit);
	nuevo.setPaginaWeb(paginaWeb);
	nuevo.setPersonaJuridica(personaJuridica);
	nuevo.setServicioEntrega(servicioEntrega);
	nuevo.setTelProveedor(telProveedor);
	nuevo.setObservaciones(observaciones);
	
	//nuevos valores
	nuevo.setRazonSocial(razonSocial);
	nuevo.setActividadEcono(actividadEcono);
	nuevo.setAceptaExencion(aceptaExencion);
	nuevo.setRelacionConProv(relacionConProv);
	nuevo.setTipoProveedor(tipoProveedor);
	nuevo.setProductosfrece(productosfrece);
	nuevo.setDisponibilidadProd(disponibilidadProd);
	nuevo.setTiempoEntrega(tiempoEntrega);
	nuevo.setRegimenTributario(regimenTributario);
	nuevo.setAceptaDonacion(aceptaDonacion);
	nuevo.setPorcentDonacion(porcentDonacion);
	
	
	try{
		gestorPersistencia.makePersistent(nuevo);
		System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
		valor = nuevo.getIdProveedor().getId();
	}finally{
		gestorPersistencia.close();
	}
	return valor;
}

public Long Insertar_MaterialCostruccionAfiliadoProveedor(Long idProveedor,String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario) throws IllegalArgumentException{
	 Long valor = 0L;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	try{
	SegProveedor prov = gestorPersistencia.getObjectById(SegProveedor.class,idProveedor);
	System.out.println("encontrado prov:"+ prov.getNomProveedor());
	SegMaterialCostruccion nuevo = new SegMaterialCostruccion();
	nuevo.setNomMaterialCostruccion(nomMaterialCostruccion);
	nuevo.setPrecioUnit(precioUnitario);
	nuevo.setUnidadMetrica(unidadMetrica);
	Date time=new Date();
	Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
	nuevo.setFechaIngreso(today);
	nuevo.setProveedor(prov);
	
	prov.getMaterialCostruccion().add(nuevo);
	gestorPersistencia.makePersistent(nuevo);
	valor = nuevo.getIdMaterialConstruccion().getId();
	//
	//gestorPersistencia.makePersistent(prov);
		System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
	
	}finally{
		gestorPersistencia.close();
	}
	return valor;
}

public Long Insertar_Solucion(AuxSolucion auxS,Double costoFinal) throws IllegalArgumentException{
	Long valor = 0L;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	 Key k = new KeyFactory
		        .Builder(SegAfiliado.class.getSimpleName(), auxS.getBeneficiario().getAfiliado().getIdAfiliado())
	 			.addChild(SegBeneficiario.class.getSimpleName(), auxS.getBeneficiario().getIdBeneficiario())	
		        .getKey();
	SegBeneficiario bene = gestorPersistencia.getObjectById(SegBeneficiario.class, k);
	SegSolucion nuevo = new SegSolucion();
	nuevo.setCostoAdministrativo(auxS.getCostoAdministrativo());
	nuevo.setCostoDirecto(auxS.getCostoDirecto());
	nuevo.setCostoMaterial(auxS.getCostoMaterial());
	nuevo.setDisenio(auxS.getDisenio());
	nuevo.setNotaDebito(auxS.getNotaDebito());
	nuevo.setNomSolucion(auxS.getNomSolucion());
	nuevo.setValorContrato(auxS.getValorContrato());
	nuevo.setEstadoSolucion(1);
	Date time=new Date();
	Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
	nuevo.setFechaInicio(today);
	nuevo.setBeneficiario(bene);
	bene.setSolucion(nuevo);
	try{
		gestorPersistencia.makePersistent(nuevo);
		System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
		valor = nuevo.getIdSolucion().getId();
	}finally{
		gestorPersistencia.close();
	}
	return valor;
}	

public Long Insertar_UnicoDetalleSolucion(Long idSolucion,AuxDetallePlantillaSolucion auxDetalle) throws IllegalArgumentException{
	 Long valor = 0L;
	 SegSolucion plantilla = null;
	 SegMaterialCostruccion materialCos = null;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	try{
	//	System.out.println("Plantilla de la que viene " + auxDetalle.getMaterialCostruccion().getIdMaterialConstruccion());
		plantilla = gestorPersistencia.getObjectById(SegSolucion.class,idSolucion);
		 Key k = new KeyFactory
			        .Builder(SegProveedor.class.getSimpleName(), auxDetalle.getMaterialCostruccion().getProveedor().getIdProveedor())
		 			.addChild(SegMaterialCostruccion.class.getSimpleName(), auxDetalle.getMaterialCostruccion().getIdMaterialConstruccion())	
			        .getKey();
		materialCos = gestorPersistencia.getObjectById(SegMaterialCostruccion.class,k);
		SegDetalleSolucion auxSeg = new SegDetalleSolucion();
			auxSeg.setCantidad(auxDetalle.getCantidad());
			auxSeg.setUnidadMetrica(auxDetalle.getUnidadMetrica());
			auxSeg.setCostoAcumulado(auxDetalle.getCostoAcumulado());
			auxSeg.setSubTotal(auxDetalle.getSubTotal());
			auxSeg.setSolucion(plantilla);
			auxSeg.setMaterialCostruccion(materialCos);
			auxSeg.setCantidadEjecutada(0.0);
			plantilla.getListaDetalle().add(auxSeg);	
	       valor = auxSeg.getIdDetalleSolucion().getId();
	       gestorPersistencia.makePersistent(auxSeg);
	       gestorPersistencia.makePersistent(plantilla);
	}	finally{
		gestorPersistencia.close();
	}
	return valor;
	
	
}

public Long Insertar_UnicoHistorialSolucion(Long idSolucion,Long idVale,AuxDetallePlantillaSolucion auxDetalle) throws IllegalArgumentException{
	 Long valor = 0L;
	 SegSolucion plantilla = null;
	 SegMaterialCostruccion materialCos = null;
	 SegVale valeActual = null;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	try{
	//	System.out.println("Plantilla de la que viene " + auxDetalle.getMaterialCostruccion().getIdMaterialConstruccion());
		plantilla = gestorPersistencia.getObjectById(SegSolucion.class,idSolucion);
		 Key k = new KeyFactory
			        .Builder(SegProveedor.class.getSimpleName(), auxDetalle.getMaterialCostruccion().getProveedor().getIdProveedor())
		 			.addChild(SegMaterialCostruccion.class.getSimpleName(), auxDetalle.getMaterialCostruccion().getIdMaterialConstruccion())	
			        .getKey();
		materialCos = gestorPersistencia.getObjectById(SegMaterialCostruccion.class,k);
		valeActual = gestorPersistencia.getObjectById(SegVale.class,idVale);
		SegDetalleEjecucion auxSeg = new SegDetalleEjecucion();
			auxSeg.setCantidad(auxDetalle.getCantidad());
			auxSeg.setUnidadMetrica(auxDetalle.getUnidadMetrica());
			auxSeg.setPrecioEjecucion(auxDetalle.getPrecioUnit());
			auxSeg.setSubTotal(auxDetalle.getSubTotal());
			auxSeg.setSolucion(plantilla);
			auxSeg.setMaterialCostruccion(materialCos);
			auxSeg.setVale(valeActual);
			//Busqueda del detalle de la solucion planificada
			List<SegDetalleSolucion> listaPlani = plantilla.getListaDetalle();
			Iterator<SegDetalleSolucion> iter = listaPlani.iterator();
			while(iter.hasNext()){
				SegDetalleSolucion auxIter = iter.next();
				System.out.println(auxIter.getMaterialCostruccion().getIdMaterialConstruccion() + "Contra " + k);
				if (auxIter.getMaterialCostruccion().getIdMaterialConstruccion().compareTo(k)== 0){
					auxIter.setCantidadEjecutada(auxIter.getCantidadEjecutada()+auxDetalle.getCantidad());
					//gestorPersistencia.makePersistent(auxIter);
				}
			}
			//----------------------------------------
			plantilla.getListaEjecucion().add(auxSeg);	
			valor = auxSeg.getIdDetalleSolucion().getId();
		    gestorPersistencia.makePersistent(plantilla);
			gestorPersistencia.makePersistent(auxSeg);

	}	finally{
		gestorPersistencia.close();
	}
	return valor;
	
	
}

public Long Insertar_PagoVale(Long idVale, Date fechaVale, String serieDocumento, String tipoDocumento, Double valorPago) throws IllegalArgumentException{
	 Long valor = 0L;
	 
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	try{
		//System.out.println("Plantilla de la que viene " + idPlantillaSolucion);
		//
		SegHistorialPagoProv auxPago = new SegHistorialPagoProv();
		  auxPago.setFechaVale(fechaVale);
		  auxPago.setSerieDocumento(serieDocumento);
		  auxPago.setTipoDocumento(tipoDocumento);
		  auxPago.setValorPago(valorPago);
		  gestorPersistencia.makePersistent(auxPago);
	      valor = auxPago.getIdHistorialPagoProv();
	      return valor;
	}	finally{
		gestorPersistencia.close();
	}
	
	
}


public Long Insertar_ValePagado(Long idHistorialPagoProv, Long idVale,Double totalPago) throws IllegalArgumentException {
	SegVale vale = null;
	SegHistorialPagoProv  pagoHistorico= null;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	pagoHistorico = gestorPersistencia.getObjectById(SegHistorialPagoProv.class,idHistorialPagoProv);
	vale = gestorPersistencia.getObjectById(SegVale.class,idVale);
	
	pagoHistorico.getVale().add(vale);
	vale.getListaPagoProv().add(pagoHistorico);
	vale.setTotalPagado(vale.getTotalPagado()+totalPago);
	
	
	return 0L;
}

public Long GenerarIdVale() throws IllegalArgumentException{
	 Long valor = 0L;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	SegVale nuevo = new SegVale();
	nuevo.setEstado(false);
	
	try{
		gestorPersistencia.makePersistent(nuevo);
		valor = nuevo.getIdVale();
	}finally{
		gestorPersistencia.close();
	}
	return valor;
	
}

public Long Insertar_Catalogo(String idMaterial,String nombreMaterial,String categoriaMaterial) throws IllegalArgumentException{
	Long valor = 0L;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	SegCatalogoMaterial nuevo = new SegCatalogoMaterial();
	nuevo.setIdMaterial(idMaterial);
	nuevo.setNombreMaterial(nombreMaterial);
	nuevo.setCategoriaMaterial(categoriaMaterial);
	nuevo.setStatus(1);
	try{
		gestorPersistencia.makePersistent(nuevo);
		System.out.println("CATEGORIA GUARDADO CORRECTAMENTE");
		valor = nuevo.getIdCatalogoMaterial();
	}finally{
		gestorPersistencia.close();
	}
	return valor;
}

///////-------------------------------------------------------ELIMINAR------------------------------------	
    @Override
    public Long Eliminar_Parametro(Long id) throws IllegalArgumentException {
    	
    	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
    	final SegParametro e = Persistencia.getObjectById(SegParametro.class, id); 
        Persistencia.deletePersistent(e);         
        return id;
    }	
	
	@Override
    public Long Eliminar_Afiliado(Long id) throws IllegalArgumentException {
    	
    	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
    	final SegAfiliado e = Persistencia.getObjectById(SegAfiliado.class, id); 
        Persistencia.deletePersistent(e);         
        return id;
    }
    public Long Eliminar_Beneficiario(Long id) throws IllegalArgumentException {
    	
    	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
    	final SegBeneficiario e = Persistencia.getObjectById(SegBeneficiario.class, id); 
        Persistencia.deletePersistent(e);         
        return id;
    }
    public Long Eliminar_MaterialCostruccion(Long id) throws IllegalArgumentException {
    	
    	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
    	final SegMaterialCostruccion e = Persistencia.getObjectById(SegMaterialCostruccion.class, id); 
        Persistencia.deletePersistent(e);         
        return id;
    }
    public Long Eliminar_Proveedor(Long id) throws IllegalArgumentException {
    	
    	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
    	final SegProveedor e = Persistencia.getObjectById(SegProveedor.class, id);
    	System.out.println(e.getNomProveedor());
        Persistencia.deletePersistent(e);         
        return id;
    }
    public Long Eliminar_ProductoCatalogo(Long id) throws IllegalArgumentException {
    	
    	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
    	final SegCatalogoMaterial e = Persistencia.getObjectById(SegCatalogoMaterial.class, id);
    	try{
    		e.setStatus(0);	
    	}finally{
    		Persistencia.close();
    	}
        return id;
    }
	
//------------------------------------------------------CONSULTAS--------------------------------------------------	
    @Override
	public List<AuxParametro> ConsultaTodosParam(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegParametro.class);
		List<AuxParametro> valor = new ArrayList<AuxParametro>();
		List<SegParametro> execute = (List<SegParametro>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegParametro p : execute){
				AuxParametro aux = new AuxParametro();
				aux.setIdParametro(p.getIdParametro());
				aux.setNomParametro(p.getNomParametro());
				aux.setCodContable(p.getCodContable());
				aux.setCodUno(p.getCodUno());
				aux.setCodDos(p.getCodDos());
				valor.add(aux);
			}
		}
		return valor;
	}

    @Override
	public List<AuxAfiliado> ConsultaTodosAfiliados(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegAfiliado.class);
		List<AuxAfiliado> valor = new ArrayList<AuxAfiliado>();
		List<SegAfiliado> execute = (List<SegAfiliado>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegAfiliado p : execute){
				AuxAfiliado n= new AuxAfiliado();
				n.setIdAfiliado(p.getIdAfiliado());
				n.setNomAfiliado(p.getNomAfiliado());
				n.setDirAfiliado(p.getDirAfiliado());
				n.setMunicipio(p.getMunicipio());
				n.setDepartamento(p.getDepartamento());
				valor.add(n);
			}
		}
		return valor;
	}
	public List<AuxCatalogoMaterial> ConsultaTodosProductosCatalogo(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegCatalogoMaterial.class);
		query.setFilter("status == 1");
		List<AuxCatalogoMaterial> valor = new ArrayList<AuxCatalogoMaterial>();
		List<SegCatalogoMaterial> execute = (List<SegCatalogoMaterial>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegCatalogoMaterial p : execute){
				AuxCatalogoMaterial n= new AuxCatalogoMaterial();
				n.setIdCatalogoMaterial(p.getIdCatalogoMaterial());
				n.setIdMaterial(p.getIdMaterial());
				n.setCategoriaMaterial(p.getCategoriaMaterial());
				n.setNombreMaterial(p.getNombreMaterial());
				n.setStatus(p.getStatus());
				valor.add(n);
			}
		}
		return valor;
	}
    
	public List<AuxBeneficiario> ConsultaTodosBene(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegBeneficiario.class);
		List<AuxBeneficiario> valor = new ArrayList<AuxBeneficiario>();
		List<SegBeneficiario> execute = (List<SegBeneficiario>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegBeneficiario p : execute){
				AuxBeneficiario n= new AuxBeneficiario();
				n.setIdBeneficiario(p.getIdBeneficiario().getId());
				n.setNomBeneficiario(p.getNomBeneficiario());
				n.setDirBeneficiario(p.getDirBeneficiario());
				n.setTelBeneficiario(p.getTelBeneficiario());
				AuxAfiliado aux = new AuxAfiliado();
				aux.setIdAfiliado(p.getAfiliado().getIdAfiliado());
				aux.setDepartamento(p.getAfiliado().getDepartamento());
				aux.setDirAfiliado(p.getAfiliado().getDirAfiliado());
				aux.setMunicipio(p.getAfiliado().getMunicipio());
				aux.setNomAfiliado(p.getAfiliado().getNomAfiliado());
				n.setAfiliado(aux);
				valor.add(n);
			}
		}
		return valor;
	}
	public List<AuxMaterialCostruccion> ConsultaTodosMaterialCostruccion(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegMaterialCostruccion.class);
		List<AuxMaterialCostruccion> valor = new ArrayList<AuxMaterialCostruccion>();
		List<SegMaterialCostruccion> execute = (List<SegMaterialCostruccion>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegMaterialCostruccion p : execute){
				AuxMaterialCostruccion n= new AuxMaterialCostruccion();
				n.setIdMaterialConstruccion(p.getIdMaterialConstruccion().getId());
				n.setNomMaterialCostruccion(p.getNomMaterialCostruccion());
				n.setUnidadMetrica(p.getUnidadMetrica());
				n.setPrecioUnit(p.getPrecioUnit());
				n.setFechaIngreso(ConvertDate.g(p.getFechaIngreso()));
				n.getProveedor().setIdProveedor(p.getProveedor().getIdProveedor().getId());
				valor.add(n);
			}
		}
		return valor;
	}
	
	public List<AuxPlantillaSolucion> ConsultaTodasPlantillas(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegPlantillaSolucion.class);
		List<AuxPlantillaSolucion> valor = new ArrayList<AuxPlantillaSolucion>();
		List<SegPlantillaSolucion> execute = (List<SegPlantillaSolucion>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegPlantillaSolucion p : execute){
				//System.out.println(p.getListaDetalle().get(0).getNomMaterialCostruccion());
				AuxPlantillaSolucion n= new AuxPlantillaSolucion();
				n.setIdPlantillaSolucion(p.getIdPlantillaSolucion());
				n.setNomPlantillaSolucion(p.getNomPlantillaSolucion());
				n.setCostoFinal(p.getCostoFinal());
				n.setFechaCreacion(ConvertDate.g(p.getFechaCreacion()));
				n.setTipo(p.getTipo());
				Iterator<SegDetallePlantillaSolucion> i = p.getListaDetalle().iterator();
				while(i.hasNext()){
					SegDetallePlantillaSolucion aux = i.next();
					AuxDetallePlantillaSolucion auxd = new AuxDetallePlantillaSolucion();
					auxd.setIdDetallePlantillaSolucion(aux.getIdDetallePlantillaSolucion().getId());
					auxd.setNomMaterialCostruccion(aux.getNomMaterialCostruccion());
					auxd.setCantidad(aux.getCantidad());
					auxd.setCostoAcumulado(aux.getCostoAcumulado());
					auxd.setPrecioUnit(aux.getPrecioUnit());
					auxd.setSubTotal(aux.getSubTotal());
					auxd.setUnidadMetrica(aux.getUnidadMetrica());
					auxd.getMaterialCostruccion().setIdMaterialConstruccion(aux.getMaterialCostruccion().getIdMaterialConstruccion().getId());
					auxd.getMaterialCostruccion().getProveedor().setIdProveedor(aux.getMaterialCostruccion().getProveedor().getIdProveedor().getId());
					n.getListaDetalle().add(auxd);
				}
				valor.add(n);
			}
		}
		return valor;
	}

	public List<AuxProveedor> ConsultaTodosProveedor_PorAfiliado(Long Afiliado){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegProveedor.class);
		List<AuxProveedor> valor = new ArrayList<AuxProveedor>();
		List<SegProveedor> execute = (List<SegProveedor>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegProveedor p : execute){
				AuxProveedor aux = new AuxProveedor();
				aux.setAprobadoComision(p.getAprobadoComision());
				aux.setDirProveedor(p.getDirProveedor());
				aux.setFechaIngreso(ConvertDate.g(p.getFechaIngreso()));
				aux.setIdProveedor(p.getIdProveedor().getId());
				aux.setNomProveedor(p.getNomProveedor());
				aux.setNumeroNit(p.getNumeroNit());
				aux.setObservaciones(p.getObservaciones());
				aux.setPaginaWeb(p.getPaginaWeb());
				aux.setPersonaJuridica(p.getPersonaJuridica());
				aux.setServicioEntrega(p.getServicioEntrega());
				aux.setTelProveedor(p.getTelProveedor());
				valor.add(aux);
			}
		}
		return valor;
	}
	public List<AuxProveedor> ConsultaTodosProveedor_PorAfiliadoAprobados(Long Afiliado){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegProveedor.class);
		query.setFilter("aprobadoComision == true");
		List<AuxProveedor> valor = new ArrayList<AuxProveedor>();
		List<SegProveedor> execute = (List<SegProveedor>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegProveedor p : execute){
				AuxProveedor aux = new AuxProveedor();
				aux.setAprobadoComision(p.getAprobadoComision());
				aux.setDirProveedor(p.getDirProveedor());
				aux.setFechaIngreso(ConvertDate.g(p.getFechaIngreso()));
				aux.setIdProveedor(p.getIdProveedor().getId());
				aux.setNomProveedor(p.getNomProveedor());
				aux.setNumeroNit(p.getNumeroNit());
				aux.setObservaciones(p.getObservaciones());
				aux.setPaginaWeb(p.getPaginaWeb());
				aux.setPersonaJuridica(p.getPersonaJuridica());
				aux.setServicioEntrega(p.getServicioEntrega());
				aux.setTelProveedor(p.getTelProveedor());
				valor.add(aux);
			}
		}
		return valor;
	}
	
	public List<AuxProveedor> ConsultaTodosProveedor_Aprobados(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegProveedor.class);
		query.setFilter("aprobadoComision == true");
		List<AuxProveedor> valor = new ArrayList<AuxProveedor>();
		List<SegProveedor> execute = (List<SegProveedor>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegProveedor p : execute){
				AuxProveedor aux = new AuxProveedor();
				aux.setAprobadoComision(p.getAprobadoComision());
				aux.setDirProveedor(p.getDirProveedor());
				aux.setFechaIngreso(ConvertDate.g(p.getFechaIngreso()));
				aux.setIdProveedor(p.getIdProveedor().getId());
				aux.setNomProveedor(p.getNomProveedor());
				aux.setNumeroNit(p.getNumeroNit());
				aux.setObservaciones(p.getObservaciones());
				aux.setPaginaWeb(p.getPaginaWeb());
				aux.setPersonaJuridica(p.getPersonaJuridica());
				aux.setServicioEntrega(p.getServicioEntrega());
				aux.setTelProveedor(p.getTelProveedor());
				valor.add(aux);
			}
		}
		return valor;
	}
	
	public List<AuxProveedor> ConsultaTodosProveedor_SinAprobar(Long Afiliado){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegProveedor.class);
		query.setFilter("aprobadoComision == false");
		List<AuxProveedor> valor = new ArrayList<AuxProveedor>();
		List<SegProveedor> execute = (List<SegProveedor>)query.execute("Google App Engine");
		if (!execute.isEmpty()){
			for (SegProveedor p : execute){
				AuxProveedor aux = new AuxProveedor();
				aux.setAprobadoComision(p.getAprobadoComision());
				aux.setDirProveedor(p.getDirProveedor());
				aux.setFechaIngreso(ConvertDate.g(p.getFechaIngreso()));
				aux.setIdProveedor(p.getIdProveedor().getId());
				aux.setNomProveedor(p.getNomProveedor());
				aux.setNumeroNit(p.getNumeroNit());
				aux.setObservaciones(p.getObservaciones());
				aux.setPaginaWeb(p.getPaginaWeb());
				aux.setPersonaJuridica(p.getPersonaJuridica());
				aux.setServicioEntrega(p.getServicioEntrega());
				aux.setTelProveedor(p.getTelProveedor());
				valor.add(aux);
			}
		}
		return valor;
	}
	public List<AuxBeneficiario> ConsultaTodosBene_PorAfiliado(Long idAfiliado){

		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		final SegAfiliado query = gestorPersistencia.getObjectById(SegAfiliado.class,idAfiliado);
		List<AuxBeneficiario> valor = new ArrayList<AuxBeneficiario>();
		System.out.println("cantidad "+ query.getSolucion().size());
		Iterator<SegBeneficiario> auxB = query.getSolucion().iterator();
		while (auxB.hasNext()){
			SegBeneficiario p = auxB.next();
				AuxBeneficiario n= new AuxBeneficiario();
				n.setIdBeneficiario(p.getIdBeneficiario().getId());
				n.setNomBeneficiario(p.getNomBeneficiario());
				n.setDirBeneficiario(p.getDirBeneficiario());
				n.setTelBeneficiario(p.getTelBeneficiario());
				AuxAfiliado aux = new AuxAfiliado();
				aux.setIdAfiliado(p.getAfiliado().getIdAfiliado());
				aux.setDepartamento(p.getAfiliado().getDepartamento());
				aux.setDirAfiliado(p.getAfiliado().getDirAfiliado());
				aux.setMunicipio(p.getAfiliado().getMunicipio());
				aux.setNomAfiliado(p.getAfiliado().getNomAfiliado());
				n.setAfiliado(aux);
				AuxSolucion auxSolucion = new AuxSolucion();
				//--Validación cuando se elimino un beneficiario

				auxSolucion.setCostoAdministrativo(p.getSolucion().getCostoAdministrativo());
				auxSolucion.setCostoDirecto(p.getSolucion().getCostoDirecto());
				auxSolucion.setCostoMaterial(p.getSolucion().getCostoMaterial());
				auxSolucion.setCostoTotal(p.getSolucion().getCostoTotal());
				auxSolucion.setDisenio(p.getSolucion().getDisenio());
				auxSolucion.setFechaInicio(ConvertDate.g(p.getSolucion().getFechaInicio()));
				auxSolucion.setIdSolucion(p.getSolucion().getIdSolucion().getId());
				auxSolucion.setNomSolucion(p.getSolucion().getNomSolucion());
				auxSolucion.setNotaDebito(p.getSolucion().getNotaDebito());
				auxSolucion.setValorContrato(p.getSolucion().getValorContrato());
				auxSolucion.setEstadoSolucion(p.getSolucion().getEstadoSolucion());
				//System.out.println(p.getSolucion().getListaDetalle().get(0).getMaterialCostruccion().getProveedor().getNomProveedor());
				ArrayList<AuxDetalleSolucion> listaDetalle = new ArrayList<AuxDetalleSolucion>();
				Iterator<SegDetalleSolucion> i1 = p.getSolucion().getListaDetalle().iterator();
				while(i1.hasNext()){
					SegDetalleSolucion auxDetalle = i1.next();
					AuxDetalleSolucion auxDetalle2 = new AuxDetalleSolucion();
					auxDetalle2.setCantidad(auxDetalle.getCantidad());
					auxDetalle2.setCostoAcumulado(auxDetalle.getCostoAcumulado());
					auxDetalle2.setIdDetalleSolucion(auxDetalle.getIdDetalleSolucion().getId());
					auxDetalle2.setSubTotal(auxDetalle.getSubTotal());
					auxDetalle2.setUnidadMetrica(auxDetalle.getUnidadMetrica());
					auxDetalle2.setCantidadEjecutada(auxDetalle.getCantidadEjecutada());
					SegMaterialCostruccion i2 = auxDetalle.getMaterialCostruccion();
					//
					AuxMaterialCostruccion auxMat = new AuxMaterialCostruccion();
					auxMat.setFechaIngreso(ConvertDate.g(i2.getFechaIngreso()));
					auxMat.setIdMaterialConstruccion(i2.getIdMaterialConstruccion().getId());
					auxMat.setNomMaterialCostruccion(i2.getNomMaterialCostruccion());
					auxMat.setPrecioUnit(i2.getPrecioUnit());
					auxMat.setUnidadMetrica(i2.getUnidadMetrica());
					SegProveedor i3 = i2.getProveedor();
					AuxProveedor auxP = new AuxProveedor();
					auxP.setIdProveedor(i3.getIdProveedor().getId());
					auxP.setNomProveedor(i3.getNomProveedor());
					auxMat.setProveedor(auxP);
					auxDetalle2.setMaterialCostruccion(auxMat);
					//fin Material Construccion
					
					//Inicio lista vales
					Iterator<SegVale> iterVale = auxDetalle.getVale().iterator();
					ArrayList<AuxVale> listaVales = new ArrayList<AuxVale>();
					while (iterVale.hasNext()){
						SegVale vale = iterVale.next();
						AuxVale auxVale = new AuxVale();
						auxVale.setIdVale(vale.getIdVale());
						auxVale.setTotalVale(vale.getTotalVale());
						auxVale.setFechaVale(ConvertDate.g(vale.getFechaVale()));
						listaVales.add(auxVale);
					}
					auxDetalle2.setVale(listaVales);

					//fin vale
					listaDetalle.add(auxDetalle2);
				}
				auxSolucion.setLista(listaDetalle);

				//--fin de la validación si se elimino un beneficiario
				n.setSolucion(auxSolucion);
				valor.add(n);
		}
		return valor;
	}
	
	public List<AuxBeneficiario> ConsultaTodosBene_PorAfiliadoDos(Long idAfiliado){

		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		final SegAfiliado query = gestorPersistencia.getObjectById(SegAfiliado.class,idAfiliado);
		List<AuxBeneficiario> valor = new ArrayList<AuxBeneficiario>();
		System.out.println("cantidad "+ query.getSolucion().size());
		Iterator<SegBeneficiario> auxB = query.getSolucion().iterator();
		while (auxB.hasNext()){
			SegBeneficiario p = auxB.next();
				AuxBeneficiario n= new AuxBeneficiario();
				n.setIdBeneficiario(p.getIdBeneficiario().getId());
				n.setNomBeneficiario(p.getNomBeneficiario());
				n.setDirBeneficiario(p.getDirBeneficiario());
				n.setTelBeneficiario(p.getTelBeneficiario());
				AuxAfiliado aux = new AuxAfiliado();
				aux.setIdAfiliado(p.getAfiliado().getIdAfiliado());
				aux.setDepartamento(p.getAfiliado().getDepartamento());
				aux.setDirAfiliado(p.getAfiliado().getDirAfiliado());
				aux.setMunicipio(p.getAfiliado().getMunicipio());
				aux.setNomAfiliado(p.getAfiliado().getNomAfiliado());
				n.setAfiliado(aux);
				AuxSolucion auxSolucion = new AuxSolucion();
				auxSolucion.setCostoAdministrativo(p.getSolucion().getCostoAdministrativo());
				auxSolucion.setCostoDirecto(p.getSolucion().getCostoDirecto());
				auxSolucion.setCostoMaterial(p.getSolucion().getCostoMaterial());
				auxSolucion.setCostoTotal(p.getSolucion().getCostoTotal());
				auxSolucion.setDisenio(p.getSolucion().getDisenio());
				auxSolucion.setFechaInicio(ConvertDate.g(p.getSolucion().getFechaInicio()));
				auxSolucion.setIdSolucion(p.getSolucion().getIdSolucion().getId());
				auxSolucion.setNomSolucion(p.getSolucion().getNomSolucion());
				auxSolucion.setNotaDebito(p.getSolucion().getNotaDebito());
				auxSolucion.setValorContrato(p.getSolucion().getValorContrato());
				auxSolucion.setEstadoSolucion(p.getSolucion().getEstadoSolucion());
				//System.out.println(p.getSolucion().getListaDetalle().get(0).getMaterialCostruccion().getProveedor().getNomProveedor());
				/*List<AuxDetalleSolucion> listaDetalle = new ArrayList<AuxDetalleSolucion>();
				Iterator<SegDetalleSolucion> i1 = p.getSolucion().getListaDetalle().iterator();
				while(i1.hasNext()){
					SegDetalleSolucion auxDetalle = i1.next();
					AuxDetalleSolucion auxDetalle2 = new AuxDetalleSolucion();
					auxDetalle2.setCantidad(auxDetalle.getCantidad());
					auxDetalle2.setCostoAcumulado(auxDetalle.getCostoAcumulado());
					auxDetalle2.setIdDetalleSolucion(auxDetalle.getIdDetalleSolucion().getId());
					auxDetalle2.setSubTotal(auxDetalle.getSubTotal());
					auxDetalle2.setUnidadMetrica(auxDetalle.getUnidadMetrica());
					auxDetalle2.setCantidadEjecutada(auxDetalle.getCantidadEjecutada());
					SegMaterialCostruccion i2 = auxDetalle.getMaterialCostruccion();
					//
					AuxMaterialCostruccion auxMat = new AuxMaterialCostruccion();
					auxMat.setFechaIngreso(ConvertDate.g(i2.getFechaIngreso()));
					auxMat.setIdMaterialConstruccion(i2.getIdMaterialConstruccion().getId());
					auxMat.setNomMaterialCostruccion(i2.getNomMaterialCostruccion());
					auxMat.setPrecioUnit(i2.getPrecioUnit());
					auxMat.setUnidadMetrica(i2.getUnidadMetrica());
					SegProveedor i3 = i2.getProveedor();
					AuxProveedor auxP = new AuxProveedor();
					auxP.setIdProveedor(i3.getIdProveedor().getId());
					auxP.setNomProveedor(i3.getNomProveedor());
					auxMat.setProveedor(auxP);
					auxDetalle2.setMaterialCostruccion(auxMat);
					//fin Material Construccion
					
					//Inicio lista vales
			/*		Iterator<SegVale> iterVale = auxDetalle.getVale().iterator();
					List<AuxVale> listaVales = new ArrayList<AuxVale>();
					while (iterVale.hasNext()){
						SegVale vale = iterVale.next();
						AuxVale auxVale = new AuxVale();
						auxVale.setIdVale(vale.getIdVale());
						auxVale.setTotalVale(vale.getTotalVale());
						auxVale.setFechaVale(ConvertDate.g(vale.getFechaVale()));
						listaVales.add(auxVale);
					}
					auxDetalle2.setVale(listaVales);

					//fin vale
					listaDetalle.add(auxDetalle2);
				}
				auxSolucion.setLista(listaDetalle);*/
				n.setSolucion(auxSolucion);
				valor.add(n);
		}
		return valor;
	}
	
	
	public List<AuxVale> ConsultarValesPendientes_unProveedor(Long idProveedor){
		List<AuxVale> response = new ArrayList<AuxVale>();
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(SegDetalleEjecucion.class);
		 try{
			 List<SegDetalleEjecucion> result = (List<SegDetalleEjecucion>)q.execute();
			 if (!result.isEmpty()){
				for (SegDetalleEjecucion auxD : result){					
					Long idProv = auxD.getMaterialCostruccion().getIdMaterialConstruccion().getParent().getId();
					System.out.println("comparar " + idProv +" contra "+ idProveedor);
					if (idProv.equals(idProveedor)){	
						boolean flagVale = true;
						for(AuxVale auxValeFlag : response){
							//System.out.println("Comparar: " + auxD.getVale().getIdVale()+ " "+ auxValeFlag.getIdVale());
							if(auxD.getVale().getIdVale().equals(auxValeFlag.getIdVale())){
								flagVale = false;
								
							}
						}
						if (auxD.getVale() != null && flagVale){
						System.out.println(auxD.getVale().getIdVale());
						SegVale auxVale = auxD.getVale();
						if (auxVale.getTotalVale()-auxVale.getTotalPagado() > 0.0){
							
							AuxVale auxCumple = new AuxVale();
							auxCumple.setIdVale(auxVale.getIdVale());
							auxCumple.setEstado(auxVale.isEstado());
							auxCumple.setTotalVale(auxVale.getTotalVale());
							auxCumple.setTotalPagado(auxVale.getTotalPagado());
							auxCumple.setFechaVale(ConvertDate.g(auxVale.getFechaVale()));
							response.add(auxCumple);
						}
						
						}
					}
				}
			 }
		 }finally{
			 q.closeAll();
		 }
		
		
		return response;
	}
	
	public AuxBeneficiario ConsultaBene_PorAfiliado(Long idAfiliado, Long idBeneficiario){
		System.out.println("Datos " + idAfiliado + " " +idBeneficiario);
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		 Key k = new KeyFactory
			        .Builder(SegAfiliado.class.getSimpleName(), idAfiliado)
		 			.addChild(SegBeneficiario.class.getSimpleName(), idBeneficiario)	
			        .getKey();
		SegBeneficiario bene = gestorPersistencia.getObjectById(SegBeneficiario.class, k);
		AuxBeneficiario resultado = new  AuxBeneficiario();
		resultado.setIdBeneficiario(bene.getIdBeneficiario().getId());
		resultado.setDirBeneficiario(bene.getDirBeneficiario());
		resultado.setNomBeneficiario(bene.getNomBeneficiario());
		resultado.setTelBeneficiario(bene.getTelBeneficiario());
		AuxSolucion auxSolucion = new AuxSolucion();
		//--Validación cuando se elimino un beneficiario

		auxSolucion.setCostoAdministrativo(bene.getSolucion().getCostoAdministrativo());
		auxSolucion.setCostoDirecto(bene.getSolucion().getCostoDirecto());
		auxSolucion.setCostoMaterial(bene.getSolucion().getCostoMaterial());
		auxSolucion.setCostoTotal(bene.getSolucion().getCostoTotal());
		auxSolucion.setDisenio(bene.getSolucion().getDisenio());
		auxSolucion.setFechaInicio(ConvertDate.g(bene.getSolucion().getFechaInicio()));
		auxSolucion.setIdSolucion(bene.getSolucion().getIdSolucion().getId());
		auxSolucion.setNomSolucion(bene.getSolucion().getNomSolucion());
		auxSolucion.setNotaDebito(bene.getSolucion().getNotaDebito());
		auxSolucion.setValorContrato(bene.getSolucion().getValorContrato());
		auxSolucion.setEstadoSolucion(bene.getSolucion().getEstadoSolucion());
		
		ArrayList<AuxDetalleSolucion> listaEjecucion = new ArrayList<AuxDetalleSolucion>();
		Iterator<SegDetalleEjecucion> i1 = bene.getSolucion().getListaEjecucion().iterator();
		while(i1.hasNext()){
			SegDetalleEjecucion auxDetalle = i1.next();
			AuxDetalleSolucion auxDetalle2 = new AuxDetalleSolucion();
			auxDetalle2.setCantidad(auxDetalle.getCantidad());
			auxDetalle2.setIdDetalleSolucion(auxDetalle.getIdDetalleSolucion().getId());
			auxDetalle2.setSubTotal(auxDetalle.getSubTotal());
			auxDetalle2.setUnidadMetrica(auxDetalle.getUnidadMetrica());
			SegMaterialCostruccion i2 = auxDetalle.getMaterialCostruccion();
			//
			AuxMaterialCostruccion auxMat = new AuxMaterialCostruccion();
			auxMat.setFechaIngreso(ConvertDate.g(i2.getFechaIngreso()));
			auxMat.setIdMaterialConstruccion(i2.getIdMaterialConstruccion().getId());
			auxMat.setNomMaterialCostruccion(i2.getNomMaterialCostruccion());
			auxMat.setPrecioUnit(i2.getPrecioUnit());
			auxMat.setUnidadMetrica(i2.getUnidadMetrica());
			SegProveedor i3 = i2.getProveedor();
			AuxProveedor auxP = new AuxProveedor();
			auxP.setIdProveedor(i3.getIdProveedor().getId());
			auxP.setNomProveedor(i3.getNomProveedor());
			auxMat.setProveedor(auxP);
			auxDetalle2.setMaterialCostruccion(auxMat);
			//fin Material Construccion
			
			//Inicio  vale
			SegVale iterVale = auxDetalle.getVale();
			ArrayList<AuxVale> listaVales = new ArrayList<AuxVale>();
				AuxVale auxVale = new AuxVale();
				auxVale.setIdVale(iterVale.getIdVale());
				auxVale.setTotalVale(iterVale.getTotalVale());
				auxVale.setFechaVale(ConvertDate.g(iterVale.getFechaVale()));
				listaVales.add(auxVale);
			auxDetalle2.setVale(listaVales);

			//fin vale
			listaEjecucion.add(auxDetalle2);
		}
		auxSolucion.setLista(listaEjecucion);
		resultado.setSolucion(auxSolucion);
		return resultado;

		
	}
	
	public AuxBeneficiario ConsultaRecord_Beneficiario(Long idAfiliado, Long idBeneficiario){
		
		HttpServletRequest request = this.getThreadLocalRequest();
		// dont create a new one -> false
		HttpSession session = request.getSession(false);
		long idAfi =  Long.parseLong(session.getAttribute("idAfiliadoHabitat").toString());
		System.out.println("Datos " + idAfi + " " +idBeneficiario);
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		 Key k = new KeyFactory
			        .Builder(SegAfiliado.class.getSimpleName(), idAfi)
		 			.addChild(SegBeneficiario.class.getSimpleName(), idBeneficiario)	
			        .getKey();
		SegBeneficiario bene = gestorPersistencia.getObjectById(SegBeneficiario.class, k);
		AuxBeneficiario resultado = new  AuxBeneficiario();
		resultado.setIdBeneficiario(bene.getIdBeneficiario().getId());
		resultado.setDirBeneficiario(bene.getDirBeneficiario());
		resultado.setNomBeneficiario(bene.getNomBeneficiario());
		resultado.setTelBeneficiario(bene.getTelBeneficiario());
		AuxSolucion auxSolucion = new AuxSolucion();
		//--Validación cuando se elimino un beneficiario

		auxSolucion.setCostoAdministrativo(bene.getSolucion().getCostoAdministrativo());
		auxSolucion.setCostoDirecto(bene.getSolucion().getCostoDirecto());
		auxSolucion.setCostoMaterial(bene.getSolucion().getCostoMaterial());
		auxSolucion.setCostoTotal(bene.getSolucion().getCostoTotal());
		auxSolucion.setDisenio(bene.getSolucion().getDisenio());
		auxSolucion.setFechaInicio(ConvertDate.g(bene.getSolucion().getFechaInicio()));
		auxSolucion.setIdSolucion(bene.getSolucion().getIdSolucion().getId());
		auxSolucion.setNomSolucion(bene.getSolucion().getNomSolucion());
		auxSolucion.setNotaDebito(bene.getSolucion().getNotaDebito());
		auxSolucion.setValorContrato(bene.getSolucion().getValorContrato());
		auxSolucion.setEstadoSolucion(bene.getSolucion().getEstadoSolucion());
		
		ArrayList<AuxDetalleSolucion> listaEjecucion = new ArrayList<AuxDetalleSolucion>();
		Iterator<SegDetalleEjecucion> i1 = bene.getSolucion().getListaEjecucion().iterator();
		while(i1.hasNext()){
			SegDetalleEjecucion auxDetalle = i1.next();
			AuxDetalleSolucion auxDetalle2 = new AuxDetalleSolucion();
			auxDetalle2.setCantidad(auxDetalle.getCantidad());
			auxDetalle2.setIdDetalleSolucion(auxDetalle.getIdDetalleSolucion().getId());
			auxDetalle2.setSubTotal(auxDetalle.getSubTotal());
			auxDetalle2.setUnidadMetrica(auxDetalle.getUnidadMetrica());
			SegMaterialCostruccion i2 = auxDetalle.getMaterialCostruccion();
			//
			AuxMaterialCostruccion auxMat = new AuxMaterialCostruccion();
			auxMat.setFechaIngreso(ConvertDate.g(i2.getFechaIngreso()));
			auxMat.setIdMaterialConstruccion(i2.getIdMaterialConstruccion().getId());
			auxMat.setNomMaterialCostruccion(i2.getNomMaterialCostruccion());
			auxMat.setPrecioUnit(i2.getPrecioUnit());
			auxMat.setUnidadMetrica(i2.getUnidadMetrica());
			SegProveedor i3 = i2.getProveedor();
			AuxProveedor auxP = new AuxProveedor();
			auxP.setIdProveedor(i3.getIdProveedor().getId());
			auxP.setNomProveedor(i3.getNomProveedor());
			auxMat.setProveedor(auxP);
			auxDetalle2.setMaterialCostruccion(auxMat);
			//fin Material Construccion
			
			//Inicio  vale
			SegVale iterVale = auxDetalle.getVale();
			ArrayList<AuxVale> listaVales = new ArrayList<AuxVale>();
				AuxVale auxVale = new AuxVale();
				auxVale.setIdVale(iterVale.getIdVale());
				auxVale.setTotalVale(iterVale.getTotalVale());
				auxVale.setFechaVale(ConvertDate.g(iterVale.getFechaVale()));
				listaVales.add(auxVale);
			auxDetalle2.setVale(listaVales);

			//fin vale
			listaEjecucion.add(auxDetalle2);
		}
		auxSolucion.setLista(listaEjecucion);
		resultado.setSolucion(auxSolucion);
		return resultado;

		
	}
	
	public List<AuxSolucion> Consulta_SolucionesGenerales(){
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		Query query = gestorPersistencia.newQuery(SegSolucion.class);
		query.setFilter("estadoSolucion == 1");
		List<AuxSolucion> valor = new ArrayList<AuxSolucion>();
		List<SegSolucion> execute = (List<SegSolucion>)query.execute("Google App Engine");
		
		if (!execute.isEmpty()){
			for(SegSolucion p : execute ){
				AuxSolucion auxSolucion = new AuxSolucion();
				auxSolucion.setCostoAdministrativo(p.getCostoAdministrativo());
				auxSolucion.setCostoDirecto(p.getCostoDirecto());
				auxSolucion.setCostoMaterial(p.getCostoMaterial());
				auxSolucion.setCostoTotal(p.getCostoTotal());
				auxSolucion.setDisenio(p.getDisenio());
				auxSolucion.setFechaInicio(ConvertDate.g(p.getFechaInicio()));
				auxSolucion.setIdSolucion(p.getIdSolucion().getId());
				auxSolucion.setNomSolucion(p.getNomSolucion());
				auxSolucion.setNotaDebito(p.getNotaDebito());
				auxSolucion.setValorContrato(p.getValorContrato());
				auxSolucion.setEstadoSolucion(p.getEstadoSolucion());
				
				AuxBeneficiario n= new AuxBeneficiario();
				n.setIdBeneficiario(p.getBeneficiario().getIdBeneficiario().getId());
				n.setNomBeneficiario(p.getBeneficiario().getNomBeneficiario());
				n.setDirBeneficiario(p.getBeneficiario().getDirBeneficiario());
				n.setTelBeneficiario(p.getBeneficiario().getTelBeneficiario());
				AuxAfiliado aux = new AuxAfiliado();
				aux.setIdAfiliado(p.getBeneficiario().getAfiliado().getIdAfiliado());
				aux.setDepartamento(p.getBeneficiario().getAfiliado().getDepartamento());
				aux.setDirAfiliado(p.getBeneficiario().getAfiliado().getDirAfiliado());
				aux.setMunicipio(p.getBeneficiario().getAfiliado().getMunicipio());
				aux.setNomAfiliado(p.getBeneficiario().getAfiliado().getNomAfiliado());
				n.setAfiliado(aux);
				auxSolucion.setBeneficiario(n);
				
				valor.add(auxSolucion);				
			}
		}
		
		
		return valor;
	}
	
	
	public AuxHistorialPagoProv Consultar_SolicitudPagoVales(Long idHistorialPagoProv){
		AuxHistorialPagoProv valor = new AuxHistorialPagoProv();
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		final SegHistorialPagoProv query = gestorPersistencia.getObjectById(SegHistorialPagoProv.class,idHistorialPagoProv);
		valor.setIdHistorialPagoProv(query.getIdHistorialPagoProv());
		valor.setSerieDocumento(query.getSerieDocumento());
		valor.setTipoDocumento(query.getTipoDocumento());
		valor.setValorPago(query.getValorPago());
		valor.setFechaVale(ConvertDate.g(query.getFechaVale()));
		List<AuxVale> listaVales = new ArrayList<AuxVale>();
		for (SegVale segVale : query.getVale()){
			AuxVale auxVale = new AuxVale();
			auxVale.setIdVale(segVale.getIdVale());
			auxVale.setEstado(segVale.isEstado());
			auxVale.setTotalPagado(segVale.getTotalPagado());
			auxVale.setTotalVale(segVale.getTotalPagado());
			auxVale.setFechaVale(ConvertDate.g(segVale.getFechaVale()));
			listaVales.add(auxVale);
		}
		valor.setVale(listaVales);	
		return valor;
	}
	
	
	//------------------------------------------MODIFICAR------------------------------------
    @Override
	public Long Actualizar_Parametro(Long id,String nomParam,int codContable,int codUno, int codDos) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(nomParam!=null){	
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			try{
				 final SegParametro e = gestorPersistencia.getObjectById(SegParametro.class, id);
				 e.setCodContable(codContable);
				 e.setNomParametro(nomParam);
				 e.setCodUno(codUno);
				 e.setCodContable(codContable);
				 e.setCodDos(codDos);
				 
			}finally{
				gestorPersistencia.close();
			}
		}
		
		return id;
	}
	@Override
	public Long Actualizar_Afiliado(Long id,String nomAfiliado,String dirAfiliado,String depAfiliado, String munAfiliado) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(nomAfiliado!=null){	
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			try{
				 final SegAfiliado e = gestorPersistencia.getObjectById(SegAfiliado.class, id);
				 e.setNomAfiliado(nomAfiliado);
				 e.setDirAfiliado(dirAfiliado);
				 e.setMunicipio(munAfiliado);
				 e.setDepartamento(depAfiliado);
				 
			}finally{
				gestorPersistencia.close();
			}
		}
		
		return id;
	}
	public Long Actualizar_Beneficiario(Long id,String nomBeneficiario,String dirBeneficiario,int telBeneficiario) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(nomBeneficiario!=null){	
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			try{
				 final SegBeneficiario e = gestorPersistencia.getObjectById(SegBeneficiario.class, id);
				 e.setNomBeneficiario(nomBeneficiario);
				 e.setDirBeneficiario(dirBeneficiario);
				 e.setTelBeneficiario(telBeneficiario);
				 
				 
			}finally{
				gestorPersistencia.close();
			}
		}
		
		return id;
	}
	
	
	public Long Actualizar_MaterialCostruccion(Long id,String nomMaterialCostruccion,Double precioUnitario,String unidadMetrica) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(nomMaterialCostruccion!=null){	
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			try{
				 final SegMaterialCostruccion e = gestorPersistencia.getObjectById(SegMaterialCostruccion.class, id);
				 e.setNomMaterialCostruccion(nomMaterialCostruccion);;
				 e.setPrecioUnit(precioUnitario);
				 e.setUnidadMetrica(unidadMetrica);
				 
				 
			}finally{
				gestorPersistencia.close();
			}
		}
		
		return id;
	}
	public Long Actualizar_Proveedor(Long id,Boolean aprobadoComision, String dirProveedor,Long fechaIngreso, String nomProveedor,String numeroNit, String observaciones, String paginaWeb, String personaJuridica, Boolean servicioEntrega, String telProveedor) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(nomProveedor!=null){	
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			try{
				 final SegProveedor e = gestorPersistencia.getObjectById(SegProveedor.class,id);
				 e.setAprobadoComision(aprobadoComision);
				 e.setDirProveedor(dirProveedor);
				 e.setFechaIngreso(new java.sql.Date(fechaIngreso));
				 e.setNomProveedor(nomProveedor);
				 e.setNumeroNit(numeroNit);
				 e.setObservaciones(observaciones);
				 e.setPaginaWeb(paginaWeb);
				 e.setPersonaJuridica(personaJuridica);
				 e.setServicioEntrega(servicioEntrega);
				 e.setTelProveedor(telProveedor);
			 
				 
			}finally{
				gestorPersistencia.close();
			}
		}
		
		return id;
	}
	
	public Long Actualizar_ProveedorAprobado(Long id) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(id!=null){	
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			try{
				 final SegProveedor e = gestorPersistencia.getObjectById(SegProveedor.class,id);
				 e.setAprobadoComision(true);	 
				 
			}finally{
				gestorPersistencia.close();
			}
		}
		
		return id;
	}
	
	
	public Long Actualizar_AfiliadoEmpleado(Long idAfiliado, Long idEmpleado){
		System.out.println("id afiliado "+idAfiliado + " id empleado "+idEmpleado);
		Long valor = 0L;
		if(idAfiliado == null){
			return valor;
		}else
		{
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			 final SegAfiliado e = gestorPersistencia.getObjectById(SegAfiliado.class, idAfiliado);
			 e.getEmpleados().add(idEmpleado);
			 valor = idEmpleado;
		}
		return valor;
	}
	
	public Long Actualizar_DetalleSolucion(Long idDetalleSolucion, Long idVale, Long idSolucion){


		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		 Key k = new KeyFactory
			        .Builder(SegSolucion.class.getSimpleName(), idSolucion)
		 			.addChild(SegDetalleSolucion.class.getSimpleName(), idDetalleSolucion)	
			        .getKey();
			System.out.println(k);
		 final SegDetalleSolucion e = gestorPersistencia.getObjectById(SegDetalleSolucion.class, k);
		 final SegVale e1 = gestorPersistencia.getObjectById(SegVale.class, idVale);
		 try {
			 e.getVale().add(e1);	
		}
		finally{
			gestorPersistencia.close();
		}
		return null;
	}
	
	public Long Actualizar_EstadoVale(Long idVale, java.util.Date fechaVale, Double costoTotal){
		Long valor = 0L;
		if(idVale == null){
			return valor;
		}else
		{
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			 final SegVale e = gestorPersistencia.getObjectById(SegVale.class, idVale);
			 e.setEstado(true);
			 e.setFechaVale(fechaVale);
			 e.setTotalVale(costoTotal);
			 e.setTotalPagado(0.0);
			 System.out.println("Fecha actualizada "+ fechaVale);
			 valor = idVale;
		}
		return valor;
	}
	
	public Long Insertar_Bene(String nomBeneficiario,String dirBeneficiario,int telBeneficiario,Long idAfiliado) throws IllegalArgumentException{
		 Long valor = 0L;
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		SegAfiliado selectB = gestorPersistencia.getObjectById(SegAfiliado.class,idAfiliado);
		SegBeneficiario nuevo = new SegBeneficiario();
		nuevo.setNomBeneficiario(nomBeneficiario);
		nuevo.setDirBeneficiario(dirBeneficiario);
		nuevo.setTelBeneficiario(telBeneficiario);
		nuevo.setAfiliado(selectB);
		selectB.getSolucion().add(nuevo);
		
		try{
			gestorPersistencia.makePersistent(nuevo);
			System.out.println("BENEFICIARIO GUARDADO CORRECTAMENTE");
			valor = nuevo.getIdBeneficiario().getId();
		}finally{
			gestorPersistencia.close();
		}
		return valor;
}
	
}