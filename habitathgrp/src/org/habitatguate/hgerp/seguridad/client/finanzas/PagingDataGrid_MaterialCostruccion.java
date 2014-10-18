package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;

 
/**
 * Clase abstracta PaggingDataGrid para establecer la simple pagina inicial del DataGrid  con ListDataProvider
 * 
 */
public abstract class PagingDataGrid_MaterialCostruccion<T> extends Composite {
 
    private DataGrid<T> dataGrid;
    private SimplePager pager;
    private String height;
    private ListDataProvider<T> dataProvider;
    private List<T> dataList;
    private DockPanel dock = new DockPanel();
	private Button botonEliminar;
	//private Button botonRefresh;
    final MultiSelectionModel<T> selectionModel =
            new MultiSelectionModel<T>((ProvidesKey<T>)AuxMaterialCostruccion.KEY_PROVIDER);
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	Iterator<T> iter = null;
	T objectoEliminado = null;
    public PagingDataGrid_MaterialCostruccion() {
        initWidget(dock);
        dataGrid = new DataGrid<T>(30,
                GWT.<TablaResources> create(TablaResources.class));
        dataGrid.setSize("1100px", "300px");

        SimplePager.Resources pagerResources = GWT
                .create(SimplePager.Resources.class);
        pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0,
                true);
        pager.setDisplay(dataGrid);
        
        dataProvider = new ListDataProvider<T>();
        dataProvider.setList(new ArrayList<T>());
        dataGrid.setEmptyTableWidget(new HTML("No existen datos a mostrar"));
        ListHandler<T> sortHandler = new ListHandler<T>(dataProvider.getList());
        dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager
                .<T> createCheckboxManager());
        initTableColumns(dataGrid, sortHandler);
 
        dataGrid.addColumnSortHandler(sortHandler);
 
        dataProvider.addDataDisplay(dataGrid);
        
        botonEliminar = new Button("Eliminar MaterialCostruccion");
   //     botonRefresh = new Button("Refresh Datos");
        pager.setVisible(true);
        dataGrid.setVisible(true);
        botonEliminar.setVisible(true);
        dock.add(dataGrid, DockPanel.CENTER);
        dock.add(pager, DockPanel.SOUTH);
        dock.setWidth("100%");
        dock.setCellWidth(dataGrid, "100%");
        dock.setCellWidth(pager, "100%");
     //   dock.add(botonRefresh,DockPanel.EAST);
        dock.add(botonEliminar,DockPanel.EAST);
        botonEliminar.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
              // Elimina los parametros.
            	Set<T> lista = selectionModel.getSelectedSet();
            	iter = (Iterator<T>) lista.iterator();
        			while (iter.hasNext()){
        			objectoEliminado = iter.next();	
        			loginService.Eliminar_MaterialCostruccion(((AuxMaterialCostruccion)objectoEliminado).getIdMaterialConstruccion(), new AsyncCallback<Long>() {
        				
        				@Override
        				public void onSuccess(Long result) {
                			System.out.println("Eliminado: " + result);
                			dataProvider.getList().remove(objectoEliminado);

        				}
        				
        				@Override
        				public void onFailure(Throwable caught) {
        					System.out.println(caught);
        					
        				}
        			});
        			}
        			
	
            }
          });
     /*   botonRefresh.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
              // Refresca el datagrid
	
        			loginService.ConsultaTodosMaterialCostruccion(new AsyncCallback<List<AuxMaterialCostruccion>>() {
        				
        				@Override
        				public void onSuccess(List result) {
                			ActualizarList();
                			setDataList(result);
        				}
        				
        				@Override
        				public void onFailure(Throwable caught) {
        					System.out.println(caught);
        					
        				}
        			});
        			}
        	});*/
    }
 
    public void setEmptyTableWidget() {
        dataGrid.setEmptyTableWidget(new HTML(
                "La actual solicitud ha sobrepasado el limiete de tiempo. Porfavor prueba de nuevo."));
    }
 
    /**
     * 
     * Metodo Abstracto para implementar la acciónde agregar columnas al datagrid
     * 
     * @param dataGrid
     * @param sortHandler
     */
    public abstract void initTableColumns(DataGrid<T> dataGrid,   ListHandler<T> sortHandler);
 
    public String getHeight() {
        return height;
    }
 
    public void setHeight(String height) {
        this.height = height;
        dataGrid.setHeight(height);
    }
 
    public List<T> getDataList() {
        return dataList;
    }
 
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        List<T> list = dataProvider.getList();
        list.addAll(this.dataList);
        dataProvider.refresh();
    }
    public void ActualizarList() {
    	System.out.println("Limpiar ");
		dataProvider.getList().clear();
    }
 
    public ListDataProvider<T> getDataProvider() {
        return dataProvider;
    }
 
    public void setDataProvider(ListDataProvider<T> dataProvider) {
        this.dataProvider = dataProvider;
    }
 
    public interface TablaResources extends DataGrid.Resources {
    	  interface Style extends DataGrid.Style { }

    	  @Source(value = {DataGrid.Style.DEFAULT_CSS, "DataGrid2.css"})
    	  public Style dataGridStyle();
    }
}
