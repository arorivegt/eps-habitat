package org.habitatguate.hgerp.seguridad.client.finanzas;



import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;

import sun.print.resources.serviceui;

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
 * MyPaginationDataGrid extends PagingDataGrid to add Columns into Grid by implementation of 
 * initTableColumns() method
 */
public class MyPaginationDataGrid<T> extends PagingDataGrid<T>{
     
    // Add a selection model so we can select cells.
    private final SqlServiceAsync loginService = GWT.create(SqlService.class); 
    @Override
    public void initTableColumns(DataGrid<T> dataGrid,
            ListHandler<T> sortHandler) {
        Column<T, Boolean> checkColumn =
                new Column<T, Boolean>(new CheckboxCell(true, false)) {
                  @Override
                  public Boolean getValue(T object) {
                    // Get the value from the selection model.
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
				// TODO Auto-generated method stub
				((AuxParametro) object).setNomParametro(value);
				
			}
        	});
        dataGrid.addColumn(nomParamColumn, "Nombre Parametro");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        /*firstNameColumn.setSortable(true);
        sortHandler.setComparator(firstNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getFirstName().compareTo(
                        ((ContactInfo) o2).getFirstName());
            }
        });*/
 
        
 
        // Last name.
        Column<T, String> codUnoColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxParametro) object).getCodUno());
            }
        };
        /*lastNameColumn.setSortable(true);
        sortHandler.setComparator(lastNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getLastName().compareTo(
                        ((ContactInfo) o2).getLastName());
            }
        });*/
        dataGrid.addColumn(codUnoColumn, "Codigo Uno");
        dataGrid.setColumnWidth(codUnoColumn, 20, Unit.PCT);
        
        Column<T, String> codDosColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxParametro) object).getCodDos());
            }
        };
        dataGrid.addColumn(codDosColumn, "Codigo Dos");
        dataGrid.setColumnWidth(codDosColumn, 20, Unit.PCT);
        
        // ButtonCell.
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
