package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.finanzas.ContactDatabase.ContactInfo;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class GWT11 extends Composite implements EntryPoint {
	

 
	public GWT11(){
        MyPaginationDataGrid<ContactInfo> grid = new MyPaginationDataGrid<ContactInfo>();
        grid.setHeight("500px");
        grid.setDataList(ContactDatabase.get().generateContacts(100));
        initWidget(grid);
	}
	public GWT11(List datagrid){
        MyPaginationDataGrid<ContactInfo> grid = new MyPaginationDataGrid<ContactInfo>();
        grid.setHeight("500px");
        grid.setDataList(datagrid);
        initWidget(grid);
	}
	
    public void onModuleLoad() {

        RootPanel.get("Tabla").add(this);
    }
}
