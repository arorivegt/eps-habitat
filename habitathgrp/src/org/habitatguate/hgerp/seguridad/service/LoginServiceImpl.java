package org.habitatguate.hgerp.seguridad.service;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	public String[] login(String user,String password) throws IllegalArgumentException {
		
		if(user!=null && password!=null){
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