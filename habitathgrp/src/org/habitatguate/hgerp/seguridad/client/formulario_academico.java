package org.habitatguate.hgerp.seguridad.client;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;

public class formulario_academico extends Composite {
	
	private academico a;
	private boolean bandera = true;
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	private Long id_historial_academico = 0L;
	private Empleados empleado;
	public formulario_academico(academico a,Empleados e) {

		this.empleado = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("738px", "55px");
		
		Label lblNivelAcademico = new Label("Nivel Academico");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Titulo/Diploma");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 190, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Establecimiento");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 374, 10);
		lblParentesco.setSize("192px", "13px");
		
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
					EliminarFormulario();
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("gwt-TextBox2");
		btnEliminar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnEliminar, 196, 61);
		btnEliminar.setSize("157px", "20px");
		
		final ListBox listNIvel_Academico = new ListBox();
		listNIvel_Academico.addItem("Primaria");
		listNIvel_Academico.addItem("Basicos");
		listNIvel_Academico.addItem("Diversificado");
		listNIvel_Academico.addItem("Universidad");
		listNIvel_Academico.addItem("Maestria");
		listNIvel_Academico.addItem("Diplomado");
		listNIvel_Academico.addItem("Titulo");
		listNIvel_Academico.addItem("Otro");
		listNIvel_Academico.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNIvel_Academico, 10, 29);
		listNIvel_Academico.setSize("157px", "20px");
		
		Label lblAos = new Label("Fecha inicio y final");
		lblAos.setStyleName("label");
		absolutePanel.add(lblAos, 612, 10);
		lblAos.setSize("103px", "13px");
		
		Label lblAl = new Label("al");
		lblAl.setStyleName("label");
		absolutePanel.add(lblAl, 649, 36);
		lblAl.setSize("23px", "13px");
		
		final DateBox dateInicio = new DateBox();
		dateInicio.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateInicio.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateInicio, 550, 29);
		dateInicio.setSize("73px", "11px");
		
		final DateBox dateFinal = new DateBox();
		dateFinal.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFinal.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFinal, 677, 29);
		dateFinal.setSize("83px", "11px");
		
		final TextBox txtTitulo = new TextBox();
		txtTitulo.setStyleName("gwt-TextBox2");
		txtTitulo.setMaxLength(100);
		absolutePanel.add(txtTitulo, 200, 29);
		txtTitulo.setSize("137px", "11px");
		
		final TextBox txtEstablecimiento = new TextBox();
		txtEstablecimiento.setStyleName("gwt-TextBox2");
		txtEstablecimiento.setMaxLength(100);
		absolutePanel.add(txtEstablecimiento, 369, 29);
		txtEstablecimiento.setSize("137px", "11px");
		
		Button btnImprimir = new Button("Send");
		btnImprimir.setText("Imprimir");
		btnImprimir.setStylePrimaryName("gwt-TextBox2");
		btnImprimir.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnImprimir, 369, 61);
		btnImprimir.setSize("157px", "20px");
		
		Button btnActualizar = new Button("Send");
		btnActualizar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if(bandera) {
					loginService.Insertar_Academico(empleado.id_empleado, dateInicio.getValue(), dateFinal.getValue(), 
							listNIvel_Academico.getItemText(listNIvel_Academico.getSelectedIndex()), txtEstablecimiento.getText(), 
							txtTitulo.getText(), new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                            Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_historial_academico = result;
							bandera = false;
                        	Window.alert("Datos Guardados exitosamente!!! "+id_historial_academico);
                        }

                 });
		}else{
			loginService.Actualizar_Academico(empleado.id_empleado,id_historial_academico, dateInicio.getValue(), dateFinal.getValue(), 
					listNIvel_Academico.getItemText(listNIvel_Academico.getSelectedIndex()), txtEstablecimiento.getText(), 
					txtTitulo.getText(), new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                    Window.alert("Error al Actualizar Datos"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {
					bandera = false;
                	Window.alert("Datos Actualizados exitosamente!!! "+id_historial_academico);
                }

         });
		}
				
			}
		});
		btnActualizar.setText("Guardar");
		btnActualizar.setStylePrimaryName("gwt-TextBox2");
		btnActualizar.setStyleName("gwt-TextBox2");
		absolutePanel.add(btnActualizar, 10, 61);
		btnActualizar.setSize("157px", "20px");
		
	}
	private void EliminarFormulario(){
	        a.EliminarFormulario(this,empleado.id_empleado,id_historial_academico);
    }
}
