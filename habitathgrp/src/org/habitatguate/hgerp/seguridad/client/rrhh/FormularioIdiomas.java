/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
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
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class FormularioIdiomas extends Composite {

	private Idioma a;
	private Empleado empleado;
	private Long id_idioma = 0L;
	private boolean bandera = true;
    private ListBox listNivel;
    private ListBox txtIdioma;
    private FormPanel form;
	private Button button;
	private Grid grid;
	private Mensaje mensaje; 
	private String URLFile ="";
	private String KeyFile ="";
	private FileUpload fileUpload;
	private VerticalPanel formElements;
	private AbsolutePanel absolutePanel;
	private Button btnEliminar;
	private Button btnActualizar;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private Loading load ;

	private final UploadUrlServiceAsync uploadUrlService = GWT.create(UploadUrlService.class);
    
	public FormularioIdiomas(Idioma a,Empleado e) {

		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.empleado = e;
		this.a = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("663px", "100px");
		
		txtIdioma = new ListBox();
		txtIdioma.addItem("Achi","1");
		txtIdioma.addItem("Akateko","2");
		txtIdioma.addItem("Awakateko","3");
		txtIdioma.addItem("Ch'orti","4");
		txtIdioma.addItem("Chuj","5");
		txtIdioma.addItem("Itza","6");
		txtIdioma.addItem("Ixil","7");
		txtIdioma.addItem("Jakalteko","8");
		txtIdioma.addItem("Kaqchiquel","9");
		txtIdioma.addItem("Kiche","10");
		txtIdioma.addItem("Mam","11");
		txtIdioma.addItem("Mopan","12");
		txtIdioma.addItem("Poqoman","13");
		txtIdioma.addItem("Poqomchi","14");
		txtIdioma.addItem("Q'anjob'al","15");
		txtIdioma.addItem("Q'eqchi","16");
		txtIdioma.addItem("Sakapulteko","17");
		txtIdioma.addItem("Sipakapense","18");
		txtIdioma.addItem("Tektiteko","19");
		txtIdioma.addItem("tz'utujil","20");
		txtIdioma.addItem("Uspanteko","21");
		txtIdioma.addItem("Garifuna","22");
		txtIdioma.addItem("Español","23");
		txtIdioma.addItem("Ingles","24");
		txtIdioma.addItem("Frances","25");
		txtIdioma.addItem("Aleman","26");
		txtIdioma.addItem("Italiano","27");
		txtIdioma.addItem("Coreano","28");
		txtIdioma.addItem("Japones","29");
		txtIdioma.addItem("Mandarin","30");
		txtIdioma.addItem("Cantones","31");
		txtIdioma.addItem("Tailandes","32");
		txtIdioma.addItem("Portugues","33");
		txtIdioma.addItem("Arabe","34");
		txtIdioma.addItem("Hebreo","35");
		txtIdioma.addItem("Griego","36");
		txtIdioma.addItem("Neerlandes","37");
		txtIdioma.addItem("Otros","38");
		txtIdioma.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtIdioma, 10, 29);
		txtIdioma.setSize("115px", "34px");
		
		listNivel = new ListBox();
		listNivel.addItem("Avanzado","0");
		listNivel.addItem("Intermedio","1");
		listNivel.addItem("Principiante","2");
		listNivel.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNivel, 146, 27);
		listNivel.setSize("115px", "36px");
		absolutePanel.add(getFormPanel(), 294, 30);
		getFormUrl();

		btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				if(bandera) {
					loginService.Insertar_Idioma(empleado.id_empleado, listNivel.getValue(listNivel.getSelectedIndex()), 
							txtIdioma.getValue(txtIdioma.getSelectedIndex()), URLFile, KeyFile,new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
					        load.invisible();
							id_idioma = result;
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        }
						});
				}else{
					loginService.Actualizar_Idioma(empleado.id_empleado,id_idioma, listNivel.getValue(listNivel.getSelectedIndex()), 
							txtIdioma.getValue(txtIdioma.getSelectedIndex()),URLFile, KeyFile, new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Actualizar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
					        load.invisible();
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
		                			"Datos Actualizados\n exitosamente!!!");
                        }
						});
				}
		        load.invisible();
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 10, 92);
		btnActualizar.setSize("115px", "34px");
		
		
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormularioSinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 146, 92);
		btnEliminar.setSize("115px", "34px");
		
		Label lblNivelAcademico = new Label("Idioma");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Nivel");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 146, 8);
		lblTitulodiploma.setSize("192px", "13px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado,id_idioma);
        if(!getKeyFile().equals(""))
        {
        	loginService.remove(getKeyFile() , new AsyncCallback<String>(){
        		@Override
        		public void onFailure(Throwable caught) {
        		}
        		@Override
        		public void onSuccess(String result) {
        		}

        	});
        }
    }
	private void EliminarFormularioSinDatos(){
        a.EliminarFormulario(this);
    }
	public void LlenarDatos(Long id, String listNivel, String txtIdioma,String  URLFile, 
		    String KeyFile)
	{

		this.KeyFile = KeyFile;
		this.URLFile = URLFile;
		//Window.alert("llenar datos"+URLFile);
		//Window.alert("llenar datos"+this.URLFile);
		if(!URLFile.equals(""))
			Archivo();
		this.id_idioma = id;
		this.bandera = false;
		boolean bandera = true;
		for(int i=0; i < this.listNivel.getItemCount() && bandera; i++){
			bandera = !this.listNivel.getValue(i).equals(listNivel);
		    this.listNivel.setSelectedIndex(i);
		}
		 bandera = true;
		for(int i=0; i < this.txtIdioma.getItemCount() && bandera; i++){
			bandera = !this.txtIdioma.getValue(i).equals(txtIdioma);
		    this.txtIdioma.setSelectedIndex(i);
		}
		
	}
	
	private FormPanel getFormPanel() {
		if (form == null) {
			form = new FormPanel();
			form.setSize("357px", "85px");
			form.setAction("/upload");
			form.setEncoding(FormPanel.ENCODING_MULTIPART);
			form.setMethod(FormPanel.METHOD_POST);
			form.setWidget(getFormElements());
			//form.add(getHidden());
			
			// add submit handler
	    form.addSubmitHandler(new SubmitHandler() {
				public void onSubmit(SubmitEvent event) {
					if (fileUpload.getFilename().length() == 0 || fileUpload.getFilename().indexOf("pdf") == -1) {
				        load.invisible();
						mensaje.setMensaje("alert alert-info", 
	                			"Selecciono un archivo o la extension no es correcta?");
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
						int j = results.indexOf("\" type");
						KeyFile = results.substring(i+4, j);
						i = results.indexOf("http");
						URLFile = results.substring(i, j);
						//Window.alert(URLFile);
						//Window.alert(KeyFile);
						//pResponse.add(new HTML(results));
						getFormUrl();
						form.setVisible(false);
						Archivo();
					}catch(Exception e){
				        load.invisible();
						mensaje.setMensaje("alert alert-error", "verifique que el documento Pese menos de 1MB");
						
					}
				}
			});
	    
		}
		return form;
	}
	
	private VerticalPanel getFormElements() {
		if (formElements == null) {
			formElements = new VerticalPanel();
			formElements.setSize("356px", "100%");
			formElements.add(getFileUpload());
			formElements.add(getButton());
		}
		return formElements;
	}
	
	private FileUpload getFileUpload() {
		if (fileUpload == null) {
			fileUpload = new FileUpload();
			fileUpload.setStyleName("gwt-TextBox2");
			fileUpload.setWidth("357px");
			fileUpload.setName("myFile");
			fileUpload.getElement().setAttribute("accept", "application/pdf");
		}
		return fileUpload;
	}
	
	private Button getButton() {
		if (button == null) {
			button = new Button("Subir");
			button.setHeight("27px");
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
	
	private void getFormUrl() {
		
		uploadUrlService.getUploadUrl(new AsyncCallback<String>() {
			public void onSuccess(String url) {
				form.setAction(url);
				button.setEnabled(true);
			}

			public void onFailure(Throwable caught) {
		        load.invisible();
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nen el servicio");
			}
		});
		
	}

	public void Archivo(){

		form.setVisible(false);
		grid = new Grid(1, 2);
		absolutePanel.add(grid,  527, 10);
		grid.setSize("357px", "59px");
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setHeight("27px");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				loginService.remove(getKeyFile() , new AsyncCallback<String>(){
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
	}

	public String getURLFile() {
		return URLFile;
	}

	public void setURLFile(String uRLFile) {
		URLFile = uRLFile;
	}

	public String getKeyFile() {
		return KeyFile;
	}

	public void setKeyFile(String keyFile) {
		KeyFile = keyFile;
	}

}
