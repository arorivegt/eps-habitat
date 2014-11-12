package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.Comparator;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;






import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;

import com.google.gwt.i18n.client.DateTimeFormat; 
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
public class MyPaginationDataGrid_Proveedor<T> extends PagingDataGrid_Proveedor<T>{
     
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
        dataGrid.addColumn(checkColumn,"Aprobar");
        dataGrid.setColumnWidth(checkColumn, 70, Unit.PX);
 
        Column<T, String> codContableColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxProveedor) object).getIdProveedor());
            }
        };
        dataGrid.addColumn(codContableColumn, "Codigo Proveedor");
        dataGrid.setColumnWidth(codContableColumn, 20, Unit.PCT); 
        
        
        Column<T, String> nomParamColumn = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return ((AuxProveedor) object).getNomProveedor();
            }
        };
        nomParamColumn.setFieldUpdater(new FieldUpdater<T, String>() {
			@Override
			public void update(int index, T object, String value) {
				
				((AuxProveedor) object).setNomProveedor(value);
				
			}
        	});
        dataGrid.addColumn(nomParamColumn, "Nombre Proveedor");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        nomParamColumn.setSortable(true);
  /*      sortHandler.setComparator(nomParamColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((AuxProveedor) o1).getNomMaterialCostruccion().compareTo(
                        ((AuxProveedor) o2).getNomMaterialCostruccion());
            }
        });*/

        
 
        // Precio Unitario.
        Column<T, String> codUnoColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxProveedor) object).getDirProveedor());
            }
        };
        dataGrid.addColumn(codUnoColumn, "Direccion Proveedor");
        dataGrid.setColumnWidth(codUnoColumn, 20, Unit.PCT);
        codUnoColumn.setSortable(true);
     /*   sortHandler.setComparator(codUnoColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((AuxProveedor) o1).getUnidadMetrica().compareTo(
                        ((AuxProveedor) o2).getUnidadMetrica());
            }
        });*/
        
        //Unidad Metrica
        Column<T, String> unidadMetrica = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxProveedor) object).getTelProveedor());
            }
        };
        dataGrid.addColumn(unidadMetrica, "Telefono");
        dataGrid.setColumnWidth(unidadMetrica, 20, Unit.PCT);
        unidadMetrica.setSortable(true);
     /*   sortHandler.setComparator(unidadMetrica, new Comparator<T>() {
            public int compare(T o1, T o2) {
            	if (((AuxProveedor) o1).getPrecioUnit()==((AuxProveedor) o2).getPrecioUnit())
            		return 0;
            	else
            		return 1;
            }
        });*/
        
        Column<T, String> codDosColumn = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
            	//DateTimeFormat fmt = DateTimeFormat.getFormat("dd-MM-yyyy");
                return String.valueOf(((AuxProveedor) object).getNumeroNit());
            }
        };
        dataGrid.addColumn(codDosColumn, "Nit");
        dataGrid.setColumnWidth(codDosColumn, 20, Unit.PCT);
        
        // ActionCell.
        ActionCell<T> reListCell = new ActionCell<T>("Modificar",
        	    new ActionCell.Delegate<T>() {
        	        @Override
        	        public void execute(final T object) {
        	        	AuxProveedor aux  = (AuxProveedor)object;
        	        	loginService.Actualizar_Proveedor(((AuxProveedor)object).getIdProveedor(), ((AuxProveedor)object).getAprobadoComision(), ((AuxProveedor)object).getDirProveedor(), ((AuxProveedor)object).getFechaIngreso().getTime(), ((AuxProveedor)object).getNomProveedor(), ((AuxProveedor)object).getNumeroNit(),((AuxProveedor)object).getObservaciones(), ((AuxProveedor)object).getPaginaWeb(), ((AuxProveedor)object).getPersonaJuridica(), ((AuxProveedor)object).getServicioEntrega(), ((AuxProveedor)object).getTelProveedor(), new AsyncCallback<Long>() {
            				
            				@Override
            				public void onSuccess(Long result) {
                	        	Window.alert("Modificado: "+ ((AuxProveedor)object).getIdProveedor());
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
