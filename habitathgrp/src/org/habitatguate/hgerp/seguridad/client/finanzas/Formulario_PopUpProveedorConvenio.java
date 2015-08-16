package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class Formulario_PopUpProveedorConvenio extends Composite{
	 private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	 private final UploadUrlServiceAsync uploadUrlService = GWT.create(UploadUrlService.class);
		
		private Label mensaje;
		final Button close= new Button("x");
		private Long idProveedor;
		private Long idAfiliado;
		
		
		private String KeyFile ="";
		private String URLFile ="";
		private Mensaje mensaje2;
		
		private FormPanel form;
		private VerticalPanel formElements;
		private FileUpload fileUpload;
		private Button button;
		
		
	
	public Formulario_PopUpProveedorConvenio(Long idProveedor, Long idAfiliado){
		 //TIPO DE PAGO
		 // 1. TRANSACCION
		 // 2. CHEQUE
		 this.idProveedor = idProveedor;
		 this.idAfiliado = idAfiliado;


		
		

		//this.idVale = idVale;
		mensaje = new Label("Formulario para subir convenio");
		close.addStyleName("close");
		initWidget(mensaje);
		mensaje.setSize("250px", "20px");
		getFormUrl();
		setMensaje();
	}
	
	public void setMensaje()
	{
		
        final DialogBox dialogo = new DialogBox();
        
           
        
        Button button = new Button("");
        button.setText("Finalizar");
        button.setStyleName("sendButton");
        button.setSize("200px", "25px");
        
        
        final HTML serverResponseLabel = new HTML();
      
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.setStyleName("gwt-Label-new");
        dialogVPanel.getElement().setAttribute("width", "100%");
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(close);
        dialogVPanel.add(this);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(getFormPanel());
        dialogVPanel.add(button);
        dialogo .setWidget(dialogVPanel);
        dialogo .setModal(true);
        dialogo .setGlassEnabled(true);
        dialogo .setAnimationEnabled(true);
        dialogo .center();
        dialogo .show();
        close.setFocus(true);
    
        close.addClickHandler(new ClickHandler() 
        {
        	public void onClick(ClickEvent event) {
        		dialogo.hide();
        	}
        });
        
    
        button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
				loginService.Actualizar_ProveedorConvenio(idProveedor,
						idAfiliado,KeyFile,URLFile,
						new AsyncCallback<Long>() {
							
							@Override
							public void onSuccess(Long result) {
								dialogo.hide();
								Window.alert("Se ha subido el convenio exitosamente");
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}
				}
				);

			

			}
		});
    }
	
	/**
	 * se obtiene un form, que contiene para subir archivos al blobStore
	 * @return
	 */
	private FormPanel getFormPanel() {
		if (form == null) {
			form = new FormPanel();
			form.setSize("357px", "59px");
			form.setAction("/upload");
			form.setEncoding(FormPanel.ENCODING_MULTIPART);
	        form.setMethod(FormPanel.METHOD_POST);
			form.setWidget(getFormElements());
			//form.add(getHidden());
			// add submit handler
	    form.addSubmitHandler(new SubmitHandler() {
				public void onSubmit(SubmitEvent event) {
					if (fileUpload.getFilename().length() == 0) {
						mensaje2.setMensaje("alert alert-info", 
	                			"Selecciono un archivo?");
						event.cancel();
					}
				}
			});
	    
	    // add submit complete handler
	    form.addSubmitCompleteHandler(new SubmitCompleteHandler() {
				public void onSubmitComplete(SubmitCompleteEvent event) {
					button.setEnabled(false);
					String results = event.getResults();
					try{
						int i = results.indexOf("key=");
						int j = results.indexOf("src=");
						//KeyFile = results.substring(i+4, results.length()-2);
						KeyFile = results.substring(i+4, j-1);
						i = results.indexOf("http");
						URLFile = results.substring(i, results.length()-2);
						//Window.alert(URLFile);
						//Window.alert(KeyFile);
						//pResponse.add(new HTML(results));
						getFormUrl();
						form.setVisible(false);
					//	Archivo();
					}catch(Exception e){
						mensaje2.setMensaje("alert alert-error", 
	                			"verifique que la imagen Pese menos de 1MB");
						
					}
				}
			});
	    
		}
		return form;
	}
	/**
	 * se agrega los elementos como fileupload, y boton a un panel
	 * @return
	 */
	private VerticalPanel getFormElements() {
		if (formElements == null) {
			formElements = new VerticalPanel();
			formElements.setSize("356px", "100%");
			formElements.add(getFileUpload());
			formElements.add(getButton());
		}
		return formElements;
	}
	/**
	 * se crea un file ulpoad
	 * @return
	 */
	private FileUpload getFileUpload() {
		if (fileUpload == null) {
			fileUpload = new FileUpload();
			fileUpload.setWidth("200px");
			fileUpload.setName("myFile");
			fileUpload.getElement().setAttribute("accept", "application/pdf");
		}
		return fileUpload;
	}
	/**
	 * se crea un boton para el form para subir archivos
	 * @return
	 */
	private Button getButton() {
		if (button == null) {
			button = new Button("Subir");
			button.setHeight("31px");
			button.setStyleName("sendButton");
			button.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					
					form.submit();
					
				}
			});
			button.setEnabled(false);
		}
		return button;
	}
	/**
	 * se realiza el procedimiento para subir el archivo y crear una URL
	 */
	private void getFormUrl() {
		
		uploadUrlService.getUploadUrl(new AsyncCallback<String>() {
			public void onSuccess(String url) {
				form.setAction(url);
				button.setEnabled(true);
				//System.out.println("retrieved url for blob store: " + url);
			}

			public void onFailure(Throwable caught) {
		        
				mensaje2.setMensaje("alert alert-error", 
            			"Error !! \nen el servicio");
			}
		});
		
	}
	/**
	 * se obtiene el archivo, tanto el key, como la URL
	 */
	/*public void Archivo(){

		form.setVisible(false);
		grid = new Grid(1, 2);
		absolutePanel.add(grid, 580, 109);
		grid.setSize("357px", "59px");
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setHeight("27px");
		grid.setVisible(true);
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
	/*			recursosHumanosService.remove(getKeyFile() , new AsyncCallback<String>(){
					@Override
					public void onFailure(Throwable caught) {
					}
					@Override
					public void onSuccess(String result) {
						form.setVisible(true);
						grid.setVisible(false);
						KeyFile = "";
						URLFile = "";
					}

                });
			}
		});

		
		grid.setWidget(0, 1, btnEliminar);
		grid.setWidget(0, 0, new HTML("<a  target=\"_blank\" href=" + URLFile +">Ver</a>"));
	}*/
	
	

}
