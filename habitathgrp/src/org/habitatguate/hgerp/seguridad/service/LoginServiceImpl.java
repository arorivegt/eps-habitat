package org.habitatguate.hgerp.seguridad.service;

import org.habitatguate.hgerp.seguridad.service.seg_usuario;
import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.util.PMF;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	public String[] login(String user,String password) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(user!=null && password!=null){
			System.out.println("GUARDANDO USUARIO");
			
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			seg_usuario usuario=new seg_usuario(user,password);
			try{
				gestorPersistencia.makePersistent(usuario);
				System.out.println("USUARIO GUARDADO CORRECTAMENTE");
			}finally{
				gestorPersistencia.close();
			}
			
			
			
			if(user.compareTo("developer")==0 & password.compareTo("dev")==0){
				String[] menu=new String[6];
				menu[0]="Planificacion";
				menu[1]="RRHH";
				menu[2]="Soluciones";
				menu[3]="Finanzas";
				menu[4]="Configuracion";
				menu[5]="Seguridad";
				return menu;
			}
		}
		
		return null;
	}
	
	

	
}