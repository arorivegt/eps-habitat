package org.habitatguate.hgerp.seguridad.client.rrhh;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxReferenciaLaboral implements IsSerializable {
	
    private Long id_referencia_laboral;
	
	
    private String nombre_referencia;
	
	
    private String telefono;
	
	
    private String puesto_candidato;
	
	
    private String empresa_referencia;

	
    private Long fecha1;
	
	
    private Long fecha2;
	
	
    private String motivo_retiro;
	
	
    private float salario_final;

	
    private String actitudes_cualidades;
	
	
    private String recomiendo;
	

	public AuxReferenciaLaboral() {
		super();
	}

	public Long getId_referencia_laboral() {
		return id_referencia_laboral;
	}
	 

	public void setId_referencia_laboral(Long id_referencia_laboral) {
		this.id_referencia_laboral = id_referencia_laboral;
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

	public Long getFecha1() {
		return fecha1;
	}

	public void setFecha1(Long fecha1) {
		this.fecha1 = fecha1;
	}

	public Long getFecha2() {
		return fecha2;
	}

	public void setFecha2(Long fecha2) {
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

}
