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
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTipoSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;
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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.datepicker.client.DateBox;

public class ReporteDeMateriales extends Composite   {

	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private ListBox listaTrimestre;
    private Label lbDato1;
    private Label lbDato2;
    private Image Busqueda;
    private TextBox txt1;
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
	private SimpleCheckBox simpleCheckBox;
	
	private long idBeneficiario;
	TablaGWT_ReporteMaterialConstruccion e = null;
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
    private Button button_1;
    private Label lblRangoDeFechas;
    
    /**
     * constructor
     */
	public ReporteDeMateriales() {

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
		
		
		formPanel = new FormPanel();

		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		absolutePanel.add(formPanel, 959, 22);
        formPanel.setSize("209px", "44px");
		
		bene = new BeneNameSuggestOracle();
		
		listBox = new ListBox();
		listBox.addItem("Seleccione Criterio");
		listBox.addItem("Por Filtros");
		listBox.addItem("Beneficiario");
		listBox.addItem("No. Vale");
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
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 205, 65);
		listEstado.setSize("179px", "30px");
		
		
		listaTrimestre = new ListBox();
		listaTrimestre.setStyleName("gwt-TextBox2");
		absolutePanel.add(listaTrimestre, 401, 22);
		listaTrimestre.setSize("168px", "23px");
		listaTrimestre.addItem("Todos los Trimestres", "0");
		listaTrimestre.addItem("Enero a Marzo", "1");
		listaTrimestre.addItem("Abril a Junio", "2");
		listaTrimestre.addItem("Julio a Septiembre", "3");
		listaTrimestre.addItem("Octubre a Diciembre", "4");
		
		
		lbDato2 = new Label();
		lbDato2.setText("Año");
		
		lbDato2.setStyleName("label");
		absolutePanel.add(lbDato2, 587, 0);
		lbDato2.setSize("32px", "19px");
		
		dateBox = new DateBox();
		dateBox.setFormat(new DateBox.DefaultFormat 
        		(DateTimeFormat.getFormat("dd/MM/yyyy")));
        dateBox.setValue(new Date());
        dateBox.getTextBox().setReadOnly(true);
        dateBox.setFireNullValues(true);
        dateBox.setStyleName("gwt-PasswordTextBox");
        
        dateBox.getDatePicker().setVisibleYearCount(100);
        dateBox.getDatePicker().setYearArrowsVisible(true);
        dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateBox.setVisible(false);
		
        
		absolutePanel.add(dateBox, 575, 68);
		dateBox.setSize("83px", "25px");
		
		
		txt1 = new TextBox();
		txt1.setStylePrimaryName("gwt-TextBox2");
		txt1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txt1, 586, 22);
		txt1.setSize("44px", "21px");
		
		
		lbDato1 = new Label("Seleccione Trimestre");
		lbDato1.setStyleName("label");
		lbDato1.setSize("168px", "19px");
		absolutePanel.add(lbDato1, 401, 0);
		

		
		Label lblBusquedaPor = new Label("Busqueda Por");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("179px", "13px");
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
		

		
		lblAfiliado = new Label("Afiliado");
		lblAfiliado.setStyleName("label");
		absolutePanel.add(lblAfiliado, 10, 53);
		lblAfiliado.setSize("179px", "13px");
		
		listBox_1 = new ListBox();
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 10, 72);
		listBox_1.setSize("179px", "23px");
		
		lblTipoSolucin = new Label("Catálogo de Materiales");
		lblTipoSolucin.setStyleName("label");
		absolutePanel.add(lblTipoSolucin, 205, 46);
		lblTipoSolucin.setSize("179px", "13px");
		
		lblAo = new Label("Desde");
		lblAo.setStyleName("label");
		absolutePanel.add(lblAo, 582, 51);
		lblAo.setSize("121px", "14px");
		
		dateBox_1 = new DateBox();
		dateBox_1.setFormat(new DateBox.DefaultFormat 
        		(DateTimeFormat.getFormat("dd/MM/yyyy")));
        dateBox_1.setValue(new Date());
        dateBox_1.getTextBox().setReadOnly(true);
        dateBox_1.setFireNullValues(true);
        dateBox_1.setStyleName("gwt-PasswordTextBox");
        dateBox_1.setVisible(false);
        
        dateBox_1.getDatePicker().setVisibleYearCount(100);
        dateBox_1.getDatePicker().setYearArrowsVisible(true);
        dateBox_1.getDatePicker().setYearAndMonthDropdownVisible(true);
		absolutePanel.add(dateBox_1, 666, 67);
		dateBox_1.setSize("83px", "25px");
		
		lblAlAo = new Label("Hasta");
		lblAlAo.setStyleName("label");
		absolutePanel.add(lblAlAo, 666, 52);
		lblAlAo.setSize("59px", "13px");
		
		lblSeleccioneDepartamento = new Label("Proveedor");
		lblSeleccioneDepartamento.setStyleName("label");
		absolutePanel.add(lblSeleccioneDepartamento, 727, 0);
		lblSeleccioneDepartamento.setSize("168px", "19px");
		
		listBox_2 = new ListBox();
		listBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_2, 727, 16);
		listBox_2.setSize("168px", "23px");
		
		listBox_2.addItem("[Todos]","0");
		
		
		
		listBox_2.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {


			}
		});
		
		
		
		
		button_1 = new Button("Send");
		button_1.setText("Exportar Excel");
		button_1.setStyleName("finanButton");
		absolutePanel.add(button_1, 1019, 16);
		button_1.setSize("157px", "30px");
		
		lblRangoDeFechas = new Label("Rango de Fechas");
		lblRangoDeFechas.setStyleName("label");
		absolutePanel.add(lblRangoDeFechas, 401, 51);
		lblRangoDeFechas.setSize("168px", "19px");
		
		simpleCheckBox = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox, 471, 72);
		
		
		simpleCheckBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			   @Override
			   public void onValueChange(ValueChangeEvent<Boolean> event) {
				   System.out.println(event.getValue());
				   if (event.getValue()){
					   dateBox.setVisible(true);
					   dateBox_1.setVisible(true);
					   txt1.setVisible(false);
					   txt1.setText("");
					   
				   }else{
					   dateBox.setVisible(false);
					   dateBox_1.setVisible(false);
					   txt1.setVisible(true);
				   }
			   }


		});
		
		
		
		button_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//List<AuxSolucion> exportar = e.grid.getDataList();
				//System.out.println(exportar.size());
				String filter = "";
				
				String idAfiliado = listBox_1.getValue(listBox_1.getSelectedIndex());
				String tipoSolucion = listEstado.getValue(listEstado.getSelectedIndex());
				String trimestre = listaTrimestre.getValue(listaTrimestre.getSelectedIndex());
				String anio = dateBox.getTextBox().getText();
				String anioFin = dateBox_1.getTextBox().getText();
				String montoMin = txt1.getText().equals("") ? "0.0" : txt1.getText();
/*				String montoMax = txt2.getText().equals("") ? "0.0" : txt2.getText();
				
				
				String codDep = listBox_2.getValue(listBox_2.getSelectedIndex());
				String codMun = listBox_3.getValue(listBox_3.getSelectedIndex());
				
				
				
				
				System.out.println("el filtro quedo: "+filter );
				
				formPanel.setAction("/ExportResumenCreditos?idAfiliado="+idAfiliado+"&tipoSolucion="+tipoSolucion+"&trimestre="+trimestre+"&anio="+anio+"&anioFin="+anioFin+"&montoMin="+montoMin+"&montoMax="+montoMax+"&codDep="+codDep+"&codMun="+codMun+"&tipoConsulta=1");
				formPanel.submit();*/
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
		
		
		loginService.ConsultaTodosProveedor_PorAfiliadoAprobados(0L,new AsyncCallback<List<AuxProveedor>>() {
			
			@Override
			public void onSuccess(List<AuxProveedor> result) {
				System.out.println("ya estan todos los afiliados");			
				for (AuxProveedor p : result) 
			    {
			    	listBox_2.addItem(p.getNomProveedor(),""+p.getIdProveedor());
			    }
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});
		
		loginService.ConsultaTodosProductosCatalogo(new AsyncCallback<List<AuxCatalogoMaterial>>() {
    		
			@Override
    		public void onSuccess(List<AuxCatalogoMaterial> result) {
				
				for (AuxCatalogoMaterial aux : result){
					listEstado.addItem(aux.getIdCatalogoMaterial()+ " "+ aux.getNombreMaterial(), aux.getIdCatalogoMaterial());
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
		String idMaterialConstruccion = listEstado.getValue(listEstado.getSelectedIndex());
		String trimestre = listaTrimestre.getValue(listaTrimestre.getSelectedIndex());
		String fechaInicio = dateBox.getTextBox().getText();
		String fechaFIn = dateBox_1.getTextBox().getText();
		String anio = txt1.getText().equals("") ? "0" : txt1.getText();
		String idProveedor = listBox_2.getValue(listBox_2.getSelectedIndex());
		boolean checkRange =  simpleCheckBox.getValue();	
		
		System.out.println("fecha ini"+fechaInicio+" fin: "+fechaFIn+" check"+checkRange+" material"+idMaterialConstruccion+ " los valores de la siguiente: "+ idAfiliado + " "+ trimestre + " "+anio + " "+idProveedor);
		
		loginService.Consulta_MaterialCostruccionGenerica(idAfiliado, filter, idProveedor, anio, trimestre,fechaInicio,fechaFIn,idMaterialConstruccion,checkRange, new AsyncCallback<List<AuxValeBeneficiario> >() {
			
			@Override
			public void onSuccess(List<AuxValeBeneficiario>  result) {
				// TODO Auto-generated method stub
				System.out.println(result.size());
				
				if(!result.isEmpty()){
					e = new TablaGWT_ReporteMaterialConstruccion(result);
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
					}else{
						e = new TablaGWT_ReporteMaterialConstruccion(new ArrayList<AuxValeBeneficiario>());
						grid.setWidget(1, 0,e);
						e.setSize("1700px", "300px");
					}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		

		
		
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
