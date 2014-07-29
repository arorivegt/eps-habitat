package org.habitatguate.hgerp.seguridad.client.api;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	String[] login(String user,String password) throws IllegalArgumentException;
	Long Insertar_Emppleado(int intafiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String tipo_empleado,
            String pais, String nit,int No_Dependientes,String no_orden, int no_registro, int cui,
            String tipo_pasaporte, int no_pasaporte,
            String depto_municipio_cedula, String direccion_actual,
            String depto_municipio_residencia, String email, int telefono,
            int celular, Date fecha_nacimiento, String tipo_licencia,
            int no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion)  throws IllegalArgumentException;
	Long Insertar_Familiar(Long id_empleado,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,
			String parentesco)throws IllegalArgumentException;
	Long Insertar_Academico(Long id_empleado, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo)throws IllegalArgumentException;
}

