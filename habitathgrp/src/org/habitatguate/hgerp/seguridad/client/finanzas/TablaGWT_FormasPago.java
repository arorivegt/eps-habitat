package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCuentaBancariaProv;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_FormasPago extends Composite implements EntryPoint {
	
	MyPaginationDataGrid_FormasPago<AuxCuentaBancariaProv> grid;
 
	public TablaGWT_FormasPago(){

        grid = null;
	}
	public TablaGWT_FormasPago(List<AuxCuentaBancariaProv> datagridParametro){
        grid = new MyPaginationDataGrid_FormasPago<AuxCuentaBancariaProv>();
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
