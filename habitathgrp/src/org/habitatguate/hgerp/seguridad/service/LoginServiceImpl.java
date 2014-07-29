package org.habitatguate.hgerp.seguridad.service;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.util.PMF;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Persistent;


@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	public String[] login(String user,String password) throws IllegalArgumentException {

		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
		if(user!=null && password!=null){
					SegUsuario e = new SegUsuario("Alfred", "Smith");
			try {  
			    gestorPersistencia.makePersistent(e);  
			} finally {  
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
	
	

	@Override
	public Long Insertar_Emppleado(int intafiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String tipo_empleado,
            String pais, String nit,int no_Dependientes,String no_orden, int no_registro, int cui,
            String tipo_pasaporte, int no_pasaporte,
            String depto_municipio_cedula, String direccion_actual,
            String depto_municipio_residencia, String email, int telefono,
            int celular, Date fecha_nacimiento, String tipo_licencia,
            int no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion) throws IllegalArgumentException {
		
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
		
		SegEmpleado e = new SegEmpleado();
           e.setAfiliacion_igss(intafiliacion_igss);
           e.setEstado_civil(estado_civil);
           e.setSexo(sexo);
           e.setPrimer_apellido(primer_apellido);
           e.setSegundo_apellido(segundo_apellido);
           e.setApellido_casada(apellido_casada);
           e.setPrimer_nombre(primer_nombre);
           e.setSegundo_nombre(segundo_nombre);
           e.setTipo_empleado(tipo_empleado);
           e.setPais(pais);
           e.setNit(nit);
           e.setNo_Dependientes(no_Dependientes);
           e.setNo_orden(no_orden);
           e.setNo_registro(no_registro);
           e.setCui(cui);
           e.setTipo_pasaporte(tipo_pasaporte);
           e.setNo_pasaporte(no_pasaporte);
           e.setDepto_municipio_cedula(depto_municipio_cedula);
           e.setDireccion_actual(direccion_actual);
           e.setDepto_municipio_residencia(depto_municipio_residencia);
           e.setEmail(email);
           e.setTelefono(telefono);
           e.setCelular(celular);
           e.setFecha_ingreso(fecha_ingreso);
           e.setTipo_licencia(tipo_licencia);
           e.setNo_licencia(no_licencia);
           e.setCentro_trabajo(centro_trabajo);
           e.setOcupacion(ocupacion);
           e.setFecha_ingreso(fecha_ingreso);
           e.setCodigo_ingreso(codigo_ingreso);
           e.setProfesion(profesion);
           e.setTipo_planilla(tipo_planilla);
           e.setSalario_base(salario_base);
           e.setTotal(total);
           e.setBonificacion(bonificacion);
		 try{ 
			 gestorPersistencia.makePersistent(e); 
		 }finally {  
			 gestorPersistencia.close();  
		 }
		 
		 
		return e.getId_empleado().getId();
	}

	@Override
	public Long Insertar_Familiar(Long id_empleado, String primer_nombre,
			String segundo_nombre, String primer_apellido,
			String segundo_apellido, int edad, String ocupacion, String parentesco)
			throws IllegalArgumentException {
		
		 final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		 Long valor = 0L;
		 try{
			 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
			 SegFamilia f = new SegFamilia();
	      		f.setPrimer_nombre(primer_nombre);
	      		f.setSegundo_nombre(segundo_nombre);
	      		f.setPrimer_apellido(primer_apellido);
	      		f.setSegundo_apellido(segundo_apellido);
	      		f.setEdad(edad);
	      		f.setOcupacion(ocupacion);
	      		f.setParentesco(parentesco);	      		
	      		e.getFamilia().add(f);
			 	valor = f.getId_familia();
			 }finally {  
				 Persistencia.close();  
			 }
		return valor ;
	}



	@Override
	public Long Insertar_Academico(Long id_empleado, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo) throws IllegalArgumentException {
		
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		 Long valor = 0L;
		 try{
			 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
			 SegHistorialAcademico a = new SegHistorialAcademico();
			 	a.setEstablecimiento(establecimiento);
			 	a.setFecha1(fecha1);
			 	a.setFecha2(fecha2);
			 	a.setNivel_academico(nivel_academico);
			 	a.setTitulo(titulo);
	      	 	e.getHistorial_academico().add(a);
			 	valor = a.getId_historial_academico();
			 }finally {  
				 Persistencia.close();  
			 }
		return valor ;
	}
	
}