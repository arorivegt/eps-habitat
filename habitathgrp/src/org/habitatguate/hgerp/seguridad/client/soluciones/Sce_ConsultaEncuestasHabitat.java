package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaFiduciaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
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
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class Sce_ConsultaEncuestasHabitat extends Composite  {

    private  Grid grid;
    private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
	private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
	
	// Llaves
	private Long idEmpleado = 0L;
	private Long idAfiliado = 0L;
	private Long idRol = 0L;
	
	private Button button;
	private FormPanel formPanel;
	private VerticalPanel verticalPanel;
	private Mensaje mensaje; 
    private ScrollPanel scrollPanel;
    private AbsolutePanel absolutePanel_1;
    private ListBox listSolucionConstruir ;
    private Loading load ;
    private List<Sce_ReporteDatosSolucionesConstruidas> DATOS;
  	
    // Valor Escritura-Lectura
    private boolean valor;
    // Opcion de busqueda
    private boolean opcion;
    
	public Sce_ConsultaEncuestasHabitat(boolean valor, final boolean opcion) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
	    this.opcion = opcion;				// Variable de opcion de busqueda Especifica|General
		
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
		
		// Obtener Id Afiliado
		recursosHumanosService.obtenerIdAfiliado(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idAfiliado = result;
				System.out.println("Afiliado: " + idAfiliado);	
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error no tiene Afiliado asignado Empleado");
			}
		});
		
		// Obtener Id Rol
		recursosHumanosService.obtenerIdRol(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idRol = result;
				System.out.println("Id Rol: " + idRol);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("100%");

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				
				busqueda();	

			}
		});
		listSolucionConstruir.addItem("Nueva","1");
		listSolucionConstruir.addItem("Mejoramiento","2");
		listSolucionConstruir.addItem("Adiciones Menores","3");
		listSolucionConstruir.addItem("TODOS");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 170, 31);
		listSolucionConstruir.setSize("227px", "34px");
		
		// Imagen de Lupa de Busqueda
		
		Image image = new Image("images/ico-lupa.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				busqueda();	
				
			}
		});

		absolutePanel.add(image, 400, 10);
		image.setSize("103px", "55px");
		
		Label lblBusquedaPor = new Label("Segun Solucion a Construir:");
		lblBusquedaPor.setStyleName("label");
		absolutePanel.add(lblBusquedaPor, 170, 10);
		lblBusquedaPor.setSize("227px", "13px");
		
		scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		grid.setWidget(1, 0, scrollPanel);
		scrollPanel.setSize("1400px", "100%");
		
		absolutePanel_1 = new AbsolutePanel();
		scrollPanel.setWidget(absolutePanel_1);
		absolutePanel_1.setSize("4500px", "100%");
		
		Label lblEstadoEmpleado = new Label("Parametro Busqueda");
		lblEstadoEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoEmpleado, 10, 29);
		lblEstadoEmpleado.setSize("154px", "13px");
	
		// Boton para Exportar Data
		
		button = new Button("Send");
		
		if(this.valor) {
			button.setVisible(true);
		}else{
			button.setVisible(false);
		}
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(opcion){
					
					char tipo = '3';
					if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
						tipo = '2';
					else
						tipo = '3';
					
					System.out.println("/ExportSolucionDetalle?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.setAction("/ExportSolucionDetalle?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.submit();	
				
				}else{
					
					char tipo = '5';
					if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
						tipo = '4';
					else
						tipo = '5';
					
					System.out.println("/ExportSolucionDetalle?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.setAction("/ExportSolucionDetalle?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.submit();	
					
				}
				
			}
		});
		button.setText("Exportar");
		button.setStylePrimaryName("sendButton");
		button.setStyleName("sendButton");
		button.setSize("198px", "41px");
		
		formPanel = new FormPanel();
		formPanel.setAction("/ExportSolucionDetalle?tipo="+"0"+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		
		verticalPanel = new VerticalPanel();
		formPanel.setWidget(verticalPanel);
		verticalPanel.setSize("208px", "43px");
        verticalPanel.add(button);
		absolutePanel.add(formPanel, 508, 21);
        formPanel.setSize("209px", "44px");
		
	}
	
	public void busqueda(){

		load.visible();

		char tipo = 0;

		if(this.opcion){
			tipo = '3';

			if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
				tipo = '2';
			else
				tipo = '3';			
		}else{
			tipo = '5';

			if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
				tipo = '4';
			else
				tipo = '5';	
		}

		solucionesService.buscarFormulario(tipo, idEmpleado, idAfiliado, "", listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()), new AsyncCallback<List<AuxSolicitudGeneral>>(){

			public void onFailure(Throwable caught) 
			{
				load.invisible();
				Window.alert("No hay resultados "+caught);
			}

			@Override
			public void onSuccess( List<AuxSolicitudGeneral> result)
			{

				for (AuxSolicitudGeneral p : result) {

					try{           	
						
						System.out.println("Personas que ingresaron encuestas: " + p.getNombreSolicitante());
						
						setDataEncuestaSatisfaccion(p.getEncuestaSatisfaccion(), p.getNombreSolicitante());
						
					}catch(Exception e){

					} 

				}
			}

		});

		load.invisible();

	}

	
	public void setDataEncuestaSatisfaccion(List<AuxSolicitudEncuestaSatisfaccion> results, String nombre){

		DATOS = new ArrayList<Sce_ReporteDatosSolucionesConstruidas>();
		int i = 1;
		Sce_ReporteDatosSolucionesConstruidas encuesta = new Sce_ReporteDatosSolucionesConstruidas();

		if (!results.isEmpty()) {

			for ( AuxSolicitudEncuestaSatisfaccion n2 : results) {

				System.out.println("ID Encuesta Satisfaccion: " + n2.getIdEncuestaSatisfaccion() + ", ID Formulario: " + n2.getIdFormulario()); 			

				// DATA A MOSTRAR EN RESULTADO

				// 1. Numero Correlativo.
				encuesta.setNumero(""+i);
				// 2. Nombre Solicitante
				encuesta.setNombreSolicitante(nombre);
				// 3. Pregunta 1
				encuesta.setPregunta1(n2.getPreguntaNo1());
				// 4. Pregunta 2
				encuesta.setPregunta2(n2.getPreguntaNo2());
				// 5. Pregunta 3
				encuesta.setPregunta3(n2.getPreguntaNo3());
				// 6. Pregunta 4
				encuesta.setPregunta4(n2.getPreguntaNo4());
				// 7. Pregunta 5
				encuesta.setPregunta5(n2.getPreguntaNo5());
				// 8. Pregunta 6
				encuesta.setPregunta6(n2.getPreguntaNo6());
				// 9. Pregunta 7
				encuesta.setPregunta7(n2.getPreguntaNo7());
				// 10. Pregunta 8
				encuesta.setPregunta8(n2.getPreguntaNo8());
				// 11. Pregunta 9
				encuesta.setPregunta9(n2.getPreguntaNo9());
				// 12. Pregunta 10
				encuesta.setPregunta10(n2.getPreguntaNo10());
				// 13. Pregunta 11
				encuesta.setPregunta11(n2.getPreguntaNo11());
				// 14. Pregunta 12
				encuesta.setPregunta12(n2.getPreguntaNo12());
				// 15. Pregunta 13
				encuesta.setPregunta13(n2.getPreguntaNo13());
				// 16. Pregunta 14
				encuesta.setPregunta14(n2.getPreguntaNo14());
				// 17. Pregunta 15
				encuesta.setPregunta15(n2.getPreguntaNo15());
				// 18. Pregunta 16
				encuesta.setPregunta16(n2.getPreguntaNo16());

				DATOS.add(encuesta);
				i++;

			}

		}

		Sce_ReporteSolucionesConstruidas nuevo = new Sce_ReporteSolucionesConstruidas(DATOS);
		nuevo.ConstruirConsultaEncuestas("1");
		nuevo.ConstruirConsultaEncuestas("2");
		nuevo.ConstruirConsultaEncuestas("3");
		nuevo.ConstruirConsultaEncuestas("4");
		nuevo.ConstruirConsultaEncuestas("5");
		nuevo.ConstruirConsultaEncuestas("6");
		nuevo.ConstruirConsultaEncuestas("7");
		nuevo.ConstruirConsultaEncuestas("8");
		nuevo.ConstruirConsultaEncuestas("9");
		nuevo.ConstruirConsultaEncuestas("10");
		nuevo.ConstruirConsultaEncuestas("11");
		nuevo.ConstruirConsultaEncuestas("12");
		nuevo.ConstruirConsultaEncuestas("13");
		nuevo.ConstruirConsultaEncuestas("14");
		nuevo.ConstruirConsultaEncuestas("15");
		nuevo.ConstruirConsultaEncuestas("16");
		nuevo.ConstruirConsultaEncuestas("17");
		nuevo.ConstruirConsultaEncuestas("18");

		absolutePanel_1.clear();
		absolutePanel_1.add(nuevo);

	}
    
	
}
