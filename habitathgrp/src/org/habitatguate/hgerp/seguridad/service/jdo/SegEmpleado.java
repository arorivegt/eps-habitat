package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegEmpleado implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_empleado;
	
	@Persistent
    private String afiliacion_igss;
	
	@Persistent
    private String estado_civil;   
	
	@Persistent    
    private String sexo;  

	@Persistent    
    private String primer_apellido;
	
	@Persistent    
    private String segundo_apellido;
    
	@Persistent    
    private String apellido_casada;
    
	@Persistent    
    private String primer_nombre;
    
	@Persistent    
    private String segundo_nombre;

	@Persistent    
    private String nit;
    
	@Persistent    
    private String no_orden ;
    
	@Persistent    
    private String no_registro;
    
	@Persistent    
    private String cui;

	@Persistent    
    private String pasaporte;
	
	@Persistent    
    private String tipo_pasaporte;
    
	@Persistent    
    private String no_pasaporte;
    
	@Persistent 
    private String depto_municipio_cedula;
    
	@Persistent    
    private String direccion_actual;
    
	@Persistent 
    private String depto_municipio_residencia;
    
	@Persistent    
    private String email;
    
	@Persistent    
    private String telefono;
    
	@Persistent    
    private String celular;
    
	@Persistent    
    private Date fecha_nacimiento;

	@Persistent    
    private String licencia;
	
	@Persistent    
    private String tipo_licencia;
	
	@Persistent    
    private String No_Dependientes;

	@Persistent    
    private String no_licencia;

	//con IVS, sin IVS
	@Persistent    
    private String IVS;
	
	@Persistent    
    private String pais;

	@Persistent    
    private String URLFile;

	@Persistent    
    private String KeyFile;

	@Persistent    
    private String Estado;

	
	public SegEmpleado() {
		super();
	}

	//aqui vienen todas los objetos con los que se relaciona

	@Persistent(mappedBy = "empleado")
    @Element(dependent = "true")
    private List<SegTestCompartidos> testCompartido;
    
	@Persistent(mappedBy = "empleado")
    @Element(dependent = "true")
	private List <SegVacaciones> vacaciones;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegFamilia> familia;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegSalario> salario;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegHistorialAcademico> historial_academico;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegReferenciaLaboral> referencia_laboral;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegEntrevista> entrevista;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegPuesto> puestos;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegIdioma> idiomas;
	
	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegReferenciaPersonal> referencia_personal;
	
	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegHistorial> Historial;

	@Persistent(mappedBy = "empleado")
	@Element(dependent = "true")
	private List <SegTest> test;
	
	@ManyToOne
	private Long afiliado;
	
	//datos del patrono
	@Persistent
	private String centro_trabajo;
	
	@Persistent
    private String ocupacion;
	
	@Persistent
    private Date fecha_ingreso;
	
	@Persistent
    private String codigo_ingreso;
	
	@Persistent
    private String profesion;
	
	@Persistent
    private String tipo_planilla;
	
	@Persistent
    private float salario_base;
	
	@Persistent
    private float total ;
	
	@Persistent
    private float bonificacion;

	
	public List<SegTestCompartidos> getTestCompartido() {
		return testCompartido;
	}

	public void setTestCompartido(List<SegTestCompartidos> testCompartido) {
		this.testCompartido = testCompartido;
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

	public List<SegSalario> getSalario() {
		return salario;
	}

	public void setSalario(List<SegSalario> salario) {
		this.salario = salario;
	}

	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}

	public Long getId_empleado() {
		return id_empleado.getId();
	}

	public String getAfiliacion_igss() {
		return afiliacion_igss;
	}

	public void setAfiliacion_igss(String afiliacion_igss) {
		this.afiliacion_igss = afiliacion_igss;
	}

	public String getEstado() {
		return Estado;
	}
	

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public void setEstado(String estado) {
		Estado = estado;
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
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
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
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNo_orden() {
		return no_orden;
	}

	public void setNo_orden(String no_orden) {
		this.no_orden = no_orden;
	}

	public String getNo_registro() {
		return no_registro;
	}

	public void setNo_registro(String no_registro) {
		this.no_registro = no_registro;
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

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTipo_licencia() {
		return tipo_licencia;
	}

	public void setTipo_licencia(String tipo_licencia) {
		this.tipo_licencia = tipo_licencia;
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

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<SegVacaciones> getVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(List<SegVacaciones> vacaciones) {
		this.vacaciones = vacaciones;
	}

	public List<SegFamilia> getFamilia() {
		return familia;
	}

	public void setFamilia(List<SegFamilia> familia) {
		this.familia = familia;
	}

	public List<SegHistorialAcademico> getHistorial_academico() {
		return historial_academico;
	}

	public void setHistorial_academico(
			List<SegHistorialAcademico> historial_academico) {
		this.historial_academico = historial_academico;
	}

	public List<SegReferenciaLaboral> getReferencia_laboral() {
		return referencia_laboral;
	}

	public void setReferencia_laboral(
			List<SegReferenciaLaboral> referencia_laboral) {
		this.referencia_laboral = referencia_laboral;
	}

	public List<SegEntrevista> getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(List<SegEntrevista> entrevista) {
		this.entrevista = entrevista;
	}

	public List<SegPuesto> getPuestos() {
		return puestos;
	}

	public void setPuestos(List<SegPuesto> puestos) {
		this.puestos = puestos;
	}

	public List<SegIdioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<SegIdioma> idiomas) {
		this.idiomas = idiomas;
	}

	public List<SegReferenciaPersonal> getReferencia_personal() {
		return referencia_personal;
	}

	public void setReferencia_personal(
			List<SegReferenciaPersonal> referencia_personal) {
		this.referencia_personal = referencia_personal;
	}

	public List<SegTest> getTest() {
		return test;
	}

	public void setTest(List<SegTest> test) {
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

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
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
	
	public String getNo_Dependientes() {
		return No_Dependientes;
	}

	public void setNo_Dependientes(String no_Dependientes) {
		No_Dependientes = no_Dependientes;
	}

	public String getDepto_municipio_cedula() {
		return depto_municipio_cedula;
	}

	public void setDepto_municipio_cedula(String depto_municipio_cedula) {
		this.depto_municipio_cedula = depto_municipio_cedula;
	}

	public String getDepto_municipio_residencia() {
		return depto_municipio_residencia;
	}

	public void setDepto_municipio_residencia(String depto_municipio_residencia) {
		this.depto_municipio_residencia = depto_municipio_residencia;
	}

	public List<SegHistorial> getHistorial() {
		return Historial;
	}

	public void setHistorial(List<SegHistorial> historial) {
		Historial = historial;
	}
	


	public String getIVS() {
		return IVS;
	}

	public void setIVS(String IVS) {
		this.IVS = IVS;
	}

	public Long getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Long afiliado) {
		this.afiliado = afiliado;
	}


	
}
