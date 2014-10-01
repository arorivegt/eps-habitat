package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPlantillaSolucion;

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

public class Plantilla_Solucion extends Composite{

	
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_PlantillaSolucion e = null;
    
    public Plantilla_Solucion() {
	final Grid grid = new Grid(2, 1);
	initWidget(grid);
	grid.setWidth("1278px");
	
	//------------------------------primera fila
	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1000px", "90px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	Label label = new Label("Nombre Plantilla");
	label.setStyleName("label");
	absolutePanel.add(label, 5, 10);
	label.setSize("157px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 5, 29);
	textBox.setSize("227px", "34px");
	
	Label label_1 = new Label("Tipo");
	label_1.setStyleName("label");
	absolutePanel.add(label_1, 242, 10);
	label_1.setSize("192px", "13px");
	

	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 242, 29);
	textBox_1.setSize("227px", "34px");
	
		
		//-----------------------------	---------------------------------
	
	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "55px");
	
	
	
	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("")){

		/*	loginService.Insertar_Beneficiario(textBox.getText(),textBox_1.getText(), Integer.parseInt(textBox_2.getText()),
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


                	
                }

         });*/
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
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});		

	button.setText("Nueva Plantilla");
	button.setStylePrimaryName("gwt-TextBox2");
	button.setStyleName("gwt-TextBox2");
	absolutePanel.add(button, 720, 29);
	button.setSize("157px", "40px");
	


			e = new TablaGWT_PlantillaSolucion(new ArrayList<AuxDetallePlantillaSolucion>());
			grid.setWidget(1, 0,e);
			e.setSize("1000px", "300px");

	

	
   
}
	
}
