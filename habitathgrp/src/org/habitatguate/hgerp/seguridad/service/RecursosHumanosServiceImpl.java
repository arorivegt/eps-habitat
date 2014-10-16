package org.habitatguate.hgerp.seguridad.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEntrevista;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialAcademico;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxIdioma;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaLaboral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaPersonal;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVacaciones;
import org.habitatguate.hgerp.seguridad.client.rrhh.valores_sesion;
import org.habitatguate.hgerp.seguridad.service.jdo.SegBDPuesto;
import org.habitatguate.hgerp.seguridad.service.jdo.SegBDTest;
import org.habitatguate.hgerp.seguridad.service.jdo.SegEmpleado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegEntrevista;
import org.habitatguate.hgerp.seguridad.service.jdo.SegFamilia;
import org.habitatguate.hgerp.seguridad.service.jdo.SegHistorial;
import org.habitatguate.hgerp.seguridad.service.jdo.SegHistorialAcademico;
import org.habitatguate.hgerp.seguridad.service.jdo.SegIdioma;
import org.habitatguate.hgerp.seguridad.service.jdo.SegPuesto;
import org.habitatguate.hgerp.seguridad.service.jdo.SegReferenciaLaboral;
import org.habitatguate.hgerp.seguridad.service.jdo.SegReferenciaPersonal;
import org.habitatguate.hgerp.seguridad.service.jdo.SegSalario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegTest;
import org.habitatguate.hgerp.seguridad.service.jdo.SegUsuario;
import org.habitatguate.hgerp.seguridad.service.jdo.SegVacaciones;
import org.habitatguate.hgerp.seguridad.service.jdo.SegTestCompartidos;
import org.habitatguate.hgerp.util.PMF;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class RecursosHumanosServiceImpl extends RemoteServiceServlet implements RecursosHumanosService {
	///metodos para insertar en las diferentes entidades
	public String Registro(String user,String pass,String Nombre, String Apellido, Date fecha_nacimiento) throws IllegalArgumentException {

		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
		if(user!=null && pass!=null){
			try{ 
				final SegUsuario e = gestorPersistencia.getObjectById(SegUsuario.class, user); 
				return "El usuario "+e.getUser()+" ya existe" ;
			}catch(Exception e){
				SegEmpleado em = new SegEmpleado();
				em.setPrimer_nombre(Nombre.toUpperCase());
				em.setPrimer_apellido(Apellido.toUpperCase());
				em.setSegundo_apellido("".toUpperCase());
				em.setSegundo_nombre("".toUpperCase());
				em.setEstado("2");
				em.setIVS("0");
				em.setCui("0");
				em.setNoCuenta("0");
				em.setTipoCuenta("1");
				em.setNombreBanco("1");
				em.setEmail(user);
				em.setNo_Dependientes("0");
				em.setAfiliacion_igss("0");
				em.setNo_pasaporte("0");
				em.setTelefono("0");
				em.setCelular("0");
				em.setNo_licencia("0");
				em.setBonificacion(0.0f);
				em.setTotal(0.0f);
				em.setSalario_base(0.0f);
				em.setDepto_municipio_residencia("01,101");
				em.setEstado_civil("0");
				em.setPais("73");
				em.setSexo("1");
				em.setTipo_licencia("0");
				em.setPasaporte("0");
				em.setLicencia("0");
				em.setFecha_nacimiento(fecha_nacimiento);
				em.setFecha_ingreso(new Date());
				try{ 
				    gestorPersistencia.makePersistent(em); 
				}finally{
					SegUsuario u = new SegUsuario(user, pass);
					u.setId_empleado(em.getId_empleado());
					try{ 
					    gestorPersistencia.makePersistent(u); 
					}finally{  
					    gestorPersistencia.close();  
					} 
					
				}
			}

			return "no existe";
		}
		
		return "error";
	}

	@Override
	public valores_sesion login_inicio(String user,String password) throws IllegalArgumentException {
		valores_sesion vs = new valores_sesion();
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
		try{ 
			final SegUsuario e = gestorPersistencia.getObjectById(SegUsuario.class, user);
			if(e.getPassword().equals(md5(password))){
				vs.setCorrecto(true);
				vs.setId_empleado(e.getId_empleado());
			}else{
				vs.setCorrecto(false);
			}
			
			return vs;
		}catch(Exception e){
			vs.setCorrecto(false);
			return vs;
		}
	}


	@Override
	public Long Insertar_Emppleado(String afiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String IVS,
            String pais,String nit, String No_Dependientes,String noCuenta, String tipoCuenta, String nombreBanco, String cui,
            String tipo_pasaporte, String no_pasaporte, String direccion_actual,
            String depto_municipio_residencia, String email, String telefono,
            String celular, Date fecha_nacimiento, String tipo_licencia,
            String no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,String  URLFile, String KeyFile,String Estado,
            String pasaporte, String licencia) throws IllegalArgumentException {
		
		final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
		Long valor = 0L;
		
		
		 try { 
			  
			 SegEmpleado e = new SegEmpleado();
			 e.setAfiliacion_igss(afiliacion_igss);
	         e.setEstado_civil(estado_civil);
	         e.setSexo(sexo);
	         e.setPrimer_apellido(primer_apellido.toUpperCase());
	         e.setSegundo_apellido(segundo_apellido.toUpperCase());
	         e.setApellido_casada(apellido_casada.toUpperCase());
	         e.setPrimer_nombre(primer_nombre.toUpperCase());
	         e.setSegundo_nombre(segundo_nombre.toUpperCase());
	         e.setIVS(IVS);
	         e.setPais(pais);
	         e.setNit(nit);
	         e.setFecha_nacimiento(fecha_nacimiento);
	         e.setNo_Dependientes(No_Dependientes);
	         e.setNoCuenta(noCuenta);
			 e.setTipoCuenta(tipoCuenta);
			 e.setNombreBanco(nombreBanco);
	         e.setCui(cui);
	         e.setTipo_pasaporte(tipo_pasaporte);
	         e.setNo_pasaporte(no_pasaporte);
	         e.setDireccion_actual(direccion_actual.toUpperCase());
	         e.setDepto_municipio_residencia(depto_municipio_residencia);
	         e.setEmail(email);
	         e.setTelefono(telefono);
	         e.setCelular(celular);
	         e.setFecha_ingreso(fecha_ingreso);
	         e.setTipo_licencia(tipo_licencia);
	         e.setNo_licencia(no_licencia);
	         e.setCentro_trabajo(centro_trabajo.toUpperCase());
	         e.setOcupacion(ocupacion.toUpperCase());
	         e.setFecha_ingreso(fecha_ingreso);
	         e.setCodigo_ingreso(codigo_ingreso.toUpperCase());
	         e.setProfesion(profesion.toUpperCase());
	         e.setTipo_planilla(tipo_planilla.toUpperCase());
	         e.setSalario_base(salario_base);
	         e.setTotal(total);
	         e.setBonificacion(bonificacion);
	         e.setURLFile(URLFile);
	         e.setKeyFile(KeyFile);
	         e.setEstado(Estado);
	         e.setPasaporte(pasaporte);
	         e.setLicencia(licencia);
	         gestorPersistencia.makePersistent(e); 
	         valor = e.getId_empleado();
	         
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
			 	f.setPrimer_nombre(primer_nombre.toUpperCase());
			 	f.setSegundo_nombre(segundo_nombre.toUpperCase());
			 	f.setPrimer_apellido(primer_apellido.toUpperCase());
			 	f.setSegundo_apellido(segundo_apellido.toUpperCase());
			 	f.setEdad(edad);
			 	f.setOcupacion(ocupacion.toUpperCase());
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
			String nivel_academico, String establecimiento, String titulo
			,String  URLFile, String KeyFile) throws IllegalArgumentException {
		
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		 Long valor = 0L;
		 try { 
			 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
			 SegHistorialAcademico a = new SegHistorialAcademico();
			 	a.setEstablecimiento(establecimiento.toUpperCase());
			 	a.setFecha1(fecha1);
			 	a.setFecha2(fecha2);
			 	a.setNivel_academico(nivel_academico);
			 	a.setTitulo(titulo.toUpperCase());
		        a.setURLFile(URLFile);
		        a.setKeyFile(KeyFile);
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
			String nombre_referencia, String telefono, String puesto_candidato,
			String empresa_referencia, Date fecha1, Date fecha2,
			String motivo_retiro, float salario_final,
			String actitudes_cualidades, String recomiendo)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		 Long valor = 0L;
		 try { 
			 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
			 SegReferenciaLaboral rl = new  SegReferenciaLaboral();
			 	rl.setNombre_referencia(nombre_referencia.toUpperCase());
			 	rl.setTelefono(telefono);
			 	rl.setPuesto_candidato(puesto_candidato.toUpperCase());
			 	rl.setEmpresa_referencia(empresa_referencia.toUpperCase());
			 	rl.setFecha1(fecha1);
			 	rl.setFecha2(fecha2);
			 	rl.setMotivo_retiro(motivo_retiro.toUpperCase());
			 	rl.setSalario_final(salario_final);
			 	rl.setActitudes_cualidades(actitudes_cualidades.toUpperCase());
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
			String nombre_referencia, String telefono, String puesto_candidato,
			String relacion, String actitudes_cualidades)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegReferenciaPersonal rp = new  SegReferenciaPersonal();
				 	rp.setNombre_referencia(nombre_referencia.toUpperCase());
				 	rp.setTelefono(telefono);
				 	rp.setPuesto_candidato(puesto_candidato.toUpperCase());
				 	rp.setRelacion(relacion.toUpperCase());
				 	rp.setActitudes_cualidades(actitudes_cualidades.toUpperCase());
		      	 	rp.setEmpleados(e);
		      	 	e.getReferencia_personal().add(rp);
				 	valor = rp.getId_referencia_personal();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor ;
	}

	@Override
	public Long Insertar_Idioma(Long id_empleado, String nivel, String idioma
			,String  URLFile, String KeyFile)throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegIdioma i = new  SegIdioma();
				 	i.setNivel(nivel);
				 	i.setIdioma(idioma.toUpperCase());
		      	 	i.setEmpleados(e);
			        i.setURLFile(URLFile);
			        i.setKeyFile(KeyFile);
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
			String evaluador, Long BDtest,boolean testBD,String tipo_test) throws IllegalArgumentException {
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
				 	t.setEvaluador(evaluador.toUpperCase());
				 	t.setTipo_test(tipo_test);
				 	t.setTestBD(testBD);
				 	t.setBDtest(BDtest);
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
				 	p.setNombre_puesto(nombre_puesto.toUpperCase());
				 	p.setFunciones(funciones.toUpperCase());
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
			String empresa_credito, boolean alquila,float pago_alquiler,String Otros_Ingresos,float amortizacion)
			throws IllegalArgumentException {
		final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
		
		Long valor = 0L;
			 try { 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
				 SegEntrevista l = new  SegEntrevista();
				 	l.setAmortizacion(amortizacion);
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
		      	 	l.setEmpleado(e);;
		      	 	e.getEntrevista().add(l);
				 	valor = l.getId_entrevista().getId();
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
				 	h.setDescripcion(descripcion.toUpperCase());
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
				 	v.setDescripcion(descripcionl.toUpperCase());
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
			public Long Actualizar_Emppleado(Long id,String afiliacion_igss,
		            String estado_civil, String sexo, String primer_apellido,
		            String segundo_apellido, String apellido_casada,
		            String primer_nombre, String segundo_nombre, String IVS,
		            String pais,String nit, String No_Dependientes, String noCuenta, String tipoCuenta, String nombreBanco, String cui,
		            String tipo_pasaporte, String no_pasaporte,String direccion_actual,
		            String depto_municipio_residencia, String email, String telefono,
		            String celular, Date fecha_nacimiento, String tipo_licencia,
		            String no_licencia, String centro_trabajo, String ocupacion,
		            Date fecha_ingreso, String codigo_ingreso, String profesion,
		            String tipo_planilla, float salario_base, float total,
		            float bonificacion,String  URLFile, String KeyFile,String Estado,String pasaporte, String licencia) throws IllegalArgumentException {
				


				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
					 try {  
							 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id); 
							 e.setAfiliacion_igss(afiliacion_igss);
					         e.setEstado_civil(estado_civil);
					         e.setSexo(sexo);
					         e.setPrimer_apellido(primer_apellido.toUpperCase());
					         e.setSegundo_apellido(segundo_apellido.toUpperCase());
					         e.setApellido_casada(apellido_casada.toUpperCase());
					         e.setPrimer_nombre(primer_nombre.toUpperCase());
					         e.setSegundo_nombre(segundo_nombre.toUpperCase());
					         e.setIVS(IVS);
					         e.setPais(pais);
					         e.setNit(nit);
					         e.setFecha_nacimiento(fecha_nacimiento);
					         e.setNo_Dependientes(No_Dependientes);
					         e.setNoCuenta(noCuenta);
							 e.setTipoCuenta(tipoCuenta);
							 e.setNombreBanco(nombreBanco);
					         e.setCui(cui);
					         e.setTipo_pasaporte(tipo_pasaporte);
					         e.setNo_pasaporte(no_pasaporte);
					         e.setDireccion_actual(direccion_actual.toUpperCase());
					         e.setDepto_municipio_residencia(depto_municipio_residencia);
					         e.setEmail(email);
					         e.setTelefono(telefono);
					         e.setCelular(celular);
					         e.setFecha_ingreso(fecha_ingreso);
					         e.setTipo_licencia(tipo_licencia);
					         e.setNo_licencia(no_licencia);
					         e.setCentro_trabajo(centro_trabajo.toUpperCase());
					         e.setOcupacion(ocupacion.toUpperCase());
					         e.setFecha_ingreso(fecha_ingreso);
					         e.setCodigo_ingreso(codigo_ingreso.toUpperCase());
					         e.setProfesion(profesion.toUpperCase());
					         e.setTipo_planilla(tipo_planilla.toUpperCase());
					         e.setSalario_base(salario_base);
					         e.setTotal(total);
					         e.setBonificacion(bonificacion);
					         e.setURLFile(URLFile);
					         e.setKeyFile(KeyFile);
					         e.setEstado(Estado);
					         e.setPasaporte(pasaporte);
					         e.setLicencia(licencia);
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
						 	f.setPrimer_nombre(primer_nombre.toUpperCase());
						 	f.setSegundo_nombre(segundo_nombre.toUpperCase());
						 	f.setPrimer_apellido(primer_apellido.toUpperCase());
						 	f.setSegundo_apellido(segundo_apellido.toUpperCase());
						 	f.setEdad(edad);
						 	f.setOcupacion(ocupacion.toUpperCase());
						 	f.setParentesco(parentesco);
						 	valor =f.getId_familia();
					  } finally {
						 	     Persistencia.close();
						 	  }
					return valor ;
		        }

			@Override
			public Long Actualizar_Academico(Long id_empleado,Long id, Date fecha1, Date fecha2,
					String nivel_academico, String establecimiento, String titulo
					,String  URLFile, String KeyFile) throws IllegalArgumentException {
				
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				 Long valor = 0L;
				 try { 
					 Key k = new KeyFactory
						        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
						        .addChild(SegHistorialAcademico.class.getSimpleName(), id)
						        .getKey();
					 final SegHistorialAcademico a = Persistencia.getObjectById(SegHistorialAcademico.class, k); 
					 	a.setEstablecimiento(establecimiento.toUpperCase());
					 	a.setFecha1(fecha1);
					 	a.setFecha2(fecha2);
					 	a.setNivel_academico(nivel_academico);
					 	a.setTitulo(titulo);
				        a.setURLFile(URLFile);
				        a.setKeyFile(KeyFile);
					 	valor = a.getId_historial_academico();
					 }finally {  
						 Persistencia.close();  
					 }
				return valor ;
			}

			@Override
			public Long Actualizar_Referencia_Laboral(Long id_empleado,Long id,
					String nombre_referencia, String telefono, String puesto_candidato,
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
					 	rl.setNombre_referencia(nombre_referencia.toUpperCase());
					 	rl.setTelefono(telefono);
					 	rl.setPuesto_candidato(puesto_candidato.toUpperCase());
					 	rl.setEmpresa_referencia(empresa_referencia.toUpperCase());
					 	rl.setFecha1(fecha1);
					 	rl.setFecha2(fecha2);
					 	rl.setMotivo_retiro(motivo_retiro.toUpperCase());
					 	rl.setSalario_final(salario_final);
					 	rl.setActitudes_cualidades(actitudes_cualidades.toUpperCase());
					 	rl.setRecomiendo(recomiendo);
					 	valor = rl.getId_referencia_laboral();
					 }finally {  
						 Persistencia.close();  
					 }
				return valor ;
			}

			@Override
			public Long Actualizar_Referencia_Personal(Long id_empleado,Long id,
					String nombre_referencia, String telefono, String puesto_candidato,
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
						 	rp.setNombre_referencia(nombre_referencia.toUpperCase());
						 	rp.setTelefono(telefono);
						 	rp.setPuesto_candidato(puesto_candidato.toUpperCase());
						 	rp.setRelacion(relacion);
						 	rp.setActitudes_cualidades(actitudes_cualidades.toUpperCase());
						 	valor = rp.getId_referencia_personal();
						 }finally {  
							 Persistencia.close();  
						 }
					return valor ;
			}

			@Override
			public Long Actualizar_Idioma(Long id_empleado,Long id, String nivel, String idioma
					,String  URLFile, String KeyFile)
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
						 	i.setIdioma(idioma.toUpperCase());
					        i.setURLFile(URLFile);
					        i.setKeyFile(KeyFile);
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
					String evaluador, Long BDtest,boolean testBD,String tipo_test) throws IllegalArgumentException {
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
						 	t.setBDtest(BDtest);
						 	t.setTestBD(testBD);
						 	t.setEvaluador(evaluador.toUpperCase());
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
						 	p.setNombre_puesto(nombre_puesto.toUpperCase());
						 	p.setFunciones(funciones.toUpperCase());
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
					String empresa_credito, boolean alquila,float pago_alquiler,String otros_ingresos,float amortizacion)
					throws IllegalArgumentException {
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				Long valor = 0L;
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
							        .addChild(SegEntrevista.class.getSimpleName(), id)
							        .getKey();
						 final SegEntrevista l = Persistencia.getObjectById(SegEntrevista.class, k); 

						 	l.setAmortizacion(amortizacion);
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
						 	valor = l.getId_entrevista().getId();
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
						 	h.setDescripcion(descripcion.toUpperCase());
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
						 	v.setDescripcion(descripcionl.toUpperCase());
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
            

            @SuppressWarnings("unchecked")
			@Override
			public List<AuxEmpleado> Buscar_Empleado(char tipo, String primer_nombre, String segundo_nombre, 
					String primer_apellido, String segundo_apellido,String DPI, String Pasaporte
					,String Estado)throws IllegalArgumentException {
				final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
				
				List<AuxEmpleado> valor = new ArrayList<AuxEmpleado>();
				List<SegEmpleado> results = null ;
				
				if(tipo=='1' || tipo =='2'){
					Query q = pm.newQuery(SegEmpleado.class);
					q.setFilter("primer_nombre == '"+primer_nombre.toUpperCase()+"'");
					q.setFilter("primer_apellido == '"+primer_apellido.toUpperCase()+"'");
					q.setFilter("segundo_apellido == '"+segundo_apellido.toUpperCase()+"'");
					results = (List<SegEmpleado>) q.execute();
				}else if(tipo=='4'){
					Query q = pm.newQuery(SegEmpleado.class,"cui == '"+DPI.toUpperCase()+"'");
					results = (List<SegEmpleado>) q.execute();
				}else if(tipo=='3'){
					Query q = pm.newQuery(SegEmpleado.class,"no_pasaporte == '"+Pasaporte.toUpperCase()+"'");
					results = (List<SegEmpleado>) q.execute();
				}else if(tipo=='5'){
					Query q = pm.newQuery(SegEmpleado.class,"Estado== '"+Estado+"'");
					results = (List<SegEmpleado>) q.execute();
				}
				if(!results.isEmpty())
				{
					 for (SegEmpleado p : results) {
					    	AuxEmpleado nuevo = new AuxEmpleado();
					    	nuevo.setAfiliacion_igss(p.getAfiliacion_igss());
					    	nuevo.setApellido_casada(p.getApellido_casada());
					    	nuevo.setBonificacion(p.getBonificacion());
					    	nuevo.setCelular(p.getCelular());
					    	nuevo.setCentro_trabajo(p.getCentro_trabajo());
					    	nuevo.setCodigo_ingreso(p.getCodigo_ingreso());
					    	nuevo.setIVS(p.getIVS());
					    	nuevo.setCui(p.getCui());
					    	nuevo.setDepto_municipio_residencia(p.getDepto_municipio_residencia());
					    	nuevo.setDireccion_actual(p.getDireccion_actual());
					    	nuevo.setEmail(p.getEmail());
					    	nuevo.setURLFile(p.getURLFile());
					    	nuevo.setKeyFile(p.getKeyFile());
					    	nuevo.setEstado(p.getEstado());
					    	nuevo.setPasaporte(p.getPasaporte());
					    	nuevo.setLicencia(p.getLicencia());
					    	List<SegEntrevista> results0 = p.getEntrevista();
					    	if (!results0.isEmpty()) {
							    for (SegEntrevista n0 : results0) {
							    	AuxEntrevista l = new AuxEntrevista();
							    	l.setId_entrevista(n0.getId_entrevista().getId());
							    	l.setFecha_entrevista(n0.getFecha_entrevista().getTime());
								 	l.setQue_conoces(n0.getQue_conoces());
								 	l.setPor_que_trabajas_aqui(n0.getPor_que_trabajas_aqui());
								 	l.setComo_se_describe(n0.getComo_se_describe());
								 	l.setTrabajar_por_presion(n0.getTrabajar_por_presion());
								 	l.setMetas(n0.getMetas());
								 	l.setDisponibilidad_inmediata(n0.getDisponibilidad_inmediata());
								 	l.setDisposicion_a_viajar(n0.getDisposicion_a_viajar());
								 	l.setFlexibilidad_horario(n0.getFlexibilidad_horario());
								 	l.setPretencion_salarial_minimo(n0.getPretencion_salarial_minimo());
								 	l.setAntecedentes_penales(n0.getAntecedentes_penales());
								 	l.setAntecedentes_policiacos(n0.getAntecedentes_policiacos());
								 	l.setCarta_recomendacion_laboral(n0.getCarta_recomendacion_laboral());
								 	l.setCarta_recomendacion_personal(n0.getCarta_recomendacion_personal());
								 	l.setVive_con_familia(n0.getVive_con_familia());
								 	l.setCasa_propia(n0.getCasa_propia());
								 	l.setEntrevisto(n0.getEntrevisto());
								 	l.setEnfermedades(n0.getEnfermedades());
								 	l.setAporte_casa(n0.getAporte_casa());
								 	l.setTiene_deudas(n0.getTiene_deudas());
								 	l.setNo_dependientes(n0.getNo_dependientes());
								 	l.setEmpresa_credito(n0.getEmpresa_credito());
								 	l.setAlquila(n0.getAlquila());
								 	l.setOtros_Ingresos(n0.getOtros_Ingresos());
								 	l.setAmortizacion(n0.getAmortizacion());
								 	nuevo.getEntrevista().add(l);
							    }
					    	}
					    	nuevo.setEstado_civil(p.getEstado_civil());
					    	
					    	List<SegFamilia> results22 = p.getFamilia();
					    	if (!results22.isEmpty()) {
							    for (SegFamilia n : results22) {
							    	AuxFamilia f = new AuxFamilia();
							    	f.setId_familia(n.getId_familia());
								 	f.setPrimer_nombre(n.getPrimer_nombre());
								 	f.setSegundo_nombre(n.getSegundo_nombre());
								 	f.setPrimer_apellido(n.getPrimer_apellido());
								 	f.setSegundo_apellido(n.getSegundo_apellido());
								 	f.setEdad(n.getEdad());
								 	f.setOcupacion(n.getOcupacion());
								 	f.setParentesco(n.getParentesco());
								 	nuevo.getFamilia().add(f);
							    }
					    	}
							    
					    	nuevo.setFecha_ingreso(p.getFecha_ingreso().getTime());
					    	nuevo.setFecha_nacimiento(p.getFecha_nacimiento().getTime());
					    	
					    	List< SegHistorialAcademico> results2 = p.getHistorial_academico();
					    	if (!results2.isEmpty()) {
							    for ( SegHistorialAcademico n2 : results2) {

							    	AuxHistorialAcademico a = new AuxHistorialAcademico();
							    	a.setId_historial_academico(n2.getId_historial_academico());
							    	a.setEstablecimiento(n2.getEstablecimiento());
								 	a.setFecha1(n2.getFecha1().getTime());
								 	a.setFecha2(n2.getFecha2().getTime());
								 	a.setNivel_academico(n2.getNivel_academico());
								 	a.setTitulo(n2.getTitulo());
							    	a.setURLFile(n2.getURLFile());
							    	a.setKeyFile(n2.getKeyFile());
								 	nuevo.getHistorial_academico().add(a);
							    }
					    	}
					    	
					    	List< SegHistorial> results3 = p.getHistorial();
					    	if (!results3.isEmpty()) {
							    for ( SegHistorial n3 : results3) {

							    	AuxHistorial h = new AuxHistorial();
							    	h.setId_historial(n3.getId_historial());
							    	h.setFecha(n3.getFecha().getTime());
								 	h.setDescripcion(n3.getDescripcion());
								 	h.setTipo_historial(n3.getTipo_historial());
								 	nuevo.getHistorial().add(h);
							    }
					    	}
					    	nuevo.setId_empleado(p.getId_empleado());
					    	
					    	List<SegIdioma> results4 = p.getIdiomas();
					    	if (!results4.isEmpty()) {
							    for (SegIdioma n4 : results4) {

							    	AuxIdioma i = new AuxIdioma();
							    	i.setId_idioma(n4.getId_idioma());
								 	i.setNivel(n4.getNivel());
								 	i.setIdioma(n4.getIdioma());
							    	i.setURLFile(n4.getURLFile());
							    	i.setKeyFile(n4.getKeyFile());
								 	nuevo.getIdiomas().add(i);
							    }
					    	}
					    	nuevo.setNit(p.getNit());
					    	nuevo.setNo_Dependientes(p.getNo_Dependientes());
					    	nuevo.setNo_licencia(p.getNo_licencia());
					        nuevo.setNoCuenta(p.getNoCuenta());
					        nuevo.setTipoCuenta(p.getTipoCuenta());
					        nuevo.setNombreBanco(p.getNombreBanco());
					    	nuevo.setNo_pasaporte(p.getNo_pasaporte());
					    	nuevo.setOcupacion(p.getOcupacion());
					    	nuevo.setPais(p.getPais());
					    	nuevo.setPrimer_apellido(p.getPrimer_apellido());
					    	nuevo.setPrimer_nombre(p.getPrimer_nombre());
					    	nuevo.setProfesion(p.getProfesion());
					    	
					    	List<SegPuesto> results5 = p.getPuestos();
					    	if (!results5.isEmpty()) {
							    for (SegPuesto n5 : results5) {

							    	AuxPuesto pp = new AuxPuesto();
							    	pp.setId_puesto(n5.getId_puesto());
							    	pp.setFecha_puesto(n5.getFecha_puesto().getTime());
								 	pp.setNombre_puesto(n5.getNombre_puesto());
								 	pp.setFunciones(n5.getFunciones());
								 	pp.setSalario(n5.getSalario());
								 	pp.setActivo(n5.getActivo());
								 	nuevo.getPuestos().add(pp);
							    }
					    	}
					    	
					    	List<SegReferenciaPersonal> results6 = p.getReferencia_personal();
					    	if (!results6.isEmpty()) {
							    for (SegReferenciaPersonal n6 : results6) {

							    	AuxReferenciaPersonal rp = new AuxReferenciaPersonal();
							    	rp.setId_referencia_personal(n6.getId_referencia_personal());
							    	rp.setNombre_referencia(n6.getNombre_referencia());
								 	rp.setTelefono(n6.getTelefono());
								 	rp.setPuesto_candidato(n6.getPuesto_candidato());
								 	rp.setRelacion(n6.getRelacion());
								 	rp.setActitudes_cualidades(n6.getActitudes_cualidades());
								 	nuevo.getReferencia_personal().add(rp);
							    }
					    	}
					    	
					    	List<SegReferenciaLaboral> results7 = p.getReferencia_laboral();
					    	if (!results7.isEmpty()) {
							    for (SegReferenciaLaboral n7 : results7) {

							    	AuxReferenciaLaboral rl = new AuxReferenciaLaboral();
							    	rl.setId_referencia_laboral(n7.getId_referencia_laboral());
							    	rl.setNombre_referencia(n7.getNombre_referencia());
								 	rl.setTelefono(n7.getTelefono());
								 	rl.setPuesto_candidato(n7.getPuesto_candidato());
								 	rl.setEmpresa_referencia(n7.getEmpresa_referencia());
								 	rl.setFecha1(n7.getFecha1().getTime());
								 	rl.setFecha2(n7.getFecha2().getTime());
								 	rl.setMotivo_retiro(n7.getMotivo_retiro());
								 	rl.setSalario_final(n7.getSalario_final());
								 	rl.setActitudes_cualidades(n7.getActitudes_cualidades());
								 	rl.setRecomiendo(n7.getRecomiendo());
								 	nuevo.getReferencia_laboral().add(rl);
							    }
					    	}
					    	nuevo.setSalario_base(p.getSalario_base());
					    	nuevo.setSegundo_apellido(p.getSegundo_apellido());
					    	nuevo.setSegundo_nombre(p.getSegundo_nombre());
					    	nuevo.setSexo(p.getSexo());
					    	nuevo.setTelefono(p.getTelefono());
					    	
					    	List<SegTest> results8 = p.getTest();
					    	if (!results8.isEmpty()) {
							    for (SegTest n8 : results8) {

							    	AuxTest t= new AuxTest();
							    	t.setId_test(n8.getId_test());
							    	t.setPregunta1(n8.getPregunta1());
								 	t.setPregunt2(n8.getPregunt2());
								 	t.setPregunta3(n8.getPregunta3());
								 	t.setPregunta4(n8.getPregunta4());
								 	t.setPregunta5(n8.getPregunta5());
								 	t.setPregunta6(n8.getPregunta6());
								 	t.setPregunta7(n8.getPregunta7());
								 	t.setPregunta8(n8.getPregunta8());
								 	t.setPregunta9(n8.getPregunta9());
								 	t.setPregunta10(n8.getPregunta10());
								 	t.setFecha_test(n8.getFecha_test().getTime());
								 	t.setEvaluador(n8.getEvaluador());
								 	t.setBDtest(n8.getBDtest());
								 	t.setTipo_test(n8.getTipo_test());
								 	t.setTestBD(n8.isTestBD());
								 	nuevo.getTest().add(t);
							    }
					    	}
					    	nuevo.setTipo_licencia(p.getTipo_licencia());
					    	nuevo.setTipo_pasaporte(p.getTipo_pasaporte());
					    	nuevo.setTipo_planilla(p.getTipo_planilla());
					    	nuevo.setTotal(p.getTotal());
					    	
					    	List<SegVacaciones> results9 = p.getVacaciones();
					    	if (!results9.isEmpty()) {
							    for (SegVacaciones n9 : results9) {

							    	AuxVacaciones v= new AuxVacaciones();
							    	v.setId_vacaciones(n9.getId_vacaciones());
							    	v.setFecha1(n9.getFecha1().getTime());
								 	v.setFecha2(n9.getFecha2().getTime());
								 	v.setDescripcion(n9.getDescripcion());
								 	nuevo.getVacaciones().add(v);
							    }
					    	}
					    	List<SegSalario> results10 = p.getSalario();
					    	if (!results10.isEmpty()) {
							    for (SegSalario n10 : results10) {
							    	AuxSalario s = new AuxSalario();
							    	s.setFecha(n10.getFecha().getTime());
							    	s.setSalario(n10.getSalario());
							    	s.setTipoSalario(n10.getTipoSalario());
							    	nuevo.getSalario().add(s);
							    }
					    	}
				    		valor.add(nuevo);
					    }
					 return valor;
				}
//				if (!results.isEmpty() && tipo=='1' || tipo =='2') {
//				    for (SegEmpleado p : results) {
//				    	if((primer_nombre.toUpperCase().equals(p.getPrimer_nombre()) 
//				    	|| segundo_nombre.toUpperCase().equals(p.getSegundo_nombre())
//				    	|| primer_apellido.toUpperCase().equals(p.getPrimer_apellido())
//				    	|| segundo_apellido.toUpperCase().equals(p.getSegundo_apellido())) && tipo =='1')
//				    	{
//							System.out.println("buscado "+tipo);
//				    		AuxEmpleado nuevo = new AuxEmpleado();
//				    		nuevo.setId_empleado(p.getId_empleado());
//				    		nuevo.setPrimer_apellido(p.getPrimer_apellido());
//				    		nuevo.setPrimer_nombre(p.getPrimer_nombre());
//				    		nuevo.setSegundo_apellido(p.getSegundo_apellido());
//				    		nuevo.setSegundo_nombre(p.getSegundo_nombre());
//				    		valor.add(nuevo);
//				    	}
//				    	if(tipo == '2'){
//					    	AuxEmpleado nuevo = new AuxEmpleado();
//					    	nuevo.setAfiliacion_igss(p.getAfiliacion_igss());
//					    	nuevo.setApellido_casada(p.getApellido_casada());
//					    	nuevo.setBonificacion(p.getBonificacion());
//					    	nuevo.setCelular(p.getCelular());
//					    	nuevo.setCentro_trabajo(p.getCentro_trabajo());
//					    	nuevo.setCodigo_ingreso(p.getCodigo_ingreso());
//					    	nuevo.setIVS(p.getIVS());
//					    	nuevo.setCui(p.getCui());
//					    	nuevo.setDepto_municipio_cedula(p.getDepto_municipio_cedula());
//					    	nuevo.setDepto_municipio_residencia(p.getDepto_municipio_residencia());
//					    	nuevo.setDireccion_actual(p.getDireccion_actual());
//					    	nuevo.setEmail(p.getEmail());
//					    	nuevo.setURLFile(p.getURLFile());
//					    	nuevo.setKeyFile(p.getKeyFile());
//					    	nuevo.setEstado(p.getEstado());
//					    	nuevo.setPasaporte(p.getPasaporte());
//					    	nuevo.setLicencia(p.getLicencia());
//					    	List<SegEntrevista> results0 = p.getEntrevista();
//					    	if (!results0.isEmpty()) {
//							    for (SegEntrevista n0 : results0) {
//							    	AuxEntrevista l = new AuxEntrevista();
//							    	l.setId_entrevista(n0.getId_entrevista().getId());
//							    	l.setFecha_entrevista(n0.getFecha_entrevista().getTime());
//								 	l.setQue_conoces(n0.getQue_conoces());
//								 	l.setPor_que_trabajas_aqui(n0.getPor_que_trabajas_aqui());
//								 	l.setComo_se_describe(n0.getComo_se_describe());
//								 	l.setTrabajar_por_presion(n0.getTrabajar_por_presion());
//								 	l.setMetas(n0.getMetas());
//								 	l.setDisponibilidad_inmediata(n0.getDisponibilidad_inmediata());
//								 	l.setDisposicion_a_viajar(n0.getDisposicion_a_viajar());
//								 	l.setFlexibilidad_horario(n0.getFlexibilidad_horario());
//								 	l.setPretencion_salarial_minimo(n0.getPretencion_salarial_minimo());
//								 	l.setAntecedentes_penales(n0.getAntecedentes_penales());
//								 	l.setAntecedentes_policiacos(n0.getAntecedentes_policiacos());
//								 	l.setCarta_recomendacion_laboral(n0.getCarta_recomendacion_laboral());
//								 	l.setCarta_recomendacion_personal(n0.getCarta_recomendacion_personal());
//								 	l.setVive_con_familia(n0.getVive_con_familia());
//								 	l.setCasa_propia(n0.getCasa_propia());
//								 	l.setEntrevisto(n0.getEntrevisto());
//								 	l.setEnfermedades(n0.getEnfermedades());
//								 	l.setAporte_casa(n0.getAporte_casa());
//								 	l.setTiene_deudas(n0.getTiene_deudas());
//								 	l.setNo_dependientes(n0.getNo_dependientes());
//								 	l.setEmpresa_credito(n0.getEmpresa_credito());
//								 	l.setAlquila(n0.getAlquila());
//								 	l.setOtros_Ingresos(n0.getOtros_Ingresos());
//								 	l.setAmortizacion(n0.getAmortizacion());
//								 	nuevo.getEntrevista().add(l);
//							    }
//					    	}
//					    	nuevo.setEstado_civil(p.getEstado_civil());
//					    	
//					    	List<SegFamilia> results22 = p.getFamilia();
//					    	if (!results22.isEmpty()) {
//							    for (SegFamilia n : results22) {
//							    	AuxFamilia f = new AuxFamilia();
//							    	f.setId_familia(n.getId_familia());
//								 	f.setPrimer_nombre(n.getPrimer_nombre());
//								 	f.setSegundo_nombre(n.getSegundo_nombre());
//								 	f.setPrimer_apellido(n.getPrimer_apellido());
//								 	f.setSegundo_apellido(n.getSegundo_apellido());
//								 	f.setEdad(n.getEdad());
//								 	f.setOcupacion(n.getOcupacion());
//								 	f.setParentesco(n.getParentesco());
//								 	nuevo.getFamilia().add(f);
//							    }
//					    	}
//							    
//					    	nuevo.setFecha_ingreso(p.getFecha_ingreso().getTime());
//					    	nuevo.setFecha_nacimiento(p.getFecha_nacimiento().getTime());
//					    	
//					    	List< SegHistorialAcademico> results2 = p.getHistorial_academico();
//					    	if (!results2.isEmpty()) {
//							    for ( SegHistorialAcademico n2 : results2) {
//
//							    	AuxHistorialAcademico a = new AuxHistorialAcademico();
//							    	a.setId_historial_academico(n2.getId_historial_academico());
//							    	a.setEstablecimiento(n2.getEstablecimiento());
//								 	a.setFecha1(n2.getFecha1().getTime());
//								 	a.setFecha2(n2.getFecha2().getTime());
//								 	a.setNivel_academico(n2.getNivel_academico());
//								 	a.setTitulo(n2.getTitulo());
//							    	a.setURLFile(n2.getURLFile());
//							    	a.setKeyFile(n2.getKeyFile());
//								 	nuevo.getHistorial_academico().add(a);
//							    }
//					    	}
//					    	
//					    	List< SegHistorial> results3 = p.getHistorial();
//					    	if (!results3.isEmpty()) {
//							    for ( SegHistorial n3 : results3) {
//
//							    	AuxHistorial h = new AuxHistorial();
//							    	h.setId_historial(n3.getId_historial());
//							    	h.setFecha(n3.getFecha().getTime());
//								 	h.setDescripcion(n3.getDescripcion());
//								 	h.setTipo_historial(n3.getTipo_historial());
//								 	nuevo.getHistorial().add(h);
//							    }
//					    	}
//					    	nuevo.setId_empleado(p.getId_empleado());
//					    	
//					    	List<SegIdioma> results4 = p.getIdiomas();
//					    	if (!results4.isEmpty()) {
//							    for (SegIdioma n4 : results4) {
//
//							    	AuxIdioma i = new AuxIdioma();
//							    	i.setId_idioma(n4.getId_idioma());
//								 	i.setNivel(n4.getNivel());
//								 	i.setIdioma(n4.getIdioma());
//							    	i.setURLFile(n4.getURLFile());
//							    	i.setKeyFile(n4.getKeyFile());
//								 	nuevo.getIdiomas().add(i);
//							    }
//					    	}
//					    	nuevo.setNit(p.getNit());
//					    	nuevo.setNo_Dependientes(p.getNo_Dependientes());
//					    	nuevo.setNo_licencia(p.getNo_licencia());
//					    	nuevo.setNo_orden(p.getNo_orden());
//					    	nuevo.setNo_pasaporte(p.getNo_pasaporte());
//					    	nuevo.setNo_registro(p.getNo_registro());
//					    	nuevo.setOcupacion(p.getOcupacion());
//					    	nuevo.setPais(p.getPais());
//					    	nuevo.setPrimer_apellido(p.getPrimer_apellido());
//					    	nuevo.setPrimer_nombre(p.getPrimer_nombre());
//					    	nuevo.setProfesion(p.getProfesion());
//					    	
//					    	List<SegPuesto> results5 = p.getPuestos();
//					    	if (!results5.isEmpty()) {
//							    for (SegPuesto n5 : results5) {
//
//							    	AuxPuesto pp = new AuxPuesto();
//							    	pp.setId_puesto(n5.getId_puesto());
//							    	pp.setFecha_puesto(n5.getFecha_puesto().getTime());
//								 	pp.setNombre_puesto(n5.getNombre_puesto());
//								 	pp.setFunciones(n5.getFunciones());
//								 	pp.setSalario(n5.getSalario());
//								 	pp.setActivo(n5.getActivo());
//								 	nuevo.getPuestos().add(pp);
//							    }
//					    	}
//					    	
//					    	List<SegReferenciaPersonal> results6 = p.getReferencia_personal();
//					    	if (!results6.isEmpty()) {
//							    for (SegReferenciaPersonal n6 : results6) {
//
//							    	AuxReferenciaPersonal rp = new AuxReferenciaPersonal();
//							    	rp.setId_referencia_personal(n6.getId_referencia_personal());
//							    	rp.setNombre_referencia(n6.getNombre_referencia());
//								 	rp.setTelefono(n6.getTelefono());
//								 	rp.setPuesto_candidato(n6.getPuesto_candidato());
//								 	rp.setRelacion(n6.getRelacion());
//								 	rp.setActitudes_cualidades(n6.getActitudes_cualidades());
//								 	nuevo.getReferencia_personal().add(rp);
//							    }
//					    	}
//					    	
//					    	List<SegReferenciaLaboral> results7 = p.getReferencia_laboral();
//					    	if (!results7.isEmpty()) {
//							    for (SegReferenciaLaboral n7 : results7) {
//
//							    	AuxReferenciaLaboral rl = new AuxReferenciaLaboral();
//							    	rl.setId_referencia_laboral(n7.getId_referencia_laboral());
//							    	rl.setNombre_referencia(n7.getNombre_referencia());
//								 	rl.setTelefono(n7.getTelefono());
//								 	rl.setPuesto_candidato(n7.getPuesto_candidato());
//								 	rl.setEmpresa_referencia(n7.getEmpresa_referencia());
//								 	rl.setFecha1(n7.getFecha1().getTime());
//								 	rl.setFecha2(n7.getFecha2().getTime());
//								 	rl.setMotivo_retiro(n7.getMotivo_retiro());
//								 	rl.setSalario_final(n7.getSalario_final());
//								 	rl.setActitudes_cualidades(n7.getActitudes_cualidades());
//								 	rl.setRecomiendo(n7.getRecomiendo());
//								 	nuevo.getReferencia_laboral().add(rl);
//							    }
//					    	}
//					    	nuevo.setSalario_base(p.getSalario_base());
//					    	nuevo.setSegundo_apellido(p.getSegundo_apellido());
//					    	nuevo.setSegundo_nombre(p.getSegundo_nombre());
//					    	nuevo.setSexo(p.getSexo());
//					    	nuevo.setTelefono(p.getTelefono());
//					    	
//					    	List<SegTest> results8 = p.getTest();
//					    	if (!results8.isEmpty()) {
//							    for (SegTest n8 : results8) {
//
//							    	AuxTest t= new AuxTest();
//							    	t.setId_test(n8.getId_test());
//							    	t.setPregunta1(n8.getPregunta1());
//								 	t.setPregunt2(n8.getPregunt2());
//								 	t.setPregunta3(n8.getPregunta3());
//								 	t.setPregunta4(n8.getPregunta4());
//								 	t.setPregunta5(n8.getPregunta5());
//								 	t.setPregunta6(n8.getPregunta6());
//								 	t.setPregunta7(n8.getPregunta7());
//								 	t.setPregunta8(n8.getPregunta8());
//								 	t.setPregunta9(n8.getPregunta9());
//								 	t.setPregunta10(n8.getPregunta10());
//								 	t.setFecha_test(n8.getFecha_test().getTime());
//								 	t.setEvaluador(n8.getEvaluador());
//								 	t.setBDtest(n8.getBDtest());
//								 	t.setTestBD(n8.isTestBD());
//								 	t.setTipo_test(n8.getTipo_test());
//								 	nuevo.getTest().add(t);
//							    }
//					    	}
//					    	nuevo.setTipo_licencia(p.getTipo_licencia());
//					    	nuevo.setTipo_pasaporte(p.getTipo_pasaporte());
//					    	nuevo.setTipo_planilla(p.getTipo_planilla());
//					    	nuevo.setTotal(p.getTotal());
//					    	
//					    	List<SegVacaciones> results9 = p.getVacaciones();
//					    	if (!results9.isEmpty()) {
//							    for (SegVacaciones n9 : results9) {
//
//							    	AuxVacaciones v= new AuxVacaciones();
//							    	v.setId_vacaciones(n9.getId_vacaciones());
//							    	v.setFecha1(n9.getFecha1().getTime());
//								 	v.setFecha2(n9.getFecha2().getTime());
//								 	v.setDescripcion(n9.getDescripcion());
//								 	nuevo.getVacaciones().add(v);
//							    }
//					    	}
//
//					    	List<SegSalario> results10 = p.getSalario();
//					    	if (!results10.isEmpty()) {
//							    for (SegSalario n10 : results10) {
//							    	AuxSalario s = new AuxSalario();
//							    	s.setFecha(n10.getFecha().getTime());
//							    	s.setSalario(n10.getSalario());
//		    						s.setTipoSalario(n10.getTipoSalario());
//							    	nuevo.getSalario().add(s);
//							    }
//					    	}
//				    		valor.add(nuevo);
//					    }
//				    		
//				    	}
//				    }
				  
				
				return valor;
			}

			@Override
			public AuxEmpleado Empleado_Registrado(Long id_empleado)
					throws IllegalArgumentException {
				
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				AuxEmpleado nuevo = new AuxEmpleado();
				 try { 
					 final SegEmpleado p = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
					 	nuevo.setAfiliacion_igss(p.getAfiliacion_igss());
				    	nuevo.setApellido_casada(p.getApellido_casada());
				    	nuevo.setBonificacion(p.getBonificacion());
				    	nuevo.setCelular(p.getCelular());
				    	nuevo.setCentro_trabajo(p.getCentro_trabajo());
				    	nuevo.setCodigo_ingreso(p.getCodigo_ingreso());
				    	nuevo.setIVS(p.getIVS());
				    	nuevo.setCui(p.getCui());
				    	nuevo.setDepto_municipio_residencia(p.getDepto_municipio_residencia());
				    	nuevo.setDireccion_actual(p.getDireccion_actual());
				    	nuevo.setEmail(p.getEmail());
				    	nuevo.setURLFile(p.getURLFile());
				    	nuevo.setKeyFile(p.getKeyFile());
				    	nuevo.setEstado(p.getEstado());
				    	nuevo.setPasaporte(p.getPasaporte());
				    	nuevo.setLicencia(p.getLicencia());
				    	List<SegEntrevista> results0 = p.getEntrevista();
				    	if (!results0.isEmpty()) {
						    for (SegEntrevista n0 : results0) {
						    	AuxEntrevista l = new AuxEntrevista();
						    	l.setId_entrevista(n0.getId_entrevista().getId());
						    	l.setFecha_entrevista(n0.getFecha_entrevista().getTime());
							 	l.setQue_conoces(n0.getQue_conoces());
							 	l.setPor_que_trabajas_aqui(n0.getPor_que_trabajas_aqui());
							 	l.setComo_se_describe(n0.getComo_se_describe());
							 	l.setTrabajar_por_presion(n0.getTrabajar_por_presion());
							 	l.setMetas(n0.getMetas());
							 	l.setDisponibilidad_inmediata(n0.getDisponibilidad_inmediata());
							 	l.setDisposicion_a_viajar(n0.getDisposicion_a_viajar());
							 	l.setFlexibilidad_horario(n0.getFlexibilidad_horario());
							 	l.setPretencion_salarial_minimo(n0.getPretencion_salarial_minimo());
							 	l.setAntecedentes_penales(n0.getAntecedentes_penales());
							 	l.setAntecedentes_policiacos(n0.getAntecedentes_policiacos());
							 	l.setCarta_recomendacion_laboral(n0.getCarta_recomendacion_laboral());
							 	l.setCarta_recomendacion_personal(n0.getCarta_recomendacion_personal());
							 	l.setVive_con_familia(n0.getVive_con_familia());
							 	l.setCasa_propia(n0.getCasa_propia());
							 	l.setEntrevisto(n0.getEntrevisto());
							 	l.setEnfermedades(n0.getEnfermedades());
							 	l.setAporte_casa(n0.getAporte_casa());
							 	l.setTiene_deudas(n0.getTiene_deudas());
							 	l.setNo_dependientes(n0.getNo_dependientes());
							 	l.setEmpresa_credito(n0.getEmpresa_credito());
							 	l.setAlquila(n0.getAlquila());
							 	l.setOtros_Ingresos(n0.getOtros_Ingresos());
							 	l.setAmortizacion(n0.getAmortizacion());
							 	nuevo.getEntrevista().add(l);
						    }
				    	}
				    	nuevo.setEstado_civil(p.getEstado_civil());
				    	
				    	List<SegFamilia> results = p.getFamilia();
				    	if (!results.isEmpty()) {
						    for (SegFamilia n : results) {
						    	AuxFamilia f = new AuxFamilia();
						    	f.setId_familia(n.getId_familia());
							 	f.setPrimer_nombre(n.getPrimer_nombre());
							 	f.setSegundo_nombre(n.getSegundo_nombre());
							 	f.setPrimer_apellido(n.getPrimer_apellido());
							 	f.setSegundo_apellido(n.getSegundo_apellido());
							 	f.setEdad(n.getEdad());
							 	f.setOcupacion(n.getOcupacion());
							 	f.setParentesco(n.getParentesco());
							 	nuevo.getFamilia().add(f);
						    }
				    	}
						    
				    	nuevo.setFecha_ingreso(p.getFecha_ingreso().getTime());
				    	nuevo.setFecha_nacimiento(p.getFecha_nacimiento().getTime());
				    	
				    	List< SegHistorialAcademico> results2 = p.getHistorial_academico();
				    	if (!results2.isEmpty()) {
						    for ( SegHistorialAcademico n2 : results2) {

						    	AuxHistorialAcademico a = new AuxHistorialAcademico();
						    	a.setId_historial_academico(n2.getId_historial_academico());
						    	a.setEstablecimiento(n2.getEstablecimiento());
							 	a.setFecha1(n2.getFecha1().getTime());
							 	a.setFecha2(n2.getFecha2().getTime());
							 	a.setNivel_academico(n2.getNivel_academico());
							 	a.setTitulo(n2.getTitulo());
						    	a.setURLFile(n2.getURLFile());
						    	a.setKeyFile(n2.getKeyFile());
							 	nuevo.getHistorial_academico().add(a);
						    }
				    	}
				    	
				    	List< SegHistorial> results3 = p.getHistorial();
				    	if (!results3.isEmpty()) {
						    for ( SegHistorial n3 : results3) {

						    	AuxHistorial h = new AuxHistorial();
						    	h.setId_historial(n3.getId_historial());
						    	h.setFecha(n3.getFecha().getTime());
							 	h.setDescripcion(n3.getDescripcion());
							 	h.setTipo_historial(n3.getTipo_historial());
							 	nuevo.getHistorial().add(h);
						    }
				    	}
				    	nuevo.setId_empleado(p.getId_empleado());
				    	
				    	List<SegIdioma> results4 = p.getIdiomas();
				    	if (!results4.isEmpty()) {
						    for (SegIdioma n4 : results4) {

						    	AuxIdioma i = new AuxIdioma();
						    	i.setId_idioma(n4.getId_idioma());
							 	i.setNivel(n4.getNivel());
							 	i.setIdioma(n4.getIdioma());
						    	i.setURLFile(n4.getURLFile());
						    	i.setKeyFile(n4.getKeyFile());
							 	nuevo.getIdiomas().add(i);
						    }
				    	}
				    	nuevo.setNit(p.getNit());
				    	nuevo.setNo_Dependientes(p.getNo_Dependientes());
				    	nuevo.setNo_licencia(p.getNo_licencia());
				        nuevo.setTipoCuenta(p.getTipoCuenta());
				        nuevo.setNombreBanco(p.getNombreBanco());
				    	nuevo.setNo_pasaporte(p.getNo_pasaporte());
				    	nuevo.setNo_pasaporte(p.getNo_pasaporte());
				    	nuevo.setOcupacion(p.getOcupacion());
				    	nuevo.setPais(p.getPais());
				    	nuevo.setPrimer_apellido(p.getPrimer_apellido());
				    	nuevo.setPrimer_nombre(p.getPrimer_nombre());
				    	nuevo.setProfesion(p.getProfesion());
				    	
				    	List<SegPuesto> results5 = p.getPuestos();
				    	if (!results5.isEmpty()) {
						    for (SegPuesto n5 : results5) {

						    	AuxPuesto pp = new AuxPuesto();
						    	pp.setId_puesto(n5.getId_puesto());
						    	pp.setFecha_puesto(n5.getFecha_puesto().getTime());
							 	pp.setNombre_puesto(n5.getNombre_puesto());
							 	pp.setFunciones(n5.getFunciones());
							 	pp.setSalario(n5.getSalario());
							 	pp.setActivo(n5.getActivo());
							 	nuevo.getPuestos().add(pp);
						    }
				    	}
				    	
				    	List<SegReferenciaPersonal> results6 = p.getReferencia_personal();
				    	if (!results6.isEmpty()) {
						    for (SegReferenciaPersonal n6 : results6) {

						    	AuxReferenciaPersonal rp = new AuxReferenciaPersonal();
						    	rp.setId_referencia_personal(n6.getId_referencia_personal());
						    	rp.setNombre_referencia(n6.getNombre_referencia());
							 	rp.setTelefono(n6.getTelefono());
							 	rp.setPuesto_candidato(n6.getPuesto_candidato());
							 	rp.setRelacion(n6.getRelacion());
							 	rp.setActitudes_cualidades(n6.getActitudes_cualidades());
							 	nuevo.getReferencia_personal().add(rp);
						    }
				    	}
				    	
				    	List<SegReferenciaLaboral> results7 = p.getReferencia_laboral();
				    	if (!results7.isEmpty()) {
						    for (SegReferenciaLaboral n7 : results7) {

						    	AuxReferenciaLaboral rl = new AuxReferenciaLaboral();
						    	rl.setId_referencia_laboral(n7.getId_referencia_laboral());
						    	rl.setNombre_referencia(n7.getNombre_referencia());
							 	rl.setTelefono(n7.getTelefono());
							 	rl.setPuesto_candidato(n7.getPuesto_candidato());
							 	rl.setEmpresa_referencia(n7.getEmpresa_referencia());
							 	rl.setFecha1(n7.getFecha1().getTime());
							 	rl.setFecha2(n7.getFecha2().getTime());
							 	rl.setMotivo_retiro(n7.getMotivo_retiro());
							 	rl.setSalario_final(n7.getSalario_final());
							 	rl.setActitudes_cualidades(n7.getActitudes_cualidades());
							 	rl.setRecomiendo(n7.getRecomiendo());
							 	nuevo.getReferencia_laboral().add(rl);
						    }
				    	}
				    	nuevo.setSalario_base(p.getSalario_base());
				    	nuevo.setSegundo_apellido(p.getSegundo_apellido());
				    	nuevo.setSegundo_nombre(p.getSegundo_nombre());
				    	nuevo.setSexo(p.getSexo());
				    	nuevo.setTelefono(p.getTelefono());
				    	
				    	List<SegTest> results8 = p.getTest();
				    	if (!results8.isEmpty()) {
						    for (SegTest n8 : results8) {

						    	AuxTest t= new AuxTest();
						    	t.setId_test(n8.getId_test());
						    	t.setPregunta1(n8.getPregunta1());
							 	t.setPregunt2(n8.getPregunt2());
							 	t.setPregunta3(n8.getPregunta3());
							 	t.setPregunta4(n8.getPregunta4());
							 	t.setPregunta5(n8.getPregunta5());
							 	t.setPregunta6(n8.getPregunta6());
							 	t.setPregunta7(n8.getPregunta7());
							 	t.setPregunta8(n8.getPregunta8());
							 	t.setPregunta9(n8.getPregunta9());
							 	t.setPregunta10(n8.getPregunta10());
							 	t.setFecha_test(n8.getFecha_test().getTime());
							 	t.setEvaluador(n8.getEvaluador());
							 	t.setBDtest(n8.getBDtest());
							 	t.setTestBD(n8.isTestBD());
							 	t.setTipo_test(n8.getTipo_test());
							 	nuevo.getTest().add(t);
						    }
				    	}
				    	nuevo.setTipo_licencia(p.getTipo_licencia());
				    	nuevo.setTipo_pasaporte(p.getTipo_pasaporte());
				    	nuevo.setTipo_planilla(p.getTipo_planilla());
				    	nuevo.setTotal(p.getTotal());
				    	
				    	List<SegVacaciones> results9 = p.getVacaciones();
				    	if (!results9.isEmpty()) {
						    for (SegVacaciones n9 : results9) {

						    	AuxVacaciones v= new AuxVacaciones();
						    	v.setId_vacaciones(n9.getId_vacaciones());
						    	v.setFecha1(n9.getFecha1().getTime());
							 	v.setFecha2(n9.getFecha2().getTime());
							 	v.setDescripcion(n9.getDescripcion());
							 	nuevo.getVacaciones().add(v);
						    }
				    	}

				    	List<SegSalario> results10 = p.getSalario();
				    	if (!results10.isEmpty()) {
						    for (SegSalario n10 : results10) {
						    	AuxSalario s = new AuxSalario();
						    	s.setFecha(n10.getFecha().getTime());
						    	s.setSalario(n10.getSalario());
						    	s.setTipoSalario(n10.getTipoSalario());
						    	nuevo.getSalario().add(s);
						    }
				    	}
			 }finally {  
				 Persistencia.close();  
			 }

			return nuevo;
			}

			@Override
			public String remove(String key)throws IllegalArgumentException {
				
			    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
			    BlobKey blobKey = new BlobKey(key);
			    blobstoreService.delete(blobKey);
				return "eliminado";
			}

			@Override
			public Long Insertar_BDPuesto(Date fecha_puesto,
					String nombre_puesto, String funciones)
					throws IllegalArgumentException {
				final PersistenceManager gestorPersistencia = PMF.get().getPersistenceManager() ;
				Long valor = 0L;
				 try { 
					 SegBDPuesto p = new SegBDPuesto();
					 	p.setFecha_puesto(fecha_puesto);
					 	p.setNombre_puesto(nombre_puesto.toUpperCase());
					 	p.setFunciones(funciones.toUpperCase());
			         gestorPersistencia.makePersistent(p); 
			         valor = p.getId_puesto();
			     }finally {  
					 gestorPersistencia.close();  
				 }
				return valor;
			}

			@Override
			public Long Actualizar_BDPuesto(Long id, Date fecha_puesto,
					String nombre_puesto, String funciones)
					throws IllegalArgumentException {
				
				final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				Long valor = 0L;
				 try { 
					 final SegBDPuesto p = Persistencia.getObjectById(SegBDPuesto.class, id); 
					 	p.setFecha_puesto(fecha_puesto);
					 	p.setNombre_puesto(nombre_puesto.toUpperCase());
					 	p.setFunciones(funciones.toUpperCase());
			         valor = p.getId_puesto();
			     }finally {  
					Persistencia.close();  
				 }
				return valor;
			}

			@SuppressWarnings("unchecked")
			@Override
			public List<AuxBDPuesto> BDPuesto() throws IllegalArgumentException {
				final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
				List<AuxBDPuesto> valor = new ArrayList<AuxBDPuesto>();
				
				Query q = pm.newQuery(SegBDPuesto.class);
				List<SegBDPuesto> results = (List<SegBDPuesto>) q.execute();
				if (!results.isEmpty()) {
              
				    for (SegBDPuesto n5 : results) {
						AuxBDPuesto pp = new AuxBDPuesto();
				    	pp.setId_puesto(n5.getId_puesto());
				    	pp.setFecha_puesto(n5.getFecha_puesto().getTime());
					 	pp.setNombre_puesto(n5.getNombre_puesto());
					 	pp.setFunciones(n5.getFunciones());
					 	valor.add(pp);
				    }
				}
				return valor;
			}

			
		  private String md5(String cadena){

	            try {
	                MessageDigest md = MessageDigest.getInstance("MD5");
	                byte[] messageDigest = md.digest(cadena.getBytes());
	                BigInteger number = new BigInteger(1, messageDigest);
	                String hashtext = number.toString(16);
	                // Now we need to zero pad it if you actually want the full 32 chars.
	                while (hashtext.length() < 32) {
	                    hashtext = "0" + hashtext;
	                }
	                return hashtext;
	            }
	            catch (NoSuchAlgorithmException e) {
	                throw new RuntimeException(e);
	            }
	        }

		@Override
		public Long Insertar_BDTest(String nombreTest,String pregunta1, String pregunt2,
				String pregunta3, String pregunta4, String pregunta5,
				String pregunta6, String pregunta7, String pregunta8,
				String pregunta9, String pregunta10, Date fecha_test,
				String tipo_test) throws IllegalArgumentException {
			
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			
			Long valor = 0L;
				 try { 
					 SegBDTest t = new  SegBDTest();
					 	t.setNombreTest(nombreTest);
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
					 	t.setTipo_test(tipo_test);
					 	Persistencia.makePersistent(t); 
					 	valor =t.getId_test();
					 }finally {  
						 Persistencia.close();  
					 }
				return valor ;
		}

		@Override
		public Long Actualizar_BDTest(Long id, String nombreTest,String pregunta1,
				String pregunt2, String pregunta3, String pregunta4,
				String pregunta5, String pregunta6, String pregunta7,
				String pregunta8, String pregunta9, String pregunta10,
				Date fecha_test, String tipo_test)
				throws IllegalArgumentException {
			
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			
			Long valor = 0L;
				 try { 
					 System.out.println("__________"+ id);
					 final SegBDTest t = Persistencia.getObjectById(SegBDTest.class, id); 
					 	t.setNombreTest(nombreTest);
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
					 	valor =t.getId_test();
					 }finally {  
						 Persistencia.close();  
					 }
				return valor ;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<AuxBDTest> BDTest() throws IllegalArgumentException {
			final PersistenceManager pm = PMF.get().getPersistenceManager() ; 
			List<AuxBDTest> valor = new ArrayList<AuxBDTest>();
			
			Query q = pm.newQuery(SegBDTest.class);
			List<SegBDTest> results = (List<SegBDTest>) q.execute();
			if (!results.isEmpty()) {
          
			    for (SegBDTest p : results) {
			    	AuxBDTest t = new AuxBDTest();
			    	t.setId_test(p.getId_test());
			    	t.setNombreTest(p.getNombreTest());
				 	t.setPregunta1(p.getPregunta1());
				 	t.setPregunt2(p.getPregunt2());
				 	t.setPregunta3(p.getPregunta3());
				 	t.setPregunta4(p.getPregunta4());
				 	t.setPregunta5(p.getPregunta5());
				 	t.setPregunta6(p.getPregunta6());
				 	t.setPregunta7(p.getPregunta7());
				 	t.setPregunta8(p.getPregunta8());
				 	t.setPregunta9(p.getPregunta9());
				 	t.setPregunta10(p.getPregunta10());
				 	t.setTipo_test(p.getTipo_test());
				 	t.setFecha_test(p.getFecha_test().getTime());
				 	valor.add(t);
			    }
			}
			return valor;
		}

		@Override
		public String InsertarCompartido(String idEmpleado, Long idTest, Long idEmpleadoCompartido)
				throws IllegalArgumentException 
		{
			
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			String valor = "Hubo un error al compartir evaluacion";
			SegUsuario results = null;
			try{
				 results = Persistencia.getObjectById(SegUsuario.class, idEmpleado); 
			}catch(Exception t){
				return idEmpleado+" \nno existe";
			}
			 
				 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, results.getId_empleado()); 
				 
				 int i = e.getTestCompartido().indexOf(idTest);
				 if(i != -1){
					 valor = "la Evaluacion ya habia sido compartido con\n"+idEmpleado;
				 }else
				 {
					 SegTestCompartidos valores = new SegTestCompartidos();
					 valores.setIdTest(idTest);
					 valores.setId_empleado(idEmpleadoCompartido);
					 valores.setEmpleado(e);
					 e.getTestCompartido().add(valores);
					 valor = "Test compartido Exitosamente con\n con "+idEmpleado;
				 
				 }
					 Persistencia.close();  
			
			 return valor ;
		}

		@Override
		public String QuitarCompartido(Long idEmpleado, Long idTest)
				throws IllegalArgumentException {

			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			String valor = "Hubo un error \nal Quitar evaluacion compartida";
			
			 try { 
				 
				 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, idEmpleado); 
				 int i = e.getTestCompartido().indexOf(idTest);
				 if(i != -1)
				 { 
					 e.getTestCompartido().remove(i);
					 valor = "la Evaluacion ha dejado \nde compartise con"+e.getEmail();
				 }
				 
			}finally {  
					 Persistencia.close();  
			}
			 return valor ;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<String> getCorreos() throws IllegalArgumentException 
		{
			
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			List<SegUsuario> results = null;
			List<String> correos = new ArrayList<String>();
			 try { 

					Query q = Persistencia.newQuery(SegUsuario.class);
					results = (List<SegUsuario>) q.execute();
					for(SegUsuario seg: results){
						correos.add(seg.getUser());
					}
			}finally {  
					 Persistencia.close();  
			}
			 return correos ;
		}

		@Override
		public Long Insertar_Salario(Long id_empleado, Date Fecha, float salario,String tipoSalario)
				throws IllegalArgumentException {
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			
			Long valor = 0L;
				 try { 
					 final SegEmpleado e = Persistencia.getObjectById(SegEmpleado.class, id_empleado); 
					 SegSalario s = new  SegSalario();
					 	s.setFecha(Fecha);
					 	s.setSalario(salario);
					 	s.setTipoSalario(tipoSalario);
			      	 	s.setEmpleado(e);
			      	 	e.getSalario().add(s);
					 	valor = s.getId_Salario();
				 }finally {  
					 Persistencia.close();  
				 }
			return valor;
		}

		@Override
		public Long Actualizar_Salario(Long id_empleado, Long id, Date Fecha,
				float salario,String tipoSalario) throws IllegalArgumentException {
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			
			Long valor = 0L;
				 try { 
					 Key k = new KeyFactory
						        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
						        .addChild(SegSalario.class.getSimpleName(), id)
						        .getKey();
					 SegSalario s = Persistencia.getObjectById(SegSalario.class, k); 
					 	s.setFecha(Fecha);
					 	s.setSalario(salario);
					 	s.setTipoSalario(tipoSalario);
					 	valor = s.getId_Salario();
					 }finally {  
						 Persistencia.close();  
					 }
				return valor ;
		}

		@Override
		public Long Eliminar_Salario(Long id_empleado, Long id)
				throws IllegalArgumentException {
        	final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ; 
			 Key k = new KeyFactory
				        .Builder(SegEmpleado.class.getSimpleName(), id_empleado)
				        .addChild(SegSalario.class.getSimpleName(), id)
				        .getKey();
			 SegSalario s = Persistencia.getObjectById(SegSalario.class, k);
            Persistencia.deletePersistent(s);
            return id ;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<AuxSalario> getSalarios() throws IllegalArgumentException {
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			List<SegSalario> results = null;
			List<AuxSalario> salarios = new ArrayList<AuxSalario>();
			 try { 

					Query q = Persistencia.newQuery(SegSalario.class);
					results = (List<SegSalario>) q.execute();
					for(SegSalario seg: results){
						AuxSalario s = new AuxSalario();
						s.setFecha(seg.getFecha().getTime());
						s.setSalario(seg.getSalario());
						s.setTipoSalario(seg.getTipoSalario());
						salarios.add(s);
					}
			}finally {  
					 Persistencia.close();  
			}
			 return salarios ;
		}

		@Override
		public List<AuxTestCompartidos> getEvaluacionesCompartidas(Long id)
				throws IllegalArgumentException {
			final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
			List<AuxTestCompartidos> res = new ArrayList<AuxTestCompartidos>();
			 try { 
					final SegEmpleado r = Persistencia.getObjectById(SegEmpleado.class,id);
					
					for(SegTestCompartidos seg: r.getTestCompartido()){
						AuxTestCompartidos nuevo = new AuxTestCompartidos();
						nuevo.setId(seg.getId_empleado().longValue());
						nuevo.setId_empleado(seg.getId_empleado());
						nuevo.setIdTest(seg.getIdTest());
						res.add(nuevo);
					}
			}finally {  
					 Persistencia.close();  
			}
			 return res ;
		}

		@Override
		public AuxTest getTest(Long idTest, Long id)
				throws IllegalArgumentException {final PersistenceManager Persistencia = PMF.get().getPersistenceManager() ;
				
				 AuxTest t = new AuxTest();
					 try { 
						 Key k = new KeyFactory
							        .Builder(SegEmpleado.class.getSimpleName(), id)
							        .addChild(SegTest.class.getSimpleName(), idTest)
							        .getKey();
						 final SegTest nuevo = Persistencia.getObjectById(SegTest.class, k); 
						 	t.setId_test(nuevo.getId_test());
						 	t.setPregunta1(nuevo.getPregunta1());
						 	t.setPregunt2(nuevo.getPregunt2());
						 	t.setPregunta3(nuevo.getPregunta3());
						 	t.setPregunta4(nuevo.getPregunta4());
						 	t.setPregunta5(nuevo.getPregunta5());
						 	t.setPregunta6(nuevo.getPregunta6());
						 	t.setPregunta7(nuevo.getPregunta7());
						 	t.setPregunta8(nuevo.getPregunta8());
						 	t.setPregunta9(nuevo.getPregunta9());
						 	t.setPregunta10(nuevo.getPregunta10());
						 	t.setFecha_test(nuevo.getFecha_test().getTime());
						 	t.setTipo_test(nuevo.getTipo_test());
						 	t.setBDtest(nuevo.getBDtest());
						 	t.setEvaluador(nuevo.getEvaluador().toUpperCase());
						 }finally {  
							 Persistencia.close();  
						 }
					return t ;
		}

	}