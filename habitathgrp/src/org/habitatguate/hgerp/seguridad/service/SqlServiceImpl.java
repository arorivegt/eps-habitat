package org.habitatguate.hgerp.seguridad.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.finanzas.Plantilla_Solucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegAfiliado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegBeneficiario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegEmpleado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegParametro;
import org.habitatguate.hgerp.seguridad.service.jdo.SegPlantillaSolucion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegProveedor;
import org.habitatguate.hgerp.util.ConvertDate;
import org.habitatguate.hgerp.util.PMF;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

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
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	try{
		//System.out.println("Plantilla de la que viene " + idPlantillaSolucion);
		plantilla = gestorPersistencia.getObjectById(SegPlantillaSolucion.class,idPlantillaSolucion);
	//	do {
		//System.out.println("Cantidad de elementos " + plantilla.getListaDetalle().size());
		SegDetallePlantillaSolucion auxSeg = new SegDetallePlantillaSolucion();
			auxSeg.setNomMaterialCostruccion(auxDetalle.getNomMaterialCostruccion());
			auxSeg.setPrecioUnit(auxDetalle.getPrecioUnit());
			auxSeg.setCantidad(auxDetalle.getCantidad());
			auxSeg.setUnidadMetrica(auxDetalle.getUnidadMetrica());
			auxSeg.setCostoAcumulado(auxDetalle.getCostoAcumulado());
			auxSeg.setSubTotal(auxDetalle.getSubTotal());
			auxSeg.setPlantillaSolucion(plantilla);
			plantilla.getListaDetalle().add(auxSeg);	
	       valor = auxSeg.getIdDetallePlantillaSolucion().getId();
	       gestorPersistencia.makePersistent(auxSeg);
	       gestorPersistencia.makePersistent(plantilla);
		//}while(plantilla != null);
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
public Long Insertar_MaterialCostruccionAfiliadoProveedor(Long idProveedor,String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario) throws IllegalArgumentException{
	 Long valor = 0L;
	final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
	try{
	SegProveedor prov = gestorPersistencia.getObjectById(SegProveedor.class,idProveedor);
	SegMaterialCostruccion nuevo = new SegMaterialCostruccion();
	nuevo.setNomMaterialCostruccion(nomMaterialCostruccion);
	nuevo.setPrecioUnit(precioUnitario);
	nuevo.setUnidadMetrica(unidadMetrica);
	Date time=new Date();
	Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
	nuevo.setFechaIngreso(today);
	nuevo.setProveedor(prov);
	prov.getMaterialCostruccion().add(nuevo);
	valor = nuevo.getIdMaterialConstruccion().getId();
	//gestorPersistencia.makePersistent(nuevo);
	//gestorPersistencia.makePersistent(prov);
		System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
	
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