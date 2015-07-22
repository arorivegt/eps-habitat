package org.habitatguate.hgerp.seguridad.client.auxjdo;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuxReporteCuentasPorPagar implements IsSerializable{

	private AuxSolucion auxSolucion;
	
	private List<AuxProveedor> listaProveedores;
	
	public AuxReporteCuentasPorPagar() {
		// TODO Auto-generated constructor stub
		auxSolucion = new AuxSolucion();
		listaProveedores = new ArrayList<AuxProveedor>();
	
	
	}
	public AuxSolucion getAuxSolucion() {
		return auxSolucion;
	}
	public void setAuxSolucion(AuxSolucion auxSolucion) {
		this.auxSolucion = auxSolucion;
	}
	public List<AuxProveedor> getListaProveedores() {
		return listaProveedores;
	}
	public void setListaProveedores(List<AuxProveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
	
	
}
