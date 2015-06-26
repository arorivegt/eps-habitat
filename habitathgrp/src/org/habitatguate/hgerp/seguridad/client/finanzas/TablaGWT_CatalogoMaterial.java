package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoMaterial;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_CatalogoMaterial extends Composite implements EntryPoint {
	
	MyPaginationDataGrid_CatalogoMaterial<AuxCatalogoMaterial> grid;
 
	public TablaGWT_CatalogoMaterial(){

        grid = null;
	}
	public TablaGWT_CatalogoMaterial(List<AuxCatalogoMaterial> datagridParametro){
        grid = new MyPaginationDataGrid_CatalogoMaterial<AuxCatalogoMaterial>();
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
