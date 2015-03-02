package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;

public class FormularioPermiso extends Composite {

	private Permiso a;
	private Empleado empleado;
	private Long id_vacaciones = 0L;
	private boolean bandera = true;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
    private TextArea txtDescripcion;
    private DateBox dateFecha1;
    private DateBox dateFecha2;
	private Mensaje mensaje; 
	private ListBox listTipoPermiso ;
    private Loading load ;
    private Button btnImprimir;
    
	public FormularioPermiso(Permiso a,Empleado e) {

		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("773px", "170px");
		
		dateFecha1 = new DateBox();
		dateFecha1.getTextBox().setReadOnly(true);
		dateFecha1.setValue(new Date());
		dateFecha1.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha1.getDatePicker().setYearArrowsVisible(true);
		dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha1.getDatePicker().setVisibleYearCount(100);
		dateFecha1.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha1, 10, 29);
		dateFecha1.setSize("89px", "34px");
		
		dateFecha2 = new DateBox();
		dateFecha2.getTextBox().setReadOnly(true);
		dateFecha2.setValue(new Date());
		dateFecha2.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha2.getDatePicker().setYearArrowsVisible(true);
		dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha2.getDatePicker().setVisibleYearCount(100);
		dateFecha2.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha2, 117, 29);
		dateFecha2.setSize("89px", "34px");
		
		txtDescripcion = new TextArea();
		txtDescripcion.getElement().setAttribute("maxlength", "1000");
		
		listTipoPermiso = new ListBox();
		listTipoPermiso.addItem("Vacaciones con goce salaria","0");
		listTipoPermiso.addItem("Vacaciones sin goce salaria","1");
		listTipoPermiso.addItem("Permiso con goce salarial","2");
		listTipoPermiso.addItem("Permiso sin goce salarial","3");
		listTipoPermiso.addItem("Suspension con goce salarial","4");
		listTipoPermiso.addItem("Suspension sin goce salarial","5");
		listTipoPermiso.addItem("Ausencia con goce salarial","6");
		listTipoPermiso.addItem("Ausencia sin goce salarial","7");
		listTipoPermiso.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTipoPermiso, 226, 29);
		listTipoPermiso.setSize("221px", "36px");
		txtDescripcion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDescripcion, 10, 106);
		txtDescripcion.setSize("433px", "95px");
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        int dias			= (int) ((dateFecha2.getValue().getTime()-dateFecha1.getValue().getTime())/(1000*60*60*24)); 
		        
		        load.visible();

				try{
					new Date(dateFecha1.getValue().getTime());
				}catch(Exception e){
					dateFecha1.setValue(new Date(1407518124684L));
				}
				try{
					new Date(dateFecha2.getValue().getTime());
				}catch(Exception e){
					dateFecha2.setValue(new Date(1407518124684L));
				}
			
				if(dias  <=  26 && dias >= 1){
					
				
					if(bandera) {
						loginService.Insertar_Solicitud_Permiso(empleado.id_empleado, dateFecha1.getValue(), 
								dateFecha2.getValue(), txtDescripcion.getText(),listTipoPermiso.getValue(listTipoPermiso.getSelectedIndex()), new AsyncCallback<String>(){
	                        public void onFailure(Throwable caught) 
	                        {
	            		        load.invisible();
	                        	mensaje.setMensaje("alert alert-error", "Error !! \nal Guardar Datos");
	                        }
	
							@Override
	                        public void onSuccess(String result)
	                        {
						        load.invisible();
								bandera = false;
								mensaje.setMensaje("alert alert-success", result);
	                        }
							});
					}else{
						mensaje.setMensaje("alert alert-information alert-block", "Ya ha sido solicitado este permiso");
					}
						
			      }else{
						mensaje.setMensaje("alert alert-information alert-block"
								, "La solicitud de dias debe ser mayor a 0 dias \n o menor igual a 26 dias para  permiso/vacaciones");
			    	  
			      }
		        load.invisible();
			}
		});
		btnActualizar.setText("Solicitar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 580, 48);
		btnActualizar.setSize("114px", "34px");
		
		btnImprimir = new Button("Send");
		btnImprimir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.open("/ImprimirConstanciaPermiso?abracadabra="+empleado.id_empleado+"&abracadabra2="+id_vacaciones, "_blank", ""); 
			}
		});
		btnImprimir.setText("Imprimir");
		btnImprimir.setStylePrimaryName("sendButton");
		btnImprimir.setStyleName("sendButton");
		absolutePanel.add(btnImprimir, 580, 125);
		btnImprimir.setSize("114px", "34px");
		
		Label lblNivelAcademico = new Label("Fecha Inicial");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblMotivo = new Label("Descripcion");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 87);
		lblMotivo.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Fecha Final");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 119, 10);
		lblLoRecomienda.setSize("103px", "13px");
		
		Label lblTipoDePermiso = new Label("Tipo de Permiso");
		lblTipoDePermiso.setStyleName("label");
		absolutePanel.add(lblTipoDePermiso, 228, 10);
		lblTipoDePermiso.setSize("139px", "13px");

		btnImprimir.setVisible(false);
	}
	public void LlenarDatos(Long id, String txtDescripcion,
		    Long dateFecha1,
		    Long dateFecha2,
		    String tipoPermiso)
	{
		boolean bandera = true;
		for(int i=0; i < this.listTipoPermiso.getItemCount() && bandera; i++){
			bandera = !this.listTipoPermiso.getValue(i).equals(tipoPermiso);
		    this.listTipoPermiso.setSelectedIndex(i);
		}
		this.id_vacaciones = id;
		this.bandera = false;
		btnImprimir.setVisible(true);
		this.txtDescripcion.setText(txtDescripcion);
		this.dateFecha1.setValue(new Date(dateFecha1));
		this.dateFecha2.setValue(new Date(dateFecha2));
	}
	
}
