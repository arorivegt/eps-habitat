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
    
    private int i = 1;
  	
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
					
					System.out.println("/ExportConsultaEncuestas?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.setAction("/ExportConsultaEncuestas?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.submit();	
				
				}else{
					
					char tipo = '5';
					if(listSolucionConstruir.getItemText(listSolucionConstruir.getSelectedIndex()).equals("TODOS"))
						tipo = '4';
					else
						tipo = '5';
					
					System.out.println("/ExportConsultaEncuestas?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.setAction("/ExportConsultaEncuestas?tipo="+tipo+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
					formPanel.submit();	
					
				}
				
			}
		});
		button.setText("Exportar");
		button.setStylePrimaryName("sendButton");
		button.setStyleName("sendButton");
		button.setSize("198px", "41px");
		
		formPanel = new FormPanel();
		formPanel.setAction("/ExportConsultaEncuestas?tipo="+"0"+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex()));
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

				DATOS = new ArrayList<Sce_ReporteDatosSolucionesConstruidas>();
				i = 1;
				
				for (AuxSolicitudGeneral p : result) {
					try{
						
						setDataEncuestaSatisfaccion(p.getEncuestaSatisfaccion(), p.getNombreSolicitante());
						i++;
						
					}catch(Exception e){
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
				nuevo.ConstruirConsultaEncuestas("19");

				absolutePanel_1.clear();
				absolutePanel_1.add(nuevo);
			}

		});

		load.invisible();

	}

	
	public void setDataEncuestaSatisfaccion(List<AuxSolicitudEncuestaSatisfaccion> results, String nombre){
			
			for ( AuxSolicitudEncuestaSatisfaccion n2 : results) {

				Sce_ReporteDatosSolucionesConstruidas encuesta = new Sce_ReporteDatosSolucionesConstruidas();
				
				// DATA A MOSTRAR EN RESULTADO

				// 1. Numero Correlativo.
				encuesta.setNumero(""+i);
				
				// 2. Nombre Solicitante
				encuesta.setNombreSolicitante(nombre);

				// 3. Departamento
				String valDepto = "";
				valDepto = n2.getPreguntaNo1();
				String departamento = "";
				if(valDepto.equals("1")){
					departamento = "Petén";
				}else if(valDepto.equals("2")){
					departamento = "Izabal";
				}else if(valDepto.equals("3")){
					departamento = "Alta Verapaz";
				}else if(valDepto.equals("4")){
					departamento = "Quiché";
				}else if(valDepto.equals("5")){
					departamento = "Huehuetenango";
				}else if(valDepto.equals("6")){
					departamento = "Escuintla";
				}else if(valDepto.equals("7")){
					departamento = "San Marcos";
				}else if(valDepto.equals("8")){
					departamento = "Jutiapa";
				}else if(valDepto.equals("9")){
					departamento = "Baja Verapaz";
				}else if(valDepto.equals("10")){
					departamento = "Santa Rosa";
				}else if(valDepto.equals("11")){
					departamento = "Zacapa";
				}else if(valDepto.equals("12")){
					departamento = "Suchitepéquez";
				}else if(valDepto.equals("13")){
					departamento = "Chiquimula";
				}else if(valDepto.equals("14")){
					departamento = "Guatemala";
				}else if(valDepto.equals("15")){
					departamento = "Jalapa";
				}else if(valDepto.equals("16")){
					departamento = "Chimaltenango";
				}else if(valDepto.equals("17")){
					departamento = "Quetzaltenango";
				}else if(valDepto.equals("18")){
					departamento = "El Progreso";
				}else if(valDepto.equals("19")){
					departamento = "Retalhuleu";
				}else if(valDepto.equals("20")){
					departamento = "Sololá";
				}else if(valDepto.equals("21")){
					departamento = "Totonicapán";
				}else if(valDepto.equals("22")){
					departamento = "Sacatepéquez";
				}	
				encuesta.setDepartamento(departamento);
				
				// 4. Pregunta 1
				String valP1 = "";
				valP1 = n2.getPreguntaNo1();
				String pregunta1 = "";
				if(valP1.equals("1")){
					pregunta1 = "Muy bueno";
				}else if(valP1.equals("2")){
					pregunta1 = "Bueno";
				}else if(valP1.equals("3")){
					pregunta1 = "Regular";
				}else if(valP1.equals("4")){
					pregunta1 = "Malo";
				}else if(valP1.equals("5")){
					pregunta1 = "Muy Malo";
				}
				encuesta.setPregunta1(pregunta1);

				// 5. Pregunta 2
				String valP2 = "";
				valP2 = n2.getPreguntaNo2();
				String pregunta2 = "";
				if(valP2.equals("1")){
					pregunta2 = "Muy bueno";
				}else if(valP2.equals("2")){
					pregunta2 = "Bueno";
				}else if(valP2.equals("3")){
					pregunta2 = "Regular";
				}else if(valP2.equals("4")){
					pregunta2 = "Malo";
				}else if(valP2.equals("5")){
					pregunta2 = "Muy Malo";
				}
				encuesta.setPregunta2(pregunta2);
				
				// 6. Pregunta 3
				String valP3 = "";
				valP3 = n2.getPreguntaNo3();
				String pregunta3 = "";
				if(valP3.equals("1")){
					pregunta3 = "Muy bueno";
				}else if(valP3.equals("2")){
					pregunta3 = "Bueno";
				}else if(valP3.equals("3")){
					pregunta3 = "Regular";
				}else if(valP3.equals("4")){
					pregunta3 = "Malo";
				}else if(valP3.equals("5")){
					pregunta3 = "Muy Malo";
				}
				encuesta.setPregunta3(pregunta3);
				
				// 7. Pregunta 4
				String valP4 = "";
				valP4 = n2.getPreguntaNo4();
				String pregunta4 = "";
				if(valP4.equals("1")){
					pregunta4 = "Muy bueno";
				}else if(valP4.equals("2")){
					pregunta4 = "Bueno";
				}else if(valP4.equals("3")){
					pregunta4 = "Regular";
				}else if(valP4.equals("4")){
					pregunta4 = "Malo";
				}else if(valP4.equals("5")){
					pregunta4 = "Muy Malo";
				}
				encuesta.setPregunta4(pregunta4);
				
				// 8. Pregunta 5
				String valP5 = "";
				valP5 = n2.getPreguntaNo5();
				String pregunta5 = "";
				if(valP5.equals("1")){
					pregunta5 = "Muy bueno";
				}else if(valP5.equals("2")){
					pregunta5 = "Bueno";
				}else if(valP5.equals("3")){
					pregunta5 = "Regular";
				}else if(valP5.equals("4")){
					pregunta5 = "Malo";
				}else if(valP5.equals("5")){
					pregunta5 = "Muy Malo";
				}
				encuesta.setPregunta5(pregunta5);
				
				// 9. Pregunta 6
				String valP6 = "";
				valP6 = n2.getPreguntaNo6();
				String pregunta6 = "";
				if(valP6.equals("1")){
					pregunta6 = "Muy bueno";
				}else if(valP6.equals("2")){
					pregunta6 = "Bueno";
				}else if(valP6.equals("3")){
					pregunta6 = "Regular";
				}else if(valP6.equals("4")){
					pregunta6 = "Malo";
				}else if(valP6.equals("5")){
					pregunta6 = "Muy Malo";
				}
				encuesta.setPregunta6(pregunta6);
				
				// 10. Pregunta 7
				String valP7 = "";
				valP7 = n2.getPreguntaNo7();
				String pregunta7 = "";
				if(valP7.equals("1")){
					pregunta7 = "Muy bueno";
				}else if(valP7.equals("2")){
					pregunta7 = "Bueno";
				}else if(valP7.equals("3")){
					pregunta7 = "Regular";
				}else if(valP7.equals("4")){
					pregunta7 = "Malo";
				}else if(valP7.equals("5")){
					pregunta7 = "Muy Malo";
				}
				encuesta.setPregunta7(pregunta7);
				
				// 11. Pregunta 8
				String valP8 = "";
				valP8 = n2.getPreguntaNo8();
				String pregunta8 = "";
				if(valP8.equals("1")){
					pregunta8 = "Muy bueno";
				}else if(valP8.equals("2")){
					pregunta8 = "Bueno";
				}else if(valP8.equals("3")){
					pregunta8 = "Regular";
				}else if(valP8.equals("4")){
					pregunta8 = "Malo";
				}else if(valP8.equals("5")){
					pregunta8 = "Muy Malo";
				}
				encuesta.setPregunta8(pregunta8);
				
				// 12. Pregunta 9
				String valP9 = "";
				valP9 = n2.getPreguntaNo9();
				String pregunta9 = "";
				if(valP9.equals("1")){
					pregunta9 = "Muy bueno";
				}else if(valP9.equals("2")){
					pregunta9 = "Bueno";
				}else if(valP9.equals("3")){
					pregunta9 = "Regular";
				}else if(valP9.equals("4")){
					pregunta9 = "Malo";
				}else if(valP9.equals("5")){
					pregunta9 = "Muy Malo";
				}
				encuesta.setPregunta9(pregunta9);
				
				// 13. Pregunta 10
				String valP10 = "";
				valP10 = n2.getPreguntaNo10();
				String pregunta10 = "";
				if(valP10.equals("1")){
					pregunta10 = "Muy bueno";
				}else if(valP10.equals("2")){
					pregunta10 = "Bueno";
				}else if(valP10.equals("3")){
					pregunta10 = "Regular";
				}else if(valP10.equals("4")){
					pregunta10 = "Malo";
				}else if(valP10.equals("5")){
					pregunta10 = "Muy Malo";
				}
				encuesta.setPregunta10(pregunta10);
				
				// 14. Pregunta 11
				String valP11 = "";
				valP11 = n2.getPreguntaNo11();
				String pregunta11 = "";
				if(valP11.equals("1")){
					pregunta11 = "Muy bueno";
				}else if(valP11.equals("2")){
					pregunta11 = "Bueno";
				}else if(valP11.equals("3")){
					pregunta11 = "Regular";
				}else if(valP11.equals("4")){
					pregunta11 = "Malo";
				}else if(valP11.equals("5")){
					pregunta11 = "Muy Malo";
				}
				encuesta.setPregunta11(pregunta11);
				
				// 15. Pregunta 12
				String valP12 = "";
				valP12 = n2.getPreguntaNo12();
				String pregunta12 = "";
				if(valP12.equals("1")){
					pregunta12 = "Muy bueno";
				}else if(valP12.equals("2")){
					pregunta12 = "Bueno";
				}else if(valP12.equals("3")){
					pregunta12 = "Regular";
				}else if(valP12.equals("4")){
					pregunta12 = "Malo";
				}else if(valP12.equals("5")){
					pregunta12 = "Muy Malo";
				}
				encuesta.setPregunta12(pregunta12);
				
				// 16. Pregunta 13
				String valP13 = "";
				valP13 = n2.getPreguntaNo13();
				String pregunta13 = "";
				if(valP13.equals("1")){
					pregunta13 = "Muy bueno";
				}else if(valP13.equals("2")){
					pregunta13 = "Bueno";
				}else if(valP13.equals("3")){
					pregunta13 = "Regular";
				}else if(valP13.equals("4")){
					pregunta13 = "Malo";
				}else if(valP13.equals("5")){
					pregunta13 = "Muy Malo";
				}
				encuesta.setPregunta13(pregunta13);
				
				// 17. Pregunta 14
				String valP14 = "";
				valP14 = n2.getPreguntaNo14();
				String pregunta14 = "";
				if(valP14.equals("1")){
					pregunta14 = "Muy bueno";
				}else if(valP14.equals("2")){
					pregunta14 = "Bueno";
				}else if(valP14.equals("3")){
					pregunta14 = "Regular";
				}else if(valP14.equals("4")){
					pregunta14 = "Malo";
				}else if(valP14.equals("5")){
					pregunta14 = "Muy Malo";
				}
				encuesta.setPregunta14(pregunta14);
				
				// 18. Pregunta 15
				String valP15 = "";
				valP15 = n2.getPreguntaNo15();
				String pregunta15 = "";
				if(valP15.equals("1")){
					pregunta15 = "Television";
				}else if(valP15.equals("2")){
					pregunta15 = "Radio";
				}else if(valP15.equals("3")){
					pregunta15 = "Prensa/Revista";
				}else if(valP15.equals("4")){
					pregunta15 = "Volantes";
				}else if(valP15.equals("5")){
					pregunta15 = "Perifoneo";
				}else if(valP15.equals("6")){
					pregunta15 = "Ferias";
				}else if(valP15.equals("7")){
					pregunta15 = "Ferreterias";
				}
				encuesta.setPregunta15(pregunta15);
				
				// 19. Pregunta 16
				encuesta.setPregunta16(n2.getPreguntaNo16());

				DATOS.add(encuesta);

			}
	}
    
	
}
