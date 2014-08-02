package org.habitatguate.hgerp.seguridad.service;


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
public class SegTest implements Serializable {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id_test;
	
	@Persistent
    private int pregunta1;
	
	@Persistent
    private int pregunt2;
	
	@Persistent
    private int pregunta3;
	
	@Persistent
    private int pregunta4;
	
	@Persistent
    private int pregunta5;
	
	@Persistent
    private int pregunta6;
	
	@Persistent
    private int pregunta7;
	
	@Persistent
    private int pregunta8;
	
	@Persistent
    private int pregunta9;
	
	@Persistent
    private int pregunta10;
	
	@Persistent
    private Date fecha_test;
	
	@Persistent
    private String evaluador;
	
	@Persistent
    private String tipo_test;

	@Persistent
    private SegEmpleado empleado;

	public SegTest() {
		super();
	}

	public Long getId_test() {
		return id_test.getId();
	}

	public int getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(int pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public int getPregunt2() {
		return pregunt2;
	}

	public void setPregunt2(int pregunt2) {
		this.pregunt2 = pregunt2;
	}

	public int getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(int pregunta3) {
		this.pregunta3 = pregunta3;
	}

	public int getPregunta4() {
		return pregunta4;
	}

	public void setPregunta4(int pregunta4) {
		this.pregunta4 = pregunta4;
	}

	public int getPregunta5() {
		return pregunta5;
	}

	public void setPregunta5(int pregunta5) {
		this.pregunta5 = pregunta5;
	}

	public int getPregunta6() {
		return pregunta6;
	}

	public void setPregunta6(int pregunta6) {
		this.pregunta6 = pregunta6;
	}

	public int getPregunta7() {
		return pregunta7;
	}

	public void setPregunta7(int pregunta7) {
		this.pregunta7 = pregunta7;
	}

	public int getPregunta8() {
		return pregunta8;
	}

	public void setPregunta8(int pregunta8) {
		this.pregunta8 = pregunta8;
	}

	public int getPregunta9() {
		return pregunta9;
	}

	public void setPregunta9(int pregunta9) {
		this.pregunta9 = pregunta9;
	}

	public int getPregunta10() {
		return pregunta10;
	}

	public void setPregunta10(int pregunta10) {
		this.pregunta10 = pregunta10;
	}

	public Date getFecha_test() {
		return fecha_test;
	}

	public void setFecha_test(Date fecha_test) {
		this.fecha_test = fecha_test;
	}

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}

	public String getTipo_test() {
		return tipo_test;
	}

	public void setTipo_test(String tipo_test) {
		this.tipo_test = tipo_test;
	}

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}	
	
	
}
