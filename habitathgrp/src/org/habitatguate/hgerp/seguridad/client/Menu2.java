package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class Menu2 extends Composite{

	private static Menu_pruebaUiBinder uiBinder = GWT
			.create(Menu_pruebaUiBinder.class);

	interface Menu_pruebaUiBinder extends UiBinder<Widget, Menu2> {
	}

	public Menu2() {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
