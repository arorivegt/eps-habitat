package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.habitatguate.hgerp.seguridad.client.api.SqlService;
import org.habitatguate.hgerp.seguridad.client.api.SqlServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxAfiliado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxMaterialCostruccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxParametro;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.FormPanel;


public class Buscador_Proveedor extends Composite{
	private final SqlServiceAsync loginService = GWT.create(SqlService.class);
    TablaGWT_Proveedor e = null;
    Formulario_PopUpProveedorInactivo formInactivo;
    Formulario_PopUpProveedorConvenio formConvenio;
    Formulario_NombresConvenio formNombres;
	
    Timer timer2 = new Timer(){
  	  public void run() {
		/*	loginService.ConsultaTodosMaterialCostruccion(new AsyncCallback<List<AuxMaterialCostruccion>>() {
        		
        		@Override
        		public void onSuccess(List<AuxMaterialCostruccion> result) {
        			e.ActulizarList(result);      			
        			
        			
        		}
        		
        		@Override
        		public void onFailure(Throwable caught) {
        			System.out.println(caught);
        			
        		}
        	});*/

  	  }
    };
	public Buscador_Proveedor(){
	final Grid grid = new Grid(2, 2);
	initWidget(grid);
	grid.setWidth("1278px");
	
	//------------------------------primera fila

	
	AbsolutePanel absolutePanel = new AbsolutePanel();
	grid.setWidget(0, 0, absolutePanel);
	absolutePanel.setSize("1289px", "70px");
	absolutePanel.setStyleName("gwt-Label-new");
	
	
	Button button = new Button("Send");
	

	button.setText("Imprimir Información Proveedor");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 649, -1);
	button.setSize("214px", "40px");
	
	Button button_1 = new Button("Send");
	button_1.setText("Cambiar Inactivo");
	button_1.setStyleName("finanButton");
	absolutePanel.add(button_1, 1109, -1);
	button_1.setSize("214px", "40px");
	
	Button button_2 = new Button("Send");
	button_2.setText("Subir Convenio Aprobado");
	button_2.setStyleName("finanButton");
	absolutePanel.add(button_2, 876, -1);
	button_2.setSize("214px", "40px");
	
	Button button_3 = new Button("Send");
	button_3.setText("Ver RTU ");
	button_3.setStyleName("finanButton");
	absolutePanel.add(button_3, 876, 45);
	button_3.setSize("214px", "40px");
	
	Button button_4 = new Button("Send");
	button_4.setText("Ver Convenio Aprobado");
	button_4.setStyleName("finanButton");
	absolutePanel.add(button_4, 1109, 45);
	button_4.setSize("214px", "40px");
	
	final ListBox comboBox = new ListBox();
	absolutePanel.add(comboBox, 10, 27);
	comboBox.setSize("216px", "26px");
	
	final ListBox listBox = new ListBox();
	absolutePanel.add(listBox, 10, 79);
	listBox.setSize("216px", "26px");
	listBox.addItem("[Todos los Tipos]", "0");
	listBox.addItem("Material de Construcción", "1");
	listBox.addItem("Mano de Obra", "2");
	listBox.addItem("Activos Fijos", "3");
	listBox.addItem("Suministro de Oficina", "4");
	
	final ListBox listBox_1 = new ListBox();
	absolutePanel.add(listBox_1, 271, 27);
	listBox_1.setSize("216px", "26px");
	listBox_1.addItem("[Todos los estados]", "0");
	listBox_1.addItem("Aprobado", "true");
	listBox_1.addItem("Sin Aprobar", "false");
	
	Label lblAfiliado = new Label("Afiliado");
	lblAfiliado.setStyleName("label");
	absolutePanel.add(lblAfiliado, 10, 2);
	lblAfiliado.setSize("168px", "19px");
	
	Label lblTipoProveedor = new Label("Tipo Proveedor");
	lblTipoProveedor.setStyleName("label");
	absolutePanel.add(lblTipoProveedor, 10, 59);
	lblTipoProveedor.setSize("168px", "19px");
	
	Label lblEstado = new Label("Estado");
	lblEstado.setStyleName("label");
	absolutePanel.add(lblEstado, 270, 2);
	lblEstado.setSize("168px", "19px");
	
	Button button_5 = new Button("Send");
	button_5.setText("Exportar Información a excel");
	button_5.setStyleName("finanButton");
	absolutePanel.add(button_5, 649, 45);
	button_5.setSize("214px", "40px");
	
	final FormPanel formPanel = new FormPanel();
	formPanel.setMethod(FormPanel.METHOD_POST);
	formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
	absolutePanel.add(formPanel, 434, 59);
	formPanel.setSize("209px", "44px");
	
	
	
	button.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			Long idProveedor = total.get(0).getIdProveedor();
			Long idAfiliado = total.get(0).getAuxAfiliado().getIdAfiliado();
			formNombres = new Formulario_NombresConvenio(idProveedor, idAfiliado);
			//Window.open("/FinanInformacionProveedorPDF?idProveedor="+idProveedor, "_blank", "");
			
			
		}
	});
	
	button_1.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			final List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			Long idProveedor = total.get(0).getIdProveedor();
			Long idAfiliado = total.get(0).getAuxAfiliado().getIdAfiliado();
			
			if (!total.isEmpty()){
				formInactivo = new Formulario_PopUpProveedorInactivo(idProveedor,idAfiliado);
			}else{
				Window.alert("Debes de Seleccionar una Solucion");
			}
			
			
		}
	});
	
	button_2.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			final List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			Long idProveedor = total.get(0).getIdProveedor();
			Long idAfiliado = total.get(0).getAuxAfiliado().getIdAfiliado();
			
			if (!total.isEmpty()){
				formConvenio = new Formulario_PopUpProveedorConvenio(idProveedor,idAfiliado);
			}else{
				Window.alert("Debes de Seleccionar una Solucion");
			}
			
			
		}
	});
	
	button_3.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			final List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			String url = total.get(0).getURLFileRTU();
			
			if (!url.equals("")){
				int fin = url.indexOf("type=");
				String urlFinal = url.substring(0, fin-2);
				Window.open(urlFinal, "_blank", "");
				
			}else{
				Window.alert("El proveedor no tiene ingresado el RTU");
			}
			
			
		}
	});
	
	button_4.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			final List<AuxProveedor> total= new ArrayList<AuxProveedor>(e.grid.selectionModel.getSelectedSet());
			String url = total.get(0).getURLFileConvenio();
			
			if (!url.equals("")){
				int fin = url.indexOf("type=");
				String urlFinal = url.substring(0, fin-2);
				Window.open(urlFinal, "_blank", "");
			}else{
				Window.alert("El proveedor aun no tiene convenio subido");
			}
			
			
		}
	});
	
	button_5.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
			String afiliado = comboBox.getValue(comboBox.getSelectedIndex());
			String tipo = listBox.getValue(listBox.getSelectedIndex());
			String estado = listBox_1.getValue(listBox_1.getSelectedIndex());
			
			System.out.println("afiliado "+ afiliado+ " tipo "+ tipo + " estado "+ estado );
			
			formPanel.setAction("/ExportDatosProv?idAfiliado="+afiliado+"&estado="+estado+"&tipo="+tipo);
			formPanel.submit();
			
			
			
		}
	});
			
		//-----------------------------	---------------------------------
	
/*	Image image = new Image("images/ico-lupa.png");
	absolutePanel.add(image, 958, 0);
	image.setSize("103px", "21px");*/
	
	
	
/*	Button button = new Button("Send");
	button.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			e.grid.EliminarFila();
			e.grid.ActualizarTabla();
		}
	});		

	button.setText("Eliminar Proveedor");
	button.setStyleName("finanButton");
	absolutePanel.add(button, 914, 28);
	button.setSize("160px", "27px");*/
	
	loginService.ConsultaTodosProveedor_PorAfiliadoAprobados(0L,new AsyncCallback<List<AuxProveedor>>() {
		
		@Override
		public void onSuccess(List<AuxProveedor> result) {
			System.out.println("ya estan todos los afiliados");
			e = new TablaGWT_Proveedor(result);
			grid.setWidget(1, 0,e);
			e.setSize("700px", "300px"); 			
			
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			System.out.println(caught);
			
		}
	});
	
	
	loginService.ConsultaTodosAfiliados(new AsyncCallback<List<AuxAfiliado>>(){
	    public void onFailure(Throwable caught) 
	    {
	    }
	
		@Override
	    public void onSuccess(List<AuxAfiliado> result)
	    {
			if (!(result.size()==0)) {
				 comboBox.addItem("Todos los afiliados","0");
				 for (AuxAfiliado p : result) 
				    {
				    	comboBox.addItem(p.getNomAfiliado(),""+p.getIdAfiliado());
				    }
	    	}
			
	    }
	});
	

	
   
}
}
