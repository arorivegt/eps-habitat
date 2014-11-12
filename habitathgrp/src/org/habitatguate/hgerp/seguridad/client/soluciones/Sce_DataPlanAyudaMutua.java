package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.Date;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.RadioButton;

public class Sce_DataPlanAyudaMutua extends Composite {

	private Sce_DataEntryEncuestaVerificacion entryFormulario;
	private Long id_empleado = 0L;
	private boolean bandera = true;
	private String depto_municipio_uno="";
	private String depto_municipio_dos="";
    private final RecursosHumanosServiceAsync RecursosHumanosService = GWT.create(RecursosHumanosService.class);
    private TextBox txtPrimerNombre;
    
	public Sce_DataPlanAyudaMutua(Sce_DataEntryEncuestaVerificacion e) {
		this.entryFormulario = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("988px", "540px");
		
		Label lblNombres = new Label("Disposici\u00F3n a trabajar el principio de Ayuda Mutua:");
		lblNombres.setStyleName("label");
		absolutePanel.add(lblNombres, 36, 70);
		lblNombres.setSize("305px", "19px");
		
		txtPrimerNombre = new TextBox();
		txtPrimerNombre.setMaxLength(50);
		txtPrimerNombre.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPrimerNombre, 36, 258);
		txtPrimerNombre.setSize("331px", "19px");
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("Guardar");
		absolutePanel.add(btnNewButton, 424, 513);
		
		Label lblExplicarClaramenteA = new Label("Explicar claramente a las familias en que consiste la participaci\u00F3n de ellos en la construcci\u00F3n de las casas y el plan de ayuda mutua.");
		lblExplicarClaramenteA.setStyleName("label");
		absolutePanel.add(lblExplicarClaramenteA, 36, 22);
		lblExplicarClaramenteA.setSize("784px", "19px");
		
		RadioButton rdbtnSi = new RadioButton("new name", "Si");
		absolutePanel.add(rdbtnSi, 345, 68);
		rdbtnSi.setSize("48px", "21px");
		
		RadioButton rdbtnNo = new RadioButton("new name", "No");
		absolutePanel.add(rdbtnNo, 412, 68);
		rdbtnNo.setSize("53px", "21px");
		
		Label lblParticipacinFamiliarEn = new Label("Participaci\u00F3n familiar en proceso:");
		lblParticipacinFamiliarEn.setStyleName("label");
		absolutePanel.add(lblParticipacinFamiliarEn, 36, 115);
		lblParticipacinFamiliarEn.setSize("305px", "19px");
		
		RadioButton radioButton = new RadioButton("new name", "Si");
		absolutePanel.add(radioButton, 345, 113);
		radioButton.setSize("48px", "21px");
		
		RadioButton radioButton_1 = new RadioButton("new name", "No");
		absolutePanel.add(radioButton_1, 412, 113);
		radioButton_1.setSize("53px", "21px");
		
		Label lblPagarCostoTotal = new Label("Pagar costo total de la casa:");
		lblPagarCostoTotal.setStyleName("label");
		absolutePanel.add(lblPagarCostoTotal, 36, 163);
		lblPagarCostoTotal.setSize("305px", "19px");
		
		RadioButton radioButton_2 = new RadioButton("new name", "Si");
		absolutePanel.add(radioButton_2, 345, 161);
		radioButton_2.setSize("48px", "21px");
		
		RadioButton radioButton_3 = new RadioButton("new name", "No");
		absolutePanel.add(radioButton_3, 412, 163);
		radioButton_3.setSize("53px", "21px");
		
		Label lblMencioneLosNombres = new Label("Mencione los nombres de las personas que le apoyar\u00E1n en el cumplimiento del principio de ayuda mutua:");
		lblMencioneLosNombres.setStyleName("label");
		absolutePanel.add(lblMencioneLosNombres, 36, 218);
		lblMencioneLosNombres.setSize("626px", "19px");
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		textBox.setMaxLength(50);
		absolutePanel.add(textBox, 36, 295);
		textBox.setSize("331px", "19px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		textBox_1.setMaxLength(50);
		absolutePanel.add(textBox_1, 436, 258);
		textBox_1.setSize("331px", "19px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox2");
		textBox_2.setMaxLength(50);
		absolutePanel.add(textBox_2, 436, 295);
		textBox_2.setSize("331px", "19px");
		
		Label lblEntiendeQueTiene = new Label("Entiende que tiene que realizar sus pagos mensualmente y de manera puntual");
		lblEntiendeQueTiene.setStyleName("label");
		absolutePanel.add(lblEntiendeQueTiene, 36, 363);
		lblEntiendeQueTiene.setSize("453px", "19px");
		
		Label lblPuntualHastaCubrir = new Label("puntual hasta cubrir el costo total de su casa, en plazo de 2, 5, 6, 8 y 10 a\u00F1os:");
		lblPuntualHastaCubrir.setStyleName("label");
		absolutePanel.add(lblPuntualHastaCubrir, 36, 388);
		lblPuntualHastaCubrir.setSize("453px", "19px");
		
		RadioButton radioButton_4 = new RadioButton("new name", "Si");
		absolutePanel.add(radioButton_4, 521, 373);
		radioButton_4.setSize("48px", "21px");
		
		RadioButton radioButton_5 = new RadioButton("new name", "No");
		absolutePanel.add(radioButton_5, 586, 373);
		radioButton_5.setSize("48px", "21px");
		
		Label lblCuotaMensualQue = new Label("Cuota mensual puede pagar:");
		lblCuotaMensualQue.setStyleName("label");
		absolutePanel.add(lblCuotaMensualQue, 36, 458);
		lblCuotaMensualQue.setSize("232px", "19px");
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setStyleName("gwt-TextBox2");
		textBox_3.setMaxLength(50);
		absolutePanel.add(textBox_3, 251, 456);
		textBox_3.setSize("116px", "19px");
		
//		btnActualizar.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				
//				try{
//					new Date(dateAnnioNacimiento.getValue().getTime());
//				}catch(Exception e){
//					dateAnnioNacimiento.setValue(new Date(1407518124684L));
//				}
//			
//				try{
//					new Date(dateFechaIngreso.getValue().getTime());
//				}catch(Exception e){
//					dateFechaIngreso.setValue(new Date(1407518124684L));
//				}
//			
//				if(bandera){
//					depto_municipio_uno = listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex()) + "," +listCedulaMunicipio.getItemText(listCedulaMunicipio.getSelectedIndex());
//					depto_municipio_dos = listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getItemText(listDireccionMunicipio.getSelectedIndex());
//					System.out.println("pais en: "+listPais.getSelectedIndex());
//					RecursosHumanosService.Insertar_Emppleado(txtNo_iggs.getText(), listEstadoCivil.getItemText(listEstadoCivil.getSelectedIndex()), 
//							listSexo.getItemText(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
//							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtConIVS.getText(), txtSinIVS.getText(), 
//							listPais.getItemText(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
//							txtNoOrden.getText(), txtRegistro.getText(), txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
//							depto_municipio_uno, txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
//							txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getItemText(listTipoLicencia.getSelectedIndex()), 
//							txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
//							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
//							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), new AsyncCallback<Long>() 
//	                        {
//	                            public void onFailure(Throwable caught) 
//	                            {
//	                                Window.alert("Error  al Guardar Datos");
//	                            }
//
////								@Override
////	                            public void onSuccess(Long result)
////	                            {
////
////	                            	id_empleado = result;
////	                            	empleado.id_empleado = result;
////	                            	bandera = false;
////	                            	empleado.Nuevas_Pestanas();
////	                            	empleado.familia_unica();
////	                                Window.alert("Nuevo Empleado Guardados exitosamente!!! "+id_empleado);
////	                            }
//
//	                     });
//				}else{
//					depto_municipio_uno = listCedulaDepartamento.getItemText(listCedulaDepartamento.getSelectedIndex()) + "," +listCedulaMunicipio.getItemText(listCedulaMunicipio.getSelectedIndex());
//					depto_municipio_dos = listDireccionDepartamento.getItemText(listDireccionDepartamento.getSelectedIndex()) + "," +listDireccionMunicipio.getItemText(listDireccionMunicipio.getSelectedIndex());
//
//					
//					RecursosHumanosService.Actualizar_Emppleado(id_empleado,txtNo_iggs.getText(), listEstadoCivil.getItemText(listEstadoCivil.getSelectedIndex()), 
//							listSexo.getItemText(listSexo.getSelectedIndex()) , txtPrimerApellido.getText(), txtSegundoApellido.getText(),
//							txtApellidoCasada.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtConIVS.getText(), txtSinIVS.getText(), 
//							listPais.getItemText(listPais.getSelectedIndex()),txtNit.getText(),listNoDependientes.getItemText(listNoDependientes.getSelectedIndex()),
//							txtNoOrden.getText(), txtRegistro.getText(), txtDPI.getText(), txtTipoPasaporte.getText(), txtNoPasaporte.getText(), 
//							depto_municipio_uno, txtDireccion.getText(), depto_municipio_dos, txtCorreoElectronico.getText(), txtTelefonoCasa.getText(), 
//							txtTelefonoCelular.getText(), dateAnnioNacimiento.getValue(), listTipoLicencia.getItemText(listTipoLicencia.getSelectedIndex()), 
//							txtNoLicencia.getText(), txtCentroTrabajo.getText(), txtOcupacion.getText(), dateFechaIngreso.getValue(), 
//							txt_CodigoOcupacion.getText(), txtProfesion.getText(), txtTipoPlanilla.getText(), Float.parseFloat(txtSalarioBase.getText()), 
//							Float.parseFloat(txtTotal.getText()), Float.parseFloat(txtBonificacion.getText()), new AsyncCallback<Long>() 
//	                        {
//	                            public void onFailure(Throwable caught) 
//	                            {
//	                                Window.alert("Error al Actualizar Datos");
//	                            }
//
//								@Override
//	                            public void onSuccess(Long result)
//	                            {
//	                            	bandera = false;
//	                                Window.alert("Datos Actualizados exitosamente!!! "+id_empleado);
//	                            }
//
//	                     });
//					
//				}
//				
//			}
//		});
	}
	
	private String Depto_Municipio(String Departamento){
		String valor = "";
		if(Departamento.equals("Alta Verapaz")){
			valor = valor + "," + "Chahal";
			valor = valor + "," + "Chisec";
			valor = valor + "," + "Coban";
			valor = valor + "," + "Fray Bartolome de las Casas";
			valor = valor + "," + "La Tinta";
			valor = valor + "," + "Lanquin";
			valor = valor + "," + "Panzos";
			valor = valor + "," + "Raxruha";
			valor = valor + "," + "San Cristobal Verapaz";
			valor = valor + "," + "San Juan Chamelco";
			valor = valor + "," + "San Pedro Carcha";
			valor = valor + "," + "Santa Cruz Verapaz";
			valor = valor + "," + "Santa Maria Cahabon";
			valor = valor + "," + "Senahu";
			valor = valor + "," + "Tamahu";
			valor = valor + "," + "Tactic";
			valor = valor + "," + "Tucuru";
			
		}else if(Departamento.equals("Baja Verapaz")){
			valor = valor + "," + "Cubulco";
			valor = valor + "," + "Granados";
			valor = valor + "," + "Purulha";
			valor = valor + "," + "Rabinal";
			valor = valor + "," + "Salama";
			valor = valor + "," + "San Jeronimo";
			valor = valor + "," + "San Miguel Chicaj";
			valor = valor + "," + "Santa Cruz el Chol";
			
		}else if(Departamento.equals("Chimaltenango")){
			valor = valor + "," + "Acatenango";
			valor = valor + "," + "Chimaltenango";
			valor = valor + "," + "El Tejar";
			valor = valor + "," + "Parramos";
			valor = valor + "," + "Patzicia";
			valor = valor + "," + "Patzun";
			valor = valor + "," + "Pochuta";
			valor = valor + "," + "San Andres Itzapa";
			valor = valor + "," + "San Jose Poaquil";
			valor = valor + "," + "San Juan Comalapa";
			valor = valor + "," + "San Martin Jilotepeque";
			valor = valor + "," + "Santa Apolonia";
			valor = valor + "," + "Santa Cruz Balanya";
			valor = valor + "," + "Tecpan";
			valor = valor + "," + "Yepocapa";
			valor = valor + "," + "Zaragoza";
			
		}else if(Departamento.equals("Chiquimula")){
			
			valor = valor + "," + "Camotan";
			valor = valor + "," + "Chiquimula";
			valor = valor + "," + "Concepcion Las Minas";
			valor = valor + "," + "Esquipulas";
			valor = valor + "," + "Ipala";
			valor = valor + "," + "Jocotan";
			valor = valor + "," + "Olopa";
			valor = valor + "," + "Quezaltepeque";
			valor = valor + "," + "San Jacinto";
			valor = valor + "," + "San Jose la Arada";
			valor = valor + "," + "San Juan Ermita";
			
		}else if(Departamento.equals("El Progreso")){
			valor = valor + "," + "El Jicaro";
			valor = valor + "," + "Guastatoya";
			valor = valor + "," + "Morazan";
			valor = valor + "," + "San Agustin Acasaguastlan";
			valor = valor + "," + "San Antonio La Paz";
			valor = valor + "," + "San Cristobal Acasaguastlan";
			valor = valor + "," + "Sanarate";
			valor = valor + "," + "Sansare";
			
		}else if(Departamento.equals("Escuintla")){			
			valor = valor + "," + "Escuintla";
			valor = valor + "," + "Guanagazapa";
			valor = valor + "," + "Iztapa";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "La Gomera";
			valor = valor + "," + "Masagua";
			valor = valor + "," + "Nueva Concepcion";
			valor = valor + "," + "Palin";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "San Vicente Pacaya";
			valor = valor + "," + "Santa Lucia Cotzumalguapa";
			valor = valor + "," + "Siquinala";
			valor = valor + "," + "Tiquisate";
			
		}else if(Departamento.equals("Guatemala")){	
			valor = valor + "," + "Amatitlan";
			valor = valor + "," + "Chinautla";
			valor = valor + "," + "Chuarrancho";
			valor = valor + "," + "Ciudad de Guatemala";
			valor = valor + "," + "Fraijanes";
			valor = valor + "," + "Mixco";
			valor = valor + "," + "Palencia";
			valor = valor + "," + "San Jose del Golfo";
			valor = valor + "," + "San Jose Pinula";
			valor = valor + "," + "San Juan Sacatepequez";
			valor = valor + "," + "San Miguel Petapa";
			valor = valor + "," + "San Pedro Ayampuc";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Raymundo";
			valor = valor + "," + "Santa Catarina Pinula";
			valor = valor + "," + "Villa Canales";
			valor = valor + "," + "Villa Nueva";
			
		}else if(Departamento.equals("Huehuetenango")){
			valor = valor + "," + "Aguacatan";
			valor = valor + "," + "Chiantla";
			valor = valor + "," + "Colotenango";
			valor = valor + "," + "Concepcion Huista";
			valor = valor + "," + "Cuilco";
			valor = valor + "," + "Huehuetenango";
			valor = valor + "," + "Jacaltenango";
			valor = valor + "," + "La Democracia";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "Malacatancito";
			valor = valor + "," + "Nenton";
			valor = valor + "," + "San Antonio Huista";
			valor = valor + "," + "San Gaspar Ixchil";
			valor = valor + "," + "San Ildefonso Ixtahuacan";
			valor = valor + "," + "San Juan Atitan";
			valor = valor + "," + "San Juan Ixcoy";
			valor = valor + "," + "San Mateo Ixtatan";
			valor = valor + "," + "San Miguel Acatan";
			valor = valor + "," + "San Pedro Necta";
			valor = valor + "," + "San Pedro Soloma";
			valor = valor + "," + "San Rafael La Independencia";
			valor = valor + "," + "San Rafael Petzal";
			valor = valor + "," + "San Sebastian Coatan";
			valor = valor + "," + "San Sebastian Huehuetenango";
			valor = valor + "," + "Santa Ana Huista";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "Santa Cruz Barillas";
			valor = valor + "," + "Santa Eulalia";
			valor = valor + "," + "Santiago Chimaltenango";
			valor = valor + "," + "Tectitan";
			valor = valor + "," + " Santos Cuchumatan";
			valor = valor + "," + "Union Cantinil";
			
		}else if(Departamento.equals("Izabal")){
			valor = valor + "," + "El Estor";
			valor = valor + "," + "Livingston";
			valor = valor + "," + "Los Amates";
			valor = valor + "," + "Morales";
			valor = valor + "," + "Puerto Barrios";
			
		}else if(Departamento.equals("Jalapa")){
			valor = valor + "," + "Jalapa";
			valor = valor + "," + "Mataquescuintla";
			valor = valor + "," + "Monjas";
			valor = valor + "," + "San Carlos Alzatate";
			valor = valor + "," + "San Luis Jilotepeque";
			valor = valor + "," + "San Manuel Chaparron";
			valor = valor + "," + "San Pedro Pinula";
			
		}else if(Departamento.equals("Jutiapa")){
			valor = valor + "," + "Agua Blanca";
			valor = valor + "," + "Asuncion Mita";
			valor = valor + "," + "Atescatempa";
			valor = valor + "," + "Comapa";
			valor = valor + "," + "Conguaco";
			valor = valor + "," + "El Adelanto";
			valor = valor + "," + "El Progreso";
			valor = valor + "," + "Jalpatagua";
			valor = valor + "," + "Jerez";
			valor = valor + "," + "Jutiapa";
			valor = valor + "," + "Moyuta";
			valor = valor + "," + "Pasaco";
			valor = valor + "," + "Quesada";
			valor = valor + "," + "San Jose Acatempa";
			valor = valor + "," + "Santa Catarina Mita";
			valor = valor + "," + "Yupiltepeque";
			valor = valor + "," + "Zapotitlan";
			
		}else if(Departamento.equals("Peten")){
			valor = valor + "," + "Dolores";
			valor = valor + "," + "El Chal";
			valor = valor + "," + "Flores";
			valor = valor + "," + "La Libertad";
			valor = valor + "," + "Las Cruces";
			valor = valor + "," + "Melchor de Mencos";
			valor = valor + "," + "Poptun";
			valor = valor + "," + "San Andres";
			valor = valor + "," + "San Benito";
			valor = valor + "," + "San Francisco";
			valor = valor + "," + "San Jose";
			valor = valor + "," + "San Luis";
			valor = valor + "," + "Santa Ana";
			valor = valor + "," + "Sayaxche";
			
		}else if(Departamento.equals("Quezaltenango")){
			valor = valor + "," + "Almolonga";
			valor = valor + "," + "Cabrican";
			valor = valor + "," + "Cajola";
			valor = valor + "," + "Cantel";
			valor = valor + "," + "Coatepeque";
			valor = valor + "," + "Colomba Costa Cuca";
			valor = valor + "," + "Concepcion Chiquirichapa";
			valor = valor + "," + "El Palmar";
			valor = valor + "," + "Flores Costa Cuca";
			valor = valor + "," + "Genova";
			valor = valor + "," + "Huitan";
			valor = valor + "," + "La Esperanza";
			valor = valor + "," + "Olintepeque";
			valor = valor + "," + "Palestina de Los Altos";
			valor = valor + "," + "Quetzaltenango";
			valor = valor + "," + "Salcaja";
			valor = valor + "," + "San Carlos Sija";
			valor = valor + "," + "San Francisco La Union";
			valor = valor + "," + "San Juan Ostuncalco";
			valor = valor + "," + "San Martin Sacatepequez";
			valor = valor + "," + "San Mateo";
			valor = valor + "," + "San Miguel Sigüila";
			valor = valor + "," + "Sibilia";
			valor = valor + "," + "Zunil";
			
		}else if(Departamento.equals("Quiche")){
			valor = valor + "," + "Canilla";
			valor = valor + "," + "Chajul";
			valor = valor + "," + "Chicaman";
			valor = valor + "," + "Chiche";
			valor = valor + "," + "Chichicastenango";
			valor = valor + "," + "Chinique";
			valor = valor + "," + "Cunen";
			valor = valor + "," + "Ixcan";
			valor = valor + "," + "Joyabaj";
			valor = valor + "," + "Nebaj";
			valor = valor + "," + "Pachalum";
			valor = valor + "," + "Patzite";
			valor = valor + "," + "Sacapulas";
			valor = valor + "," + "San Andres Sajcabaja";
			valor = valor + "," + "San Antonio Ilotenango";
			valor = valor + "," + "San Bartolome Jocotenango";
			valor = valor + "," + "San Juan Cotzal";
			valor = valor + "," + "San Pedro Jocopilas";
			valor = valor + "," + "Santa Cruz del Quiche";
			valor = valor + "," + "Uspantan";
			valor = valor + "," + "Zacualpa";
			
		}else if(Departamento.equals("Retalhuleu")){
			valor = valor + "," + "Champerico";
			valor = valor + "," + "El Asintal";
			valor = valor + "," + "Nuevo San Carlos";
			valor = valor + "," + "Retalhuleu";
			valor = valor + "," + "San Andres Villa Seca";
			valor = valor + "," + "San Felipe";
			valor = valor + "," + "San Martin Zapotitlan";
			valor = valor + "," + "San Sebastian";
			valor = valor + "," + "Santa Cruz Mulua";
			
		}else if(Departamento.equals("Sacatepequez")){
			valor = valor + "," + "Alotenango";
			valor = valor + "," + "Ciudad Vieja";
			valor = valor + "," + "Jocotenango";
			valor = valor + "," + "La Antigua Guatemala";
			valor = valor + "," + "Magdalena Milpas Altas";
			valor = valor + "," + "Pastores";
			valor = valor + "," + "San Antonio Aguas Calientes";
			valor = valor + "," + "San Bartolome Milpas Altas";
			valor = valor + "," + "San Lucas Sacatepequez";
			valor = valor + "," + "San Miguel Dueñas";
			valor = valor + "," + "Santa Catarina Barahona";
			valor = valor + "," + "Santa Lucia Milpas Altas";
			valor = valor + "," + "Santa Maria de Jesus";
			valor = valor + "," + "Santiago Sacatepequez";
			valor = valor + "," + "Santo Domingo Xenacoj";
			valor = valor + "," + "Sumpango";;
			
		}else if(Departamento.equals("San Marcos")){
			valor = valor + "," + "Ayutla";
			valor = valor + "," + "Catarina";
			valor = valor + "," + "Comitancillo";
			valor = valor + "," + "Concepcion Tutuapa";
			valor = valor + "," + "El Quetzal";
			valor = valor + "," + "El Tumbador";
			valor = valor + "," + "Esquipulas Palo Gordo";
			valor = valor + "," + "Ixchiguan";
			valor = valor + "," + "La Blanca";
			valor = valor + "," + "La Reforma";
			valor = valor + "," + "Malacatan";
			valor = valor + "," + "Nuevo Progreso";
			valor = valor + "," + "Ocos";
			valor = valor + "," + "Pajapita";
			valor = valor + "," + "Rio Blanco";
			valor = valor + "," + "San Antonio Sacatepequez";
			valor = valor + "," + "San Cristobal Cucho";
			valor = valor + "," + "San Jose El Rodeo";
			valor = valor + "," + "San Jose Ojetenam";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "San Marcos";
			valor = valor + "," + "San Miguel Ixtahuacan";
			valor = valor + "," + "San Pablo";
			valor = valor + "," + "San Pedro Sacatepequez";
			valor = valor + "," + "San Rafael Pie de la Cuesta";
			valor = valor + "," + "Sibinal";
			valor = valor + "," + "Sipacapa";
			valor = valor + "," + "Tacana";
			valor = valor + "," + "Tajumulco";
			valor = valor + "," + "Tejutla";
			
		}else if(Departamento.equals("Santa Rosa")){
			valor = valor + "," + "Barberena";
			valor = valor + "," + "Casillas";
			valor = valor + "," + "Chiquimulilla";
			valor = valor + "," + "Cuilapa";
			valor = valor + "," + "Guazacapan";
			valor = valor + "," + "Nueva Santa Rosa";
			valor = valor + "," + "Oratorio";
			valor = valor + "," + "Pueblo Nuevo Viñas";
			valor = valor + "," + "San Juan Tecuaco";
			valor = valor + "," + "San Rafael las Flores";
			valor = valor + "," + "Santa Cruz Naranjo";
			valor = valor + "," + "Santa Maria Ixhuatan";
			valor = valor + "," + "Santa Rosa de Lima";
			valor = valor + "," + "Taxisco";
			
		}else if(Departamento.equals("Solola")){
			valor = valor + "," + "Concepcion";
			valor = valor + "," + "Nahuala";
			valor = valor + "," + "Panajachel";
			valor = valor + "," + "San Andres Semetabaj";
			valor = valor + "," + "San Antonio Palopo";
			valor = valor + "," + "San Jose Chacaya";
			valor = valor + "," + "San Juan La Laguna";
			valor = valor + "," + "San Lucas Toliman";
			valor = valor + "," + "San Marcos La Laguna";
			valor = valor + "," + "San Pablo La Laguna";
			valor = valor + "," + "San Pedro La Laguna";
			valor = valor + "," + "Santa Catarina Ixtahuacan";
			valor = valor + "," + "Santa Catarina Palopo";
			valor = valor + "," + "Santa Clara La Laguna";
			valor = valor + "," + "Santa Cruz La Laguna";
			valor = valor + "," + "Santa Lucia Utatlan";
			valor = valor + "," + "Santa Maria Visitacion";
			valor = valor + "," + "Santiago Atitlan";
			valor = valor + "," + "Solola";
			
		}else if(Departamento.equals("Suchitepequez")){
			valor = valor + "," + "Chicacao";
			valor = valor + "," + "Cuyotenango";
			valor = valor + "," + "Mazatenango";
			valor = valor + "," + "Patulul";
			valor = valor + "," + "Pueblo Nuevo";
			valor = valor + "," + "Rio Bravo";
			valor = valor + "," + "Samayac";
			valor = valor + "," + "San Antonio Suchitepequez";
			valor = valor + "," + "San Bernardino";
			valor = valor + "," + "San Francisco Zapotitlan";
			valor = valor + "," + "San Gabriel";
			valor = valor + "," + "San Jose El Idolo";
			valor = valor + "," + "San Jose La Maquina";
			valor = valor + "," + "San Juan Bautista";
			valor = valor + "," + "San Lorenzo";
			valor = valor + "," + "San Miguel Panan";
			valor = valor + "," + "San Pablo Jocopilas";
			valor = valor + "," + "Santa Barbara";
			valor = valor + "," + "Santo Domingo Suchitepequez";
			valor = valor + "," + "Santo Tomas La Union";
			valor = valor + "," + "Zunilito";
			
		}else if(Departamento.equals("Totonicapan")){
			valor = valor + "," + "Momostenango";
			valor = valor + "," + "San Andres Xecul";
			valor = valor + "," + "San Bartolo";
			valor = valor + "," + "San Cristobal Totonicapan";
			valor = valor + "," + "San Francisco El Alto";
			valor = valor + "," + "Santa Lucia La Reforma";
			valor = valor + "," + "Santa Maria Chiquimula";
			valor = valor + "," + "Totonicapan";
			
		}else if(Departamento.equals("Zacapa")){
			valor = valor + "," + "Cabañas";
			valor = valor + "," + "Estanzuela";
			valor = valor + "," + "Gualan";
			valor = valor + "," + "Huite";
			valor = valor + "," + "La Union";
			valor = valor + "," + "Rio Hondo";
			valor = valor + "," + "San Diego";
			valor = valor + "," + "San Jorge";
			valor = valor + "," + "Teculutan";
			valor = valor + "," + "Usumatlan";
			valor = valor + "," + "Zacapa";
			
		}
		return valor;
	}
	
	public void LlenarDatos(Long id,String listEstadoCivil,String listSexo,String txtPrimerApellido,
		    String txtSegundoApellido , String txtApellidoCasada ,String txtNo_iggs, String txtPrimerNombre,
		    String txtSegundoNombre ,String listPais,String listNoDependientes , String txtTipoPasaporte ,
		    String listCedulaMunicipio,String txtDireccion , String listDireccionMunicipio, String txtCorreoElectronico,
		    String listTipoLicencia, Long dateAnnioNacimiento,String txtOcupacion , String txtCentroTrabajo,
		    String txt_CodigoOcupacion, String txtProfesion,String txtTipoPlanilla, Long dateFechaIngreso,
		    String txtRegistro , String txtNoOrden , String txtDPI,String txtTelefonoCasa, String txtTelefonoCelular ,
		    String txtNoLicencia, String txtNit, String txtNoPasaporte,String txtSalarioBase ,String txtBonificacion ,
		    String txtTotal, String listCedulaDepartamento , String listDireccionDepartamento ,String txtConIVS ,
		    String txtSinIVS )
	{
		this.id_empleado = id;
		this.bandera = false;
//		this.txtNo_iggs.setText(txtNo_iggs);
        boolean bandera = true;
//        for(int i=0; i < this.listEstadoCivil.getItemCount() && bandera; i++){
//            bandera = !this.listEstadoCivil.getItemText(i).equals(listEstadoCivil);
//            this.listEstadoCivil.setSelectedIndex(i);
//        }   

        bandera = true;
//        for(int i=0; i < this.listSexo.getItemCount() && bandera; i++){
//            bandera = !this.listSexo.getItemText(i).equals(listSexo);
//            this.listSexo.setSelectedIndex(i);
//        }   
//		this.txtPrimerApellido.setText(txtPrimerApellido);
//		this.txtSegundoApellido.setText(txtSegundoApellido);
//		this.txtApellidoCasada.setText(txtApellidoCasada);
		this.txtPrimerNombre.setText(txtPrimerNombre);
//		this.txtSegundoNombre.setText(txtSegundoNombre);
//		this.txtConIVS.setText(txtConIVS);
//		this.txtSinIVS.setText(txtSinIVS);
        bandera = true;
//        for(int i=0; i < this.listPais.getItemCount() && bandera; i++){
//           bandera = !this.listPais.getItemText(i).equals(listPais);
//           this.listPais.setSelectedIndex(i);
//        }   
//		this.txtNit.setText(txtNit);
        bandera = true;
//        for(int i=0; i < this.listNoDependientes.getItemCount() && bandera; i++){
//            bandera = !this.listNoDependientes.getItemText(i).equals(listNoDependientes);
//            this.listNoDependientes.setSelectedIndex(i);
//        }   
//		this.txtNoOrden.setText(txtNoOrden);
//		this.txtRegistro.setText(txtRegistro);
//		this.txtDPI.setText(txtDPI);
//		this.txtTipoPasaporte.setText(txtTipoPasaporte);
//		this.txtNoPasaporte.setText(txtNoPasaporte);
//		this.txtDireccion.setText(txtDireccion);
//		this.textBox_direccionActual_sce.setText(txtCorreoElectronico);
//		this.integerBox_telefonoCelular.setText(txtTelefonoCasa);
//		this.integerBox_telefonoCasa_sce.setText(txtTelefonoCelular);
		//SimpleDateFormat formatter = new SimpleDateFormat("dow mon dd HH:mm:ss zzz yyyy");
		//Date date = formatter.parse(dateAnnioNacimiento);
		
//		this.dateAnnioNacimiento.setValue(new Date(dateAnnioNacimiento));
        bandera = true;
//        for(int i=0; i < this.listTipoLicencia.getItemCount() && bandera; i++){
//            bandera = this.listTipoLicencia.getItemText(i).equals(listTipoLicencia);
//            this.listTipoLicencia.setSelectedIndex(i);
//        }   
//		this.txtNoLicencia.setText(txtNoLicencia);
//		this.txtCentroTrabajo.setText(txtCentroTrabajo);
//		this.txtOcupacion.setText(txtOcupacion);
		//Date date2 = formatter.parse(dateFechaIngreso);
//		this.dateFechaIngreso.setValue(new Date(dateFechaIngreso));
//		this.txt_CodigoOcupacion.setText(txt_CodigoOcupacion);
//		this.txtProfesion.setText(txtProfesion);
//		this.txtTipoPlanilla.setText(txtTipoPlanilla);
//		this.txtSalarioBase.setText(txtSalarioBase);
//		this.txtTotal.setText(txtTotal);
//		this.txtBonificacion.setText(txtBonificacion);

		System.out.println(listDireccionDepartamento);
        bandera = true;
//        for(int i=0; i < this.listDireccionDepartamento.getItemCount() && bandera; i++){
//            bandera = !this.listDireccionDepartamento.getItemText(i).equals(listDireccionDepartamento);
//            this.listDireccionDepartamento.setSelectedIndex(i);
//        }   
        

		System.out.println(listCedulaDepartamento);
        bandera = true;
//        for(int i=0; i < this.listCedulaDepartamento.getItemCount() && bandera; i++){
//            bandera = !this.listCedulaDepartamento.getItemText(i).equals(listCedulaDepartamento);
//            this.listCedulaDepartamento.setSelectedIndex(i);
//        }   

//        this.listCedulaMunicipio.clear();
//        String[] numerosComoArray = Depto_Municipio(this.listCedulaDepartamento.getItemText(this.listCedulaDepartamento.getSelectedIndex())).split(",");
//        for (int i = 0; i < numerosComoArray.length; i++) {
//        	this.listCedulaMunicipio.addItem(numerosComoArray[i]);
//        }


//        this.listDireccionMunicipio.clear();
//        String[] numerosComoArray2 = Depto_Municipio(this.listDireccionDepartamento.getItemText(this.listDireccionDepartamento.getSelectedIndex())).split(",");
//        for (int i = 0; i < numerosComoArray2.length; i++) {
//        	this.listDireccionMunicipio.addItem(numerosComoArray2[i]);
//        }
		System.out.println(listCedulaMunicipio);
        bandera = true;
//        for(int i=0; i < this.listCedulaMunicipio.getItemCount() && bandera; i++){
//            bandera = !this.listCedulaMunicipio.getItemText(i).equals(listCedulaMunicipio);
//            this.listCedulaMunicipio.setSelectedIndex(i);
//        }   

		System.out.println(listDireccionMunicipio);
        bandera = true;
//        for(int i=0; i < this.listDireccionMunicipio.getItemCount() && bandera; i++){
//            bandera = !this.listDireccionMunicipio.getItemText(i).equals(listDireccionMunicipio);
//            this.listDireccionMunicipio.setSelectedIndex(i);
//        }   
				  
		
	}
}
