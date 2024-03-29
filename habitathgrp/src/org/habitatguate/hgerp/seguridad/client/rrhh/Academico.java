/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialAcademico;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
/**
 * clase que contiene los formularios academicos
 * @author arodriguez
 *
 */
public class Academico extends Composite  {


	 private Mensaje mensaje; 
	 private Loading load ;
	 private Button btnAgregar;
	 private Empleado empleado;
	 private FlexTable flextable;
	 boolean valor = true;
     private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
     
    /**
     * inicializa los componentes
     * @param empleado
     */
     public Academico(Empleado empleado) 
	 {

			this.empleado = empleado;
			mensaje = new Mensaje();
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			
	        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	        panel.setSize("761px", "85px");
	        
	        flextable = new FlexTable();
	        panel.add(flextable);
	        
	        btnAgregar = new Button("Agregar");
	        btnAgregar.setStyleName("sendButton");
	        btnAgregar.addClickHandler(new ClickHandler() {
	        	public void onClick(ClickEvent event) {
	        		agregarFormulario();
	        	}
	        });
	        panel.add(btnAgregar);
	        btnAgregar.setSize("227px", "34px");
	        
	        initWidget(panel);
	}
     /**
      * /agrega un nuevo formulario acaedmico al panel
      */
	private void agregarFormulario()
	{
		if(valor){
	        load.visible();
	        flextable.setWidget(flextable.getRowCount(), 0, new FormularioAcademico(this,empleado));
	        load.invisible();
	    }
	}
	
	
	/**
	 * agrega un formulario academico al panel con datos del Datastore
	 * @param results
	 */
	public void agregarFormulario_lleno(List<AuxHistorialAcademico> results)
	{
        load.visible();
		if (!results.isEmpty()) 
		{
			for ( AuxHistorialAcademico n2 : results) 
			{
				FormularioAcademico fa = new FormularioAcademico(this,empleado);
				fa.LlenarDatos(n2.getId_historial_academico(),n2.getFecha1(), n2.getFecha2(), 
						       n2.getTitulo(), n2.getEstablecimiento(),n2.getNivel_academico()
						       ,n2.getURLFile(), n2.getKeyFile());
				fa.btnhinabilitar(valor);
			    flextable.setWidget(flextable.getRowCount(), 0,fa );
			 }
	    }	  
        load.invisible();  
	}
	
	
	/**
	 * agrega un nuevo formulario acaedmico al panel y del datastore
	 * @param formularioAcademico
	 * @param id_empledo
	 * @param id_FormularioAcademico
	 */
	public void EliminarFormulario(final FormularioAcademico formularioAcademico, final Long id_empledo, final Long id_FormularioAcademico)
	{

        load.visible();
		recursosHumanosService.Eliminar_Academico(id_empledo, id_FormularioAcademico, new AsyncCallback<Long>()
		{
	        public void onFailure(Throwable caught) 
	        {
	        	mensaje.setMensaje("alert alert-error", "Error !! \nal ELiminar Formulario");
	        }
	
			@Override
	        public void onSuccess(Long resultLong)
	        {
				mensaje.setMensaje("alert alert-success", "Eliminado Exitosamente");
		        flextable.remove(formularioAcademico);
	        }
	
		});
        load.invisible();
	}
	
	
	/**
	 *elimina un formulario del panel sin haberse guardado algo 
	 * @param formularioAcademico
	 */
	public void EliminarFormulario(FormularioAcademico formularioAcademico)
	{
        load.visible();
		flextable.remove(formularioAcademico);
        load.invisible();
	}
	    
}
