package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_Afiliado extends Composite implements EntryPoint {
	
	MyPaginationDataGrid_Afiliado<AuxAfiliado> grid;
 
	public TablaGWT_Afiliado(){

        grid = null;
	}
	public TablaGWT_Afiliado(List<AuxAfiliado> datagridParametro){
        grid = new MyPaginationDataGrid_Afiliado<AuxAfiliado>();
        grid.setHeight("500px");
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
