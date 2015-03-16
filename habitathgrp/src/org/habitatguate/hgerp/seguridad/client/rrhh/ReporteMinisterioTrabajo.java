package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

public class ReporteMinisterioTrabajo extends Composite  {

	private CellTable<DatosMinisterioTrabajo> cellTable;
	private List<DatosMinisterioTrabajo> DATOS = new ArrayList<DatosMinisterioTrabajo>();
	private  VerticalPanel vp ;
    private Loading load ;
	
	public ReporteMinisterioTrabajo(List<DatosMinisterioTrabajo> DATOS2) {

	    vp = new VerticalPanel();

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		setDATOS(DATOS2);
		cellTable = new CellTable<DatosMinisterioTrabajo>();
		cellTable.setPageSize(10);
		initWidget(vp);
	
		AsyncDataProvider<DatosMinisterioTrabajo> provider = new AsyncDataProvider<DatosMinisterioTrabajo>() {
		      @Override
		      protected void onRangeChanged(HasData<DatosMinisterioTrabajo> display) {
		        int start = display.getVisibleRange().getStart();
		        int end = start + display.getVisibleRange().getLength();
		        end = end >= DATOS.size() ? DATOS.size() : end;
		        List<DatosMinisterioTrabajo> sub = DATOS.subList(start, end);
		        updateRowData(start, sub);
		      }
		    };
		    provider.addDataDisplay(cellTable);
		    provider.updateRowCount(DATOS.size(), true);

		    SimplePager pager = new SimplePager();
		    pager.setDisplay(cellTable);

		    vp.add(cellTable);
		    cellTable.setWidth("421px");
		    vp.add(pager);
		    pager.setWidth("219px");
		
	}

	public void AgregarColumna(String tipo)
	{

		if(tipo.equals("1"))
		{
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getNoEmpleado();
				}
			};
			cellTable.addColumn(nameColumn, "Numero empleado");
		}else if(tipo.equals("2")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getNombre1();
				}
			};
			cellTable.addColumn(nameColumn, "Primer Nombre");	
		}else if(tipo.equals("3")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getNombre2();
				}
			};
			cellTable.addColumn(nameColumn, "Segundo Nombre");	
		}else if(tipo.equals("4")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getApellido1();
				}
			};
			cellTable.addColumn(nameColumn, "Primer Apellido");	
		}else if(tipo.equals("5")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getApellido2();
				}
			};
			cellTable.addColumn(nameColumn, "Segundo Apellido");	
		}else if(tipo.equals("6")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPaisOrigen();
				}
			};
			cellTable.addColumn(nameColumn, "Nacionalidad");	
		}else if(tipo.equals("7")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getEstadoCivil();
				}
			};
			cellTable.addColumn(nameColumn, "Estado Civil");	
		}else if(tipo.equals("8")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getTipoIdentificacion();
				}
			};
			cellTable.addColumn(nameColumn, "Documento Identificación");	
		}
		else if(tipo.equals("9")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getDocumentoIdentificacion();
				}
			};
			cellTable.addColumn(nameColumn, "Número de Documento");	
		}
		else if(tipo.equals("10")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPaisOrigen();
				}
			};
			cellTable.addColumn(nameColumn, "Pais Origen");	
		}
		else if(tipo.equals("11")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getLugarNacimiento();
				}
			};
			cellTable.addColumn(nameColumn, "Lugar Nacimiento");	
		}else if(tipo.equals("12")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getNitEmpleado();
				}
			};
			cellTable.addColumn(nameColumn, "NIT");	
		}else if(tipo.equals("13")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getIGSSEmpleado();
				}
			};
			cellTable.addColumn(nameColumn, "Número de Afiliación IGSS");	
		}else if(tipo.equals("14")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getSexo();
				}
			};
			cellTable.addColumn(nameColumn, " Sexo (M) O (F)");	
		}else if(tipo.equals("15")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getFechaNacimiento();
				}
			};
			cellTable.addColumn(nameColumn, "Fecha Nacimiento");	
		}
		else if(tipo.equals("16")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getNumeroHijos();
				}
			};
			cellTable.addColumn(nameColumn, "Cantidad de Hijos");	
		}else if(tipo.equals("17")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPaisOrigen();
				}
			};
			cellTable.addColumn(nameColumn, "A trabajado en el extranjero");	
		}else if(tipo.equals("18")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPaisOrigen();
				}
			};
			cellTable.addColumn(nameColumn, "En que forma");	
		}else if(tipo.equals("19")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPaisOrigen();
				}
			};
			cellTable.addColumn(nameColumn, "Pais");	
		}else if(tipo.equals("20")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPaisOrigen();
				}
			};
			cellTable.addColumn(nameColumn, "Motivo de finalización de la relación laboral en el extranjero");	
		}else if(tipo.equals("21")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getNivelAcademico();
				}
			};
			cellTable.addColumn(nameColumn, "Nivel Academico");	
		}else if(tipo.equals("22")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getProfesion();
				}
			};
			cellTable.addColumn(nameColumn, "Profesión");	
		}else if(tipo.equals("23")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getEtnia();
				}
			};
			cellTable.addColumn(nameColumn, "Etnia");	
		}else if(tipo.equals("24")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getIdiomas();
				}
			};
			cellTable.addColumn(nameColumn, "Idioma");	
		}else if(tipo.equals("25")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getTipoContrato();
				}
			};
			cellTable.addColumn(nameColumn, "Tipo Contrato");	
		}else if(tipo.equals("26")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getInicioLabores();
				}
			};
			cellTable.addColumn(nameColumn, "Fecha Inicio Labores");	
		}else if(tipo.equals("27")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getReinicioLabores();
				}
			};
			cellTable.addColumn(nameColumn, "Fecha Reinicio-labores");	
		}else if(tipo.equals("28")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getInicioLabores();
				}
			};
			cellTable.addColumn(nameColumn, "Fecha Retiro Labores");	
		}else if(tipo.equals("29")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPuesto();
				}
			};
			cellTable.addColumn(nameColumn, "Puesto");	
		}else if(tipo.equals("30")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getJornada();
				}
			};
			cellTable.addColumn(nameColumn, "Jornada de Trabajo");	
		}else if(tipo.equals("31")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getTiempodelaborar();
				}
			};
			cellTable.addColumn(nameColumn, "Dias Laborados en el Año");	
		}else if(tipo.equals("32")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getPermisoTrabajo();
				}
			};
			cellTable.addColumn(nameColumn, "Permiso Trabajo");	
		}else if(tipo.equals("33")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getSalarioMensualNominal();
				}
			};
			cellTable.addColumn(nameColumn, "Salario Mensual Nominal");	
		}else if(tipo.equals("34")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getDecreto7889();
				}
			};
			cellTable.addColumn(nameColumn, "Bonificación Decreto 78-89 (Q.250.00)");	
		}else if(tipo.equals("35")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getTotalHorasExtras();
				}
			};
			cellTable.addColumn(nameColumn, "Total Horas Extras Anuales");	
		}else if(tipo.equals("36")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getValordeHoraExtra();
				}
			};
			cellTable.addColumn(nameColumn, "Valor de Hora Extra");	
		}else if(tipo.equals("37")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getAguinaldo();
				}
			};
			cellTable.addColumn(nameColumn, "Monto Aguinaldo Decreto 76-78");	
		}else if(tipo.equals("38")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getBono14();
				}
			};
			cellTable.addColumn(nameColumn, "Monto Bono 14  Decreto");	
		}else if(tipo.equals("39")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getComisiones();
				}
			};
			cellTable.addColumn(nameColumn, "Retribución por Comisiones");	
		}else if(tipo.equals("40")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getViaticos();
				}
			};
			cellTable.addColumn(nameColumn, "Viaticos");	
		}
		else if(tipo.equals("41")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getBonificaciones();
				}
			};
			cellTable.addColumn(nameColumn, "Bonificaciones Adicionales");	
		}
		else if(tipo.equals("42")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getVacaciones();
				}
			};
			cellTable.addColumn(nameColumn, "Retribución por vacaciones");	
		}else if(tipo.equals("43")){
			TextColumn<DatosMinisterioTrabajo> nameColumn = new TextColumn<DatosMinisterioTrabajo>() {
				@Override
				public String getValue(DatosMinisterioTrabajo object) {
					return object.getIndemnizacion();
				}
			};
			cellTable.addColumn(nameColumn, "Retribución por Indemnización (Articulo 82)");	
		}
		
	}
	
	public List<DatosMinisterioTrabajo> getDATOS() {
		return DATOS;
	}

	public void setDATOS(List<DatosMinisterioTrabajo> dATOS) {
		DATOS = dATOS;
	}

}
