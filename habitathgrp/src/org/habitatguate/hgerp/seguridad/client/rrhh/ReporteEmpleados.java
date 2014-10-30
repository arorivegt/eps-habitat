package org.habitatguate.hgerp.seguridad.client.rrhh;

import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;

public class ReporteEmpleados extends Composite  {

    private  Grid grid;
    private ListBox crearPor;
	
	public ReporteEmpleados() {
		grid = new Grid(1, 1);
		initWidget(grid);
		grid.setSize("1278px", "312px");
					
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1096px", "550px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		final ListBox listEstado = new ListBox();
		listEstado.addItem("empleado activo");
		listEstado.addItem("empleado inactivo");
		listEstado.addItem("posible empleado");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 155, 142);
		listEstado.setSize("229px", "34px");
		
		crearPor = new ListBox();
		crearPor.addItem("Todos");
		crearPor.addItem("Estado");
		crearPor.setStyleName("gwt-TextBox2");
		absolutePanel.add(crearPor, 390, 140);
		crearPor.setSize("229px", "36px");
		final SimpleCheckBox checkFamilia = new SimpleCheckBox();
		absolutePanel.add(checkFamilia, 245, 257);
		checkFamilia.setSize("22px", "22px");
		
		final SimpleCheckBox checkAcademico = new SimpleCheckBox();
		absolutePanel.add(checkAcademico, 245, 296);
		checkAcademico.setSize("22px", "22px");
		
		final SimpleCheckBox checkRefLaboral = new SimpleCheckBox();
		absolutePanel.add(checkRefLaboral, 245, 337);
		checkRefLaboral.setSize("22px", "22px");
		
		final SimpleCheckBox checkRefPersonal = new SimpleCheckBox();
		absolutePanel.add(checkRefPersonal, 245, 378);
		checkRefPersonal.setSize("22px", "22px");
		
		final SimpleCheckBox checkIdioma = new SimpleCheckBox();
		absolutePanel.add(checkIdioma, 245, 415);
		checkIdioma.setSize("22px", "22px");
		
		final SimpleCheckBox checkDesempeno = new SimpleCheckBox();
		absolutePanel.add(checkDesempeno, 245, 456);
		checkDesempeno.setSize("22px", "22px");
		
		final SimpleCheckBox checkEvaluacion = new SimpleCheckBox();
		absolutePanel.add(checkEvaluacion, 480, 256);
		checkEvaluacion.setSize("22px", "22px");
		
		final SimpleCheckBox checkHistorial = new SimpleCheckBox();
		absolutePanel.add(checkHistorial, 480, 296);
		checkHistorial.setSize("22px", "22px");
		
		final SimpleCheckBox checkVacaciones = new SimpleCheckBox();
		absolutePanel.add(checkVacaciones, 480, 337);
		checkVacaciones.setSize("22px", "22px");
		
		final SimpleCheckBox checkBono14 = new SimpleCheckBox();
		absolutePanel.add(checkBono14, 480, 378);
		checkBono14.setSize("22px", "22px");
		
		final SimpleCheckBox checkAguinaldo = new SimpleCheckBox();
		absolutePanel.add(checkAguinaldo, 480, 415);
		checkAguinaldo.setSize("22px", "22px");
		
		final SimpleCheckBox checkIndemnizacion = new SimpleCheckBox();
		absolutePanel.add(checkIndemnizacion, 480, 456);
		checkIndemnizacion.setSize("22px", "22px");
		
		Image image = new Image("images/pdf.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.open("/CrearReporte?"
						+"crear="+crearPor.getItemText(crearPor.getSelectedIndex())
						+"&estado="+listEstado.getItemText(listEstado.getSelectedIndex())
						+"&familia="+checkFamilia.getValue()
						+"&academico="+checkAcademico.getValue()
						+"&reflaboral="+checkRefLaboral.getValue()
						+"&refpersonal="+checkRefPersonal.getValue()
						+"&idioma="+checkIdioma.getValue()
						+"&desempeno="+checkDesempeno.getValue()
						+"&evaluacion="+checkEvaluacion.getValue()
						+"&historial="+checkHistorial.getValue()
						+"&vacaciones="+checkVacaciones.getValue()
						+"&bono14="+checkBono14.getValue()
						+"&aguinaldo="+checkAguinaldo.getValue()
						+"&indemnizacion="+checkIndemnizacion.getValue()
						, "_blank", "");
			}
		});
		absolutePanel.add(image, 648, 63);
		image.setSize("103px", "87px");
						
		Label lblBusquedaPor = new Label("Crear Reporte por:");
		lblBusquedaPor.setStyleName("label");
		absolutePanel.add(lblBusquedaPor, 390, 124);
		lblBusquedaPor.setSize("190px", "13px");
				
		Label lblEstadoEmpleado = new Label("Estado Empleado");
		lblEstadoEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoEmpleado, 155, 123);
		lblEstadoEmpleado.setSize("229px", "13px");
		
		Label lblCrearReporte = new Label("Crear Reporte");
		lblCrearReporte.setStyleName("label");
		absolutePanel.add(lblCrearReporte, 648, 156);
		lblCrearReporte.setSize("118px", "13px");
		
		Label lblFamilia = new Label("Datos de Familia");
		lblFamilia.setStyleName("label");
		absolutePanel.add(lblFamilia, 290, 259);
		lblFamilia.setSize("157px", "13px");
		
		Label lblDatosAcademicos = new Label("Datos Academicos");
		lblDatosAcademicos.setStyleName("label");
		absolutePanel.add(lblDatosAcademicos, 290, 299);
		lblDatosAcademicos.setSize("157px", "13px");
		
		Label lblDatosReferenciaPersonal = new Label("Datos Referencia Personal");
		lblDatosReferenciaPersonal.setStyleName("label");
		absolutePanel.add(lblDatosReferenciaPersonal, 290, 381);
		lblDatosReferenciaPersonal.setSize("157px", "13px");
		
		Label lblDatps = new Label("Datos Referencia Laboral");
		lblDatps.setStyleName("label");
		absolutePanel.add(lblDatps, 290, 341);
		lblDatps.setSize("157px", "13px");
		
		Label lblDatosDeDesempeo = new Label("Datos de desempeño");
		lblDatosDeDesempeo.setStyleName("label");
		absolutePanel.add(lblDatosDeDesempeo, 290, 459);
		lblDatosDeDesempeo.setSize("157px", "13px");
		
		Label lblIdiomasHablados = new Label("Idiomas Hablados");
		lblIdiomasHablados.setStyleName("label");
		absolutePanel.add(lblIdiomasHablados, 290, 419);
		lblIdiomasHablados.setSize("157px", "13px");
		
		Label lblContenidoDelReporte = new Label("A continuacion, seleccione lo que desea ver en el Reporte por Empleado:");
		lblContenidoDelReporte.setStyleName("label");
		absolutePanel.add(lblContenidoDelReporte, 245, 213);
		lblContenidoDelReporte.setSize("464px", "13px");
		
		Label lblCreeElReporte = new Label("Cree el Reporte en base a un Empleado Especifico, por DPI, por Pasaporte, Por Nombre, Por Estado o a todos los Empleados");
		lblCreeElReporte.setStyleName("label");
		absolutePanel.add(lblCreeElReporte, 25, 10);
		lblCreeElReporte.setSize("828px", "13px");
		
		Label lblDatosDeE = new Label("Datos de Evaluacion");
		lblDatosDeE.setStyleName("label");
		absolutePanel.add(lblDatosDeE, 525, 259);
		lblDatosDeE.setSize("157px", "13px");
		
		Label lblDatos = new Label("Datos Llamadas de atencion, ausencias, aciertos y permisos");
		lblDatos.setStyleName("label");
		absolutePanel.add(lblDatos, 525, 299);
		lblDatos.setSize("261px", "13px");
		
		Label lblDatosDeVacaciones = new Label("Datos de vacaciones");
		lblDatosDeVacaciones.setStyleName("label");
		absolutePanel.add(lblDatosDeVacaciones, 525, 341);
		lblDatosDeVacaciones.setSize("157px", "13px");
		
		Label lblBonos = new Label("Bono 14");
		lblBonos.setStyleName("label");
		absolutePanel.add(lblBonos, 525, 381);
		lblBonos.setSize("157px", "13px");
		
		Label lblAguinaldo = new Label("Aguinaldo");
		lblAguinaldo.setStyleName("label");
		absolutePanel.add(lblAguinaldo, 525, 419);
		lblAguinaldo.setSize("157px", "13px");
		
		Label lblIndenmizacion = new Label("Indenmizacion");
		lblIndenmizacion.setStyleName("label");
		absolutePanel.add(lblIndenmizacion, 525, 459);
		lblIndenmizacion.setSize("157px", "13px");
		
	}
	

}
