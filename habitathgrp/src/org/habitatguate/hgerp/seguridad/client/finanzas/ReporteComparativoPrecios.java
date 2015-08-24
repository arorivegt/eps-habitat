package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
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
		absolutePanel.setSize("100%", "50px");
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
		absolutePanel.add(listBox, 10, 29);
		listBox.setSize("179px", "39px");
		
		txtDato1 =  new SuggestBox(bene);

		txtDato1.setStylePrimaryName("gwt-TextBox2");
		txtDato1.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDato1, 205, 19);
		txtDato1.setSize("250px", "34px");
		txtDato1.setVisible(false);
		
		
		listItems = new ListBox();
		absolutePanel.add(listItems, 195, 34);
		listItems.setSize("250px", "34px");
		listItems.setVisible(true);
		
		listEstado = new ListBox();
		listEstado.setStyleName("gwt-TextBox2");
		listEstado.setVisible(true);
		absolutePanel.add(listEstado, 479, 29);
		listEstado.setSize("179px", "39px");
		
		lbDato1 = new Label("Nombre del Material de Construcción");
		lbDato1.setStyleName("label");
		lbDato1.setSize("278px", "19px");
		absolutePanel.add(lbDato1, 195, 4);
		
		Label lblBusquedaPor = new Label("Busqueda Por");
		lblBusquedaPor.setStyleName("label");
		lblBusquedaPor.setSize("179px", "13px");
		absolutePanel.add(lblBusquedaPor, 10, 10);
		
		button_1 = new Button("Send");
		button_1.setText("Exportar Excel");
		button_1.setStyleName("finanButton");
		absolutePanel.add(button_1, 1019, 16);
		button_1.setSize("157px", "30px");
		
		formPanel = new FormPanel();

		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		absolutePanel.add(formPanel, 365, 41);
        formPanel.setSize("209px", "44px");
		
		
		Busqueda = new Image("images/pdf.png");
		absolutePanel.add(Busqueda, 820, 10);
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
		absolutePanel.add(lblProveedor, 479, 4);
		lblProveedor.setSize("278px", "19px");
		
	
		button_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String itemConstruccion = listItems.getValue(listItems.getSelectedIndex());
				String idAfiliado		= listEstado.getValue(listEstado.getSelectedIndex());
				System.out.println("nelson "+ itemConstruccion + idAfiliado);
				
				
				
				formPanel.setAction("/ExportComparativoPrecios?idAfiliado="+idAfiliado+"&itemConstruccion="+itemConstruccion);
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
		
		String itemConstruccion = listItems.getValue(listItems.getSelectedIndex());
		String idAfiliado		= listEstado.getValue(listEstado.getSelectedIndex());
		System.out.println("nelson "+ itemConstruccion + idAfiliado);
		loginService.Consulta_ComparativoPreciosGenerica(itemConstruccion,idAfiliado, new AsyncCallback<List<AuxMaterialCostruccion>>() {
			
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
