package org.habitatguate.hgerp.seguridad.client.rrhh;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxIdioma implements IsSerializable{
	
    private Long id_idioma;
	
	
    private String nivel;
	
	
    private String idioma;   
	

	public AuxIdioma() {
		super();
	}

	public Long getId_idioma() {
		return id_idioma;
	}

	public void setId_idioma(Long id_idioma) {
		this.id_idioma = id_idioma;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	
}
