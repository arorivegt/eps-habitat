package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class Empleados extends Composite {

	public Empleados() {
		TabPanel tp = new TabPanel();
		tp.setStyleName((String) null);
		tp.setAnimationEnabled(true);
	    
	    ScrollPanel scrollPanel = new ScrollPanel();
	    scrollPanel.setAlwaysShowScrollBars(true);
	    tp.add(scrollPanel, "New tab", false);
	    scrollPanel.setSize("776px", "389px");
	    HTML html = new HTML("Foo");
	    html.setStyleName("gwt-PasswordTextBox");
	    html.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	    tp.add(html, "foo");
	    html.setHeight("272px");
	    tp.add(new HTML("Bar"), "bar");
	    HTML html_1 = new HTML("Baz");
	    html_1.setStyleName("gwt-PasswordTextBox");
	    tp.add(html_1, "baz");

	    // Show the 'bar' tab initially.
	    tp.selectTab(1);
		initWidget(tp);
		tp.setSize("918px", "478px");
		
	}
}
