package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_SolucionesHab extends Composite implements EntryPoint {
	
	MyPaginationDataGrid_SolucionesHab<AuxSolucion> grid;
 
	public TablaGWT_SolucionesHab(){

        grid = null;
	}
	public TablaGWT_SolucionesHab(List<AuxSolucion> datagridParametro){
        grid = new MyPaginationDataGrid_SolucionesHab<AuxSolucion>(datagridParametro);
        grid.setHeight("500px");
        //grid.setDataList(datagridParametro);
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
