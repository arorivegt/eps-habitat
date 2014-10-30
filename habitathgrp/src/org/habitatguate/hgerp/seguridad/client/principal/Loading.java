package org.habitatguate.hgerp.seguridad.client.principal;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Loading extends Composite {
	
	private Image image; 
	final DialogBox dialogo = new DialogBox();
	public Loading() {
		image = new Image("images/loading.gif");
		initWidget(image);
		image.setSize("100%", "100%");
	}
	
	
	public void Mostrar()
	{
       
        final HTML serverResponseLabel = new HTML();
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogo.setStyleName("loading"); 
        dialogVPanel.setSize("100%", "100%");
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(this);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogo .setWidget(dialogVPanel);
        dialogo .setModal(true);
        dialogo .setGlassEnabled(true);
        dialogo .setAnimationEnabled(true);
        dialogo .center();
        dialogo .show();
    }
	
	public void invisible(){
		dialogo.hide();
	}
	
	public void visible(){
        dialogo .show();
		
	}
}
