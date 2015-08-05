package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolucion;
import org.habitatguate.hgerp.seguridad.client.finanzas.PagingDataGrid_MaterialCostruccion.TablaResources;

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
public abstract class PagingDataGrid_SolucionGeneral<T> extends Composite {
 
    private DataGrid<T> dataGrid;
    private SimplePager pager;
    private String height;
    private ListDataProvider<T> dataProvider;
    private List<T> dataList;
    private DockPanel dock = new DockPanel();
	private Button botonEliminar;
	//private Button botonRefresh;
    final MultiSelectionModel<T> selectionModel =
            new MultiSelectionModel<T>((ProvidesKey<T>)AuxSolucion.KEY_PROVIDER);
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	Iterator<T> iter = null;
	T objectoEliminado = null;
	

    public PagingDataGrid_SolucionGeneral(List<T> dataList) {
    	this.dataList = dataList;
    	MyPaginationDataGrid_SolucionGeneral.actual = 0;
    	if (!dataList.isEmpty()){
    	MyPaginationDataGrid_SolucionGeneral.cantProduct = ((AuxSolucion)dataList.get(0)).getCostoProducto().size();
    	MyPaginationDataGrid_SolucionGeneral.namesColumns = ((AuxSolucion)dataList.get(0)).getNombreProducto();
    	int plani = ((AuxSolucion)dataList.get(0)).getCostoProductoPlani().size();
    	if (plani > 0){
    		MyPaginationDataGrid_SolucionGeneral.showplani = true;
    	}else{
    		MyPaginationDataGrid_SolucionGeneral.showplani = false;
    	}
    	}
    	
        initWidget(dock);
        dataGrid = new DataGrid<T>(30,
                GWT.<TablaResources> create(TablaResources.class));
        dataGrid.setWidth("100%");

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
        
        List<T> list = dataProvider.getList();
        list.addAll(this.dataList);
        dataProvider.refresh();
        
        initTableColumns(dataGrid, sortHandler);
 
        dataGrid.addColumnSortHandler(sortHandler);
 
        dataProvider.addDataDisplay(dataGrid);
        
       
        pager.setVisible(true);
        dataGrid.setVisible(true);
        dock.add(dataGrid, DockPanel.CENTER);
        dock.add(pager, DockPanel.SOUTH);
        dock.setWidth("100%");
        dock.setCellWidth(dataGrid, "100%");
        dock.setCellWidth(pager, "100%");
      //  dock.add(botonRefresh,DockPanel.EAST);
       
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
    	  @Override
    	    @Source(value = {DataGrid.Style.DEFAULT_CSS, "DataGrid2.css"})
    	    DataGrid.Style dataGridStyle();
      }

    
}
