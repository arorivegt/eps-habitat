package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;

public class EmpleadosMinisterioTrabajo extends Composite  {

    private  Grid grid;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private ScrollPanel scrollPanel;
    private AbsolutePanel absolutePanel_1;
	public EmpleadosMinisterioTrabajo() {
		
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("1178px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("1130px", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		final ListBox listEstado = new ListBox();
		listEstado.addItem("empleado activo");
		listEstado.addItem("empleado inactivo");
		listEstado.addItem("posible empleado");
		listEstado.addItem("todos");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 170, 31);
		listEstado.setSize("227px", "34px");
		
		Label lblBusquedaPor = new Label("Crear Reporte Empleados:");
		lblBusquedaPor.setStyleName("label");
		absolutePanel.add(lblBusquedaPor, 170, 10);
		lblBusquedaPor.setSize("262px", "13px");
		
		scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		grid.setWidget(1, 0, scrollPanel);
		scrollPanel.setSize("1187px", "379px");
		
		absolutePanel_1 = new AbsolutePanel();
		scrollPanel.setWidget(absolutePanel_1);
		absolutePanel_1.setSize("10322px", "601px");
	
		Image image = new Image("images/ico-lupa.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				char tipo = '5';
				
				if(listEstado.getItemText(listEstado.getSelectedIndex()).equals("todos"))
					tipo = '2';
				else
					tipo = '5';
				
				loginService.Buscar_Empleado(tipo,"", "", 
						"", "","","",listEstado.getItemText(listEstado.getSelectedIndex()),new AsyncCallback<List<AuxEmpleado>>(){
            public void onFailure(Throwable caught) 
            {
                Window.alert("No hay resultados "+caught);
            }

			@Override
            public void onSuccess( List<AuxEmpleado> result)
            {
				List<DatosMinisterioTrabajo> DATOS = new ArrayList<DatosMinisterioTrabajo>();
				int i = 0;
				for (AuxEmpleado p : result) {
					DatosMinisterioTrabajo empleado = new DatosMinisterioTrabajo();
					empleado.setNoEmpleado(""+i);
					try{
						if(p.getCui().equals(null) || p.getCui().equals("")){
							empleado.setTipoIdentificacion("1");
							empleado.setDocumentoIdentificacion(p.getNo_registro()+p.getNo_orden());
						}
						if(!p.getCui().equals("")){
							empleado.setTipoIdentificacion("2");
							empleado.setDocumentoIdentificacion(p.getCui());
						}
					}catch(Exception e){

						empleado.setTipoIdentificacion("2");
						empleado.setDocumentoIdentificacion(p.getCui());
					}
					empleado.setPaisOrigen(p.getPais());
					//empleado.setLugarNacimiento(lugarNacimiento);
					empleado.setNitEmpleado(p.getNit());
					empleado.setIGSSEmpleado(p.getAfiliacion_igss());
					//empleado.setDeportadoPais(deportadoPais);
					empleado.setNombre1(p.getPrimer_nombre());
					empleado.setNombre2(p.getSegundo_nombre());
					//empleado.setNombre3(p.getPrimer_nombre());
					empleado.setApellido1(p.getPrimer_apellido());
					empleado.setApellido2(p.getSegundo_apellido());
					empleado.setEstadoCivil(p.getEstado_civil());
					int NoHijos = 0;
					for (AuxFamilia f : p.getFamilia()) {
						if(f.getParentesco().equals("hijo(a)"))
							NoHijos++;
					}
					empleado.setNumeroHijos(""+NoHijos);
					empleado.setFechaNacimiento(""+new Date(p.getFecha_nacimiento()));
					
					DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy");
					String AnnioNacimiento = dtf.format(new Date(p.getFecha_nacimiento()));
					String AnnioActual = dtf.format(new Date());
					//resta del año de actual - año nacimiento, para calcular edad aproximada
					int edadtotal = Integer.parseInt(AnnioActual)- Integer.parseInt(AnnioNacimiento);
					empleado.setEdad(""+edadtotal);
					empleado.setSexo(""+p.getSexo().toUpperCase().charAt(0));
					empleado.setTiempodelaborar(""+365);
					for (AuxPuesto f : p.getPuestos()) {
						if(f.isActivo()){
							empleado.setPuesto(f.getNombre_puesto());
							break;
						}
					}
					
					/*
					private String DiasTrabajadosAnnio;	
					private String DescansoSemanal;
					private String Jornada;
					private String HorasAlDia;
					private String SalarioMensualNominal;
					private String Decreto7889 ;
					private String TotalHorasExtras;
					private String ValordeHoraExtra;
					private String Aguinaldo;
					private String Bono14;
					private String Comisiones;	
					private String NivelAcademico;
					private String Profesion;
					private String Etnia;
					private String PermisoTrabajo;
					private String TipoContrato;
					private String Indemnizacion;
					private String OtrosPagos;
					private String Idiomas;*/
					
					DATOS.add(empleado);
					i++;
				}
				ReporteMinisterioTrabajo nuevo = new ReporteMinisterioTrabajo(DATOS);
				nuevo.AgregarColumna("1");
				nuevo.AgregarColumna("2");
				nuevo.AgregarColumna("3");
				nuevo.AgregarColumna("4");
				nuevo.AgregarColumna("5");
				nuevo.AgregarColumna("6");
				nuevo.AgregarColumna("7");
				nuevo.AgregarColumna("8");
				nuevo.AgregarColumna("9");
				nuevo.AgregarColumna("10");
				nuevo.AgregarColumna("11");
				nuevo.AgregarColumna("12");
				nuevo.AgregarColumna("13");
				nuevo.AgregarColumna("14");
				nuevo.AgregarColumna("15");
				nuevo.AgregarColumna("16");
				nuevo.AgregarColumna("17");
				nuevo.AgregarColumna("18");
				nuevo.AgregarColumna("19");
				nuevo.AgregarColumna("20");
				nuevo.AgregarColumna("21");
				nuevo.AgregarColumna("22");
				nuevo.AgregarColumna("23");
				nuevo.AgregarColumna("24");
				nuevo.AgregarColumna("25");
				nuevo.AgregarColumna("26");
				nuevo.AgregarColumna("27");
				nuevo.AgregarColumna("28");
				nuevo.AgregarColumna("29");
				nuevo.AgregarColumna("30");
				//nuevo.setSize("1187px", "648px");
				absolutePanel_1.clear();
				absolutePanel_1.add(nuevo);
            }

				});
			}
		});

		absolutePanel.add(image, 438, 10);
		image.setSize("103px", "55px");
		
		Label lblEstadoEmpleado = new Label("Estado Empleado");
		lblEstadoEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoEmpleado, 10, 29);
		lblEstadoEmpleado.setSize("154px", "13px");
		
	}
}
