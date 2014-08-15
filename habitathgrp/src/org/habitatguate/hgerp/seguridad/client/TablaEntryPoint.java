package org.habitatguate.hgerp.seguridad.client;


import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

public class TablaEntryPoint extends Composite implements EntryPoint{
    private final DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
    private SelectionModel<AuxParametro> sm = new MultiSelectionModel<AuxParametro>(AuxParametro.KEY_PROVIDER);
 /*   {
    	
    	       Añade un objeto que recibe notificaciones cuando cambia la selección. 
    	      sm.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
    	        @Override
    	        public void onSelectionChange(SelectionChangeEvent event) {
    	          AuxParametro c = sm.getSelectedObject();
    	          if (c != null) {
    	            Window.alert(c.getNomParametro());
    	          }
    	        }
    	      });
    	
    }*/
    /** La tabla trabaja por páginas. En este caso la longitud de página se pasa en el
     * constructor. También hay un constructor sin parámetros que define una longitud
     * por defecto de 15 renglones por página. */
    private final CellTable<AuxParametro> tblConocidos = new CellTable<AuxParametro>(10);
    {
      // asigna el objeto que controla las selecciones.
    
    tblConocidos.setSelectionModel(sm, DefaultSelectionEventManager
            .<AuxParametro> createCheckboxManager());
      // Agrega columnas.
    Column<AuxParametro, Boolean> checkColumn = new Column<AuxParametro, Boolean>(
            new CheckboxCell(true, false)) {
          @Override
          public Boolean getValue(AuxParametro object) {
            // Get the value from the selection model.
            return sm.isSelected(object);
          }
        };
        tblConocidos.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
        tblConocidos.setColumnWidth(checkColumn, 40, Unit.PX);
      // Columna numérica. El constructor de "NumberCell"puede recibir un"NumberFormat".
      tblConocidos.addColumn(new Column<AuxParametro, Number>(new NumberCell()) {
        {
          setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
        }
        @Override
        public Long getValue(final AuxParametro objeto) {
          return objeto.getIdParametro();
        }
      }, "ID Unico");
      // Columna de texto fijo con encabezado y pie de página.
      tblConocidos.addColumn(new TextColumn<AuxParametro>() {
        @Override
        public String getValue(final AuxParametro objeto) {
          return objeto.getNomParametro();
        }
      }, "Nombre Parametro");
      /* Columna modificable. El método "update" de la interfaz "FieldUpdater" recibe
       * los cambios a un objeto de la columna. */
      tblConocidos.addColumn(new Column<AuxParametro,String>(new TextInputCell()) {
        {
          /* Asigna la referencia al objeto que recibe las notificaciones de cambio. */
          setFieldUpdater(new FieldUpdater<AuxParametro, String>() {
            @Override
            public void update(int index, AuxParametro objeto, String valor) {
              objeto.setCodContable(Integer.parseInt(valor));
            }
          });
        }
        @Override
        public String getValue(final AuxParametro objeto) {
          return String.valueOf(objeto.getCodContable());
        }
      }, "Codigo Contable");
      // Columna de fecha.
      tblConocidos.addColumn(new Column<AuxParametro, Number>(new NumberCell()) {
        @Override
        public Integer getValue(final AuxParametro objeto) {
          return objeto.getCodUno();
       }
     }, "Codigo Uno");
      // Columna de fecha.
      tblConocidos.addColumn(new Column<AuxParametro, Number>(new NumberCell()) {
        @Override
        public Integer getValue(final AuxParametro objeto) {
          return objeto.getCodDos();
       }
     }, "Codigo Dos");
      

   }

    private final SimplePager pager = new SimplePager();
    {
      pager.setDisplay(tblConocidos);
    }

    public TablaEntryPoint(List<AuxParametro> tabla) {
    	ListDataProvider<AuxParametro> dataProvider = new ListDataProvider<AuxParametro>(tabla);
        dataProvider.addDataDisplay(tblConocidos);
        FlowPanel panel = new FlowPanel();
        panel.add(new Label("Seleccione un contacto o edite su teléfono."));
        panel.add(tblConocidos);
        panel.add(pager);
        initWidget(panel);
      }
      public void onModuleLoad() {
        RootPanel.get().add(this);
      }
    
}
