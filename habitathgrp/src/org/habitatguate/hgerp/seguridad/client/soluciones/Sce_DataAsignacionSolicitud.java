package org.habitatguate.hgerp.seguridad.client.soluciones;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.ListBox;

public class Sce_DataAsignacionSolicitud extends Composite{
	
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	
	private Loading load ;
    private Mensaje mensaje; 
    private Button 	btnAsignar;
    private AbsolutePanel rootPanel;    
    private SuggestBox txtUsuario;
    
	// Llaves
	private Long idEmpleado = 0L;
	private String usrName = "";
    
	private Long idFormularioAsignar = 0L;
	private Long idEmpleadoAsignar = 0L;
	private String usrNameAsignar = "";
	
    public Sce_DataAsignacionSolicitud(final Long idFormulario) 
    {
    	
    	this.idFormularioAsignar = idFormulario;

		// Obtener Id Empleado y UserName (eMail)
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) 
			{
				idEmpleado = result;				

				solucionesService.consultaEmpleadoRegistrado(idEmpleado, new AsyncCallback<AuxEmpleado>(){
					public void onFailure(Throwable caught) 
					{
						mensaje.setMensaje("alert alert-information alert-block", 
								"\nNo hay resultados");
					}

					@Override
					public void onSuccess(AuxEmpleado result)
					{	
						usrName = result.getEmail();
						
						System.out.println("ID Empleado: " + idEmpleado + ", Nombre de Usuario: " + usrName);
					}
				});
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
    	
    	load = new Loading();
    	load.Mostrar();
    	load.invisible();

    	mensaje = new Mensaje();

    	rootPanel = new AbsolutePanel();
    	rootPanel.setSize("297px", "261px");
    	rootPanel.setStyleName("body");

    	Label lblNewLabel_1 = new Label("");
    	lblNewLabel_1.setStyleName("gwt-Label-new");
    	rootPanel.add(lblNewLabel_1, 10, 5);
    	lblNewLabel_1.setSize("207px", "167px");

    	txtUsuario =  new SuggestBox(createCountriesOracle());
    	txtUsuario.getElement().setAttribute("placeHolder", "Escriba el Usuario");
    	txtUsuario.setStyleName("gwt-PasswordTextBox");
    	rootPanel.add(txtUsuario, 30, 80);
    	txtUsuario.setSize("241px", "49px");

    	btnAsignar = new Button("Send");
    	btnAsignar.addClickHandler(new ClickHandler() {
    		public void onClick(ClickEvent event) {

    			load.visible();
    			
    			solucionesService.consultaEmpleadoAsignacion(txtUsuario.getText(), new AsyncCallback<AuxEmpleado>(){ 

    				public void onFailure(Throwable caught) {
    					load.invisible();
    					mensaje.setMensaje("alert alert-error", "Error !! \nal obtener Usuario");
    				}

    				public void onSuccess(AuxEmpleado result) {

    					idEmpleadoAsignar = result.getId_empleado();
    					usrNameAsignar = result.getEmail();
    					
    					System.out.println("ID empleado a Asignar: " + idEmpleadoAsignar + ", User Name: " + usrNameAsignar + ", Del Formulario: " + idFormularioAsignar + ", Usuario Asignador: " + usrName);

    					solucionesService.asignarSolicitud(idFormularioAsignar, idEmpleadoAsignar, usrNameAsignar, new AsyncCallback<String>()
    					{
    						
    						public void onFailure(Throwable caught) {
    							load.invisible();
    							mensaje.setMensaje("alert alert-error", "Error !! \nal actualizar rol");
    						}

    						public void onSuccess(String result) {
    							load.invisible();
    							mensaje.setMensaje("alert alert-success", result);
    							
    							Window.Location.reload();
    						}

    					});

    				}

    			});
    		}
    	});
    	btnAsignar.setText("Asignar");
    	btnAsignar.setStyleName("sendButton");
    	rootPanel.add(btnAsignar, 30, 160);
    	btnAsignar.setSize("243px", "44px");

    	initWidget(rootPanel);

    	Label lblAsignacion = new Label("Asignacion Solicitud");
    	rootPanel.add(lblAsignacion, 59, 23);
    	lblAsignacion.setSize("185px", "19px");


    }
    
    MultiWordSuggestOracle createCountriesOracle()
	{
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
	    recursosHumanosService.getCorreos(new AsyncCallback<List<String>>()
	    {
            public void onFailure(Throwable caught) 
            {
            }

			public void onSuccess(List<String> listCorreos)
            {
				if(!listCorreos.isEmpty())
				{	
					for(String correo: listCorreos){
						oracle.add(correo);
					}
				}
            }

	    });
	    return oracle;
    }
        
}