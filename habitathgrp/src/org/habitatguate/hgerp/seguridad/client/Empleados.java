/**
 * 
 */
package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * @author anibaljose
 *
 */
public class Empleados extends Composite {

	/**
	 * 
	 */
	public Empleados() {
		
		TabPanel tabPanel = new TabPanel();
		initWidget(tabPanel);
		tabPanel.setSize("827px", "638px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel, "New tab", false);
		scrollPanel.setSize("1200px", "541px");
		// TODO Auto-generated constructor stub
	}

}
