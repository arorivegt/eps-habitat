package org.habitatguate.hgerp.seguridad.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.service.jdo.SegAfiliado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegBeneficiario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegEmpleado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegParametro;
import org.habitatguate.hgerp.util.ConvertDate;
import org.habitatguate.hgerp.util.PMF;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
	@Override
	public Long Insertar_Beneficiario(String nomBeneficiario,String dirBeneficiario,int telBeneficiario) throws IllegalArgumentException{
		 Long valor = 0L;
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		SegBeneficiario nuevo = new SegBeneficiario();
		nuevo.setNomBeneficiario(nomBeneficiario);
		nuevo.setDirBeneficiario(dirBeneficiario);
		nuevo.setTelBeneficiario(telBeneficiario);
	
		
		try{
			gestorPersistencia.makePersistent(nuevo);
			System.out.println("BENEFICIARIO GUARDADO CORRECTAMENTE");
			valor = nuevo.getIdBeneficiario();
		}finally{
			gestorPersistencia.close();
		}
		return valor;
}
	
	public Long Insertar_MaterialCostruccion(String nomMaterialCostruccion,String unidadMetrica, Double precioUnitario) throws IllegalArgumentException{
		 Long valor = 0L;
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
		SegMaterialCostruccion nuevo = new SegMaterialCostruccion();
		nuevo.setNomMaterialCostruccion(nomMaterialCostruccion);
		nuevo.setPrecioUnit(precioUnitario);
		nuevo.setUnidadMetrica(unidadMetrica);
		Date time=new Date();
		Date today=new Date(time.getYear(),time.getMonth(),time.getDate());
		nuevo.setFechaIngreso(today);
		try{
			gestorPersistencia.makePersistent(nuevo);
			System.out.println("MATERIAL ALMACENADO SATISFACTORIAMENTE");
			valor = nuevo.getIdMaterialConstruccion();
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
				n.setIdBeneficiario(p.getIdBeneficiario());
				n.setNomBeneficiario(p.getNomBeneficiario());
				n.setDirBeneficiario(p.getDirBeneficiario());
				n.setTelBeneficiario(p.getTelBeneficiario());
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
				n.setIdMaterialConstruccion(p.getIdMaterialConstruccion());
				n.setNomMaterialCostruccion(p.getNomMaterialCostruccion());
				n.setUnidadMetrica(p.getUnidadMetrica());
				n.setPrecioUnit(p.getPrecioUnit());
				n.setFechaIngreso(ConvertDate.g(p.getFechaIngreso()));
				valor.add(n);
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
	
	
}