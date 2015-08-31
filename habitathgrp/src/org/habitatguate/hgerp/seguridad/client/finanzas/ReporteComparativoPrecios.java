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
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;
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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
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
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class ReporteComparativoPrecios extends Composite {
	
	private Mensaje mensaje; 
    private  Grid grid;
    private ListBox listBox;
    private Label lbDato1;
    private Image Busqueda;
    private SuggestBox txtDato1;
    private  ListBox listEstado ;
    private ListBox listItems;
    private AbsolutePanel absolutePanel;
	private FormPanel formPanel;
	public List <AuxBDPuesto> BDpuestos = new ArrayList<AuxBDPuesto>();	
	public List <AuxAfiliado> BDAfiliados = new ArrayList<AuxAfiliado>();	
    private Loading load ;
	private AbsolutePanel absolutePanel_1;
	
	private long idBeneficiario;
	TablaGWT_ComparativoPrecios e = null;
	private BeneNameSuggestOracle bene;
    private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    private Label lblProveedor;
    private Button button_1;
    private Label label;
    private ListBox listBox_1;
    private Label label_1;
    private TextBox textBox;
    private Label label_2;
    private Label label_3;
    private Label label_4;
    private DateBox dateBox;
    private DateBox dateBox_1;
    private SimpleCheckBox simpleCheckBox;
    
    
    public ReporteComparativoPrecios(){
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
		
		bene = new BeneNameSuggestOracle();
		
		listBox = new ListBox();
		listBox.addItem("Material de Construcción");
		//listBox.addItem("Afiliado");
		//listBox.addItem("General");
		listBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Beneficiario"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(true);
					
					txtDato1.setVisible(true);
					listEstado.setVisible(false);
					//absolutePanel.add(Busqueda, 420, 19);
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Material de Construcción"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(false);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(false);

					//grid.clearCell(1, 0);
//					agregarFormulario('2',txtDato1.getText(), "","", 
//							"",txtDato1.getText(),txtDato1.getText()
//							,"");
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("General"))
				{
					lbDato1.setText("Escriba los nombres:");

					lbDato1.setVisible(false);
					
					txtDato1.setVisible(false);
					listEstado.setVisible(false);

					//grid.clearCell(1, 0);
//					agregarFormulario('2',txtDato1.getText(), "","", 
//							"",txtDato1.getText(),txtDato1.getText()
//							,"");
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
		absolutePanel.add(listBox, 10, 53);
		listBox.setSize("179px", "39px");
		
		txtDato1 =  new SuggestBox(bene);

		txtDato1.setStylePrimaryName("gwt-TextBox2");
		txtDato1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDato1, 205, 56);
		txtDato1.setSize("250px", "34px");
		txtDato1.setVisible(false);
		
		
		listItems = new ListBox();
		absolutePanel.add(listItems, 195, 58);
		listItems.setSize("250px", "34px");
		listItems.setVisible(true);
		
		listEstado = new ListBox();
		listEstado.setStyleName("gwt-TextBox2");
		listEstado.setVisible(true);
		absolutePanel.add(listEstado, 463, 56);
		listEstado.setSize("179px", "39px");
		
		lbDato1 = new Label("Nombre del Material de Construcción");
		lbDato1.setStyleName("label");
		lbDato1.setSize("278px", "19px");
		absolutePanel.add(lbDato1, 195, 41);
		
		Label lblBusquedaPor = new Label("REPORTE DE COMPARATIVO DE PRECIOS");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("321px", "25px");
		absolutePanel.add(lblBusquedaPor, 10, 10);
		
		button_1 = new Button("Send");
		button_1.setText("Exportar Excel");
		button_1.setStyleName("finanButton");
		absolutePanel.add(button_1, 1021, 5);
		button_1.setSize("157px", "30px");
		
		formPanel = new FormPanel();

		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		absolutePanel.add(formPanel, 34, 10);
        formPanel.setSize("209px", "44px");
		
		
		Busqueda = new Image("images/pdf.png");
		absolutePanel.add(Busqueda, 1031, 37);
		Busqueda.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Material de Construcción"))
				{
					buscar();
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("General"))
				{
					BuscarGeneral();
					
				}else if(listBox.getItemText(listBox.getSelectedIndex()).equals("Afiliado"))
				{
					BuscarAfiliado();
				}
				
			}
		});
		
		
		
		Busqueda.setSize("103px", "78px");
		
		lblProveedor = new Label("afiliado");
		lblProveedor.setStyleName("label");
		absolutePanel.add(lblProveedor, 463, 41);
		lblProveedor.setSize("278px", "19px");
		
		label = new Label("Seleccione Trimestre");
		label.setStyleName("label");
		absolutePanel.add(label, 656, 10);
		label.setSize("168px", "19px");
		
		listBox_1 = new ListBox();
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 656, 32);
		listBox_1.setSize("168px", "23px");
		listBox_1.addItem("Todos los Trimestres", "0");
		listBox_1.addItem("Enero a Marzo", "1");
		listBox_1.addItem("Abril a Junio", "2");
		listBox_1.addItem("Julio a Septiembre", "3");
		listBox_1.addItem("Octubre a Diciembre", "4");
		
		
		label_1 = new Label();
		label_1.setText("Año");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 842, 10);
		label_1.setSize("32px", "19px");
		
		textBox = new TextBox();
		textBox.setStylePrimaryName("gwt-TextBox2");
		textBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox, 841, 32);
		textBox.setSize("44px", "21px");
		
		label_2 = new Label("Rango de Fechas");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 654, 58);
		label_2.setSize("168px", "19px");
		
		label_3 = new Label("Desde");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 828, 63);
		label_3.setSize("121px", "14px");
		
		label_4 = new Label("Hasta");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 910, 64);
		label_4.setSize("59px", "13px");
		
		dateBox = new DateBox();
		absolutePanel.add(dateBox, 786, 83);
		dateBox.setSize("107px", "20px");
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
		
		
		dateBox_1 = new DateBox();
		absolutePanel.add(dateBox_1, 908, 83);
		dateBox_1.setSize("107px", "20px");
		dateBox_1.setFormat(new DateBox.DefaultFormat 
        		(DateTimeFormat.getFormat("dd/MM/yyyy")));
        dateBox_1.setValue(new Date());
        dateBox_1.getTextBox().setReadOnly(true);
        dateBox_1.setFireNullValues(true);
        dateBox_1.setStyleName("gwt-PasswordTextBox");
        
        dateBox_1.getDatePicker().setVisibleYearCount(100);
        dateBox_1.getDatePicker().setYearArrowsVisible(true);
        dateBox_1.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateBox_1.setVisible(false);
		
		
		simpleCheckBox = new SimpleCheckBox();
		absolutePanel.add(simpleCheckBox, 710, 83);
		simpleCheckBox.setSize("22px", "20px");
		
		simpleCheckBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			   @Override
			   public void onValueChange(ValueChangeEvent<Boolean> event) {
				   System.out.println(event.getValue());
				   if (event.getValue()){
					   dateBox.setVisible(true);
					   dateBox_1.setVisible(true);
					   textBox.setVisible(false);
					   textBox.setText("");
					   
				   }else{
					   dateBox.setVisible(false);
					   dateBox_1.setVisible(false);
					   textBox.setVisible(true);
				   }
			   }


		});
		
		
	
		button_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String filter ="";
				String itemConstruccion = listItems.getValue(listItems.getSelectedIndex());
				String idAfiliado		= listEstado.getValue(listEstado.getSelectedIndex());
				String trimestre = listBox_1.getValue(listBox_1.getSelectedIndex());
				String fechaInicio = dateBox.getTextBox().getText();
				String fechaFIn = dateBox_1.getTextBox().getText();
				String anio = textBox.getText().equals("") ? "0" : textBox.getText();
				boolean checkRange =  simpleCheckBox.getValue();
				System.out.println("nelson "+ itemConstruccion + idAfiliado);
				
				
				
				formPanel.setAction("/ExportComparativoPrecios?idAfiliado="+idAfiliado+"&itemConstruccion="+itemConstruccion
						+"&trimestre="+trimestre+"&fechaInicio="+fechaInicio+"&fechaFin="+fechaFIn+"&anio="+anio+"&checkRange="+checkRange+"&filter="+filter);
				formPanel.submit();
			}
		});
		
		loginService.ConsultaTodosProductosCatalogo(new AsyncCallback<List<AuxCatalogoMaterial>>() {
    		@Override
    		public void onSuccess(List<AuxCatalogoMaterial> result) {
			
    			for(AuxCatalogoMaterial aux : result){
    				listItems.addItem(aux.getIdCatalogoMaterial()+" " +aux.getNombreMaterial(), aux.getIdCatalogoMaterial());
    			}
    		}
    		
    		@Override
    		public void onFailure(Throwable caught) {
    			System.out.println(caught);
    			
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
					 listEstado.addItem("Todos los afiliados","0");
					 for (AuxAfiliado p : result) 
					    {
					    	listEstado.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
					    }
		    	}
				
		    }
		});
		
		initWidget(grid);
		
		absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-Label-new");
		grid.setWidget(1, 0, absolutePanel_1);
		absolutePanel_1.setSize("1096px", "550px");
		
		

		
		
		
	}
	
	
	
	

	public void buscar(){
		
		String filter = "";
		String itemConstruccion = listItems.getValue(listItems.getSelectedIndex());
		String idAfiliado		= listEstado.getValue(listEstado.getSelectedIndex());
		String trimestre = listBox_1.getValue(listBox_1.getSelectedIndex());
		String fechaInicio = dateBox.getTextBox().getText();
		String fechaFIn = dateBox_1.getTextBox().getText();
		String anio = textBox.getText().equals("") ? "0" : textBox.getText();
		System.out.println("nelson "+ itemConstruccion + idAfiliado);
		boolean checkRange =  simpleCheckBox.getValue();
		loginService.Consulta_ComparativoPrecios_Generica2(idAfiliado, filter, itemConstruccion, anio, trimestre, fechaInicio, fechaFIn, checkRange ,new AsyncCallback<List<AuxMaterialCostruccion>>() {
			
			@Override
			public void onSuccess(List<AuxMaterialCostruccion> result) {
				// TODO Auto-generated method stub
				if(!result.isEmpty()){
					e = new TablaGWT_ComparativoPrecios(result);
					grid.setWidget(1, 0,e);
					e.setSize("1700px", "300px");
					}else{
						e = new TablaGWT_ComparativoPrecios(new ArrayList<AuxMaterialCostruccion>());
						grid.setWidget(1, 0,e);
						e.setSize("1700px", "300px");
					}				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	//	Window.open("/ExportComparativoPrecios?idItemMaterial="+listItems.getValue(listItems.getSelectedIndex()), "_blank", "");
		//formPanel.setAction("/ExportComparativoPrecios?idItemMaterial="+listItems.getValue(listItems.getSelectedIndex()));
		//formPanel.submit();

		
	}
	
	public void BuscarGeneral(){
		System.out.println("General");

	}
	
	public void BuscarAfiliado(){
		System.out.println("Afiliado");
	}
}
