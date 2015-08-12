/**0
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
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
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.datepicker.client.DateBox;

public class ReporteResumenCréditos extends Composite   {

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
    private Label lblAfiliado;
    private ListBox listBox_1;
    private Label lblTipoSolucin;
    private Label lblAo;
    private DateBox dateBox_1;
    private Label lblAlAo;
    
    /**
     * constructor
     */
	public ReporteResumenCréditos() {

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
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("General"))
				{
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Rango de Monto Ejecutado"))
				{

				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Tipo de Solución"))
				{

					
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
		listBox.setSize("179px", "23px");
		
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
		absolutePanel.add(txtDato1, 205, 0);
		txtDato1.setSize("177px", "25px");
		
		listEstado = new ListBox();
		listEstado.addItem("Todos los Tipos","0");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 205, 65);
		listEstado.setSize("179px", "30px");
		
		
		listaTrimestre = new ListBox();
		listaTrimestre.setStyleName("gwt-TextBox2");
		absolutePanel.add(listaTrimestre, 401, 16);
		listaTrimestre.setSize("168px", "23px");
		listaTrimestre.addItem("Todos los Trimestres", "0");
		listaTrimestre.addItem("Enero a Marzo", "1");
		listaTrimestre.addItem("Abril a Junio", "2");
		listaTrimestre.addItem("Julio a Septiembre", "3");
		listaTrimestre.addItem("Octubre a Diciembre", "4");
		
		
		lbDato2 = new Label();
		lbDato2.setText("Buscar por Rango Montos");
		
		lbDato2.setStyleName("label");
		absolutePanel.add(lbDato2, 585, 16);
		lbDato2.setSize("202px", "23px");
		
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
		
        
		absolutePanel.add(dateBox, 401, 68);
		dateBox.setSize("56px", "25px");
		
		
		txt1 = new TextBox();
		txt1.setStylePrimaryName("gwt-TextBox2");
		txt1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt1, 610, 32);
		txt1.setSize("131px", "21px");
		txt1.getElement().setAttribute("placeHolder", "Monto Mínimo");
		
		txt2 = new TextBox();
		txt2.setStylePrimaryName("gwt-TextBox2");
		txt2.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt2, 610, 65);
		txt2.setSize("131px", "21px");
		txt2.getElement().setAttribute("placeHolder", "Monto Máximo");
		
		lbDato1 = new Label("Seleccione Trimestre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("168px", "19px");
		absolutePanel.add(lbDato1, 401, 0);
		

		
		Label lblBusquedaPor = new Label("Busqueda Por");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("179px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
		Busqueda = new Image("images/pdf.png");
		absolutePanel.add(Busqueda, 898, 0);
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
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Seleccione Criterio"))
				{
					BuscarPorFiltros();
				}
				
			}
		});
		Busqueda.setSize("103px", "78px");
		
		/*lblSeleccioneLosEmpleados = new Label("Seleccione los empleados que quiere mostrar en el reporte");
		lblSeleccioneLosEmpleados.setStyleName("label");
		absolutePanel.add(lblSeleccioneLosEmpleados, 800, 5);
		lblSeleccioneLosEmpleados.setSize("828px", "13px");*/
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				List<AuxSolucion> total= new ArrayList<AuxSolucion>(e.grid.selectionModel.getSelectedSet());
				Long idBeneficiario = total.get(0).getBeneficiario().getIdBeneficiario();
				Window.open("/FinanGenerarPdfReporteRecord?idBeneficiario="+idBeneficiario, "_blank", "");
			}
		});		

		button.setText("Imprimir Record");
		button.setStyleName("finanButton");
		absolutePanel.add(button, 1007, 55);
		button.setSize("157px", "30px");
		
		lblAfiliado = new Label("Afiliado");
		lblAfiliado.setStyleName("label");
		absolutePanel.add(lblAfiliado, 10, 53);
		lblAfiliado.setSize("179px", "13px");
		
		listBox_1 = new ListBox();
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 10, 72);
		listBox_1.setSize("179px", "23px");
		
		lblTipoSolucin = new Label("Tipo Solución");
		lblTipoSolucin.setStyleName("label");
		absolutePanel.add(lblTipoSolucin, 205, 46);
		lblTipoSolucin.setSize("179px", "13px");
		
		lblAo = new Label("Del Año");
		lblAo.setStyleName("label");
		absolutePanel.add(lblAo, 400, 52);
		lblAo.setSize("59px", "13px");
		
		dateBox_1 = new DateBox();
		dateBox_1.setFormat(new DateBox.DefaultFormat 
        		(DateTimeFormat.getFormat("yyyy")));
        dateBox_1.setValue(new Date());
        dateBox_1.getTextBox().setReadOnly(true);
        dateBox_1.setFireNullValues(true);
        dateBox_1.setStyleName("gwt-PasswordTextBox");
        
        dateBox_1.getDatePicker().setVisibleYearCount(100);
        dateBox_1.getDatePicker().setYearArrowsVisible(true);
        dateBox_1.getDatePicker().setYearAndMonthDropdownVisible(true);
		absolutePanel.add(dateBox_1, 484, 68);
		dateBox_1.setSize("56px", "25px");
		
		lblAlAo = new Label("Al Año");
		lblAlAo.setStyleName("label");
		absolutePanel.add(lblAlAo, 483, 52);
		lblAlAo.setSize("59px", "13px");
		
		

		loginService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>(){
		    public void onFailure(Throwable caught) 
		    {
		    }
		
			@Override
		    public void onSuccess(List<AuxAfiliado> result)
		    {
				if (!(result.size()==0)) {
					 listBox_1.addItem("Todos los afiliados","0");
					 for (AuxAfiliado p : result) 
					    {
					    	listBox_1.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
					    }
		    	}
				
		    }
		});
		
		loginService.Consultar_TipoSolucion(new AsyncCallback<List<AuxTipoSolucion>>() {
			
			@Override
			public void onSuccess(List<AuxTipoSolucion> result) {
				listEstado.addItem("CASA COMPLETA","CASA COMPLETA");
				for (AuxTipoSolucion p : result) 
			    {
			    	listEstado.addItem(p.getIdTipoSolucion(),p.getIdTipoSolucion());
			    }
				
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
		
			
		
		txtDato1.setVisible(false);

		
		
		
	}
	
	
	
	

	protected void BuscarPorFiltros() {
		// TODO Auto-generated method stub
		
		String idAfiliado = listBox_1.getValue(listBox_1.getSelectedIndex());
		String tipoSolucion = listEstado.getValue(listEstado.getSelectedIndex());
		String trimestre = listaTrimestre.getValue(listaTrimestre.getSelectedIndex());
		String anio = dateBox.getTextBox().getText();
		String anioFin = dateBox_1.getTextBox().getText();
		String montoMin = txt1.getText();
		String montoMax = txt2.getText();
		
		if (idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda solo por añio");
			loginService.Consulta_SolucionesGeneralesPorAnio(anio,anioFin,new AsyncCallback<List<AuxSolucion>>() {

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
			
		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda solo Afiliado");
			System.out.println("Afiliado: "+ idAfiliado);
				loginService.Consulta_SolucionesGeneralesAfiliado(Long.valueOf(idAfiliado),anio,anioFin,new AsyncCallback<List<AuxSolucion>>() {

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
			
		}else if (idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda solo TipoSolucion");
			loginService.Consulta_SolucionesGeneralesTipoSolucion(tipoSolucion,anio,anioFin,new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda por trimestre y año");
			System.out.println("Trimestre y Año"+ trimestre+ " año" + anio);
			loginService.Consulta_SolucionesGeneralesOpcion1(anio,trimestre,anioFin,new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda solo por rango de montos");
			System.out.println("Rango: "+ montoMin+" "+montoMax);
			loginService.Consulta_SolucionesGeneralesRango(Double.valueOf(montoMin),Double.valueOf(montoMax),anio,anioFin,new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda por afiliado y tipos solucion");
			loginService.Consulta_SolucionesGeneralesAfiliado_TipoSolucion(Long.valueOf(idAfiliado),anio,anioFin,tipoSolucion,new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda por afiliado y tipos solucion y trimestre");
			loginService.Consulta_SolucionesGeneralesAfiliado_TipoSolucion_Trimestre(Long.valueOf(idAfiliado),anio,anioFin,tipoSolucion,trimestre,new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda por afiliado y tipos solucion trimestre y montos ");
			loginService.Consulta_SolucionesGeneralesAfiliado_TipoSolucion_Trimestre_Montos(Long.valueOf(idAfiliado),anio,anioFin,tipoSolucion,trimestre,Double.valueOf(montoMin),Double.valueOf(montoMax),new AsyncCallback<List<AuxSolucion>>() {

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
		}else if  (idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda por tipos solucion y trimestre");
			loginService.Consulta_SolucionesGeneralesTrimestre_TipoSolucion(anio,trimestre,anioFin,tipoSolucion,new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda por tipo solucion trimestre y montos");
			loginService.Consulta_SolucionesGeneralesTrimestre_TipoSolucion_Montos(anio,trimestre,anioFin,tipoSolucion,Double.valueOf(montoMin),Double.valueOf(montoMax),new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda por trimestre y montos");
			loginService.Consulta_SolucionesGeneralesTrimestre_Montos(anio,trimestre,anioFin,Double.valueOf(montoMin),Double.valueOf(montoMax),new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && montoMin.equals("") && montoMax.equals("")){
			System.out.println("Busqueda por trimestre y afiliado");
			
			loginService.Consulta_SolucionesGeneralesAfiliado_Trimestre(Long.valueOf(idAfiliado),anio,anioFin,trimestre,new AsyncCallback<List<AuxSolucion>>() {

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

		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda por trimestre y montos y afiliados ");
			loginService.Consulta_SolucionesGeneralesAfiliado_Trimestre_Montos(Long.valueOf(idAfiliado),anio,anioFin,trimestre,Double.valueOf(montoMin),Double.valueOf(montoMax),new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda por afiliado tipo solucion y montos");
			loginService.Consulta_SolucionesGeneralesAfiliado_TipoSolucion_Montos(Long.valueOf(idAfiliado),anio,anioFin,tipoSolucion,Double.valueOf(montoMin),Double.valueOf(montoMax),new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda por tipo solucion y montos");
			loginService.Consulta_SolucionesGeneralesTipoSolucion_Montos(anio,tipoSolucion,anioFin,Double.valueOf(montoMin),Double.valueOf(montoMax),new AsyncCallback<List<AuxSolucion>>() {

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
		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && !montoMin.equals("") && !montoMax.equals("")){
			System.out.println("Busqueda por afiliado y montos");
			loginService.Consulta_SolucionesGeneralesAfiliado_Montos(Long.valueOf(idAfiliado),anio,anioFin,Double.valueOf(montoMin),Double.valueOf(montoMax),new AsyncCallback<List<AuxSolucion>>() {

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
		
		
	}





	protected void BuscarTipoSolucion() {
		// TODO Auto-generated method stub
		System.out.println("Tipos solucion: "+ listaTrimestre.getValue(listaTrimestre.getSelectedIndex()));

	}





	protected void BuscarRangoMonto() {
		// TODO Auto-generated method stub

		
		
	}





	public void buscar(){
		
		
	}
	
	public void BuscarGeneral(){
		System.out.println("General");
		loginService.Consulta_SolucionesGenerales(new AsyncCallback<List<AuxSolucion>>() {

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
	
	public void BuscarAfiliado(){
		
	}

	
	


}
