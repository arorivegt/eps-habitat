package org.habitatguate.hgerp.seguridad.client.finanzas;




import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxParametro implements Comparable<AuxParametro>,IsSerializable{

	/**
     * The key provider that provides the unique ID of a contact.
     */
    public static final ProvidesKey<AuxParametro> KEY_PROVIDER = new ProvidesKey<AuxParametro>() {
      @Override
      public Object getKey(AuxParametro item) {
        return item == null ? null : item.getIdParametro();
      }
    };
    @Override
    public int compareTo(AuxParametro o) {
      return (o == null || o.idParametro == null) ? -1 : -o.idParametro.compareTo(idParametro);
    }
	
    


    
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
