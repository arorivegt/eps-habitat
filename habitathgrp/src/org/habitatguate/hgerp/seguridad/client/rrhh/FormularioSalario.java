/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;


public class FormularioSalario extends Composite {

	private Salario salario;
	private Empleados empleado;
	private Mensaje mensaje; 
    private Label label;
    private DateBox fecha;
    private Label lblAo;
    private Loading load ;
	private TextBox txtSalario;
	private Button btnEliminar;
	private Long id_salario = 0L;
	private boolean bandera = true;
	private Button btnActualizar;
	private ListBox txtTipoSalario;
    private TextArea txtDescipcion;
	private AbsolutePanel absolutePanel;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);

	public FormularioSalario(Salario salari,Empleados emplead) {

		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.empleado = emplead;
		this.salario = salari;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("795px", "126px");

		btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				try{
					new Date(fecha.getValue().getTime());
				}catch(Exception e){
					fecha.setValue(new Date());
				}
				if(bandera) {
					loginService.Insertar_Salario(empleado.id_empleado, fecha.getValue(),
							Float.parseFloat(txtSalario.getText()), txtTipoSalario.getValue(txtTipoSalario.getSelectedIndex()), txtDescipcion.getText(),
							new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
					        load.invisible();
							id_salario = result;
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        }
						});
				}else{
					loginService.Actualizar_Salario(empleado.id_empleado,id_salario,  fecha.getValue(),
							Float.parseFloat(txtSalario.getText()), txtTipoSalario.getValue(txtTipoSalario.getSelectedIndex()),txtDescipcion.getText(),new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", "Error !! \nal Actualizar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
					        load.invisible();
							bandera = false;
							mensaje.setMensaje("alert alert-success", "Datos Actualizados\n exitosamente!!!");
                        }
						});
				}
		        load.invisible();
			}
		});
		
		txtSalario = new TextBox();
		txtSalario.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalario.getText().equals("")) {txtSalario.setText("0.0");}
				else if(txtSalario.getText().equals(null)) {txtSalario.setText("0.0");}
				else{
					try{
						Float.parseFloat(txtSalario.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nSalario no valido");
						txtSalario.setText("0.0");
					}
				}
			}
		});
		txtSalario.setText("0.0");
		txtSalario.setStylePrimaryName("gwt-TextBox2");
		txtSalario.setStyleName("gwt-TextBox2");
		txtSalario.setMaxLength(100);
		absolutePanel.add(txtSalario, 10, 27);
		txtSalario.setSize("184px", "34px");
		
		txtTipoSalario = new ListBox();
		txtTipoSalario.addItem("Salario Base", "0");
		txtTipoSalario.addItem("Decreto(78-89)", "1");
		txtTipoSalario.addItem("Comisiones", "2");
		txtTipoSalario.addItem("Bonificacion", "3");
		txtTipoSalario.addItem("Bono 14", "4");
		txtTipoSalario.addItem("Aguinaldo", "5");
		txtTipoSalario.addItem("Vacaciones", "6");
		txtTipoSalario.addItem("Indemnizacion", "7");
		txtTipoSalario.addItem("Otros pagos", "8");
		txtTipoSalario.setStylePrimaryName("gwt-TextBox2");
		txtTipoSalario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTipoSalario, 10, 90);
		txtTipoSalario.setSize("186px", "34px");
		
		txtDescipcion = new TextArea();
		txtDescipcion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDescipcion, 247, 20);
		txtDescipcion.setSize("327px", "100px");
		

		fecha = new DateBox();
		fecha.getTextBox().setReadOnly(true);
		fecha.setValue(new Date());
		fecha.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		fecha.getDatePicker().setYearArrowsVisible(true);
		fecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		fecha.getDatePicker().setVisibleYearCount(100);
		fecha.setStyleName("gwt-PasswordTextBox");
		fecha.setSize("113px", "41px");
		absolutePanel.add(fecha, 607, 20);
		
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 740, 27);
		btnActualizar.setSize("115px", "34px");
		
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormularioSinDatos();
				}else{
			        load.invisible();
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 740, 90);
		btnEliminar.setSize("115px", "34px");
		
		Label lblTitulodiploma = new Label("");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 146, 8);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblSalario = new Label("Monto");
		lblSalario.setStyleName("label");
		absolutePanel.add(lblSalario, 12, 8);
		lblSalario.setSize("113px", "13px");
		
		Label lblTipoSalario = new Label("Tipo Salario");
		lblTipoSalario.setStyleName("label");
		absolutePanel.add(lblTipoSalario, 12, 71);
		lblTipoSalario.setSize("113px", "13px");
		
		label = new Label("Descripcion");
		label.setStyleName("label");
		absolutePanel.add(label, 247, 3);
		label.setSize("192px", "13px");
		
		lblAo = new Label("Fecha Creacion");
		lblAo.setStyleName("label");
		absolutePanel.add(lblAo, 607, 3);
		lblAo.setSize("139px", "13px");
		
		
	}
	
	private void EliminarFormulario(){
        salario.EliminarFormulario(this,empleado.id_empleado,id_salario);
    }
	private void EliminarFormularioSinDatos(){
		salario.EliminarFormulario(this);
    }
	
	public void LlenarDatos(Long id, String txtSalario, Long fecha,
				String txtTipoSalario, String Descripcion)
	{

		this.id_salario = id;
		this.bandera = false;
		this.txtSalario.setText(txtSalario);
		boolean bandera = true;
		for(int i=0; i < this.txtTipoSalario.getItemCount() && bandera; i++){
			bandera = !this.txtTipoSalario.getValue(i).equals(txtTipoSalario);
		    this.txtTipoSalario.setSelectedIndex(i);
		}
		this.txtDescipcion.setText(Descripcion);
		this.fecha.setValue(new Date(fecha));
	}
	
	

}
