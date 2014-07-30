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
			System.out.println("GUARDANDO PARAMETRO");
			
			final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager();
			seqParametro nuevo = new seqParametro("Primero", 1010101, 1, 2);
			try{
				gestorPersistencia.makePersistent(nuevo);
				System.out.println("PARAMETRO GUARDADO CORRECTAMENTE");
			}finally{
				gestorPersistencia.close();
			}
		}
		
		return null;
	}
	
}