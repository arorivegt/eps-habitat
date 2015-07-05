
package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class Sce_CrearReporteSolucionesHabitat extends Composite   {

	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private Label lbDato1;
    private Image Busqueda;
    private SuggestBox txtNombreSolicitante;
    private  ListBox listSolucionConstruir ;
    private AbsolutePanel absolutePanel;
	public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
	public List <AuxAfiliado> BDAfiliados = new ArrayList<AuxAfiliado>();	
    private Loading load ;
	private AbsolutePanel absolutePanel_1;
	private SimpleCheckBox checkCargaFamiliar;
	private SimpleCheckBox cheqAcademicos;
	private SimpleCheckBox cheqReferenciaLaboral;
	private SimpleCheckBox cheqReferenciaPersonal;
	private SimpleCheckBox cheqIdiomas;
	private Label lblCargaFamiliar;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private Label label_6;
	private Label lblAContinuacionSeleccione;
	private Label lblCreeElReporte; 
	private Label lblSeleccioneLosEmpleados;
	
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final SqlServiceAsync FinanzasService = GWT.create(SqlService.class);
	private final SolucionesConstruidasServiceAsync solucionesService = GWT.create(SolucionesConstruidasService.class);
    
	// Llaves
	private Long idEmpleado = 0L;
	private String usrName = "";
	private Long idAfiliado = 0L;
	private Long idRol = 0L;
    
	// Valor Escritura-Lectura
	private boolean valor;
    // Opcion de busqueda
    private boolean opcion;
	
	public Sce_CrearReporteSolucionesHabitat(final boolean valor, final boolean opcion) {

		this.valor = valor;					// Variable de valor de Lectura/Escritura
	    this.opcion = opcion;				// Variable de opcion de busqueda Especifica|General
		
		
		// Obtener Id Empleado y UserName (eMail)
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) 
			{
				idEmpleado = result;				

				solucionesService.consultaEmpleadoRegistrado(idEmpleado, new AsyncCallback<AuxEmpleado>(){
					public void onFailure(Throwable caught) 
					{
						mensaje.setMensaje("alert alert-information alert-block", 
								"\nNo hay resultados");
					}

					@Override
					public void onSuccess(AuxEmpleado result)
					{	
						usrName = result.getEmail();
						
						System.out.println("ID Empleado: " + idEmpleado + ", Nombre de Usuario: " + usrName);
					}
				});
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
				System.out.println("Id Afiliado - 1: " + idAfiliado);	
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
		
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		grid.setSize("1117px", "100%");
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "98px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-Label-new");
		grid.setWidget(1, 0, absolutePanel_1);
		absolutePanel_1.setSize("1057px", "457px");
		
		lblAContinuacionSeleccione = new Label("A continuacion, seleccione lo que desea ver en el Reporte de Soluciones Construidas:");
		lblAContinuacionSeleccione.setStyleName("label");
		absolutePanel_1.add(lblAContinuacionSeleccione, 182, 75);
		lblAContinuacionSeleccione.setSize("651px", "13px");
		
		lblCreeElReporte = new Label("Cree el Reporte en base a un Solicitante en Especifico, Por tipo de Solucion o Todos");
		lblCreeElReporte.setStyleName("label");
		absolutePanel_1.add(lblCreeElReporte, 25, 10);
		lblCreeElReporte.setSize("828px", "13px");
		
		lblCargaFamiliar = new Label("Datos de Carga Familiares");
		lblCargaFamiliar.setStyleName("label");
		absolutePanel_1.add(lblCargaFamiliar, 138, 137);
		lblCargaFamiliar.setSize("222px", "13px");
		
		label_2 = new Label("Datos Academicos");
		label_2.setStyleName("label");
		absolutePanel_1.add(label_2, 138, 186);
		label_2.setSize("157px", "13px");
		
		label_4 = new Label("Datos Referencia Laboral");
		label_4.setStyleName("label");
		absolutePanel_1.add(label_4, 138, 244);
		label_4.setSize("198px", "13px");
		
		label_3 = new Label("Datos Referencia Personal");
		absolutePanel_1.add(label_3, 138, 300);
		label_3.setStyleName("label");
		
		label_6 = new Label("Idiomas Hablados");
		label_6.setStyleName("label");
		absolutePanel_1.add(label_6, 138, 362);
		label_6.setSize("157px", "13px");
	
		lbDato1 = new Label("Escriba el nombre del solicitante:");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		Label lblBusquedaPor = new Label("Empleados:");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("179px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
		lblSeleccioneLosEmpleados = new Label("Seleccione la opcion de solicitudes que quiere mostrar en el reporte");
		lblSeleccioneLosEmpleados.setStyleName("label");
		absolutePanel.add(lblSeleccioneLosEmpleados, 225, 92);
		lblSeleccioneLosEmpleados.setSize("495px", "13px");
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
		listBox.addItem("Solucion");
		listBox.addItem("Todos");
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(true);
					
					txtNombreSolicitante.setVisible(true);
					listSolucionConstruir.setVisible(false);

				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(false);
					
					txtNombreSolicitante.setVisible(false);
					listSolucionConstruir.setVisible(false);

				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Solucion"))
				{
					listSolucionConstruir.clear();
					listSolucionConstruir.addItem("Casa Nueva","0");
					listSolucionConstruir.addItem("Mejoramiento","1");
					listSolucionConstruir.addItem("Adiciones Menores","2");
					
					lbDato1.setText("Seleccione segun Solucion");

					lbDato1.setVisible(true);
					
					txtNombreSolicitante.setVisible(false);
					listSolucionConstruir.setVisible(true);

				}
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
		
		txtNombreSolicitante =  new SuggestBox(resultadoFormulario());
		txtNombreSolicitante.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER){
					buscar();
				}

			}
		});
		txtNombreSolicitante.setStylePrimaryName("gwt-TextBox2");
		txtNombreSolicitante.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreSolicitante, 205, 19);
		txtNombreSolicitante.setSize("250px", "34px");
		
		listSolucionConstruir = new ListBox();
		listSolucionConstruir.addItem("Casa Nueva","0");
		listSolucionConstruir.addItem("Mejoramiento","1");
		listSolucionConstruir.addItem("Adiciones Menores","2");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		listSolucionConstruir.setVisible(false);
		absolutePanel.add(listSolucionConstruir, 205, 16);
		listSolucionConstruir.setSize("179px", "39px");
		
		Busqueda = new Image("images/pdf.png");
		absolutePanel.add(Busqueda, 35, 65);
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				buscar();
			}
		});
		Busqueda.setSize("103px", "78px");
		
		initWidget(grid);
		
		checkCargaFamiliar = new SimpleCheckBox();
		absolutePanel_1.add(checkCargaFamiliar, 93, 137);
		checkCargaFamiliar.setSize("22px", "22px");
		
		cheqAcademicos = new SimpleCheckBox();
		absolutePanel_1.add(cheqAcademicos, 93, 186);
		cheqAcademicos.setSize("22px", "22px");
		
		cheqReferenciaLaboral = new SimpleCheckBox();
		absolutePanel_1.add(cheqReferenciaLaboral, 93, 244);
		cheqReferenciaLaboral.setSize("22px", "22px");
		
		cheqReferenciaPersonal = new SimpleCheckBox();
		absolutePanel_1.add(cheqReferenciaPersonal, 93, 300);
		cheqReferenciaPersonal.setSize("22px", "22px");
		
		cheqIdiomas = new SimpleCheckBox();
		absolutePanel_1.add(cheqIdiomas, 93, 362);
		cheqIdiomas.setSize("22px", "22px");
		
		
	}
	@SuppressWarnings("deprecation")
	public void buscar(){
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			Window.open("/CrearReporteSolucionesHabitat?tipo="+"2"
					+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex())
					+"&nombre="+"a"
					+"&idEmpleado="+idEmpleado
					+"&idAfiliado="+idAfiliado

					+"&familia="+checkCargaFamiliar.isChecked()
					+"&academico="+cheqAcademicos.isChecked()
					+"&reflab="+cheqReferenciaLaboral.isChecked()
					+"&refper="+cheqReferenciaPersonal.isChecked()
					+"&idiomas="+cheqIdiomas.isChecked(), "_blank", ""); 

		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
		{

			String nombreSolicitante = txtNombreSolicitante.getText();
			System.out.println("Data del solicitante para Crear Reporte: " + nombreSolicitante);
			
			if(!txtNombreSolicitante.getText().equals("")){

				Window.open("/CrearReporteSolucionesHabitat?tipo="+"1"
						+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex())
						+"&nombre="+nombreSolicitante
						+"&idEmpleado="+idEmpleado
						+"&idAfiliado="+idAfiliado
						
						+"&familia="+checkCargaFamiliar.isChecked()
						+"&academico="+cheqAcademicos.isChecked()
						+"&reflab="+cheqReferenciaLaboral.isChecked()
						+"&refper="+cheqReferenciaPersonal.isChecked()
						+"&idiomas="+cheqIdiomas.isChecked(), "_blank", "");
				
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Debe escribir el nombre del solicitante");
			}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Solucion"))
		{

			Window.open("/CrearReporteSolucionesHabitat?tipo="+"3"
					+"&solucion="+listSolucionConstruir.getValue(listSolucionConstruir.getSelectedIndex())
					+"&nombre="+"a"
					+"&idEmpleado="+idEmpleado
					+"&idAfiliado="+idAfiliado
					
					+"&cargaFamiliar="+checkCargaFamiliar.isChecked()
					+"&academico="+cheqAcademicos.isChecked()
					+"&reflab="+cheqReferenciaLaboral.isChecked()
					+"&refper="+cheqReferenciaPersonal.isChecked()
					+"&idiomas="+cheqIdiomas.isChecked(), "_blank", "");
			
		}
		
	}
	
	
	// RESULTADO BUSQUEDA

	MultiWordSuggestOracle resultadoFormulario()	
	{	
	    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	    
		// Obtener Id Empleado
		recursosHumanosService.obtenerId(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idEmpleado = result;
			
				// Obtener Id Afiliado
				recursosHumanosService.obtenerIdAfiliado(new AsyncCallback<Long>() {
					@Override
					public void onSuccess(Long result) {
						idAfiliado = result;
						
						System.out.println("Valores obtenidos para realizar busqueda: Id Empleado = " + idEmpleado + ", Id Afiliado = " + idAfiliado);
						
						if(opcion){
							System.out.println("Desplegar Solicitudes Ingresadas por Nombre de Solicitante");
							
							solucionesService.buscarFormulario('2', idEmpleado, idAfiliado, "", "", new AsyncCallback<List<AuxSolicitudGeneral>>(){

								public void onFailure(Throwable caught) 
								{
									load.invisible();
								}

								@Override
								public void onSuccess( List<AuxSolicitudGeneral> result)
								{
									for(AuxSolicitudGeneral p : result) 
									{
										oracle.add(p.getNombreSolicitante());
									}
								}

							});	
							
						}else{
							System.out.println("Desplegar Solicitudes en General por Nombre de Solicitante");
							
							solucionesService.buscarFormulario('4', idEmpleado, idAfiliado, "", "", new AsyncCallback<List<AuxSolicitudGeneral>>(){

								public void onFailure(Throwable caught) 
								{
									load.invisible();
								}

								@Override
								public void onSuccess( List<AuxSolicitudGeneral> result)
								{
									for(AuxSolicitudGeneral p : result) 
									{
										oracle.add(p.getNombreSolicitante());
									}
								}

							});	
							
						}
					    
						
					}
					@Override
					public void onFailure(Throwable caught) {
						mensaje.setMensaje("alert alert-error", "Error no tiene Afiliado asignado Empleado");
					}
				});
				
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
	    
	    return oracle;
    }
	
}
