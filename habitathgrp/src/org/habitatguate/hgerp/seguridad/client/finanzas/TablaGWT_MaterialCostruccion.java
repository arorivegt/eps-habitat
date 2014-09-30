package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_MaterialCostruccion extends Composite implements EntryPoint {
	
	MyPaginationDataGrid_MaterialConstruccion<AuxMaterialCostruccion> grid;
 
	public TablaGWT_MaterialCostruccion(){

        grid = null;
	}
	public TablaGWT_MaterialCostruccion(List<AuxMaterialCostruccion> datagridParametro){
        grid = new MyPaginationDataGrid_MaterialConstruccion<AuxMaterialCostruccion>();
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
