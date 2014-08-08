
package org.habitatguate.hgerp.seguridad.client;
  
  import com.google.gwt.cell.client.DateCell;
  import com.google.gwt.cell.client.FieldUpdater;
  import com.google.gwt.cell.client.NumberCell;
  import com.google.gwt.cell.client.TextInputCell;
  import com.google.gwt.core.client.EntryPoint;
  import com.google.gwt.i18n.client.DateTimeFormat;
  import com.google.gwt.user.cellview.client.CellTable;
  import com.google.gwt.user.cellview.client.Column;
  import com.google.gwt.user.cellview.client.SimplePager;
  import com.google.gwt.user.cellview.client.TextColumn;
  import com.google.gwt.user.client.Window;
  import com.google.gwt.user.client.ui.Composite;
  import com.google.gwt.user.client.ui.FlowPanel;
  import com.google.gwt.user.client.ui.HasAlignment;
  import com.google.gwt.user.client.ui.Label;
  import com.google.gwt.user.client.ui.RootPanel;
  import com.google.gwt.view.client.ListDataProvider;
  import com.google.gwt.view.client.SelectionChangeEvent;
  import com.google.gwt.view.client.SingleSelectionModel;
  import java.util.ArrayList;
 import java.util.Arrays;
  import java.util.Date;
  
  /** Ejemplo de areas de texto. */
  public class TablasEntryPoint extends Composite implements EntryPoint {
    private final DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
    /** Modelo de selección. Permite detectar selecciones en la tabla. */
    private SingleSelectionModel<Contacto> sm =
        new SingleSelectionModel<Contacto>();
    {
      /* Añade un objeto que recibe notificaciones cuando cambia la selección. */
      sm.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
        @Override
        public void onSelectionChange(SelectionChangeEvent event) {
          Contacto c = sm.getSelectedObject();
          if (c != null) {
            Window.alert(c.getNombre());
          }
        }
      });
    }
    /** La tabla trabaja por páginas. En este caso la longitud de página se pasa en el
     * constructor. También hay un constructor sin parámetros que define una longitud
     * por defecto de 15 renglones por página. */
    private final CellTable<Contacto> tblConocidos = new CellTable<Contacto>(5);
    {
      // asigna el objeto que controla las selecciones.
      tblConocidos.setSelectionModel(sm);
      // Agrega columnas.
      // Columna numérica. El constructor de "NumberCell"puede recibir un"NumberFormat".
      tblConocidos.addColumn(new Column<Contacto, Number>(new NumberCell()) {
        {
          setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
        }
        @Override
        public Integer getValue(final Contacto objeto) {
          return objeto.getClave();
        }
      }, "Clave");
      // Columna de texto fijo con encabezado y pie de página.
      tblConocidos.addColumn(new TextColumn<Contacto>() {
        @Override
        public String getValue(final Contacto objeto) {
          return objeto.getNombre();
        }
      }, "Nombre", "Nombre");
      /* Columna modificable. El método "update" de la interfaz "FieldUpdater" recibe
       * los cambios a un objeto de la columna. */
      tblConocidos.addColumn(new Column<Contacto, String>(new TextInputCell()) {
        {
          /* Asigna la referencia al objeto que recibe las notificaciones de cambio. */
          setFieldUpdater(new FieldUpdater<Contacto, String>() {
            @Override
            public void update(int index, Contacto objeto, String valor) {
              objeto.setTelefono(valor);
            }
          });
        }
        @Override
        public String getValue(final Contacto objeto) {
          return objeto.getTelefono();
        }
      }, "Teléfono", "Teléfono");
      // Columna de fecha.
      tblConocidos.addColumn(new Column<Contacto, Date>(new DateCell(fmt)) {
        @Override
        public Date getValue(final Contacto objeto) {
          return objeto.getNacimiento();
       }
     }, "Nacimiento");
   }
   private final SimplePager pager = new SimplePager();
   {
     pager.setDisplay(tblConocidos);
   }
   public TablasEntryPoint() {
     ListDataProvider<Contacto> dataProvider = new ListDataProvider<Contacto>(
         new ArrayList<Contacto>(Arrays.asList(
         new Contacto(1, "Amanda Zapata", "567892", fmt.parse("07/01/1990")),
         new Contacto(2, "Zoila Vaca", "01-800-MUUU", fmt.parse("30/04/1992")),
         new Contacto(3, "Rolando Mota", "222222222", fmt.parse("07/28/1991")),
         new Contacto(4, "Petra Ansas", "544445555555", fmt.parse("14/02/1989")),
         new Contacto(5, "Mónica Galindo", "55555555555", fmt.parse("13/11/1980")),
         new Contacto(6, "Alma Madero", "556666555555", fmt.parse("10/07/1978")),
         new Contacto(7, "Esteban Dido", "55555577755", fmt.parse("10/09/1985")),
         new Contacto(8, "Érika Galindo", "55555555555", fmt.parse("03/05/1985")),
         new Contacto(9, "Estela Pérez Sosa", "52222555555", fmt.parse("23/05/1986")),
         new Contacto(10, "Félix de la Colina", "5555533335", fmt.parse("04/14/1983")),
         new Contacto(11, "John Carter Ista", "5555534565", fmt.parse("18/01/1989")),
         new Contacto(12, "Estela Raya", "5123555555", fmt.parse("21/02/1981")),
         new Contacto(13, "Camila Rosas", "5552345555", fmt.parse("19/03/1982")))));
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