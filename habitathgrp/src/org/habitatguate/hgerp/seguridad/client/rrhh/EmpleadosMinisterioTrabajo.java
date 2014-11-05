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
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;

public class EmpleadosMinisterioTrabajo extends Composite  {

    private  Grid grid;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private ScrollPanel scrollPanel;
    private AbsolutePanel absolutePanel_1;
    private  ListBox listEstado ;
    private Loading load ;
    private ListBox listAnnio;
    private Label lblAoDelReporte;
    private List<DatosMinisterioTrabajo> DATOS;
    private String xmlInicio = "<table><tbody>"
				+"<tr>"
				+"<td>No. de empleado</td>"	
				+"<td>Tipo Documento Identificación</td>"
				+"<td>Documento Identificación</td>"	
				+"<td>Pais Origen</td>"	
				+"<td>Lugar Nacimiento</td>"	
				+"<td>Nit Empleado</td>"	
				+"<td>IGSS Empleado</td>"
				+"<td>Deportado de algún País</td>"	
				+"<td>Nombre1</td>"	
				+"<td>Nombre2</td>"	
				+"<td>Nombre3</td>"	
				+"<td>Apellido1</td>"	
				+"<td>Apellido2</td>"	
				+"<td>Estado Civil</td>"	
				+"<td>Número Hijos</td>"	
				+"<td>Fecha Nacimiento</td>"	
				+"<td>Edad aprox.</td>"	 
				+"<td>Sexo (M) O (F)</td>"	
				+"<td>Tiempo de laborar</td>"	
				+"<td>Puesto</td>"	 
				+"<td>Dias Trabajados Año</td>"	
				+"<td>Descanso Semanal</td>"	
				+"<td>Jornada</td>"	
				+"<td>Horas al Día</td>"	
				+"<td>Salario Mensual Nominal</td>"	
				+"<td>Decreto 78-89  (Q.250.00)</td>"	
				+"<td>Total Horas Extras</td>"	
				+"<td>Valor de Hora Extra </td>"	
				+"<td>Aguinaldo Decreto 76-78</td>"	
				+"<td>Bono 14 decreto 42-92</td>"	
				+"<td>Comisiones</td>"	
				+"<td>Nivel Academico</td>"	
				+"<td>Profesión</td>"
				+"<td>Etnia</td>"	 
				+"<td>Idiomas</td>"	
				+"<td>Permiso Trabajo</td>"	
				+"<td>Tipo Contrato</td>"	
				+"<td>Indemnización (Articulo 82)</td>"
				+"<td>Otros Pagos</td>"
				+"</tr>";

	String  xmlFinal = "</tbody></table>";
	private FormPanel formPanel;
	private VerticalPanel verticalPanel;
	private Button button;
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
		
		formPanel = new FormPanel();
		absolutePanel.add(formPanel, 708, 21);
		formPanel.setMethod(FormPanel.METHOD_POST);
		formPanel.setEncoding(FormPanel.METHOD_POST);
		formPanel.setAction("/ExportAs?tabla=1");
		formPanel.setSize("209px", "44px");
		
		verticalPanel = new VerticalPanel();
		formPanel.setWidget(verticalPanel);
		verticalPanel.setSize("208px", "43px");
		
		button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println("/ExportAs?tabla="+DATOS+"");
				formPanel.setAction("/ExportAs?tabla="+DATOS+"");
				formPanel.submit();
			}
		});
		button.setText("Exportar");
		button.setStylePrimaryName("sendButton");
		button.setStyleName("sendButton");
		verticalPanel.add(button);
		button.setSize("198px", "41px");
		
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
		public void onSuccess( List<AuxEmpleado> result)
		{
				DATOS = new ArrayList<DatosMinisterioTrabajo>();
				int i = 0;
				
				for (AuxEmpleado p : result) {
					DatosMinisterioTrabajo empleado = new DatosMinisterioTrabajo();
					
					empleado.setNoEmpleado(""+i);
					xmlInicio += "<td>"+i+"</td>";
					
					try{
						if(p.getPais().equals("83")){
							empleado.setTipoIdentificacion("2");
							empleado.setDocumentoIdentificacion(p.getCui());
							xmlInicio += "<td>2</td>";
							xmlInicio += "<td>"+p.getCui()+"</td>";
						}
						else{
							empleado.setTipoIdentificacion("4");
							empleado.setDocumentoIdentificacion(p.getNo_pasaporte());
							xmlInicio += "<td>4</td>";
							xmlInicio += "<td>"+p.getCui()+"</td>";
						}
					}catch(Exception e){
						empleado.setTipoIdentificacion("2");
						empleado.setDocumentoIdentificacion("");
						xmlInicio += "<td>2</td>";
						xmlInicio += "<td>"+p.getCui()+"</td>";
					}
					empleado.setPaisOrigen(p.getPais());
					xmlInicio += "<td>"+p.getPais()+"</td>";
		
					 String[] numerosComoArray2  = p.getDepto_municipio_nacimiento().split(",");
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
								xmlInicio += "<td>"+"I"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("I"+"0"+munidir);
								xmlInicio += "<td>"+"I"+munidir+"</td>";
						 }
					 }
					 else if(deptodir.equals("15")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("II"+"0"+munidir);
								xmlInicio += "<td>"+"II"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("II"+munidir);
								xmlInicio += "<td>"+"II"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("16")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("II"+"0"+munidir);
								xmlInicio += "<td>"+"II"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("II"+munidir);
								xmlInicio += "<td>"+"II"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("02")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("18")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("19")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("20")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("III"+"0"+munidir);
								xmlInicio += "<td>"+"III"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("III"+munidir);
								xmlInicio += "<td>"+"III"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("06")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("IV"+"0"+munidir);
								xmlInicio += "<td>"+"IV"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("IV"+munidir);
								xmlInicio += "<td>"+"IV"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("21")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("IV"+"0"+munidir);
								xmlInicio += "<td>"+"IV"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("IV"+munidir);
								xmlInicio += "<td>"+"IV"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("22")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("IV"+"0"+munidir);
								xmlInicio += "<td>"+"IV"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("IV"+munidir);
								xmlInicio += "<td>"+"IV"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("03")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("V"+"0"+munidir);
								xmlInicio += "<td>"+"V"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("V"+munidir);
								xmlInicio += "<td>"+"V"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("04")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("V"+"0"+munidir);
								xmlInicio += "<td>"+"V"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("V"+munidir);
								xmlInicio += "<td>"+"V"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("05")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("V"+"0"+munidir);
								xmlInicio += "<td>"+"V"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("V"+munidir);
								xmlInicio += "<td>"+"V"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("07")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("08")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("09")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("10")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("11")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("12")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VI"+"0"+munidir);
								xmlInicio += "<td>"+"VI"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VI"+munidir);
								xmlInicio += "<td>"+"VI"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("13")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VII"+"0"+munidir);
								xmlInicio += "<td>"+"VIII"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VII"+munidir);
								xmlInicio += "<td>"+"VII"+"0"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("14")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VII"+"0"+munidir);
								xmlInicio += "<td>"+"VIII"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VII"+munidir);
								xmlInicio += "<td>"+"VIII"+munidir+"</td>";
						 }}
					 else if(deptodir.equals("17")){
						 if(munidir.length()<4){
							 empleado.setLugarNacimiento("VIII"+"0"+munidir);
								xmlInicio += "<td>"+"VIII"+"0"+munidir+"</td>";
						 }else{
							 empleado.setLugarNacimiento("VIII"+munidir);
								xmlInicio += "<td>"+"VIII"+munidir+"</td>";
						 }}
		
					empleado.setNitEmpleado(p.getNit());
					xmlInicio += "<td>"+p.getNit()+"</td>";
					
					empleado.setIGSSEmpleado(p.getAfiliacion_igss());
					xmlInicio += "<td>"+p.getAfiliacion_igss()+"</td>";
					
					empleado.setDeportadoPais("");
					xmlInicio += "<td>"+""+"</td>";
					
					empleado.setNombre1(p.getPrimer_nombre());
					xmlInicio += "<td>"+p.getPrimer_nombre()+"</td>";
					
					empleado.setNombre2(p.getSegundo_nombre());
					xmlInicio += "<td>"+p.getSegundo_nombre()+"</td>";
					
					//empleado.setNombre3(p.getPrimer_nombre());
					xmlInicio += "<td>"+""+"</td>";
					
					empleado.setApellido1(p.getPrimer_apellido());
					xmlInicio += "<td>"+p.getPrimer_apellido()+"</td>";
					
					empleado.setApellido2(p.getSegundo_apellido());
					xmlInicio += "<td>"+p.getSegundo_apellido()+"</td>";
					
					empleado.setEstadoCivil(p.getEstado_civil());
					xmlInicio += "<td>"+p.getEstado_civil()+"</td>";
					
					int NoHijos = 0;
					for (AuxFamilia f : p.getFamilia()) {
						if(f.getParentesco().equals("hijo(a)"))
							NoHijos++;
					}
					empleado.setNumeroHijos(""+NoHijos);
					xmlInicio += "<td>"+NoHijos+"</td>";
					
					//fecha de naicmiento con formato dia/mes/año
					DateTimeFormat dtDia = DateTimeFormat.getFormat("dd");
					String dia = dtDia.format(new Date(p.getFecha_nacimiento()));
					DateTimeFormat dtMes = DateTimeFormat.getFormat("MM");
					String Mes = dtMes.format(new Date(p.getFecha_nacimiento()));
					DateTimeFormat dtAnio = DateTimeFormat.getFormat("yyyy");
					String Anio = dtAnio.format(new Date(p.getFecha_nacimiento()));
					
					empleado.setFechaNacimiento(dia+"/"+Mes+"/"+Anio);
					xmlInicio += "<td>"+dia+"/"+Mes+"/"+Anio+"</td>";
					
					//calculo de edad del empleado
					//resta del año de actual - año nacimiento, para calcular edad aproximada
					DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy");
					String AnnioNacimiento = dtf.format(new Date(p.getFecha_nacimiento()));
					String AnnioActual = dtf.format(new Date());
					int edadtotal = Integer.parseInt(AnnioActual)- Integer.parseInt(AnnioNacimiento);
					
					empleado.setEdad(""+edadtotal);
					xmlInicio += "<td>"+edadtotal+"</td>";
		
					if(p.getSexo().equals("0")){
						empleado.setSexo("F");
						xmlInicio += "<td>"+"F"+"</td>";
					}else{
						empleado.setSexo("M");
						xmlInicio += "<td>"+"M"+"</td>";
					}
					 Anio = dtAnio.format(new Date(p.getFecha_ingreso()));
					 String Anio2 = dtAnio.format(new Date());
					 
					
					long diaslaborados = new Date().getTime()-p.getFecha_ingreso();
					if(Integer.parseInt(Anio)< Integer.parseInt(Anio2)){
						empleado.setTiempodelaborar("365");
						xmlInicio += "<td>"+"365"+"</td>";
					}else{
						int dialaboradoss = (int) (diaslaborados /(1000 * 60 * 60 * 24));
						empleado.setTiempodelaborar(""+dialaboradoss);
						xmlInicio += "<td>"+dialaboradoss+"</td>";
					}
		
					String DescansoSemanal = "";
					String jornada = "";
					for (AuxPuesto f : p.getPuestos()) {
						if(f.isActivo()){
							
							empleado.setPuesto(f.getNombre_puesto());
							xmlInicio += "<td>"+f.getNombre_puesto()+"</td>";
							
							xmlInicio += "<td>"+""+"</td>";

							//+"<td>Dias Trabajados Año</td>"	aqui va despues del nombre del puesto
							
							if(f.getJornada().equals("0")){
								jornada = "Diurna";
							}else if(f.getJornada().equals("1")){
								jornada = "Nocturna";
							}else if(f.getJornada().equals("2")){
								jornada = "Mixta";
							}
							
							if(f.getLunes()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Lunes";
								else
									DescansoSemanal +=","+ "Lunes";
							}if(f.getMartes()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Martes";
								else
									DescansoSemanal +=","+ "Martes";
									
							}if(f.getMiercoles()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Miercoles";
								else
									DescansoSemanal +=","+ "Miercoles";
							}if(f.getJueves()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Jueves";
								else
									DescansoSemanal +=","+ "Jueves";
							}if(f.getViernes()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Viernes";
								else
									DescansoSemanal +=","+ "Viernes";
							}if(f.getSabado()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Sabado";
								else
									DescansoSemanal +=","+ "Sabado";
							}if(f.getDomingo()){
								if(DescansoSemanal.equals(""))
									DescansoSemanal +=  "Domingo";
								else
									DescansoSemanal +=","+ "Domingo";
							}

							empleado.setDescansoSemanal(DescansoSemanal);
							xmlInicio += "<td>"+DescansoSemanal+"</td>";
							
							empleado.setJornada(jornada);
							xmlInicio += "<td>"+jornada+"</td>";

							empleado.setHorasAlDia(f.getHorasTrabajo());
							xmlInicio += "<td>"+f.getHorasTrabajo()+"</td>";
							break;
						}
					}

					
					
					String idioma ="";
					for (AuxIdioma id : p.getIdiomas()) {
						if(idioma.equals(""))
							idioma = id.getIdioma();
						else
							idioma += ","+id.getIdioma();
					}
		
					int nivelAcademico = 0;
					String profesion = "";
					for (AuxHistorialAcademico academico : p.getHistorial_academico()) {
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
			 		
					for (AuxSalario s : p.getSalario()) {
		 				formatAnio = anio.format(new Date(s.getFecha()));
		 				
		 				if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
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
		 				}else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("1"))
		 				{
		 					decreto7889 = s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("7")) //abra que incluir bonos?
		 				{
		 					indemnizacion = s.getSalario();
		 				}
		 				else if(formatAnio.equals(listAnnio.getItemText(listAnnio.getSelectedIndex())) 
		 						&& s.getTipoSalario().equals("8")) //abra que incluir bonos?
		 				{
		 					otrosPagos += s.getSalario();
		 				}
		 				
		 				//falta salario mensual nominal,  y otros pagos que incluye estos dos?
		 				
					}
					empleado.setSalarioMensualNominal(""+salarioMensualNominal);
					xmlInicio += "<td>"+salarioMensualNominal+"</td>";
					
					empleado.setDecreto7889(""+decreto7889);
					xmlInicio += "<td>"+decreto7889+"</td>";
					
					empleado.setTotalHorasExtras("0");
					xmlInicio += "<td>"+"0"+"</td>";
					
					empleado.setValordeHoraExtra("0");
					xmlInicio += "<td>"+"0"+"</td>";
					
					empleado.setAguinaldo(""+aguinaldo);
					xmlInicio += "<td>"+aguinaldo+"</td>";
					
					empleado.setBono14(""+bono14);
					xmlInicio += "<td>"+bono14+"</td>";
					
					empleado.setComisiones(""+comisiones);
					xmlInicio += "<td>"+comisiones+"</td>";
					

					empleado.setNivelAcademico(""+nivelAcademico);
					xmlInicio += "<td>"+nivelAcademico+"</td>";
					
					empleado.setProfesion(profesion);
					xmlInicio += "<td>"+profesion+"</td>";
					
					empleado.setEtnia(p.getEtnia());
					xmlInicio += "<td>"+p.getEtnia()+"</td>";

					empleado.setIdiomas(idioma);
					xmlInicio += "<td>"+idioma+"</td>";

					xmlInicio += "<td>"+""+"</td>";
					//private String PermisoTrabajo;
					
					empleado.setTipoContrato("Indefinido");
					xmlInicio += "<td>"+"Indefinido"+"</td>";
					
					empleado.setIndemnizacion(""+indemnizacion);
					xmlInicio += "<td>"+indemnizacion+"</td>";
					
					empleado.setOtrosPagos(""+otrosPagos);
					xmlInicio += "<td>"+otrosPagos+"</td></tr>";
					
					
					
					DATOS.add(empleado);
					i++;
				}

		 		xmlInicio = xmlInicio + xmlFinal;
		 		System.out.println(xmlInicio);
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
