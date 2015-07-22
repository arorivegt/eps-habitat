package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoProducto;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class Formulario_CatalogoMaterial extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_CatalogoMaterial e = null;
    Timer timer2 = new Timer(){
  	  public void run() {
			loginService.ConsultaTodosProductosCatalogo(new AsyncCallback<List<AuxCatalogoMaterial>>() {
        		
        		@Override
        		public void onSuccess(List<AuxCatalogoMaterial> result) {
   			
        			e.ActulizarList(result);
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});

  	  }
    };
	
	public Formulario_CatalogoMaterial(){
		final Grid grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		


		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "20px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		//----------------------------primera fila---------------------------------
		
		Label labelProductos = new Label("Tipo de Producto");
		labelProductos.setStyleName("label");
		absolutePanel.add(labelProductos, 10, 10);
		labelProductos.setSize("157px", "13px");
		
		final ListBox listaProducto = new ListBox();
		listaProducto.setStyleName("label");
		absolutePanel.add(listaProducto,10,29);
		listaProducto.setSize("200px", "25px");
		
		Label label = new Label("Codigo Item");
		label.setStyleName("label");
		absolutePanel.add(label, 230, 10);
		label.setSize("157px", "13px");
		
		Label label_1 = new Label("Subtipo Item");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 750, 10);
		label_1.setSize("192px", "13px");
		
		final TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(100);
		absolutePanel.add(textBox, 230, 29);
		textBox.setSize("227px", "34px");
		
		final TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(100);
		absolutePanel.add(textBox_1, 750, 29);
		textBox_1.setSize("227px", "34px");
		
		Label label_2 = new Label("Nombre Producto");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 494, 10);
		label_2.setSize("157px", "19px");
		
		final TextBox textBox_2 = new TextBox();
		textBox_2.setStylePrimaryName("gwt-TextBox2");
		textBox_2.setStyleName("gwt-TextBox2");
		textBox_2.setMaxLength(100);
		absolutePanel.add(textBox_2, 494, 29);
		textBox_2.setSize("227px", "34px");
		

			
	/*	Image image = new Image("images/ico-lupa.png");
		absolutePanel.add(image, 958, 0);
		image.setSize("103px", "55px");*/
		
		
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!textBox.getText().equals("")){

				loginService.Insertar_Catalogo(textBox.getText(), textBox_2.getText(), textBox_1.getText(),listaProducto.getValue(listaProducto.getSelectedIndex()),
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
	                	Window.alert("Nuevo Catalogo Material con el codigo: "+ result);
	                	textBox.setText("");
	                	textBox_1.setText("");
	                	textBox_2.setText("");

	                	
	                }

	         });
				

			}
			
			else{
				Window.alert("Debe completar el formulario");
			}
			}
		});		

		button.setText("Nuevo Producto");
		button.setStyleName("finanButton");
		absolutePanel.add(button, 1000, 29);
		button.setSize("157px", "30px");
		
		

		loginService.ConsultaTodosProductosCatalogo(new AsyncCallback<List<AuxCatalogoMaterial>>() {
			
			@Override
			public void onSuccess(List<AuxCatalogoMaterial> result) {
				System.out.println("ya estan todos los afiliados");
				e = new TablaGWT_CatalogoMaterial(result);
				grid.setWidget(1, 0,e);
				e.setSize("1000px", "300px");
		
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});	
		
		
		loginService.Consultar_CatalogoProductos(new AsyncCallback<List<AuxCatalogoProducto>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<AuxCatalogoProducto> result) {
				// TODO Auto-generated method stub
				for (AuxCatalogoProducto aux : result){
					listaProducto.addItem(aux.getDescripcionProducto(), aux.getIdProducto());
				}
				
			}
		});
	}
	
	
}
