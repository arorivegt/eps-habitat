package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class CopyOfPanel extends Composite {

	public CopyOfPanel() {
		
		SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
		initWidget(splitLayoutPanel);
		splitLayoutPanel.setSize("100%", "500px");
		
		 HTMLPanel panel = new HTMLPanel("");
	     panel.setStyleName("panelNorth");
	     splitLayoutPanel.addNorth(panel, 122.0);
	     panel.setSize("100%", "100%");
	     
	     HTMLPanel panel_1 = new HTMLPanel("");
	     panel_1.setStyleName("lauyout");
	     splitLayoutPanel.addSouth(panel_1, 27.0);
	     panel_1.setSize("100%", "20px");
	     
	     AbsolutePanel absolutePanel = new AbsolutePanel();
	     absolutePanel.setStyleName("html-west");
	     splitLayoutPanel.addWest(absolutePanel, 79.0);
	     absolutePanel.setSize("100%", "100%");
	     
	     UIStacksEjemplo menu = new UIStacksEjemplo();
	     menu.setStyleName("tree_css2");
	     absolutePanel.add(menu, 0, 0);
	     menu.setSize("81px", "335px");
	     
	     HTMLPanel panel_2 = new HTMLPanel("AQUI VAMOS A RENDERIZAR LOS FORMULARIOS");
	     panel_2.setStyleName("html-CENTER");
	     splitLayoutPanel.add(panel_2);
	     panel_2.setSize("100%", "100%");
		setStyleName("lauyout");
	}
	

}
