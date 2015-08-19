package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_ReporteCuentasAPagar extends Composite implements EntryPoint {
	
	public MyPaginationDataGrid_ReporteCuentasAPagar<AuxValeBeneficiario> grid;
 
	public TablaGWT_ReporteCuentasAPagar(){

        grid = null;
	}
	public TablaGWT_ReporteCuentasAPagar(List<AuxValeBeneficiario> datagridParametro){

        grid = new MyPaginationDataGrid_ReporteCuentasAPagar<AuxValeBeneficiario>();
        grid.setSize("1100x", "500px");
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
