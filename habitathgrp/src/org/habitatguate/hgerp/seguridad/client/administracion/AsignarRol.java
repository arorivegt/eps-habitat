package org.habitatguate.hgerp.seguridad.client.administracion;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
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
import com.google.gwt.user.client.ui.ListBox;
/**
 * 
 * @author Anibal Jose Rodriguez Orive
 *	tppEMarketing
 */
public class AsignarRol extends Composite{
	
	private Loading load ;
    private Mensaje mensaje; 
    private Button 	btnAsignar;
    private AbsolutePanel rootPanel;
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
    private SuggestBox txtUsuario;
    private ListBox listRol;
    private Label lblRol;
	
    public AsignarRol() 
    {
    	
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		mensaje = new Mensaje();
		
    	rootPanel = new AbsolutePanel();
    	rootPanel.setSize("297px", "323px");
        rootPanel.setStyleName("body");
        
        Label lblNewLabel_1 = new Label("");
        lblNewLabel_1.setStyleName("gwt-Label-new");
        rootPanel.add(lblNewLabel_1, 10, 5);
        lblNewLabel_1.setSize("207px", "215px");
        
        txtUsuario =  new SuggestBox(createCountriesOracle());
        txtUsuario.getElement().setAttribute("placeHolder", "Escriba el Usuario");
        txtUsuario.setStyleName("gwt-PasswordTextBox");
        rootPanel.add(txtUsuario, 30, 57);
        txtUsuario.setSize("241px", "49px");
        
        btnAsignar = new Button("Send");
        btnAsignar.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
                load.visible();
            	recursosHumanosService.obtenerUsuario(new AsyncCallback<String>() 
				{ 
            		public void onFailure(Throwable caught) {
            			load.invisible();
            			mensaje.setMensaje("alert alert-error", "Error !! \nal obtener Usuario");
            		}

					public void onSuccess(String result) {

						Long rol = Long.parseLong(listRol.getItemText(listRol.getSelectedIndex()));
	            		recursosHumanosService.CambiarRol(result, rol,new AsyncCallback<String>()
	    			    {
	    		            public void onFailure(Throwable caught) {
	    		                load.invisible();
	    		            	mensaje.setMensaje("alert alert-error", "Error !! \nal actualizar rol");
	    		            }
	    
	    					public void onSuccess(String result) {
	    			            load.invisible();
	    			            mensaje.setMensaje("alert alert-success", result);
	    		            }
	    
	    			    });
		            }

				});
        	}
        });
        
        listRol = new ListBox();
        AdministracionService.ObtenerUltimoROl(new AsyncCallback<Long>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-success", "Error al obtener rol\n"+caught);
    		}

			@Override
			public void onSuccess(Long result)
			{
				for(int i = 1; i <= result; i++){
					listRol.addItem(""+i);
				}
			}
		});
        listRol.setStyleName("gwt-TextBox2");
        rootPanel.add(listRol, 111, 149);
        listRol.setSize("67px", "39px");
        btnAsignar.setText("Asignar");
        btnAsignar.setStyleName("sendButton");
        rootPanel.add(btnAsignar, 30, 213);
        btnAsignar.setSize("243px", "44px");
        
        initWidget(rootPanel);
        
        Label lblNewLabel = new Label("Asignar rol");
        rootPanel.add(lblNewLabel, 105, 5);
        lblNewLabel.setSize("98px", "19px");
        
        lblRol = new Label("rol");
        lblRol.setStyleName("label");
        rootPanel.add(lblRol, 122, 130);
        lblRol.setSize("67px", "13px");
        

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