package org.habitatguate.hgerp.seguridad.client.finanzas;



import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
	

public class Menu_Proveedores extends Composite{
	public TabPanel tabPanel;
	public Long id_empleado = 0L;
	private ScrollPanel panel1;
	private ScrollPanel panel2;
	private ScrollPanel panel3;
	ScrollPanel panel4;
	private Formulario_Proveedor bp;
	private Buscador_Proveedor fp;
    private Buscador_ProveedorAprobar bpa;
    private Formulario_InfoProveedor fip;
	public Menu_Proveedores(){
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");

		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);
		panel3 = new ScrollPanel();
		panel3.setAlwaysShowScrollBars(true);
		panel4 = new ScrollPanel();
		panel4.setAlwaysShowScrollBars(true);
		tabPanel.add(panel1, "Formulario nuevo proveedor",true);
		tabPanel.add(panel4,"Información Contactos",true);
		tabPanel.add(panel2, "Información Proveedores Aprobados",true);
		tabPanel.add(panel3,"Aprobar Proveedor",true);
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
				   ItemDos();
				   break;
			   case 3:
				   ItemTres();
				   break;
			   }

			 }
			});
	
   
	}

	public void ItemUno(){
		bp = new Formulario_Proveedor(this);
		panel1.setWidget(bp);
	}
	
	public void ItemDos(){
		fp = new Buscador_Proveedor();
		panel2.setWidget(fp);
	}
	public void ItemTres(){
		bpa = new Buscador_ProveedorAprobar();
		panel3.setWidget(bpa);
	}
	
	public void ItemCuatro(){
		if (panel4.getWidget() == null){
			Window.alert("Ingrese o seleccione un proveedor");
		}
	}
	
	
	
}
