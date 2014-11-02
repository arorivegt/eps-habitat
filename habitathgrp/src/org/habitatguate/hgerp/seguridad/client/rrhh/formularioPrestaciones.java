package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;


public class formularioPrestaciones  extends Composite  {

	private Mensaje mensaje; 
	private Long idEmpleado = 0L;
	private String codigoSalario;
	private String descripcion;
	private TextBox txtEmpleado ;
	private TextBox txtPromedioSalario;
	private AbsolutePanel absolutePanel ;
    private TextBox txtDiasAnnio;
    private Loading load ;
    private DateBox dateFecha;
    private SimpleCheckBox checkOk;
    private TextBox txtTotal;
    private TextBox txtDiasTrabajados;
	public formularioPrestaciones() {
		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("802px", "35px");
		
		txtEmpleado = new TextBox();
		txtEmpleado.setReadOnly(true);
		txtEmpleado.setMaxLength(100);
		txtEmpleado.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEmpleado, 10, 29);
		txtEmpleado.setSize("198px", "34px");
		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date());
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 216, 29);
		dateFecha.setSize("137px", "34px");
		
		txtPromedioSalario = new TextBox();
		txtPromedioSalario.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPromedioSalario.getText().equals("")) {txtPromedioSalario.setText("0.0");}
				else if(txtPromedioSalario.getText().equals(null)) {txtPromedioSalario.setText("0.0");}
				else{
					try{
						Float.parseFloat(txtPromedioSalario.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nPromedio de salario no valido");
						txtPromedioSalario.setText("0.0");
					}
				}
			}
		});
		txtPromedioSalario.setText("0.0");
		txtPromedioSalario.setMaxLength(100);
		txtPromedioSalario.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPromedioSalario, 371, 29);
		txtPromedioSalario.setSize("94px", "34px");
		
		txtDiasAnnio = new TextBox();
		txtDiasAnnio.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(txtDiasAnnio.getText().equals("")) {txtDiasAnnio.setText("0");}
				else if(txtDiasAnnio.getText().equals(null)) {txtDiasAnnio.setText("0");}
				else{
					try{
						Integer.parseInt(txtDiasAnnio.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nDias No valido");
						txtDiasAnnio.setText("0");
					}
				} 

			}
		});
		txtDiasAnnio.setText("0");
		txtDiasAnnio.setStyleName("gwt-TextBox2");
		txtDiasAnnio.setMaxLength(100);
		absolutePanel.add(txtDiasAnnio, 486, 29);
		txtDiasAnnio.setSize("94px", "34px");
		
		txtDiasTrabajados = new TextBox();
		txtDiasTrabajados.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(txtDiasTrabajados.getText().equals("")) {txtDiasTrabajados.setText("0");}
				else if(txtDiasTrabajados.getText().equals(null)) {txtDiasTrabajados.setText("0");}
				else{
					try{
						Integer.parseInt(txtDiasTrabajados.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nDias trabajado no valido");
						txtDiasTrabajados.setText("0");
					}
				}

			}
		});
		txtDiasTrabajados.setText("0");
		txtDiasTrabajados.setStyleName("gwt-TextBox2");
		txtDiasTrabajados.setMaxLength(100);
		absolutePanel.add(txtDiasTrabajados, 598, 29);
		txtDiasTrabajados.setSize("94px", "34px");
		
		txtTotal = new TextBox();
		txtTotal.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTotal.getText().equals("")) {txtTotal.setText("0.0");}
				else if(txtTotal.getText().equals(null)) {txtTotal.setText("0.0");}
				else{
					try{
						Float.parseFloat(txtTotal.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \total no valido");
						txtTotal.setText("0.0");
					}
				}
			}
		});
		txtTotal.setText("0.0");
		txtTotal.setStyleName("gwt-TextBox2");
		txtTotal.setMaxLength(100);
		absolutePanel.add(txtTotal, 710, 29);
		txtTotal.setSize("94px", "34px");
		
		checkOk = new SimpleCheckBox();
		absolutePanel.add(checkOk, 812, 33);
		
		Label lblEmpleado = new Label("Empleado");
		lblEmpleado.setStyleName("label");
		absolutePanel.add(lblEmpleado, 10, 10);
		lblEmpleado.setSize("157px", "13px");
		
		Label lblPromedioSalario = new Label("Promedio Salario");
		lblPromedioSalario.setStyleName("label");
		absolutePanel.add(lblPromedioSalario, 371, 0);
		lblPromedioSalario.setSize("75px", "13px");
		
		Label lblX = new Label("/");
		lblX.setStyleName("label");
		absolutePanel.add(lblX, 476, 42);
		lblX.setSize("16px", "13px");
		
		Label lblDiasAlAo = new Label("Dias al año");
		lblDiasAlAo.setStyleName("label");
		absolutePanel.add(lblDiasAlAo, 486, 10);
		lblDiasAlAo.setSize("86px", "13px");
		
		Label lblX_1 = new Label("X");
		lblX_1.setStyleName("label");
		absolutePanel.add(lblX_1, 586, 42);
		lblX_1.setSize("16px", "13px");
		
		Label lblDiasTrabajados = new Label("Dias Trabajados");
		lblDiasTrabajados.setStyleName("label");
		absolutePanel.add(lblDiasTrabajados, 598, 0);
		lblDiasTrabajados.setSize("86px", "13px");
		
		Label label = new Label("=");
		label.setStyleName("label");
		absolutePanel.add(label, 698, 42);
		label.setSize("16px", "13px");
		
		Label lblTotalPrestacion = new Label("Total Prestacion");
		lblTotalPrestacion.setStyleName("label");
		absolutePanel.add(lblTotalPrestacion, 710, 0);
		lblTotalPrestacion.setSize("86px", "13px");
		
		Label label_1 = new Label("Fecha");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 216, 10);
		label_1.setSize("60px", "13px");
		
	}
	
	public void llenar_datos(
			 Long idEmpleado,
			 String codigoSalario,
			 String descripcion,
			 String nombre,
			 String promedioSalario,
			 String txtDiasTrabajados,
			 String txtDiasAnnio){
		float total = 0;
		this.txtPromedioSalario.setText(promedioSalario);
		this.txtDiasAnnio.setText(txtDiasAnnio);
		this.txtDiasTrabajados.setText(txtDiasTrabajados);
		this.txtEmpleado.setText(nombre);
		
		this.idEmpleado = idEmpleado;
		this.codigoSalario = codigoSalario;
		this.descripcion = descripcion;
		
		total = Float.parseFloat(this.txtPromedioSalario.getText())/Float.parseFloat(this.txtDiasAnnio.getText())*Float.parseFloat(this.txtDiasTrabajados.getText());
		this.txtTotal.setText(""+total);
		
	}
	
}
