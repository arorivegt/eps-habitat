package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.finanzas.MyPaginationDataGrid;;
public class TablaGWT_Beneficiario extends Composite implements EntryPoint {
	
	MyPaginationDataGrid_Beneficiario<AuxBeneficiario> grid;
 
	public TablaGWT_Beneficiario(){

        grid = null;
	}
	public TablaGWT_Beneficiario(List<AuxBeneficiario> datagridParametro){
        grid = new MyPaginationDataGrid_Beneficiario<AuxBeneficiario>();
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
