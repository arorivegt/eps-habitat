package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Compartir extends Composite{
        
        
       private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
       private Long idTes = 0L;
       private Long idEmpleadoCompartido = 0L;
       final SuggestBox txtUser;
        public Compartir(Long idTest, Long id) 
        {
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
            		 loginService.InsertarCompartido(txtUser.getText(),idTes,idEmpleadoCompartido,new AsyncCallback<String>()
					    {
				            public void onFailure(Throwable caught) 
				            {
			                	setMensaje("alert alert-error", 
			                			"Error !! \nal Compartir Evaluacion");
				            }
	
							public void onSuccess(String result)
				            {
			                	setMensaje("alert alert-success", result);
				            }
	
					    });
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
        public void setMensaje(String estilo, String mensaje){
            final DialogBox Registro2 = new DialogBox();
            final HTML serverResponseLabel = new HTML();
            final Button close= new Button("x");
            Mensaje inicio = new Mensaje();
            
            Registro2.setStyleName(estilo);
            inicio.mensajeEntrada(mensaje);
            inicio.mensajeEstilo(estilo);
            close.addStyleName("close");
            VerticalPanel dialogVPanel = new VerticalPanel();
            dialogVPanel.add(serverResponseLabel );
            dialogVPanel.add(inicio);
            dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
            dialogVPanel.add(close);
            Registro2 .setWidget(dialogVPanel);
            Registro2 .setModal(true);
            Registro2 .setGlassEnabled(true);
            Registro2 .setAnimationEnabled(true);
            Registro2 .center();
            Registro2 .show();
            close.setFocus(true);
        
            close.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Registro2.hide();
            }
            });
        }
}