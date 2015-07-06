package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;

public class Formulario_CuentasXPagar extends Composite  {
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	public long idProveedorActual = 0L;
	Formulario_PagoVale formularioPago;
    TablaGWT_ListaVale e = null;
	
	public Formulario_CuentasXPagar(){
		

		
		final Grid grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		

		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "20px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		//----------------------------primera fila---------------------------------
		
		Label label = new Label("Nombre del proveedor");
		label.setStyleName("label");
		absolutePanel.add(label, 20, 10);
		label.setSize("275px", "18px");
		
		final ValueListBox<AuxProveedor> valueListBox = new ValueListBox<AuxProveedor>(new Renderer<AuxProveedor>() {
			  public String render(AuxProveedor user) {
				    String s = "";
				    if (user != null) {
				      // Specify the format for the Strings to display per list item here. In this example, it is 
				      // 'username (firstname lastname)'
				      // For example: MTielemans (Mark Tielemans)
				      s = " "+user.getNomProveedor();
				    } else {
				      s = "Seleccione Proveedor";
				    }
				    return s; 
				  }

				  public void render(AuxProveedor user, Appendable appendable) throws IOException {
				      String s = render(user);
				      appendable.append(s);
				  }
			
		});
		
		valueListBox.addValueChangeHandler(new ValueChangeHandler<AuxProveedor>()
		        {

					@Override
					public void onValueChange(
							ValueChangeEvent<AuxProveedor> event) {
						 idProveedorActual = event.getValue().getIdProveedor();
							loginService.ConsultarValesPendientes_unProveedor(idProveedorActual, new AsyncCallback<List<AuxVale>>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(List<AuxVale> result) {
									e = new TablaGWT_ListaVale(result);
									grid.setWidget(1, 0,e);
									e.setSize("1000px", "300px");
									
								}
							});
					}
		        
		        });
		
		
	/*	Image image = new Image("images/ico-lupa.png");
		absolutePanel.add(image, 958, 0);
		image.setSize("103px", "55px");*/
		
		absolutePanel.add(valueListBox, 20, 34);
		valueListBox.setSize("275px", "20px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Set<AuxVale> total= e.grid.selectionModel.getSelectedSet();
				if (!total.isEmpty()){
				formularioPago = new Formulario_PagoVale(total,idProveedorActual);
			//	formularioPago.setMensaje();
				}
			}
		});		

		button.setText("Realizar Pago Vale");
		button.setStyleName("finanButton");
		absolutePanel.add(button, 968, 29);
		button.setSize("157px", "30px");
		
		

		loginService.ConsultaTodosProveedor_Aprobados(new AsyncCallback<List<AuxProveedor>>() {
			
			@Override
			public void onSuccess(List<AuxProveedor> result) {
				System.out.println("ya estan todos los proveedores");
				valueListBox.setAcceptableValues(result);

		
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
				
			}
		});
		
		e = new TablaGWT_ListaVale(new ArrayList<AuxVale>());
		grid.setWidget(1, 0,e);
		e.setSize("1000px", "300px");
		
	}
}
