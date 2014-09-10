package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class Buscador_Soluciones_Inv extends Composite {
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT e = null;
	public Buscador_Soluciones_Inv(){

	final Grid grid = new Grid(2, 1);
	initWidget(grid);
	grid.setWidth("1278px");
	
	//------------------------------primera fila
	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1000px", "90px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	Label label = new Label("No. Casa");
	label.setStyleName("label");
	absolutePanel.add(label, 5, 10);
	label.setSize("157px", "13px");
	
	Label label_1 = new Label("Nombre prestatario");
	label_1.setStyleName("label");
	absolutePanel.add(label_1, 242, 10);
	label_1.setSize("192px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 5, 29);
	textBox.setSize("227px", "34px");
	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 242, 29);
	textBox_1.setSize("227px", "34px");
	
	Label label_2 = new Label("Dirección");
	label_2.setStyleName("label");
	absolutePanel.add(label_2, 479, 10);
	label_2.setSize("157px", "19px");
	
	final TextBox textBox_2 = new TextBox();
	textBox_2.setStylePrimaryName("gwt-TextBox2");
	textBox_2.setStyleName("gwt-TextBox2");
	textBox_2.setMaxLength(100);
	absolutePanel.add(textBox_2, 479, 29);
	textBox_2.setSize("227px", "34px");
	
	final TextBox textBox_3 = new TextBox();
	textBox_3.setStylePrimaryName("gwt-TextBox2");
	textBox_3.setStyleName("gwt-TextBox2");
	textBox_3.setMaxLength(100);
	absolutePanel.add(textBox_3, 716, 29);
	textBox_3.setSize("227px", "34px");
	
	Label label_3 = new Label("Comunidad");
	label_3.setStyleName("label");
	absolutePanel.add(label_3, 716, 10);
	label_3.setSize("157px", "13px");
	
	//---------------------------------segunda fila
	
	//----------------------------Segunda fila---------------------------------
	
		Label label_4 = new Label("Telefono");
		label_4.setStyleName("label");
		absolutePanel.add(label_4, 20, 68);
		label_4.setSize("157px", "13px");
		
		Label label_5 = new Label("Nombre Responsable");
		label_5.setStyleName("label");
		absolutePanel.add(label_5, 257, 68);
		label_5.setSize("192px", "13px");
		
		final TextBox textBox_4 = new TextBox();
		textBox_4.setStyleName("gwt-TextBox2");
		textBox_4.setMaxLength(100);
		absolutePanel.add(textBox_4, 20, 85);
		textBox_4.setSize("227px", "34px");
		
		final TextBox textBox_5 = new TextBox();
		textBox_5.setStyleName("gwt-TextBox2");
		textBox_5.setMaxLength(100);
		absolutePanel.add(textBox_5, 257, 85);
		textBox_5.setSize("227px", "34px");
		
		Label label_6 = new Label("Monto Autorizado");
		label_6.setStyleName("label");
		absolutePanel.add(label_6, 494, 68);
		label_6.setSize("157px", "19px");
		
		final TextBox textBox_6 = new TextBox();
		textBox_6.setStylePrimaryName("gwt-TextBox2");
		textBox_6.setStyleName("gwt-TextBox2");
		textBox_6.setMaxLength(100);
		absolutePanel.add(textBox_6, 494, 85);
		textBox_6.setSize("227px", "34px");
		
		final TextBox textBox_7 = new TextBox();
		textBox_7.setStylePrimaryName("gwt-TextBox2");
		textBox_7.setStyleName("gwt-TextBox2");
		textBox_7.setMaxLength(100);
		absolutePanel.add(textBox_7, 731, 85);
		textBox_7.setSize("227px", "34px");
		
		Label label_7 = new Label("Comunidad");
		label_7.setStyleName("label");
		absolutePanel.add(label_7, 731, 68);
		label_7.setSize("157px", "13px");
		
		
		
		//-----------------------------	---------------------------------
	
	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "55px");
	
	
	
	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("")){

			loginService.Insertar_Beneficiario(textBox.getText(),textBox_1.getText(), Integer.parseInt(textBox_2.getText()),
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
                	textBox_3.setText("");

                	
                }

         });
			
			/*loginService.ConsultaTodosParam(new AsyncCallback<List<AuxParametro>>() {
        		
        		@Override
        		public void onSuccess(List<AuxParametro> result) {
        			e.ActulizarList(result);      			
        			
        			
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});*/
		}
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});		

	button.setText("Nueva Solución");
	button.setStylePrimaryName("gwt-TextBox2");
	button.setStyleName("gwt-TextBox2");
	absolutePanel.add(button, 958, 29);
	button.setSize("157px", "40px");
	
	

	
   
}
}