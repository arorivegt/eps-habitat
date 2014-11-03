package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class AsignarJefe extends Composite{
        
        
       private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
       final SuggestBox txtUser;
   	   private Mensaje mensaje; 
   	   private formularioDatos datos;
       private Loading load ;
   		
        public AsignarJefe(formularioDatos dato) 
        {
        	this.datos = dato;
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			mensaje = new Mensaje();
        	AbsolutePanel rootPanel = new AbsolutePanel();
        	rootPanel.setSize("299px", "199px");
            rootPanel.setStyleName("body");
            
            Label lblNewLabel_1 = new Label("");
            lblNewLabel_1.setStyleName("gwt-Label-new");
            rootPanel.add(lblNewLabel_1, 10, 5);
            lblNewLabel_1.setSize("205px", "142px");
            txtUser =new SuggestBox(createCountriesOracle());
            txtUser.setStyleName("gwt-PasswordTextBox");
            txtUser.getElement().setAttribute("placeHolder", "Ingrese correo");
            rootPanel.add(txtUser, 30, 86);
            txtUser.setSize("241px", "49px");
            
            Button btnAsignar = new Button("Send");
            btnAsignar.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {
                    load.visible();
            		 loginService.getIdEmpleado(txtUser.getText(),new AsyncCallback<Long>()
					    {
				            public void onFailure(Throwable caught) 
				            {
				                load.invisible();
				            	mensaje.setMensaje("alert alert-error", 
			                			"Error !! \nal No se encontro el Empleado que buscaba");
				            }
	
							public void onSuccess(Long result)
				            {
					            load.invisible();
								if(result == 0L){

					            	mensaje.setMensaje("alert alert-error", 
				                			"Error !! \n No se encontro el Empleado que buscaba asignar");
								}else{
									datos.setJefe(""+result);
									datos.setIdJefe(result);
								}
				            }
	
					    });
            	}
            });
            btnAsignar.setText("Asignar");
            btnAsignar.setStyleName("sendButton");
            rootPanel.add(btnAsignar, 30, 143);
            btnAsignar.setSize("243px", "44px");
            
            initWidget(rootPanel);
            
            Label lblNewLabel = new Label("Escriba el correo del jefe que va asignar a este empleado:");
            rootPanel.add(lblNewLabel, 30, 10);
            lblNewLabel.setSize("243px", "19px");
            

        }
        

	MultiWordSuggestOracle createCountriesOracle()
	{
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
	    loginService.getCorreos(new AsyncCallback<List<String>>()
	    {
            public void onFailure(Throwable caught) 
            {
            }

			public void onSuccess(List<String> result)
            {
				if(!result.isEmpty())
				{	
					for(String correo: result){
						oracle.add(correo);
					}
				}
            }

	    });
	    return oracle;
    }
       
}