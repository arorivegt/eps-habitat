package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class FormularioAcademico extends Composite {
	private Mensaje mensaje; 
	private Academico academico;
	private Empleado empleado;
	private boolean bandera = true;
	private Grid grid;
	private DateBox dateInicio;
	private DateBox dateFinal ;
	private TextBox txtTitulo;
	private TextBox txtEstablecimiento;
	private ListBox listNIvel_Academico;
	private AbsolutePanel absolutePanel ;

	private FormPanel form;
	private VerticalPanel formElements;
	private FileUpload fileUpload;
	private Button button;
	private String URLFile ="";
	private String KeyFile ="";
    private Loading load ;
    private Button btnActualizar;
    private Button btnEliminar;
	private Long id_historial_academico = 0L;
	private final UploadUrlServiceAsync uploadUrlService = GWT.create(UploadUrlService.class);
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private Label lblAchivosPdfUnicamente;
	
	public FormularioAcademico(Academico academico,Empleado emplead) {

		mensaje = new Mensaje();
		this.empleado = emplead;
		this.academico = academico;
		
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1050px", "120px");
		getFormUrl();
		
		listNIvel_Academico = new ListBox();
		listNIvel_Academico.addItem("No sabe leer y/o Escribir","0");
		listNIvel_Academico.addItem("sabe leer y/o Escribir","1");
		listNIvel_Academico.addItem("Primaria Incompleta","2");
		listNIvel_Academico.addItem("Primaria Completa","3");
		listNIvel_Academico.addItem("Secundaria Incompleta","4");
		listNIvel_Academico.addItem("Secundaria Completa","5");
		listNIvel_Academico.addItem("Diversificado Incompleta","6");
		listNIvel_Academico.addItem("Diversificado Completa","7");
		listNIvel_Academico.addItem("Universidad Incompleta","8");
		listNIvel_Academico.addItem("Universidad Completa","9");
		listNIvel_Academico.addItem("Postgrados","10");
		listNIvel_Academico.addItem("Diplomado","11");
		listNIvel_Academico.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNIvel_Academico, 10, 29);
		listNIvel_Academico.setSize("229px", "34px");
		
		txtTitulo = new TextBox();
		txtTitulo.setStyleName("gwt-TextBox2");
		txtTitulo.setMaxLength(100);
		absolutePanel.add(txtTitulo, 273, 29);
		txtTitulo.setSize("227px", "34px");
		
		txtEstablecimiento = new TextBox();
		txtEstablecimiento.setStyleName("gwt-TextBox2");
		txtEstablecimiento.setMaxLength(100);
		absolutePanel.add(txtEstablecimiento, 522, 29);
		txtEstablecimiento.setSize("227px", "34px");
		
		dateInicio = new DateBox();
		dateInicio.getTextBox().setReadOnly(true);
		dateInicio.setValue(new Date(1407518124684L));
		dateInicio.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateInicio.getDatePicker().setYearArrowsVisible(true);
		dateInicio.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateInicio.getDatePicker().setVisibleYearCount(100);
        
		dateInicio.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateInicio, 10, 107);
		dateInicio.setSize("227px", "34px");
		
		dateFinal = new DateBox();
		dateFinal.getTextBox().setReadOnly(true);
		dateFinal.setValue(new Date(1407518566816L));
		dateFinal.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFinal.getDatePicker().setYearArrowsVisible(true);
		dateFinal.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFinal.getDatePicker().setVisibleYearCount(100);
		dateFinal.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFinal, 274, 107);
		dateFinal.setSize("227px", "34px");
		
		btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        load.visible();
					try{
						new Date(dateFinal.getValue().getTime());
					}catch(Exception e){
						dateFinal.setValue(new Date(1407518124684L));
					}
				
					try{
						new Date(dateInicio.getValue().getTime());
					}catch(Exception e){
						dateInicio.setValue(new Date(1407518124684L));
					}
				
				
				if(bandera) {
					recursosHumanosService.Insertar_Academico(empleado.id_empleado, dateInicio.getValue(), dateFinal.getValue(), 
							listNIvel_Academico.getValue(listNIvel_Academico.getSelectedIndex()), txtEstablecimiento.getText(), 
							txtTitulo.getText(),URLFile, KeyFile, new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                            //Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_historial_academico = result;
							bandera = false;
							
							mensaje.setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        	//Window.alert("Datos Guardados exitosamente!!! ");
                        }

                 });
		}else{
			recursosHumanosService.Actualizar_Academico(empleado.id_empleado,id_historial_academico, dateInicio.getValue(), dateFinal.getValue(), 
					listNIvel_Academico.getValue(listNIvel_Academico.getSelectedIndex()), txtEstablecimiento.getText(), 
					txtTitulo.getText(),URLFile, KeyFile, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                	mensaje.setMensaje("alert alert-error", 
                			"Error !! \nal Actualizar Datos");
                   // Window.alert("Error al Actualizar Datos"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {
					bandera = false;
					mensaje.setMensaje("alert alert-success", 
                			"Datos Actualizados\n exitosamente!!!");
                	//Window.alert("Datos Actualizados exitosamente!!! ");
                }

         });
		}

		        load.invisible();
			}
			
		});
		absolutePanel.add(getFormPanel(), 522, 108);
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 883, 29);
		btnActualizar.setSize("227px", "34px");
		
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(bandera){
					EliminarFormulario_SinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 883, 108);
		btnEliminar.setSize("227px", "34px");
		
		Label lblNivelAcademico = new Label("Nivel Academico");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Titulo/Diploma");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 278, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Establecimiento");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 522, 10);
		lblParentesco.setSize("192px", "13px");
		
		Label lblAos = new Label("Fecha inicio");
		lblAos.setStyleName("label");
		absolutePanel.add(lblAos, 10, 88);
		lblAos.setSize("208px", "13px");
		
		Label lblAl = new Label("al");
		lblAl.setStyleName("label");
		absolutePanel.add(lblAl, 245, 116);
		lblAl.setSize("23px", "13px");
		
		Label lblFechaFinal = new Label("Fecha Final");
		lblFechaFinal.setStyleName("label");
		absolutePanel.add(lblFechaFinal, 275, 88);
		lblFechaFinal.setSize("208px", "13px");
		
		lblAchivosPdfUnicamente = new Label("Achivos pdf unicamente 1MB MAX");
		lblAchivosPdfUnicamente.setStyleName("label");
		absolutePanel.add(lblAchivosPdfUnicamente, 522, 71);
		lblAchivosPdfUnicamente.setSize("229px", "13px");

		
	}
	private void EliminarFormulario(){
        load.visible();
        academico.EliminarFormulario(this,empleado.id_empleado,id_historial_academico);
        if(!getKeyFile().equals(""))
        {
        	recursosHumanosService.remove(getKeyFile() , new AsyncCallback<String>(){
        		@Override
        		public void onFailure(Throwable caught) {
        		}
        		@Override
        		public void onSuccess(String result) {
        		}

        	});
        }
        load.invisible();
    }
	private void EliminarFormulario_SinDatos(){
		academico.EliminarFormulario(this);
	}
	
	public void LlenarDatos(Long id,Long dateInicio, Long dateFinal,
							String txtTitulo, String txtEstablecimiento,
							String listNIvel_Academico,String  URLFile, 
						    String KeyFile)
	{
		this.KeyFile = KeyFile;
		this.URLFile = URLFile;
		this.bandera = false;
		if(!URLFile.equals(""))
			Archivo();
		this.id_historial_academico = id;
		this.bandera = false;
		this.dateInicio.setValue(new Date(dateInicio));
		this.dateFinal.setValue(new Date(dateFinal));
		this.txtTitulo.setText(txtTitulo);
		this.txtEstablecimiento.setText(txtEstablecimiento);
		boolean bandera = true;
		for(int i=0; i < this.listNIvel_Academico.getItemCount() && bandera; i++){

			bandera = !this.listNIvel_Academico.getValue(i).equals(listNIvel_Academico);
		    this.listNIvel_Academico.setSelectedIndex(i);
		}
		
	}
	
	private FormPanel getFormPanel() {
		if (form == null) {
			form = new FormPanel();
			form.setSize("229px", "59px");
			form.setAction("/upload");
			form.setEncoding(FormPanel.ENCODING_MULTIPART);
			form.setMethod(FormPanel.METHOD_POST);
			form.setWidget(getFormElements());
			//form.add(getHidden());
			
			// add submit handler
	    form.addSubmitHandler(new SubmitHandler() {
				public void onSubmit(SubmitEvent event) {
					if (fileUpload.getFilename().length() == 0 || fileUpload.getFilename().indexOf("pdf") == -1) {
						mensaje.setMensaje("alert alert-info", 
	                			"Selecciono un archivo o no es de extension pdf?");
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
						getFormUrl();
						form.setVisible(false);
						Archivo();
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
	                			"verifique que el documento Pese menos de 1MB");
						
					}
				}
			});
	    
		}
		return form;
	}
	
	private VerticalPanel getFormElements() {
		if (formElements == null) {
			formElements = new VerticalPanel();
			formElements.setSize("228px", "100%");
			formElements.add(getFileUpload());
			formElements.add(getButton());
		}
		return formElements;
	}
	
	private FileUpload getFileUpload() {
		if (fileUpload == null) {
			fileUpload = new FileUpload();
			fileUpload.setStyleName("gwt-PasswordTextBox");
			fileUpload.setWidth("227px");
			fileUpload.setName("myFile");
			fileUpload.getElement().setAttribute("accept", "application/pdf");
		}
		return fileUpload;
	}
	
	private Button getButton() {
		if (button == null) {
			button = new Button("Subir");
			button.setHeight("30px");
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
				System.out.println("retrieved url for blob store: " + url);
			}

			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", 
            			"Algo esta Mal !! \nal iniciar Servicio");
				//Window.alert("Something went wrong with the rpc call.");
			}
		});
		
	}

	public void Archivo(){

		form.setVisible(false);
		grid = new Grid(1, 2);
		absolutePanel.add(grid, 522, 108);
		grid.setSize("357px", "59px");
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setHeight("27px");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				recursosHumanosService.remove(getKeyFile() , new AsyncCallback<String>(){
					@Override
					public void onFailure(Throwable caught) {
						form.setVisible(true);
						grid.setVisible(false);
						mensaje.setMensaje("alert alert-error", 
	                			"Archivo !! \nNo eliminado");
						//Window.alert("Archivo No Eliminado");
					}
					@Override
					public void onSuccess(String result) {
						form.setVisible(true);
						grid.setVisible(false);
						KeyFile = "";
						URLFile = "";
						mensaje.setMensaje("alert alert-success", 
	                			"Archivo !! \n eliminado");
						//Window.alert("Archivo Eliminado");
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
	
	public void btnhinabilitar(boolean valor){
		btnActualizar.setEnabled(valor);
		btnActualizar.setVisible(valor);
		btnEliminar.setEnabled(valor);
		btnEliminar.setVisible(valor);
	}
}
