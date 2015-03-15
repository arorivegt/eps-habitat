package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.datepicker.client.DatePicker;

public class Sce_DataSupervisionPrimera extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private Sce_DataEntryBitacoraSolicitud formulario;
	private Sce_DataEntrySupervisionPrimera supervisionPrimera;
    private boolean bandera = true;
	private Long idSupervisionPrimera = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	private CheckBox checkSi;
	private CheckBox checkNo;
	private TextArea txtObservaciones;
	private TextArea txtAcciones;
	private CheckBox checkSatisfactoria;
	private CheckBox checkNoSatisfactoria;
	private DateBox txtFechaVisita;
	private Button btnGuardar;
	private Label lblPromotor;
	private Label lblAlbail;
	private Label lblRepresentanteDeFamilia;
	private TextBox txtPromotor;
	private TextBox txtAlbanil;
	private TextBox txtRepresentanteFamilia;
	
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
	
    
	public Sce_DataSupervisionPrimera(Sce_DataEntrySupervisionPrimera a, Sce_DataEntryBitacoraSolicitud e) {
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.supervisionPrimera = a;
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
		
		// ---
		
		lblSeleccioneUnaImagen = new Label("Seleccione una imagen no mayor a 1MB");
		lblSeleccioneUnaImagen.setStyleName("label");
		absolutePanel.add(lblSeleccioneUnaImagen, 596, 10);
		lblSeleccioneUnaImagen.setSize("357px", "19px");
		
		checkSi = new CheckBox("Si");
		absolutePanel.add(checkSi, 232, 95);
		checkSi.setSize("69px", "24px");
		
		checkNo = new CheckBox("No");
		absolutePanel.add(checkNo, 307, 95);
		checkNo.setSize("69px", "21px");
		
		txtObservaciones = new TextArea();
		absolutePanel.add(txtObservaciones, 42, 179);
		txtObservaciones.setSize("857px", "69px");
		
		txtFechaVisita = new DateBox();
		txtFechaVisita.setValue(new Date());
		txtFechaVisita.getTextBox().setReadOnly(true);
		txtFechaVisita.setFireNullValues(true);
		txtFechaVisita.setStyleName("gwt-PasswordTextBox");
		txtFechaVisita.getDatePicker().setYearArrowsVisible(true);
		txtFechaVisita.getDatePicker().setYearAndMonthDropdownVisible(true);
		txtFechaVisita.getDatePicker().setVisibleYearCount(100);
		absolutePanel.add(txtFechaVisita, 232, 31);
		txtFechaVisita.setFormat(new DateBox.DefaultFormat (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		
		txtAcciones = new TextArea();
		absolutePanel.add(txtAcciones, 42, 302);
		txtAcciones.setSize("857px", "69px");
		
		checkSatisfactoria = new CheckBox("Satisfactoria");
		absolutePanel.add(checkSatisfactoria, 232, 392);
		checkSatisfactoria.setSize("141px", "24px");
		
		checkNoSatisfactoria = new CheckBox("No Satisfactoria");
		absolutePanel.add(checkNoSatisfactoria, 379, 392);
		checkNoSatisfactoria.setSize("161px", "24px");
		
		Label lblAyudaMutua = new Label("Ayuda Mutua:");
		lblAyudaMutua.setStyleName("label");
		absolutePanel.add(lblAyudaMutua, 42, 95);
		lblAyudaMutua.setSize("148px", "19px");
		
		Label lblFechaDeVisita = new Label("Fecha de Visita I:");
		lblFechaDeVisita.setStyleName("label");
		absolutePanel.add(lblFechaDeVisita, 42, 31);
		lblFechaDeVisita.setSize("148px", "19px");
		
		Label lblAcciones = new Label("Acciones");
		lblAcciones.setStyleName("label");
		absolutePanel.add(lblAcciones, 42, 277);
		lblAcciones.setSize("171px", "19px");
		
		Label lblSupervision = new Label("Supervision");
		lblSupervision.setStyleName("label");
		absolutePanel.add(lblSupervision, 42, 397);
		lblSupervision.setSize("133px", "19px");
		
		Label lblIndiqueLosBienes = new Label("Observaciones:");
		lblIndiqueLosBienes.setStyleName("label");
		absolutePanel.add(lblIndiqueLosBienes, 42, 154);
		lblIndiqueLosBienes.setSize("171px", "19px");
		
		lblPromotor = new Label("Promotor:");
		lblPromotor.setStyleName("label");
		absolutePanel.add(lblPromotor, 42, 469);
		lblPromotor.setSize("133px", "19px");
		
		lblAlbail = new Label("Albañil:");
		lblAlbail.setStyleName("label");
		absolutePanel.add(lblAlbail, 42, 514);
		lblAlbail.setSize("133px", "19px");
		
		lblRepresentanteDeFamilia = new Label("Representante de Familia:");
		lblRepresentanteDeFamilia.setStyleName("label");
		absolutePanel.add(lblRepresentanteDeFamilia, 42, 558);
		lblRepresentanteDeFamilia.setSize("208px", "19px");
		
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
		
		txtRepresentanteFamilia = new TextBox();
		txtRepresentanteFamilia.setStylePrimaryName("gwt-TextBox2");
		txtRepresentanteFamilia.setStyleName("gwt-TextBox2");
		txtRepresentanteFamilia.setMaxLength(200);
		absolutePanel.add(txtRepresentanteFamilia, 275, 556);
		txtRepresentanteFamilia.setSize("386px", "19px");
		
		// -- Boton Guardar/Actualizar Informacion
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				Date fechaVisita = new Date();
				fechaVisita = txtFechaVisita.getValue();
				
				Boolean ayudaMutuaSi = false;
				ayudaMutuaSi = checkSi.getValue();

				Boolean ayudaMutuaNo = false;
				ayudaMutuaNo = checkNo.getValue();
				
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
				
				
				Date time = new Date();
				@SuppressWarnings("deprecation")
				Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());
				
				if(bandera){

					solucionesService.ingresarSupervisionPrimera(fecrec, formulario.idFormulario, 
							fechaVisita, ayudaMutuaSi, ayudaMutuaNo,
							observaciones, acciones,
							checkSatisfactoriaValue, checkNoSatisfactoriaValue,
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

							idSupervisionPrimera = result;
							System.out.println("Valor de NUEVA Primera Supervision: " + idSupervisionPrimera);
							bandera = false;
							
							// --- formulario.habilitarSegundaSupervision(); // Habilita para 2da Supervision
						}
					});

				}else{
					
					solucionesService.actualizarSupervisionPrimera(formulario.idFormulario, idSupervisionPrimera, 
							fechaVisita, ayudaMutuaSi, ayudaMutuaNo,
							observaciones, acciones,
							checkSatisfactoriaValue, checkNoSatisfactoriaValue,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de DATOS DE PRIMERA SUPERVISION: " + idSupervisionPrimera );
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
			Boolean checkSi, Boolean checkNo,
			String observaciones, String acciones,
			Boolean satisfactoria, Boolean noSatisfactoria)
	{
    	
		this.bandera = false;
		
		this.idSupervisionPrimera = id; // ID Formulario Cargado
		
		this.txtFechaVisita.setValue(new Date(fechaVisita));
		this.checkSi.setValue(checkSi);
		this.checkNo.setValue(checkNo);
		this.txtObservaciones.setValue(observaciones);
		this.txtAcciones.setValue(acciones);
		this.checkSatisfactoria.setValue(satisfactoria);
		this.checkNoSatisfactoria.setValue(noSatisfactoria);
	    
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
		absolutePanel.add(grid, 580, 109);
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
