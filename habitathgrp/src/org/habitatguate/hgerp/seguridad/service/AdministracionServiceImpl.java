package org.habitatguate.hgerp.seguridad.service;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;
import org.habitatguate.hgerp.seguridad.service.jdo.SegUsuarioPermiso;
import org.habitatguate.hgerp.util.PMF;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class AdministracionServiceImpl extends RemoteServiceServlet implements AdministracionService {


	@Override
	public Long InsertarUsuarioPermiso(Long rol, String nombreFormulario,
			Long formularioPadre, String permiso)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;
		try{
			SegUsuarioPermiso usuarioPermiso = new SegUsuarioPermiso();
			usuarioPermiso.setRol(rol);
			usuarioPermiso.setNombreFormulario(nombreFormulario);
			usuarioPermiso.setFormularioPadre(formularioPadre);
			usuarioPermiso.setPermiso(permiso);
	        Persistencia.makePersistent(usuarioPermiso); 
	        valor = usuarioPermiso.getId_permiso().getId();
		}finally {  
			 Persistencia.close();  
		 }
		return valor;
	}

	@Override
	public Long ActualizarUsuarioPermiso(Long idPermiso, Long rol,
			String nombreFormulario, Long formularioPadre, String permiso)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager();
		
		try{
			 final SegUsuarioPermiso usuarioPermiso = Persistencia.getObjectById(SegUsuarioPermiso.class, idPermiso); 
				usuarioPermiso.setRol(rol);
				usuarioPermiso.setNombreFormulario(nombreFormulario);
				usuarioPermiso.setFormularioPadre(formularioPadre);
				usuarioPermiso.setPermiso(permiso);
			 
		}finally {  
			 Persistencia.close();  
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuxUsuarioPermiso> ObtenerUsuarioPermiso(Long Rol)
			throws IllegalArgumentException {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
		
		List<AuxUsuarioPermiso> valor = new ArrayList<AuxUsuarioPermiso>();
		List<SegUsuarioPermiso> results = new ArrayList<SegUsuarioPermiso>();
		System.out.println("rol == '"+Rol+"'");
		Query q = pm.newQuery(SegUsuarioPermiso.class,"rol == "+Rol+"");
		results = (List<SegUsuarioPermiso>) q.execute();
		
		for(SegUsuarioPermiso e:results)
		{
			AuxUsuarioPermiso usuarioPermiso = new AuxUsuarioPermiso();
			usuarioPermiso.setId_permiso(e.getId_permiso().getId());
			usuarioPermiso.setRol(e.getRol());
			usuarioPermiso.setNombreFormulario(e.getNombreFormulario());
			usuarioPermiso.setFormularioPadre(e.getFormularioPadre());
			usuarioPermiso.setPermiso(e.getPermiso());	
			valor.add(usuarioPermiso);
		}
		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuxUsuarioPermiso> ObtenerUsuarioPermisoFormularios(Long Rol,
			Long formularioPadre) throws IllegalArgumentException {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager() ;
		
		List<AuxUsuarioPermiso> valor = new ArrayList<AuxUsuarioPermiso>();
		List<SegUsuarioPermiso> results = new ArrayList<SegUsuarioPermiso>();

		Query q = pm.newQuery(SegUsuarioPermiso.class, "rol == "+Rol+" && formularioPadre == "+formularioPadre+"");
		results = (List<SegUsuarioPermiso>) q.execute();

		for(SegUsuarioPermiso e:results)
		{
			AuxUsuarioPermiso usuarioPermiso = new AuxUsuarioPermiso();
			usuarioPermiso.setId_permiso(e.getId_permiso().getId());
			usuarioPermiso.setRol(e.getRol());
			usuarioPermiso.setNombreFormulario(e.getNombreFormulario());
			usuarioPermiso.setFormularioPadre(e.getFormularioPadre());
			usuarioPermiso.setPermiso(e.getPermiso());	
			valor.add(usuarioPermiso);
		}
		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long EliminarUsuarioPermiso(Long Rol)
			throws IllegalArgumentException {
		final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
		
		List<SegUsuarioPermiso> results = new ArrayList<SegUsuarioPermiso>();
		Long valor = 0L;

		Query q = pm.newQuery(SegUsuarioPermiso.class,"rol == "+Rol+"");
		results = (List<SegUsuarioPermiso>) q.execute();

		for(SegUsuarioPermiso e:results)
		{
			valor++;
			pm.deletePersistent(e);
		}
		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long EliminarUsuarioPermisoFormularios(Long Rol,
			Long formularioPadre) throws IllegalArgumentException {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager() ;
		
		List<SegUsuarioPermiso> results = new ArrayList<SegUsuarioPermiso>();
		Long valor = 0L;

		Query q = pm.newQuery(SegUsuarioPermiso.class, "rol == "+Rol+" && formularioPadre == "+formularioPadre+"");
		results = (List<SegUsuarioPermiso>) q.execute();

		for(SegUsuarioPermiso e:results)
		{
			valor++;
			pm.deletePersistent(e);
		}
		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuxUsuarioPermiso> ObtenerUsuarioPermisoNombre(
			String nombreFormulario, Long Rol) {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
		
		List<AuxUsuarioPermiso> valor = new ArrayList<AuxUsuarioPermiso>();
		List<SegUsuarioPermiso> results = new ArrayList<SegUsuarioPermiso>();
		System.out.println("rol == "+Rol+" && nombreFormulario == '"+nombreFormulario+"'");
		Query q = pm.newQuery(SegUsuarioPermiso.class,"rol == "+Rol+" && nombreFormulario == '"+nombreFormulario+"'");
		results = (List<SegUsuarioPermiso>) q.execute();

		for(SegUsuarioPermiso e:results)
		{
			AuxUsuarioPermiso usuarioPermiso = new AuxUsuarioPermiso();
			usuarioPermiso.setId_permiso(e.getId_permiso().getId());
			usuarioPermiso.setRol(e.getRol());
			usuarioPermiso.setNombreFormulario(e.getNombreFormulario());
			usuarioPermiso.setFormularioPadre(e.getFormularioPadre());
			usuarioPermiso.setPermiso(e.getPermiso());	
			valor.add(usuarioPermiso);
		}
		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long ObtenerUltimoROl() {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
		
		List<SegUsuarioPermiso> results = new ArrayList<SegUsuarioPermiso>();
		Query q = pm.newQuery(SegUsuarioPermiso.class);
		q.setOrdering("rol desc");
		results = (List<SegUsuarioPermiso>) q.execute();
		
		System.out.println(results.isEmpty());
		
		if(!results.isEmpty()){
			System.out.println("ss: "+ results.get(0).getRol());
			System.out.println("ss: "+ results.get(results.size()-1).getRol());
			return results.get(0).getRol();
		}else{
			System.out.println("0L");
			return 0L;
		}
	}


	
	
	
}