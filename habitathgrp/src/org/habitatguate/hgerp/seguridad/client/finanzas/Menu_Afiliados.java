package org.habitatguate.hgerp.seguridad.client.finanzas;



import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
	

public class Menu_Afiliados extends Composite{
	public TabPanel tabPanel;
	public Long id_empleado = 0L;
	private ScrollPanel panel1;
	private ScrollPanel panel2;
	private Buscador_Afiliado ba;
	private Formulario_PersonalAfiliado fpa;
	public Menu_Afiliados(){
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		tabPanel.setWidth("782px");

		panel2 = new ScrollPanel();
		panel2.setAlwaysShowScrollBars(true);
		panel1 = new ScrollPanel();
		panel1.setAlwaysShowScrollBars(true);

		tabPanel.add(panel1, "Admin. Afiliados",true);
		tabPanel.add(panel2, "Personal Afiliados",true);
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

			   }

			 }
			});
	
   
	}

	public void ItemUno(){
		ba = new Buscador_Afiliado();
		panel1.setWidget(ba);
	}
	
	public void ItemDos(){
		fpa = new Formulario_PersonalAfiliado();
		panel2.setWidget(fpa);
	}

	
	
	
}
