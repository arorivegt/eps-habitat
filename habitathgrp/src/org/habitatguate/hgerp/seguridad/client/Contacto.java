package org.habitatguate.hgerp.seguridad.client;



 import java.util.Date;
 
 /** Modelo. Se recomienda que los modelos solo contengan referencias para que
  * interactúen más fácilmente con las vistas. */
 public class Contacto {
   private Integer clave;
   private String nombre;
   private String telefono;
   private Date nacimiento;
   public Contacto() {
   }
   public Contacto(Integer clave, String nombre, String telefono, Date nacimiento) {
     this.clave = clave;
     this.nombre = nombre;
     this.telefono = telefono;
     this.nacimiento = nacimiento;
   }
   public Integer getClave() {
    return clave;
   }
   public void setClave(Integer clave) {
     this.clave = clave;
   }
   public String getNombre() {
     return nombre;
   }
   public void setNombre(String nombre) {
     this.nombre = nombre;
   }
   public String getTelefono() {
     return telefono;
   }
   public void setTelefono(String telefono) {
     this.telefono = telefono;
   }
   public Date getNacimiento() {
     return nacimiento;
   }
   public void setNacimiento(Date nacimiento) {
     this.nacimiento = nacimiento;
   }
   @Override
   public boolean equals(Object obj) {
     if (obj != null && getClass() == obj.getClass()) {
       final Contacto otra = (Contacto) obj;
       return getClave() == otra.getClave();
     } else {
       return false;
     }
   }
   @Override
   public int hashCode() {
     return 93 * getClave();
   }
 }
