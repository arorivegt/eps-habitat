package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetallePlantillaSolucion;
import org.habitatguate.hgerp.seguridad.client.finanzas.PagingDataGrid_MaterialCostruccion.TablaResources;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
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
public abstract class PagingDataGrid_PlantillaSolucion<T> extends Composite {
 
    public DataGrid<T> dataGrid;
    private SimplePager pager;
    private String height;
    private ListDataProvider<T> dataProvider;
    private List<T> dataList;
    private DockPanel dock = new DockPanel();
	//private Button botonEliminar;
    final MultiSelectionModel<T> selectionModel =
            new MultiSelectionModel<T>((ProvidesKey<T>)AuxDetallePlantillaSolucion.KEY_PROVIDER);
    private final SqlServiceAsync loginService = GWT.create(SqlService.class);
	Iterator<T> iter = null;
	T objectoEliminado = null;
    public PagingDataGrid_PlantillaSolucion() {
        initWidget(dock);
        dataGrid = new DataGrid<T>(30,
                GWT.<TablaResources> create(TablaResources.class));
    //    dataGrid.setWidth("100%");
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
        
        //botonEliminar = new Button("Eliminar Fila");
        
        pager.setVisible(true);
        dataGrid.setVisible(true);
       // botonEliminar.setVisible(true);
        dock.add(dataGrid, DockPanel.CENTER);
        dock.add(pager, DockPanel.SOUTH);
        dock.setWidth("100%");
        dock.setCellWidth(dataGrid, "100%");
        dock.setCellWidth(pager, "100%");
        


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
    
    public void NuevoMaterial(AuxDetallePlantillaSolucion nuevo){

    	dataProvider.getList().add((T) nuevo);
    }
    
    public List<T> getListMateriales(){
    	return this.dataProvider.getList();
    }
    
    
    public void EliminarFila(){
    	Set<T> lista = selectionModel.getSelectedSet();
    	iter = (Iterator<T>) lista.iterator();
			while (iter.hasNext()){
					objectoEliminado = iter.next();	
         			dataProvider.getList().remove(objectoEliminado);

			}
    }
    
    public Double ActualizarTabla(){
    	Double total = 0.0;
    	Iterator<T> lista = dataProvider.getList().iterator();
    		while (lista.hasNext()){
    				AuxDetallePlantillaSolucion aux = (AuxDetallePlantillaSolucion)lista.next();
    				total = total + aux.getSubTotal();
    				aux.setCostoAcumulado(total);
    		}
    		dataProvider.refresh();
    	return total;
    }
 
}
