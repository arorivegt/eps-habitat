package org.habitatguate.hgerp.seguridad.client.auxjdo;



import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxContactoProv  implements Comparable<AuxContactoProv>,IsSerializable{
	
    public static final ProvidesKey<AuxContactoProv> KEY_PROVIDER = new ProvidesKey<AuxContactoProv>() {
        @Override
        public Object getKey(AuxContactoProv item) {
          return item == null ? null : item.getIdContactoProv();
        }
      };
      @Override
      public int compareTo(AuxContactoProv o) {
        return (o == null || o.idContactoProv == null) ? -1 : -o.idContactoProv.compareTo(idContactoProv);
      }
	
	private Long idContactoProv;
	
	private String nomContacto;
	
	private String puestoContacto;
	
	private String correoContacto;
	
	private String telContacto;
	
	private String cellphoneContacto;

	public Long getIdContactoProv() {
		return idContactoProv;
	}

	public void setIdContactoProv(Long idContactoProv) {
		this.idContactoProv = idContactoProv;
	}

	public String getNomContacto() {
		return nomContacto;
	}

	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	public String getPuestoContacto() {
		return puestoContacto;
	}

	public void setPuestoContacto(String puestoContacto) {
		this.puestoContacto = puestoContacto;
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public String getTelContacto() {
		return telContacto;
	}

	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}

	public String getCellphoneContacto() {
		return cellphoneContacto;
	}

	public void setCellphoneContacto(String cellphoneContacto) {
		this.cellphoneContacto = cellphoneContacto;
	}

	
	
}
