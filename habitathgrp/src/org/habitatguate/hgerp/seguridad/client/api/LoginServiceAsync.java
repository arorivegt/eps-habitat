package org.habitatguate.hgerp.seguridad.client.api;


import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LoginServiceAsync {
	void login(String user,String i2, AsyncCallback<String[]> callback) throws IllegalArgumentException;
	void Insertar_Emppleado(int intafiliacion_igss,
            String estado_civil, String sexo, String primer_apellido,
            String segundo_apellido, String apellido_casada,
            String primer_nombre, String segundo_nombre, String tipo_empleado,
            String pais,String nit, int No_Dependientes,String no_orden, int no_registro, int cui,
            String tipo_pasaporte, int no_pasaporte,
            String depto_municipio_cedula, String direccion_actual,
            String depto_municipio_residencia, String email, int telefono,
            int celular, Date fecha_nacimiento, String tipo_licencia,
            int no_licencia, String centro_trabajo, String ocupacion,
            Date fecha_ingreso, String codigo_ingreso, String profesion,
            String tipo_planilla, float salario_base, float total,
            float bonificacion,AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Familiar(Long id_empleado,String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, int edad, String ocupacion,String parentesco, 
			AsyncCallback<Long> callback) throws IllegalArgumentException;
	void Insertar_Academico(Long id_empleado, Date fecha1, Date fecha2,
			String nivel_academico, String establecimiento, String titulo, 
			AsyncCallback<Long> callback) throws IllegalArgumentException;
}
