package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.Comparator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;






import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SafeHtmlHeader;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;



 
/**
 * MyPaginationDataGrid extends  para agregar columnas dentro del grid para implementación del  metodo initTableColumns()
 */
public class MyPaginationDataGrid_ListaVale<T> extends PagingDataGrid_ListaVale<T>{
     
    private final SqlServiceAsync loginService = GWT.create(SqlService.class); 
    @Override
    public void initTableColumns(final DataGrid<T> dataGrid,
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
                return String.valueOf(((AuxVale) object).getIdVale());
            }
        };
        dataGrid.addColumn(nomMaterial, "Id Vale");
        dataGrid.setColumnWidth(nomMaterial, 20, Unit.PCT); 
        
        
        Column<T, String> unidadMetrica = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxVale) object).getTotalVale());
            }
        };

        dataGrid.addColumn(unidadMetrica, "Total Vale");        
        dataGrid.setColumnWidth(unidadMetrica, 20, Unit.PCT);
       
 
        // Codigo Uno.
        Column<T, String> cantidad = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxVale) object).getFechaVale());
            }
        };
        dataGrid.addColumn(cantidad, "Fecha Vale");
        dataGrid.setColumnWidth(cantidad, 20, Unit.PCT);
        
        
        Column<T, String> precioUnitario = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxVale) object).getTotalPagado());
            }
        };
        dataGrid.addColumn(precioUnitario, "Total Cancelado");
        dataGrid.setColumnWidth(precioUnitario, 20, Unit.PCT);
        
        Column<T, String> columna5 = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
            	double diferencia = ((AuxVale) object).getTotalVale()-((AuxVale) object).getTotalPagado();
                return String.valueOf(diferencia);
            }
        };
        
        Header<String> sumatoria = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxVale> items = (List<AuxVale>) dataGrid.getVisibleItems();
              if (items.size() == 0) {
                return "";
              } else {
                double totalAge = 0.0;
                for (AuxVale item : items) {
                  totalAge += item.getTotalVale()-item.getTotalPagado();
                }
                return "Total Saldo: " + totalAge;
              }
            }
          };
          
        dataGrid.addColumn(columna5,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Saldo")), sumatoria);
        dataGrid.setColumnWidth(precioUnitario, 20, Unit.PCT);
               
    }
    
 
}
