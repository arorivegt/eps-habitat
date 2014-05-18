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
	    
	    // Create a table to layout the form options
	    FlexTable layout = new FlexTable();
	    layout.setCellSpacing(4);
	    layout.setCellPadding(4);
	    rootPanel.add(layout, 512, 90);
	    layout.setStyleName("login_css");
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
	    pass.setStyleName("gwt-TextBox");
	    	    
	    // Add some standard form options
	    	    	    
	    Label lblNewLabel = new Label("Login");
	    layout.setWidget(0, 0, lblNewLabel);
	    lblNewLabel.setSize("380", "100%");
	    	    	    
	    Image image = new Image("images/mailicon.png");
	    layout.setWidget(1, 0, image);
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
	    layout.setWidget(1, 1,user );
	    user.setSize("321px", "36px");
	    	    	    
	    Image image_1 = new Image("images/passicon.png");
	    layout.setWidget(2, 0, image_1);
	    layout.setWidget(2, 1, pass);
	    pass.setSize("321px", "36px");
	    layout.getCellFormatter().setStyleName(3, 1, "h1");
	    layout.setSize("395px", "192px");
	    layout.getCellFormatter().setVerticalAlignment(3, 1, HasVerticalAlignment.ALIGN_MIDDLE);
	    	    	    
	    final Button sendButton = new Button("Send");
	    sendButton.setText("Sign In");
	    sendButton.setStyleName("sendButton");
	    sendButton.addClickHandler(handler);
	    	    	    	    
	    layout.setWidget(3, 1, sendButton);
		sendButton.setSize("341px", "44px");
		layout.getCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		layout.getCellFormatter().setVerticalAlignment(2, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		layout.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_LEFT);
		layout.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_LEFT);
		layout.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		layout.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		layout.getFlexCellFormatter().setColSpan(0, 0, 2);
	    //RootPanel.get().add(dialogBox);
	    

	}
}
