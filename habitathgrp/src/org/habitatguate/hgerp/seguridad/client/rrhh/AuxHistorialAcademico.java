package org.habitatguate.hgerp.seguridad.client.rrhh;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxHistorialAcademico implements IsSerializable{
	
    private Long id_historial_academico;
	
	
    private Long fecha1;
	
	
    private Long fecha2;

	
    private String nivel_academico;
	
	
    private String establecimiento;
	
	
    private String titulo;
	

	public AuxHistorialAcademico() {
		super();
	}

	public Long getId_historial_academico() {
		return id_historial_academico;
	}
 
	public void setId_historial_academico(Long id_historial_academico) {
		this.id_historial_academico = id_historial_academico;
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

	public String getNivel_academico() {
		return nivel_academico;
	}

	public void setNivel_academico(String nivel_academico) {
		this.nivel_academico = nivel_academico;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	

}
