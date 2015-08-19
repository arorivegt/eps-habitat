package org.habitatguate.hgerp.seguridad.client.finanzas;



import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialPagoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;

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
public class MyPaginationDataGrid_ReportePagosProv<T> extends PagingDataGrid_ReportePagosProv<T>{
     
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
 
        Column<T, String> codContableColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxHistorialPagoProv) object).getIdHistorialPagoProv());
            }
        };
        dataGrid.addColumn(codContableColumn, "Codigo Pago");
        dataGrid.setColumnWidth(codContableColumn, 20, Unit.PCT); 
        
        
        Column<T, String> nomParamColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxHistorialPagoProv) object).getNombreProveedor();
            }
        };
        
        Column<T, String> codDosColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxHistorialPagoProv) object).getNombreAfiliado());
            }
        };
        dataGrid.addColumn(codDosColumn, "Afiliado");
        dataGrid.setColumnWidth(codDosColumn, 20, Unit.PCT);
        
        dataGrid.addColumn(nomParamColumn, "Proveedor");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        /*firstNameColumn.setSortable(true);
        sortHandler.setComparator(firstNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getFirstName().compareTo(
                        ((ContactInfo) o2).getFirstName());
            }
        });*/
 

        Column<T, String> columTipo = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxHistorialPagoProv) object).getTipoOperacion());
            }
        };

        dataGrid.addColumn(columTipo, "Tipo de Operación");
        dataGrid.setColumnWidth(columTipo, 20, Unit.PCT);

        
 
        // Codigo Uno.
        Column<T, String> codUnoColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxHistorialPagoProv) object).getFechaSolicitud());
            }
        };

        dataGrid.addColumn(codUnoColumn, "Fecha Pago");
        dataGrid.setColumnWidth(codUnoColumn, 20, Unit.PCT);
        
        
        
        Column<T, String> depAfiliado = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxHistorialPagoProv) object).getValorPago());
            }
        };
        dataGrid.addColumn(depAfiliado, "Total Cancelado");
        dataGrid.setColumnWidth(depAfiliado, 20, Unit.PCT);
        
        Column<T, String> Column7 = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxHistorialPagoProv) object).getRetenidoDonacion());
            }
        };
        dataGrid.addColumn(Column7, "Reducción de Donación");
        dataGrid.setColumnWidth(Column7, 20, Unit.PCT);
                
    }
    
 
}
