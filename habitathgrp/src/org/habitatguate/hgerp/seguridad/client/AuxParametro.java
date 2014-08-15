package org.habitatguate.hgerp.seguridad.client;



import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxParametro implements IsSerializable {

	/**
     * The key provider that provides the unique ID of a contact.
     */
    public static final ProvidesKey<AuxParametro> KEY_PROVIDER = new ProvidesKey<AuxParametro>() {
      @Override
      public Object getKey(AuxParametro item) {
        return item == null ? null : item.getIdParametro();
      }
    };
	
	
	private Long idParametro;

	private String nomParametro;

	private int codContable;

	private int codUno;

	private int codDos;
	
	
	public AuxParametro(){
		super();
	
	}


	public Long getIdParametro() {
		return idParametro;
	}


	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}


	public String getNomParametro() {
		return nomParametro;
	}


	public void setNomParametro(String nomParametro) {
		this.nomParametro = nomParametro;
	}


	public int getCodContable() {
		return codContable;
	}


	public void setCodContable(int codContable) {
		this.codContable = codContable;
	}


	public int getCodUno() {
		return codUno;
	}


	public void setCodUno(int codUno) {
		this.codUno = codUno;
	}


	public int getCodDos() {
		return codDos;
	}


	public void setCodDos(int codDos) {
		this.codDos = codDos;
	}
	
}
