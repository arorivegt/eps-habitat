package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialAcademico;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxIdioma;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EmpleadosMinisterioTrabajo extends Composite  {

    private Grid grid;
    private Loading load;
	private Button button;
    private ListBox listAnnio;
    private ListBox listEstado;
	private FormPanel formPanel;
    private Label lblAoDelReporte;
    private ScrollPanel scrollPanel;
	private VerticalPanel verticalPanel;
    private AbsolutePanel absolutePanel_1;
    private List<DatosMinisterioTrabajo> DATOS;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	
	public EmpleadosMinisterioTrabajo() {
		
		grid = new Grid(2, 1);
		initWidget(grid);
		grid.setWidth("100%");

    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		AbsolutePanel absolutePanel = new AbsolutePanel();
		grid.setWidget(0, 0, absolutePanel);
		absolutePanel.setSize("100%", "30px");
		absolutePanel.setStyleName("gwt-Label-new");
		
		listEstado = new ListBox();
		listEstado.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				busqueda();
			}
		});
		listEstado.addItem("empleado activo","0");
		listEstado.addItem("empleado inactivo","1");
		listEstado.addItem("posible empleado","2");
		listEstado.addItem("practicante","3");
		listEstado.addItem("interino","4");
		listEstado.addItem("todos");
		listEstado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listEstado, 170, 31);
		listEstado.setSize("227px", "34px");
		
		Image image = new Image("images/ico-lupa.png");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				busqueda();
			}
		});
			
		absolutePanel.add(image, 604, 10);
		image.setSize("103px", "55px");
		
		Label lblBusquedaPor = new Label("Crear Reporte Empleados:");
		lblBusquedaPor.setStyleName("label");
		absolutePanel.add(lblBusquedaPor, 170, 10);
		lblBusquedaPor.setSize("227px", "13px");
		
		scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(false);
		grid.setWidget(1, 0, scrollPanel);
		scrollPanel.setSize("1400px", "100%");
		
		absolutePanel_1 = new AbsolutePanel();
		scrollPanel.setWidget(absolutePanel_1);
		absolutePanel_1.setSize("4500px", "100%");
		
		Label lblEstadoEmpleado = new Label("Estado Empleado");
		lblEstadoEmpleado.setStyleName("label");
		absolutePanel.add(lblEstadoEmpleado, 10, 29);
		lblEstadoEmpleado.setSize("154px", "13px");
		
		listAnnio = new ListBox();
		listAnnio.addItem("2000");
		listAnnio.addItem("2001");
		listAnnio.addItem("2002");
		listAnnio.addItem("2003");
		listAnnio.addItem("2004");
		listAnnio.addItem("2005");
		listAnnio.addItem("2006");
		listAnnio.addItem("2007");
		listAnnio.addItem("2008");
		listAnnio.addItem("2009");
		listAnnio.addItem("2010");
		listAnnio.addItem("2011");
		listAnnio.addItem("2012");
		listAnnio.addItem("2013");
		listAnnio.addItem("2014");
		listAnnio.addItem("2015");
		listAnnio.addItem("2016");
		listAnnio.addItem("2017");
		listAnnio.addItem("2018");
		listAnnio.addItem("2019");
		listAnnio.addItem("2020");
		listAnnio.addItem("2021");
		listAnnio.addItem("2022");
		listAnnio.addItem("2023");
		listAnnio.addItem("2024");
		listAnnio.addItem("2025");
		listAnnio.addItem("2026");
		listAnnio.addItem("2027");
		listAnnio.addItem("2028");
		listAnnio.addItem("2029");
		listAnnio.addItem("2030");
		listAnnio.addItem("2031");
		listAnnio.addItem("2032");
		listAnnio.addItem("2033");
		listAnnio.addItem("2034");
		listAnnio.addItem("2035");
		listAnnio.addItem("2036");
		listAnnio.addItem("2037");
		listAnnio.addItem("2038");
		listAnnio.addItem("2039");
		listAnnio.addItem("2040");
		listAnnio.addItem("2050");
		listAnnio.addItem("2051");
		listAnnio.addItem("2052");
		listAnnio.addItem("2053");
		listAnnio.addItem("2054");
		listAnnio.addItem("2055");
		listAnnio.addItem("2056");
		listAnnio.addItem("2057");
		listAnnio.addItem("2058");
		listAnnio.addItem("2059");
		listAnnio.addItem("2060");
		listAnnio.setStyleName("gwt-TextBox2");
		absolutePanel.add(listAnnio, 403, 29);
		listAnnio.setSize("179px", "39px");
		
		lblAoDelReporte = new Label("Año del Reporte");
		lblAoDelReporte.setStyleName("label");
		absolutePanel.add(lblAoDelReporte, 403, 10);
		lblAoDelReporte.setSize("173px", "13px");

		button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				char tipo = '5';
				if(listEstado.getItemText(listEstado.getSelectedIndex()).equals("todos"))
					tipo = '2';
				else
					tipo = '5';
				
				System.out.println("/ExportAs?tipo="+tipo+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex()));
				formPanel.setAction("/ExportAs?tipo="+tipo+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex()));
				formPanel.submit();
			}
		});
		button.setText("Exportar");
		button.setStylePrimaryName("sendButton");
		button.setStyleName("sendButton");
		button.setSize("198px", "41px");

		formPanel = new FormPanel();
		formPanel.setAction("/ExportAs?tipo="+"0"+"&estado="+listEstado.getValue(listEstado.getSelectedIndex())+"&annio="+listAnnio.getItemText(listAnnio.getSelectedIndex()));
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		
		verticalPanel = new VerticalPanel();
		formPanel.setWidget(verticalPanel);
		verticalPanel.setSize("208px", "43px");
        verticalPanel.add(button);
		absolutePanel.add(formPanel, 708, 21);
        formPanel.setSize("209px", "44px");
        
		

		
	}
	
	public void busqueda(){

        load.visible();
		char tipo = '5';
		
		if(listEstado.getItemText(listEstado.getSelectedIndex()).equals("todos"))
			tipo = '2';
		else
			tipo = '5';
		
		loginService.Buscar_Empleado(tipo,"", "", 
				"", "","","",listEstado.getValue(listEstado.getSelectedIndex()),new AsyncCallback<List<AuxEmpleado>>(){
		public void onFailure(Throwable caught) 
		{
	        load.invisible();
		    Window.alert("No hay resultados "+caught);
		}
		
			@Override
		public void onSuccess(List<AuxEmpleado> listAuxEmpleado)
		{
				NumberFormat fmt = NumberFormat.getDecimalFormat();
				DATOS = new ArrayList<DatosMinisterioTrabajo>();
				int i = 0;
				
				for (AuxEmpleado itemEmpleado : listAuxEmpleado) {
					DatosMinisterioTrabajo empleado = new DatosMinisterioTrabajo();
					
					empleado.setNoEmpleado(""+i);
					
					try{
						if(itemEmpleado.getPais().equals("83")){
							empleado.setTipoIdentificacion("2");
							empleado.setDocumentoIdentificacion(itemEmpleado.getCui());
						}
						else{
							empleado.setTipoIdentificacion("4");
							empleado.setDocumentoIdentificacion(itemEmpleado.getNo_pasaporte());
						}
					}catch(Exception e){
						empleado.setTipoIdentificacion("2");
						empleado.setDocumentoIdentificacion("");
					}
					empleado.setPaisOrigen(itemEmpleado.getPais());
		
					 String[] numerosComoArray2  = itemEmpleado.getDepto_municipio_nacimiento().split(",");
					 String deptodir = "";
					 String munidir = "";
					 for (int i1 = 0; i1 < numerosComoArray2.length; i1++) {
						 if(i1 == 0)
							 deptodir = numerosComoArray2[i1];
						 if(i1 == 1)
							 munidir = numerosComoArray2[i1];
				     }	
					 if(deptodir.equals("01")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("I"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("I"+"0"+munidir);
						 }
					 }
					 else if(deptodir.equals("15")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("II"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("II"+munidir);
						 }}
					 else if(deptodir.equals("16")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("II"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("II"+munidir);
						 }}
					 else if(deptodir.equals("02")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
						 }}
					 else if(deptodir.equals("18")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
						 }}
					 else if(deptodir.equals("19")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
						 }}
					 else if(deptodir.equals("20")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
						 }}
					 else if(deptodir.equals("06")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("IV"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("IV"+munidir);
						 }}
					 else if(deptodir.equals("21")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("IV"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("IV"+munidir);
						 }}
					 else if(deptodir.equals("22")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("IV"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("IV"+munidir);
						 }}
					 else if(deptodir.equals("03")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("V"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("V"+munidir);
						 }}
					 else if(deptodir.equals("04")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("V"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("V"+munidir);
						 }}
					 else if(deptodir.equals("05")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("V"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("V"+munidir);
						 }}
					 else if(deptodir.equals("07")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
						 }}
					 else if(deptodir.equals("08")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
						 }}
					 else if(deptodir.equals("09")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
						 }}
					 else if(deptodir.equals("10")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
						 }}
					 else if(deptodir.equals("11")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
						 }}
					 else if(deptodir.equals("12")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
						 }}
					 else if(deptodir.equals("13")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VII"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VII"+munidir);
						 }}
					 else if(deptodir.equals("14")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VII"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VII"+munidir);
						 }}
					 else if(deptodir.equals("17")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VIII"+"0"+munidir);
						 }else{
							 empleado.setLugarNacimiento("VIII"+munidir);
						 }}
		
					empleado.setNitEmpleado(itemEmpleado.getNit());
					
					empleado.setIGSSEmpleado(itemEmpleado.getAfiliacion_igss());
					
					empleado.setDeportadoPais("");
					
					empleado.setNombre1(itemEmpleado.getPrimer_nombre());
					
					empleado.setNombre2(itemEmpleado.getSegundo_nombre());
					
					empleado.setNombre3("");
					
					empleado.setApellido1(itemEmpleado.getPrimer_apellido());
					
					empleado.setApellido2(itemEmpleado.getSegundo_apellido());
					
					empleado.setEstadoCivil(itemEmpleado.getEstado_civil());
					
					int NoHijos = 0;
					for (AuxFamilia f : itemEmpleado.getFamilia()) {
						if(f.getParentesco().equals("hijo(a)"))
							NoHijos++;
					}
					empleado.setNumeroHijos(""+NoHijos);
					
					//fecha de naicmiento con formato dia/mes/año
					DateTimeFormat dtDia = DateTimeFormat.getFormat("dd");
					String dia = dtDia.format(new Date(itemEmpleado.getFecha_nacimiento()));
					DateTimeFormat dtMes = DateTimeFormat.getFormat("MM");
					String Mes = dtMes.format(new Date(itemEmpleado.getFecha_nacimiento()));
					DateTimeFormat dtAnio = DateTimeFormat.getFormat("yyyy");
					String Anio = dtAnio.format(new Date(itemEmpleado.getFecha_nacimiento()));
					
					empleado.setFechaNacimiento(dia+"/"+Mes+"/"+Anio);
					
					//calculo de edad del empleado
					//resta del año de actual - año nacimiento, para calcular edad aproximada
					DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy");
					String AnnioNacimiento = dtf.format(new Date(itemEmpleado.getFecha_nacimiento()));
					String AnnioActual = dtf.format(new Date());
					int edadtotal = Integer.parseInt(AnnioActual)- Integer.parseInt(AnnioNacimiento);
					
					empleado.setEdad(""+edadtotal);
		
					if(itemEmpleado.getSexo().equals("0")){
						empleado.setSexo("F");
					}else{
						empleado.setSexo("M");
					}
					 Anio = dtAnio.format(new Date(itemEmpleado.getFecha_ingreso()));
					 String Anio2 = dtAnio.format(new Date());
					 
					
					long diaslaborados = new Date().getTime()-itemEmpleado.getFecha_ingreso();
					if(Integer.parseInt(Anio)< Integer.parseInt(Anio2)){
						empleado.setTiempodelaborar("365");
					}else{
						int dialaboradoss = (int) (diaslaborados /(1000 * 60 * 60 * 24));
						empleado.setTiempodelaborar(""+dialaboradoss);
					}
		
					String DescansoSemanal = "";
					String jornada = "";
					for (AuxPuesto f : itemEmpleado.getPuestos()) {
						if(f.isActivo()){
							
							empleado.setPuesto(f.getNombre_puesto());
							empleado.setDiasTrabajadosAnnio("0");//+"<td>Dias Trabajados Año</td>"	aqui va despues del nombre del puesto
							
							if(f.getJornada().equals("0")){
								jornada = "Diurna";
							}else if(f.getJornada().equals("1")){
								jornada = "Nocturna";
							}else if(f.getJornada().equals("2")){
								jornada = "Mixta";
							}
							
							if(f.getLunes().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Lunes medio dia";
								else
									DescansoSemanal +=","+ "Lunes medio dia";
							}else if(f.getLunes().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Lunes";
								else
									DescansoSemanal +=","+ "Lunes";
							}
							
							
							if(f.getMartes().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Martes medio dia";
								else
									DescansoSemanal +=","+  "Martes medio dia";
							}else if(f.getMartes().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Martes";
								else
									DescansoSemanal +=","+ "Martes";
							}
							

							if(f.getMiercoles().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Miercoles medio dia";
								else
									DescansoSemanal +=","+  "Miercoles medio dia";
							}else if(f.getMiercoles().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Miercoles";
								else
									DescansoSemanal +=","+ "Miercoles";
							}
							

							if(f.getJueves().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Jueves medio dia";
								else
									DescansoSemanal +=","+  "Jueves medio dia";
							}else if(f.getJueves().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Jueves";
								else
									DescansoSemanal +=","+ "Jueves";
							}
							

							if(f.getViernes().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Viernes medio dia";
								else
									DescansoSemanal +=","+  "Viernes medio dia";
							}else if(f.getViernes().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Viernes";
								else
									DescansoSemanal +=","+ "Viernes";
							}
							

							if(f.getSabado().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Sabado medio dia";
								else
									DescansoSemanal +=","+  "Sabado medio dia";
							}else if(f.getSabado().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Sabado";
								else
									DescansoSemanal +=","+ "Sabado";
							}
							

							if(f.getDomingo().equals("1")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Domingo medio dia";
								else
									DescansoSemanal +=","+  "Domingo medio dia";
							}else if(f.getDomingo().equals("2")){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Domingo";
								else
									DescansoSemanal +=","+ "Domingo";
							}

							empleado.setDescansoSemanal(DescansoSemanal);
							
							empleado.setJornada(jornada);

							empleado.setHorasAlDia(f.getHorasTrabajo());
							break;
						}
					}

					
					
					String idioma ="";
					for (AuxIdioma id : itemEmpleado.getIdiomas()) {
						if(idioma.equals(""))
							idioma = id.getIdioma();
						else
							idioma += ","+id.getIdioma();
					}
		
					int nivelAcademico = 0;
					String profesion = "";
					for (AuxHistorialAcademico academico : itemEmpleado.getHistorial_academico()) {
						if(Integer.parseInt(academico.getNivel_academico()) > nivelAcademico){
							nivelAcademico = Integer.parseInt(academico.getNivel_academico());
							profesion = academico.getTitulo();
						}
					}

			 		DateTimeFormat anio = DateTimeFormat.getFormat("yyyy");
			 		//DateTimeFormat mes 	= DateTimeFormat.getFormat("MM");
			 		//DateTimeFormat diaa 	= DateTimeFormat.getFormat("dd");
			 		String formatAnio 	= "";
			 		//String formatMes 	= "";
			 		// formatDia 	= "";
			 		
			 		float bono14 = 0;
			 		float aguinaldo = 0;
			 		float comisiones = 0;
			 		float indemnizacion = 0;
			 		float otrosPagos = 0;
			 		float salarioMensualNominal = 0;
			 		float decreto7889 = 0;
			 		
					for (AuxSalario s : itemEmpleado.getSalario()) {
		 				formatAnio = anio.format(new Date(s.getFecha()));
		 				
		 				 if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
			 						&& s.getTipoSalario().equals("0"))
		 				{
		 					salarioMensualNominal += s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("1"))
		 				{
		 					decreto7889 += s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("4"))
		 				{
		 					bono14 = s.getSalario();
		 				}else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("5"))
		 				{
		 					aguinaldo = s.getSalario();
		 				}else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("2"))
		 				{
		 					comisiones += s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("7")) 
		 				{
		 					indemnizacion = s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("8")) 
		 				{
		 					otrosPagos += s.getSalario();
		 				}
		 				
		 				
		 				
					}
					empleado.setSalarioMensualNominal(""+fmt.format(salarioMensualNominal));
					
					empleado.setDecreto7889(""+fmt.format(decreto7889));
					
					empleado.setTotalHorasExtras("0");
					
					empleado.setValordeHoraExtra("0");
					
					empleado.setAguinaldo(""+fmt.format(aguinaldo));
					
					empleado.setBono14(""+fmt.format(bono14));
					
					empleado.setComisiones(""+fmt.format(comisiones));
					
					empleado.setNivelAcademico(""+nivelAcademico);
					
					empleado.setProfesion(profesion);
					
					empleado.setEtnia(itemEmpleado.getEtnia());

					empleado.setIdiomas(idioma);

					empleado.setPermisoTrabajo("0");//private String PermisoTrabajo;
					
					empleado.setTipoContrato("Indefinido");
					
					empleado.setIndemnizacion(""+fmt.format(indemnizacion));
					
					empleado.setOtrosPagos(""+fmt.format(otrosPagos));
					
					
					
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
				nuevo.AgregarColumna("31");
				nuevo.AgregarColumna("32");
				nuevo.AgregarColumna("33");
				nuevo.AgregarColumna("34");
				nuevo.AgregarColumna("35");
				nuevo.AgregarColumna("36");
				nuevo.AgregarColumna("37");
				nuevo.AgregarColumna("38");
				nuevo.AgregarColumna("39");
				//nuevo.setSize("1187px", "648px");
				absolutePanel_1.clear();
				absolutePanel_1.add(nuevo);
		}
		
				});

        load.invisible();

	}
}
