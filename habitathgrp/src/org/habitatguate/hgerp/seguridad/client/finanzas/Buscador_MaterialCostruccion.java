package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoProducto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;

import com.google.appengine.api.search.query.ExpressionParser.negation_return;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;


public class Buscador_MaterialCostruccion extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_MaterialCostruccion e = null;
    public AuxProveedor selectProveedor = null;
    public AuxCatalogoMaterial selectMaterial = null;
    Timer timer2 = new Timer(){
  	  public void run() {
			loginService.ConsultaTodosMaterialCostruccion(new AsyncCallback<List<AuxMaterialCostruccion>>() {
        		
        		@Override
        		public void onSuccess(List<AuxMaterialCostruccion> result) {
        			e.ActulizarList(result);      			
        			
        			
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});

  	  }
    };
	public Buscador_MaterialCostruccion(){
	final Grid grid = new Grid(2, 2);
	final ProveedorNameSuggestOracle listaproveedor = new ProveedorNameSuggestOracle();
	final CatalogoNameSuggestOracle listaProductos = new CatalogoNameSuggestOracle();
	initWidget(grid);
	grid.setWidth("1278px");
	
	//------------------------------primera fila

	loginService.ConsultaTodosProveedor_PorAfiliadoAprobados(0L,new AsyncCallback<List<AuxProveedor>>() {
		
		@Override
		public void onSuccess(List<AuxProveedor> result) {
			if (!result.isEmpty()){
				for (AuxProveedor p : result){
					listaproveedor.add(new ProveedorMultiWordSuggestion(p));	
				}
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
			if (!result.isEmpty()){
				for (AuxCatalogoMaterial p : result){
					listaProductos.add(new CatalogoMultiWordSuggestion(p));	
				}
			}			
			
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
	
	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1025px", "90px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	
	Label label = new Label("Nombre Material Costruccion");
	label.setStyleName("label");
	absolutePanel.add(label, 226, 66);
	label.setSize("250px", "13px");
	
		
	/*textBox.addKeyUpHandler(new KeyUpHandler() {
        @Override
        public void onKeyUp(KeyUpEvent event) {
        	textBox.setText(textBox.getText().toUpperCase());
        }
    });*/	
	
	Label label_1 = new Label("Precio Sugerido");
	label_1.setStyleName("label");
	absolutePanel.add(label_1, 484, 66);
	label_1.setSize("192px", "13px");
	

	
	final TextBox textBox_1 = new TextBox();
	textBox_1.setStyleName("gwt-TextBox2");
	textBox_1.setMaxLength(100);
	absolutePanel.add(textBox_1, 484, 85);
	textBox_1.setSize("227px", "34px");
	
	Label label_2 = new Label("Unidad Medida");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 725, 66);
	label_2.setSize("157px", "19px");
	
	final TextBox textBox_2 = new TextBox();
	textBox_2.setStylePrimaryName("gwt-TextBox2");
	textBox_2.setStyleName("gwt-TextBox2");
	textBox_2.setMaxLength(100);
	absolutePanel.add(textBox_2, 725, 85);
	textBox_2.setSize("227px", "34px");
	
			
		
		//-----------------------------	---------------------------------
	
	/*Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "55px");*/
	
	
	
	Button button = new Button("Send");
		

	button.setText("Nuevo Material Costr.");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 900, 85);
	button.setSize("157px", "40px");
	
	Label lblProveedor = new Label("Proveedor");
	lblProveedor.setStyleName("label");
	absolutePanel.add(lblProveedor, 10, 10);
	lblProveedor.setSize("157px", "13px");
	
	final SuggestBox suggestBox = new SuggestBox(listaproveedor);
	absolutePanel.add(suggestBox, 10, 29);
	suggestBox.setSize("375px", "13px");
	
	final SuggestBox suggestBox2 = new SuggestBox(listaProductos);
	absolutePanel.add(suggestBox2, 226, 85);
	suggestBox2.setSize("227px", "13px");
	
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!suggestBox2.getText().equals("")){
				
				
			loginService.Insertar_MaterialCostruccionAfiliadoProveedor(selectProveedor.getIdProveedor(),suggestBox2.getText(),textBox_2.getText(), Double.valueOf(textBox_1.getText()),selectMaterial.getIdProducto(),
					selectProveedor.getAuxAfiliado().getIdAfiliado(),
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
                	//textBox.setText("");
                	textBox_1.setText("");
                	textBox_2.setText("");
                	suggestBox.setText("");
                	selectProveedor = null;
                	timer2.schedule(1500);
                	
                	
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
			ProveedorMultiWordSuggestion select = (ProveedorMultiWordSuggestion)event.getSelectedItem();
			selectProveedor = select.getAfiliado();
			System.out.println(selectProveedor.getIdProveedor());
			
		}
	});
	
	suggestBox2.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
		
		@Override
		public void onSelection(SelectionEvent<Suggestion> event) {
			// TODO Auto-generated method stub
			CatalogoMultiWordSuggestion select = (CatalogoMultiWordSuggestion)event.getSelectedItem();
			selectMaterial = select.getAfiliado();
			System.out.println(selectMaterial.getIdProducto());
			
		}
	});
	
	
	
	
	loginService.ConsultaTodosMaterialCostruccion(new AsyncCallback<List<AuxMaterialCostruccion>>() {
		
		@Override
		public void onSuccess(List<AuxMaterialCostruccion> result) {
			System.out.println("ya estan todos los afiliados");
			e = new TablaGWT_MaterialCostruccion(result);
			grid.setWidget(1, 0,e);
			e.setSize("700px", "300px"); 			
			
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
	

	
   
}
}
