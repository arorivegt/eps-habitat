package org.habitatguate.hgerp.seguridad.client.auxjdo;

import javax.jdo.annotations.Persistent;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxBDTest implements IsSerializable {
	
    private Long id_test;
	
    private String nombreTest;
    
    private String pregunta1;
	
	
    private String pregunt2;
	
	
    private String pregunta3;
	
	
    private String pregunta4;
	
	
    private String pregunta5;
	
	
    private String pregunta6;
	
	
    private String pregunta7;
	
	
    private String pregunta8;
	
	
    private String pregunta9;
	
	
    private String pregunta10;
	
	
    private Long fecha_test;
	
	
    private String tipo_test;

	
	public AuxBDTest() {
		super();
	}

	public Long getId_test() {
		return id_test;
	}

	public void setId_test(Long id_test) {
		this.id_test = id_test;
	}

	public String getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public String getPregunt2() {
		return pregunt2;
	}

	public void setPregunt2(String pregunt2) {
		this.pregunt2 = pregunt2;
	}

	public String getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}

	public String getPregunta4() {
		return pregunta4;
	}

	public void setPregunta4(String pregunta4) {
		this.pregunta4 = pregunta4;
	}

	public String getPregunta5() {
		return pregunta5;
	}

	public void setPregunta5(String pregunta5) {
		this.pregunta5 = pregunta5;
	}

	public String getPregunta6() {
		return pregunta6;
	}

	public void setPregunta6(String pregunta6) {
		this.pregunta6 = pregunta6;
	}

	public String getPregunta7() {
		return pregunta7;
	}

	public void setPregunta7(String pregunta7) {
		this.pregunta7 = pregunta7;
	}

	public String getPregunta8() {
		return pregunta8;
	}

	public void setPregunta8(String pregunta8) {
		this.pregunta8 = pregunta8;
	}

	public String getPregunta9() {
		return pregunta9;
	}

	public void setPregunta9(String pregunta9) {
		this.pregunta9 = pregunta9;
	}

	public String getPregunta10() {
		return pregunta10;
	}

	public void setPregunta10(String pregunta10) {
		this.pregunta10 = pregunta10;
	}

	public Long getFecha_test() {
		return fecha_test;
	}

	public void setFecha_test(Long fecha_test) {
		this.fecha_test = fecha_test;
	}

	public String getTipo_test() {
		return tipo_test;
	}

	public void setTipo_test(String tipo_test) {
		this.tipo_test = tipo_test;
	}

	public String getNombreTest() {
		return nombreTest;
	}

	public void setNombreTest(String nombreTest) {
		this.nombreTest = nombreTest;
	}

	

}
