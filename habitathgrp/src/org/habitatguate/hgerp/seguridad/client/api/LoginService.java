package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.rrhh.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.rrhh.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.rrhh.valores_sesion;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	//metodos para insertar en la base de datos
	String Registro(String user,String password) throws IllegalArgumentException;
	valores_sesion login_inicio(String user,String password) throws IllegalArgumentException;	
	Long Insertar_Emppleado(String afiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String IVS,
            String pais,String nit, String No_Dependientes,String no_orden, String no_registro, String cui,
            String tipo_pasaporte, String no_pasaporte,
            String depto_municipio_cedula, String direccion_actual,
            String depto_municipio_residencia, String email, String telefono,
            String celular, Date fecha_nacimiento, String tipo_licencia,
            String no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,String  URLFile, String KeyFile,String Estado,String pasaporte, String licencia)  throws IllegalArgumentException;
	Long Insertar_Familiar(Long id_empleado,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,
			String parentesco)throws IllegalArgumentException;
	Long Insertar_Academico(Long id_empleado, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	Long Insertar_Referencia_Laboral(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato,String empresa_referencia, Date fecha1, 
			Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
			String recomiendo)throws IllegalArgumentException;
	Long Insertar_Referencia_Personal(Long id_empleado,String nombre_referencia, String telefono, 
			String puesto_candidato, String relacion, String actitudes_cualidades)throws IllegalArgumentException;
	Long Insertar_Idioma(Long id_empleado, String nivel, String idioma
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	Long Insertar_Test(Long id_empleado,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
			int pregunta5, int pregunta6, int pregunta7, int pregunta8,
			int pregunta9, int pregunta10, Date fecha_test, String evaluador,
			String tipo_test)throws IllegalArgumentException;
	Long Insertar_Puesto(Long id_empleado,Date fecha_puesto, String nombre_puesto, String funciones,
			float salario, boolean activo)throws IllegalArgumentException;
	Long Insertar_BDPuesto(Date fecha_puesto, String nombre_puesto, String funciones) throws IllegalArgumentException;
	Long Insertar_Entrevista(Long id_empleado,Date fecha_entrevista, String que_conoces,
			String por_que_trabajas_aqui, String como_se_describe,
			String trabajar_por_presion, String metas,
			boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
			boolean flexibilidad_horario, float pretencion_salarial_minimo,
			boolean antecedentes_penales, boolean antecedentes_policiacos,
			boolean carta_recomendacion_laboral,
			boolean carta_recomendacion_personal, boolean vive_con_familia,
			boolean casa_propia, String entrevisto, String enfermedades,
			float aporte_casa, boolean tiene_deudas, int no_dependientes,
			String empresa_credito, boolean alquila,float pago_alquiler,String Otros_Ingresos,float amortizacion)throws IllegalArgumentException;
	Long Insertar_Historial(Long id_empleado,Date fecha, String descripcion, 
			String tipo_historial)throws IllegalArgumentException;
	Long  Insertar_Vacaciones(Long id_empleado,Date fecha1, Date fecha2, 
			String descripcionl)throws IllegalArgumentException;
	

	//metodos para Actualizar en la base de datos
	Long Actualizar_Emppleado(Long id, String Stringafiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String IVS,
            String pais,String nit, String No_Dependientes,String no_orden, String no_registro, String cui,
            String tipo_pasaporte, String no_pasaporte,
            String depto_municipio_cedula, String direccion_actual,
            String depto_municipio_residencia, String email, String telefono,
            String celular, Date fecha_nacimiento, String tipo_licencia,
            String no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,String  URLFile, String KeyFile,String Estado,
            String pasaporte, String licencia)  throws IllegalArgumentException;
	Long Actualizar_Familiar(Long id_empleado,Long id,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,
			String parentesco)throws IllegalArgumentException;
	Long Actualizar_Academico(Long id_empleado,Long id, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	Long Actualizar_Referencia_Laboral(Long id_empleado,Long id,String nombre_referencia, String telefono, 
			String puesto_candidato,String empresa_referencia, Date fecha1, 
			Date fecha2,String motivo_retiro, float salario_final, String actitudes_cualidades,
			String recomiendo)throws IllegalArgumentException;
	Long Actualizar_Referencia_Personal(Long id_empleado,Long id,String nombre_referencia, String telefono, 
			String puesto_candidato, String relacion, String actitudes_cualidades)throws IllegalArgumentException;
	Long Actualizar_Idioma(Long id_empleado,Long id, String nivel, String idioma
			,String  URLFile, String KeyFile)throws IllegalArgumentException;
	Long Actualizar_Test(Long id_empleado,Long id,int pregunta1, int pregunt2, int pregunta3, int pregunta4,
			int pregunta5, int pregunta6, int pregunta7, int pregunta8,
			int pregunta9, int pregunta10, Date fecha_test, String evaluador,
			String tipo_test)throws IllegalArgumentException;
	Long Actualizar_Puesto(Long id_empleado,Long id,Date fecha_puesto, String nombre_puesto, String funciones,
			float salario, boolean activo)throws IllegalArgumentException;
	Long Actualizar_BDPuesto(Long id,Date fecha_puesto, String nombre_puesto, String funciones)
			throws IllegalArgumentException;
	Long Actualizar_Entrevista(Long id_empleado,Long id,Date fecha_entrevista, String que_conoces,
			String por_que_trabajas_aqui, String como_se_describe,
			String trabajar_por_presion, String metas,
			boolean disponibilidad_inmediata, boolean disposicion_a_viajar,
			boolean flexibilidad_horario, float pretencion_salarial_minimo,
			boolean antecedentes_penales, boolean antecedentes_policiacos,
			boolean carta_recomendacion_laboral,
			boolean carta_recomendacion_personal, boolean vive_con_familia,
			boolean casa_propia, String entrevisto, String enfermedades,
			float aporte_casa, boolean tiene_deudas, int no_dependientes,
			String empresa_credito, boolean alquila,float pago_alquiler,String Otros_Ingresos,float amortizacion)throws IllegalArgumentException;
	Long Actualizar_Historial(Long id_empleado,Long id,Date fecha, String descripcion, 
			String tipo_historial)throws IllegalArgumentException;
	Long  Actualizar_Vacaciones(Long id_empleado,Long id,Date fecha1, Date fecha2, 
			String descripcionl)throws IllegalArgumentException;
	
	//metodos para Eliminar en la base de datos
    Long Eliminar_Emppleado(Long id)  throws IllegalArgumentException;
    Long Eliminar_Familiar(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Academico(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Referencia_Laboral(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Referencia_Personal(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Idioma(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Test(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Puesto(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Entrevista(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Historial(Long id_empleado,Long id)throws IllegalArgumentException;
    Long Eliminar_Vacaciones(Long id_empleado,Long id)throws IllegalArgumentException;
    String remove(String fileURL)throws IllegalArgumentException;


    ///querys
    List<AuxEmpleado> Buscar_Empleado(char tipo, String primer_nombre, String segundo_nombre, 
			String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,
			String Estado) throws IllegalArgumentException;    
    List<AuxBDPuesto> BDPuesto()throws IllegalArgumentException;
    ///querys
    AuxEmpleado Empleado_Registrado(Long id_empleado) throws IllegalArgumentException;
    
	
    

}

