package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;

public class Sce_DataSupervisionCuarta extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryBitacoraSolicitud formulario;
	private Sce_DataEntrySupervisionCuarta supervisionCuarta;
    private boolean bandera = true;
	private Long idSupervisionCuarta = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	private TextArea txtObservaciones;
	private TextArea txtAcciones;
	private CheckBox checkSatisfactoria;
	private CheckBox checkNoSatisfactoria;
	private DateBox txtFechaVisita;
	private Button btnGuardar;
	private TextBox txtRepresentante;
	private Label label;
	private Label label_1;
	private Label label_2;
	private TextBox txtAlbanil;
	private TextBox txtPromotor;
	
	private FormPanel form;
	private FileUpload fileUpload;
	private Button button;
	private String URLFile ="";
	private String KeyFile ="";
	private VerticalPanel formElements;
    private Loading load ;
	private final UploadUrlServiceAsync uploadUrlService = GWT.create(UploadUrlService.class);
	private Grid grid;
	private Image image ;
    private Label lblSeleccioneUnaImagen;
    
	public Sce_DataSupervisionCuarta(Sce_DataEntrySupervisionCuarta a, Sce_DataEntryBitacoraSolicitud e) {
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.supervisionCuarta = a;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "630px");
		
		// ---
		
		getFormUrl();

		image = new Image("images/imagenempresa.png");
		image.setSize("167px", "158px");
		absolutePanel.add(image, 811, 424);
		absolutePanel.add(getFormPanel(), 596, 43);
		
		lblSeleccioneUnaImagen = new Label("Seleccione una imagen no mayor a 1MB");
		lblSeleccioneUnaImagen.setStyleName("label");
		absolutePanel.add(lblSeleccioneUnaImagen, 596, 10);
		lblSeleccioneUnaImagen.setSize("357px", "19px");
		
		// ---
		
		txtObservaciones = new TextArea();
		absolutePanel.add(txtObservaciones, 42, 134);
		txtObservaciones.setSize("857px", "69px");
		
		txtFechaVisita = new DateBox();
		txtFechaVisita.setValue(new Date());
		txtFechaVisita.getTextBox().setReadOnly(true);
		txtFechaVisita.setFireNullValues(true);
		txtFechaVisita.setStyleName("gwt-PasswordTextBox");
		txtFechaVisita.getDatePicker().setYearArrowsVisible(true);
		txtFechaVisita.getDatePicker().setYearAndMonthDropdownVisible(true);
		txtFechaVisita.getDatePicker().setVisibleYearCount(100);
		absolutePanel.add(txtFechaVisita, 232, 36);
		txtFechaVisita.setFormat(new DateBox.DefaultFormat (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		
		txtAcciones = new TextArea();
		absolutePanel.add(txtAcciones, 42, 257);
		txtAcciones.setSize("857px", "69px");
		
		checkSatisfactoria = new CheckBox("Satisfactoria");
		absolutePanel.add(checkSatisfactoria, 232, 361);
		checkSatisfactoria.setSize("141px", "24px");
		
		checkNoSatisfactoria = new CheckBox("No Satisfactoria");
		absolutePanel.add(checkNoSatisfactoria, 379, 361);
		checkNoSatisfactoria.setSize("161px", "24px");
		
		Label lblFechaDeVisita = new Label("Fecha de Visita IV:");
		lblFechaDeVisita.setStyleName("label");
		absolutePanel.add(lblFechaDeVisita, 42, 36);
		lblFechaDeVisita.setSize("148px", "19px");
		
		Label lblAcciones = new Label("Acciones");
		lblAcciones.setStyleName("label");
		absolutePanel.add(lblAcciones, 42, 232);
		lblAcciones.setSize("171px", "19px");
		
		Label lblSupervision = new Label("Supervision");
		lblSupervision.setStyleName("label");
		absolutePanel.add(lblSupervision, 42, 366);
		lblSupervision.setSize("133px", "19px");
		
		Label lblIndiqueLosBienes = new Label("Observaciones:");
		lblIndiqueLosBienes.setStyleName("label");
		absolutePanel.add(lblIndiqueLosBienes, 42, 109);
		lblIndiqueLosBienes.setSize("171px", "19px");
		
		label_2 = new Label("Promotor:");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 42, 469);
		label_2.setSize("133px", "19px");
		
		label_1 = new Label("Albañil:");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 42, 514);
		label_1.setSize("133px", "19px");
		
		label = new Label("Representante de Familia:");
		label.setStyleName("label");
		absolutePanel.add(label, 42, 558);
		label.setSize("208px", "19px");
		
		txtPromotor = new TextBox();
		txtPromotor.setStylePrimaryName("gwt-TextBox2");
		txtPromotor.setStyleName("gwt-TextBox2");
		txtPromotor.setMaxLength(200);
		absolutePanel.add(txtPromotor, 275, 467);
		txtPromotor.setSize("386px", "19px");
		
		txtAlbanil = new TextBox();
		txtAlbanil.setStylePrimaryName("gwt-TextBox2");
		txtAlbanil.setStyleName("gwt-TextBox2");
		txtAlbanil.setMaxLength(200);
		absolutePanel.add(txtAlbanil, 275, 512);
		txtAlbanil.setSize("386px", "19px");
		
		txtRepresentante = new TextBox();
		txtRepresentante.setStylePrimaryName("gwt-TextBox2");
		txtRepresentante.setStyleName("gwt-TextBox2");
		txtRepresentante.setMaxLength(200);
		absolutePanel.add(txtRepresentante, 275, 556);
		txtRepresentante.setSize("386px", "19px");
		
		// -- Boton Guardar/Actualizar Informacion
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				Date fechaVisita = new Date();
				fechaVisita = txtFechaVisita.getValue();
				
				Boolean checkSatisfactoriaValue = false;
				checkSatisfactoriaValue = checkSatisfactoria.getValue();
				
				Boolean checkNoSatisfactoriaValue = false;
				checkNoSatisfactoriaValue = checkNoSatisfactoria.getValue();
				
				String observaciones = "";		
				if(txtObservaciones.getText() == null){
					observaciones = "";
				}else{
					observaciones = txtObservaciones.getText();
				}

				String acciones = "";		
				if(txtAcciones.getText() == null){
					acciones = "";
				}else{
					acciones = txtAcciones.getText();
				}
				
				String promotor = "";
				if(txtPromotor.getText() == null){
					promotor = "";
				}else{
					promotor = txtPromotor.getText();
				}
				
				String albanil = "";
				if(txtAlbanil.getText() == null){
					albanil = "";
				}else{
					albanil = txtAlbanil.getText();
				}
				
				String representante = "";
				if(txtRepresentante.getText() == null){
					representante = "";
				}else{
					representante = txtRepresentante.getText();
				}
				
				Date time = new Date();
				@SuppressWarnings("deprecation")
				Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());
				
				if(bandera){

					solucionesService.ingresarSupervisionCuarta(fecrec, formulario.idFormulario, 
							fechaVisita,
							observaciones, acciones,
							checkSatisfactoriaValue, checkNoSatisfactoriaValue,
							promotor, albanil, representante,
							URLFile, KeyFile,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje = new Mensaje();
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden almacenarse");
						}

						public void onSuccess(Long result)
						{
							mensaje = new Mensaje();
							mensaje.setMensaje("alert alert-info", "Registro almacenado exitosamente");

							idSupervisionCuarta = result;
							System.out.println("Valor de NUEVA CUARTA Supervision: " + idSupervisionCuarta);
							bandera = false;
							
						}
					});

				}else{
					
					solucionesService.actualizarSupervisionCuarta(formulario.idFormulario, idSupervisionCuarta, 
							fechaVisita,
							observaciones, acciones,
							checkSatisfactoriaValue, checkNoSatisfactoriaValue,
							promotor, albanil, representante,
							URLFile, KeyFile,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de DATOS DE CUARTA SUPERVISION: " + idSupervisionCuarta );
							bandera = false;

						}
					});
					
				}
				
			}
		});
		
		btnGuardar.setText("Guardar");
		absolutePanel.add(btnGuardar, 471, 614);
				
	}
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
			Long fechaVisita,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria,
			String promotor, String albanil, String representante,
			String URLFile, String KeyFile)
	{
    	
		this.bandera = false;
		
		this.idSupervisionCuarta = id; // ID Formulario Cargado
		
		this.txtFechaVisita.setValue(new Date(fechaVisita));
		this.txtObservaciones.setValue(observaciones);
		this.txtAcciones.setValue(acciones);
		this.checkSatisfactoria.setValue(satisfactoria);
		this.checkNoSatisfactoria.setValue(noSatisfactoria);
		this.txtPromotor.setValue(promotor);
		this.txtAlbanil.setValue(albanil);
		this.txtRepresentante.setValue(representante);
		
		this.KeyFile = KeyFile;
		this.URLFile = URLFile;
	    	
		try{
			image.setUrl(URLFile);
			Archivo();
		}catch(Exception e){
			image.setUrl("images/imagenempresa.png");
		}
	    
	}
	
    
	// --- SUBIDA DE ARCHIVOS A BLOBSTORE

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
						mensaje.setMensaje("alert alert-info", 
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
						KeyFile = results.substring(i+4, results.length()-2);
						i = results.indexOf("http");
						URLFile = results.substring(i, results.length()-2);
						//Window.alert(URLFile);
						//Window.alert(KeyFile);
						//pResponse.add(new HTML(results));
						getFormUrl();
						form.setVisible(false);
						Archivo();
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
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
			fileUpload.setWidth("357px");
			fileUpload.setName("myFile");
			fileUpload.getElement().setAttribute("accept", "image/*");
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
					load.visible();
					form.submit();
					load.invisible();
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
				System.out.println("retrieved url for blob store: " + url);
			}

			public void onFailure(Throwable caught) {
		        load.invisible();
				mensaje.setMensaje("alert alert-error", 
            			"Error !! \nen el servicio");
			}
		});
		
	}
	/**
	 * se obtiene el archivo, tanto el key, como la URL
	 */
	public void Archivo(){

		form.setVisible(false);
		grid = new Grid(1, 2);
//		absolutePanel.add(grid, 580, 109);
		absolutePanel.add(grid, 811, 600);
		grid.setSize("357px", "59px");
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setHeight("27px");
		grid.setVisible(true);
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				solucionesService.remove(getKeyFile() , new AsyncCallback<String>(){
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

		image.setUrl(URLFile);
		grid.setWidget(0, 1, btnEliminar);
		grid.setWidget(0, 0, new HTML("<a  target=\"_blank\" href=" + URLFile +">Ver</a>"));
	}

	/**
	 * 
	 * @return
	 */
		public String getURLFile() {
			return URLFile;
		}
	/**
	 * 
	 * @param uRLFile
	 */
		public void setURLFile(String uRLFile) {
			URLFile = uRLFile;
		}

	/**
	 * 
	 * @return
	 */
		public String getKeyFile() {
			return KeyFile;
		}
	/**
	 * 
	 * @param keyFile
	 */
		public void setKeyFile(String keyFile) {
			KeyFile = keyFile;
		}		
		
}
