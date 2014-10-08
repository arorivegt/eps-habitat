package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_PlantillaSolucion extends Composite implements EntryPoint {
	
	public MyPaginationDataGrid_PlantillaSolucion<AuxDetallePlantillaSolucion> grid;
 
	public TablaGWT_PlantillaSolucion(){

        grid = null;
	}
	public TablaGWT_PlantillaSolucion(List<AuxDetallePlantillaSolucion> datagridParametro){
        grid = new MyPaginationDataGrid_PlantillaSolucion<AuxDetallePlantillaSolucion>();
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
