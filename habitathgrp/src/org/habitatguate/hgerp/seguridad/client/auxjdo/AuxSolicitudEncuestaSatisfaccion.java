package org.habitatguate.hgerp.seguridad.client.auxjdo;


import java.util.Date;

import javax.jdo.annotations.Persistent;

import com.google.gwt.user.client.rpc.IsSerializable;


public class AuxSolicitudEncuestaSatisfaccion implements IsSerializable {

	public AuxSolicitudEncuestaSatisfaccion() {
		super();
	}
	
	// Llave Primaria
	
    private Long idEncuestaSatisfaccion;
	
    public Long getIdEncuestaSatisfaccion() {
		return idEncuestaSatisfaccion;
	}

	public void setIdEncuestaSatisfaccion(Long idEncuestaSatisfaccion) {
		this.idEncuestaSatisfaccion = idEncuestaSatisfaccion;
	}
	
	// Atributos

    private String preguntaNo1;
	
	public String getPreguntaNo1() {
		return preguntaNo1;
	}

	public void setPreguntaNo1(String preguntaNo1) {
		this.preguntaNo1 = preguntaNo1;
	}

    private String preguntaNo2;
	
	public String getPreguntaNo2() {
		return preguntaNo2;
	}

	public void setPreguntaNo2(String preguntaNo2) {
		this.preguntaNo2 = preguntaNo2;
	}

    private String preguntaNo3;
	
	public String getPreguntaNo3() {
		return preguntaNo3;
	}

	public void setPreguntaNo3(String preguntaNo3) {
		this.preguntaNo3 = preguntaNo3;
	}

    private String preguntaNo4;
	
	public String getPreguntaNo4() {
		return preguntaNo4;
	}

	public void setPreguntaNo4(String preguntaNo4) {
		this.preguntaNo4 = preguntaNo4;
	}

    private String preguntaNo5;

	public String getPreguntaNo5() {
		return preguntaNo5;
	}

	public void setPreguntaNo5(String preguntaNo5) {
		this.preguntaNo5 = preguntaNo5;
	}

    private String preguntaNo6;

	public String getPreguntaNo6() {
		return preguntaNo6;
	}

	public void setPreguntaNo6(String preguntaNo6) {
		this.preguntaNo6 = preguntaNo6;
	}

    private String preguntaNo7;

	public String getPreguntaNo7() {
		return preguntaNo7;
	}

	public void setPreguntaNo7(String preguntaNo7) {
		this.preguntaNo7 = preguntaNo7;
	}

    private String preguntaNo8;
	
	public String getPreguntaNo8() {
		return preguntaNo8;
	}

	public void setPreguntaNo8(String preguntaNo8) {
		this.preguntaNo8 = preguntaNo8;
	}

    private String preguntaNo9;
	
	public String getPreguntaNo9() {
		return preguntaNo9;
	}

	public void setPreguntaNo9(String preguntaNo9) {
		this.preguntaNo9 = preguntaNo9;
	}

    private String preguntaNo10;
	
	public String getPreguntaNo10() {
		return preguntaNo10;
	}

	public void setPreguntaNo10(String preguntaNo10) {
		this.preguntaNo10 = preguntaNo10;
	}

    private String preguntaNo11;
	
	public String getPreguntaNo11() {
		return preguntaNo11;
	}

	public void setPreguntaNo11(String preguntaNo11) {
		this.preguntaNo11 = preguntaNo11;
	}

    private String preguntaNo12;
	
	public String getPreguntaNo12() {
		return preguntaNo12;
	}

	public void setPreguntaNo12(String preguntaNo12) {
		this.preguntaNo12 = preguntaNo12;
	}

    private String preguntaNo13;
	
	public String getPreguntaNo13() {
		return preguntaNo13;
	}

	public void setPreguntaNo13(String preguntaNo13) {
		this.preguntaNo13 = preguntaNo13;
	}

    private String preguntaNo14;
	
	public String getPreguntaNo14() {
		return preguntaNo14;
	}

	public void setPreguntaNo14(String preguntaNo14) {
		this.preguntaNo14 = preguntaNo14;
	}

    private String preguntaNo15;
	
	public String getPreguntaNo15() {
		return preguntaNo15;
	}

	public void setPreguntaNo15(String preguntaNo15) {
		this.preguntaNo15 = preguntaNo15;
	}

    private String preguntaNo16;

	public String getPreguntaNo16() {
		return preguntaNo16;
	}

	public void setPreguntaNo16(String preguntaNo16) {
		this.preguntaNo16 = preguntaNo16;
	}
	
    private String departamento;
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	// Llave Foranea
	
	private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
    
}
