package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;



public class Formulario_GestorVales extends Composite{
	private TabPanel tabPanel;
	public Long id_empleado = 0L;
	private ScrollPanel panel1;
	private ScrollPanel panel2;
	private Formulario_CrearVale bp;
	private Long idAfiliadoSession = 0L;
    private final RecursosHumanosServiceAsync getSession = GWT.create(RecursosHumanosService.class);
	
	public Formulario_GestorVales(){
		getSession.obtenerIdAfiliado(new AsyncCallback<Long>() {
			
			@Override
			public void onSuccess(Long result) {
				idAfiliadoSession = result;
				
				System.out.println("buscar afiliado" + idAfiliadoSession);

				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");

		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		
		tabPanel.add(panel1, "Generar Vales de Solución",true);
		//tabPanel.add(panel2, "Aprobar Vales",true);
		panel1.setSize("100%", "480px");

		

		
		tabPanel.addSelectionHandler(new SelectionHandler<Integer>(){
			  public void onSelection(SelectionEvent<Integer> event){
			   int tabId = event.getSelectedItem();
			   switch(tabId) {
			   case 0:
				   ItemUno();
			       break;
			   case 1: 
				   ItemDos();
			       break;
			   case 2:

			   }

			 }
			});
	
   
	}

	public void ItemUno(){
		bp = new Formulario_CrearVale(idAfiliadoSession);
		panel1.setWidget(bp);
	}
	
	public void ItemDos(){

	}
}
