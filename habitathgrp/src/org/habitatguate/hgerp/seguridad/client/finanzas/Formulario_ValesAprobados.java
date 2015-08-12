package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTipoSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;







import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class Formulario_ValesAprobados extends Composite{
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	public long idProveedorActual = 0L;
	Formulario_PagoVale formularioPago;
    TablaGWT_SolicitudesCompra e = null;
	protected AuxBeneficiario selectNuevoBene;
    
    public Formulario_ValesAprobados(final Long idAfiliado, final Long idEmpleado) {
		// TODO Auto-generated constructor stub
    	final BeneNameSuggestOracle bene = new BeneNameSuggestOracle();
    	
    	loginService.ConsultaTodosBene_PorAfiliado(idAfiliado, new AsyncCallback<List<AuxBeneficiario>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(List<AuxBeneficiario> result) {
				// TODO Auto-generated method stub

				if (!result.isEmpty()){
					for (AuxBeneficiario p : result){
						bene.add(new BeneMultiWordSuggestion(p));
						System.out.println(p.getNomBeneficiario());
					}
				}else
				{
					System.out.println("No hay registros");
				}
				
			}
			

		});

		
		final Grid grid = new Grid(2, 1);
		initWidget(grid);
		grid.setSize("1178px", "154px");
		

		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "90px");
		absolutePanel.setStyleName("gwt-Label-new");
		

		
		Label lblAfiliado = new Label("Afiliado");
		lblAfiliado.setStyleName("label");
		absolutePanel.add(lblAfiliado, 20, 10);
		lblAfiliado.setSize("275px", "18px");
		
		final SuggestBox suggestBox = new SuggestBox(bene);
		absolutePanel.add(suggestBox, 208, 73);
		suggestBox.setVisible(false);
		
				
		
	/*	Image image = new Image("images/ico-lupa.png");
		absolutePanel.add(image, 958, 0);
		image.setSize("103px", "55px");*/
		
		Button button = new Button("Send");
				

		button.setText("Buscar Vale");
		button.setStyleName("finanButton");
		absolutePanel.add(button, 825, 77);
		button.setSize("157px", "30px");
				
		Button button3 = new Button("Send");
		button3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				List<AuxValeBeneficiario> total= new ArrayList<AuxValeBeneficiario>(e.grid.selectionModel.getSelectedSet());
				System.out.println("Seleccionado "+ total.size());
				String idVale = total.get(0).getVale().getIdVale();
				Long idBeneficiario = total.get(0).getBeneficiario().getIdBeneficiario();
				System.out.println("/FinanGenerarPdfVale?idVale="+idVale+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&idBeneficiario="+idBeneficiario);
				Window.open("/FinanGenerarPdfVale?idVale="+idVale+"&idEmpleado="+idEmpleado+"&idAfiliado="+idAfiliado+"&idBeneficiario="+idBeneficiario, "_blank", "");
				
			}
		});		

		button3.setText("Imprimir Vale");
		button3.setStyleName("finanButton");
		absolutePanel.add(button3, 1020, 77);
		button3.setSize("157px", "30px");
		
		final ListBox comboBox = new ListBox();
		absolutePanel.add(comboBox, 20, 35);
		comboBox.setSize("174px", "26px");
		
		
		final ListBox comboBox_1 = new ListBox();
		absolutePanel.add(comboBox_1, 20, 81);
		comboBox_1.setSize("178px", "26px");
		comboBox_1.addItem("Seleccione Criterio", "0");
		comboBox_1.addItem("Beneficiaro", "1");
		comboBox_1.addItem("Trimestre y Año", "2");
		
		
		
		
		final Label lblSeleccioneBeneficiario = new Label("Seleccione trimestre");
		lblSeleccioneBeneficiario.setStyleName("label");
		absolutePanel.add(lblSeleccioneBeneficiario, 448, 58);
		lblSeleccioneBeneficiario.setSize("178px", "18px");
		lblSeleccioneBeneficiario.setVisible(false);
		
		final ListBox comboBox_2 = new ListBox();
		absolutePanel.add(comboBox_2, 444, 77);
		comboBox_2.setSize("178px", "26px");
		comboBox_2.addItem("Enero a Marzo", "1");
		comboBox_2.addItem("Abril a Junio", "2");
		comboBox_2.addItem("Julio a Septiembre", "3");
		comboBox_2.addItem("Octubre a Diciembre", "4");
		comboBox_2.setVisible(false);
		
		final Label lblAo = new Label("Año");
		lblAo.setStyleName("label");
		absolutePanel.add(lblAo, 641, 58);
		lblAo.setSize("178px", "18px");
		lblAo.setVisible(false);
		
		final DateBox dateBox = new DateBox();
		absolutePanel.add(dateBox, 642, 77);
		dateBox.setSize("143px", "18px");
		dateBox.setVisible(false);
		
		dateBox.setFormat(new DateBox.DefaultFormat 
        		(DateTimeFormat.getFormat("yyyy")));
        dateBox.setValue(new Date());
        dateBox.getTextBox().setReadOnly(true);
        dateBox.setFireNullValues(true);
        
        dateBox.getDatePicker().setVisibleYearCount(100);
        dateBox.getDatePicker().setYearArrowsVisible(true);
        dateBox.getDatePicker().setYearAndMonthDropdownVisible(true);
		
		final Label label = new Label("Seleccione Beneficiario");
		label.setStyleName("label");
		absolutePanel.add(label, 217, 58);
		label.setSize("178px", "18px");
		label.setVisible(false);
		
		comboBox_1.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				String valor = comboBox_1.getValue(comboBox_1.getSelectedIndex());
				if (valor.equals("1")){
					label.setVisible(true);
					suggestBox.setVisible(true);
					lblAo.setVisible(false);
					lblSeleccioneBeneficiario.setVisible(false);
					dateBox.setVisible(false);
					comboBox_2.setVisible(false);
				}else if (valor.equals("2")){
					label.setVisible(false);
					suggestBox.setVisible(false);
					lblAo.setVisible(true);
					lblSeleccioneBeneficiario.setVisible(true);
					dateBox.setVisible(true);
					comboBox_2.setVisible(true);
				}
			}	
		});
		
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String valor = comboBox_1.getValue(comboBox_1.getSelectedIndex());
				if (valor.equals("1")){
					loginService.ConsultarValesAprobados(0L,selectNuevoBene.getIdBeneficiario(), new AsyncCallback<List<AuxValeBeneficiario>>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(List<AuxValeBeneficiario> result) {
							e = new TablaGWT_SolicitudesCompra(result);
							grid.setWidget(1, 0,e);
							e.setSize("1000px", "300px");
							System.out.println("Numero de Vales encontrados + " + result.size());
						}
					});
				}else if (valor.equals("2")){
					System.out.println(Long.valueOf(comboBox.getValue(comboBox.getSelectedIndex()))+dateBox.getTextBox().getText()+Integer.valueOf(comboBox_2.getValue(comboBox_2.getSelectedIndex())));
					
					loginService.ConsultarValesAprobados_PorTrimestreAnio(Long.valueOf(comboBox.getValue(comboBox.getSelectedIndex())),comboBox_2.getValue(comboBox_2.getSelectedIndex()),Integer.valueOf(dateBox.getTextBox().getText()), new AsyncCallback<List<AuxValeBeneficiario>>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(List<AuxValeBeneficiario> result) {
							e = new TablaGWT_SolicitudesCompra(result);
							grid.setWidget(1, 0,e);
							e.setSize("1000px", "300px");
							System.out.println("Numero de Vales encontrados + " + result.size());
						}
					});
					
				}
				
			}
		});
		
		loginService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>() {
			
			@Override
			public void onSuccess(List<AuxAfiliado> result) {
				for(AuxAfiliado aux : result){
					comboBox.addItem(aux.getNomAfiliado(), String.valueOf(aux.getIdAfiliado()));
				}
		
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});
		
		suggestBox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
			
			@Override
			public void onSelection(
					SelectionEvent<SuggestOracle.Suggestion> event) {
				// TODO Auto-generated method stub
				BeneMultiWordSuggestion select = (BeneMultiWordSuggestion)event.getSelectedItem();
				selectNuevoBene = select.getAfiliado();
				
			}
		});
		
		
		
	}
}
