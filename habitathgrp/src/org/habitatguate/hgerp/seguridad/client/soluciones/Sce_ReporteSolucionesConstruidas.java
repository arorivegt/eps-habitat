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

	private CellTable<Sce_DatosSolucionesConstruidas> cellTable;
	private List<Sce_DatosSolucionesConstruidas> DATOS = new ArrayList<Sce_DatosSolucionesConstruidas>();
	private VerticalPanel vp ;
    private Loading load ;
	
	public Sce_ReporteSolucionesConstruidas(List<Sce_DatosSolucionesConstruidas> DATOS2) {

	    vp = new VerticalPanel();

    	load = new Loading();
        load.Mostrar();
        load.invisible();
		setDATOS(DATOS2);
		cellTable = new CellTable<Sce_DatosSolucionesConstruidas>();
		cellTable.setPageSize(10);
		initWidget(vp);
	
		AsyncDataProvider<Sce_DatosSolucionesConstruidas> provider = new AsyncDataProvider<Sce_DatosSolucionesConstruidas>() {
		      @Override
		      protected void onRangeChanged(HasData<Sce_DatosSolucionesConstruidas> display) {
		        int start = display.getVisibleRange().getStart();
		        int end = start + display.getVisibleRange().getLength();
		        end = end >= DATOS.size() ? DATOS.size() : end;
		        List<Sce_DatosSolucionesConstruidas> sub = DATOS.subList(start, end);
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
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getNumero();
				}
			};
			cellTable.addColumn(nameColumn, "No. Correlativo");
		}
		
//		if(tipo.equals("1"))
//		{
//			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
//				@Override
//				public String getValue(Sce_DatosSolucionesConstruidas object) {
//					return object.getIdFormulario();
//				}
//			};
//			cellTable.addColumn(nameColumn, "Codigo Referencia");
//		}
		
		if(tipo.equals("2"))
		{
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getNombreSolicitante();
				}
			};
			cellTable.addColumn(nameColumn, "Nombre Solicitante");
		}
		
		else if(tipo.equals("3")){
				TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
					@Override
					public String getValue(Sce_DatosSolucionesConstruidas object) {
						return object.getEstadoCivil();
					}
				};
				cellTable.addColumn(nameColumn, "Estado Civil");	
		}
		
		else if(tipo.equals("4")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getEdad();
				}
			};
			cellTable.addColumn(nameColumn, "Edad");	
		}
		
		else if(tipo.equals("5")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getSolucionConstruir();
				}
			};
			cellTable.addColumn(nameColumn, "Solucion a Construir");	
		}
		
//		else if(tipo.equals("5")){
//			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
//				@Override
//				public String getValue(Sce_DatosSolucionesConstruidas object) {
//					return object.getSabeLeer();
//				}
//			};
//			cellTable.addColumn(nameColumn, "Sabe Leer");	
//		}
//		else if(tipo.equals("6")){
//			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
//				@Override
//				public String getValue(Sce_DatosSolucionesConstruidas object) {
//					return object.getSabeEscribir();
//				}
//			};
//			cellTable.addColumn(nameColumn, "Sabe Escribir");	
//		}
		
		else if(tipo.equals("6")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getTelefonoCasaSolicitante();
				}
			};
			cellTable.addColumn(nameColumn, "Telefono Casa");	
		}
		
		else if(tipo.equals("7")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getTelefonoTrabajoSolicitante();
				}
			};
			cellTable.addColumn(nameColumn, "Telefono Trabajo");	
		}
		else if(tipo.equals("8")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getCamion();
				}
			};
			cellTable.addColumn(nameColumn, "Inmueble accesible en camion");	
		}
		
		else if(tipo.equals("9")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getCarro();
				}
			};
			cellTable.addColumn(nameColumn, "Inmueble accesible en carro");	
		}
		
		else if(tipo.equals("10")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getPeatonal();
				}
			};
			cellTable.addColumn(nameColumn, "Inmueble accesible para peatones");	
		}
		
		else if(tipo.equals("11")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getGarantia();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Garantia");	
		}	
		
		else if(tipo.equals("12")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getSupervisionPrimera();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Primera Supervision");	
		}	
		
		else if(tipo.equals("13")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getSupervisionSegunda();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Segunda Supervision");	
		}
		
		else if(tipo.equals("14")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getSupervisionTercera();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Tercera Supervision");	
		}
		
		else if(tipo.equals("15")){
			TextColumn<Sce_DatosSolucionesConstruidas> nameColumn = new TextColumn<Sce_DatosSolucionesConstruidas>() {
				@Override
				public String getValue(Sce_DatosSolucionesConstruidas object) {
					return object.getSupervisionCuarta();
				}
			};
			cellTable.addColumn(nameColumn, "Contiene Cuarta Supervision");	
		}

	}
	
	public List<Sce_DatosSolucionesConstruidas> getDATOS() {
		return DATOS;
	}

	public void setDATOS(List<Sce_DatosSolucionesConstruidas> dATOS) {
		DATOS = dATOS;
	}

}
