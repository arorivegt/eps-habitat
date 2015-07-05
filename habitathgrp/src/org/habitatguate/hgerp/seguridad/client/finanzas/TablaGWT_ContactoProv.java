package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxContactoProv;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_ContactoProv extends Composite implements EntryPoint {
	
	MyPaginationDataGrid_ContactoProv<AuxContactoProv> grid;
 
	public TablaGWT_ContactoProv(){

        grid = null;
	}
	public TablaGWT_ContactoProv(List<AuxContactoProv> datagridParametro){
        grid = new MyPaginationDataGrid_ContactoProv<AuxContactoProv>();
        grid.setHeight("150px");
        grid.setDataList(datagridParametro);
        initWidget(grid);
	}

	
    public void onModuleLoad() {

        RootPanel.get("Tabla").add(this);
    }
    
    public void ActulizarList(List datagrid){
    	grid.ActualizarList();
    	grid.setDataList(datagrid);
    }
}
