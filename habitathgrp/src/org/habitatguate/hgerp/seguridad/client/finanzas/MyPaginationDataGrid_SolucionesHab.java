package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;

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
public class MyPaginationDataGrid_SolucionesHab<T> extends PagingDataGrid_SolucionesHab<T>{
    static Integer actual;
    static Integer cantProduct;
    static List<String> namesColumns;
    static boolean showplani = false;
    int contador = 0;
    int contadorInterno = -1;
    int contadorInterno2 = 0;
    int contadorInterno3 = 0;
    int contadorInterno4 = 0;
    Header<String>[] headers; 
    
    public MyPaginationDataGrid_SolucionesHab(List<T> dataList) {
		super(dataList);
		
		// TODO Auto-generated constructor stub
	}


	private final SqlServiceAsync loginService = GWT.create(SqlService.class); 
    @Override
    public void initTableColumns(final DataGrid<T> dataGrid,
            ListHandler<T> sortHandler) {

        
    	System.out.println("Tamaño de la pagina "+dataGrid.getPageSize());
    	
    	Column<T, Boolean> checkColumn =
                new Column<T, Boolean>(new CheckboxCell(true, false)) {
                  @Override
                  public Boolean getValue(T object) {
                    // obtiene el valor del select model
                    return selectionModel.isSelected(object);
                  }
                };
        dataGrid.addColumn(checkColumn,"Selección");
        dataGrid.setColumnWidth(checkColumn, 70, Unit.PX);
        
        Header<String> cantidadTotal = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
              
              if (items.size() == 0) {
                return "";
              } else {
                double totalAge = items.size();
                             
                return "Tot:" + totalAge;
              }
            }
          };
    	
    	Column<T, String> codContableColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(++actual);
            }
        };
        dataGrid.addColumn(codContableColumn, new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Correlativo")), cantidadTotal);
        dataGrid.setColumnWidth(codContableColumn, 20, Unit.PCT); 
        
        
        Column<T, String> nomParamColumn = new Column<T, String>(
                new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getIdSolucion());
            }
        };
        dataGrid.addColumn(nomParamColumn, "Num. Solucion");        
        dataGrid.setColumnWidth(nomParamColumn, 20, Unit.PCT);
        
        
        Column<T, String> nombreBene = new Column<T, String>(
                new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getBeneficiario().getNomBeneficiario());
            }
        };
        dataGrid.addColumn(nombreBene, "Beneficiario");        
        dataGrid.setColumnWidth(nombreBene, 20, Unit.PCT);
        /*firstNameColumn.setSortable(true);
        sortHandler.setComparator(firstNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getFirstName().compareTo(
                        ((ContactInfo) o2).getFirstName());
            }
        });*/
 
        
 
        // Codigo Uno.
        Column<T, String> codUnoColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getDisenio());
            }
        };
 
        /*lastNameColumn.setSortable(true);
        sortHandler.setComparator(lastNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getLastName().compareTo(
                        ((ContactInfo) o2).getLastName());
            }
        });*/
        dataGrid.addColumn(codUnoColumn, "Diseño");
        dataGrid.setColumnWidth(codUnoColumn, 20, Unit.PCT);
        
        Column<T, String> codDosColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getBeneficiario().getDirBeneficiario());
            }
        };
        dataGrid.addColumn(codDosColumn, "Direccion");
        dataGrid.setColumnWidth(codDosColumn, 20, Unit.PCT);
        
        Column<T, String> codDep = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getDepartamentoSolucion());
            }
        };
        dataGrid.addColumn(codDep, "Departamento");
        dataGrid.setColumnWidth(codDep, 20, Unit.PCT);
        
        Column<T, String> codMun = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getMunicipioSolucion());
            }
        };
        dataGrid.addColumn(codMun, "Municipio");
        dataGrid.setColumnWidth(codMun, 20, Unit.PCT);
        
        Column<T, String> depAfiliado = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getBeneficiario().getTelBeneficiario());
            }
        };
        dataGrid.addColumn(depAfiliado, "Telefono");
        dataGrid.setColumnWidth(depAfiliado, 20, Unit.PCT);
        
        Column<T, String> costoMaterial = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoMaterial());
            }
        };

          
       
        Header<String> costoTotalHeader = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
              
              if (items.size() == 0) {
                return "";
              } else {
                double totalAge = 0.0;
                
                for (AuxSolucion item : items) {  	
                  totalAge += item.getCostoTotal();
                }
                
                return "Total: " + totalAge;
              }
            }
          };
        
        Column<T, String> costoTotal = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoTotal());
            }
        };
        dataGrid.addColumn(costoTotal,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Costo Total ")), costoTotalHeader);
        dataGrid.setColumnWidth(costoTotal, 20, Unit.PCT);
        
        
        Header<String> costoTotalHeader2 = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
              
              if (items.size() == 0) {
                return "";
              } else {
                double totalAge = 0.0;
                
                for (AuxSolucion item : items) {  	
                  totalAge += item.getCostoTotal();
                }
                
                return "Avg: " + totalAge/items.size();
              }
            }
          };
        
        Column<T, String> costoTotal2 = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoTotal());
            }
        };
        dataGrid.addColumn(costoTotal2,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Costo Total ")), costoTotalHeader2);
        dataGrid.setColumnWidth(costoTotal2, 20, Unit.PCT);
        
       
        

       
        
        
        
    }
    


 
}
