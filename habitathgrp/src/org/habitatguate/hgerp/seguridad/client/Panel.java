package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;

public class Panel extends Composite {

	public Panel() {
		
		SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
		initWidget(splitLayoutPanel);
		splitLayoutPanel.setSize("100%", "800px");
		
		 HTMLPanel panel = new HTMLPanel("");
	     panel.setStyleName("panelNorth");
	     splitLayoutPanel.addNorth(panel, 153.0);
	     panel.setSize("100%", "100%");
	     
	     Image image = new Image("images/imagenempresa.png");
	     panel.add(image);
	     image.setSize("221px", "104px");
	     
	     HTMLPanel panel_1 = new HTMLPanel("");
	     panel_1.setStyleName("Panel_Central");
	     splitLayoutPanel.addSouth(panel_1, 27.0);
	     panel_1.setSize("100%", "20px");
	     
	     AbsolutePanel absolutePanel = new AbsolutePanel();
	     absolutePanel.setStyleName("html-west");
	     splitLayoutPanel.addWest(absolutePanel, 146.0);
	     absolutePanel.setSize("100%", "100%");
	     
	     UIStacksEjemplo menu = new UIStacksEjemplo();
	     absolutePanel.add(menu, 0, 0);
	     menu.setSize("139px", "529px");
	     
	     HTMLPanel panel_2 = new HTMLPanel("AQUI VAMOS A RENDERIZAR LOS FORMULARIOS");
	     panel_2.setStyleName("Panel_principal");
	     splitLayoutPanel.add(panel_2);
	     panel_2.setSize("100%", "100%");
		setStyleName("Panel_principal");
		setSize("1343px", "734px");
	}
}
