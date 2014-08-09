package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

public class Panel extends Composite {

	private AbsolutePanel absolutePanel_1;
		public Panel() {
         SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
         initWidget(splitLayoutPanel);
         splitLayoutPanel.setSize("100%", "800px");
                
         HTMLPanel panel = new HTMLPanel("");
         panel.setStyleName("panelNorth");
         splitLayoutPanel.addNorth(panel, 43.0);
         panel.setSize("100%", "100%");
             
             Image image = new Image("images/imagenempresa.png");
             panel.add(image);
             image.setSize("123px", "35px");
             
             HTMLPanel panel_1 = new HTMLPanel("");
             panel_1.setStyleName("Panel_Central");
             splitLayoutPanel.addSouth(panel_1, 27.0);
             panel_1.setSize("1200px", "20px");
             
             AbsolutePanel absolutePanel = new AbsolutePanel();
             absolutePanel.setStyleName("html-west");
             splitLayoutPanel.addWest(absolutePanel, 124.0);
             absolutePanel.setSize("100%", "100%");
             
             UIStacksEjemplo menu2 = new UIStacksEjemplo(this);
             absolutePanel.add(menu2, 0, 0);
             menu2.setSize("124px", "388px");
             
             absolutePanel_1 = new AbsolutePanel();
             splitLayoutPanel.add(absolutePanel_1);
                 setStyleName("Panel_principal");
                 setSize("1343px", "734px");
                 
                 //Buscador_Parametro_Inv buscador = new Buscador_Parametro_Inv(); 
               //  Buscador_Empleados buscador = new Buscador_Empleados();
                 //Empleado_tab empleado = new Empleado_tab();
                // absolutePanel_1.add(buscador, 0, 0);
                 //empleado.setSize("1187px", "648px");
        }
		

        public AbsolutePanel getAbsolutePanel_1() {
		return absolutePanel_1;
	}
}