package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlService;
import org.habitatguate.hgerp.seguridad.client.api.UploadUrlServiceAsync;

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
public class formularioAcademico extends Composite {
	private academico a;
	private Empleados empleado;
	private boolean bandera = true;
	private Long id_historial_academico = 0L;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);

	private final UploadUrlServiceAsync uploadUrlService = GWT
			.create(UploadUrlService.class);
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
	
	public formularioAcademico(academico a,Empleados e) {

		this.empleado = e;
		this.a = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1101px", "40px");
		absolutePanel.add(getFormPanel(), 786, 10);
		getFormUrl();
		listNIvel_Academico = new ListBox();
		listNIvel_Academico.addItem("Primaria");
		listNIvel_Academico.addItem("Basicos");
		listNIvel_Academico.addItem("Diversificado");
		listNIvel_Academico.addItem("Universidad");
		listNIvel_Academico.addItem("Maestria");
		listNIvel_Academico.addItem("Diplomado");
		listNIvel_Academico.addItem("Titulo");
		listNIvel_Academico.addItem("Otro");
		listNIvel_Academico.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNIvel_Academico, 10, 29);
		listNIvel_Academico.setSize("157px", "20px");
		
		txtTitulo = new TextBox();
		txtTitulo.setStyleName("gwt-TextBox2");
		txtTitulo.setMaxLength(100);
		absolutePanel.add(txtTitulo, 200, 29);
		txtTitulo.setSize("137px", "11px");
		
		txtEstablecimiento = new TextBox();
		txtEstablecimiento.setStyleName("gwt-TextBox2");
		txtEstablecimiento.setMaxLength(100);
		absolutePanel.add(txtEstablecimiento, 369, 29);
		txtEstablecimiento.setSize("137px", "11px");
		
		dateInicio = new DateBox();
		dateInicio.setValue(new Date(1407518124684L));
		dateInicio.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateInicio.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateInicio, 550, 29);
		dateInicio.setSize("73px", "11px");
		
		dateFinal = new DateBox();
		dateFinal.setValue(new Date(1407518566816L));
		dateFinal.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFinal.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFinal, 677, 29);
		dateFinal.setSize("83px", "11px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//validar fechas, si el datebox no esta vacio
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
					loginService.Insertar_Academico(empleado.id_empleado, dateInicio.getValue(), dateFinal.getValue(), 
							listNIvel_Academico.getItemText(listNIvel_Academico.getSelectedIndex()), txtEstablecimiento.getText(), 
							txtTitulo.getText(),URLFile, KeyFile, new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_historial_academico = result;
							bandera = false;
                        	Window.alert("Datos Guardados exitosamente!!! "+id_historial_academico);
                        }

                 });
		}else{
			loginService.Actualizar_Academico(empleado.id_empleado,id_historial_academico, dateInicio.getValue(), dateFinal.getValue(), 
					listNIvel_Academico.getItemText(listNIvel_Academico.getSelectedIndex()), txtEstablecimiento.getText(), 
					txtTitulo.getText(),URLFile, KeyFile, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Error al Actualizar Datos"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {
					bandera = false;
                	Window.alert("Datos Actualizados exitosamente!!! "+id_historial_academico);
                }

         });
		}
				
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 110, 55);
		btnActualizar.setSize("157px", "20px");
		
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(bandera){
					Window.alert("No se a guardado los datos");
				}else{
					EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 296, 55);
		btnEliminar.setSize("157px", "20px");
		
		Label lblNivelAcademico = new Label("Nivel Academico");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Titulo/Diploma");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 190, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Establecimiento");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		Label lblAos = new Label("Fecha inicio y final");
		lblAos.setStyleName("label");
		absolutePanel.add(lblAos, 612, 10);
		lblAos.setSize("103px", "13px");
		
		Label lblAl = new Label("al");
		lblAl.setStyleName("label");
		absolutePanel.add(lblAl, 649, 36);
		lblAl.setSize("23px", "13px");

		
	}
	private void EliminarFormulario(){
	        a.EliminarFormulario(this,empleado.id_empleado,id_historial_academico);
    }
	
	public void LlenarDatos(Long id,Long dateInicio, Long dateFinal,
							String txtTitulo, String txtEstablecimiento,
							String listNIvel_Academico,String  URLFile, 
						    String KeyFile)
	{

		this.KeyFile = KeyFile;
		this.URLFile = URLFile;
		this.id_historial_academico = id;
		this.bandera = false;
		this.dateInicio.setValue(new Date(dateInicio));
		this.dateFinal.setValue(new Date(dateFinal));
		this.txtTitulo.setText(txtTitulo);
		this.txtEstablecimiento.setText(txtEstablecimiento);
		boolean bandera = true;
		//Window.alert("lista: "+this.listNIvel_Academico.getItemCount());
		for(int i=0; i < this.listNIvel_Academico.getItemCount() && bandera; i++){

			bandera = !this.listNIvel_Academico.getItemText(i).equals(listNIvel_Academico);
			//Window.alert("lista: "+bandera + " i:"+ i);
		    this.listNIvel_Academico.setSelectedIndex(i);
		}
		
	}
	
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
	          Window.alert("Did you select a file?");
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
						Window.alert(URLFile);
						Window.alert(KeyFile);
						//pResponse.add(new HTML(results));
						getFormUrl();
						form.setVisible(false);
						Archivo();
					}catch(Exception e){
						Archivo();
						Window.alert(results);
						
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
			fileUpload.setWidth("357px");
			fileUpload.setName("myFile");
		}
		return fileUpload;
	}
	
	private Button getButton() {
		if (button == null) {
			button = new Button("Upload");
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
				Window.alert("Something went wrong with the rpc call.");
			}
		});
		
	}

	public void Archivo(){

		grid = new Grid(1, 2);
		absolutePanel.add(grid, 786, 10);
		grid.setSize("357px", "59px");
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				loginService.remove(getKeyFile() , new AsyncCallback<String>(){
					@Override
					public void onFailure(Throwable caught) {
						form.setVisible(true);
						grid.setVisible(false);
						Window.alert("Archivo No Eliminado");
					}
					@Override
					public void onSuccess(String result) {
						Window.alert("Archivo Eliminado");
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
