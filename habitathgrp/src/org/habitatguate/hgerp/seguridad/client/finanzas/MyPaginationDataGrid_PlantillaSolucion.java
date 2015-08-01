package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.Comparator;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;






import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
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
public class MyPaginationDataGrid_PlantillaSolucion<T> extends PagingDataGrid_PlantillaSolucion<T>{
     
    private final SqlServiceAsync loginService = GWT.create(SqlService.class); 
    @Override
    public void initTableColumns(DataGrid<T> dataGrid,
            ListHandler<T> sortHandler) {
        Column<T, Boolean> checkColumn =
                new Column<T, Boolean>(new CheckboxCell(true, false)) {
                  @Override
                  public Boolean getValue(T object) {
                    // obtiene el valor del select model
                    return selectionModel.isSelected(object);
                  }
                };
        dataGrid.addColumn(checkColumn,"Select");
        dataGrid.setColumnWidth(checkColumn, 70, Unit.PX);
 
        Column<T, String> nomMaterial = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxDetallePlantillaSolucion) object).getNomMaterialCostruccion());
            }
        };
        dataGrid.addColumn(nomMaterial, "Nombre Material");
        dataGrid.setColumnWidth(nomMaterial, 20, Unit.PCT); 
        
        
        Column<T, String> unidadMetrica = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxDetallePlantillaSolucion) object).getUnidadMetrica();
            }
        };

        dataGrid.addColumn(unidadMetrica, "Unidad de Medida");        
        dataGrid.setColumnWidth(unidadMetrica, 20, Unit.PCT);
       
 
        // Codigo Uno.
        Column<T, String> cantidad = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxDetallePlantillaSolucion) object).getCantidad());
            }
        };
        dataGrid.addColumn(cantidad, "Cantidad");
        dataGrid.setColumnWidth(cantidad, 20, Unit.PCT);
        
        
        Column<T, String> precioUnitario = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxDetallePlantillaSolucion) object).getPrecioUnit());
            }
        };
        dataGrid.addColumn(precioUnitario, "PrecioUnitario");
        dataGrid.setColumnWidth(precioUnitario, 20, Unit.PCT);

        Column<T, String> subTotal = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxDetallePlantillaSolucion) object).getSubTotal());
            }
        };
        dataGrid.addColumn(subTotal, "SubTotal");
        dataGrid.setColumnWidth(subTotal, 20, Unit.PCT);
        
        Column<T, String> costoAcumulado = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxDetallePlantillaSolucion) object).getCostoAcumulado());
            }
        };
        dataGrid.addColumn(costoAcumulado, "Costo Acumulado");
        dataGrid.setColumnWidth(costoAcumulado, 20, Unit.PCT);
               
    }
    
 
}
