package org.habitatguate.hgerp.seguridad.client.soluciones;

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

public class Sce_ReporteSolucionesConstruidas extends Composite  {

	private CellTable<Sce_ReporteDatosSolucionesConstruidas> cellTable;
	private List<Sce_ReporteDatosSolucionesConstruidas> DATOS = new ArrayList<Sce_ReporteDatosSolucionesConstruidas>();
	private VerticalPanel vp ;
    private Loading load ;
	
	public Sce_ReporteSolucionesConstruidas(List<Sce_ReporteDatosSolucionesConstruidas> DATOS2) {

	    vp = new VerticalPanel();

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		setDATOS(DATOS2);
		cellTable = new CellTable<Sce_ReporteDatosSolucionesConstruidas>();
		cellTable.setPageSize(10);
		initWidget(vp);
	
		AsyncDataProvider<Sce_ReporteDatosSolucionesConstruidas> provider = new AsyncDataProvider<Sce_ReporteDatosSolucionesConstruidas>() {
		      @Override
		      protected void onRangeChanged(HasData<Sce_ReporteDatosSolucionesConstruidas> display) {
		        int start = display.getVisibleRange().getStart();
		        int end = start + display.getVisibleRange().getLength();
		        end = end >= DATOS.size() ? DATOS.size() : end;
		        List<Sce_ReporteDatosSolucionesConstruidas> sub = DATOS.subList(start, end);
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

	public void ConstruirConsultaSoluciones(String tipo)
	{

		if(tipo.equals("1"))
		{
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getNumero();
				}
			};
			cellTable.addColumn(nameColumn, "No. Correlativo");
		}
		
		if(tipo.equals("2"))
		{
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getNombreSolicitante();
				}
			};
			cellTable.addColumn(nameColumn, "Nombre Solicitante");
		}
		
		else if(tipo.equals("3")){
				TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
					@Override
					public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
						return object.getEstadoCivil();
					}
				};
				cellTable.addColumn(nameColumn, "Estado Civil");	
		}
		
		else if(tipo.equals("4")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getEdad();
				}
			};
			cellTable.addColumn(nameColumn, "Edad");	
		}
		
		else if(tipo.equals("5")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getSolucionConstruir();
				}
			};
			cellTable.addColumn(nameColumn, "Solucion a Construir");	
		}
		
		else if(tipo.equals("6")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getUsrName();
				}
			};
			cellTable.addColumn(nameColumn, "Usuario Responsable");	
		}
		
		else if(tipo.equals("7")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getTelefonoCasaSolicitante();
				}
			};
			cellTable.addColumn(nameColumn, "Telefono Casa");	
		}
		
		else if(tipo.equals("8")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getTelefonoTrabajoSolicitante();
				}
			};
			cellTable.addColumn(nameColumn, "Telefono Trabajo");	
		}
		else if(tipo.equals("9")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getCamion();
				}
			};
			cellTable.addColumn(nameColumn, "Inmueble accesible en camion");	
		}
		
		else if(tipo.equals("10")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getCarro();
				}
			};
			cellTable.addColumn(nameColumn, "Inmueble accesible en carro");	
		}
		
		else if(tipo.equals("11")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPeatonal();
				}
			};
			cellTable.addColumn(nameColumn, "Inmueble accesible para peatones");	
		}
		
		else if(tipo.equals("12")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getCreditoAprobado();
				}
			};
			cellTable.addColumn(nameColumn, "Credito Aprobado");	
		}
		
		else if(tipo.equals("13")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getSupervisionPrimera();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Primera Supervision");	
		}	
		
		else if(tipo.equals("14")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getSupervisionSegunda();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Segunda Supervision");	
		}
		
		else if(tipo.equals("15")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getSupervisionTercera();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Tercera Supervision");	
		}
		
		else if(tipo.equals("16")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getSupervisionCuarta();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Cuarta Supervision");	
		}

	}
	
	public void ConstruirConsultaEncuestas(String tipo)
	{

		if(tipo.equals("1"))
		{
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getNumero();
				}
			};
			cellTable.addColumn(nameColumn, "No. Correlativo");
		}
		
		if(tipo.equals("2"))
		{
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getNombreSolicitante();
				}
			};
			cellTable.addColumn(nameColumn, "Nombre Solicitante");
		}

		if(tipo.equals("3"))
		{
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getDepartamento();
				}
			};
			cellTable.addColumn(nameColumn, "Departamento");
		}
		
		if(tipo.equals("4"))
		{
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta1();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 1");
		}
		
		else if(tipo.equals("5")){
				TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
					@Override
					public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
						return object.getPregunta2();
					}
				};
				cellTable.addColumn(nameColumn, "Pregunta 2");	
		}
		
		else if(tipo.equals("6")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta3();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 3");	
		}
		
		else if(tipo.equals("7")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta4();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 4");	
		}
		
		else if(tipo.equals("8")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta5();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 5");	
		}
		
		else if(tipo.equals("9")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta6();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 6");	
		}
		else if(tipo.equals("10")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta7();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 7");	
		}
		
		else if(tipo.equals("11")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta8();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 8");	
		}
		
		else if(tipo.equals("12")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta9();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 9");	
		}
		
		else if(tipo.equals("13")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta10();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 10");	
		}	
		
		else if(tipo.equals("14")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta11();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 11");	
		}	
		
		else if(tipo.equals("15")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta12();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 12");	
		}
		
		else if(tipo.equals("16")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta13();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 13");	
		}
		
		else if(tipo.equals("17")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta14();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 14");	
		}
		
		else if(tipo.equals("18")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta15();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 15");	
		}
		
		else if(tipo.equals("19")){
			TextColumn<Sce_ReporteDatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_ReporteDatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_ReporteDatosSolucionesConstruidas object) {
					return object.getPregunta16();
				}
			};
			cellTable.addColumn(nameColumn, "Pregunta 16");	
		}

	}	
	
	
	public List<Sce_ReporteDatosSolucionesConstruidas> getDATOS() {
		return DATOS;
	}

	public void setDATOS(List<Sce_ReporteDatosSolucionesConstruidas> dATOS) {
		DATOS = dATOS;
	}

}
