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
import com.google.gwt.user.client.ui.FormPanel;
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

public class ReporteSolucionesHab extends Composite   {

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
	private FormPanel formPanel;
    private AbsolutePanel absolutePanel;
	public List <AuxTipoSolucion> BDTipos = new ArrayList<AuxTipoSolucion>();	
	public List <AuxAfiliado> BDAfiliados = new ArrayList<AuxAfiliado>();	
    private Loading load ;
	private AbsolutePanel absolutePanel_1;
	private Label lblSeleccioneLosEmpleados;
	
	private long idBeneficiario;
	TablaGWT_SolucionesHab e = null;
	private BeneNameSuggestOracle bene;
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    private Label lblAfiliado;
    private ListBox listBox_1;
    private Label lblTipoSolucin;
    private Label lblAo;
    private DateBox dateBox_1;
    private Label lblAlAo;
    private Label lblSeleccioneDepartamento;
    private ListBox listBox_2;
    private Label lblMunicipio;
    private ListBox listBox_3;
    private Button button_1;
    private Label lblEstadoDeLa;
    private ListBox listBox_4;
    
    /**
     * constructor
     */
	public ReporteSolucionesHab() {

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		mensaje = new Mensaje();
		grid = new Grid(2, 1);
		grid.setSize("1117px", "100%");
		idBeneficiario = 0L;
					
		absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "70px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		
		formPanel = new FormPanel();

		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		absolutePanel.add(formPanel, 420, 21);
        formPanel.setSize("209px", "44px");
		
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
		absolutePanel.add(listBox, 10, 49);
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
		absolutePanel.add(txtDato1, 10, 45);
		txtDato1.setSize("177px", "25px");
		
		listEstado = new ListBox();
		listEstado.addItem("Todos los Tipos","0");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 205, 85);
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
		absolutePanel.add(lbDato2, 575, 12);
		lbDato2.setSize("146px", "27px");
		
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
		absolutePanel.add(txt1, 585, 43);
		txt1.setSize("131px", "21px");
		txt1.getElement().setAttribute("placeHolder", "Monto Mínimo");
		
		txt2 = new TextBox();
		txt2.setStylePrimaryName("gwt-TextBox2");
		txt2.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt2, 585, 72);
		txt2.setSize("131px", "21px");
		txt2.getElement().setAttribute("placeHolder", "Monto Máximo");
		
		lbDato1 = new Label("Seleccione Trimestre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("168px", "19px");
		absolutePanel.add(lbDato1, 401, 0);
		

		
		Label lblBusquedaPor = new Label("REPORTE SOLUCIONES HABITACINALES");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("340px", "19px");
		absolutePanel.add(lblBusquedaPor, 10, 0);
		
		Busqueda = new Image("images/pdf.png");
		absolutePanel.add(Busqueda, 910, 16);
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
		absolutePanel.add(button, 1019, 53);
		button.setSize("157px", "30px");
		
		lblAfiliado = new Label("Afiliado");
		lblAfiliado.setStyleName("label");
		absolutePanel.add(lblAfiliado, 10, 73);
		lblAfiliado.setSize("179px", "13px");
		
		listBox_1 = new ListBox();
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 10, 92);
		listBox_1.setSize("179px", "23px");
		
		lblTipoSolucin = new Label("Tipo Solución");
		lblTipoSolucin.setStyleName("label");
		absolutePanel.add(lblTipoSolucin, 205, 66);
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
		
		lblSeleccioneDepartamento = new Label("Departamento");
		lblSeleccioneDepartamento.setStyleName("label");
		absolutePanel.add(lblSeleccioneDepartamento, 727, 0);
		lblSeleccioneDepartamento.setSize("168px", "19px");
		
		listBox_2 = new ListBox();
		listBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_2, 727, 16);
		listBox_2.setSize("168px", "23px");
		
		listBox_2.addItem("[Todos]","0");
		listBox_2.addItem("Guatemala","01");
		listBox_2.addItem("Baja Verapaz","15");
		listBox_2.addItem("Alta Verapaz","16");
		listBox_2.addItem("El Progreso","02");
		listBox_2.addItem("Izabal","18");
		listBox_2.addItem("Zacapa","19");
		listBox_2.addItem("Chiquimula","20");
		listBox_2.addItem("Santa Rosa","06");
		listBox_2.addItem("Jalapa","21");
		listBox_2.addItem("Jutiapa","22");
		listBox_2.addItem("Sacatepequez","03");
		listBox_2.addItem("Chimaltenango","04");
		listBox_2.addItem("Escuintla","05");
		listBox_2.addItem("Solola","07");
		listBox_2.addItem("Totonicapan","08");
		listBox_2.addItem("Quezaltenango","09");
		listBox_2.addItem("Suchitepequez","10");
		listBox_2.addItem("Retalhuleu","11");
		listBox_2.addItem("San Marcos","12");
		listBox_2.addItem("Huehuetenango","13");
		listBox_2.addItem("Quiche","14");
		listBox_2.addItem("Peten","17");
		
		
		listBox_2.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				listBox_3.clear();
				listBox_3.addItem("[Todos]","0");
		        String[] numerosComoArray = Depto_Municipio(listBox_2.getItemText(listBox_2.getSelectedIndex())).split(",");
		        int correlativo = Integer.parseInt(listBox_2.getValue(listBox_2.getSelectedIndex())+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	listBox_3.addItem(numerosComoArray[i],String.valueOf(correlativo));
		        	correlativo++;
		        }

			}
		});
		
		lblMunicipio = new Label("Municipio");
		lblMunicipio.setStyleName("label");
		absolutePanel.add(lblMunicipio, 724, 43);
		lblMunicipio.setSize("168px", "19px");
		
		
		listBox_3 = new ListBox();
		listBox_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_3, 724, 59);
		listBox_3.setSize("168px", "23px");
		listBox_3.addItem("[Todos]","0");
		
		
		
		
		button_1 = new Button("Send");
		button_1.setText("Exportar Excel");
		button_1.setStyleName("finanButton");
		absolutePanel.add(button_1, 1019, 16);
		button_1.setSize("157px", "30px");
		
		lblEstadoDeLa = new Label("Estado de la Solución");
		lblEstadoDeLa.setStyleName("label");
		absolutePanel.add(lblEstadoDeLa, 205, 21);
		lblEstadoDeLa.setSize("179px", "13px");
		
		listBox_4 = new ListBox();
		listBox_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_4, 205, 35);
		listBox_4.setSize("179px", "30px");
		
		listBox_4.addItem("[Seleccione Estado]", "0");
		listBox_4.addItem("Finalizadas", "1");
		listBox_4.addItem("En Proceso", "2");
		
		button_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				String filter = "";
				
				String idAfiliado = listBox_1.getValue(listBox_1.getSelectedIndex());
				String tipoSolucion = listEstado.getValue(listEstado.getSelectedIndex());
				String trimestre = listaTrimestre.getValue(listaTrimestre.getSelectedIndex());
				String anio = dateBox.getTextBox().getText();
				String anioFin = dateBox_1.getTextBox().getText();
				String montoMin = txt1.getText().equals("") ? "0.0" : txt1.getText();
				String montoMax = txt2.getText().equals("") ? "0.0" : txt2.getText();
				String estadoSolucion = listBox_4.getValue(listBox_4.getSelectedIndex());
				
				double montoFinal = Double.valueOf(montoMax)-Double.valueOf(montoMin);
				
				String codDep = listBox_2.getValue(listBox_2.getSelectedIndex());
				String codMun = listBox_3.getValue(listBox_3.getSelectedIndex());
				
				
				formPanel.setAction("/ExportReporteSolucionesHab?idAfiliado="+idAfiliado+"&tipoSolucion="+tipoSolucion+"&trimestre="+trimestre+"&anio="+anio+"&anioFin="+anioFin+"&montoMin="+montoMin+"&montoMax="+montoMax+"&codDep="+codDep+"&codMun="+codMun+"&estadoSolucion="+estadoSolucion);
				formPanel.submit();
				
				
				
			}
		});

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
	
		String filter = "";
		
		String idAfiliado = listBox_1.getValue(listBox_1.getSelectedIndex());
		String tipoSolucion = listEstado.getValue(listEstado.getSelectedIndex());
		String trimestre = listaTrimestre.getValue(listaTrimestre.getSelectedIndex());
		String anio = dateBox.getTextBox().getText();
		String anioFin = dateBox_1.getTextBox().getText();
		String montoMin = txt1.getText().equals("") ? "0.0" : txt1.getText();
		String montoMax = txt2.getText().equals("") ? "0.0" : txt2.getText();
		String estadoSolucion = listBox_4.getValue(listBox_4.getSelectedIndex());
		
		double montoFinal = Double.valueOf(montoMax)-Double.valueOf(montoMin);
		
		String codDep = listBox_2.getValue(listBox_2.getSelectedIndex());
		String codMun = listBox_3.getValue(listBox_3.getSelectedIndex());
		
		if (!tipoSolucion.equals("0")){
			filter = filter + " && disenio =='"+tipoSolucion+"' ";
			
		}
		if (!trimestre.equals("0")){
			filter = filter + " && trimestre =="+trimestre;
		}
		
		if (!codDep.equals("0") && codMun.equals("0")){
			filter = filter + " && departamentoSolucion == '"+codDep+"'";
		}else if (!codDep.equals("0") && !codMun.equals("0")){
			filter = filter + " && departamentoSolucion == '"+codDep + "' && municipioSolucion == '"+codMun+"'";
		}
		
		if (!estadoSolucion.equals("0")){
			filter = filter + " && estadoSolucion == "+estadoSolucion;
		}
		
		
		System.out.println("el filtro quedo: "+filter );
		
		loginService.Consulta_SolucionesHabitacionalesGenerica(idAfiliado, anio, anioFin, Double.valueOf(montoMin), Double.valueOf(montoMax), filter,new AsyncCallback<List<AuxSolucion>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<AuxSolucion> result) {
				// TODO Auto-generated method stub
				
				if(!result.isEmpty()){
				e = new TablaGWT_SolucionesHab(result);
				grid.setWidget(1, 0,e);
				e.setSize("1700px", "300px");
				}else{
					e = new TablaGWT_SolucionesHab(new ArrayList<AuxSolucion>());
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
				}
				
			}
		});
		
		
		/*if (idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal == 0.0){
			System.out.println("Busqueda solo por añio");
/*			loginService.Consulta_SolucionesGeneralesPorAnio(anio,anioFin,new AsyncCallback<List<AuxSolucion>>() {

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
			
			loginService.Consulta_SolucionesGeneralesGenerica(idAfiliado, anio, anioFin, Double.valueOf(montoMin), Double.valueOf(montoMax), "",new AsyncCallback<List<AuxSolucion>>() {

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
			
			
			
		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal == 0.0){
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
			
		}else if (idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal == 0.0){
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
		}else if (idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal == 0.0){
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
		}else if (idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal != 0.0){
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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal == 0.0){
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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal == 0.0){
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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal != 0.0){
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
		}else if  (idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal == 0.0){
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
		}else if (idAfiliado.equals("0") && !tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal != 0.0){
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
		}else if (idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal != 0.0){
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
		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal == 0.0){
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

		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && !trimestre.equals("0") && montoFinal != 0.0){
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
		}else if (!idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal != 0.0){
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
		}else if (idAfiliado.equals("0") && !tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal != 0.0){
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
		}else if (!idAfiliado.equals("0") && tipoSolucion.equals("0") && trimestre.equals("0") && montoFinal != 0.0){
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

		}*/
		
		
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
				e = new TablaGWT_SolucionesHab(result);
				grid.setWidget(1, 0,e);
				e.setSize("1700px", "300px");
				}else{
					e = new TablaGWT_SolucionesHab(new ArrayList<AuxSolucion>());
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
				}
				
			}
		});
	}
	
	public void BuscarAfiliado(){
		
	}
	
    /**
	 * metodo para obtener los municipios del departamento entrante
	 * @param Departamento
	 * @return
	 */
	private String Depto_Municipio(String Departamento){
		
		String valor = "";
		if(Departamento.equals("Guatemala")){	
			
			valor = valor + "," + "Guatemala";
			valor = valor + "," + "Santa Catarina Pinula";
			valor = valor + "," + "San Jose Pinula";
			valor = valor + "," + "San Jose del Golfo";
			valor = valor + "," + "Palencia";
			valor = valor + "," + "Chinautla";
			valor = valor + "," + "San Pedro Ayampuc";
			valor = valor + "," + "Mixco";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Juan Sacatepequez";
			valor = valor + "," + "San Raymundo";
			valor = valor + "," + "Chuarrancho";
			valor = valor + "," + "Fraijanes";
			valor = valor + "," + "Amatitlan";
			valor = valor + "," + "Villa Nueva";
			valor = valor + "," + "Villa Canales";
			valor = valor + "," + "Petapa";
			
		}else if(Departamento.equals("Baja Verapaz")){
			valor = valor + "," + "Salama";
			valor = valor + "," + "San Miguel Chicaj";
			valor = valor + "," + "Rabinal";
			valor = valor + "," + "Cubulco";
			valor = valor + "," + "Granados";
			valor = valor + "," + "Santa Cruz el Chol";
			valor = valor + "," + "San Jeronimo";
			valor = valor + "," + "Purulha";
			
		}else if(Departamento.equals("Alta Verapaz")){
			valor = valor + "," + "Coban";
			valor = valor + "," + "Santa Cruz Verapaz";
			valor = valor + "," + "San Cristobal Verapaz";
			valor = valor + "," + "Tactic";
			valor = valor + "," + "Tamahu";
			valor = valor + "," + "Tucuru";
			valor = valor + "," + "Panzos";
			valor = valor + "," + "Senahu";
			valor = valor + "," + "San Pedro Carcha";
			valor = valor + "," + "San Juan Chamelco";
			valor = valor + "," + "Lanquin";
			valor = valor + "," + "Santa Maria Cahabon";
			valor = valor + "," + "Chisec";
			valor = valor + "," + "Chahal";
			valor = valor + "," + "Fray Bartolome de las Casas";
			valor = valor + "," + "La Tinta";
			valor = valor + "," + "Raxruha";
			
		}else if(Departamento.equals("El Progreso")){
			valor = valor + "," + "Guastatoya";
			valor = valor + "," + "Morazan";
			valor = valor + "," + "San Agustin Acasaguastlan";
			valor = valor + "," + "San Cristobal Acasaguastlan";
			valor = valor + "," + "El Jicaro";
			valor = valor + "," + "Sansare";
			valor = valor + "," + "Sanarate";
			valor = valor + "," + "San Antonio La Paz";
			
		}else if(Departamento.equals("Izabal")){
			valor = valor + "," + "Puerto Barrios";
			valor = valor + "," + "Livingston";
			valor = valor + "," + "El Estor";
			valor = valor + "," + "Morales";
			valor = valor + "," + "Los Amates";
			
		}else if(Departamento.equals("Zacapa")){
			valor = valor + "," + "Zacapa";
			valor = valor + "," + "Estanzuela";
			valor = valor + "," + "Rio Hondo";
			valor = valor + "," + "Gualan";
			valor = valor + "," + "Teculutan";
			valor = valor + "," + "Usumatlan";
			valor = valor + "," + "Cabañas";
			valor = valor + "," + "Huite";
			valor = valor + "," + "San Diego";
			valor = valor + "," + "La Union";
			valor = valor + "," + "Huite";
			
		}else if(Departamento.equals("Chiquimula")){

			valor = valor + "," + "Chiquimula";
			valor = valor + "," + "San Jose la Arada";
			valor = valor + "," + "San Juan Ermita";
			valor = valor + "," + "Jocotan";
			valor = valor + "," + "Camotan";
			valor = valor + "," + "Olopa";
			valor = valor + "," + "Esquipulas";
			valor = valor + "," + "Concepcion Las Minas";
			valor = valor + "," + "Quezaltepeque";
			valor = valor + "," + "San Jacinto";
			valor = valor + "," + "Ipala";
			
		}else if(Departamento.equals("Santa Rosa")){
			valor = valor + "," + "Cuilapa";
			valor = valor + "," + "Barberena";
			valor = valor + "," + "Santa Rosa de Lima";
			valor = valor + "," + "Casillas";
			valor = valor + "," + "San Rafael las Flores";
			valor = valor + "," + "Oratorio";
			valor = valor + "," + "San Juan Tecuaco";
			valor = valor + "," + "Chiquimulilla";
			valor = valor + "," + "Taxisco";
			valor = valor + "," + "Santa Maria Ixhuatan";
			valor = valor + "," + "Guazacapan";
			valor = valor + "," + "Santa Cruz Naranjo";
			valor = valor + "," + "Pueblo Nuevo Viñas";
			valor = valor + "," + "Nueva Santa Rosa";
			
		}else if(Departamento.equals("Jalapa")){
			valor = valor + "," + "Jalapa";
			valor = valor + "," + "San Pedro Pinula";
			valor = valor + "," + "San Luis Jilotepeque";
			valor = valor + "," + "San Manuel Chaparron";
			valor = valor + "," + "San Carlos Alzatate";
			valor = valor + "," + "Monjas";
			valor = valor + "," + "Mataquescuintla";
			
		}else if(Departamento.equals("Jutiapa")){
			valor = valor + "," + "Jutiapa";
			valor = valor + "," + "El Progreso";
			valor = valor + "," + "Santa Catarina Mita";
			valor = valor + "," + "Agua Blanca";
			valor = valor + "," + "Asuncion Mita";
			valor = valor + "," + "Yupiltepeque";
			valor = valor + "," + "Atescatempa";
			valor = valor + "," + "Jerez";
			valor = valor + "," + "El Adelanto";
			valor = valor + "," + "Zapotitlan";
			valor = valor + "," + "Comapa";
			valor = valor + "," + "Jalpatagua";
			valor = valor + "," + "Conguaco";
			valor = valor + "," + "Moyuta";
			valor = valor + "," + "Pasaco";
			valor = valor + "," + "San Jose Acatempa";
			valor = valor + "," + "Quesada";
			
		}else if(Departamento.equals("Sacatepequez")){
			valor = valor + "," + "La Antigua Guatemala";
			valor = valor + "," + "Jocotenango";
			valor = valor + "," + "Pastores";
			valor = valor + "," + "Sumpango";
			valor = valor + "," + "Santo Domingo Xenacoj";
			valor = valor + "," + "Santiago Sacatepequez";
			valor = valor + "," + "San Bartolome Milpas Altas";
			valor = valor + "," + "San Lucas Sacatepequez";
			valor = valor + "," + "Santa Lucia Milpas Altas";
			valor = valor + "," + "Magdalena Milpas Altas";
			valor = valor + "," + "Santa Maria de Jesus";
			valor = valor + "," + "Ciudad Vieja";
			valor = valor + "," + "San Miguel Dueñas";
			valor = valor + "," + "Alotenango";
			valor = valor + "," + "San Antonio Aguas Calientes";
			valor = valor + "," + "Santa Catarina Barahona";
			
		}else if(Departamento.equals("Chimaltenango")){
			valor = valor + "," + "Chimaltenango";
			valor = valor + "," + "San Jose Poaquil";
			valor = valor + "," + "San Martin Jilotepeque";
			valor = valor + "," + "San Juan Comalapa";
			valor = valor + "," + "Santa Apolonia";
			valor = valor + "," + "Tecpan";
			valor = valor + "," + "Patzun";
			valor = valor + "," + "Pochuta";
			valor = valor + "," + "Patzicia";
			valor = valor + "," + "Santa Cruz Balanya";
			valor = valor + "," + "Acatenango";
			valor = valor + "," + "Yepocapa";
			valor = valor + "," + "San Andres Itzapa";
			valor = valor + "," + "Parramos";
			valor = valor + "," + "Zaragoza";
			valor = valor + "," + "El Tejar";
			
		}else if(Departamento.equals("Escuintla")){			
			valor = valor + "," + "Escuintla";
			valor = valor + "," + "Santa Lucia Cotzumalguapa";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "Siquinala";
			valor = valor + "," + "Masagua";
			valor = valor + "," + "Tiquisate";
			valor = valor + "," + "La Gomera";
			valor = valor + "," + "Guanagazapa";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "Iztapa";
			valor = valor + "," + "Palin";
			valor = valor + "," + "San Vicente Pacaya";
			valor = valor + "," + "Nueva Concepcion";
			
		}else if(Departamento.equals("Solola")){
			valor = valor + "," + "Solola";
			valor = valor + "," + "San Jose Chacaya";
			valor = valor + "," + "Santa Maria Visitacion";
			valor = valor + "," + "Santa Lucia Utatlan";
			valor = valor + "," + "Nahuala";
			valor = valor + "," + "Santa Catarina Ixtahuacan";
			valor = valor + "," + "Santa Clara La Laguna";
			valor = valor + "," + "Concepcion";
			valor = valor + "," + "San Andres Semetabaj";
			valor = valor + "," + "Panajachel";
			valor = valor + "," + "Santa Catarina Palopo";
			valor = valor + "," + "San Antonio Palopo";
			valor = valor + "," + "San Lucas Toliman";
			valor = valor + "," + "Santa Cruz La Laguna";
			valor = valor + "," + "San Pablo La Laguna";
			valor = valor + "," + "San Juan La Laguna";
			valor = valor + "," + "San Marcos La Laguna";
			valor = valor + "," + "San Pedro La Laguna";
			valor = valor + "," + "Santiago Atitlan";
			
		}else if(Departamento.equals("Totonicapan")){
			valor = valor + "," + "Totonicapan";
			valor = valor + "," + "San Cristobal Totonicapan";
			valor = valor + "," + "San Francisco El Alto";
			valor = valor + "," + "San Andres Xecul";
			valor = valor + "," + "Momostenango";
			valor = valor + "," + "Santa Maria Chiquimula";
			valor = valor + "," + "Santa Lucia La Reforma";
			valor = valor + "," + "San Bartolo";
			
		}else if(Departamento.equals("Quezaltenango")){
			valor = valor + "," + "Quetzaltenango";
			valor = valor + "," + "Salcaja";
			valor = valor + "," + "Olintepeque";
			valor = valor + "," + "San Carlos Sija";
			valor = valor + "," + "Sibilia";
			valor = valor + "," + "Cabrican";
			valor = valor + "," + "Cajola";
			valor = valor + "," + "San Miguel Sigüila";
			valor = valor + "," + "San Juan Ostuncalco";
			valor = valor + "," + "San Mateo";
			valor = valor + "," + "Concepcion Chiquirichapa";
			valor = valor + "," + "San Martin Sacatepequez";
			valor = valor + "," + "Almolonga";
			valor = valor + "," + "Cantel";
			valor = valor + "," + "Huitan";
			valor = valor + "," + "Zunil";
			valor = valor + "," + "Colomba Costa Cuca";
			valor = valor + "," + "San Francisco La Union";
			valor = valor + "," + "El Palmar";
			valor = valor + "," + "Coatepeque";
			valor = valor + "," + "Genova";
			valor = valor + "," + "Flores Costa Cuca";
			valor = valor + "," + "La Esperanza";
			valor = valor + "," + "Palestina de Los Altos";
			
		}else if(Departamento.equals("Suchitepequez")){
			valor = valor + "," + "Mazatenango";
			valor = valor + "," + "Cuyotenango";
			valor = valor + "," + "San Francisco Zapotitlan";
			valor = valor + "," + "San Bernardino";
			valor = valor + "," + "San Jose El Idolo";
			valor = valor + "," + "Santo Domingo Suchitepequez";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "Samayac";
			valor = valor + "," + "San Pablo Jocopilas";
			valor = valor + "," + "San Antonio Suchitepequez";
			valor = valor + "," + "San Miguel Panan";
			valor = valor + "," + "San Gabriel";
			valor = valor + "," + "Chicacao";
			valor = valor + "," + "Patulul";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "San Juan Bautista";
			valor = valor + "," + "Santo Tomas La Union";
			valor = valor + "," + "Zunilito";
			valor = valor + "," + "Pueblo Nuevo";
			valor = valor + "," + "Rio Bravo";
			
		}else if(Departamento.equals("Retalhuleu")){
			valor = valor + "," + "Retalhuleu";
			valor = valor + "," + "San Sebastian";
			valor = valor + "," + "Santa Cruz Mulua";
			valor = valor + "," + "San Martin Zapotitlan";
			valor = valor + "," + "San Felipe";
			valor = valor + "," + "San Andres Villa Seca";
			valor = valor + "," + "Champerico";
			valor = valor + "," + "Nuevo San Carlos";
			valor = valor + "," + "El Asintal";
			
		}else if(Departamento.equals("San Marcos")){
			valor = valor + "," + "San Marcos";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Antonio Sacatepequez";
			valor = valor + "," + "Comitancillo";
			valor = valor + "," + "San Miguel Ixtahuacan";
			valor = valor + "," + "Concepcion Tutuapa";
			valor = valor + "," + "Tacana";
			valor = valor + "," + "Sibinal";
			valor = valor + "," + "Tajumulco";
			valor = valor + "," + "Tejutla";
			valor = valor + "," + "San Rafael Pie de la Cuesta";
			valor = valor + "," + "Nuevo Progreso";
			valor = valor + "," + "El Tumbador";
			valor = valor + "," + "San Jose El Rodeo";
			valor = valor + "," + "Malacatan";
			valor = valor + "," + "Catarina";
			valor = valor + "," + "Ayutla";
			valor = valor + "," + "Ocos";
			valor = valor + "," + "San Pablo";
			valor = valor + "," + "El Quetzal";
			valor = valor + "," + "La Reforma";
			valor = valor + "," + "Pajapita";
			valor = valor + "," + "Ixchiguan";
			valor = valor + "," + "San Jose Ojetenam";
			valor = valor + "," + "San Cristobal Cucho";
			valor = valor + "," + "Sipacapa";
			valor = valor + "," + "Esquipulas Palo Gordo";
			valor = valor + "," + "Rio Blanco";
			valor = valor + "," + "San Lorenzo";
			
		}else if(Departamento.equals("Huehuetenango")){
			valor = valor + "," + "Huehuetenango";
			valor = valor + "," + "Chiantla";
			valor = valor + "," + "Malacatancito";
			valor = valor + "," + "Cuilco";
			valor = valor + "," + "Nenton";
			valor = valor + "," + "San Pedro Necta";
			valor = valor + "," + "Jacaltenango";
			valor = valor + "," + "San Pedro Soloma";
			valor = valor + "," + "San Ildefonso Ixtahuacan";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "San Miguel Acatan";
			valor = valor + "," + "San Rafael La Independencia";
			valor = valor + "," + "Santos Cuchumatan";
			valor = valor + "," + "San Juan Atitan";
			valor = valor + "," + "Santa Eulalia";
			valor = valor + "," + "San Mateo Ixtatan";
			valor = valor + "," + "Colotenango";
			valor = valor + "," + "San Sebastian Huehuetenango";
			valor = valor + "," + "Tectitan";
			valor = valor + "," + "Concepcion Huista";
			valor = valor + "," + "San Juan Ixcoy";
			valor = valor + "," + "San Antonio Huista";
			valor = valor + "," + "San Sebastian Coatan";
			valor = valor + "," + "Santa Cruz Barillas";
			valor = valor + "," + "Aguacatan";
			valor = valor + "," + "San Rafael Petzal";
			valor = valor + "," + "San Gaspar Ixchil";
			valor = valor + "," + "Santiago Chimaltenango";
			valor = valor + "," + "Santa Ana Huista";
			valor = valor + "," + "Union Cantinil";
			
		}else if(Departamento.equals("Quiche")){
			valor = valor + "," + "Santa Cruz del Quiche";
			valor = valor + "," + "Chiche";
			valor = valor + "," + "Chinique";
			valor = valor + "," + "Zacualpa";
			valor = valor + "," + "Chajul";
			valor = valor + "," + "Chichicastenango";
			valor = valor + "," + "Patzite";
			valor = valor + "," + "San Antonio Ilotenango";
			valor = valor + "," + "San Pedro Jocopilas";
			valor = valor + "," + "Cunen";
			valor = valor + "," + "San Juan Cotzal";
			valor = valor + "," + "Joyabaj";
			valor = valor + "," + "Nebaj";
			valor = valor + "," + "San Andres Sajcabaja";
			valor = valor + "," + "Uspantan";
			valor = valor + "," + "Sacapulas";
			valor = valor + "," + "San Bartolome Jocotenango";
			valor = valor + "," + "Canilla";
			valor = valor + "," + "Chicaman";
			valor = valor + "," + "Ixcan";
			valor = valor + "," + "Pachalum";
			
		}else if(Departamento.equals("Peten")){
			valor = valor + "," + "Flores";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "San Benito";
			valor = valor + "," + "San Andres";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "San Francisco";
			valor = valor + "," + "Santa Ana";
			valor = valor + "," + "Dolores";
			valor = valor + "," + "San Luis";
			valor = valor + "," + "Sayaxche";
			valor = valor + "," + "Melchor de Mencos";
			valor = valor + "," + "Poptun";
			
		}else if(Departamento.equals("-")){
			valor = valor + "," + "-";
		}
	
		return valor;
	}

	
	


}
