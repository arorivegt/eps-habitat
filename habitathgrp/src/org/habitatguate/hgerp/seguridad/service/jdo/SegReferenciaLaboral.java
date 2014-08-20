package org.habitatguate.hgerp.seguridad.service.jdo;


import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegReferenciaLaboral implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_referencia_laboral;
	
	@Persistent
    private String nombre_referencia;
	
	@Persistent
    private String telefono;
	
	@Persistent
    private String puesto_candidato;
	
	@Persistent
    private String empresa_referencia;

	@Persistent
    private Date fecha1;
	
	@Persistent
    private Date fecha2;
	
	@Persistent
    private String motivo_retiro;
	
	@Persistent
    private float salario_final;

	@Persistent
    private String actitudes_cualidades;
	
	@Persistent
    private String recomiendo;

    private SegEmpleado empleado;


	public SegReferenciaLaboral() {
		super();
	}

	public Long getId_referencia_laboral() {
		return id_referencia_laboral.getId();
	}

	public String getNombre_referencia() {
		return nombre_referencia;
	}

	public void setNombre_referencia(String nombre_referencia) {
		this.nombre_referencia = nombre_referencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPuesto_candidato() {
		return puesto_candidato;
	}

	public void setPuesto_candidato(String puesto_candidato) {
		this.puesto_candidato = puesto_candidato;
	}

	public String getEmpresa_referencia() {
		return empresa_referencia;
	}

	public void setEmpresa_referencia(String empresa_referencia) {
		this.empresa_referencia = empresa_referencia;
	}

	public Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	public Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}

	public String getMotivo_retiro() {
		return motivo_retiro;
	}

	public void setMotivo_retiro(String motivo_retiro) {
		this.motivo_retiro = motivo_retiro;
	}

	public float getSalario_final() {
		return salario_final;
	}

	public void setSalario_final(float salario_final) {
		this.salario_final = salario_final;
	}

	public String getActitudes_cualidades() {
		return actitudes_cualidades;
	}

	public void setActitudes_cualidades(String actitudes_cualidades) {
		this.actitudes_cualidades = actitudes_cualidades;
	}

	public String getRecomiendo() {
		return recomiendo;
	}

	public void setRecomiendo(String recomiendo) {
		this.recomiendo = recomiendo;
	}

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}    
    
}
