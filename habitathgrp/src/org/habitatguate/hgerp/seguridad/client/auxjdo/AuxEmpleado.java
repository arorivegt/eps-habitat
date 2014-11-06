package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxEmpleado implements IsSerializable{
	
    private Long id_empleado;
	
	
    private String afiliacion_igss;
	
	
    private String estado_civil;   
	
	 
    private String sexo;  
    

    private Long afiliado;  

	 
    private String primer_apellido;
	
	 
    private String Segundo_apellido;
    
	 
    private String apellido_casada;
    
	 
    private String primer_nombre;
    
	 
    private String Segundo_nombre;

	 
    private String nit;
    
    
	 
    private String cui;
 
    
    private String pasaporte;
    
	 
    private String tipo_pasaporte;
    
	 
    private String no_pasaporte;
	 
    private String direccion_actual;
	 
    private String depto_municipio_residencia;
    
    private String depto_municipio_nacimiento;
	 
    private String email;
	 
    private String telefono;
	 
    private String celular;    
	 
    private Long fecha_nacimiento;

    private String licencia;
	 
    private String tipo_licencia;
	 
    private String No_Dependientes;
	 
    private String no_licencia;
	 
    private String IVS;	
	 
    private String pais; 
  
    private String URLFile;
    
    private String KeyFile;

    private String Estado;

    private String noCuenta;
	
    private String tipoCuenta;
	
    private String nombreBanco;
    
    private String Etnia;
    
    private Long Jefe_Inmediato;
	
    private String NombreEmergencia;
	
    private String TelefonoEmergencia;
	
    private String NombreEmergencia2;

    private String TelefonoEmergencia2;
    
    private List <AuxVacaciones> vacaciones = new ArrayList<AuxVacaciones>();

    private List <AuxFamilia> familia= new ArrayList<AuxFamilia>();

  	
  	private List <AuxHistorialAcademico> historial_academico= new ArrayList<AuxHistorialAcademico>();

  	
  	private List <AuxReferenciaLaboral> referencia_laboral= new ArrayList<AuxReferenciaLaboral>();

  	
  	private List <AuxEntrevista> entrevista= new ArrayList<AuxEntrevista>();

  	
  	private List <AuxPuesto> puestos= new ArrayList<AuxPuesto>();

  	
  	private List <AuxIdioma> idiomas= new ArrayList<AuxIdioma>();
  	
  	
  	private List <AuxReferenciaPersonal> referencia_personal= new ArrayList<AuxReferenciaPersonal>();
  	
  	
  	private List <AuxHistorial> Historial= new ArrayList<AuxHistorial>();

  	private List <AuxTest> test= new ArrayList<AuxTest>();
  	
  	private List <AuxSalario> salario= new ArrayList<AuxSalario>();

    private List<AuxTestCompartidos> testCompartido = new ArrayList<AuxTestCompartidos>();
  	//datos del patrono
  	
  	private String centro_trabajo;
  	
  	
      private String ocupacion;
  	
  	
      private Long fecha_ingreso;
  	
  	
      private String codigo_ingreso;
  	
  	
      private String profesion;
  	
  	
      private String tipo_planilla;
  	
  	
      private float salario_base;
  	
  	
      private float total ;
  	
  	
      private float bonificacion;


	public AuxEmpleado() {
		super();
	}


	public List<AuxTestCompartidos> getTestCompartido() {
		return testCompartido;
	}


	public void setTestCompartido(List<AuxTestCompartidos> testCompartido) {
		this.testCompartido = testCompartido;
	}


	public Long getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}


	public String getAfiliacion_igss() {
		return afiliacion_igss;
	}


	public void setAfiliacion_igss(String afiliacion_igss) {
		this.afiliacion_igss = afiliacion_igss;
	}


	public String getEstado_civil() {
		return estado_civil;
	}


	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}


	public String getSexo() {
		return sexo;
	}


	public Long getAfiliado() {
		return afiliado;
	}


	public void setAfiliado(Long afiliado) {
		this.afiliado = afiliado;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getPrimer_apellido() {
		return primer_apellido;
	}


	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}


	public String getSegundo_apellido() {
		return Segundo_apellido;
	}


	public void setSegundo_apellido(String segundo_apellido) {
		Segundo_apellido = segundo_apellido;
	}


	public String getApellido_casada() {
		return apellido_casada;
	}


	public void setApellido_casada(String apellido_casada) {
		this.apellido_casada = apellido_casada;
	}


	public String getPrimer_nombre() {
		return primer_nombre;
	}


	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}


	public String getSegundo_nombre() {
		return Segundo_nombre;
	}


	public void setSegundo_nombre(String segundo_nombre) {
		Segundo_nombre = segundo_nombre;
	}


	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public String getCui() {
		return cui;
	}


	public void setCui(String cui) {
		this.cui = cui;
	}


	public String getTipo_pasaporte() {
		return tipo_pasaporte;
	}


	public void setTipo_pasaporte(String tipo_pasaporte) {
		this.tipo_pasaporte = tipo_pasaporte;
	}


	public String getNo_pasaporte() {
		return no_pasaporte;
	}


	public void setNo_pasaporte(String no_pasaporte) {
		this.no_pasaporte = no_pasaporte;
	}

	public String getDireccion_actual() {
		return direccion_actual;
	}


	public void setDireccion_actual(String direccion_actual) {
		this.direccion_actual = direccion_actual;
	}


	public String getDepto_municipio_residencia() {
		return depto_municipio_residencia;
	}


	public void setDepto_municipio_residencia(String depto_municipio_residencia) {
		this.depto_municipio_residencia = depto_municipio_residencia;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public Long getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Long fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getTipo_licencia() {
		return tipo_licencia;
	}


	public void setTipo_licencia(String tipo_licencia) {
		this.tipo_licencia = tipo_licencia;
	}


	public String getNo_Dependientes() {
		return No_Dependientes;
	}


	public void setNo_Dependientes(String no_Dependientes) {
		No_Dependientes = no_Dependientes;
	}


	public String getNo_licencia() {
		return no_licencia;
	}


	public void setNo_licencia(String no_licencia) {
		this.no_licencia = no_licencia;
	}



	public String getPais() {
		return pais;
	}


	public String getIVS() {
		return IVS;
	}


	public void setIVS(String iVS) {
		IVS = iVS;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public List<AuxVacaciones> getVacaciones() {
		return vacaciones;
	}


	public void setVacaciones(List<AuxVacaciones> vacaciones) {
		this.vacaciones = vacaciones;
	}


	public List<AuxFamilia> getFamilia() {
		return familia;
	}


	public void setFamilia(List<AuxFamilia> familia) {
		this.familia = familia;
	}


	public List<AuxHistorialAcademico> getHistorial_academico() {
		return historial_academico;
	}


	public void setHistorial_academico(
			List<AuxHistorialAcademico> historial_academico) {
		this.historial_academico = historial_academico;
	}


	public List<AuxReferenciaLaboral> getReferencia_laboral() {
		return referencia_laboral;
	}


	public void setReferencia_laboral(List<AuxReferenciaLaboral> referencia_laboral) {
		this.referencia_laboral = referencia_laboral;
	}


	public List<AuxEntrevista> getEntrevista() {
		return entrevista;
	}


	public void setEntrevista(List<AuxEntrevista> entrevista) {
		this.entrevista = entrevista;
	}


	public List<AuxPuesto> getPuestos() {
		return puestos;
	}


	public void setPuestos(List<AuxPuesto> puestos) {
		this.puestos = puestos;
	}


	public List<AuxIdioma> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(List<AuxIdioma> idiomas) {
		this.idiomas = idiomas;
	}


	public List<AuxReferenciaPersonal> getReferencia_personal() {
		return referencia_personal;
	}


	public void setReferencia_personal(
			List<AuxReferenciaPersonal> referencia_personal) {
		this.referencia_personal = referencia_personal;
	}


	public List<AuxHistorial> getHistorial() {
		return Historial;
	}


	public void setHistorial(List<AuxHistorial> historial) {
		Historial = historial;
	}


	public List<AuxTest> getTest() {
		return test;
	}


	public void setTest(List<AuxTest> test) {
		this.test = test;
	}


	public String getCentro_trabajo() {
		return centro_trabajo;
	}


	public void setCentro_trabajo(String centro_trabajo) {
		this.centro_trabajo = centro_trabajo;
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	public Long getFecha_ingreso() {
		return fecha_ingreso;
	}


	public void setFecha_ingreso(Long fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}


	public String getCodigo_ingreso() {
		return codigo_ingreso;
	}


	public void setCodigo_ingreso(String codigo_ingreso) {
		this.codigo_ingreso = codigo_ingreso;
	}


	public String getProfesion() {
		return profesion;
	}


	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}


	public String getTipo_planilla() {
		return tipo_planilla;
	}


	public void setTipo_planilla(String tipo_planilla) {
		this.tipo_planilla = tipo_planilla;
	}


	public float getSalario_base() {
		return salario_base;
	}


	public void setSalario_base(float salario_base) {
		this.salario_base = salario_base;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public float getBonificacion() {
		return bonificacion;
	}


	public void setBonificacion(float bonificacion) {
		this.bonificacion = bonificacion;
	}


	public String getURLFile() {
		return URLFile;
	}


	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}


	public String getKeyFile() {
		return KeyFile;
	}


	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public String getLicencia() {
		return licencia;
	}


	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}


	public String getPasaporte() {
		return pasaporte;
	}


	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}


	public List <AuxSalario> getSalario() {
		return salario;
	}


	public void setSalario(List <AuxSalario> salario) {
		this.salario = salario;
	}


	public String getNoCuenta() {
		return noCuenta;
	}


	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public String getNombreBanco() {
		return nombreBanco;
	}


	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}


	public String getEtnia() {
		return Etnia;
	}


	public void setEtnia(String etnia) {
		Etnia = etnia;
	}


	public String getNombreEmergencia() {
		return NombreEmergencia;
	}


	public void setNombreEmergencia(String nombreEmergencia) {
		NombreEmergencia = nombreEmergencia;
	}


	public String getTelefonoEmergencia() {
		return TelefonoEmergencia;
	}


	public void setTelefonoEmergencia(String telefonoEmergencia) {
		TelefonoEmergencia = telefonoEmergencia;
	}


	public String getNombreEmergencia2() {
		return NombreEmergencia2;
	}


	public void setNombreEmergencia2(String nombreEmergencia2) {
		NombreEmergencia2 = nombreEmergencia2;
	}


	public String getTelefonoEmergencia2() {
		return TelefonoEmergencia2;
	}


	public void setTelefonoEmergencia2(String telefonoEmergencia2) {
		TelefonoEmergencia2 = telefonoEmergencia2;
	}


	public Long getJefe_Inmediato() {
		return Jefe_Inmediato;
	}


	public void setJefe_Inmediato(Long jefe_Inmediato) {
		Jefe_Inmediato = jefe_Inmediato;
	}


	public String getDepto_municipio_nacimiento() {
		return depto_municipio_nacimiento;
	}


	public void setDepto_municipio_nacimiento(String depto_municipio_nacimiento) {
		this.depto_municipio_nacimiento = depto_municipio_nacimiento;
	}

	
}
