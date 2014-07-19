package org.habitatguate.hgerp.seguridad.service;


import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.util.PMF;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;

@SuppressWarnings("serial")
public class SqlServiceImpl extends RemoteServiceServlet implements SqlService{

	public String[] Insertar(String user,String password) throws IllegalArgumentException {
		//System.out.println("user: "+user+" pass: "+password);
		if(user!=null && password!=null){
			System.out.println("GUARDANDO USUARIO");
			
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			seg_usuario usuario=new seg_usuario("Prueba Nelson","Password Nelson");
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
