/**0
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class CrearReporteEmpleados extends Composite   {

	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private Label lbDato1;
    private Image Busqueda;
    private SuggestBox txtDato1;
    private  ListBox listEstado ;
    private AbsolutePanel absolutePanel;
	public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
	public List <AuxAfiliado> BDAfiliados = new ArrayList<AuxAfiliado>();	
    private Loading load ;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private final SqlServiceAsync service = GWT.create(SqlService.class);
	private FormPanel formPanel;
	private VerticalPanel verticalPanel;
	private AbsolutePanel absolutePanel_1;
	private SimpleCheckBox simpleCheckBox;
	private SimpleCheckBox simpleCheckBox_1;
	private SimpleCheckBox simpleCheckBox_2;
	private SimpleCheckBox simpleCheckBox_3;
	private SimpleCheckBox simpleCheckBox_4;
	private Label label_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private Label label_6;
	private Label label_7;
	private Label lblCreeElReporte;
	private Label lblSeleccioneLosEmpleados;
	private SimpleCheckBox simpleCheckBox_5;
	private Label lblDatosDeEvaluacion;
	private DateBox dateTestFecha1;
	private DateBox dateTestFecha2;
	private ListBox listTipoTest;
	private SimpleCheckBox simpleCheckBox_6;
	private Label lblDatosDelHistorial;
	private DateBox dateHistorialFecha1;
	private DateBox dateHistorialFecha2;
	private ListBox listTipoHistorial;
	private SimpleCheckBox simpleCheckBox_7;
	private Label lblPuestos;
	private SimpleCheckBox simpleCheckBox_8;
	private Label lblDatosDePermiso;
	private DateBox datePermisosecha1;
	private DateBox datePermisosecha2;
	private ListBox listTipoPermiso;
	private SimpleCheckBox simpleCheckBox_9;
	private Label lblDatosDeSalario;
	private DateBox dateSalarioecha1;
	private DateBox dateSalarioecha2;
	private ListBox listTipoSalario;
    
    /**
     * constructor
     */
	public CrearReporteEmpleados() {

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
		
		
		
		listBox = new ListBox();
		listBox.addItem("Nombres");
		listBox.addItem("Afiliado");
		listBox.addItem("Pasaporte");
		listBox.addItem("Estado");
		listBox.addItem("Puesto");
		listBox.addItem("Todos");
		listBox.addItem("DPI");
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
				{
					lbDato1.setText("Ingrese el DPI");
					
					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(false);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(false);
					absolutePanel.add(Busqueda, 205, 16);

					grid.clearCell(1, 0);
//					agregarFormulario('2',txtDato1.getText(), "","", 
//							"",txtDato1.getText(),txtDato1.getText()
//							,"");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Pasaporte"))
				{
					lbDato1.setText("Ingrese No. Pasaporte");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
				{
					listEstado.clear();
					listEstado.addItem("empleado activo","0");
					listEstado.addItem("empleado inactivo","1");
					listEstado.addItem("posible empleado","2");
					listEstado.addItem("practicante","3");
					listEstado.addItem("interino","4");
					
					lbDato1.setText("Seleccione el Estado del empleado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un puesto","0");
				    for (AuxBDPuesto p : BDpuestos) 
				    {
				    	listEstado.addItem(p.getNombre_puesto(),""+p.getId_puesto());
				    }
					lbDato1.setText("Seleccione el puesto");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{

					listEstado.clear();
					listEstado.addItem("seleccione un afiliado","0");
				    for (AuxAfiliado p : BDAfiliados) 
				    {
				    	listEstado.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
				    }
					lbDato1.setText("Seleccione el Afiliado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
			        load.invisible();
				}
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
		
		txtDato1 =  new SuggestBox(createCountriesOracle());
		txtDato1.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER){
					buscar();
				}

			}
		});
		txtDato1.setStylePrimaryName("gwt-TextBox2");
		txtDato1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDato1, 205, 19);
		txtDato1.setSize("250px", "34px");
		
		listEstado = new ListBox();
		listEstado.addItem("empleado activo","0");
		listEstado.addItem("empleado inactivo","1");
		listEstado.addItem("posible empleado","2");
		listEstado.addItem("practicante","3");
		listEstado.addItem("interino","4");
		listEstado.setStyleName("gwt-TextBox2");
		listEstado.setVisible(false);
		absolutePanel.add(listEstado, 205, 16);
		listEstado.setSize("179px", "39px");
		
		lbDato1 = new Label("Escriba los nombres:");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		Label lblBusquedaPor = new Label("Empleados:");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("179px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);

		formPanel = new FormPanel();
		formPanel.setAction("/ExportBancos?tipo="+"0"
				+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())
				+"&annio="+"2000"
				+"&primer_nombre="+"a"
				+"&segundo_nombre="+"a"
				+"&primer_apellido="+"a"
				+"&segundo_apellido="+"a"
				+"&DPI="+"a"
				+"&Pasaporte="+"a"
				+"&listMes="+"a");
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		absolutePanel.add(formPanel, 10, 61);
        formPanel.setSize("209px", "44px");
        
		Busqueda = new Image("images/pdf.png");
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				buscar();
			}
		});
		Busqueda.setSize("103px", "78px");
		
		verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 20, 61);
		verticalPanel.setSize("118px", "82px");
		verticalPanel.add(Busqueda);
		
		lblSeleccioneLosEmpleados = new Label("Seleccione los empleados que quiere mostrar en el reporte");
		lblSeleccioneLosEmpleados.setStyleName("label");
		absolutePanel.add(lblSeleccioneLosEmpleados, 225, 92);
		lblSeleccioneLosEmpleados.setSize("828px", "13px");
		
		
    	loginService.BDPuesto(new AsyncCallback<List<AuxBDPuesto>>(){
    		public void onFailure(Throwable caught) 
    		{
    			mensaje.setMensaje("alert alert-success", "Error en BD puestos\n"+caught);
    		}

			@Override
			public void onSuccess(List<AuxBDPuesto> results)
			{
				if (!(results.size()==0)) {
					BDpuestos = results;
		    	}	
			}
		});

		service.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>(){
		    public void onFailure(Throwable caught) 
		    {
		    }
		
			@Override
		    public void onSuccess(List<AuxAfiliado> result)
		    {
				if (!(result.size()==0)) {
					BDAfiliados = result;
		    	}
		    }
		});
		initWidget(grid);
		
		absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-Label-new");
		grid.setWidget(1, 0, absolutePanel_1);
		absolutePanel_1.setSize("1096px", "550px");
		
		simpleCheckBox = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox, 25, 136);
		simpleCheckBox.setSize("22px", "22px");
		
		simpleCheckBox_1 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_1, 25, 183);
		simpleCheckBox_1.setSize("22px", "22px");
		
		simpleCheckBox_2 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_2, 25, 233);
		simpleCheckBox_2.setSize("22px", "22px");
		
		simpleCheckBox_3 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_3, 25, 299);
		simpleCheckBox_3.setSize("22px", "22px");
		
		simpleCheckBox_4 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_4, 25, 361);
		simpleCheckBox_4.setSize("22px", "22px");
		
		label_7 = new Label("A continuacion, seleccione lo que desea ver en el Reporte por Empleado:");
		label_7.setStyleName("label");
		absolutePanel_1.add(label_7, 182, 75);
		label_7.setSize("583px", "13px");
		
		lblCreeElReporte = new Label("Cree el Reporte en base a un Empleado Especifico,Por Afiliado, por DPI, por Pasaporte, Por Nombre, Por Estado o a todos los Empleados");
		lblCreeElReporte.setStyleName("label");
		absolutePanel_1.add(lblCreeElReporte, 25, 10);
		lblCreeElReporte.setSize("828px", "13px");
		
		simpleCheckBox_5 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_5, 350, 136);
		simpleCheckBox_5.setSize("22px", "22px");
		
		dateTestFecha1 = new DateBox();
		dateTestFecha1.setValue(new Date());
		dateTestFecha1.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateTestFecha1.getDatePicker().setYearArrowsVisible(true);
		dateTestFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateTestFecha1.getDatePicker().setVisibleYearCount(100);
		dateTestFecha1.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(dateTestFecha1, 558, 124);
		dateTestFecha1.setSize("88px", "34px");
		
		dateTestFecha2 = new DateBox();
		dateTestFecha2.setValue(new Date());
		dateTestFecha2.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateTestFecha2.getDatePicker().setYearArrowsVisible(true);
		dateTestFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateTestFecha2.getDatePicker().setVisibleYearCount(100);
		dateTestFecha2.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(dateTestFecha2, 654, 124);
		dateTestFecha2.setSize("88px", "34px");
		
		listTipoTest = new ListBox();
		listTipoTest.addItem("Desempeño","1");
		listTipoTest.addItem("Evaluacion","2");
		listTipoTest.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(listTipoTest, 750, 124);
		listTipoTest.setSize("119px", "36px");
		
		simpleCheckBox_6 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_6, 350, 198);
		simpleCheckBox_6.setSize("22px", "22px");
		
		dateHistorialFecha1 = new DateBox();
		dateHistorialFecha1.setValue(new Date());
		dateHistorialFecha1.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateHistorialFecha1.getDatePicker().setYearArrowsVisible(true);
		dateHistorialFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateHistorialFecha1.getDatePicker().setVisibleYearCount(100);
		dateHistorialFecha1.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(dateHistorialFecha1, 558, 186);
		dateHistorialFecha1.setSize("88px", "34px");
		
		dateHistorialFecha2 = new DateBox();
		dateHistorialFecha2.setValue(new Date());
		dateHistorialFecha2.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateHistorialFecha2.getDatePicker().setYearArrowsVisible(true);
		dateHistorialFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateHistorialFecha2.getDatePicker().setVisibleYearCount(100);
		dateHistorialFecha2.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(dateHistorialFecha2, 654, 186);
		dateHistorialFecha2.setSize("88px", "34px");
		
		listTipoHistorial = new ListBox();
		listTipoHistorial.addItem("aciertos ","0");
		listTipoHistorial.addItem("llamadas de atención","1");
		listTipoHistorial.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(listTipoHistorial, 750, 186);
		listTipoHistorial.setSize("119px", "36px");
		
		simpleCheckBox_7 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_7, 350, 361);
		simpleCheckBox_7.setSize("22px", "22px");
		
		simpleCheckBox_8 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_8, 350, 256);
		simpleCheckBox_8.setSize("22px", "22px");
		
		datePermisosecha1 = new DateBox();
		datePermisosecha1.setValue(new Date());
		datePermisosecha1.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		datePermisosecha1.getDatePicker().setYearArrowsVisible(true);
		datePermisosecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		datePermisosecha1.getDatePicker().setVisibleYearCount(100);
		datePermisosecha1.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(datePermisosecha1, 558, 244);
		datePermisosecha1.setSize("88px", "34px");
		
		datePermisosecha2 = new DateBox();
		datePermisosecha2.setValue(new Date());
		datePermisosecha2.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		datePermisosecha2.getDatePicker().setYearArrowsVisible(true);
		datePermisosecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		datePermisosecha2.getDatePicker().setVisibleYearCount(100);
		datePermisosecha2.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(datePermisosecha2, 654, 244);
		datePermisosecha2.setSize("88px", "34px");
		
		listTipoPermiso = new ListBox();
		listTipoPermiso.addItem("Vacaciones con goce salaria","0");
		listTipoPermiso.addItem("Vacaciones sin goce salaria","1");
		listTipoPermiso.addItem("Permiso con goce salarial","2");
		listTipoPermiso.addItem("Permiso sin goce salarial","3");
		listTipoPermiso.addItem("Suspension con goce salarial","4");
		listTipoPermiso.addItem("Suspension sin goce salarial","5");
		listTipoPermiso.addItem("Ausencia con goce salarial","6");
		listTipoPermiso.addItem("Ausencia sin goce salarial","7");
		listTipoPermiso.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(listTipoPermiso, 750, 244);
		listTipoPermiso.setSize("119px", "36px");
		
		simpleCheckBox_9 = new SimpleCheckBox();
		absolutePanel_1.add(simpleCheckBox_9, 350, 311);
		simpleCheckBox_9.setSize("22px", "22px");
		
		dateSalarioecha1 = new DateBox();
		dateSalarioecha1.setValue(new Date());
		dateSalarioecha1.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateSalarioecha1.getDatePicker().setYearArrowsVisible(true);
		dateSalarioecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateSalarioecha1.getDatePicker().setVisibleYearCount(100);
		dateSalarioecha1.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(dateSalarioecha1, 558, 299);
		dateSalarioecha1.setSize("88px", "34px");
		
		dateSalarioecha2 = new DateBox();
		dateSalarioecha2.setValue(new Date());
		dateSalarioecha2.setFormat(new DateBox.DefaultFormat 
				    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateSalarioecha2.getDatePicker().setYearArrowsVisible(true);
		dateSalarioecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateSalarioecha2.getDatePicker().setVisibleYearCount(100);
		dateSalarioecha2.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(dateSalarioecha2, 654, 299);
		dateSalarioecha2.setSize("88px", "34px");
		
		listTipoSalario = new ListBox();
		listTipoSalario.addItem("Salario Base", "0");
		listTipoSalario.addItem("Decreto(78-89)", "1");
		listTipoSalario.addItem("Comisiones", "2");
		listTipoSalario.addItem("Bonificacion", "3");
		listTipoSalario.addItem("Bono 14", "4");
		listTipoSalario.addItem("Aguinaldo", "5");
		listTipoSalario.addItem("Vacaciones", "6");
		listTipoSalario.addItem("Indemnizacion", "7");
		listTipoSalario.addItem("Otros pagos", "8");
		listTipoSalario.setStyleName("gwt-TextBox2");
		absolutePanel_1.add(listTipoSalario, 750, 299);
		listTipoSalario.setSize("119px", "36px");
		
		lblPuestos = new Label("Puestos");
		lblPuestos.setStyleName("label");
		absolutePanel_1.add(lblPuestos, 395, 365);
		lblPuestos.setSize("157px", "13px");
		
		lblDatosDeSalario = new Label("Datos de Salario");
		lblDatosDeSalario.setStyleName("label");
		absolutePanel_1.add(lblDatosDeSalario, 395, 313);
		lblDatosDeSalario.setSize("157px", "13px");
		
		lblDatosDePermiso = new Label("Datos de Permisos");
		lblDatosDePermiso.setStyleName("label");
		absolutePanel_1.add(lblDatosDePermiso, 395, 258);
		lblDatosDePermiso.setSize("157px", "13px");
		
		lblDatosDelHistorial = new Label("Datos del HIstorial:");
		lblDatosDelHistorial.setStyleName("label");
		absolutePanel_1.add(lblDatosDelHistorial, 395, 200);
		lblDatosDelHistorial.setSize("157px", "13px");
		
		lblDatosDeEvaluacion = new Label("Datos de Evaluacion:");
		lblDatosDeEvaluacion.setStyleName("label");
		absolutePanel_1.add(lblDatosDeEvaluacion, 395, 138);
		lblDatosDeEvaluacion.setSize("157px", "13px");
		
		label_1 = new Label("Datos de Familia");
		label_1.setStyleName("label");
		absolutePanel_1.add(label_1, 70, 138);
		label_1.setSize("157px", "13px");
		
		label_2 = new Label("Datos Academicos");
		label_2.setStyleName("label");
		absolutePanel_1.add(label_2, 70, 186);
		label_2.setSize("157px", "13px");
		
		label_4 = new Label("Datos Referencia Laboral");
		label_4.setStyleName("label");
		absolutePanel_1.add(label_4, 70, 237);
		label_4.setSize("198px", "13px");
		
		label_3 = new Label("Datos Referencia Personal");
		absolutePanel_1.add(label_3, 70, 299);
		label_3.setStyleName("label");
		
		label_6 = new Label("Idiomas Hablados");
		label_6.setStyleName("label");
		absolutePanel_1.add(label_6, 70, 365);
		label_6.setSize("157px", "13px");
		
	}
	public void buscar(){
		grid.clearCell(1, 0);
		if(listBox.getItemText(listBox.getSelectedIndex()).equals("Todos"))
		{
			formPanel.setAction("/ExportBancos?tipo="+"2");
			formPanel.submit();
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Nombres"))
		{

			String nombre = txtDato1.getText().replace(" ", ":");
			System.out.println(nombre);
			if(!txtDato1.getText().equals("")){

				formPanel.setAction("/ExportBancos?tipo="+"1");
				formPanel.submit();
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba al menos un dato");
			}
		}else if(listBox.getValue(listBox.getSelectedIndex()).equals("Pasaporte"))
		{
			if(!txtDato1.getText().equals("") ){

				formPanel.setAction("/ExportBancos?tipo="+"3");
				formPanel.submit();
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba el No pasaporte");
    		}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("DPI"))
		{

			if(!txtDato1.getText().equals("") ){
				formPanel.setAction("/ExportBancos?tipo="+"4");
				formPanel.submit();
			}
			else{

    			mensaje.setMensaje("alert alert-info", "Escriba el DPI");
    		}
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Estado"))
		{

			formPanel.setAction("/ExportBancos?tipo="+"5");
			formPanel.submit();
		}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Puesto"))
		{

			formPanel.setAction("/ExportBancos?tipo="+"6");
			formPanel.submit();
		}
		else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
		{
			formPanel.setAction("/ExportBancos?tipo="+"7");
			formPanel.submit();
		}
	}
//	 public void agregarFormulario(final char tipo, final String primer_nombre, String segundo_nombre, 
//				String primer_apellido, String segundo_apellido,String DPI, String Pasaporte,String Estado){
//
//	        load.visible();
//	    	loginService.Buscar_Empleado(tipo, primer_nombre, segundo_nombre, 
//							primer_apellido, segundo_apellido,DPI, Pasaporte,Estado,new AsyncCallback<List<AuxEmpleado>>(){
//	            public void onFailure(Throwable caught) 
//	            {
//			        load.invisible();
//	            	mensaje.setMensaje("alert alert-information alert-block", "\nNo hay resultados");
//	            }
//
//				@Override
//	            public void onSuccess( List<AuxEmpleado> result)
//	            {
//					if(!result.isEmpty()){
//						//Bancos(result,listMes.getValue(listMes.getSelectedIndex()),listAnnio.getItemText(listAnnio.getSelectedIndex()));
//					}
//	            }
//
//	     });
//
//	    }
	 
//
//	 	private void Bancos(List<AuxEmpleado> result, String listMes,String listAnio)
//	 	{
//	 		String nombre = "";
//	 		int i = 0;
//	 		float salarioCalculo = 0;
//	 		float enero = 0, Bono = 0;
//	 		float febrero= 0 , marzo = 0;
//	 		float abril= 0, mayo = 0;
//	 		float junio= 0, julio = 0;
//	 		float agosto= 0, septiembre = 0;
//	 		float octubre= 0, noviembre = 0;
//	 		float diciembre= 0;
//	 		
//	 		boolean bEnero = true;
//	 		boolean bFebrero = true;
//	 		boolean bMarzo	= true;
//	 		boolean bAbril = true;
//	 		boolean bMayo = true;
//	 		boolean bJunio = true;
//	 		boolean bJulio = true;
//	 		boolean bAgosto = true;
//	 		boolean bSeptiembre = true;
//	 		boolean bOctubre = true;
//	 		boolean bNoviembre = true;
//	 		boolean bDiciembre = true;
//	 		
//	 		DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
//	 		DateTimeFormat mes 	= DateTimeFormat.getFormat("MM");
//	 		int ultimoAnnio = 0;
//	 		int ultimoMes = 0;
//	 		float ultimoSalario = 0;
//	 		String formatAnio 	= "";
//	 		String formatMes 	= "";
//	 		
//	 		for(AuxEmpleado e:result)
//	 		{
//	 			nombre = e.getPrimer_nombre() +" "+ e.getSegundo_nombre() +" "+e.getPrimer_apellido() +" "+e.getSegundo_apellido(); 
//	 			for(AuxSalario s:e.getSalario())
//	 			{
//	 				formatAnio = anio.format(new Date(s.getFecha()));
//	 				formatMes  = mes.format(new Date(s.getFecha()));
//	 				
//	 				//verifico el ultimo salario que tiene el empleado, si en caso:
//	 				//esto primero verificando que el año del ultimo salario, este no sea de una fecha despues de la que se quiere calcular
//	 				//fecha del salario menor o igual que el año a calcular
//	 				if(Integer.parseInt(formatAnio) <= Integer.parseInt(listAnio))
//	 				{
//	 					//luego de lo anterior verifico que el año del salario y el mes del salario a tomar en cuenta
//	 					//es mayor o igual a la fecha del ultimo salario, si es asi, entonces ese salario sera el ultimo
//	 					//y asi hasta encontrar el ultimo entre la fecha a calcular hasta antes de esa fecha
//	 					if(Integer.parseInt(formatAnio) >= ultimoAnnio && Integer.parseInt(formatMes) >= ultimoMes)
//	 					{
//	 						ultimoAnnio 	= Integer.parseInt(formatAnio);
//	 				 		ultimoMes 		= Integer.parseInt(formatMes);
//	 				 		ultimoSalario 	=  s.getSalario();
//	 					}
//	 				}
//	 				//*********************************************************************************
//	 				/**
//	 				 * por si cada mes no tuviera un salario en especifico, entonces se le asigna el ultimo salario calculado
//	 				 * este salario para asignarle, el año debera ser menor o igual al año a calcular, y ademas el mes en 
//	 				 * cuestion a asignarle el ultimo salario, el mes del ultimo salario debera ser menor o igual al mes al
//	 				 * que se le va asignar el ultimo salario, en caso contrario ese mes, tendra salario = 0;
//	 				 */
//	 				//salario de enero
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("01")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					enero = s.getSalario();
//	 					bEnero = false;
//	 				}else if(bEnero && s.getTipoSalario().equals("0") &&
//	 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 01 && ultimoAnnio == Integer.parseInt(listAnio)) )
//	 						)
//	 				{
//	 					enero = ultimoSalario;
//	 				}
//	 				
//	 				//salario de febrero
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("02")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					febrero = s.getSalario();
//	 					bFebrero  = false;
//	 				}else if(bFebrero && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 02 && ultimoAnnio == Integer.parseInt(listAnio))) 
// 							)
//	 				{
//	 					febrero = ultimoSalario;
//	 				}
//	 				
//	 				//salario de marzo
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("03")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					marzo = s.getSalario();
//	 					bMarzo  = false;
//	 				}else if(bMarzo && s.getTipoSalario().equals("0")&&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 03 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					marzo = ultimoSalario;
//	 				}
//	 				
//	 				//salario de abril
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("04")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					abril = s.getSalario();
//	 					bAbril  = false;
//	 				}else if(bAbril && s.getTipoSalario().equals("0")&&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 04 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					abril = ultimoSalario;
//	 				}
//	 				
//	 				//salario de mayo
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("05")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					mayo = s.getSalario();
//	 					bMayo  = false;
//	 				}else if(bMayo && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 05 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					mayo = ultimoSalario;
//	 				}
//	 				
//	 				//salario de junio
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("06")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					junio = s.getSalario();
//	 					bJunio  = false;
//	 				}else if(bJunio && s.getTipoSalario().equals("0")&&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 06 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					junio = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de julio
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("07")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					julio = s.getSalario();
//	 					bJulio  = false;
//	 				}else if(bJulio && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 07 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					julio = ultimoSalario;
//	 				}
//	 				
//	 				//salario de agosto
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("08")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					agosto = s.getSalario();
//	 					bAgosto  = false;
//	 				}else if(bAgosto && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 8 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					agosto = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de septiembre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("09")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					septiembre = s.getSalario();
//	 					bSeptiembre  = false;
//	 				}else if(bSeptiembre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 9 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					septiembre = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de octubre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("10")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					octubre = s.getSalario();
//	 					bOctubre  = false;
//	 				}else if(bOctubre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 10 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					octubre = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de noviembre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("11")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					noviembre = s.getSalario();
//	 					bNoviembre  = false;
//	 				}else if(bNoviembre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 11 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					noviembre = ultimoSalario;
//	 				}
//	 				
//
//	 				//salario de diciembre
//	 				if(formatAnio.equals(listAnio) && formatMes.equals("12")
//	 				   && s.getTipoSalario().equals("0"))
//	 				{
//	 					diciembre = s.getSalario();
//	 					bDiciembre  = false;
//	 				}else if(bDiciembre && s.getTipoSalario().equals("0") &&
// 							(ultimoAnnio < Integer.parseInt(listAnio) || (ultimoMes <= 12 && ultimoAnnio == Integer.parseInt(listAnio)))
// 							)
//	 				{
//	 					diciembre = ultimoSalario;
//	 				}
//	 				
//	 				//*********************************************************************************
//	 				
//	 				//*********************************************************************************
//	 				//bonos
//	 				if(formatAnio.equals(listAnio) && formatMes.equals(listMes)
//	 	 				   && s.getTipoSalario().equals("3"))
//	 				{
//	 					Bono += s.getSalario();
//	 				}
//	 				//*********************************************************************************
//	 				
//	 				
//	 			}//fin for salario
//	 			
//
// 				//****************************************calculo de planilla del mes a calcular*****************************************
//	 			
//	 			if(Integer.parseInt(listMes) == 01){
//	 				salarioCalculo = (float) (enero - (enero*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 02){
//	 				salarioCalculo = (float) (febrero- (febrero*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 03){
//	 				salarioCalculo = (float) (marzo - (marzo*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 04){
//	 				salarioCalculo = (float) (abril - (abril*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 05){
//	 				salarioCalculo = (float) (mayo - (mayo*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 06){
//	 				salarioCalculo = (float) (junio - (junio*4.83/100) + Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 07){
//	 				salarioCalculo = (float) (julio - (julio*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 8){
//	 				salarioCalculo = (float) (agosto - (agosto*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 9){
//	 				salarioCalculo = (float) (septiembre - (septiembre*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 10){
//	 				salarioCalculo = octubre + Bono;
//	 				
//	 			}else if(Integer.parseInt(listMes) == 11){
//	 				salarioCalculo = (float) (noviembre - (noviembre*4.83/100)+ Bono);
//	 				
//	 			}else if(Integer.parseInt(listMes) == 12){
//	 				salarioCalculo = (float) (diciembre - (diciembre*4.83/100)+ Bono);
//	 				
//	 			}
//	 			String tipoCuenta = "";
//	 			if(e.getTipoCuenta().equals("0")){
//	 				tipoCuenta = "Ahorro";
//	 			}else{
//	 				tipoCuenta = "Monetaria";
//	 			}
//	 			//aqui se crea cada fila con sus respectivas columnas para el excel
//	 			enero = 0;
//	 			febrero = 0;
//	 			marzo = 0;
//	 			abril = 0;
//	 			mayo = 0;
//	 			junio = 0;
//	 			julio = 0;
//	 			agosto = 0;
//	 			septiembre = 0;
//	 			octubre = 0;
//	 			noviembre = 0;
//	 			diciembre = 0;
//	 			
//	 			Bono = 0;
//	 		}//fin for empleado
//	        load.invisible();
//	 	}
//	 	
	 	MultiWordSuggestOracle createCountriesOracle()
		{
		    final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		    
		    loginService.Buscar_Empleado('2', "", "", 
		    		"", "","", "","",new AsyncCallback<List<AuxEmpleado>>(){
			    public void onFailure(Throwable caught) 
			    {
			        load.invisible();
			    }
			
				@Override
			    public void onSuccess( List<AuxEmpleado> result)
			    {
					for(AuxEmpleado p : result) 
					{
						oracle.add(p.getPrimer_nombre()+" "+p.getSegundo_nombre()+" "+p.getPrimer_apellido()+" "+p.getSegundo_apellido());
					}
			    }
			
			});
		    return oracle;
	    }
}
