package org.habitatguate.hgerp.seguridad.client.auxjdo;



import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

public class AuxCuentaBancariaProv  implements Comparable<AuxCuentaBancariaProv>,IsSerializable{
	
    public static final ProvidesKey<AuxCuentaBancariaProv> KEY_PROVIDER = new ProvidesKey<AuxCuentaBancariaProv>() {
        @Override
        public Object getKey(AuxCuentaBancariaProv item) {
          return item == null ? null : item.getIdCuentaBancariaProv();
        }
      };
      @Override
      public int compareTo(AuxCuentaBancariaProv o) {
        return (o == null || o.idCuentaBancariaProv == null) ? -1 : -o.idCuentaBancariaProv.compareTo(idCuentaBancariaProv);
      }
	
	private Long idCuentaBancariaProv;
	
	private String tipoPago;
	
	private String tipoCuentaBancaria;
	
	private String numeroCuentaBancaria;
	
	private String bancoCuentaBancaria;
	
	private String nombrePropietario;

	public Long getIdCuentaBancariaProv() {
		return idCuentaBancariaProv;
	}

	public void setIdCuentaBancariaProv(Long idCuentaBancariaProv) {
		this.idCuentaBancariaProv = idCuentaBancariaProv;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getTipoCuentaBancaria() {
		return tipoCuentaBancaria;
	}

	public void setTipoCuentaBancaria(String tipoCuentaBancaria) {
		this.tipoCuentaBancaria = tipoCuentaBancaria;
	}

	public String getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}

	public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}

	public String getBancoCuentaBancaria() {
		return bancoCuentaBancaria;
	}

	public void setBancoCuentaBancaria(String bancoCuentaBancaria) {
		this.bancoCuentaBancaria = bancoCuentaBancaria;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	
	
}
