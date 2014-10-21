package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;


public class formularioSalario extends Composite {

	private salario a;
	private Empleados empleado;
	private Long id_salario = 0L;
	private boolean bandera = true;
	private Mensaje mensaje; 
	private AbsolutePanel absolutePanel;
	private TextBox txtSalario;
	private Button btnActualizar ;
	private TextBox txtTipoSalario;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private TextArea txtDescipcion;
    private Label label;
    private ListBox listAnio;
    private Label lblAo;

	public formularioSalario(salario a,Empleados e, String tipoSalario) {

		txtTipoSalario.setText(tipoSalario);
		mensaje = new Mensaje();
		this.empleado = e;
		this.a = a;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("595px", "126px");

		btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera) {
					loginService.Insertar_Salario(empleado.id_empleado, listAnio.getItemText(listAnio.getSelectedIndex()) ,
							Float.parseFloat(txtSalario.getText()), txtTipoSalario.getText(), txtDescipcion.getText(),
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
					loginService.Actualizar_Salario(empleado.id_empleado,id_salario,  listAnio.getItemText(listAnio.getSelectedIndex()) ,
							Float.parseFloat(txtSalario.getText()), txtTipoSalario.getText(),txtDescipcion.getText(),new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Actualizar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
		                			"Datos Actualizados\n exitosamente!!!");
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
                    			"Error !! \nBonificacion no valido");
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
		
		txtTipoSalario = new TextBox();
		txtTipoSalario.setEnabled(false);
		txtTipoSalario.setReadOnly(true);
		txtTipoSalario.setStylePrimaryName("gwt-TextBox2");
		txtTipoSalario.setStyleName("gwt-TextBox2");
		txtTipoSalario.setMaxLength(100);
		absolutePanel.add(txtTipoSalario, 10, 90);
		txtTipoSalario.setSize("134px", "34px");
		
		txtDescipcion = new TextArea();
		txtDescipcion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtDescipcion, 166, 27);
		txtDescipcion.setSize("327px", "95px");
		
		listAnio = new ListBox();
		listAnio.addItem("2014");
		listAnio.addItem("2015");
		listAnio.addItem("2016");
		listAnio.addItem("2017");
		listAnio.addItem("2018");
		listAnio.addItem("2019");
		listAnio.addItem("2020");
		listAnio.addItem("2021");
		listAnio.addItem("2022");
		listAnio.addItem("2023");
		listAnio.addItem("2024");
		listAnio.addItem("2025");
		listAnio.addItem("2026");
		listAnio.addItem("2027");
		listAnio.addItem("2028");
		listAnio.addItem("2029");
		listAnio.addItem("2030");
		listAnio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listAnio, 516, 27);
		listAnio.setSize("115px", "36px");
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 516, 90);
		btnActualizar.setSize("115px", "34px");
		
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
	
	public void LlenarDatos(Long id, String txtSalario, String anio,
				String txtTipoSalario, String Descripcion)
	{

		this.id_salario = id;
		this.bandera = false;
		this.txtSalario.setText(txtSalario);
		this.txtTipoSalario.setText(txtTipoSalario);
		this.txtDescipcion.setText(Descripcion);
		
		boolean bandera = true;
		for(int i=0; i < this.listAnio.getItemCount() && bandera; i++){
			bandera = !this.listAnio.getItemText(i).equals(anio);
		    this.listAnio.setSelectedIndex(i);
		}
	}
	
	

}
