package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;



import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;

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
public class MyPaginationDataGrid_SolucionGeneral<T> extends PagingDataGrid_SolucionGeneral<T>{
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
    
    public MyPaginationDataGrid_SolucionGeneral(List<T> dataList) {
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
        
        Column<T, String> codDep = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getDepartamentoSolucion());
            }
        };
        dataGrid.addColumn(codDep, "Departamento");
        dataGrid.setColumnWidth(codDep, 20, Unit.PCT);
        
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

            Header<String> sumatoria = new Header<String>(new TextCell()) {
                @Override
                public String getValue() {
                	
                	contadorInterno4 ++;
                	if (contadorInterno4 == 3){
                		contadorInterno2 ++;
                		contadorInterno4 = 0;
                	}
                  List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
                  
                  if (items.size() == 0) {
                    return "";
                  } else {
                    double totalAge = 0.0;
                    
                    for (AuxSolucion item : items) {  	
                      totalAge += item.getCostoProducto().get(contadorInterno2);
                    }
                    System.out.println("i "+contadorInterno2+ " J "+contadorInterno4);
                    return ""+totalAge  ;
                 }
                }
              };
        	
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
            

            
            
           dataGrid.addColumn(columnProduct,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Ejecutado "+namesColumns.get(contador))), sumatoria);
           // dataGrid.addColumn(columnProduct, sumatoria);
            dataGrid.setColumnWidth(columnProduct, 20, Unit.PCT);
            
            if (showplani){
            	
            	Header<String> sumatoriaPlani = new Header<String>(new TextCell()) {
                    @Override
                    public String getValue() {
                      List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
                      
                      if (items.size() == 0) {
                        return "";
                      } else {
                        double totalAge = 0.0;
                        
                        for (AuxSolucion item : items) {  	
                          totalAge += item.getCostoProductoPlani().get(contadorInterno2);
                        }
                        System.out.println("nelson"+totalAge);
                        return "" + totalAge;
                      }
                    }
                  };
            	
            	Column<T, String> columnProductPlani= new Column<T, String>(new TextCell()) {
                    @Override
                    public String getValue(T object) {
                    	//este hay que modificarlo
                    	return String.valueOf(((AuxSolucion) object).getCostoProductoPlani().get(contadorInterno));
                    }
                };
                System.out.println("Nombre Column:"+namesColumns.get(contador));
                dataGrid.addColumn(columnProductPlani,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Planificado " +namesColumns.get(contador))), sumatoriaPlani);
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
        
        
        Header<String> costoDirecto = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
              
              if (items.size() == 0) {
                return "";
              } else {
                double totalAge = 0.0;
                
                for (AuxSolucion item : items) {  	
                  totalAge += item.getCostoDirecto();
                }
                
                return "" + totalAge;
              }
            }
          };
        
        Column<T, String> costodirecto = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoDirecto());
            }
        };
        dataGrid.addColumn(costodirecto,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Ejecutado Costo Directo")), costoDirecto);
        
        dataGrid.setColumnWidth(costodirecto, 20, Unit.PCT);
       
        
        
        
        if (showplani){
        	
        	Header<String> costoDirectoPlani = new Header<String>(new TextCell()) {
                @Override
                public String getValue() {
                  List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
                  
                  if (items.size() == 0) {
                    return "";
                  } else {
                    double totalAge = 0.0;
                    
                    for (AuxSolucion item : items) {  	
                      totalAge += item.getCostoDirectoPlani();
                    }
                
                    return "" + totalAge;
                  }
                }
              };
        	
        	Column<T, String> costodirectopla = new Column<T, String>(new TextCell()) {
                @Override
                public String getValue(T object) {
                    return String.valueOf(((AuxSolucion) object).getCostoDirectoPlani());
                }
            };
            dataGrid.addColumn(costodirectopla,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Planificado Costo Directo")), costoDirectoPlani);
            
            dataGrid.setColumnWidth(costodirectopla, 20, Unit.PCT);
        }
        
        Header<String> costoAdminHeader = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
              
              if (items.size() == 0) {
                return "";
              } else {
                double totalAge = 0.0;
                
                for (AuxSolucion item : items) {  	
                  totalAge += item.getCostoAdministrativo();
                }
                
                return "" + totalAge;
              }
            }
          };
        
        
        Column<T, String> costoAdmin = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoAdministrativo());
            }
        };
        dataGrid.addColumn(costoAdmin,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Costo Administrativo ")), costoAdminHeader);
        dataGrid.setColumnWidth(costoAdmin, 20, Unit.PCT);
        
        
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
                
                return "" + totalAge;
              }
            }
          };
        
        Column<T, String> costoTotal = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getCostoTotal());
            }
        };
        dataGrid.addColumn(costoTotal,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Costo Total Ejecutado")), costoTotalHeader);
        dataGrid.setColumnWidth(costoTotal, 20, Unit.PCT);
        
        if (showplani){
        	
        	Header<String> costoTotalPlaniHeader = new Header<String>(new TextCell()) {
                @Override
                public String getValue() {
                  List<AuxSolucion> items = (List<AuxSolucion>) dataGrid.getVisibleItems();
                  
                  if (items.size() == 0) {
                    return "";
                  } else {
                    double totalAge = 0.0;
                    
                    for (AuxSolucion item : items) {  	
                      totalAge += item.getCostoTotalPlani();
                    }
                    
                    return "" + totalAge;
                  }
                }
              };
        	
        	Column<T, String> costoTotalplani = new Column<T, String>(new TextCell()) {
                @Override
                public String getValue(T object) {
                    return String.valueOf(((AuxSolucion) object).getCostoTotalPlani());
                }
            };
            dataGrid.addColumn(costoTotalplani,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Costo Total Planificado")), costoTotalPlaniHeader);
            dataGrid.setColumnWidth(costoTotalplani, 20, Unit.PCT);
        }
        
        
        Column<T, String> valorContrato= new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getValorContrato());
            }
        };
        dataGrid.addColumn(valorContrato, "Monto Autorizado");
        dataGrid.setColumnWidth(valorContrato, 20, Unit.PCT);
        
       Column<T, String> notaDeb= new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxSolucion) object).getValorContrato()-((AuxSolucion) object).getCostoTotal());
            }
        };
        dataGrid.addColumn(notaDeb, "(+-) Costo Total y Monto Autorizado");
        dataGrid.setColumnWidth(notaDeb, 20, Unit.PCT);
        
        
        Column<T, String> cuentaXPagar= new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
            	//este hay que modificarlo
                return String.valueOf(((AuxSolucion) object).getCostoMaterial());
            }
        };
        dataGrid.addColumn(cuentaXPagar, "Cuentas por Pagar");
        dataGrid.setColumnWidth(cuentaXPagar, 20, Unit.PCT);        
       
        
        
        
    }
    


 
}
