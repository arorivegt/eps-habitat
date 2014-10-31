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

public class Compartir extends Composite{
        
        
       private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
       private Long idTes = 0L;
       private Long idEmpleadoCompartido = 0L;
       final SuggestBox txtUser;
   	   private Mensaje mensaje; 
       private Loading load ;
   		
        public Compartir(Long idTest, Long id) 
        {
        	load = new Loading();
            load.Mostrar();
            load.invisible();
			mensaje = new Mensaje();
        	this.idEmpleadoCompartido = id;
        	this.idTes = idTest;
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
            
            Button button = new Button("Send");
            button.addClickHandler(new ClickHandler() {
            	public void onClick(ClickEvent event) {

                    load.visible();
            		 loginService.InsertarCompartido(txtUser.getText(),idTes,idEmpleadoCompartido,new AsyncCallback<String>()
					    {
				            public void onFailure(Throwable caught) 
				            {
						        load.invisible();
				            	mensaje.setMensaje("alert alert-error", 
			                			"Error !! \nal Compartir Evaluacion");
				            }
	
							public void onSuccess(String result)
				            {
						        load.invisible();
								mensaje.setMensaje("alert alert-success", result);
				            }
	
					    });

                     load.invisible();
            	}
            });
            button.setText("Aceptar");
            button.setStyleName("sendButton");
            rootPanel.add(button, 30, 143);
            button.setSize("243px", "44px");
            
            initWidget(rootPanel);
            
            Label lblNewLabel = new Label("Escribe el correo del Empleado, con quien quieres compartir el test:");
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