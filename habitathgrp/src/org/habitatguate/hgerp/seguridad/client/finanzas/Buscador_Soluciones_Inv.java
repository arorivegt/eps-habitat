package org.habitatguate.hgerp.seguridad.client.finanzas;


import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class Buscador_Soluciones_Inv extends Composite {
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	private AuxAfiliado selectNuevo = null;
    TablaGWT_Beneficiario e = null;
    Timer timer2 = new Timer(){
    	  public void run() {
			loginService.ConsultaTodosBene(new AsyncCallback<List<AuxBeneficiario>>() {
        		
        		@Override
        		public void onSuccess(List<AuxBeneficiario> result) {
        			e.ActulizarList(result);      			
        			
        			
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});

    	  }
      };
	public Buscador_Soluciones_Inv(){
	final Grid grid = new Grid(2, 1);
	initWidget(grid);
	grid.setWidth("1278px");
	
	final AfiliadoNameSuggestOracle listaAfiliado = new AfiliadoNameSuggestOracle();
	
	loginService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>() {
		
		@Override
		public void onSuccess(List<AuxAfiliado> result) {
			if (!result.isEmpty()){
				for (AuxAfiliado p : result){
					listaAfiliado.add(new AfiliadoMultiWordSuggestion(p));	
				}
			}
	
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
	
	//------------------------------primera fila
	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1000px", "90px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	Label label = new Label("Nombre Prestatario");
	label.setStyleName("label");
	absolutePanel.add(label, 5, 10);
	label.setSize("157px", "13px");
	
	Label label_1 = new Label("Dirección");
	label_1.setStyleName("label");
	absolutePanel.add(label_1, 242, 10);
	label_1.setSize("192px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 5, 29);
	textBox.setSize("219px", "17px");
	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 242, 29);
	textBox_1.setSize("219px", "17px");
	
	Label label_2 = new Label("Telefono");
	label_2.setStyleName("label");
	absolutePanel.add(label_2, 479, 10);
	label_2.setSize("157px", "19px");
	
	final TextBox textBox_2 = new TextBox();
	textBox_2.setStylePrimaryName("gwt-TextBox2");
	textBox_2.setStyleName("gwt-TextBox2");
	textBox_2.setMaxLength(100);
	absolutePanel.add(textBox_2, 479, 29);
	textBox_2.setSize("219px", "17px");
	
			
		
		//-----------------------------	---------------------------------
	
	/*Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 706, 10);
	image.setSize("56px", "40px");*/
	
	
	
	Button button = new Button("Send");
	

	button.setText("Nueva Beneficiario");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 913, 95);
	button.setSize("157px", "40px");
	
	CaptionPanel cptnpnlNewPanel = new CaptionPanel("Afiliado");
	absolutePanel.add(cptnpnlNewPanel, 5, 54);
	cptnpnlNewPanel.setSize("674px", "62px");
	
	AbsolutePanel absolutePanel_1 = new AbsolutePanel();
	cptnpnlNewPanel.setContentWidget(absolutePanel_1);
	absolutePanel_1.setSize("686px", "51px");
	
	Label lblNombreAfiliado = new Label("Nombre Afiliado");
	lblNombreAfiliado.setStyleName("label");
	absolutePanel_1.add(lblNombreAfiliado, 0, 0);
	lblNombreAfiliado.setSize("157px", "13px");
	
	final SuggestBox suggestBox = new SuggestBox(listaAfiliado);
	absolutePanel_1.add(suggestBox, 10, 19);
	suggestBox.setSize("226px", "16px");
	

	
	Label lblMunicipio = new Label("Municipio");
	lblMunicipio.setStyleName("label");
	absolutePanel_1.add(lblMunicipio, 246, 0);
	lblMunicipio.setSize("157px", "13px");
	
	final TextBox textBox_3 = new TextBox();
	textBox_3.setStyleName("gwt-TextBox2");
	textBox_3.setMaxLength(100);
	absolutePanel_1.add(textBox_3, 246, 20);
	textBox_3.setSize("166px", "17px");
	
	final TextBox textBox_4 = new TextBox();
	textBox_4.setStyleName("gwt-TextBox2");
	textBox_4.setMaxLength(100);
	absolutePanel_1.add(textBox_4, 420, 19);
	textBox_4.setSize("200px", "17px");
	
	
	Label lblDepartamento = new Label("Departamento");
	lblDepartamento.setStyleName("label");
	absolutePanel_1.add(lblDepartamento, 425, 0);
	lblDepartamento.setSize("157px", "13px");
	
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("") && selectNuevo != null){

			loginService.Insertar_Bene(textBox.getText(),textBox_1.getText(), Integer.parseInt(textBox_2.getText()),selectNuevo.getIdAfiliado(),
					new AsyncCallback<Long>(){
				@Override		
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {			
                	Window.alert("Datos Almacenados Correctamente");
                	textBox.setText("");
                	textBox_1.setText("");
                	textBox_2.setText("");
                	suggestBox.setText("");
                	textBox_3.setText("");
                	textBox_4.setText("");
                	timer2.schedule(1500);
                	selectNuevo = null;
                }

         });


		}
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});	
	
	suggestBox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
		
		@Override
		public void onSelection(SelectionEvent<Suggestion> event) {
			// TODO Auto-generated method stub
			AfiliadoMultiWordSuggestion select = (AfiliadoMultiWordSuggestion)event.getSelectedItem();
			selectNuevo = select.getAfiliado();
			textBox_3.setText(selectNuevo.getDepartamento());
			textBox_4.setText(selectNuevo.getMunicipio());
		}
	});
	
	
	
	loginService.ConsultaTodosBene(new AsyncCallback<List<AuxBeneficiario>>() {
		
		@Override
		public void onSuccess(List<AuxBeneficiario> result) {

			e = new TablaGWT_Beneficiario(result);
			grid.setWidget(1, 0,e);
			e.setSize("1000px", "300px");
			e.ActulizarList(result);

			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
	

	
   
}
}
