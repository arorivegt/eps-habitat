package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;

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
import com.google.gwt.user.client.ui.ValueListBox;

public class Formulario_AprobarCompra extends Composite{
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	public long idProveedorActual = 0L;
	Formulario_PagoVale formularioPago;
    TablaGWT_SolicitudesCompra e = null;
    
    public Formulario_AprobarCompra(final Long idAfiliado, final Long idEmpleado) {
		// TODO Auto-generated constructor stub
		

		
		final Grid grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		

		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "20px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		//----------------------------primera fila---------------------------------
		
		Label label = new Label("Solicitudes de Compra sin Aprobar");
		label.setStyleName("label");
		absolutePanel.add(label, 20, 10);
		label.setSize("275px", "18px");
		
				
		
	/*	Image image = new Image("images/ico-lupa.png");
		absolutePanel.add(image, 958, 0);
		image.setSize("103px", "55px");*/
		
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Set<AuxValeBeneficiario> total= e.grid.selectionModel.getSelectedSet();
				for(AuxValeBeneficiario aux : total){
					loginService.Actualizar_StatusValeAprobado(aux.getVale().getIdVale(), 1, new AsyncCallback<String>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(String result) {
							// TODO Auto-generated method stub
							
						}
					});
				}
				Window.alert("Los vales han sido Aprobados");
				
			}
		});		

		button.setText("Aprobar Compra");
		button.setStyleName("finanButton");
		absolutePanel.add(button, 650, 29);
		button.setSize("157px", "30px");
		
		Button button2 = new Button("Send");
		button2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});		

		button2.setText("Rechazar Compra");
		button2.setStyleName("finanButton");
		absolutePanel.add(button2, 850, 29);
		button2.setSize("157px", "30px");
		
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

		button3.setText("Imprimir Solicitud");
		button3.setStyleName("finanButton");
		absolutePanel.add(button3, 1050, 29);
		button3.setSize("157px", "30px");
		
		
		

				
		
		
		loginService.ConsultarValesPendientes_Aprobar(0L, new AsyncCallback<List<AuxValeBeneficiario>>() {

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
