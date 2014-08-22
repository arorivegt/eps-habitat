package org.habitatguate.hgerp.seguridad.service;


import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.finanzas.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.rrhh.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegParametro;
import org.habitatguate.hgerp.util.PMF;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@SuppressWarnings("serial")
public class SqlServiceImpl extends RemoteServiceServlet implements SqlService{

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
	
	@SuppressWarnings("unchecked")
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


	
	
}