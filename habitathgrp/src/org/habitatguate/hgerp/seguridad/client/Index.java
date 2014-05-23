package org.habitatguate.hgerp.seguridad.client;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class Index implements EntryPoint {
	
	final TextBox user =new TextBox();
	final PasswordTextBox pass =new PasswordTextBox();
	final Button sendButton = new Button("Send");
	private final LoginServiceAsync loginService = GWT
			.create(LoginService.class);
	
	@Override
	public void onModuleLoad() 
	{
	    
	    final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Autenticacion");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("cerrar");
		
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
        
		// Add a handler to close the DialogBox

		
		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler
		{
			
			public void onClick(ClickEvent event) 
			{
				login();
			}
			private void login() 
			{
				// First, we validate the input.
				final Button sendButton = new Button("Send");	
				String usertxt = user.getText();
				String passtxt= pass.getText();
				// Then, we send the input to the server.
				sendButton.setEnabled(false);
						
				closeButton.addClickHandler(new ClickHandler() 
				{
					public void onClick(ClickEvent event) 
					{
						dialogBox.hide();
						sendButton.setEnabled(true);
						sendButton.setFocus(true);
					}
				});
				
				textToServerLabel.setText(usertxt+" / "+passtxt);
				serverResponseLabel.setText("");
						
				loginService.login(usertxt,passtxt, new AsyncCallback<String[]>() 
				{
					public void onFailure(Throwable caught) 
					{
						// Show the RPC error message to the user
						dialogBox.setText("Error en login :(");
						dialogBox.center();
						closeButton.setFocus(true);
					}
					
					public void onSuccess(String result[])
					{
						//si la autentificacion es correcta limpia y contruye el menu
						if(result!=null)
						{
							Panel inicio = new Panel();
							RootPanel.get().clear();
							RootPanel.get().add(inicio);
							//RootPanel.get().add(buildMenu(result));
						}else
						{
							dialogBox.setText("Usuario o password incorrecto");
							dialogBox.center();
							closeButton.setFocus(true);
						}
										
					}
				 });
			}
		}// Add a handler to send the name to the server
		
		MyHandler handler = new MyHandler();
	    RootPanel rootPanel = RootPanel.get();
	    rootPanel.setStyleName("body");
		
	    // Add some standard form options
			    
	    Label lblNewLabel = new Label("Inicio");
	    rootPanel.add(lblNewLabel, 508, 72);
	    lblNewLabel.setSize("346px", "30px");
	    
	    Label lblNewLabel_1 = new Label("");
	    lblNewLabel_1.setStyleName("gwt-Label-new");
	    rootPanel.add(lblNewLabel_1, 508, 135);
	    lblNewLabel_1.setSize("346px", "175px");
	    	    
	    final Button sendButton_1 = new Button("Send");
	    rootPanel.add(sendButton_1, 545, 286);
	    sendButton_1.setText("Iniciar sesion");
	    sendButton_1.setStyleName("sendButton");
	    sendButton_1.addClickHandler(handler);
	    sendButton_1.setSize("341px", "44px");
	    rootPanel.add(pass, 545, 226);
	    pass.addFocusHandler(new FocusHandler() {
	    	public void onFocus(FocusEvent event) {
	    		if (pass.getText().equals("password"))
	    		{
	    			pass.setText("");
	    		}
	    	}
	    });
	    pass.addBlurHandler(new BlurHandler() {
	    	public void onBlur(BlurEvent event) {
	    		if (pass.getText().equals(""))
	    		{
	    			pass.setText("password");
	    		}
	    	}
	    });
	    
	    	    pass.setText("password");
	    	    pass.setSize("321px", "36px");
	    	    rootPanel.add(user, 545, 161);
	    	    user.addBlurHandler(new BlurHandler() {
	    	    	public void onBlur(BlurEvent event) {

	    	    		if (user.getText().equals(""))
	    	    		{
	    	    			user.setText("Usuario");
	    	    		}
	    	    	}
	    	    });
	    	    user.addFocusHandler(new FocusHandler() {
	    	    	public void onFocus(FocusEvent event) {
	    	    		if (user.getText().equals("Usuario"))
	    	    		{
	    	    			user.setText("");
	    	    		}
	    	    				
	    	    	}
	    	    });
	    	    user.setText("Usuario");
	    	    user.setSize("321px", "36px");
	    	    
	    	    Image image = new Image("images/mailicon.png");
	    	    rootPanel.add(image, 522, 175);
	    	    image.setSize("16px", "10px");
	    	    
	    	    Image image_1 = new Image("images/passicon.png");
	    	    rootPanel.add(image_1, 522, 236);
	    	    image_1.setSize("9px", "17px");
	    //RootPanel.get().add(dialogBox);
	    

	}
}
