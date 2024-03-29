package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTipoSolucion;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class Formulario_TipoSolucion extends Composite {
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_TipoSolucion e = null;
    Timer timer2 = new Timer(){
  	  public void run() {
			loginService.Consultar_TipoSolucion(new AsyncCallback<List<AuxTipoSolucion>>() {
        		
        		@Override
        		public void onSuccess(List<AuxTipoSolucion> result) {
   			
        			e.ActulizarList(result);
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});

  	  }
    };
	public Formulario_TipoSolucion(){

	final Grid grid = new Grid(2, 1);
	initWidget(grid);
	grid.setWidth("1178px");
	


	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1130px", "20px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	//----------------------------primera fila---------------------------------
	
	Label label = new Label("Nombre Tipo Solución");
	label.setStyleName("label");
	absolutePanel.add(label, 20, 10);
	label.setSize("157px", "13px");
	
	Label label_1 = new Label("Descripción");
	label_1.setStyleName("label");
	absolutePanel.add(label_1, 257, 10);
	label_1.setSize("192px", "13px");
	
	final TextBox textBox = new TextBox();
	textBox.setStyleName("gwt-TextBox2");
	textBox.setMaxLength(100);
	absolutePanel.add(textBox, 20, 29);
	textBox.setSize("227px", "34px");
	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 257, 29);
	textBox_1.setSize("227px", "34px");
	
	

	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!textBox.getText().equals("")){

			loginService.Insertar_TipoSolucion(textBox.getText(), textBox_1.getText(),
					new AsyncCallback<String>(){
				@Override		
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Hubó un error al intentar guardar los datos, intentelo de nuevo"+caught);
                }

				@Override
                public void onSuccess(String result)
                {	
                	timer2.schedule(2000);	
                	Window.alert("Nuevo Tipo de Solución Ingresado: "+ result);
                	textBox.setText("");
                	textBox_1.setText("");

                	
                }

         });
			

		}
		
		else{
			Window.alert("Debe completar el formulario");
		}
		}
	});		

	button.setText("Ingresar Tipo Solución");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 968, 29);
	button.setSize("157px", "30px");
	
	

	loginService.Consultar_TipoSolucion(new AsyncCallback<List<AuxTipoSolucion>>() {
		
		@Override
		public void onSuccess(List<AuxTipoSolucion> result) {
			System.out.println("ya estan todos los afiliados");
			e = new TablaGWT_TipoSolucion(result);
			grid.setWidget(1, 0,e);
			e.setSize("1000px", "300px");
	
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
   
}
		
}
