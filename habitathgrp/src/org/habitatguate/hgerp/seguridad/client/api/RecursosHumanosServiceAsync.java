/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudPermiso;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPermiso;
import org.habitatguate.hgerp.seguridad.client.rrhh.ValoresSesion;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 * @author arodriguez
 *
 */
public interface RecursosHumanosServiceAsync {
	
	//metodos para insertar una tupla en la entidad especifica..................................................................................................
	/**
	 * 
	 * @param user
	 * @param pass
	 * @param Nombre
	 * @param Apellido
	 * @param fecha_nacimiento
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Registro(String user,String pass,String Nombre, String Apellido, Date fecha_nacimiento, 
			String Nombre2, String Apellido2,
			AsyncCallback<String> callback) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param user
	 * @param pass
	 * @param Nombre
	 * @param Apellido
	 * @param fecha_nacimiento
	 * @param Nombre2
	 * @param Apellido2
	 * @param DPI
	 * @param Pais
	 * @param NIT
	 * @param IGGS
	 * @param Sexo
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void RegistroMasivo(String user,String pass,String Nombre, String Apellido, Date fecha_nacimiento, 
			String Nombre2, String Apellido2,String DPI, String Pais, String NIT, String IGGS, String Sexo, 
			String EstadoCivil,
			AsyncCallback<Boolean> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param user
	 * @param i2
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void login_inicio(String user,String i2, AsyncCallback<ValoresSesion> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param idUsuario
	 * @param nuevaContrasena
	 * @param actualContrasena
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void CambiarContrasena(String idUsuario,String nuevaContrasena, String actualContrasena, AsyncCallback<String> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param idUsuario
	 * @param nuevaContrasena
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void CambiarContrasenaAdmin(String idUsuario,String nuevaContrasena, AsyncCallback<String> callback) throws IllegalArgumentException;
	

	/**
	 * 
	 * @param idUsuario
	 * @param rol
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void CambiarRol(String idUsuario, Long rol, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param afiliacion_igss
	 * @param estado_civil
	 * @param sexo
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param apellido_casada
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param IVS
	 * @param pais
	 * @param nit
	 * @param No_Dependientes
	 * @param noCuenta
	 * @param tipoCuenta
	 * @param nombreBanco
	 * @param cui
	 * @param tipo_pasaporte
	 * @param no_pasaporte
	 * @param direccion_actual
	 * @param depto_municipio_residencia
	 * @param email
	 * @param telefono
	 * @param celular
	 * @param fecha_nacimiento
	 * @param tipo_licencia
	 * @param no_licencia
	 * @param centro_trabajo
	 * @param ocupacion
	 * @param fecha_ingreso
	 * @param codigo_ingreso
	 * @param profesion
	 * @param tipo_planilla
	 * @param salario_base
	 * @param total
	 * @param bonificacion
	 * @param URLFile
	 * @param KeyFile
	 * @param Estado
	 * @param pasaporte
	 * @param licencia
	 * @param Etnia
	 * @param NombreEmergencia
	 * @param TelefonoEmergencia
	 * @param NombreEmergencia2
	 * @param TelefonoEmergencia2
	 * @param depto_municipio_nacimiento
	 * @param Jefe_Inmediato
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Emppleado(String afiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String IVS,
            String pais,String nit, String No_Dependientes,String noCuenta, String tipoCuenta, 
            String nombreBanco,String cui, String tipo_pasaporte, String no_pasaporte, String direccion_actual,
            String depto_municipio_residencia, String email, String telefono,
            String celular, Date fecha_nacimiento, String tipo_licencia,
            String no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,String  URLFile, String KeyFile,String Estado,
            String pasaporte, String licencia,String Etnia,
            String NombreEmergencia, String TelefonoEmergencia,
            String NombreEmergencia2, String TelefonoEmergencia2,
            String depto_municipio_nacimiento, Long Jefe_Inmediato, Long afiliado,
            AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param edad
	 * @param ocupacion
	 * @param parentesco
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Familiar(Long id_empleado,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,String parentesco, 
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha1
	 * @param fecha2
	 * @param nivel_academico
	 * @param establecimiento
	 * @param titulo
	 * @param URLFile
	 * @param KeyFile
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Academico(Long id_empleado, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo, 
			String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param nombre_referencia
	 * @param telefono
	 * @param puesto_candidato
	 * @param empresa_referencia
	 * @param fecha1
	 * @param fecha2
	 * @param motivo_retiro
	 * @param salario_final
	 * @param actitudes_cualidades
	 * @param recomiendo
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Referencia_Laboral(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato,String empresa_referencia, Date fecha1, 
			Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
			String recomiendo, AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param nombre_referencia
	 * @param telefono
	 * @param puesto_candidato
	 * @param relacion
	 * @param actitudes_cualidades
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Referencia_Personal(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato, String relacion, String actitudes_cualidades, Date fecha1, 
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param nivel
	 * @param idioma
	 * @param URLFile
	 * @param KeyFile
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Idioma(Long id_empleado, String nivel, String idioma, 
			String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param pregunta1
	 * @param pregunt2
	 * @param pregunta3
	 * @param pregunta4
	 * @param pregunta5
	 * @param pregunta6
	 * @param pregunta7
	 * @param pregunta8
	 * @param pregunta9
	 * @param pregunta10
	 * @param fecha_test
	 * @param evaluador
	 * @param BDtest
	 * @param testBD
	 * @param tipo_test
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Test(Long id_empleado,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
			int pregunta5, int pregunta6, int pregunta7, int pregunta8,
			int pregunta9, int pregunta10, Date fecha_test, String evaluador,Long BDtest, boolean testBD,
			String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha
	 * @param salario
	 * @param tipoSalario
	 * @param Descripcion
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Salario(Long id_empleado, Date fecha, float salario, 
			String tipoSalario, String Descripcion, AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param idEmpleado
	 * @param idTest
	 * @param idEmpleadoCompartido
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void InsertarCompartido(String idEmpleado,Long idTest, 
			Long idEmpleadoCompartido, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param nombreTest
	 * @param pregunta1
	 * @param pregunt2
	 * @param pregunta3
	 * @param pregunta4
	 * @param pregunta5
	 * @param pregunta6
	 * @param pregunta7
	 * @param pregunta8
	 * @param pregunta9
	 * @param pregunta10
	 * @param fecha_test
	 * @param tipo_test
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_BDTest(String nombreTest,String pregunta1, String pregunt2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8,
			String pregunta9, String pregunta10, Date fecha_test,
			String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha_puesto
	 * @param nombre_puesto
	 * @param funciones
	 * @param motivoPuesto
	 * @param activo
	 * @param jornada
	 * @param horasTrabajo
	 * @param Lunes
	 * @param Martes
	 * @param Miercoles
	 * @param Jueves
	 * @param Viernres
	 * @param Sabado
	 * @param Domingo
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Puesto(Long id_empleado,Date fecha_puesto, String nombre_puesto, String funciones,
			String motivoPuesto, boolean activo,  String jornada, String horasTrabajo, 
			String Lunes, String Martes, String Miercoles, String Jueves, 
			String Viernres, String Sabado, String Domingo, AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id
	 * @param fecha_puesto
	 * @param nombre_puesto
	 * @param funciones
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_BDPuesto(Long id, Date fecha_puesto, String nombre_puesto, String funciones,
			 	AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha_entrevista
	 * @param que_conoces
	 * @param por_que_trabajas_aqui
	 * @param como_se_describe
	 * @param trabajar_por_presion
	 * @param metas
	 * @param disponibilidad_inmediata
	 * @param disposicion_a_viajar
	 * @param flexibilidad_horario
	 * @param pretencion_salarial_minimo
	 * @param antecedentes_penales
	 * @param antecedentes_policiacos
	 * @param carta_recomendacion_laboral
	 * @param carta_recomendacion_personal
	 * @param vive_con_familia
	 * @param casa_propia
	 * @param entrevisto
	 * @param enfermedades
	 * @param aporte_casa
	 * @param tiene_deudas
	 * @param no_dependientes
	 * @param empresa_credito
	 * @param alquila
	 * @param pago_alquiler
	 * @param Otros_Ingresos
	 * @param amortizacion
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Entrevista(Long id_empleado,Date fecha_entrevista, String que_conoces,
			String por_que_trabajas_aqui, String como_se_describe,
			String trabajar_por_presion, String metas,
			boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
			boolean flexibilidad_horario, float pretencion_salarial_minimo,
			boolean antecedentes_penales, boolean antecedentes_policiacos,
			boolean carta_recomendacion_laboral,
			boolean carta_recomendacion_personal, boolean vive_con_familia,
			boolean casa_propia, String entrevisto, String enfermedades,
			float aporte_casa, boolean tiene_deudas, int no_dependientes,
			String empresa_credito, boolean alquila,float pago_alquiler,String Otros_Ingresos, 
			float amortizacion,AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha
	 * @param descripcion
	 * @param tipo_historial
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Historial(Long id_empleado,Date fecha, String descripcion, 
			String tipo_historial, AsyncCallback<Long> callback) throws IllegalArgumentException;
	/**
	 * 
	 * @param id_empleado
	 * @param fecha1
	 * @param fecha2
	 * @param descripcionl
	 * @param tipoPermisos
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Vacaciones(Long id_empleado,Date fecha1, Date fecha2, String descripcionl, 
			String tipoPermisos,AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param id_empleado
	 * @param fecha1
	 * @param fecha2
	 * @param descripcionl
	 * @param tipoPermisos
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Solicitud_Permiso(Long id_empleado,Date fecha1, Date fecha2, String descripcionl, 
			String tipoPermisos,AsyncCallback<String> callback) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param dia
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Insertar_Dias_Vacaciones(float dia,AsyncCallback<String> callback) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param id_solicitud
	 * @param id_empleado
	 * @param id_Solicitante
	 * @param fecha1
	 * @param fecha2
	 * @param descripcionl
	 * @param tipoPermisos
	 * @param jefe
	 * @param rrhh
	 * @param callback
	 * @throws IllegalArgumentException
	 */
	void Respuesta_Solicitud(Long id_solicitud,Long id_empleado,Long id_Solicitante,Date fecha1, Date fecha2, String descripcionl, 
			String tipoPermisos,String jefe, String rrhh,String solicitante,AsyncCallback<String> callback) throws IllegalArgumentException;
	

	///metodos para actualizar las entidades
	/**
	 * 
	 * @param id
	 * @param Stringafiliacion_igss
	 * @param estado_civil
	 * @param sexo
	 * @param primer_apellido
	 * @param segundo_apellido
	 * @param apellido_casada
	 * @param primer_nombre
	 * @param segundo_nombre
	 * @param IVS
	 * @param pais
	 * @param nit
	 * @param No_Dependientes
	 * @param noCuenta
	 * @param tipoCuenta
	 * @param nombreBanco
	 * @param cui
	 * @param tipo_pasaporte
	 * @param no_pasaporte
	 * @param direccion_actual
	 * @param depto_municipio_residencia
	 * @param email
	 * @param telefono
	 * @param celular
	 * @param fecha_nacimiento
	 * @param tipo_licencia
	 * @param no_licencia
	 * @param centro_trabajo
	 * @param ocupacion
	 * @param fecha_ingreso
	 * @param codigo_ingreso
	 * @param profesion
	 * @param tipo_planilla
	 * @param salario_base
	 * @param total
	 * @param bonificacion
	 * @param URLFile
	 * @param KeyFile
	 * @param Estado
	 * @param pasaporte
	 * @param licencia
	 * @param Etnia
	 * @param NombreEmergencia
	 * @param TelefonoEmergencia
	 * @param NombreEmergencia2
	 * @param TelefonoEmergencia2
	 * @param depto_municipio_nacimiento
	 * @param Jefe_Inmediato
	 * @param callback
	 * @throws IllegalArgumentException
	 */
		void Actualizar_Emppleado(Long id, String Stringafiliacion_igss,
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
	            String pasaporte, String licencia,String Etnia,
	            String NombreEmergencia, String TelefonoEmergencia,
	            String NombreEmergencia2, String TelefonoEmergencia2,
	            String depto_municipio_nacimiento, Long Jefe_Inmediato,Long afiliado,
	            AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param primer_nombre
		 * @param segundo_nombre
		 * @param primer_apellido
		 * @param segundo_apellido
		 * @param edad
		 * @param ocupacion
		 * @param parentesco
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Familiar(Long id_empleado,Long id,String primer_nombre, String segundo_nombre,
				String primer_apellido, String segundo_apellido, int edad, String ocupacion,String parentesco, 
				AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param fecha1
		 * @param fecha2
		 * @param nivel_academico
		 * @param establecimiento
		 * @param titulo
		 * @param URLFile
		 * @param KeyFile
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Academico(Long id_empleado,Long id, Date fecha1, Date fecha2,
				String nivel_academico, String establecimiento, String titulo, 
				String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param nombre_referencia
		 * @param telefono
		 * @param puesto_candidato
		 * @param empresa_referencia
		 * @param fecha1
		 * @param fecha2
		 * @param motivo_retiro
		 * @param salario_final
		 * @param actitudes_cualidades
		 * @param recomiendo
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Referencia_Laboral(Long id_empleado,Long id,String nombre_referencia, String telefono, 
				String puesto_candidato,String empresa_referencia, Date fecha1, 
				Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
				String recomiendo, AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param nombre_referencia
		 * @param telefono
		 * @param puesto_candidato
		 * @param relacion
		 * @param actitudes_cualidades
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Referencia_Personal(Long id_empleado,Long id,String nombre_referencia, String telefono, 
				String puesto_candidato, String relacion, String actitudes_cualidades, Date fecha1, 
				AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param nivel
		 * @param idioma
		 * @param URLFile
		 * @param KeyFile
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Idioma(Long id_empleado,Long id, String nivel, String idioma, 
				String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param pregunta1
		 * @param pregunt2
		 * @param pregunta3
		 * @param pregunta4
		 * @param pregunta5
		 * @param pregunta6
		 * @param pregunta7
		 * @param pregunta8
		 * @param pregunta9
		 * @param pregunta10
		 * @param fecha_test
		 * @param evaluador
		 * @param BDtest
		 * @param testBD
		 * @param tipo_test
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Test(Long id_empleado,Long id,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
				int pregunta5, int pregunta6, int pregunta7, int pregunta8,
				int pregunta9, int pregunta10, Date fecha_test,String evaluador,Long BDtest, boolean testBD,
				String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id
		 * @param nombreTest
		 * @param pregunta1
		 * @param pregunta2
		 * @param pregunta3
		 * @param pregunta4
		 * @param pregunta5
		 * @param pregunta6
		 * @param pregunta7
		 * @param pregunta8
		 * @param pregunta9
		 * @param pregunta10
		 * @param fecha_test
		 * @param tipo_test
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_BDTest(Long id,String nombreTest,String pregunta1, String pregunta2, 
				String pregunta3, String pregunta4, String pregunta5, String pregunta6, 
				String pregunta7, String pregunta8, String pregunta9, String pregunta10, 
				Date fecha_test, String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param fecha_puesto
		 * @param nombre_puesto
		 * @param funciones
		 * @param motivoPuesto
		 * @param activo
		 * @param jornada
		 * @param horasTrabajo
		 * @param Lunes
		 * @param Martes
		 * @param Miercoles
		 * @param Jueves
		 * @param Viernres
		 * @param Sabado
		 * @param Domingo
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Puesto(Long id_empleado,Long id,Date fecha_puesto, String nombre_puesto, String funciones,
				String motivoPuesto, boolean activo, String jornada,  String horasTrabajo,
				String Lunes, String Martes, String Miercoles, String Jueves, String Viernres,
				String Sabado, String Domingo,AsyncCallback<Long> callback) throws IllegalArgumentException;

		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param mensaje
		 * @throws IllegalArgumentException
		 */
	    void Actualizar_Estado_Puesto(Long id_empleado,Long id,AsyncCallback<String> mensaje) throws IllegalArgumentException;
		/**
		 * 
		 * @param id
		 * @param fecha_puesto
		 * @param nombre_puesto
		 * @param funciones
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_BDPuesto(Long id,Date fecha_puesto, String nombre_puesto, String funciones,
				 AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param fecha_entrevista
		 * @param que_conoces
		 * @param por_que_trabajas_aqui
		 * @param como_se_describe
		 * @param trabajar_por_presion
		 * @param metas
		 * @param disponibilidad_inmediata
		 * @param disposicion_a_viajar
		 * @param flexibilidad_horario
		 * @param pretencion_salarial_minimo
		 * @param antecedentes_penales
		 * @param antecedentes_policiacos
		 * @param carta_recomendacion_laboral
		 * @param carta_recomendacion_personal
		 * @param vive_con_familia
		 * @param casa_propia
		 * @param entrevisto
		 * @param enfermedades
		 * @param aporte_casa
		 * @param tiene_deudas
		 * @param no_dependientes
		 * @param empresa_credito
		 * @param alquila
		 * @param pago_alquiler
		 * @param Otros_Ingresos
		 * @param amortizacion
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Entrevista(Long id_empleado,Long id,Date fecha_entrevista, String que_conoces,
				String por_que_trabajas_aqui, String como_se_describe,
				String trabajar_por_presion, String metas,
				boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
				boolean flexibilidad_horario, float pretencion_salarial_minimo,
				boolean antecedentes_penales, boolean antecedentes_policiacos,
				boolean carta_recomendacion_laboral,
				boolean carta_recomendacion_personal, boolean vive_con_familia,
				boolean casa_propia, String entrevisto, String enfermedades,
				float aporte_casa, boolean tiene_deudas, int no_dependientes,
				String empresa_credito, boolean alquila,float pago_alquiler, 
				String Otros_Ingresos,float amortizacion,
				AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param fecha
		 * @param descripcion
		 * @param tipo_historial
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Historial(Long id_empleado,Long id,Date fecha, String descripcion, 
				String tipo_historial, AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param fecha1
		 * @param fecha2
		 * @param descripcionl
		 * @param tipoPermisos
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Vacaciones(Long id_empleado,Long id,Date fecha1, Date fecha2, String descripcionl, 
				String tipoPermisos,AsyncCallback<Long> callback) throws IllegalArgumentException;
		/**
		 * 
		 * @param id_empleado
		 * @param id
		 * @param fecha
		 * @param salario
		 * @param tipoSalario
		 * @param Descripcion
		 * @param callback
		 * @throws IllegalArgumentException
		 */
		void Actualizar_Salario(Long id_empleado,Long id, Date fecha,float salario, 
				String tipoSalario, String Descripcion, AsyncCallback<Long> callback) throws IllegalArgumentException;
		
		//metodos para Eliminar en la base de datos..................................................................................................
	   /**
	    * 
	    * @param id
	    * @param callback
	    * @throws IllegalArgumentException
	    */
		void Eliminar_Emppleado(Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Familiar(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Academico(Long id_empleado,Long id,
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Referencia_Laboral(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Referencia_Personal(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Idioma(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Test(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Puesto(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Entrevista(Long id_empleado,Long id,
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Historial(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Vacaciones(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Eliminar_Salario(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param idEmpleado
	     * @param idTeist
	     * @param callback
	     * @throws IllegalArgumentException
	     */
		void QuitarCompartido(Long idEmpleado,Long idTeist, 
				AsyncCallback<String> callback) throws IllegalArgumentException;
	    
	    ///querys....................................................................................................................................................................................................
	    /**
	     * 
	     * @param tipo
	     * @param primer_nombre
	     * @param segundo_nombre
	     * @param primer_apellido
	     * @param segundo_apellido
	     * @param DPI
	     * @param Pasaporte
	     * @param Estado
	     * @param callback
	     * @throws IllegalArgumentException
	     */
		void Buscar_Empleado(char tipo, String primer_nombre, String segundo_nombre, 
				String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,
				String Estado,AsyncCallback<List<AuxEmpleado>> callback) throws IllegalArgumentException;
	    /**
	     * 
	     * @param id_empleado
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void Empleado_Registrado(Long id_empleado,
	    		AsyncCallback<AuxEmpleado> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void BDSolicitudPermiso(
				AsyncCallback<List<AuxSolicitudPermiso>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param idEmpleadoSolicitante
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void BDSolicitudesEmpleado(Long idEmpleadoSolicitante,
				AsyncCallback<List<AuxSolicitudPermiso>> callback)throws IllegalArgumentException;
	    

	    /**
	     * 
	     * @param idEmpleadoSolicitante
	     * @param Permiso
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getPermiso(Long idEmpleado, Long Permiso,
				AsyncCallback<AuxPermiso> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param idEmpleado
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void BDSolicitudesJefe(Long idEmpleado,
				AsyncCallback<List<AuxSolicitudPermiso>> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void BDPuesto(AsyncCallback<List<AuxBDPuesto>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void NombrePuesto(Long id, AsyncCallback<String> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void BDTest(AsyncCallback<List<AuxBDTest>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getCorreos(AsyncCallback<List<String>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getEvaluacionesCompartidas(Long id,AsyncCallback<List<AuxTestCompartidos>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getEmpleado(Long id,AsyncCallback<AuxEmpleado> callback)throws IllegalArgumentException;

	    /**
	     * 
	     * @param idTest
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getTest(Long idTest,Long id,AsyncCallback<AuxTest> callback)throws IllegalArgumentException;

	    /**
	     * 
	     * @param idTest
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getTest(Long id,AsyncCallback<List<AuxTest>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getSalarios(AsyncCallback<List<AuxSalario>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getSalarios(Long id, AsyncCallback<List<AuxSalario>> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param fileURL
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void remove(String fileURL,AsyncCallback<String> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param Correo
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getIdEmpleado(String Correo,AsyncCallback<Long> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getHistorial(Long id,AsyncCallback<List<AuxHistorial>> callback)throws IllegalArgumentException;

	    /**
	     * 
	     * @param id
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getPermisos(Long id,AsyncCallback<List<AuxPermiso>> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param idEmpleado
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void getPuestoActivo(Long idEmpleado,AsyncCallback<AuxPuesto> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void CheqLog(AsyncCallback<Boolean> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void obtenerId(AsyncCallback<Long> callback)throws IllegalArgumentException;
	    

	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void obtenerIdAfiliado(AsyncCallback<Long> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void obtenerIdRol(AsyncCallback<Long> callback)throws IllegalArgumentException;
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void obtenerUsuario(AsyncCallback<String> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void obtenerIdJefe(AsyncCallback<Long> callback)throws IllegalArgumentException;
	    
	    /**
	     * 
	     * @param callback
	     * @throws IllegalArgumentException
	     */
	    void logout(AsyncCallback<Boolean> callback)throws IllegalArgumentException;
}
