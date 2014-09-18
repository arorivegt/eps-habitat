package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.Comparator;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;






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
public class MyPaginationDataGrid<T> extends PagingDataGrid<T>{
     
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
                return String.valueOf(((AuxParametro) object).getCodContable());
            }
        };
        dataGrid.addColumn(codContableColumn, "Codigo Contable");
        dataGrid.setColumnWidth(codContableColumn, 20, Unit.PCT); 
        
        
        Column<T, String> nomParamColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxParametro) object).getNomParametro();
            }
        };
        nomParamColumn.setFieldUpdater(new FieldUpdater<T, String>() {
			@Override
			public void update(int index, T object, String value) {
				
				((AuxParametro) object).setNomParametro(value);
				
			}
        	});
        dataGrid.addColumn(nomParamColumn, "Nombre Parametro");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        nomParamColumn.setSortable(true);
        sortHandler.setComparator(nomParamColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((AuxParametro) o1).getNomParametro().compareTo(
                        ((AuxParametro) o2).getNomParametro());
            }
        });

        
 
        // Codigo Uno.
        Column<T, String> codUnoColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxParametro) object).getCodUno());
            }
        };
        dataGrid.addColumn(codUnoColumn, "Codigo Uno");
        dataGrid.setColumnWidth(codUnoColumn, 20, Unit.PCT);
        codUnoColumn.setSortable(true);
        sortHandler.setComparator(codUnoColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
            	if (((AuxParametro) o1).getCodUno()==((AuxParametro) o2).getCodUno())
            		return 0;
            	else
            		return 1;
            }
        });
        
        Column<T, String> codDosColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxParametro) object).getCodDos());
            }
        };
        dataGrid.addColumn(codDosColumn, "Codigo Dos");
        dataGrid.setColumnWidth(codDosColumn, 20, Unit.PCT);
        
        // ActionCell.
        ActionCell<T> reListCell = new ActionCell<T>("Modificar",
        	    new ActionCell.Delegate<T>() {
        	        @Override
        	        public void execute(final T object) {
        	           // code to be executed 
        	        	loginService.Actualizar_Parametro(((AuxParametro)object).getIdParametro(), ((AuxParametro)object).getNomParametro(), ((AuxParametro)object).getCodContable(), ((AuxParametro)object).getCodUno(), ((AuxParametro)object).getCodDos(), new AsyncCallback<Long>() {
            				
            				@Override
            				public void onSuccess(Long result) {
                	        	Window.alert("Modificado: "+ ((AuxParametro)object).getNomParametro());
            				}
            				
            				@Override
            				public void onFailure(Throwable caught) {
            					System.out.println(caught);
            					
            				}
            			});

        	        }
        	     }) 
        	 {
        	 };

        	 Column<T, T> reListColumn = new Column<T, T>(reListCell) {
        	      @Override
        	      public T getValue(T object) {
        	        return object;
        	      }
        	 };

        	 dataGrid.addColumn(reListColumn,"Boton");
        	 dataGrid.setColumnWidth(reListColumn, 20, Unit.PCT); 
        
    }
    
 
}
