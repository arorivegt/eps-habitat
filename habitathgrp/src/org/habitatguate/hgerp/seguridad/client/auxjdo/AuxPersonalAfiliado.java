package org.habitatguate.hgerp.seguridad.client.auxjdo;

	
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxPersonalAfiliado implements Comparable<AuxPersonalAfiliado>,IsSerializable {
	
	/**

     * El KEY_PROVIDER es el que provee el ID de un contacto.
     */
    public static final ProvidesKey<AuxPersonalAfiliado> KEY_PROVIDER = new ProvidesKey<AuxPersonalAfiliado>() {
      @Override
      public Object getKey(AuxPersonalAfiliado item) {
        return item == null ? null : item.getIdPersonalAfiliado();
      }
    };
	    @Override
	    public int compareTo(AuxPersonalAfiliado o) {
	      return (o == null || o.idPersonalAfiliado == null) ? -1 : -o.idPersonalAfiliado.compareTo(idPersonalAfiliado);
	    }
	
    
    
    private Long idPersonalAfiliado;
	
	private String nombreAdministrador;
	
	private String nombreAsistenteAdmin;
	
	private String nombreContadorRegion;
	
	private String nombreEncargadoCheques;
	public Long getIdPersonalAfiliado() {
		return idPersonalAfiliado;
	}

	public void setIdPersonalAfiliado(Long idPersonalAfiliado) {
		this.idPersonalAfiliado = idPersonalAfiliado;
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getNombreAsistenteAdmin() {
		return nombreAsistenteAdmin;
	}

	public void setNombreAsistenteAdmin(String nombreAsistenteAdmin) {
		this.nombreAsistenteAdmin = nombreAsistenteAdmin;
	}

	public String getNombreContadorRegion() {
		return nombreContadorRegion;
	}

	public void setNombreContadorRegion(String nombreContadorRegion) {
		this.nombreContadorRegion = nombreContadorRegion;
	}

	public String getNombreEncargadoCheques() {
		return nombreEncargadoCheques;
	}

	public void setNombreEncargadoCheques(String nombreEncargadoCheques) {
		this.nombreEncargadoCheques = nombreEncargadoCheques;
	}
	
	

}
