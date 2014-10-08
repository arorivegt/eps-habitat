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
public class SegSalario implements Serializable {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key id_Salario;
	
	@Persistent
	private Date Fecha;
	
	@Persistent
	private float salario;
	
	@Persistent
    private SegEmpleado empleado;

	public SegSalario() {
		super();
	}

	public Long getId_Salario() {
		return id_Salario.getId();
	}


	public Date getFecha() {
		return Fecha;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}

	
	
}
