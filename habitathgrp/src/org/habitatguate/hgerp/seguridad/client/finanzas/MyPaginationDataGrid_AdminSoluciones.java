package org.habitatguate.hgerp.seguridad.client.finanzas;



import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
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
public class MyPaginationDataGrid_AdminSoluciones<T> extends PagingDataGrid_AdminSoluciones<T>{
     
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
                return String.valueOf(((AuxSolucion) object).getIdSolucion());
            }
        };
        dataGrid.addColumn(codContableColumn, "Codigo Solucion");
        dataGrid.setColumnWidth(codContableColumn, 20, Unit.PCT); 
        
        
        Column<T, String> nomParamColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxSolucion) object).getDisenio();
            }
        };

        dataGrid.addColumn(nomParamColumn, "Tipo Solucion");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        /*firstNameColumn.setSortable(true);
        sortHandler.setComparator(firstNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getFirstName().compareTo(
                        ((ContactInfo) o2).getFirstName());
            }
        });*/
 
        
 
        // Codigo Uno.
        Column<T, String> codUnoColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getBeneficiario().getNomBeneficiario());
            }
        };

        dataGrid.addColumn(codUnoColumn, "Beneficiario");
        dataGrid.setColumnWidth(codUnoColumn, 20, Unit.PCT);
        
        Column<T, String> codDosColumn2 = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getAnio());
            }
        };
        dataGrid.addColumn(codDosColumn2, "Año");
        dataGrid.setColumnWidth(codDosColumn2, 20, Unit.PCT);
        
        Column<T, String> codDosColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getTrimestre());
            }
        };
        dataGrid.addColumn(codDosColumn, "Trimestre");
        dataGrid.setColumnWidth(codDosColumn, 20, Unit.PCT);
        
        Column<T, String> depAfiliado = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getValorContrato());
            }
        };
        dataGrid.addColumn(depAfiliado, "Monto Autorizado");
        dataGrid.setColumnWidth(depAfiliado, 20, Unit.PCT);
        
       
        
    }
    
 
}
