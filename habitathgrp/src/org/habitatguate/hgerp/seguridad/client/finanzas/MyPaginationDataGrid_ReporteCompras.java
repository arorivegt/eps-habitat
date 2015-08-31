package org.habitatguate.hgerp.seguridad.client.finanzas;



import java.util.Comparator;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;






import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxVale;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxValeBeneficiario;

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
public class MyPaginationDataGrid_ReporteCompras<T> extends PagingDataGrid_ReporteCompras<T>{
     
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
                return String.valueOf(((AuxValeBeneficiario) object).getVale().getIdVale());
            }
        };
        dataGrid.addColumn(nomMaterial, "Id Vale");
        dataGrid.setColumnWidth(nomMaterial, 20, Unit.PCT); 

        
        Column<T, String> aprobado = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
            	String valor = ((AuxValeBeneficiario) object).getVale().getAprobado() == 1 ? "Aprobado" : "Sin Aprobar";
                return String.valueOf(valor);
            }
        };

        dataGrid.addColumn(aprobado, "Estado Vale");        
        dataGrid.setColumnWidth(aprobado, 20, Unit.PCT);

        
        Column<T, String> nomAfiliado = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxValeBeneficiario) object).getSolucion().getBeneficiario().getAfiliado().getNomAfiliado());
            }
        };

        dataGrid.addColumn(nomAfiliado, "Afiliado");        
        dataGrid.setColumnWidth(nomAfiliado, 20, Unit.PCT);

        
        Column<T, String> unidadMetrica = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxValeBeneficiario) object).getSolucion().getBeneficiario().getNomBeneficiario());
            }
        };

        dataGrid.addColumn(unidadMetrica, "Beneficiario");        
        dataGrid.setColumnWidth(unidadMetrica, 20, Unit.PCT);
        
        Column<T, String> dpi = new Column<T, String>(
                new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxValeBeneficiario) object).getSolucion().getBeneficiario().getDPI());
            }
        };

        dataGrid.addColumn(dpi, "DPI Beneficiario");        
        dataGrid.setColumnWidth(dpi, 20, Unit.PCT);
       
        Column<T, String> codDep = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
            	String nombreDep = getDepto(String.valueOf(((AuxValeBeneficiario) object).getSolucion().getDepartamentoSolucion()));
                return nombreDep;
            }
        };
        dataGrid.addColumn(codDep, "Departamento");
        dataGrid.setColumnWidth(codDep, 20, Unit.PCT);
        
        Column<T, String> codMun = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
            	String resultMun = "Sin Mun";
            	String[] numerosComoArray = Depto_Municipio(((AuxValeBeneficiario) object).getSolucion().getDepartamentoSolucion()).split(",");
            	int correlativo = Integer.parseInt(((AuxValeBeneficiario) object).getSolucion().getDepartamentoSolucion()+"01");
		        for (int i = 1; i < numerosComoArray.length; i++) {
		        	if (((AuxValeBeneficiario) object).getSolucion().getMunicipioSolucion().equals(String.valueOf(correlativo))){
		        		resultMun = numerosComoArray[i];
		        	}
		        	correlativo++;
		        }
                return resultMun;
            }
        };
        dataGrid.addColumn(codMun, "Municipio");
        dataGrid.setColumnWidth(codMun, 20, Unit.PCT);
        
        
        // Codigo Uno.
        Column<T, String> cantidad = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxValeBeneficiario) object).getVale().getFechaVale());
            }
        };
        dataGrid.addColumn(cantidad, "Fecha Vale");
        dataGrid.setColumnWidth(cantidad, 20, Unit.PCT);
        
        
        Header<String> sumatoria = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
              List<AuxValeBeneficiario> items = (List<AuxValeBeneficiario>) dataGrid.getVisibleItems();
              if (items.size() == 0) {
                return "";
              } else {
                double totalAge = 0.0;
                for (AuxValeBeneficiario item : items) {
                  totalAge += item.getVale().getTotalVale();
                }
                return "Total Saldo: " + totalAge;
              }
            }
          };        
        
        
        Column<T, String> precioUnitario = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return "Q "+String.valueOf(((AuxValeBeneficiario) object).getVale().getTotalVale());
            }
        };
        dataGrid.addColumn(precioUnitario,new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant("Total Vale (Q)")), sumatoria);
        dataGrid.setColumnWidth(precioUnitario, 20, Unit.PCT);
        
        Column<T, String> column5 = new Column<T, String>(new EditTextCell()) {
            @Override
            public String getValue(T object) {
                return String.valueOf(((AuxValeBeneficiario) object).getProveedor().getNomProveedor());
            }
        };
        dataGrid.addColumn(column5, "Proveedor");
        dataGrid.setColumnWidth(column5, 20, Unit.PCT);
        
       /* Column<T, String> columna5 = new Column<T, String>(new EditTextCell()) {
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
        dataGrid.setColumnWidth(precioUnitario, 20, Unit.PCT);*/
               
    }
    
    
private String Depto_Municipio(String Departamento){
		
		String valor = "";
		if(Departamento.equals("01")){	
			
			valor = valor + "," + "Guatemala";
			valor = valor + "," + "Santa Catarina Pinula";
			valor = valor + "," + "San Jose Pinula";
			valor = valor + "," + "San Jose del Golfo";
			valor = valor + "," + "Palencia";
			valor = valor + "," + "Chinautla";
			valor = valor + "," + "San Pedro Ayampuc";
			valor = valor + "," + "Mixco";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Juan Sacatepequez";
			valor = valor + "," + "San Raymundo";
			valor = valor + "," + "Chuarrancho";
			valor = valor + "," + "Fraijanes";
			valor = valor + "," + "Amatitlan";
			valor = valor + "," + "Villa Nueva";
			valor = valor + "," + "Villa Canales";
			valor = valor + "," + "Petapa";
			
		}else if(Departamento.equals("15")){
			valor = valor + "," + "Salama";
			valor = valor + "," + "San Miguel Chicaj";
			valor = valor + "," + "Rabinal";
			valor = valor + "," + "Cubulco";
			valor = valor + "," + "Granados";
			valor = valor + "," + "Santa Cruz el Chol";
			valor = valor + "," + "San Jeronimo";
			valor = valor + "," + "Purulha";
			
		}else if(Departamento.equals("16")){
			valor = valor + "," + "Coban";
			valor = valor + "," + "Santa Cruz Verapaz";
			valor = valor + "," + "San Cristobal Verapaz";
			valor = valor + "," + "Tactic";
			valor = valor + "," + "Tamahu";
			valor = valor + "," + "Tucuru";
			valor = valor + "," + "Panzos";
			valor = valor + "," + "Senahu";
			valor = valor + "," + "San Pedro Carcha";
			valor = valor + "," + "San Juan Chamelco";
			valor = valor + "," + "Lanquin";
			valor = valor + "," + "Santa Maria Cahabon";
			valor = valor + "," + "Chisec";
			valor = valor + "," + "Chahal";
			valor = valor + "," + "Fray Bartolome de las Casas";
			valor = valor + "," + "La Tinta";
			valor = valor + "," + "Raxruha";
			
		}else if(Departamento.equals("02")){
			valor = valor + "," + "Guastatoya";
			valor = valor + "," + "Morazan";
			valor = valor + "," + "San Agustin Acasaguastlan";
			valor = valor + "," + "San Cristobal Acasaguastlan";
			valor = valor + "," + "El Jicaro";
			valor = valor + "," + "Sansare";
			valor = valor + "," + "Sanarate";
			valor = valor + "," + "San Antonio La Paz";
			
		}else if(Departamento.equals("18")){
			valor = valor + "," + "Puerto Barrios";
			valor = valor + "," + "Livingston";
			valor = valor + "," + "El Estor";
			valor = valor + "," + "Morales";
			valor = valor + "," + "Los Amates";
			
		}else if(Departamento.equals("19")){
			valor = valor + "," + "Zacapa";
			valor = valor + "," + "Estanzuela";
			valor = valor + "," + "Rio Hondo";
			valor = valor + "," + "Gualan";
			valor = valor + "," + "Teculutan";
			valor = valor + "," + "Usumatlan";
			valor = valor + "," + "Cabañas";
			valor = valor + "," + "Huite";
			valor = valor + "," + "San Diego";
			valor = valor + "," + "La Union";
			valor = valor + "," + "Huite";
			
		}else if(Departamento.equals("20")){

			valor = valor + "," + "Chiquimula";
			valor = valor + "," + "San Jose la Arada";
			valor = valor + "," + "San Juan Ermita";
			valor = valor + "," + "Jocotan";
			valor = valor + "," + "Camotan";
			valor = valor + "," + "Olopa";
			valor = valor + "," + "Esquipulas";
			valor = valor + "," + "Concepcion Las Minas";
			valor = valor + "," + "Quezaltepeque";
			valor = valor + "," + "San Jacinto";
			valor = valor + "," + "Ipala";
			
		}else if(Departamento.equals("06")){
			valor = valor + "," + "Cuilapa";
			valor = valor + "," + "Barberena";
			valor = valor + "," + "Santa Rosa de Lima";
			valor = valor + "," + "Casillas";
			valor = valor + "," + "San Rafael las Flores";
			valor = valor + "," + "Oratorio";
			valor = valor + "," + "San Juan Tecuaco";
			valor = valor + "," + "Chiquimulilla";
			valor = valor + "," + "Taxisco";
			valor = valor + "," + "Santa Maria Ixhuatan";
			valor = valor + "," + "Guazacapan";
			valor = valor + "," + "Santa Cruz Naranjo";
			valor = valor + "," + "Pueblo Nuevo Viñas";
			valor = valor + "," + "Nueva Santa Rosa";
			
		}else if(Departamento.equals("21")){
			valor = valor + "," + "Jalapa";
			valor = valor + "," + "San Pedro Pinula";
			valor = valor + "," + "San Luis Jilotepeque";
			valor = valor + "," + "San Manuel Chaparron";
			valor = valor + "," + "San Carlos Alzatate";
			valor = valor + "," + "Monjas";
			valor = valor + "," + "Mataquescuintla";
			
		}else if(Departamento.equals("22")){
			valor = valor + "," + "Jutiapa";
			valor = valor + "," + "El Progreso";
			valor = valor + "," + "Santa Catarina Mita";
			valor = valor + "," + "Agua Blanca";
			valor = valor + "," + "Asuncion Mita";
			valor = valor + "," + "Yupiltepeque";
			valor = valor + "," + "Atescatempa";
			valor = valor + "," + "Jerez";
			valor = valor + "," + "El Adelanto";
			valor = valor + "," + "Zapotitlan";
			valor = valor + "," + "Comapa";
			valor = valor + "," + "Jalpatagua";
			valor = valor + "," + "Conguaco";
			valor = valor + "," + "Moyuta";
			valor = valor + "," + "Pasaco";
			valor = valor + "," + "San Jose Acatempa";
			valor = valor + "," + "Quesada";
			
		}else if(Departamento.equals("03")){
			valor = valor + "," + "La Antigua Guatemala";
			valor = valor + "," + "Jocotenango";
			valor = valor + "," + "Pastores";
			valor = valor + "," + "Sumpango";
			valor = valor + "," + "Santo Domingo Xenacoj";
			valor = valor + "," + "Santiago Sacatepequez";
			valor = valor + "," + "San Bartolome Milpas Altas";
			valor = valor + "," + "San Lucas Sacatepequez";
			valor = valor + "," + "Santa Lucia Milpas Altas";
			valor = valor + "," + "Magdalena Milpas Altas";
			valor = valor + "," + "Santa Maria de Jesus";
			valor = valor + "," + "Ciudad Vieja";
			valor = valor + "," + "San Miguel Dueñas";
			valor = valor + "," + "Alotenango";
			valor = valor + "," + "San Antonio Aguas Calientes";
			valor = valor + "," + "Santa Catarina Barahona";
			
		}else if(Departamento.equals("04")){
			valor = valor + "," + "Chimaltenango";
			valor = valor + "," + "San Jose Poaquil";
			valor = valor + "," + "San Martin Jilotepeque";
			valor = valor + "," + "San Juan Comalapa";
			valor = valor + "," + "Santa Apolonia";
			valor = valor + "," + "Tecpan";
			valor = valor + "," + "Patzun";
			valor = valor + "," + "Pochuta";
			valor = valor + "," + "Patzicia";
			valor = valor + "," + "Santa Cruz Balanya";
			valor = valor + "," + "Acatenango";
			valor = valor + "," + "Yepocapa";
			valor = valor + "," + "San Andres Itzapa";
			valor = valor + "," + "Parramos";
			valor = valor + "," + "Zaragoza";
			valor = valor + "," + "El Tejar";
			
		}else if(Departamento.equals("05")){			
			valor = valor + "," + "Escuintla";
			valor = valor + "," + "Santa Lucia Cotzumalguapa";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "Siquinala";
			valor = valor + "," + "Masagua";
			valor = valor + "," + "Tiquisate";
			valor = valor + "," + "La Gomera";
			valor = valor + "," + "Guanagazapa";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "Iztapa";
			valor = valor + "," + "Palin";
			valor = valor + "," + "San Vicente Pacaya";
			valor = valor + "," + "Nueva Concepcion";
			
		}else if(Departamento.equals("07")){
			valor = valor + "," + "Solola";
			valor = valor + "," + "San Jose Chacaya";
			valor = valor + "," + "Santa Maria Visitacion";
			valor = valor + "," + "Santa Lucia Utatlan";
			valor = valor + "," + "Nahuala";
			valor = valor + "," + "Santa Catarina Ixtahuacan";
			valor = valor + "," + "Santa Clara La Laguna";
			valor = valor + "," + "Concepcion";
			valor = valor + "," + "San Andres Semetabaj";
			valor = valor + "," + "Panajachel";
			valor = valor + "," + "Santa Catarina Palopo";
			valor = valor + "," + "San Antonio Palopo";
			valor = valor + "," + "San Lucas Toliman";
			valor = valor + "," + "Santa Cruz La Laguna";
			valor = valor + "," + "San Pablo La Laguna";
			valor = valor + "," + "San Juan La Laguna";
			valor = valor + "," + "San Marcos La Laguna";
			valor = valor + "," + "San Pedro La Laguna";
			valor = valor + "," + "Santiago Atitlan";
			
		}else if(Departamento.equals("08")){
			valor = valor + "," + "Totonicapan";
			valor = valor + "," + "San Cristobal Totonicapan";
			valor = valor + "," + "San Francisco El Alto";
			valor = valor + "," + "San Andres Xecul";
			valor = valor + "," + "Momostenango";
			valor = valor + "," + "Santa Maria Chiquimula";
			valor = valor + "," + "Santa Lucia La Reforma";
			valor = valor + "," + "San Bartolo";
			
		}else if(Departamento.equals("09")){
			valor = valor + "," + "Quetzaltenango";
			valor = valor + "," + "Salcaja";
			valor = valor + "," + "Olintepeque";
			valor = valor + "," + "San Carlos Sija";
			valor = valor + "," + "Sibilia";
			valor = valor + "," + "Cabrican";
			valor = valor + "," + "Cajola";
			valor = valor + "," + "San Miguel Sigüila";
			valor = valor + "," + "San Juan Ostuncalco";
			valor = valor + "," + "San Mateo";
			valor = valor + "," + "Concepcion Chiquirichapa";
			valor = valor + "," + "San Martin Sacatepequez";
			valor = valor + "," + "Almolonga";
			valor = valor + "," + "Cantel";
			valor = valor + "," + "Huitan";
			valor = valor + "," + "Zunil";
			valor = valor + "," + "Colomba Costa Cuca";
			valor = valor + "," + "San Francisco La Union";
			valor = valor + "," + "El Palmar";
			valor = valor + "," + "Coatepeque";
			valor = valor + "," + "Genova";
			valor = valor + "," + "Flores Costa Cuca";
			valor = valor + "," + "La Esperanza";
			valor = valor + "," + "Palestina de Los Altos";
			
		}else if(Departamento.equals("10")){
			valor = valor + "," + "Mazatenango";
			valor = valor + "," + "Cuyotenango";
			valor = valor + "," + "San Francisco Zapotitlan";
			valor = valor + "," + "San Bernardino";
			valor = valor + "," + "San Jose El Idolo";
			valor = valor + "," + "Santo Domingo Suchitepequez";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "Samayac";
			valor = valor + "," + "San Pablo Jocopilas";
			valor = valor + "," + "San Antonio Suchitepequez";
			valor = valor + "," + "San Miguel Panan";
			valor = valor + "," + "San Gabriel";
			valor = valor + "," + "Chicacao";
			valor = valor + "," + "Patulul";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "San Juan Bautista";
			valor = valor + "," + "Santo Tomas La Union";
			valor = valor + "," + "Zunilito";
			valor = valor + "," + "Pueblo Nuevo";
			valor = valor + "," + "Rio Bravo";
			
		}else if(Departamento.equals("11")){
			valor = valor + "," + "Retalhuleu";
			valor = valor + "," + "San Sebastian";
			valor = valor + "," + "Santa Cruz Mulua";
			valor = valor + "," + "San Martin Zapotitlan";
			valor = valor + "," + "San Felipe";
			valor = valor + "," + "San Andres Villa Seca";
			valor = valor + "," + "Champerico";
			valor = valor + "," + "Nuevo San Carlos";
			valor = valor + "," + "El Asintal";
			
		}else if(Departamento.equals("12")){
			valor = valor + "," + "San Marcos";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Antonio Sacatepequez";
			valor = valor + "," + "Comitancillo";
			valor = valor + "," + "San Miguel Ixtahuacan";
			valor = valor + "," + "Concepcion Tutuapa";
			valor = valor + "," + "Tacana";
			valor = valor + "," + "Sibinal";
			valor = valor + "," + "Tajumulco";
			valor = valor + "," + "Tejutla";
			valor = valor + "," + "San Rafael Pie de la Cuesta";
			valor = valor + "," + "Nuevo Progreso";
			valor = valor + "," + "El Tumbador";
			valor = valor + "," + "San Jose El Rodeo";
			valor = valor + "," + "Malacatan";
			valor = valor + "," + "Catarina";
			valor = valor + "," + "Ayutla";
			valor = valor + "," + "Ocos";
			valor = valor + "," + "San Pablo";
			valor = valor + "," + "El Quetzal";
			valor = valor + "," + "La Reforma";
			valor = valor + "," + "Pajapita";
			valor = valor + "," + "Ixchiguan";
			valor = valor + "," + "San Jose Ojetenam";
			valor = valor + "," + "San Cristobal Cucho";
			valor = valor + "," + "Sipacapa";
			valor = valor + "," + "Esquipulas Palo Gordo";
			valor = valor + "," + "Rio Blanco";
			valor = valor + "," + "San Lorenzo";
			
		}else if(Departamento.equals("13")){
			valor = valor + "," + "Huehuetenango";
			valor = valor + "," + "Chiantla";
			valor = valor + "," + "Malacatancito";
			valor = valor + "," + "Cuilco";
			valor = valor + "," + "Nenton";
			valor = valor + "," + "San Pedro Necta";
			valor = valor + "," + "Jacaltenango";
			valor = valor + "," + "San Pedro Soloma";
			valor = valor + "," + "San Ildefonso Ixtahuacan";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "San Miguel Acatan";
			valor = valor + "," + "San Rafael La Independencia";
			valor = valor + "," + "Santos Cuchumatan";
			valor = valor + "," + "San Juan Atitan";
			valor = valor + "," + "Santa Eulalia";
			valor = valor + "," + "San Mateo Ixtatan";
			valor = valor + "," + "Colotenango";
			valor = valor + "," + "San Sebastian Huehuetenango";
			valor = valor + "," + "Tectitan";
			valor = valor + "," + "Concepcion Huista";
			valor = valor + "," + "San Juan Ixcoy";
			valor = valor + "," + "San Antonio Huista";
			valor = valor + "," + "San Sebastian Coatan";
			valor = valor + "," + "Santa Cruz Barillas";
			valor = valor + "," + "Aguacatan";
			valor = valor + "," + "San Rafael Petzal";
			valor = valor + "," + "San Gaspar Ixchil";
			valor = valor + "," + "Santiago Chimaltenango";
			valor = valor + "," + "Santa Ana Huista";
			valor = valor + "," + "Union Cantinil";
			
		}else if(Departamento.equals("14")){
			valor = valor + "," + "Santa Cruz del Quiche";
			valor = valor + "," + "Chiche";
			valor = valor + "," + "Chinique";
			valor = valor + "," + "Zacualpa";
			valor = valor + "," + "Chajul";
			valor = valor + "," + "Chichicastenango";
			valor = valor + "," + "Patzite";
			valor = valor + "," + "San Antonio Ilotenango";
			valor = valor + "," + "San Pedro Jocopilas";
			valor = valor + "," + "Cunen";
			valor = valor + "," + "San Juan Cotzal";
			valor = valor + "," + "Joyabaj";
			valor = valor + "," + "Nebaj";
			valor = valor + "," + "San Andres Sajcabaja";
			valor = valor + "," + "Uspantan";
			valor = valor + "," + "Sacapulas";
			valor = valor + "," + "San Bartolome Jocotenango";
			valor = valor + "," + "Canilla";
			valor = valor + "," + "Chicaman";
			valor = valor + "," + "Ixcan";
			valor = valor + "," + "Pachalum";
			
		}else if(Departamento.equals("17")){
			valor = valor + "," + "Flores";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "San Benito";
			valor = valor + "," + "San Andres";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "San Francisco";
			valor = valor + "," + "Santa Ana";
			valor = valor + "," + "Dolores";
			valor = valor + "," + "San Luis";
			valor = valor + "," + "Sayaxche";
			valor = valor + "," + "Melchor de Mencos";
			valor = valor + "," + "Poptun";
			
		}else if(Departamento.equals("-")){
			valor = valor + "," + "-";
		}
	
		return valor;
	}


    
private String getDepto(String codigo){
	switch (codigo) {
	  case "01": return "Guatemala";  
	  case "15": return "Baja Verapaz";  
	 case "16": return "Alta Verapaz" ;  
	  case "02": return "El Progreso";  
	  case "18": return "Izabal";  
	 case "19": return  "Zacapa";  
	  case "20": return "Chiquimula";  
	  case "06": return "Santa Rosa";  
	  case "21": return "Jalapa";  
	  case "22": return "Jutiapa";  
	  case "03": return "Sacatepequez";  
	  case "04": return "Chimaltenango";  
	  case "05": return "Escuintla";  
	  case "07": return "Solola";  
	  case "08": return "Totonicapan";  
	  case "09": return "Quezaltenango"; 
	  case "10": return "Suchitepequez";  
	  case "11": return "Retalhuleu";  
	  case "12": return "San Marcos";  
	  case "13": return "Huehuetenango";  
	  case "14": return "Quiche";  
	  case "17": return "Peten";  

	default: return "Sin Dep";
	}
}
 
}
