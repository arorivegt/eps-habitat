package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTipoSolucion;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.datepicker.client.DateBox;

public class ReporteComparativoSolucion extends Composite{
	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private ListBox listaTrimestre;
    private Label lbDato1;
    private Label lbDato2;
    private Image Busqueda;
    private TextBox txt1;
    private TextBox txt2;
    private SuggestBox txtDato1;
    private  ListBox listEstado ;
    private DateBox dateBox;
    private AbsolutePanel absolutePanel;
	public List <AuxTipoSolucion> BDTipos = new ArrayList<AuxTipoSolucion>();	
	public List <AuxAfiliado> BDAfiliados = new ArrayList<AuxAfiliado>();	
    private Loading load ;
	private AbsolutePanel absolutePanel_1;
	private Label lblSeleccioneLosEmpleados;
	
	private long idBeneficiario;
	TablaGWT_SolucionGeneral e = null;
	private BeneNameSuggestOracle bene;
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    
    /**
     * constructor
     */
    public ReporteComparativoSolucion() {
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		grid.setSize("1117px", "100%");
		idBeneficiario = 0L;
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "50px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		bene = new BeneNameSuggestOracle();
		
		listBox = new ListBox();
		listBox.addItem("Seleccione Criterio");
		listBox.addItem("Afiliado");
		listBox.addItem("Trimestre y Año");
		listBox.addItem("Rango de Monto Ejecutado");
		listBox.addItem("Tipo de Solución");
		listBox.addItem("General");
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Trimestre y Año"))
				{
					lbDato1.setText("Seleccione Trimestre");

					lbDato1.setVisible(true);
					
					lbDato2.setText("Selecione Año");
					lbDato2.setVisible(true);
					
					listaTrimestre.clear();
					listaTrimestre.addItem("Enero a Marzo", "1");
					listaTrimestre.addItem("Abril a Junio", "2");
					listaTrimestre.addItem("Julio a Septiembre", "3");
					listaTrimestre.addItem("Octubre a Diciembre", "4");
					
					
					listaTrimestre.setVisible(true);
					dateBox.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("General"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(false);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(false);
					listaTrimestre.setVisible(false);

					//grid.clearCell(1, 0);
//					agregarFormulario('2',txtDato1.getText(), "","", 
//							"",txtDato1.getText(),txtDato1.getText()
//							,"");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{

					listaTrimestre.clear();
					listaTrimestre.addItem("Seleccione un afiliado","0");
				    for (AuxAfiliado p : BDAfiliados) 
				    {
				    	listaTrimestre.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
				    }
					lbDato1.setText("Seleccione el Afiliado");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listaTrimestre.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
					
					lbDato2.setVisible(false);
					dateBox.setVisible(false);
			        load.invisible();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Rango de Monto Ejecutado"))
				{

					lbDato1.setText("Monto Mínimo");

					lbDato1.setVisible(true);
					
					lbDato2.setText("Monto Máximo");
					lbDato2.setVisible(true);
					
					txt1.setVisible(true);
					txt2.setVisible(true);
					listaTrimestre.setVisible(false);
					dateBox.setVisible(false);

				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Tipo de Solución"))
				{

					listaTrimestre.clear();
					listaTrimestre.addItem("CASA COMPLETA","CASA COMPLETA");
				    for (AuxTipoSolucion p : BDTipos) 
				    {
				    	listaTrimestre.addItem(p.getIdTipoSolucion(),p.getIdTipoSolucion());
				    }
					lbDato1.setText("Seleccione Tipo Solución");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(false);
					listaTrimestre.setVisible(true);
					//absolutePanel.add(Busqueda, 390, 19);
					
					lbDato2.setVisible(false);
					dateBox.setVisible(false);
					
					txt1.setVisible(false);
					txt2.setVisible(false);
			        load.invisible();

				}
			}	
		});
		loginService.ConsultaTodosBene(new AsyncCallback<List<AuxBeneficiario>>() {
			
			@Override
			public void onSuccess(List<AuxBeneficiario> result) {
				if (!result.isEmpty()){
					for (AuxBeneficiario p : result){
						bene.add(new BeneMultiWordSuggestion(p));	
					}
				}

			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});
		
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 10, 16);
		listBox.setSize("179px", "39px");
		
		txtDato1 =  new SuggestBox(bene);
		txtDato1.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode()== KeyCodes.KEY_ENTER){
					//buscar();
				}

			}
		});
		
		txtDato1.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
			
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				// TODO Auto-generated method stub
				BeneMultiWordSuggestion select = (BeneMultiWordSuggestion)event.getSelectedItem();
				idBeneficiario = select.getAfiliado().getIdBeneficiario();
				
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
		
		
		listaTrimestre = new ListBox();
		listaTrimestre.setStyleName("gwt-TextBox2");
		listaTrimestre.setVisible(false);
		absolutePanel.add(listaTrimestre, 205, 16);
		listaTrimestre.setSize("179px", "39px");
		
		
		lbDato2 = new Label();
		lbDato2.setVisible(false);
		lbDato2.setStyleName("label");
		absolutePanel.add(lbDato2, 400, 0);
		lbDato2.setSize("179px", "39px");
		
		dateBox = new DateBox();
		dateBox.setFormat(new DateBox.DefaultFormat 
        		(DateTimeFormat.getFormat("yyyy")));
        dateBox.setValue(new Date());
        dateBox.getTextBox().setReadOnly(true);
        dateBox.setFireNullValues(true);
        dateBox.setStyleName("gwt-PasswordTextBox");
        
        dateBox.getDatePicker().setVisibleYearCount(100);
        dateBox.getDatePicker().setYearArrowsVisible(true);
        dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
		
        dateBox.setVisible(false);
		absolutePanel.add(dateBox, 400, 16);
		dateBox.setSize("150px", "39px");
		
		
		txt1 = new TextBox();
		txt1.setStylePrimaryName("gwt-TextBox2");
		txt1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt1, 205, 19);
		txt1.setSize("180px", "34px");
		txt1.setVisible(false);
		
		txt2 = new TextBox();
		txt2.setStylePrimaryName("gwt-TextBox2");
		txt2.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt2, 400, 19);
		txt2.setSize("180px", "34px");
		txt2.setVisible(false);
		
		lbDato1 = new Label("Seleccione Trimestre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("368px", "19px");
		absolutePanel.add(lbDato1, 205, 0);
		
		Label lblBusquedaPor = new Label("Busqueda Por");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("179px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
		Busqueda = new Image("images/pdf.png");
		absolutePanel.add(Busqueda, 600, 5);
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Trimestre y Año"))
				{
					buscar();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("General"))
				{
					BuscarGeneral();
					
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{
					BuscarAfiliado();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Rango de Monto Ejecutado"))
				{
					BuscarRangoMonto();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Tipo de Solución"))
				{
					BuscarTipoSolucion();
				}
				
			}
		});
		Busqueda.setSize("103px", "78px");
		
		lblSeleccioneLosEmpleados = new Label("Seleccione los empleados que quiere mostrar en el reporte");
		lblSeleccioneLosEmpleados.setStyleName("label");
		absolutePanel.add(lblSeleccioneLosEmpleados, 700, 5);
		lblSeleccioneLosEmpleados.setSize("828px", "13px");
		
		

		loginService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>(){
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
		
		loginService.Consultar_TipoSolucion(new AsyncCallback<List<AuxTipoSolucion>>() {
			
			@Override
			public void onSuccess(List<AuxTipoSolucion> result) {
				
				BDTipos = result;
		
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});

		initWidget(grid);
		
		absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-Label-new");
		grid.setWidget(1, 0, absolutePanel_1);
		absolutePanel_1.setSize("1096px", "550px");
		
		lbDato1.setVisible(false);
		
		txtDato1.setVisible(false);

		
		
		
	}
	
	
	
	

	protected void BuscarTipoSolucion() {
		// TODO Auto-generated method stub
		System.out.println("Tipos solucion: "+ listaTrimestre.getValue(listaTrimestre.getSelectedIndex()));
		loginService.Consulta_ComparativoPlaniEjecucionSolucion_TipoSolucion(listaTrimestre.getValue(listaTrimestre.getSelectedIndex()),new AsyncCallback<List<AuxSolucion>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<AuxSolucion> result) {
				// TODO Auto-generated method stub
				
				if(!result.isEmpty()){
				e = new TablaGWT_SolucionGeneral(result);
				grid.setWidget(1, 0,e);
				e.setSize("1700px", "300px");
				}else{
					e = new TablaGWT_SolucionGeneral(new ArrayList<AuxSolucion>());
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
				}
				
			}
		});
		
	}





	protected void BuscarRangoMonto() {
		// TODO Auto-generated method stub
		
		System.out.println("Rango: "+ txt1.getText()+" "+txt2.getText());
		loginService.Consulta_ComparativoPlaniEjecucionSolucion_RangoMontos(Double.valueOf(txt1.getText()),Double.valueOf(txt2.getText()),new AsyncCallback<List<AuxSolucion>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<AuxSolucion> result) {
				// TODO Auto-generated method stub
				
				if(!result.isEmpty()){
				e = new TablaGWT_SolucionGeneral(result);
				grid.setWidget(1, 0,e);
				e.setSize("1700px", "300px");
				}else{
					e = new TablaGWT_SolucionGeneral(new ArrayList<AuxSolucion>());
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
				}
				
			}
		});
		
	}





	public void buscar(){
		System.out.println("Trimestre y Año"+ listaTrimestre.getValue(listaTrimestre.getSelectedIndex())+ " año" + dateBox.getTextBox().getText());
		loginService.Consulta_ComparativoPlaniEjecucionSolucion_Opcion1(dateBox.getTextBox().getText(),listaTrimestre.getValue(listaTrimestre.getSelectedIndex()),new AsyncCallback<List<AuxSolucion>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<AuxSolucion> result) {
				// TODO Auto-generated method stub
				
				if(!result.isEmpty()){
				e = new TablaGWT_SolucionGeneral(result);
				grid.setWidget(1, 0,e);
				e.setSize("1700px", "300px");
				}else{
					e = new TablaGWT_SolucionGeneral(new ArrayList<AuxSolucion>());
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
				}
				
			}
		});
		
	}
	
	public void BuscarGeneral(){
		System.out.println("General");
		loginService.Consulta_ComparativoPlaniEjecucionSolucion(new AsyncCallback<List<AuxSolucion>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<AuxSolucion> result) {
				// TODO Auto-generated method stub
				e = new TablaGWT_SolucionGeneral(result);
				grid.setWidget(1, 0,e);
				e.setSize("1700px", "300px");
				
			}
		});
	}
	
	public void BuscarAfiliado(){
		System.out.println("Afiliado: "+ listaTrimestre.getValue(listaTrimestre.getSelectedIndex()));
		String idAfiliado = listaTrimestre.getValue(listaTrimestre.getSelectedIndex());
		if (!idAfiliado.equals("0")){
			loginService.Consulta_ComparativoPlaniEjecucionSolucion_Afiliado(Long.valueOf(idAfiliado),new AsyncCallback<List<AuxSolucion>>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(List<AuxSolucion> result) {
					// TODO Auto-generated method stub
					
					if(!result.isEmpty()){
					e = new TablaGWT_SolucionGeneral(result);
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
					}else{
						e = new TablaGWT_SolucionGeneral(new ArrayList<AuxSolucion>());
						grid.setWidget(1, 0,e);
						e.setSize("1700px", "300px");
					}
					
				}
			});
		}else{
			Window.alert("Debe seleccionar un Afiliado");
		}
	}

}
