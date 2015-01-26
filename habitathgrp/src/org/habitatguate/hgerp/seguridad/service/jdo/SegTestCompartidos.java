package org.habitatguate.hgerp.seguridad.service.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SegTestCompartidos implements Serializable {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Key id;

	@Persistent
	private Long idTest;
	
	@Persistent    
	private Long idEmpleadoCompartido;
	
	@Persistent
    private SegEmpleado empleado;
	
	public SegTestCompartidos() {
	}

	public SegEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(SegEmpleado empleado) {
		this.empleado = empleado;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public Long getId_empleado() {
		return idEmpleadoCompartido;
	}

	public void setId_empleado(Long id_empleado) {
		this.idEmpleadoCompartido = id_empleado;
	}

	


}
