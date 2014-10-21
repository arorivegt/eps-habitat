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


public class formularioSalario extends Composite {

	private salario salario;
	private Empleados empleado;
	private Long id_salario = 0L;
	private boolean bandera = true;
	private Mensaje mensaje; 
	private AbsolutePanel absolutePanel;
	private TextBox txtSalario;
	private Button btnActualizar ;
	private Button btnEliminar ;
	private ListBox txtTipoSalario;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private TextArea txtDescipcion;
    private Label label;
    private DateBox fecha;
    private Label lblAo;

	public formularioSalario(salario salari,Empleados e) {

		mensaje = new Mensaje();
		this.empleado = e;
		this.salario = salari;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("595px", "126px");

		btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				try{
					new Date(fecha.getValue().getTime());
				}catch(Exception e){
					fecha.setValue(new Date(1407518124684L));
				}
				if(bandera) {
					loginService.Insertar_Salario(empleado.id_empleado, fecha.getValue(),
							Float.parseFloat(txtSalario.getText()), txtTipoSalario.getValue(txtTipoSalario.getSelectedIndex()), txtDescipcion.getText(),
							new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
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
                        	mensaje.setMensaje("alert alert-error", "Error !! \nal Actualizar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							bandera = false;
							mensaje.setMensaje("alert alert-success", "Datos Actualizados\n exitosamente!!!");
                        }
						});
				}
			}
		});
		
		txtSalario = new TextBox();
		txtSalario.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalario.getText().equals("")) {txtSalario.setText("0");}
				else if(txtSalario.getText().equals(null)) {txtSalario.setText("0");}
				else{
					try{
						Float.parseFloat(txtSalario.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nSalario no valido");
						txtSalario.setText("0");
					}
				}
			}
		});
		txtSalario.setText("0.0");
		txtSalario.setStylePrimaryName("gwt-TextBox2");
		txtSalario.setStyleName("gwt-TextBox2");
		txtSalario.setMaxLength(100);
		absolutePanel.add(txtSalario, 10, 27);
		txtSalario.setSize("134px", "34px");
		
		txtTipoSalario = new ListBox();
		txtTipoSalario.addItem("Salario Base", "0");
		txtTipoSalario.addItem("Decreto(78-89)", "1");
		txtTipoSalario.addItem("Comisiones", "2");
		txtTipoSalario.addItem("Otros pagos", "3");
		txtTipoSalario.setStylePrimaryName("gwt-TextBox2");
		txtTipoSalario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTipoSalario, 10, 90);
		txtTipoSalario.setSize("134px", "34px");
		
		txtDescipcion = new TextArea();
		txtDescipcion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDescipcion, 166, 27);
		txtDescipcion.setSize("327px", "95px");
		

		fecha = new DateBox();
		fecha.setValue(new Date(1407518707105L));
		fecha.setFormat(new DateBox.DefaultFormat 
	    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		fecha.getDatePicker().setYearArrowsVisible(true);
		fecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		fecha.getDatePicker().setVisibleYearCount(100);
		fecha.setStyleName("gwt-PasswordTextBox");
		fecha.setSize("228px", "41px");
		absolutePanel.add(fecha, 516, 27);
		
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 516, 90);
		btnActualizar.setSize("115px", "34px");
		
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormularioSinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 550, 90);
		btnEliminar.setSize("115px", "34px");
		
		Label lblTitulodiploma = new Label("");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 146, 8);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblSalario = new Label("Salario");
		lblSalario.setStyleName("label");
		absolutePanel.add(lblSalario, 12, 8);
		lblSalario.setSize("113px", "13px");
		
		Label lblTipoSalario = new Label("Tipo Salario");
		lblTipoSalario.setStyleName("label");
		absolutePanel.add(lblTipoSalario, 12, 71);
		lblTipoSalario.setSize("113px", "13px");
		
		label = new Label("Descripcion");
		label.setStyleName("label");
		absolutePanel.add(label, 166, 8);
		label.setSize("192px", "13px");
		
		lblAo = new Label("Año");
		lblAo.setStyleName("label");
		absolutePanel.add(lblAo, 518, 8);
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
