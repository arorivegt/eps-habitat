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
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.datepicker.client.DateBox;

public class ReporteRecordSoluciones extends Composite   {

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
	public ReporteRecordSoluciones() {

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
		listBox.addItem("Beneficiario");
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
		
		lbDato1 = new Label("Nombre del Beneficiario");
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
				if(listBox.getItemText(listBox.getSelectedIndex()).equals("Beneficiario"))
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
		initWidget(grid);
		
		absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-Label-new");
		grid.setWidget(1, 0, absolutePanel_1);
		absolutePanel_1.setSize("1096px", "550px");
		
		

		
		
		
	}
	
	
	
	

	public void buscar(){
		System.out.println("beneficiario "+ idBeneficiario);
		/*loginService.ConsultaRecord_Beneficiario(0L, idBeneficiario, new AsyncCallback<AuxBeneficiario>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(AuxBeneficiario result) {
				// TODO Auto-generated method stub
				
				System.out.println("Se obtuvo el siguiente beneficiario:" + result.getNomBeneficiario());
				

				
			}
		});*/
		Window.open("/FinanGenerarPdfReporteRecord?idBeneficiario="+idBeneficiario, "_blank", "");
		
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
				for (Double cantidad : result.get(0).getCostoProducto()){
					System.out.println("la cantidad es:"+ cantidad);
				}
				e = new TablaGWT_SolucionGeneral(result);
				grid.setWidget(1, 0,e);
				e.setSize("1700px", "300px");
				
			}
		});
	}
	
	public void BuscarAfiliado(){
		System.out.println("Afiliado");
	}

	
	


}
