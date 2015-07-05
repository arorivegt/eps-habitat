package org.habitatguate.hgerp.seguridad.client.finanzas;



import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCatalogoProducto;

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
public class MyPaginationDataGrid_CatalogoProductos<T> extends PagingDataGrid_CatalogoProductos<T>{
     
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
                return String.valueOf(((AuxCatalogoProducto) object).getIdProducto());
            }
        };
        dataGrid.addColumn(codContableColumn, "Codigo Producto");
        dataGrid.setColumnWidth(codContableColumn, 20, Unit.PCT); 
        
        
        Column<T, String> nomParamColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxCatalogoProducto) object).getDescripcionProducto();
            }
        };
        nomParamColumn.setFieldUpdater(new FieldUpdater<T, String>() {
			@Override
			public void update(int index, T object, String value) {
				
				((AuxCatalogoProducto) object).setDescripcionProducto(value);
				
			}
        	});
        dataGrid.addColumn(nomParamColumn, "Descripción");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        /*firstNameColumn.setSortable(true);
        sortHandler.setComparator(firstNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getFirstName().compareTo(
                        ((ContactInfo) o2).getFirstName());
            }
        });*/
 
         
                
        // ActionCell.
        ActionCell<T> reListCell = new ActionCell<T>("Modificar",
        	    new ActionCell.Delegate<T>() {
        	        @Override
        	        public void execute(final T object) {
        	           // code to be executed 
        	        	loginService.Actualizar_Afiliado(((AuxAfiliado)object).getIdAfiliado(), ((AuxAfiliado)object).getNomAfiliado(), ((AuxAfiliado)object).getDirAfiliado(), ((AuxAfiliado)object).getDepartamento(), ((AuxAfiliado)object).getMunicipio(), new AsyncCallback<Long>() {
            				
            				@Override
            				public void onSuccess(Long result) {
                	        	Window.alert("Modificado: "+ ((AuxAfiliado)object).getIdAfiliado());
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
