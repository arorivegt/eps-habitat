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
public class academico extends Composite  {

	
	 private FlexTable flextable;
	 private Empleados empleado;
	 private Button btnAgregar;
     private VerticalPanel panel = new VerticalPanel();
     private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
     
    /**
     * inicializa los componentes
     * @param empleado
     */
     public academico(Empleados empleado) 
	 {

			this.empleado = empleado;
			
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
	        flextable.setWidget(flextable.getRowCount(), 0, new formularioAcademico(this,empleado));
	}
	
	
	/**
	 * agrega un formulario academico al panel con datos del Datastore
	 * @param results
	 */
	public void agregarFormulario_lleno(List<AuxHistorialAcademico> results)
	{
		if (!results.isEmpty()) 
		{
			for ( AuxHistorialAcademico n2 : results) 
			{
				formularioAcademico fa = new formularioAcademico(this,empleado);
				fa.LlenarDatos(n2.getId_historial_academico(),n2.getFecha1(), n2.getFecha2(), 
						       n2.getTitulo(), n2.getEstablecimiento(),n2.getNivel_academico()
			    			, n2.getURLFile(), n2.getKeyFile());
			    flextable.setWidget(flextable.getRowCount(), 0,fa );
			 }
	    }	    
	}
	
	
	/**
	 * agrega un nuevo formulario acaedmico al panel y del datastore
	 * @param formularioAcademico
	 * @param id_empledo
	 * @param id_FormularioAcademico
	 */
	public void EliminarFormulario(final formularioAcademico formularioAcademico, final Long id_empledo, final Long id_FormularioAcademico)
	{
	
		loginService.Eliminar_Academico(id_empledo, id_FormularioAcademico, new AsyncCallback<Long>()
		{
	        public void onFailure(Throwable caught) 
	        {
	        	formularioAcademico.setMensaje("alert alert-error", "Error !! \nal ELiminar Formulario");
	        }
	
			@Override
	        public void onSuccess(Long resultLong)
	        {
	        	formularioAcademico.setMensaje("alert alert-success", "Eliminado Exitosamente");
		        flextable.remove(formularioAcademico);
	        }
	
		});
	}
	
	
	/**
	 *elimina un formulario del panel sin haberse guardado algo 
	 * @param formularioAcademico
	 */
	public void EliminarFormulario(formularioAcademico formularioAcademico)
	{
		flextable.remove(formularioAcademico);
	}
	    
}
