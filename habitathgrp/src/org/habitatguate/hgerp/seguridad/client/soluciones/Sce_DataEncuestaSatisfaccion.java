package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
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
import com.google.gwt.user.client.ui.ListBox;

public class Sce_DataEncuestaSatisfaccion extends Composite {

    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
	private Sce_DataEntrySupervisionSolicitud formulario;
	private Sce_DataEntryEncuestaSatisfaccion encuestaSatisfaccion;
    private boolean bandera = true;
	private Long idEncuestaSatisfaccion = 0L;
	
	// Llaves
	private Long idFormulario = 0L;
	private Long idEmpleado = 0L;
	private Long idAfiliado = 0L;
	private Long idRol = 0L;
	
	private AbsolutePanel absolutePanel;
	private Mensaje mensaje; 
	private Button btnGuardar;
	private Button btnImprimir;
    private Loading load ;

	private Label lblPregunta1;
	private ListBox listPregunta1;
	private Label lblNo1;
	private Label lblNo2;
	private Label lblNo3;
	private Label lblNo4;
	private Label lblNo5;
	private Label lblNo6;
	private Label lblNo7;
	private Label lblNo8;
	private Label lblNo9;
	private Label lblNo10;
	private Label lblNo11;
	private Label lblNo12;
	private Label lblNo13;
	private Label lblNo14;
	private Label lblNo15;
	private Label lblNo16;
	private Label lblPregunta2;
	private ListBox listPregunta2;
	private Label lblPregunta3;
	private Label lblPregunta4;
	private Label lblPregunta5;
	private Label lblPregunta6;
	private Label lblPregunta7;
	private Label lblPregunta8;
	private Label lblPregunta9;
	private Label lblPregunta10;
	private Label lblPregunta11;
	private Label lblPregunta12;
	private Label lblPregunta13;
	private Label lblPregunta14;
	private Label lblPregunta15;
	private Label lblPregunta16;
	private ListBox listPregunta3;
	private ListBox listPregunta4;
	private ListBox listPregunta5;
	private ListBox listPregunta6;
	private ListBox listPregunta7;
	private ListBox listPregunta8;
	private ListBox listPregunta9;
	private ListBox listPregunta10;
	private ListBox listPregunta11;
	private ListBox listPregunta12;
	private ListBox listPregunta13;
	private ListBox listPregunta14;
	private ListBox listPregunta15;
	private ListBox listPregunta16;
	private Label lblObservacion;
	
	// Valor Escritura-Lectura
	private boolean valor;
	
	public Sce_DataEncuestaSatisfaccion(Sce_DataEntryEncuestaSatisfaccion a, Sce_DataEntrySupervisionSolicitud e, boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		// Obtener Id Empleado
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idEmpleado = result;
				System.out.println("Id Empleado: " + idEmpleado);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		mensaje = new Mensaje();
		this.formulario = e;
		this.encuestaSatisfaccion = a;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "805px");
		
		lblNo1 = new Label("1.");
		lblNo1.setStyleName("label");
		absolutePanel.add(lblNo1, 44, 69);
		lblNo1.setSize("38px", "19px");
		
		lblNo2 = new Label("2.");
		lblNo2.setStyleName("label");
		absolutePanel.add(lblNo2, 44, 111);
		lblNo2.setSize("38px", "19px");
		
		lblNo3 = new Label("3.");
		lblNo3.setStyleName("label");
		absolutePanel.add(lblNo3, 44, 153);
		lblNo3.setSize("38px", "19px");
		
		lblNo4 = new Label("4.");
		lblNo4.setStyleName("label");
		absolutePanel.add(lblNo4, 44, 195);
		lblNo4.setSize("38px", "19px");
		
		lblNo5 = new Label("5.");
		lblNo5.setStyleName("label");
		absolutePanel.add(lblNo5, 44, 237);
		lblNo5.setSize("38px", "19px");
		
		lblNo6 = new Label("6.");
		lblNo6.setStyleName("label");
		absolutePanel.add(lblNo6, 44, 279);
		lblNo6.setSize("38px", "19px");
		
		lblNo7 = new Label("7.");
		lblNo7.setStyleName("label");
		absolutePanel.add(lblNo7, 44, 321);
		lblNo7.setSize("38px", "19px");
		
		lblNo8 = new Label("8.");
		lblNo8.setStyleName("label");
		absolutePanel.add(lblNo8, 44, 363);
		lblNo8.setSize("38px", "19px");
		
		lblNo9 = new Label("9.");
		lblNo9.setStyleName("label");
		absolutePanel.add(lblNo9, 44, 405);
		lblNo9.setSize("38px", "19px");
		
		lblNo10 = new Label("10.");
		lblNo10.setStyleName("label");
		absolutePanel.add(lblNo10, 44, 447);
		lblNo10.setSize("38px", "19px");
		
		lblNo11 = new Label("11.");
		lblNo11.setStyleName("label");
		absolutePanel.add(lblNo11, 44, 489);
		lblNo11.setSize("38px", "19px");
		
		lblNo12 = new Label("12.");
		lblNo12.setStyleName("label");
		absolutePanel.add(lblNo12, 44, 531);
		lblNo12.setSize("38px", "19px");
		
		lblNo13 = new Label("13.");
		lblNo13.setStyleName("label");
		absolutePanel.add(lblNo13, 44, 573);
		lblNo13.setSize("38px", "19px");
		
		lblNo14 = new Label("14.");
		lblNo14.setStyleName("label");
		absolutePanel.add(lblNo14, 44, 615);
		lblNo14.setSize("38px", "19px");
		
		lblNo15 = new Label("15.");
		lblNo15.setStyleName("label");
		absolutePanel.add(lblNo15, 44, 657);
		lblNo15.setSize("38px", "19px");
		
		lblNo16 = new Label("16.");
		lblNo16.setStyleName("label");
		absolutePanel.add(lblNo16, 44, 699);
		lblNo16.setSize("38px", "19px");
		
		lblPregunta1 = new Label("¿Como considera la ubicacion de nuestra oficina?");
		lblPregunta1.setStyleName("label");
		absolutePanel.add(lblPregunta1, 97, 69);
		lblPregunta1.setSize("416px", "19prx");
		
		lblPregunta2 = new Label("¿Como califica el orden y limpieza de nuestras instalaciones?");
		lblPregunta2.setStyleName("label");
		absolutePanel.add(lblPregunta2, 97, 111);
		lblPregunta2.setSize("508px", "19px");
	
		lblPregunta3 = new Label("¿Como considera el ambiente de nuestra oficina?");
		lblPregunta3.setStyleName("label");
		absolutePanel.add(lblPregunta3, 97, 156);
		lblPregunta3.setSize("416px", "19prx");
		
		lblPregunta4 = new Label("¿Como fue el trato que recibio por parte del personal?");
		lblPregunta4.setStyleName("label");
		absolutePanel.add(lblPregunta4, 97, 198);
		lblPregunta4.setSize("416px", "19prx");
		
		lblPregunta5 = new Label("¿Recibio informacion clara de nuestros productos y servicios?");
		lblPregunta5.setStyleName("label");
		absolutePanel.add(lblPregunta5, 97, 240);
		lblPregunta5.setSize("508px", "19px");
		
		lblPregunta6 = new Label("¿Resolvieron sus dudas correctamente y con rapidez?");
		lblPregunta6.setStyleName("label");
		absolutePanel.add(lblPregunta6, 97, 282);
		lblPregunta6.setSize("416px", "19prx");
		
		lblPregunta7 = new Label("¿Recibio asesoria para completar los requisitos solicitados?");
		lblPregunta7.setStyleName("label");
		absolutePanel.add(lblPregunta7, 97, 324);
		lblPregunta7.setSize("508px", "19px");
		
		lblPregunta8 = new Label("¿Entregaron su producto en el tiempo ofrecido?");
		lblPregunta8.setStyleName("label");
		absolutePanel.add(lblPregunta8, 97, 366);
		lblPregunta8.setSize("416px", "19prx");
		
		lblPregunta9 = new Label("¿Como califica la calidad de los materiales de construccion?");
		lblPregunta9.setStyleName("label");
		absolutePanel.add(lblPregunta9, 97, 408);
		lblPregunta9.setSize("508px", "19px");
		
		lblPregunta10 = new Label("¿Como califica la calidad de los acabados de su vivienda?");
		lblPregunta10.setStyleName("label");
		absolutePanel.add(lblPregunta10, 97, 450);
		lblPregunta10.setSize("508px", "16px");
		
		lblPregunta11 = new Label("¿Considera util el contenido de las capacitaciones?");
		lblPregunta11.setStyleName("label");
		absolutePanel.add(lblPregunta11, 97, 492);
		lblPregunta11.setSize("416px", "19prx");
		
		lblPregunta12 = new Label("¿Ha puesto en practica el conocimiento recibido?");
		lblPregunta12.setStyleName("label");
		absolutePanel.add(lblPregunta12, 97, 534);
		lblPregunta12.setSize("416px", "19prx");
		
		lblPregunta13 = new Label("¿Como considera la asistencia tecnica constructiva que recibio?");
		lblPregunta13.setStyleName("label");
		absolutePanel.add(lblPregunta13, 97, 576);
		lblPregunta13.setSize("508px", "16px");
		
		lblPregunta14 = new Label("En general ¿Como considera su experiencia con nosotros?");
		lblPregunta14.setStyleName("label");
		absolutePanel.add(lblPregunta14, 97, 618);
		lblPregunta14.setSize("508px", "16px");
		
		lblPregunta15 = new Label("¿Como se entero de nuestros productos y servicios?");
		lblPregunta15.setStyleName("label");
		absolutePanel.add(lblPregunta15, 97, 660);
		lblPregunta15.setSize("416px", "19prx");
		
		lblPregunta16 = new Label("¿Recomendaria nuestros productos y servicios?");
		lblPregunta16.setStyleName("label");
		absolutePanel.add(lblPregunta16, 97, 702);
		lblPregunta16.setSize("416px", "19prx");
		
		lblObservacion = new Label("Considerando 1 es la nota mas baja y 5 la mas alta");
		lblObservacion.setStyleName("label");
		absolutePanel.add(lblObservacion, 97, 724);
		lblObservacion.setSize("416px", "19prx");
		
		listPregunta1 = new ListBox();
		listPregunta1.addItem("-","-1");
		listPregunta1.addItem("Muy bueno","1");
		listPregunta1.addItem("Bueno","2");
		listPregunta1.addItem("Regular","3");
		listPregunta1.addItem("Malo","4");
		listPregunta1.addItem("Muy Malo","5");
		listPregunta1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta1, 626, 58);
		listPregunta1.setSize("148px", "27px");
		
		listPregunta2 = new ListBox();
		listPregunta2.addItem("-","-1");
		listPregunta2.addItem("Muy bueno","1");
		listPregunta2.addItem("Bueno","2");
		listPregunta2.addItem("Regular","3");
		listPregunta2.addItem("Malo","4");
		listPregunta2.addItem("Muy Malo","5");
		listPregunta2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta2, 626, 103);
		listPregunta2.setSize("148px", "27px");
		
		listPregunta3 = new ListBox();
		listPregunta3.addItem("-","-1");
		listPregunta3.addItem("Muy bueno","1");
		listPregunta3.addItem("Bueno","2");
		listPregunta3.addItem("Regular","3");
		listPregunta3.addItem("Malo","4");
		listPregunta3.addItem("Muy Malo","5");
		listPregunta3.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta3, 626, 145);
		listPregunta3.setSize("148px", "27px");
		
		listPregunta4 = new ListBox();
		listPregunta4.addItem("-","-1");
		listPregunta4.addItem("Muy bueno","1");
		listPregunta4.addItem("Bueno","2");
		listPregunta4.addItem("Regular","3");
		listPregunta4.addItem("Malo","4");
		listPregunta4.addItem("Muy Malo","5");
		listPregunta4.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta4, 626, 187);
		listPregunta4.setSize("148px", "27px");
		
		listPregunta5 = new ListBox();
		listPregunta5.addItem("-","-1");
		listPregunta5.addItem("Muy bueno","1");
		listPregunta5.addItem("Bueno","2");
		listPregunta5.addItem("Regular","3");
		listPregunta5.addItem("Malo","4");
		listPregunta5.addItem("Muy Malo","5");
		listPregunta5.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta5, 626, 229);
		listPregunta5.setSize("148px", "27px");
		
		listPregunta6 = new ListBox();
		listPregunta6.addItem("-","-1");
		listPregunta6.addItem("Muy bueno","1");
		listPregunta6.addItem("Bueno","2");
		listPregunta6.addItem("Regular","3");
		listPregunta6.addItem("Malo","4");
		listPregunta6.addItem("Muy Malo","5");
		listPregunta6.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta6, 626, 271);
		listPregunta6.setSize("148px", "27px");
		
		listPregunta7 = new ListBox();
		listPregunta7.addItem("-","-1");
		listPregunta7.addItem("Muy bueno","1");
		listPregunta7.addItem("Bueno","2");
		listPregunta7.addItem("Regular","3");
		listPregunta7.addItem("Malo","4");
		listPregunta7.addItem("Muy Malo","5");
		listPregunta7.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta7, 626, 313);
		listPregunta7.setSize("148px", "27px");
		
		listPregunta8 = new ListBox();
		listPregunta8.addItem("-","-1");
		listPregunta8.addItem("Muy bueno","1");
		listPregunta8.addItem("Bueno","2");
		listPregunta8.addItem("Regular","3");
		listPregunta8.addItem("Malo","4");
		listPregunta8.addItem("Muy Malo","5");
		listPregunta8.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta8, 626, 355);
		listPregunta8.setSize("148px", "27px");
		
		listPregunta9 = new ListBox();
		listPregunta9.addItem("-","-1");
		listPregunta9.addItem("Muy bueno","1");
		listPregunta9.addItem("Bueno","2");
		listPregunta9.addItem("Regular","3");
		listPregunta9.addItem("Malo","4");
		listPregunta9.addItem("Muy Malo","5");
		listPregunta9.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta9, 626, 397);
		listPregunta9.setSize("148px", "27px");
		
		listPregunta10 = new ListBox();
		listPregunta10.addItem("-","-1");
		listPregunta10.addItem("Muy bueno","1");
		listPregunta10.addItem("Bueno","2");
		listPregunta10.addItem("Regular","3");
		listPregunta10.addItem("Malo","4");
		listPregunta10.addItem("Muy Malo","5");
		listPregunta10.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta10, 626, 439);
		listPregunta10.setSize("148px", "27px");
		
		listPregunta11 = new ListBox();
		listPregunta11.addItem("-","-1");
		listPregunta11.addItem("Muy bueno","1");
		listPregunta11.addItem("Bueno","2");
		listPregunta11.addItem("Regular","3");
		listPregunta11.addItem("Malo","4");
		listPregunta11.addItem("Muy Malo","5");
		listPregunta11.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta11, 626, 481);
		listPregunta11.setSize("148px", "27px");
		
		listPregunta12 = new ListBox();
		listPregunta12.addItem("-","-1");
		listPregunta12.addItem("Muy bueno","1");
		listPregunta12.addItem("Bueno","2");
		listPregunta12.addItem("Regular","3");
		listPregunta12.addItem("Malo","4");
		listPregunta12.addItem("Muy Malo","5");
		listPregunta12.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta12, 626, 523);
		listPregunta12.setSize("148px", "27px");
		
		listPregunta13 = new ListBox();
		listPregunta13.addItem("-","-1");
		listPregunta13.addItem("Muy bueno","1");
		listPregunta13.addItem("Bueno","2");
		listPregunta13.addItem("Regular","3");
		listPregunta13.addItem("Malo","4");
		listPregunta13.addItem("Muy Malo","5");
		listPregunta13.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta13, 626, 565);
		listPregunta13.setSize("148px", "27px");
		
		listPregunta14 = new ListBox();
		listPregunta14.addItem("-","-1");
		listPregunta14.addItem("Muy bueno","1");
		listPregunta14.addItem("Bueno","2");
		listPregunta14.addItem("Regular","3");
		listPregunta14.addItem("Malo","4");
		listPregunta14.addItem("Muy Malo","5");
		listPregunta14.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta14, 626, 607);
		listPregunta14.setSize("148px", "27px");
		
		listPregunta15 = new ListBox();
		listPregunta15.addItem("-","-1");
		listPregunta15.addItem("Television","1");
		listPregunta15.addItem("Radio","2");
		listPregunta15.addItem("Prensa/Revista","3");
		listPregunta15.addItem("Volantes","4");
		listPregunta15.addItem("Perifoneo","5");
		listPregunta15.addItem("Ferias","6");
		listPregunta15.addItem("Ferreterias","7");
		listPregunta15.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta15, 626, 649);
		listPregunta15.setSize("148px", "27px");
		
		listPregunta16 = new ListBox();
		listPregunta16.addItem("-","-1");
		listPregunta16.addItem("1","1");
		listPregunta16.addItem("2","2");
		listPregunta16.addItem("3","3");
		listPregunta16.addItem("4","4");
		listPregunta16.addItem("5","5");
		listPregunta16.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta16, 626, 691);
		listPregunta16.setSize("148px", "27px");
	
		// -- Boton Guardar/Actualizar Informacion
		
		btnGuardar = new Button("Send");
		
		if(this.valor) {
			btnGuardar.setVisible(true);
		}else{
			btnGuardar.setVisible(false);
		}
		
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				String preguntaNo1 = "-1";		
				preguntaNo1 = listPregunta1.getValue(listPregunta1.getSelectedIndex());	
				
				String preguntaNo2 = "-1";		
				preguntaNo2 = listPregunta2.getValue(listPregunta2.getSelectedIndex());
				
				String preguntaNo3 = "-1";		
				preguntaNo3 = listPregunta3.getValue(listPregunta3.getSelectedIndex());	
				
				String preguntaNo4 = "-1";		
				preguntaNo4 = listPregunta4.getValue(listPregunta4.getSelectedIndex());	
				
				String preguntaNo5 = "-1";		
				preguntaNo5 = listPregunta5.getValue(listPregunta5.getSelectedIndex());	
				
				String preguntaNo6 = "-1";		
				preguntaNo6 = listPregunta6.getValue(listPregunta6.getSelectedIndex());	
				
				String preguntaNo7 = "-1";		
				preguntaNo7 = listPregunta7.getValue(listPregunta7.getSelectedIndex());	
				
				String preguntaNo8 = "-1";		
				preguntaNo8 = listPregunta8.getValue(listPregunta8.getSelectedIndex());	
				
				String preguntaNo9 = "-1";		
				preguntaNo9 = listPregunta9.getValue(listPregunta9.getSelectedIndex());	
				
				String preguntaNo10 = "-1";		
				preguntaNo10 = listPregunta10.getValue(listPregunta10.getSelectedIndex());	
				
				String preguntaNo11 = "-1";		
				preguntaNo11 = listPregunta11.getValue(listPregunta11.getSelectedIndex());	
				
				String preguntaNo12 = "-1";		
				preguntaNo12 = listPregunta12.getValue(listPregunta12.getSelectedIndex());	
				
				String preguntaNo13 = "-1";		
				preguntaNo13 = listPregunta13.getValue(listPregunta13.getSelectedIndex());	

				String preguntaNo14 = "-1";		
				preguntaNo14 = listPregunta14.getValue(listPregunta14.getSelectedIndex());	
				
				String preguntaNo15 = "-1";		
				preguntaNo15 = listPregunta15.getValue(listPregunta15.getSelectedIndex());	
				
				String preguntaNo16 = "-1";		
				preguntaNo16 = listPregunta16.getValue(listPregunta16.getSelectedIndex());	
				
				Date time = new Date();
				@SuppressWarnings("deprecation")
				Date fecrec = new Date(time.getYear(),time.getMonth(),time.getDate());
				
				if(bandera){

					solucionesService.ingresarEncuestaSatisfaccion(fecrec, formulario.idFormulario, 
							preguntaNo1, preguntaNo2, preguntaNo3, preguntaNo4,
							preguntaNo5, preguntaNo6, preguntaNo7, preguntaNo8,
							preguntaNo9, preguntaNo10, preguntaNo11, preguntaNo12,
							preguntaNo13, preguntaNo14, preguntaNo15, preguntaNo16,
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

							idEncuestaSatisfaccion = result;
							System.out.println("Valor de NUEVA EncuestaSatisfaccion: " + idEncuestaSatisfaccion);
							bandera = false;
						
						}
					});

				}else{
					
					solucionesService.actualizarEncuestaSatisfaccion(formulario.idFormulario, idEncuestaSatisfaccion, 
							preguntaNo1, preguntaNo2, preguntaNo3, preguntaNo4,
							preguntaNo5, preguntaNo6, preguntaNo7, preguntaNo8,
							preguntaNo9, preguntaNo10, preguntaNo11, preguntaNo12,
							preguntaNo13, preguntaNo14, preguntaNo15, preguntaNo16,
							new AsyncCallback<Long>() {

						public void onFailure(Throwable caught) 
						{
							mensaje.setMensaje("alert alert-error", "Se produjo un error los datos no pueden Actualizarse");
						}

						public void onSuccess(Long result)
						{	
							mensaje.setMensaje("alert alert-info", "Registro Actualizado Exitosamente");
							
							System.out.println("Valor de DATOS DE ENCUESTA SATISFACCION: " + idEncuestaSatisfaccion );
							bandera = false;

						}
					});
					
				}
				
			}
		});
		
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 368, 773);
		btnGuardar.setSize("198px", "41px");
		
		btnImprimir = new Button("Send");
		btnImprimir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				Window.open("/ImprimirEncuestaSatisfaccion?id_Empleado="+idEmpleado, "_blank", "");

			}
		});
		btnImprimir.setText("Imprimir");
		btnImprimir.setStylePrimaryName("sendButton");
		btnImprimir.setStyleName("sendButton");
		absolutePanel.add(btnImprimir, 600, 773);
		btnImprimir.setSize("198px", "41px");
		
	}
	
	// DATA A CARGAR EN DATOS
	 
    public void LlenarDatos(Long id, 
    		String preguntaNo1, String preguntaNo2, String preguntaNo3, String preguntaNo4,
    		String preguntaNo5, String preguntaNo6, String preguntaNo7, String preguntaNo8,
    		String preguntaNo9, String preguntaNo10, String preguntaNo11, String preguntaNo12,
    		String preguntaNo13, String preguntaNo14, String preguntaNo15, String preguntaNo16)
	{
    	
		this.bandera = false;
		
		this.idEncuestaSatisfaccion = id; // ID Formulario Cargado
		
        boolean bandera = true;
        for(int i=0; i < this.listPregunta1.getItemCount() && bandera; i++){
            bandera = !this.listPregunta1.getValue(i).equals(preguntaNo1);
            this.listPregunta1.setSelectedIndex(i);
       }
        
        bandera = true;
	    for(int i=0; i < this.listPregunta2.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta2.getValue(i).equals(preguntaNo2);
	       this.listPregunta2.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta3.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta3.getValue(i).equals(preguntaNo3);
	       this.listPregunta3.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta4.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta4.getValue(i).equals(preguntaNo4);
	       this.listPregunta4.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta5.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta5.getValue(i).equals(preguntaNo5);
	       this.listPregunta5.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta6.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta6.getValue(i).equals(preguntaNo6);
	       this.listPregunta6.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta7.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta7.getValue(i).equals(preguntaNo7);
	       this.listPregunta7.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta8.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta8.getValue(i).equals(preguntaNo8);
	       this.listPregunta8.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta9.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta9.getValue(i).equals(preguntaNo9);
	       this.listPregunta9.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta10.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta10.getValue(i).equals(preguntaNo10);
	       this.listPregunta10.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta11.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta11.getValue(i).equals(preguntaNo11);
	       this.listPregunta11.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta12.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta12.getValue(i).equals(preguntaNo12);
	       this.listPregunta12.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta13.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta13.getValue(i).equals(preguntaNo13);
	       this.listPregunta13.setSelectedIndex(i);
	    } 
        
        bandera = true;
	    for(int i=0; i < this.listPregunta14.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta14.getValue(i).equals(preguntaNo14);
	       this.listPregunta14.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta15.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta15.getValue(i).equals(preguntaNo15);
	       this.listPregunta15.setSelectedIndex(i);
	    } 
	    
        bandera = true;
	    for(int i=0; i < this.listPregunta16.getItemCount() && bandera; i++){
	       bandera = !this.listPregunta16.getValue(i).equals(preguntaNo16);
	       this.listPregunta16.setSelectedIndex(i);
	    } 
	    
	    
		
	}
    

		
}
