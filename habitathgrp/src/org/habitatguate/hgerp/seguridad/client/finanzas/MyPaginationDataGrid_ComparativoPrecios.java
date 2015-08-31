package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.Comparator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;






import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;

import com.google.gwt.i18n.client.DateTimeFormat; 
import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SafeHtmlHeader;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;



 
/**
 * MyPaginationDataGrid extends  para agregar columnas dentro del grid para implementación del  metodo initTableColumns()
 */
public class MyPaginationDataGrid_ComparativoPrecios<T> extends PagingDataGrid_ComparativoPrecios<T>{
     
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
 
        Column<T, String> codContableColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxMaterialCostruccion) object).getIdMaterialConstruccion());
            }
        };
        dataGrid.addColumn(codContableColumn, "Codigo Material");
        dataGrid.setColumnWidth(codContableColumn, 20, Unit.PCT); 
        
        
        Column<T, String> nomParamColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxMaterialCostruccion) object).getNomMaterialCostruccion();
            }
        };

        dataGrid.addColumn(nomParamColumn, "Nombre Material");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        nomParamColumn.setSortable(true);
        
        Column<T, String> provColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxMaterialCostruccion) object).getProveedor().getNomProveedor();
            }
        };

        dataGrid.addColumn(provColumn, "Proveedor");        
        dataGrid.setColumnWidth(provColumn, 20, Unit.PCT);
        nomParamColumn.setSortable(true);

        Column<T, String> afiColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxMaterialCostruccion) object).getProveedor().getAuxAfiliado().getNomAfiliado();
            }
        };

        dataGrid.addColumn(afiColumn, "Afiliado");        
        dataGrid.setColumnWidth(afiColumn, 20, Unit.PCT);
        nomParamColumn.setSortable(true);
        
        Header<String> totalAPagar = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxMaterialCostruccion> items = (List<AuxMaterialCostruccion>) dataGrid.getVisibleItems();
              
              if (items.size() == 0) {
                return "";
              } else {
            	  double totalAge = 0.0;
            	  int totalCantidad = 0;
                  
                  for (AuxMaterialCostruccion item : items) {  	
                    totalAge += item.getPrecioUnit();
                    totalCantidad += item.getCantidadMaterial();
                  }
                             
                return "AVG: " + totalAge/totalCantidad;
              }
            }
          };
        
 
        // Precio Unitario.
        Column<T, String> codUnoColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxMaterialCostruccion) object).getPrecioUnit()/((AuxMaterialCostruccion) object).getCantidadMaterial() );
            }
        };
        dataGrid.addColumn(codUnoColumn, new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Precio Unitario (Q)")), totalAPagar);
        dataGrid.setColumnWidth(codUnoColumn, 20, Unit.PCT);

        
        //Unidad Metrica
        Column<T, String> unidadMetrica = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxMaterialCostruccion) object).getUnidadMetrica());
            }
        };
        dataGrid.addColumn(unidadMetrica, "Unidad de Medida");
        dataGrid.setColumnWidth(unidadMetrica, 20, Unit.PCT);

        

        
       
        	 
        
    }
    
 
}
