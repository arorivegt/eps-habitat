package org.habitatguate.hgerp.seguridad.client.auxjdo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxIdioma implements IsSerializable{
	
    private Long id_idioma;
	
    private String nivel;
	
    private String idioma;   
  
    private String URLFile;
    
    private String KeyFile;

	

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

	
}
