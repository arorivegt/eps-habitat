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
	private ScrollPanel panel3;
	private ScrollPanel panel4;
	private Formulario_CrearVale bp;
	private Formulario_CuentasXPagar fcp;
	private Long idAfiliadoSession = 0L;
	private Long idEmpleadoSession = 0L;
	private Formulario_AprobarCompra fac;
	private Formulario_ValesAprobados fva;
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
		
		getSession.obtenerId(new AsyncCallback<Long>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Long result) {
				// TODO Auto-generated method stub
				idEmpleadoSession = result;
				
				System.out.println("buscar empleado" + idEmpleadoSession);
			}
		});
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");

		panel4 = new ScrollPanel();
		panel4.setAlwaysShowScrollBars(true);
		panel3 = new ScrollPanel();
		panel3.setAlwaysShowScrollBars(true);
		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		
		tabPanel.add(panel1, "Generar Vales de Solución",true);
		tabPanel.add(panel4, "Vales Aprobados",true);
		tabPanel.add(panel3, "Aprobar Solicitudes Compra",true);
		tabPanel.add(panel2, "Cuentas por Pagar",true);
		
		panel1.setSize("100%", "480px");

		

		
		tabPanel.addSelectionHandler(new SelectionHandler<Integer>(){
			  public void onSelection(SelectionEvent<Integer> event){
			   int tabId = event.getSelectedItem();
			   switch(tabId) {
			   case 0:
				   ItemUno();
			       break;
			   case 1: 
				   ItemCuatro();
			       break;
			   case 2: 
				   ItemTres();
			       break;
			   case 3:
				   ItemDos();
				   break;

			   }

			 }
			});
	
   
	}

	protected void ItemCuatro() {
		// TODO Auto-generated method stub
		fva = new Formulario_ValesAprobados(idAfiliadoSession,idEmpleadoSession);
		panel4.setWidget(fva);
		
	}

	protected void ItemTres() {
		// TODO Auto-generated method stub
		fac = new Formulario_AprobarCompra(idAfiliadoSession,idEmpleadoSession);
		panel3.setWidget(fac);
	}

	public void ItemUno(){
		bp = new Formulario_CrearVale(idAfiliadoSession,idEmpleadoSession);
		panel1.setWidget(bp);
	}
	
	public void ItemDos(){
		fcp = new Formulario_CuentasXPagar();
		panel2.setWidget(fcp);
	}
}
