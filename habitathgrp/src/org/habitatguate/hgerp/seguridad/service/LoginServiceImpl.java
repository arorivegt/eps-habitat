package org.habitatguate.hgerp.seguridad.service;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.util.PMF;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.PersistenceManager;


@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	///metodos para insertar en las diferentes entidades
	public String[] login(String user,String password) throws IllegalArgumentException {

		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
		if(user!=null && password!=null){
					SegUsuario e = new SegUsuario("Alfred", "Smith");
			try{ 
				  
			    gestorPersistencia.makePersistent(e);  
			    
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

	@Override
	public Long Insertar_Emppleado(int intafiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String ConIVS, String SinIVS,
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
		Long valor = 0L;
		
		
		 try { 
			  
			 SegEmpleado e = new SegEmpleado();
			 e.setAfiliacion_igss(intafiliacion_igss);
	         e.setEstado_civil(estado_civil);
	         e.setSexo(sexo);
	         e.setPrimer_apellido(primer_apellido);
	         e.setSegundo_apellido(segundo_apellido);
	         e.setApellido_casada(apellido_casada);
	         e.setPrimer_nombre(primer_nombre);
	         e.setSegundo_nombre(segundo_nombre);
	         e.setConIVS(ConIVS);
	         e.setSinIVS(SinIVS);
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
	         gestorPersistencia.makePersistent(e); 
	         valor = e.getId_empleado().getId();
	         
	     }finally {  
			 gestorPersistencia.close();  
		 }
		 
		 
		return valor;
	}

	@Override
	public Long Insertar_Familiar(Long id_empleado, String primer_nombre,
			String segundo_nombre, String primer_apellido,
			String segundo_apellido, int edad, String ocupacion, String parentesco)
			throws IllegalArgumentException {
        
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegFamilia f = new  SegFamilia();
				 	f.setPrimer_nombre(primer_nombre);
				 	f.setSegundo_nombre(segundo_nombre);
				 	f.setPrimer_apellido(primer_apellido);
				 	f.setSegundo_apellido(segundo_apellido);
				 	f.setEdad(edad);
				 	f.setOcupacion(ocupacion);
				 	f.setParentesco(parentesco);
		      	 	f.setEmpleado(e);
		      	 	e.getFamilia().add(f);
				 	valor =f.getId_familia();
				 
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
		 try { 
			 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
			 SegHistorialAcademico a = new SegHistorialAcademico();
			 	a.setEstablecimiento(establecimiento);
			 	a.setFecha1(fecha1);
			 	a.setFecha2(fecha2);
			 	a.setNivel_academico(nivel_academico);
			 	a.setTitulo(titulo);
	      	 	a.setEmpleados(e);
	      	 	e.getHistorial_academico().add(a);
			 	valor = a.getId_historial_academico();
			 }finally {  
				 Persistencia.close();  
			 }
		return valor ;
	}

	@Override
	public Long Insertar_Referencia_Laboral(Long id_empleado,
			String nombre_referencia, int telefono, String puesto_candidato,
			String empresa_referencia, Date fecha1, Date fecha2,
			String motivo_retiro, float salario_final,
			String actitudes_cualidades, String recomiendo)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		 Long valor = 0L;
		 try { 
			 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
			 SegReferenciaLaboral rl = new  SegReferenciaLaboral();
			 	rl.setNombre_referencia(nombre_referencia);
			 	rl.setTelefono(telefono);
			 	rl.setPuesto_candidato(puesto_candidato);
			 	rl.setEmpresa_referencia(empresa_referencia);
			 	rl.setFecha1(fecha1);
			 	rl.setFecha2(fecha2);
			 	rl.setMotivo_retiro(motivo_retiro);
			 	rl.setSalario_final(salario_final);
			 	rl.setActitudes_cualidades(actitudes_cualidades);
			 	rl.setRecomiendo(recomiendo);
	      	 	rl.setEmpleado(e);
	      	 	e.getReferencia_laboral().add(rl);
			 	valor = rl.getId_referencia_laboral();
			 }finally {  
				 Persistencia.close();  
			 }
		return valor ;
	}

	@Override
	public Long Insertar_Referencia_Personal(Long id_empleado,
			String nombre_referencia, int telefono, String puesto_candidato,
			String relacion, String actitudes_cualidades)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegReferenciaPersonal rp = new  SegReferenciaPersonal();
				 	rp.setNombre_referencia(nombre_referencia);
				 	rp.setTelefono(telefono);
				 	rp.setPuesto_candidato(puesto_candidato);
				 	rp.setRelacion(relacion);
				 	rp.setActitudes_cualidades(actitudes_cualidades);
		      	 	rp.setEmpleados(e);
		      	 	e.getReferencia_personal().add(rp);
				 	valor = rp.getId_referencia_personal();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor ;
	}

	@Override
	public Long Insertar_Idioma(Long id_empleado, String nivel, String idioma)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegIdioma i = new  SegIdioma();
				 	i.setNivel(nivel);
				 	i.setIdioma(idioma);
		      	 	i.setEmpleados(e);
		      	 	e.getIdiomas().add(i);
				 	valor = i.getId_idioma();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor ;
	}

	@Override
	public Long Insertar_Test(Long id_empleado,int pregunta1, int pregunt2, int pregunta3,
			int pregunta4, int pregunta5, int pregunta6, int pregunta7,
			int pregunta8, int pregunta9, int pregunta10, Date fecha_test,
			String evaluador, String tipo_test) throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegTest t = new  SegTest();
				 	t.setPregunta1(pregunta1);
				 	t.setPregunt2(pregunt2);
				 	t.setPregunta3(pregunta3);
				 	t.setPregunta4(pregunta4);
				 	t.setPregunta5(pregunta5);
				 	t.setPregunta6(pregunta6);
				 	t.setPregunta7(pregunta7);
				 	t.setPregunta8(pregunta8);
				 	t.setPregunta9(pregunta9);
				 	t.setPregunta10(pregunta10);
				 	t.setFecha_test(fecha_test);
				 	t.setEvaluador(evaluador);
				 	t.setTipo_test(tipo_test);
		      	 	t.setEmpleado(e);
		      	 	e.getTest().add(t);
				 	valor =t.getId_test();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor ;
	}

	@Override
	public Long Insertar_Puesto(Long id_empleado,Date fecha_puesto, String nombre_puesto,
			String funciones, float salario, boolean activo)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegPuesto p = new  SegPuesto();
				 	p.setFecha_puesto(fecha_puesto);
				 	p.setNombre_puesto(nombre_puesto);
				 	p.setFunciones(funciones);
				 	p.setSalario(salario);
				 	p.setActivo(activo);
		      	 	p.setEmpleado(e);
		      	 	e.getPuestos().add(p);
				 	valor =p.getId_puesto();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor ;
	}

	@Override
	public Long Insertar_Entrevista(Long id_empleado, Date fecha_entrevista,
			String que_conoces, String por_que_trabajas_aqui,
			String como_se_describe, String trabajar_por_presion, String metas,
			boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
			boolean flexibilidad_horario, float pretencion_salarial_minimo,
			boolean antecedentes_penales, boolean antecedentes_policiacos,
			boolean carta_recomendacion_laboral,
			boolean carta_recomendacion_personal, boolean vive_con_familia,
			boolean casa_propia, String entrevisto, String enfermedades,
			float aporte_casa, boolean tiene_deudas, int no_dependientes,
			String empresa_credito, boolean alquila,float pago_alquiler,String Otros_Ingresos)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegEntrevista l = new  SegEntrevista();
				 	l.setFecha_entrevista(fecha_entrevista);
				 	l.setQue_conoces(que_conoces);
				 	l.setPor_que_trabajas_aqui(por_que_trabajas_aqui);
				 	l.setComo_se_describe(como_se_describe);
				 	l.setTrabajar_por_presion(trabajar_por_presion);
				 	l.setMetas(metas);
				 	l.setDisponibilidad_inmediata(disponibilidad_inmediata);
				 	l.setDisposicion_a_viajar(disposicion_a_viajar);
				 	l.setFlexibilidad_horario(flexibilidad_horario);
				 	l.setPretencion_salarial_minimo(pretencion_salarial_minimo);
				 	l.setAntecedentes_penales(antecedentes_penales);
				 	l.setAntecedentes_policiacos(antecedentes_policiacos);
				 	l.setCarta_recomendacion_laboral(carta_recomendacion_laboral);
				 	l.setCarta_recomendacion_personal(carta_recomendacion_personal);
				 	l.setVive_con_familia(vive_con_familia);
				 	l.setCasa_propia(casa_propia);
				 	l.setEntrevisto(entrevisto);
				 	l.setEnfermedades(enfermedades);
				 	l.setAporte_casa(aporte_casa);
				 	l.setTiene_deudas(tiene_deudas);
				 	l.setNo_dependientes(no_dependientes);
				 	l.setEmpresa_credito(empresa_credito);
				 	l.setAlquila(alquila);
				 	l.setOtros_Ingresos(Otros_Ingresos);
		      	 	l.setEmpleados(e);
		      	 	e.getEntrevista().add(l);
				 	valor = l.getId_entrevista();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor ;
	}

	@Override
	public Long Insertar_Historial(Long id_empleado, Date fecha,
			String descripcion, String tipo_historial)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegHistorial h = new  SegHistorial();
				 	h.setFecha(fecha);
				 	h.setDescripcion(descripcion);
				 	h.setTipo_historial(tipo_historial);
		      	 	h.setEmpleados(e);
		      	 	e.getHistorial().add(h);
				 	valor = h.getId_historial();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor;
	}

	@Override
	public Long Insertar_Vacaciones(Long id_empleado, Date fecha1, Date fecha2,
			String descripcionl) throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegVacaciones v = new  SegVacaciones();
				 	v.setFecha1(fecha1);
				 	v.setFecha2(fecha2);
				 	v.setDescripcion(descripcionl);
		      	 	v.setEmpleado(e);
		      	 	e.getVacaciones().add(v);
				 	valor = v.getId_vacaciones();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor;
	}
	
	///metodos para Actualizar en las diferentes entidades
			@Override
			public Long Actualizar_Emppleado(Long id,int intafiliacion_igss,
		            String estado_civil, String sexo, String primer_apellido,
		            String segundo_apellido, String apellido_casada,
		            String primer_nombre, String segundo_nombre, String ConIVS, String SinIVS,
		            String pais, String nit,int no_Dependientes,String no_orden, int no_registro, int cui,
		            String tipo_pasaporte, int no_pasaporte,
		            String depto_municipio_cedula, String direccion_actual,
		            String depto_municipio_residencia, String email, int telefono,
		            int celular, Date fecha_nacimiento, String tipo_licencia,
		            int no_licencia, String centro_trabajo, String ocupacion,
		            Date fecha_ingreso, String codigo_ingreso, String profesion,
		            String tipo_planilla, float salario_base, float total,
		            float bonificacion) throws IllegalArgumentException {
				
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
					 try { 
						 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id); 
				
		           e.setAfiliacion_igss(intafiliacion_igss);
		           e.setEstado_civil(estado_civil);
		           e.setSexo(sexo);
		           e.setPrimer_apellido(primer_apellido);
		           e.setSegundo_apellido(segundo_apellido);
		           e.setApellido_casada(apellido_casada);
		           e.setPrimer_nombre(primer_nombre);
		           e.setSegundo_nombre(segundo_nombre);
		           e.setConIVS(ConIVS);
		           e.setSinIVS(SinIVS);
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
				 }finally {  
					 Persistencia.close();  
				 }
				 
				 
				return id;
			}

			@Override
			public Long Actualizar_Familiar(Long id_empleado,Long id, String primer_nombre,
					String segundo_nombre, String primer_apellido,
					String segundo_apellido, int edad, String ocupacion, String parentesco)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
				

				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegFamilia.class.getSimpleName(), id)
							        .getKey();
						 SegFamilia f = Persistencia.getObjectById(SegFamilia.class, k);
						 	f.setPrimer_nombre(primer_nombre);
						 	f.setSegundo_nombre(segundo_nombre);
						 	f.setPrimer_apellido(primer_apellido);
						 	f.setSegundo_apellido(segundo_apellido);
						 	f.setEdad(edad);
						 	f.setOcupacion(ocupacion);
						 	f.setParentesco(parentesco);
						 	valor =f.getId_familia();
					  } finally {
						 	     Persistencia.close();
						 	  }
					return valor ;
		        }

			@Override
			public Long Actualizar_Academico(Long id_empleado,Long id, Date fecha1, Date fecha2,
					String nivel_academico, String establecimiento, String titulo) throws IllegalArgumentException {
				
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				 Long valor = 0L;
				 try { 
					 Key k = new KeyFactory
						        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
						        .addChild(SegHistorialAcademico.class.getSimpleName(), id)
						        .getKey();
					 final SegHistorialAcademico a = Persistencia.getObjectById(SegHistorialAcademico.class, k); 
					 	a.setEstablecimiento(establecimiento);
					 	a.setFecha1(fecha1);
					 	a.setFecha2(fecha2);
					 	a.setNivel_academico(nivel_academico);
					 	a.setTitulo(titulo);
					 	valor = a.getId_historial_academico();
					 }finally {  
						 Persistencia.close();  
					 }
				return valor ;
			}

			@Override
			public Long Actualizar_Referencia_Laboral(Long id_empleado,Long id,
					String nombre_referencia, int telefono, String puesto_candidato,
					String empresa_referencia, Date fecha1, Date fecha2,
					String motivo_retiro, float salario_final,
					String actitudes_cualidades, String recomiendo)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				 Long valor = 0L;
				 try { 
					 Key k = new KeyFactory
						        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
						        .addChild(SegReferenciaLaboral.class.getSimpleName(), id)
						        .getKey();
					 final SegReferenciaLaboral rl = Persistencia.getObjectById(SegReferenciaLaboral.class, k); 
					 	rl.setNombre_referencia(nombre_referencia);
					 	rl.setTelefono(telefono);
					 	rl.setPuesto_candidato(puesto_candidato);
					 	rl.setEmpresa_referencia(empresa_referencia);
					 	rl.setFecha1(fecha1);
					 	rl.setFecha2(fecha2);
					 	rl.setMotivo_retiro(motivo_retiro);
					 	rl.setSalario_final(salario_final);
					 	rl.setActitudes_cualidades(actitudes_cualidades);
					 	rl.setRecomiendo(recomiendo);
					 	valor = rl.getId_referencia_laboral();
					 }finally {  
						 Persistencia.close();  
					 }
				return valor ;
			}

			@Override
			public Long Actualizar_Referencia_Personal(Long id_empleado,Long id,
					String nombre_referencia, int telefono, String puesto_candidato,
					String relacion, String actitudes_cualidades)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegReferenciaPersonal.class.getSimpleName(), id)
							        .getKey();
						 SegReferenciaPersonal rp = Persistencia.getObjectById(SegReferenciaPersonal.class, k); 
						 	rp.setNombre_referencia(nombre_referencia);
						 	rp.setTelefono(telefono);
						 	rp.setPuesto_candidato(puesto_candidato);
						 	rp.setRelacion(relacion);
						 	rp.setActitudes_cualidades(actitudes_cualidades);
						 	valor = rp.getId_referencia_personal();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor ;
			}

			@Override
			public Long Actualizar_Idioma(Long id_empleado,Long id, String nivel, String idioma)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegIdioma.class.getSimpleName(), id)
							        .getKey();
						 final SegIdioma i = Persistencia.getObjectById(SegIdioma.class, k); 
						 	i.setNivel(nivel);
						 	i.setIdioma(idioma);
						 	valor = i.getId_idioma();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor ;
			}

			@Override
			public Long Actualizar_Test(Long id_empleado,Long id,int pregunta1, int pregunt2, int pregunta3,
					int pregunta4, int pregunta5, int pregunta6, int pregunta7,
					int pregunta8, int pregunta9, int pregunta10, Date fecha_test,
					String evaluador, String tipo_test) throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegTest.class.getSimpleName(), id)
							        .getKey();
						 final SegTest t = Persistencia.getObjectById(SegTest.class, k); 
						 	t.setPregunta1(pregunta1);
						 	t.setPregunt2(pregunt2);
						 	t.setPregunta3(pregunta3);
						 	t.setPregunta4(pregunta4);
						 	t.setPregunta5(pregunta5);
						 	t.setPregunta6(pregunta6);
						 	t.setPregunta7(pregunta7);
						 	t.setPregunta8(pregunta8);
						 	t.setPregunta9(pregunta9);
						 	t.setPregunta10(pregunta10);
						 	t.setFecha_test(fecha_test);
						 	t.setEvaluador(evaluador);
						 	valor =t.getId_test();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor ;
			}

			@Override
			public Long Actualizar_Puesto(Long id_empleado,Long id,Date fecha_puesto, String nombre_puesto,
					String funciones, float salario, boolean activo)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegPuesto.class.getSimpleName(), id)
							        .getKey();
						 final SegPuesto p = Persistencia.getObjectById(SegPuesto.class, k);
						 	p.setFecha_puesto(fecha_puesto);
						 	p.setNombre_puesto(nombre_puesto);
						 	p.setFunciones(funciones);
						 	p.setSalario(salario);
						 	p.setActivo(activo);
						 	valor =p.getId_puesto();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor ;
			}

			@Override
			public Long Actualizar_Entrevista(Long id_empleado,Long id, Date fecha_entrevista,
					String que_conoces, String por_que_trabajas_aqui,
					String como_se_describe, String trabajar_por_presion, String metas,
					boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
					boolean flexibilidad_horario, float pretencion_salarial_minimo,
					boolean antecedentes_penales, boolean antecedentes_policiacos,
					boolean carta_recomendacion_laboral,
					boolean carta_recomendacion_personal, boolean vive_con_familia,
					boolean casa_propia, String entrevisto, String enfermedades,
					float aporte_casa, boolean tiene_deudas, int no_dependientes,
					String empresa_credito, boolean alquila,float pago_alquiler,String otros_ingresos)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegEntrevista.class.getSimpleName(), id)
							        .getKey();
						 final SegEntrevista l = Persistencia.getObjectById(SegEntrevista.class, k); 
						 	l.setFecha_entrevista(fecha_entrevista);
						 	l.setQue_conoces(que_conoces);
						 	l.setPor_que_trabajas_aqui(por_que_trabajas_aqui);
						 	l.setComo_se_describe(como_se_describe);
						 	l.setTrabajar_por_presion(trabajar_por_presion);
						 	l.setMetas(metas);
						 	l.setDisponibilidad_inmediata(disponibilidad_inmediata);
						 	l.setDisposicion_a_viajar(disposicion_a_viajar);
						 	l.setFlexibilidad_horario(flexibilidad_horario);
						 	l.setPretencion_salarial_minimo(pretencion_salarial_minimo);
						 	l.setAntecedentes_penales(antecedentes_penales);
						 	l.setAntecedentes_policiacos(antecedentes_policiacos);
						 	l.setCarta_recomendacion_laboral(carta_recomendacion_laboral);
						 	l.setCarta_recomendacion_personal(carta_recomendacion_personal);
						 	l.setVive_con_familia(vive_con_familia);
						 	l.setCasa_propia(casa_propia);
						 	l.setEntrevisto(entrevisto);
						 	l.setEnfermedades(enfermedades);
						 	l.setAporte_casa(aporte_casa);
						 	l.setTiene_deudas(tiene_deudas);
						 	l.setNo_dependientes(no_dependientes);
						 	l.setEmpresa_credito(empresa_credito);
						 	l.setAlquila(alquila);
						 	l.setOtros_Ingresos(otros_ingresos);
						 	valor = l.getId_entrevista();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor ;
			}

			@Override
			public Long Actualizar_Historial(Long id_empleado,Long id, Date fecha,
					String descripcion, String tipo_historial)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegHistorial.class.getSimpleName(), id)
							        .getKey();
						 final SegHistorial  h = Persistencia.getObjectById(SegHistorial.class, k);
						 	h.setFecha(fecha);
						 	h.setDescripcion(descripcion);
						 	h.setTipo_historial(tipo_historial);
						 	valor = h.getId_historial();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor;
			}

			@Override
			public Long Actualizar_Vacaciones(Long id_empleado,Long id, Date fecha1, Date fecha2,
					String descripcionl) throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegVacaciones.class.getSimpleName(), id)
							        .getKey();
						 final SegVacaciones v = Persistencia.getObjectById(SegVacaciones.class, k); 
						 	v.setFecha1(fecha1);
						 	v.setFecha2(fecha2);
						 	v.setDescripcion(descripcionl);
						 	valor = v.getId_vacaciones();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor;
			}
			
			///metodos para Actualizar en las diferentes entidades
            @Override
            public Long Eliminar_Emppleado(Long id) throws IllegalArgumentException {
            	
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
            	final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id); 
                Persistencia.deletePersistent(e);  
                
                return id;
            }

            @Override
            public Long Eliminar_Familiar(Long id_empleado,Long id)throws IllegalArgumentException {
                final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegFamilia.class.getSimpleName(), id)
                        .getKey();
                SegFamilia f = Persistencia.getObjectById(SegFamilia.class, k);
                Persistencia.deletePersistent(f);
                return id ;
                }

            @Override
            public Long Eliminar_Academico(Long id_empleado,Long id) throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegHistorialAcademico.class.getSimpleName(), id)
                        .getKey();
                SegHistorialAcademico f = Persistencia.getObjectById(SegHistorialAcademico.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Referencia_Laboral(Long id_empleado,Long id)throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegReferenciaLaboral.class.getSimpleName(), id)
                        .getKey();
                SegReferenciaLaboral f = Persistencia.getObjectById(SegReferenciaLaboral.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Referencia_Personal(Long id_empleado,Long id) throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegReferenciaPersonal.class.getSimpleName(), id)
                        .getKey();
                SegReferenciaPersonal f = Persistencia.getObjectById(SegReferenciaPersonal.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Idioma(Long id_empleado,Long id)throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegIdioma.class.getSimpleName(), id)
                        .getKey();
                SegIdioma f = Persistencia.getObjectById(SegIdioma.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Test(Long id_empleado,Long id) throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegTest.class.getSimpleName(), id)
                        .getKey();
                SegTest f = Persistencia.getObjectById(SegTest.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Puesto(Long id_empleado,Long id) throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegPuesto.class.getSimpleName(), id)
                        .getKey();
                SegPuesto f = Persistencia.getObjectById(SegPuesto.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Entrevista(Long id_empleado,Long id)throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegEntrevista.class.getSimpleName(), id)
                        .getKey();
                SegEntrevista f = Persistencia.getObjectById(SegEntrevista.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Historial(Long id_empleado,Long id)throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegHistorial.class.getSimpleName(), id)
                        .getKey();
                SegHistorial f = Persistencia.getObjectById(SegHistorial.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }

            @Override
            public Long Eliminar_Vacaciones(Long id_empleado,Long id) throws IllegalArgumentException {
            	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
                Key k = new KeyFactory
                		.Builder(SegEmpleado.class.getSimpleName(), id_empleado)
                		.addChild(SegVacaciones.class.getSimpleName(), id)
                        .getKey();
                SegVacaciones f = Persistencia.getObjectById(SegVacaciones.class, k);
                Persistencia.deletePersistent(f);
                return id ;
            }
            



		

	}