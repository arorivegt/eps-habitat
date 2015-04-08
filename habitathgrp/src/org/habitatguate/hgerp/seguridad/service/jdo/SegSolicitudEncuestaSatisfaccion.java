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
public class SegSolicitudEncuestaSatisfaccion implements Serializable {

	public SegSolicitudEncuestaSatisfaccion() {
		super();
	}
	
	// Llave Primaria
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key idEncuestaSatisfaccion;
	
	public Long getIdEncuestaSatisfaccion() {
		return idEncuestaSatisfaccion.getId();
	}
	
	// Atributos
	
	@Persistent    
    private Date fecrec;
	
	public Date getFecrec() {
		return fecrec;
	}

	public void setFecrec(Date fecrec) {
		this.fecrec = fecrec;
	}
	
	@Persistent
    private String preguntaNo1;
	
	public String getPreguntaNo1() {
		return preguntaNo1;
	}

	public void setPreguntaNo1(String preguntaNo1) {
		this.preguntaNo1 = preguntaNo1;
	}

	@Persistent
    private String preguntaNo2;
	
	public String getPreguntaNo2() {
		return preguntaNo2;
	}

	public void setPreguntaNo2(String preguntaNo2) {
		this.preguntaNo2 = preguntaNo2;
	}

	@Persistent
    private String preguntaNo3;
	
	public String getPreguntaNo3() {
		return preguntaNo3;
	}

	public void setPreguntaNo3(String preguntaNo3) {
		this.preguntaNo3 = preguntaNo3;
	}

	@Persistent
    private String preguntaNo4;
	
	public String getPreguntaNo4() {
		return preguntaNo4;
	}

	public void setPreguntaNo4(String preguntaNo4) {
		this.preguntaNo4 = preguntaNo4;
	}

	@Persistent
    private String preguntaNo5;

	public String getPreguntaNo5() {
		return preguntaNo5;
	}

	public void setPreguntaNo5(String preguntaNo5) {
		this.preguntaNo5 = preguntaNo5;
	}

	@Persistent
    private String preguntaNo6;

	public String getPreguntaNo6() {
		return preguntaNo6;
	}

	public void setPreguntaNo6(String preguntaNo6) {
		this.preguntaNo6 = preguntaNo6;
	}

	@Persistent
    private String preguntaNo7;

	public String getPreguntaNo7() {
		return preguntaNo7;
	}

	public void setPreguntaNo7(String preguntaNo7) {
		this.preguntaNo7 = preguntaNo7;
	}

	@Persistent
    private String preguntaNo8;
	
	public String getPreguntaNo8() {
		return preguntaNo8;
	}

	public void setPreguntaNo8(String preguntaNo8) {
		this.preguntaNo8 = preguntaNo8;
	}

	@Persistent
    private String preguntaNo9;
	
	public String getPreguntaNo9() {
		return preguntaNo9;
	}

	public void setPreguntaNo9(String preguntaNo9) {
		this.preguntaNo9 = preguntaNo9;
	}

	@Persistent
    private String preguntaNo10;
	
	public String getPreguntaNo10() {
		return preguntaNo10;
	}

	public void setPreguntaNo10(String preguntaNo10) {
		this.preguntaNo10 = preguntaNo10;
	}

	@Persistent
    private String preguntaNo11;
	
	public String getPreguntaNo11() {
		return preguntaNo11;
	}

	public void setPreguntaNo11(String preguntaNo11) {
		this.preguntaNo11 = preguntaNo11;
	}

	@Persistent
    private String preguntaNo12;
	
	public String getPreguntaNo12() {
		return preguntaNo12;
	}

	public void setPreguntaNo12(String preguntaNo12) {
		this.preguntaNo12 = preguntaNo12;
	}

	@Persistent
    private String preguntaNo13;
	
	public String getPreguntaNo13() {
		return preguntaNo13;
	}

	public void setPreguntaNo13(String preguntaNo13) {
		this.preguntaNo13 = preguntaNo13;
	}

	@Persistent
    private String preguntaNo14;
	
	public String getPreguntaNo14() {
		return preguntaNo14;
	}

	public void setPreguntaNo14(String preguntaNo14) {
		this.preguntaNo14 = preguntaNo14;
	}

	@Persistent
    private String preguntaNo15;
	
	public String getPreguntaNo15() {
		return preguntaNo15;
	}

	public void setPreguntaNo15(String preguntaNo15) {
		this.preguntaNo15 = preguntaNo15;
	}

	@Persistent
    private String preguntaNo16;

	public String getPreguntaNo16() {
		return preguntaNo16;
	}

	public void setPreguntaNo16(String preguntaNo16) {
		this.preguntaNo16 = preguntaNo16;
	}

	// Llave Foranea
	
	private long idFormulario;
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}

	// Relacion
	
	@Persistent
    private SegSolicitudGeneral solicitud;

	public SegSolicitudGeneral getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SegSolicitudGeneral solicitud) {
		this.solicitud = solicitud;
	}
    
}
