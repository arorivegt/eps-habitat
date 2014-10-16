package org.habitatguate.hgerp.seguridad.client.api;


import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTestCompartidos;
import org.habitatguate.hgerp.seguridad.client.rrhh.valores_sesion;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RecursosHumanosServiceAsync {
	//metodos para insertar una tupla en la entidad especifica
	void Registro(String user,String pass,String Nombre, String Apellido, Date fecha_nacimiento, AsyncCallback<String> callback) throws IllegalArgumentException;
	void login_inicio(String user,String i2, AsyncCallback<valores_sesion> callback) throws IllegalArgumentException;
	void Insertar_Emppleado(String afiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String IVS,
            String pais,String nit, String No_Dependientes,String noCuenta, String tipoCuenta, String nombreBanco,String cui,
            String tipo_pasaporte, String no_pasaporte, String direccion_actual,
            String depto_municipio_residencia, String email, String telefono,
            String celular, Date fecha_nacimiento, String tipo_licencia,
            String no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,String  URLFile, String KeyFile,String Estado,
            String pasaporte, String licencia,AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Familiar(Long id_empleado,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,String parentesco, 
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Academico(Long id_empleado, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo, 
			String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Referencia_Laboral(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato,String empresa_referencia, Date fecha1, 
			Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
			String recomiendo, AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Referencia_Personal(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato, String relacion, String actitudes_cualidades, 
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Idioma(Long id_empleado, String nivel, String idioma, 
			String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Test(Long id_empleado,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
			int pregunta5, int pregunta6, int pregunta7, int pregunta8,
			int pregunta9, int pregunta10, Date fecha_test, String evaluador,Long BDtest, boolean testBD,
			String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Salario(Long id_empleado,Date Fecha, float salario, String tipoSalario, AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void InsertarCompartido(String idEmpleado,Long idTest, Long idEmpleadoCompartido, AsyncCallback<String> callback) throws IllegalArgumentException;
	void QuitarCompartido(Long idEmpleado,Long idTeist, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void Insertar_BDTest(String nombreTest,String pregunta1, String pregunt2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8,
			String pregunta9, String pregunta10, Date fecha_test,
			String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Puesto(Long id_empleado,Date fecha_puesto, String nombre_puesto, String funciones,
			String motivoPuesto, boolean activo,  String jornada, String horasTrabajo,AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_BDPuesto(Date fecha_puesto, String nombre_puesto, String funciones,
			 	AsyncCallback<Long> callback) throws IllegalArgumentException;
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
			String empresa_credito, boolean alquila,float pago_alquiler,String Otros_Ingresos, float amortizacion,
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Historial(Long id_empleado,Date fecha, String descripcion, 
			String tipo_historial, AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Vacaciones(Long id_empleado,Date fecha1, Date fecha2, String descripcionl, 
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	///metodos para actualizar las entidades
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
	            String pasaporte, String licencia,AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Familiar(Long id_empleado,Long id,String primer_nombre, String segundo_nombre,
				String primer_apellido, String segundo_apellido, int edad, String ocupacion,String parentesco, 
				AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Academico(Long id_empleado,Long id, Date fecha1, Date fecha2,
				String nivel_academico, String establecimiento, String titulo, 
				String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Referencia_Laboral(Long id_empleado,Long id,String nombre_referencia, String telefono, 
				String puesto_candidato,String empresa_referencia, Date fecha1, 
				Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
				String recomiendo, AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Referencia_Personal(Long id_empleado,Long id,String nombre_referencia, String telefono, 
				String puesto_candidato, String relacion, String actitudes_cualidades, 
				AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Idioma(Long id_empleado,Long id, String nivel, String idioma, 
				String  URLFile, String KeyFile,AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Test(Long id_empleado,Long id,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
				int pregunta5, int pregunta6, int pregunta7, int pregunta8,
				int pregunta9, int pregunta10, Date fecha_test,String evaluador,Long BDtest, boolean testBD,
				String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_BDTest(Long id,String nombreTest,String pregunta1, String pregunta2, String pregunta3, String pregunta4,
				String pregunta5, String pregunta6, String pregunta7, String pregunta8,
				String pregunta9, String pregunta10, Date fecha_test,
				String tipo_test, AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Puesto(Long id_empleado,Long id,Date fecha_puesto, String nombre_puesto, String funciones,
				String motivoPuesto, boolean activo, String jornada, String horasTrabajo, AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_BDPuesto(Long id,Date fecha_puesto, String nombre_puesto, String funciones,
				 AsyncCallback<Long> callback) throws IllegalArgumentException;
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
				String empresa_credito, boolean alquila,float pago_alquiler, String Otros_Ingresos,float amortizacion,
				AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Historial(Long id_empleado,Long id,Date fecha, String descripcion, 
				String tipo_historial, AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Vacaciones(Long id_empleado,Long id,Date fecha1, Date fecha2, String descripcionl, 
				AsyncCallback<Long> callback) throws IllegalArgumentException;
		void Actualizar_Salario(Long id_empleado,Long id,Date Fecha, float salario, String tipoSalario,AsyncCallback<Long> callback) throws IllegalArgumentException;
		
		//metodos para Eliminar en la base de datos
		//metodos para Eliminar en la base de datos
	    void Eliminar_Emppleado(Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Familiar(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Academico(Long id_empleado,Long id,
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Referencia_Laboral(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Referencia_Personal(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Idioma(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Test(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Puesto(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Entrevista(Long id_empleado,Long id,
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Historial(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Vacaciones(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    void Eliminar_Salario(Long id_empleado,Long id, 
					AsyncCallback<Long> callback) throws IllegalArgumentException;
	    
	    ///querys
	    void Buscar_Empleado(char tipo, String primer_nombre, String segundo_nombre, 
				String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,
				String Estado,AsyncCallback<List<AuxEmpleado>> callback) throws IllegalArgumentException;
	    void Empleado_Registrado(Long id_empleado,
	    		AsyncCallback<AuxEmpleado> callback)throws IllegalArgumentException;
	    void BDPuesto(AsyncCallback<List<AuxBDPuesto>> callback)throws IllegalArgumentException;
	    void BDTest(AsyncCallback<List<AuxBDTest>> callback)throws IllegalArgumentException;
	    void getCorreos(AsyncCallback<List<String>> callback)throws IllegalArgumentException;
	    void getEvaluacionesCompartidas(Long id,AsyncCallback<List<AuxTestCompartidos>> callback)throws IllegalArgumentException;
	    void getTest(Long idTest,Long id,AsyncCallback<AuxTest> callback)throws IllegalArgumentException;
	    void getSalarios(AsyncCallback<List<AuxSalario>> callback)throws IllegalArgumentException;
	    void remove(String fileURL,AsyncCallback<String> callback)throws IllegalArgumentException;
	    
		

	
}
