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
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class FormularioReferenciaLaboral extends Composite {

	private Empleados empleado;
	private ReferenciaLaboral a;
	private boolean bandera = true;
	private Long id_referencia_laboral = 0L;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	
	private TextBox txtNombre;
	private TextBox txtEmpresa;
	private ListBox listRecomienda;
	private TextArea txtMotivoRetiro;
	private TextArea txtActitudes;
	private IntegerBox txtTelefono;
	private DateBox dateFecha1;
	private DateBox dateFecha2;
	private TextBox txtSalarioFinal;
	private TextBox txtPuestoCandidato;
	private Mensaje mensaje; 
    private Loading load ;
	
	public FormularioReferenciaLaboral(ReferenciaLaboral a,Empleados e) {

		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.empleado = e;
		this.a = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1219px", "210px");
		
		txtNombre = new TextBox();
		txtNombre.setMaxLength(200);
		txtNombre.setStylePrimaryName("gwt-TextBox2");
		txtNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombre, 10, 19);
		txtNombre.setSize("227px", "34px");
		
		txtTelefono = new IntegerBox();
		txtTelefono.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtTelefono .getText().equals("")) {txtTelefono .setText("0");}
				else if(txtTelefono .getText().equals(null)) {txtTelefono .setText("0");}
				else{
					try{
						Integer.parseInt(txtTelefono .getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nTelefono No valido");
						txtTelefono .setText("0");
					}
				}
			}
		});
		txtTelefono.setText("0");
		txtTelefono.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtTelefono, 257, 19);
		txtTelefono.setSize("227px", "34px");
		
		txtPuestoCandidato = new TextBox();
		txtPuestoCandidato.setMaxLength(200);
		txtPuestoCandidato.setStylePrimaryName("gwt-TextBox2");
		txtPuestoCandidato.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPuestoCandidato, 502, 19);
		txtPuestoCandidato.setSize("227px", "34px");
		
		dateFecha1 = new DateBox();
		dateFecha1.getTextBox().setReadOnly(true);
		dateFecha1.setValue(new Date());
		dateFecha1.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha1.getDatePicker().setYearArrowsVisible(true);
		dateFecha1.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha1.getDatePicker().setVisibleYearCount(100);
		dateFecha1.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha1, 750, 19);
		dateFecha1.setSize("227px", "34px");
		
		dateFecha2 = new DateBox();
		dateFecha2.getTextBox().setReadOnly(true);
		dateFecha2.setValue(new Date());
		dateFecha2.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha2.getDatePicker().setYearArrowsVisible(true);
		dateFecha2.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha2.getDatePicker().setVisibleYearCount(100);
		dateFecha2.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha2, 1044, 19);
		dateFecha2.setSize("227px", "34px");
		
		txtEmpresa = new TextBox();
		txtEmpresa.setMaxLength(100);
		txtEmpresa.setStylePrimaryName("gwt-TextBox2");
		txtEmpresa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEmpresa, 10, 75);
		txtEmpresa.setSize("227px", "34px");
		
		txtSalarioFinal = new TextBox();
		txtSalarioFinal.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalarioFinal.getText().equals("")) {txtSalarioFinal.setText("0");}
				else if(txtSalarioFinal.getText().equals(null)) {txtSalarioFinal.setText("0");}
				else{
					try{
						Float.parseFloat(txtSalarioFinal.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nSalario no valido");
						txtSalarioFinal.setText("0.0");
					}
				}
			}
		});
		txtSalarioFinal.setText("0.0");
		txtSalarioFinal.setStylePrimaryName("gwt-TextBox2");
		txtSalarioFinal.setStyleName("gwt-TextBox2");
		txtSalarioFinal.setMaxLength(100);
		absolutePanel.add(txtSalarioFinal, 257, 75);
		txtSalarioFinal.setSize("227px", "34px");
		
		listRecomienda = new ListBox();
		listRecomienda.addItem("Si");
		listRecomienda.addItem("No");
		listRecomienda.setStyleName("gwt-TextBox2");
		absolutePanel.add(listRecomienda, 502, 77);
		listRecomienda.setSize("227px", "34px");
		
		txtMotivoRetiro = new TextArea();
		txtMotivoRetiro.getElement().setAttribute("maxlength", "500");
		txtMotivoRetiro.setStyleName("gwt-TextBox");
		absolutePanel.add(txtMotivoRetiro, 10, 144);
		txtMotivoRetiro.setSize("426px", "61px");
		
		txtActitudes = new TextArea();
		txtActitudes.getElement().setAttribute("maxlength", "500");
		txtActitudes.setStyleName("gwt-TextBox");
		absolutePanel.add(txtActitudes, 499, 144);
		txtActitudes.setSize("430px", "61px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
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
			
				if(bandera) {
					loginService.Insertar_Referencia_Laboral(empleado.id_empleado, txtNombre.getText(), txtTelefono.getText(), 
							txtPuestoCandidato.getText(), txtEmpresa.getText(), dateFecha1.getValue(), dateFecha2.getValue(), 
							txtMotivoRetiro.getText() , Float.parseFloat(txtSalarioFinal.getText()), txtActitudes.getText(), 
							listRecomienda.getItemText(listRecomienda.getSelectedIndex()), new AsyncCallback<Long>(){
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
							id_referencia_laboral = result;
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        }
						});
				}else{
					loginService.Actualizar_Referencia_Laboral(empleado.id_empleado,id_referencia_laboral, txtNombre.getText(), txtTelefono.getText(), 
							txtPuestoCandidato.getText(), txtEmpresa.getText(), dateFecha1.getValue(), dateFecha2.getValue(), 
							txtMotivoRetiro.getText() , Float.parseFloat(txtSalarioFinal.getText()), txtActitudes.getText(), 
							listRecomienda.getItemText(listRecomienda.getSelectedIndex()), new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
            		        load.invisible();
                        	mensaje.setMensaje("alert alert-error", 
                        			"Error !! \nal Actualizar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
					        load.invisible();
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
		                			"Datos Actualizados\n exitosamente!!!");
                        }
						});
				}
		        load.invisible();
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("sendButton");
		btnActualizar.setStyleName("sendButton");
		absolutePanel.add(btnActualizar, 1046, 144);
		btnActualizar.setSize("227px", "34px");
		
		
		Button btnEliminar = new Button("Send");
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
		absolutePanel.add(btnEliminar, 1046, 211);
		btnEliminar.setSize("227px", "34px");
		
		Label lblNivelAcademico = new Label("Nombre");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 0);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Telefono");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 257, 0);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Puesto Candidato");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 502, 0);
		lblParentesco.setSize("192px", "13px");
		
		Label lblAos = new Label("Periodo Labores");
		lblAos.setStyleName("label");
		absolutePanel.add(lblAos, 970, 0);
		lblAos.setSize("192px", "13px");
		
		Label lblEmpresa = new Label("Empresa");
		lblEmpresa.setStyleName("label");
		absolutePanel.add(lblEmpresa, 10, 61);
		lblEmpresa.setSize("192px", "13px");
		
		Label lblMotivo = new Label("Motivo Retiro");
		lblMotivo.setStyleName("label");
		absolutePanel.add(lblMotivo, 10, 119);
		lblMotivo.setSize("196px", "19px");
		
		Label lblSalarioFinal = new Label("Salario  Final");
		lblSalarioFinal.setStyleName("label");
		absolutePanel.add(lblSalarioFinal, 257, 61);
		lblSalarioFinal.setSize("192px", "13px");
		
		Label lblLoRecomienda = new Label("Lo recomienda");
		lblLoRecomienda.setStyleName("label");
		absolutePanel.add(lblLoRecomienda, 502, 61);
		lblLoRecomienda.setSize("229px", "5px");
		
		Label lblActitudescualidadesaptitudesObserv = new Label("Actitudes/cualidades/aptitudes observadas");
		lblActitudescualidadesaptitudesObserv.setStyleName("label");
		absolutePanel.add(lblActitudescualidadesaptitudesObserv, 499, 122);
		lblActitudescualidadesaptitudesObserv.setSize("338px", "13px");
		
		Label label = new Label("al");
		label.setStyleName("label");
		absolutePanel.add(label, 1000, 28);
		label.setSize("38px", "13px");
	}
	private void EliminarFormulario(){
        a.EliminarFormulario(this,empleado.id_empleado,id_referencia_laboral);
    }
	private void EliminarFormularioSinDatos(){
        a.EliminarFormulario(this);
    }
	public void LlenarDatos(Long id,  String txtNombre,
			 String txtEmpresa,
			 String listRecomienda,
			 String txtMotivoRetiro,
			 String txtActitudes,
			 String txtTelefono,
			 Long dateFecha1,
			 Long dateFecha2,
			 String txtSalarioFinal,
			 String txtPuestoCandidato)
	{
		this.id_referencia_laboral = id;
		this.bandera = false;
		this.txtNombre.setText(txtNombre);
		this.txtEmpresa.setText(txtEmpresa);
		boolean bandera = true;
		for(int i=0; i < this.listRecomienda.getItemCount() && bandera; i++){
			bandera = !this.listRecomienda.getItemText(i).endsWith(listRecomienda);
		    this.listRecomienda.setSelectedIndex(i);
		}
		this.txtMotivoRetiro.setText(txtMotivoRetiro);;
		this.txtActitudes.setText(txtActitudes);
		this.txtTelefono.setText(txtTelefono);
		this.dateFecha1.setValue(new Date(dateFecha1));
		this.dateFecha2.setValue(new Date(dateFecha2));
		this.txtSalarioFinal.setText(txtSalarioFinal);
		this.txtPuestoCandidato.setText(txtPuestoCandidato);
	}
}
