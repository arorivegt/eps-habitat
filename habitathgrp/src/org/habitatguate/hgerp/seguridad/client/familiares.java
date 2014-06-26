package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class familiares extends Composite  {

    private FlexTable flextable;
	private VerticalPanel panel = new VerticalPanel();
	private Button btnAgregarHermanoa;
	private Grid grid;
	
    public familiares() {

        initWidget(panel);
        panel.setSize("761px", "381px");
        flextable = new FlexTable();
        panel.add(flextable);
        //se agrega padre, madre, conyugue
		agregarFormulario("padre");
		agregarFormulario("madre");
		agregarFormulario("conyugue");
        
        grid = new Grid(1, 3);
        panel.add(grid);
        Button btnAgregar_pariente = new Button("Agregar hijo(a)");
        grid.setWidget(0, 0, btnAgregar_pariente);
        
        btnAgregar_pariente.setStyleName("gwt-PasswordTextBox");
        btnAgregar_pariente.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario("hijo(a)");
        	}
        });
        
        btnAgregar_pariente.setWidth("246px");
        
        btnAgregarHermanoa = new Button("Agregar hermano(a)");
        grid.setWidget(0, 2, btnAgregarHermanoa);
        btnAgregarHermanoa.setStyleName("gwt-PasswordTextBox");
        btnAgregarHermanoa.setWidth("246px");
        btnAgregarHermanoa.setStyleName("gwt-PasswordTextBox");
        btnAgregarHermanoa.addClickHandler(new ClickHandler() {
        	public void onClick(ClickEvent event) {
        		agregarFormulario("hermano(a)");
        	}
        });
	}
    
    private void agregarFormulario(String pariente){
        flextable.setWidget(flextable.getRowCount(), 0, new formulario_familia(pariente,this));  	
    }
    public void EliminarFormulario(formulario_familia fa){
        flextable.remove(fa);
    }
}
