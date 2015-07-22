package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReporteCuentasPorPagar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;



 
/**
 * MyPaginationDataGrid extends  para agregar columnas dentro del grid para implementación del  metodo initTableColumns()
 */
public class MyPaginationDataGrid_ReporteCuentaPorPagar<T> extends PagingDataGrid_ReporteCuentaPorPagar<T>{
    static Integer actual;
    static Integer cantProduct;
    static List<AuxProveedor> namesProveedor;
    static boolean showplani = false;
    int contador = 0;
    int contadorInterno = -1;
    
    public MyPaginationDataGrid_ReporteCuentaPorPagar(List<T> dataList) {
		super(dataList);
		
		// TODO Auto-generated constructor stub
	}


	private final SqlServiceAsync loginService = GWT.create(SqlService.class); 
    @Override
    public void initTableColumns(final DataGrid<T> dataGrid,
            ListHandler<T> sortHandler) {

       
    	Column<T, String> nomParamColumn = new Column<T, String>(
                new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxReporteCuentasPorPagar) object).getAuxSolucion().getIdSolucion());
            }
        };
        dataGrid.addColumn(nomParamColumn, "Solución");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
    	
    	
        for(int x =0; x < cantProduct;x++){
        	contador = x;
            Column<T, String> columnProduct= new Column<T, String>(new TextCell()) {
                @Override
                public String getValue(T object) {
                	//este hay que modificarlo
                	contadorInterno ++;
                	if (contadorInterno == cantProduct){
                		contadorInterno = 0;
                	}
                	System.out.println("el valor de contador es " +contadorInterno +" y su resultado es "+((AuxReporteCuentasPorPagar) object).getListaProveedores().get(contadorInterno).getTotalCuentaPorPagar());
                    return String.valueOf(((AuxReporteCuentasPorPagar) object).getListaProveedores().get(contadorInterno).getTotalCuentaPorPagar());
                }
            };
            System.out.println("Nombre Column:"+namesProveedor.get(contador).getNomProveedor());
            dataGrid.addColumn(columnProduct,"Cantidad a: " + namesProveedor.get(contador).getNomProveedor());
            dataGrid.setColumnWidth(columnProduct, 20, Unit.PCT);
            
        }
        

       
        
        
        
    }
    


 
}
