package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;



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
public class MyPaginationDataGrid_SolucionGeneral<T> extends PagingDataGrid_SolucionGeneral<T>{
    static Integer actual;
    static Integer cantProduct;
    static List<String> namesColumns;
    static boolean showplani = false;
    int contador = 0;
    int contadorInterno = -1;
    
    public MyPaginationDataGrid_SolucionGeneral(List<T> dataList) {
		super(dataList);
		
		// TODO Auto-generated constructor stub
	}


	private final SqlServiceAsync loginService = GWT.create(SqlService.class); 
    @Override
    public void initTableColumns(final DataGrid<T> dataGrid,
            ListHandler<T> sortHandler) {

        Column<T, String> codContableColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(++actual);
            }
        };
        dataGrid.addColumn(codContableColumn, "Correlativo");
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
        
        for(int x =0; x < cantProduct;x++){
        	contador = x;
            Column<T, String> columnProduct= new Column<T, String>(new TextCell()) {
                @Override
                public String getValue(T object) {
                	//este hay que modificarlo
                	contadorInterno ++;
                	if (contadorInterno == cantProduct){
                		contadorInterno = 0;
                	}
                	System.out.println("el valor de contador es " +contadorInterno +" y su resultado es "+((AuxSolucion) object).getCostoProducto().get(contadorInterno));
                    return String.valueOf(((AuxSolucion) object).getCostoProducto().get(contadorInterno));
                }
            };
            System.out.println("Nombre Column:"+namesColumns.get(contador));
            dataGrid.addColumn(columnProduct,namesColumns.get(contador));
            dataGrid.setColumnWidth(columnProduct, 20, Unit.PCT);
            
            if (showplani){
            	Column<T, String> columnProductPlani= new Column<T, String>(new TextCell()) {
                    @Override
                    public String getValue(T object) {
                    	//este hay que modificarlo
                    	return String.valueOf(((AuxSolucion) object).getCostoProductoPlani().get(contadorInterno));
                    }
                };
                System.out.println("Nombre Column:"+namesColumns.get(contador));
                dataGrid.addColumn(columnProductPlani,"Planificado " +namesColumns.get(contador));
                dataGrid.setColumnWidth(columnProductPlani, 20, Unit.PCT);
            }
        }
        
        /*dataGrid.addColumn(costoMaterial, "Costo Material");
        dataGrid.setColumnWidth(costoMaterial, 20, Unit.PCT);
        
        Column<T, String> costoManoObra = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
            	//Este hay que modificarlo
                return String.valueOf(((AuxSolucion) object).getCostoMaterial());
            }
        };
        dataGrid.addColumn(costoManoObra, "Mano de Obra");
        dataGrid.setColumnWidth(costoManoObra, 20, Unit.PCT);
        
        Column<T, String> fletes = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
            	//Este tambien
                return String.valueOf(((AuxSolucion) object).getCostoMaterial());
            }
        };
        dataGrid.addColumn(fletes, "Fletes");
        dataGrid.setColumnWidth(fletes, 20, Unit.PCT);
        
        Column<T, String> costoDirecto = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoDirecto());
            }
        };
        dataGrid.addColumn(costoDirecto, "Costo Directo");
        dataGrid.setColumnWidth(costoDirecto, 20, Unit.PCT);
        
                
        Column<T, String> costoAdmin = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoAdministrativo());
            }
        };
        dataGrid.addColumn(costoAdmin, "Costo Admin.");
        dataGrid.setColumnWidth(costoAdmin, 20, Unit.PCT);
        
        */
        
        Column<T, String> costoTotal = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoTotal());
            }
        };
        dataGrid.addColumn(costoTotal, "Costo Total");
        dataGrid.setColumnWidth(costoTotal, 20, Unit.PCT);
        
        Column<T, String> valorContrato= new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getValorContrato());
            }
        };
        dataGrid.addColumn(valorContrato, "Valor Contrato");
        dataGrid.setColumnWidth(valorContrato, 20, Unit.PCT);
        
       Column<T, String> notaDeb= new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoTotal()-((AuxSolucion) object).getCostoMaterial());
            }
        };
        dataGrid.addColumn(notaDeb, "Nota Debito / Nota Credito");
        dataGrid.setColumnWidth(notaDeb, 20, Unit.PCT);
        
        
        Column<T, String> cuentaXPagar= new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
            	//este hay que modificarlo
                return String.valueOf(((AuxSolucion) object).getCostoTotal());
            }
        };
        dataGrid.addColumn(cuentaXPagar, "Cuentas por Pagar");
        dataGrid.setColumnWidth(cuentaXPagar, 20, Unit.PCT);        
       
        
        
        
    }
    


 
}
