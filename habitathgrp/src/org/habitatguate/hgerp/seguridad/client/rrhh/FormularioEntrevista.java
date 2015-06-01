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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class FormularioEntrevista extends Composite {

	private Mensaje mensaje; 
	 private Empleado empleado;
	 private boolean bandera = true;
     private Long id_entrevista = 0L;
	 private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
	
	 private TextArea txtQueConoces;
	 private TextArea txtPorque_Trabajar ;
	 private TextArea txtComoDescribe ;
	 private TextArea txtMetas;
	 private ListBox listA;
	 private ListBox listB ;
	 private ListBox listC ;
	 private ListBox listE ;
	 private ListBox listF ;
	 private ListBox listG ;
	 private ListBox listH ;
	 private ListBox listI ;
	 private ListBox listJ;
	 private ListBox listDeudaEn ;
	 private TextArea txtEnfermedades;
	 private TextArea txtPresion;
	 private ListBox txtNombreEmpresa ;
	 private ListBox listNoDependientes ;
	 private ListBox listAlquila ;
	 private TextArea txtOtrosIngresos ;
	 private TextBox txtEntrevistoA;
	 private DateBox dateFecha ;
	 private DoubleBox txtAporteCasa;
	 private DoubleBox txtAmortizacion ;
	 private DoubleBox txtPagoMensual ;
	 private DoubleBox txtPretencionSalarial;
     private Loading load ;
     private Button btnGuardar;
	 boolean valor = true;
	 
	 private TextBox txtEntrevistoB;
	 private TextBox txtEntrevistoC;
	 private TextBox txtEntrevistoD;
	 private TextArea txtObservacion1;
	 private TextArea txtObservacion2;
	 private TextArea txtObservacion3;
	 private TextArea txtObservacion4;
	 private TextArea txtObservacion5;
	 private DateBox dateFechaDeudaInicio;
	 private DateBox dateFechaDeudaFinal;
	 private TextArea motivoDeuda;
	 private ListBox listDeudas ;
   

	public FormularioEntrevista(Empleado empleadoo) {

		mensaje = new Mensaje();
		this.empleado = empleadoo;
		
    	load = new Loading();
        load.Mostrar();
        load.invisible();
        
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1169px", "2000px");
		
		txtQueConoces = new TextArea();
		//txtQueConoces.getElement().setAttribute("maxlength", "500");
		txtQueConoces.setStyleName("gwt-TextBox");
		absolutePanel.add(txtQueConoces, 10, 91);
		txtQueConoces.setSize("272px", "39px");
		
		txtPorque_Trabajar = new TextArea();
		//txtPorque_Trabajar.getElement().setAttribute("maxlength", "500");
		txtPorque_Trabajar.setStyleName("gwt-TextBox");
		absolutePanel.add(txtPorque_Trabajar, 458, 91);
		txtPorque_Trabajar.setSize("272px", "39px");
		
		txtComoDescribe = new TextArea();
		//txtComoDescribe.getElement().setAttribute("maxlength", "500");
		txtComoDescribe.setStyleName("gwt-TextBox");
		absolutePanel.add(txtComoDescribe, 10, 200);
		txtComoDescribe.setSize("272px", "39px");
		
		txtPresion = new TextArea();
		//txtPresion.getElement().setAttribute("maxlength", "500");
		txtPresion.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtPresion, 458, 200);
		txtPresion.setSize("272px", "39px");
		
		txtMetas = new TextArea();
		//txtMetas.getElement().setAttribute("maxlength", "1000");
		txtMetas.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtMetas, 10, 306);
		txtMetas.setSize("720px", "83px");
		
		listA = new ListBox();
		listA.addItem("Si");
		listA.addItem("No");
		listA.setStyleName("gwt-TextBox2");
		absolutePanel.add(listA, 643, 474);
		listA.setSize("137px", "26px");
		
		listB = new ListBox();
		listB.addItem("Si");
		listB.addItem("No");
		listB.setStyleName("gwt-TextBox2");
		absolutePanel.add(listB, 643, 506);
		listB.setSize("137px", "26px");
		
		listC = new ListBox();
		listC.addItem("Si");
		listC.addItem("No");
		listC.setStyleName("gwt-TextBox2");
		absolutePanel.add(listC, 643, 538);
		listC.setSize("137px", "26px");
		
		listE = new ListBox();
		listE.addItem("Si");
		listE.addItem("No");
		listE.setStyleName("gwt-TextBox2");
		absolutePanel.add(listE, 643, 570);
		listE.setSize("137px", "26px");
		
		listF = new ListBox();
		listF.addItem("Si");
		listF.addItem("No");
		listF.setStyleName("gwt-TextBox2");
		absolutePanel.add(listF, 643, 604);
		listF.setSize("137px", "26px");
		
		listG = new ListBox();
		listG.addItem("Si");
		listG.addItem("No");
		listG.setStyleName("gwt-TextBox2");
		absolutePanel.add(listG, 643, 636);
		listG.setSize("137px", "26px");
		
		listH = new ListBox();
		listH.addItem("Si");
		listH.addItem("No");
		listH.setStyleName("gwt-TextBox2");
		absolutePanel.add(listH, 643, 668);
		listH.setSize("137px", "26px");
		
		listI = new ListBox();
		listI.addItem("Si");
		listI.addItem("No");
		listI.setStyleName("gwt-TextBox2");
		absolutePanel.add(listI, 643, 700);
		listI.setSize("137px", "26px");
		
		listJ = new ListBox();
		listJ.addItem("Si");
		listJ.addItem("No");
		listJ.setStyleName("gwt-TextBox2");
		absolutePanel.add(listJ, 643, 732);
		listJ.setSize("137px", "26px");
		
		txtEnfermedades = new TextArea();
		txtEnfermedades.getElement().setAttribute("maxlength", "500");
		txtEnfermedades.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtEnfermedades, 10, 842);
		txtEnfermedades.setSize("720px", "64px");
		
		txtAporteCasa = new DoubleBox();
		txtAporteCasa.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtAporteCasa.getText().equals("")) {txtAporteCasa.setText("0");}
				else if(txtAporteCasa.getText().equals(null)) {txtAporteCasa.setText("0");}
				else{
					try{
						Float.parseFloat(txtAporteCasa.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nAporte a Casa no valido");
						txtAporteCasa.setText("0.0");
					}
				}
			}
		});
		txtAporteCasa.setText("0.0");
		txtAporteCasa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtAporteCasa, 10, 1016);
		txtAporteCasa.setSize("227px", "34px");
		
		txtNombreEmpresa = new ListBox();
		txtNombreEmpresa.addItem("Antigua","0");
		txtNombreEmpresa.addItem("Azteca","1");
		txtNombreEmpresa.addItem("Agromercantil","2");
		txtNombreEmpresa.addItem("Banrural","3");
		txtNombreEmpresa.addItem("City","4");
		txtNombreEmpresa.addItem("CHN","5");
		txtNombreEmpresa.addItem("G&T Continental","6");
		txtNombreEmpresa.addItem("Guatemala","7");
		txtNombreEmpresa.addItem("Promerica","8");
		txtNombreEmpresa.addItem("Reformador","9");
		txtNombreEmpresa.addItem("Fichosa","10");
		txtNombreEmpresa.addItem("InterBanco","11");
		txtNombreEmpresa.addItem("Inmobiliario","12");
		txtNombreEmpresa.addItem("ViviBanco","13");
		txtNombreEmpresa.addItem("Industrial","14");
		txtNombreEmpresa.addItem("Trabajadores","15");
		txtNombreEmpresa.addItem("Fundación Hábitat","16");
		txtNombreEmpresa.addItem("MiCope","17");
		txtNombreEmpresa.addItem("COOPERATIVA HUNA COOP R.L.","18");
		txtNombreEmpresa.addItem("COINIPAZ","18");
		txtNombreEmpresa.addItem("COINACREDE R.L.","19");
		txtNombreEmpresa.addItem("COOPERATIVA CENDIST, R.L.","20");
		txtNombreEmpresa.addItem("COOPERATIVA INNOVIC R.L.","21");
		txtNombreEmpresa.addItem("COOPERATIVA EL MONOLITO R.L.","22");
		txtNombreEmpresa.addItem("Otras Cooperativas","23");		
		txtNombreEmpresa.addItem("Otras Instancias financieras","24");
		txtNombreEmpresa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreEmpresa, 264, 1016);
		txtNombreEmpresa.setSize("227px", "34px");
		
		txtPretencionSalarial = new DoubleBox();
		txtPretencionSalarial.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPretencionSalarial.getText().equals("")) {txtPretencionSalarial.setText("0");}
				else if(txtPretencionSalarial.getText().equals(null)) {txtPretencionSalarial.setText("0");}
				else{
					try{
						Float.parseFloat(txtPretencionSalarial.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nPretencion Salarial no valido");
						txtPretencionSalarial.setText("0.0");
					}
				}
			}
		});
		txtPretencionSalarial.setText("0.0");
		txtPretencionSalarial.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPretencionSalarial, 551, 1016);
		txtPretencionSalarial.setSize("227px", "34px");
		
		listDeudas = new ListBox();
		listDeudas.addItem("Si");
		listDeudas.addItem("No");
		listDeudas.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDeudas, 10, 1133);
		listDeudas.setSize("47px", "36px");
		
		txtAmortizacion = new DoubleBox();
		txtAmortizacion.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtAmortizacion.getText().equals("")) {txtAmortizacion.setText("0");}
				else if(txtAmortizacion.getText().equals(null)) {txtAmortizacion.setText("0");}
				else{
					try{
						Float.parseFloat(txtAmortizacion.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nAmortizacion no valido");
						txtAmortizacion.setText("0.0");
					}
				}
			}
		});
		txtAmortizacion.setText("0.0");
		txtAmortizacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtAmortizacion, 71, 1133);
		txtAmortizacion.setSize("157px", "34px");
		
		dateFechaDeudaInicio = new DateBox();
		dateFechaDeudaInicio.getTextBox().setReadOnly(true);
		dateFechaDeudaInicio.setValue(new Date(1407518819070L));
		dateFechaDeudaInicio.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFechaDeudaInicio.getDatePicker().setYearArrowsVisible(true);
		dateFechaDeudaInicio.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFechaDeudaInicio.getDatePicker().setVisibleYearCount(100);
		dateFechaDeudaInicio.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFechaDeudaInicio, 241, 1133);
		dateFechaDeudaInicio.setSize("148px", "34px");
		
		dateFechaDeudaFinal = new DateBox();
		dateFechaDeudaFinal.getTextBox().setReadOnly(true);
		dateFechaDeudaFinal.setValue(new Date(1407518819070L));
		dateFechaDeudaFinal.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFechaDeudaFinal.getDatePicker().setYearArrowsVisible(true);
		dateFechaDeudaFinal.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFechaDeudaFinal.getDatePicker().setVisibleYearCount(100);
		dateFechaDeudaFinal.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFechaDeudaFinal, 406, 1133);
		dateFechaDeudaFinal.setSize("148px", "34px");
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        load.visible();
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
			
				if(bandera) {
					loginService.Insertar_Entrevista( empleado.id_empleado, dateFecha.getValue(), txtQueConoces.getText(), 
							txtPorque_Trabajar.getText(),txtComoDescribe.getText(), txtPresion.getText(), txtMetas.getText(),
							listA.getItemText(listA.getSelectedIndex()).equals("Si"), 
                            listB.getItemText(listB.getSelectedIndex()).equals("Si"), listC.getItemText(listC.getSelectedIndex()).equals("Si"), 
                            Float.parseFloat(txtPretencionSalarial.getText()), listE.getItemText(listE.getSelectedIndex()).equals("Si"), 
                            listF.getItemText(listF.getSelectedIndex()).equals("Si"),listG.getItemText(listG.getSelectedIndex()).equals("Si"), 
                            listH.getItemText(listH.getSelectedIndex()).equals("Si"), listI.getItemText(listI.getSelectedIndex()).equals("Si"), 
                            listJ.getItemText(listJ.getSelectedIndex()).equals("Si"), txtEntrevistoA.getText(), txtEnfermedades.getText(),  
                            Float.parseFloat(txtAporteCasa.getText()),listDeudas.getItemText(listDeudas.getSelectedIndex()).equals("Si"), 
                            Integer.parseInt(listNoDependientes.getItemText(listNoDependientes.getSelectedIndex())), txtNombreEmpresa.getValue(txtNombreEmpresa.getSelectedIndex()),  
                            listAlquila.getItemText(listAlquila.getSelectedIndex()).equals("Si"),Float.parseFloat(txtPagoMensual.getText()),
			                txtOtrosIngresos.getText(),Float.parseFloat(txtAmortizacion.getText()), txtEntrevistoB.getText(), txtEntrevistoC.getText(),txtEntrevistoD.getText(),
			                txtObservacion1.getText(),txtObservacion2.getText(), txtObservacion3.getText(),txtObservacion4.getText(), txtObservacion5.getText(),
			           	   dateFechaDeudaInicio.getValue(), dateFechaDeudaFinal.getValue(), motivoDeuda.getText(),listDeudaEn.getValue(listDeudaEn.getSelectedIndex()),new AsyncCallback<Long>(){
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
							id_entrevista = result;
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        }

                 });
					}else{
						System.out.println(listJ.getItemText(listJ.getSelectedIndex()).equals("Si"));
						loginService.Actualizar_Entrevista(empleado.id_empleado,id_entrevista, dateFecha.getValue(), txtQueConoces.getText(), 
								txtPorque_Trabajar.getText(),txtComoDescribe.getText(), txtPresion.getText(), txtMetas.getText(),
								listA.getItemText(listA.getSelectedIndex()).equals("Si"), 
	                            listB.getItemText(listB.getSelectedIndex()).equals("Si"), listC.getItemText(listC.getSelectedIndex()).equals("Si"), 
	                            Float.parseFloat(txtPretencionSalarial.getText()), listE.getItemText(listE.getSelectedIndex()).equals("Si"), 
	                            listF.getItemText(listF.getSelectedIndex()).equals("Si"),listG.getItemText(listG.getSelectedIndex()).equals("Si"), 
	                            listH.getItemText(listH.getSelectedIndex()).equals("Si"), listI.getItemText(listI.getSelectedIndex()).equals("Si"), 
	                            listJ.getItemText(listJ.getSelectedIndex()).equals("Si"), txtEntrevistoA.getText(), txtEnfermedades.getText(),  
	                            Float.parseFloat(txtAporteCasa.getText()),listDeudas.getItemText(listDeudas.getSelectedIndex()).equals("Si"), 
	                            Integer.parseInt(listNoDependientes.getItemText(listNoDependientes.getSelectedIndex())), txtNombreEmpresa.getValue(txtNombreEmpresa.getSelectedIndex()),  
	                            listAlquila.getItemText(listAlquila.getSelectedIndex()).equals("Si"),Float.parseFloat(txtPagoMensual.getText()),
				                txtOtrosIngresos.getText(),Float.parseFloat(txtAmortizacion.getText()),txtEntrevistoB.getText(), txtEntrevistoC.getText(),txtEntrevistoD.getText(),
				                txtObservacion1.getText(),txtObservacion2.getText(), txtObservacion3.getText(),txtObservacion4.getText(), txtObservacion5.getText(),
					           	   dateFechaDeudaInicio.getValue(), dateFechaDeudaFinal.getValue(), motivoDeuda.getText(),listDeudaEn.getValue(listDeudaEn.getSelectedIndex()),new AsyncCallback<Long>(){
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
		
		listDeudaEn = new ListBox();
		listDeudaEn.addItem("Antigua","0");
		listDeudaEn.addItem("Azteca","1");
		listDeudaEn.addItem("Agromercantil","2");
		listDeudaEn.addItem("Banrural","3");
		listDeudaEn.addItem("City","4");
		listDeudaEn.addItem("CHN","5");
		listDeudaEn.addItem("G&T Continental","6");
		listDeudaEn.addItem("Guatemala","7");
		listDeudaEn.addItem("Promerica","8");
		listDeudaEn.addItem("Reformador","9");
		listDeudaEn.addItem("Fichosa","10");
		listDeudaEn.addItem("InterBanco","11");
		listDeudaEn.addItem("Inmobiliario","12");
		listDeudaEn.addItem("ViviBanco","13");
		listDeudaEn.addItem("Industrial","14");
		listDeudaEn.addItem("Trabajadores","15");
		listDeudaEn.addItem("Fundación Hábitat","16");
		listDeudaEn.addItem("MiCope","17");
		listDeudaEn.addItem("COOPERATIVA HUNA COOP R.L.","18");
		listDeudaEn.addItem("COINIPAZ","18");
		listDeudaEn.addItem("COINACREDE R.L.","19");
		listDeudaEn.addItem("COOPERATIVA CENDIST, R.L.","20");
		listDeudaEn.addItem("COOPERATIVA INNOVIC R.L.","21");
		listDeudaEn.addItem("COOPERATIVA EL MONOLITO R.L.","22");
		listDeudaEn.addItem("Otras Cooperativas","23");		
		listDeudaEn.addItem("Otras Instancias financieras","24");
		listDeudaEn.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDeudaEn, 561, 1131);
		listDeudaEn.setSize("219px", "34px");
		
		motivoDeuda = new TextArea();
		motivoDeuda.setStyleName("gwt-TextBox ");
		absolutePanel.add(motivoDeuda, 10, 1203);
		motivoDeuda.setSize("720px", "57px");
		motivoDeuda.setText("");
		
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar,433, 1750);
		btnGuardar.setSize("227px", "34px");
		
		listNoDependientes = new ListBox();
		listNoDependientes.addItem("0");
		listNoDependientes.addItem("1");
		listNoDependientes.addItem("2");
		listNoDependientes.addItem("2");
		listNoDependientes.addItem("3");
		listNoDependientes.addItem("4");
		listNoDependientes.addItem("5");
		listNoDependientes.addItem("6");
		listNoDependientes.addItem("7");
		listNoDependientes.addItem("8");
		listNoDependientes.addItem("9");
		listNoDependientes.addItem("10");
		listNoDependientes.addItem("11");
		listNoDependientes.addItem("12");
		listNoDependientes.addItem("13");
		listNoDependientes.addItem("14");
		listNoDependientes.addItem("15");
		listNoDependientes.addItem("16");
		listNoDependientes.addItem("17");
		listNoDependientes.addItem("18");
		listNoDependientes.addItem("19");
		listNoDependientes.addItem("20");
		listNoDependientes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listNoDependientes, 10, 1394);
		listNoDependientes.setSize("229px", "41px");
		
		listAlquila = new ListBox();
		listAlquila.addItem("Si");
		listAlquila.addItem("No");
		listAlquila.setStyleName("gwt-TextBox2");
		absolutePanel.add(listAlquila, 264, 1394);
		listAlquila.setSize("107px", "41px");
		
		txtPagoMensual = new DoubleBox();
		txtPagoMensual.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPagoMensual.getText().equals("")) {txtPagoMensual.setText("0");}
				else if(txtPagoMensual.getText().equals(null)) {txtPagoMensual.setText("0");}
				else{
					try{
						Float.parseFloat(txtPagoMensual.getText());
					}catch(Exception e){
						mensaje.setMensaje("alert alert-error", 
                    			"Error !! \nPago Mensual no valido");
						txtPagoMensual.setText("0.0");
					}
				}
			}
		});
		txtPagoMensual.setText("0.0");
		txtPagoMensual.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPagoMensual, 385, 1399);
		txtPagoMensual.setSize("150px", "34px");
		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date(1407518819070L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 551, 1399);
		dateFecha.setSize("222px", "34px");
		
		txtEntrevistoA = new TextBox();
		txtEntrevistoA.setMaxLength(500);
		txtEntrevistoA.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEntrevistoA, 10, 1683);
		txtEntrevistoA.setSize("148px", "34px");
		
		txtEntrevistoB = new TextBox();
		txtEntrevistoB.setStyleName("gwt-TextBox2");
		txtEntrevistoB.setMaxLength(500);
		absolutePanel.add(txtEntrevistoB, 221, 1683);
		txtEntrevistoB.setSize("148px", "34px");
		
		txtEntrevistoC = new TextBox();
		txtEntrevistoC.setStyleName("gwt-TextBox2");
		txtEntrevistoC.setMaxLength(500);
		absolutePanel.add(txtEntrevistoC, 433, 1683);
		txtEntrevistoC.setSize("148px", "34px");
		
		txtEntrevistoD = new TextBox();
		txtEntrevistoD.setStyleName("gwt-TextBox2");
		txtEntrevistoD.setMaxLength(500);
		absolutePanel.add(txtEntrevistoD, 630, 1683);
		txtEntrevistoD.setSize("148px", "34px");
		
		txtOtrosIngresos = new TextArea();
		//txtOtrosIngresos.getElement().setAttribute("maxlength", "500");
		txtOtrosIngresos.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtOtrosIngresos, 13, 1496);
		txtOtrosIngresos.setSize("717px", "57px");
		
		txtObservacion1 = new TextArea();
		txtObservacion1.setStyleName("gwt-TextBox");
		absolutePanel.add(txtObservacion1, 824, 91);
		txtObservacion1.setSize("343px", "298px");
		
		txtObservacion2 = new TextArea();
		txtObservacion2.setStyleName("gwt-TextBox");
		absolutePanel.add(txtObservacion2, 824, 487);
		txtObservacion2.setSize("343px", "231px");
		
		txtObservacion3 = new TextArea();
		txtObservacion3.setStyleName("gwt-TextBox");
		absolutePanel.add(txtObservacion3, 824, 982);
		txtObservacion3.setSize("343px", "39px");
		
		txtObservacion4 = new TextArea();
		txtObservacion4.setStyleName("gwt-TextBox");
		absolutePanel.add(txtObservacion4, 824, 1114);
		txtObservacion4.setSize("343px", "146px");
		
		txtObservacion5 = new TextArea();
		txtObservacion5.setStyleName("gwt-TextBox");
		absolutePanel.add(txtObservacion5, 824, 1356);
		txtObservacion5.setSize("343px", "197px");
		
		Label lblNivelAcademico = new Label("Entrevista");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 292, 10);
		lblNivelAcademico.setSize("150px", "13px");
		
		Label lblQueConoce = new Label("1. Qué conoces de la Fundación?");
		lblQueConoce.setStyleName("label");
		absolutePanel.add(lblQueConoce, 10, 72);
		lblQueConoce.setSize("338px", "13px");
		
		Label lblPorQu = new Label("2. Por qué desea trabajar en la Fundación?");
		lblPorQu.setStyleName("label");
		absolutePanel.add(lblPorQu, 458, 72);
		lblPorQu.setSize("338px", "13px");
		
		Label lblCmoSe = new Label("3. Cómo se describe así mismo?");
		lblCmoSe.setStyleName("label");
		absolutePanel.add(lblCmoSe, 10, 181);
		lblCmoSe.setSize("338px", "13px");
		
		Label lblpuedesTrabajar = new Label("4. ¿Puedes trabajar bajo presión?");
		lblpuedesTrabajar.setStyleName("label");
		absolutePanel.add(lblpuedesTrabajar, 458, 181);
		lblpuedesTrabajar.setSize("338px", "13px");
		
		Label lblMetas = new Label("Metas");
		lblMetas.setStyleName("label");
		absolutePanel.add(lblMetas, 10, 287);
		lblMetas.setSize("338px", "13px");
		
		Label lblATieneDisponibilidad = new Label("a) Tiene disponibilidad inmediata");
		lblATieneDisponibilidad.setStyleName("label");
		absolutePanel.add(lblATieneDisponibilidad, 37, 475);
		lblATieneDisponibilidad.setSize("293px", "13px");
		
		Label lblBTieneDisposicin = new Label("b) Tiene disposición de viajar incluso fines de semana");
		lblBTieneDisposicin.setStyleName("label");
		absolutePanel.add(lblBTieneDisposicin, 37, 506);
		lblBTieneDisposicin.setSize("511px", "13px");
		
		Label lblCTieneFlexibilidad = new Label("c) Tiene flexibilidad en el horario");
		lblCTieneFlexibilidad.setStyleName("label");
		absolutePanel.add(lblCTieneFlexibilidad, 37, 538);
		lblCTieneFlexibilidad.setSize("524px", "13px");
		
		Label lblETieneAntecedentes = new Label("e) Tiene antecedentes penales");
		lblETieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblETieneAntecedentes, 37, 570);
		lblETieneAntecedentes.setSize("511px", "13px");
		
		Label lblFTieneAntecedentes = new Label("f) Tiene antecedentes policíacos");
		lblFTieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblFTieneAntecedentes, 37, 604);
		lblFTieneAntecedentes.setSize("511px", "13px");
		
		Label lblGCartasDe = new Label("g) Cartas de recomendación laborales");
		lblGCartasDe.setStyleName("label");
		absolutePanel.add(lblGCartasDe, 37, 636);
		lblGCartasDe.setSize("511px", "13px");
		
		Label lblHCartasDe = new Label("h) Cartas de recomendación personales");
		lblHCartasDe.setStyleName("label");
		absolutePanel.add(lblHCartasDe, 37, 668);
		lblHCartasDe.setSize("511px", "13px");
		
		Label lblEnfermedades = new Label("Enfermedades");
		lblEnfermedades.setStyleName("label");
		absolutePanel.add(lblEnfermedades, 10, 812);
		lblEnfermedades.setSize("338px", "13px");
		
		Label lblI = new Label("i) Vive con familia");
		lblI.setStyleName("label");
		absolutePanel.add(lblI, 34, 706);
		lblI.setSize("511px", "13px");
		
		Label lblAporteCasa = new Label("Aporte Casa");
		lblAporteCasa.setStyleName("label");
		absolutePanel.add(lblAporteCasa, 13, 997);
		lblAporteCasa.setSize("149px", "13px");
		
		Label lblTieneDeudas = new Label("Tiene deudas");
		lblTieneDeudas.setStyleName("label");
		absolutePanel.add(lblTieneDeudas, 10, 1095);
		lblTieneDeudas.setSize("55px", "18px");
		
		Label lblAmortizacinMensual = new Label("Amortización mensual");
		lblAmortizacinMensual.setStyleName("label");
		absolutePanel.add(lblAmortizacinMensual, 71, 1110);
		lblAmortizacinMensual.setSize("176px", "13px");
		
		Label lblNombreDeLa = new Label("Nombre de la institución donde tiene el crédito");
		lblNombreDeLa.setStyleName("label");
		absolutePanel.add(lblNombreDeLa, 271, 982);
		lblNombreDeLa.setSize("229px", "13px");
		
		Label lblNoDependientes = new Label("No. Dependientes");
		lblNoDependientes.setStyleName("label");
		absolutePanel.add(lblNoDependientes, 10, 1375);
		lblNoDependientes.setSize("137px", "13px");
		
		Label lblFechaEntrevista = new Label("Fecha Entrevista");
		lblFechaEntrevista.setStyleName("label");
		absolutePanel.add(lblFechaEntrevista, 558, 1380);
		lblFechaEntrevista.setSize("183px", "13px");
		
		Label lblPagoMensual = new Label("Pago mensual-alquiler");
		lblPagoMensual.setStyleName("label");
		absolutePanel.add(lblPagoMensual, 385, 1380);
		lblPagoMensual.setSize("160px", "13px");
		
		Label lblAlquila = new Label("Alquila");
		lblAlquila.setStyleName("label");
		absolutePanel.add(lblAlquila, 267, 1375);
		lblAlquila.setSize("81px", "13px");
		
		Label lblKCasaPropia = new Label("J) Casa Propia");
		lblKCasaPropia.setStyleName("label");
		absolutePanel.add(lblKCasaPropia, 34, 738);
		lblKCasaPropia.setSize("511px", "13px");
		
		Label lblPretencionSalarial = new Label("Pretencion Salarial");
		lblPretencionSalarial.setStyleName("label");
		absolutePanel.add(lblPretencionSalarial, 551, 997);
		lblPretencionSalarial.setSize("137px", "13px");
		
		Label lblOtrosIngresos = new Label("Otros Ingresos");
		lblOtrosIngresos.setStyleName("label");
		absolutePanel.add(lblOtrosIngresos, 10, 1477);
		lblOtrosIngresos.setSize("338px", "13px");
		
		Label lblEntrevisto = new Label("Entrevisto (A)");
		lblEntrevisto.setStyleName("label");
		absolutePanel.add(lblEntrevisto, 12, 1664);
		lblEntrevisto.setSize("137px", "13px");
		
		Label lblFechaDeDeuda = new Label("Fecha inicio Deuda");
		lblFechaDeDeuda.setStyleName("label");
		absolutePanel.add(lblFechaDeDeuda, 250, 1110);
		lblFechaDeDeuda.setSize("141px", "13px");
		
		Label lblFechaFinDeuda = new Label("Fecha fin Deuda");
		lblFechaFinDeuda.setStyleName("label");
		absolutePanel.add(lblFechaFinDeuda, 406, 1110);
		lblFechaFinDeuda.setSize("141px", "13px");
		
		Label lblEntrevistob = new Label("Entrevisto (B)");
		lblEntrevistob.setStyleName("label");
		absolutePanel.add(lblEntrevistob, 223, 1664);
		lblEntrevistob.setSize("137px", "13px");
		
		Label lblEntrevistoc = new Label("Entrevisto (C)");
		lblEntrevistoc.setStyleName("label");
		absolutePanel.add(lblEntrevistoc, 435, 1664);
		lblEntrevistoc.setSize("137px", "13px");
		
		Label lblEntrevistod = new Label("Entrevisto (D)");
		lblEntrevistod.setStyleName("label");
		absolutePanel.add(lblEntrevistod, 632, 1664);
		lblEntrevistod.setSize("137px", "13px");
		
		Label lblAdquirioDeudaEn = new Label("Adquirio deuda en?");
		lblAdquirioDeudaEn.setStyleName("label");
		absolutePanel.add(lblAdquirioDeudaEn, 567, 1110);
		lblAdquirioDeudaEn.setSize("229px", "13px");
		
		Label lblSeccion = new Label("SECCION 1.");
		lblSeccion.setStyleName("label");
		absolutePanel.add(lblSeccion, 37, 53);
		lblSeccion.setSize("150px", "13px");
		
		Label lblSeccion_1 = new Label("SECCION 2.");
		lblSeccion_1.setStyleName("label");
		absolutePanel.add(lblSeccion_1, 10, 455);
		lblSeccion_1.setSize("150px", "13px");
		
		Label lblSeccion_2 = new Label("SECCION 3.");
		lblSeccion_2.setStyleName("label");
		absolutePanel.add(lblSeccion_2, 10, 782);
		lblSeccion_2.setSize("150px", "13px");
		
		Label lblSeccion_3 = new Label("SECCION 4.");
		lblSeccion_3.setStyleName("label");
		absolutePanel.add(lblSeccion_3, 10, 963);
		lblSeccion_3.setSize("150px", "13px");
		
		Label lblSeccion_4 = new Label("SECCION 5.");
		lblSeccion_4.setStyleName("label");
		absolutePanel.add(lblSeccion_4, 10, 1065);
		lblSeccion_4.setSize("150px", "13px");
		
		Label lblMotivoDeLa = new Label("Motivo de la deuda");
		lblMotivoDeLa.setStyleName("label");
		absolutePanel.add(lblMotivoDeLa, 10, 1184);
		lblMotivoDeLa.setSize("176px", "13px");
		
		Label lblSeccion_5 = new Label("SECCION 6.");
		lblSeccion_5.setStyleName("label");
		absolutePanel.add(lblSeccion_5, 10, 1325);
		lblSeccion_5.setSize("150px", "13px");
		
		Label lblObservaciones = new Label("OBSERVACIONES");
		lblObservaciones.setStyleName("label");
		absolutePanel.add(lblObservaciones, 824, 72);
		lblObservaciones.setSize("305px", "13px");
		
		Label label = new Label("OBSERVACIONES");
		label.setStyleName("label");
		absolutePanel.add(label, 824, 468);
		label.setSize("305px", "13px");
		
		Label label_1 = new Label("OBSERVACIONES");
		label_1.setStyleName("label");
		absolutePanel.add(label_1, 824, 963);
		label_1.setSize("305px", "13px");
		
		Label label_2 = new Label("OBSERVACIONES");
		label_2.setStyleName("label");
		absolutePanel.add(label_2, 824, 1095);
		label_2.setSize("305px", "13px");
		
		Label label_3 = new Label("OBSERVACIONES");
		label_3.setStyleName("label");
		absolutePanel.add(label_3, 824, 1337);
		label_3.setSize("305px", "13px");
	}
	
	public void LlenarDatos(Long id, String txtQueConoces,
			String txtPorque_Trabajar, String txtComoDescribe,
			String txtMetas, String listA, String listB, String listC,
			String listE, String listF, String listG, String listH,
			String listI, String listJ, String txtEnfermedades,
			String txtPresion, String txtNombreEmpresa, String listDeudas,
			String listNoDependientes, String listAlquila,
			String txtOtrosIngresos, String txtEntrevisto,
			Long dateFecha, String txtAporteCasa,
			String txtAmortizacion, String txtPagoMensual,
			String txtPretencionSalarial,
			 String txtEntrevistoB,
			 String  txtEntrevistoC,
			 String  txtEntrevistoD,
			 String  txtObservacion1,
			 String  txtObservacion2,
			 String  txtObservacion3,
			 String  txtObservacion4,
			 String  txtObservacion5,
			 long dateFechaDeudaInicio,
			 long dateFechaDeudaFinal,
			 String motivoDeuda,
			 String listDeudaEn) {

		System.out.println("listDeudaEn: "+listJ);
		this.id_entrevista = id;
		this.bandera = false;
		this.txtQueConoces.setText( txtQueConoces);
		this.txtPorque_Trabajar.setText( txtPorque_Trabajar);
		this.txtComoDescribe.setText( txtComoDescribe);
		this.txtMetas.setText( txtMetas);
		this.txtEnfermedades.setText(txtEnfermedades);
		this.txtPresion.setText(txtPresion);

		 this.txtEntrevistoB.setText(txtEntrevistoB);
		 this.txtEntrevistoC.setText(txtEntrevistoC);
		 this.txtEntrevistoD.setText(txtEntrevistoD);
		 this.txtObservacion1.setText(txtObservacion1);
		 this.txtObservacion2.setText(txtObservacion2);
		 this.txtObservacion3.setText(txtObservacion3);
		 this.txtObservacion4.setText(txtObservacion4);
		 this.txtObservacion5.setText(txtObservacion5);
		 this.txtObservacion2.setText(txtObservacion2);
		 this.dateFechaDeudaInicio.setValue(new Date(dateFechaDeudaInicio));
		 this.dateFechaDeudaFinal.setValue(new Date(dateFechaDeudaFinal));
		 this.motivoDeuda.setText(motivoDeuda);
		 
		 
		 
		bandera = true;
	    for(int i=0; i < this.txtNombreEmpresa.getItemCount() && bandera; i++){
	       bandera = !this.txtNombreEmpresa.getValue(i).equals(txtNombreEmpresa);
	       this.txtNombreEmpresa.setSelectedIndex(i);
	    } 
	    
	    bandera = true;
	    for(int i=0; i < this.listDeudaEn.getItemCount() && bandera; i++){
	       bandera = !this.listDeudaEn.getValue(i).equals(listDeudaEn);
	       this.listDeudaEn.setSelectedIndex(i);
	    } 
	    
		this.txtOtrosIngresos.setText(txtOtrosIngresos);
		this.txtEntrevistoA.setText(txtEntrevisto);
		this.dateFecha.setValue(new Date(dateFecha));
		this.txtAporteCasa.setText(txtAporteCasa);
		this.txtAmortizacion.setText(txtAmortizacion);
		this.txtPagoMensual.setText(txtPagoMensual);
		this.txtPretencionSalarial.setText(txtPretencionSalarial);
		boolean bandera = true;
		
	    for(int i=0; i < this.listA .getItemCount() && bandera; i++){
	    	bandera = !this.listA .getItemText(i).equals(listA );
	    	this.listA .setSelectedIndex(i);
	    }
	    bandera = true;
	    for(int i=0; i < this.listB.getItemCount() && bandera; i++){
	        bandera = !this.listB.getItemText(i).equals(listB);
	        this.listB.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listC.getItemCount() && bandera; i++){
	        bandera = !this.listC.getItemText(i).equals(listC);
	        this.listC.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listE.getItemCount() && bandera; i++){
	        bandera = !this.listE.getItemText(i).equals(listE);
	        this.listE.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listF.getItemCount() && bandera; i++){
	        bandera = !this.listF.getItemText(i).equals(listF);
	        this.listF.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listG.getItemCount() && bandera; i++){
	        bandera = !this.listG.getItemText(i).equals(listG);
	        this.listG.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listH.getItemCount() && bandera; i++){
	        bandera = !this.listH.getItemText(i).equals(listH);
	        this.listH.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listI.getItemCount() && bandera; i++){
	        bandera = !this.listI.getItemText(i).equals(listI);
	        this.listI.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listJ.getItemCount() && bandera; i++){
	        bandera = !this.listJ.getItemText(i).equals(listJ);
	        this.listJ.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listDeudas.getItemCount() && bandera; i++){
	        bandera = !this.listDeudas.getItemText(i).equals(listDeudas);
	        this.listDeudas.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listNoDependientes.getItemCount() && bandera; i++){
	        bandera = !this.listNoDependientes.getItemText(i).equals(listNoDependientes);
	        this.listNoDependientes.setSelectedIndex(i);
	    }   
	    bandera = true;
	    for(int i=0; i < this.listAlquila.getItemCount() && bandera; i++){
	        bandera = !this.listAlquila.getItemText(i).equals(listAlquila);
	        this.listAlquila.setSelectedIndex(i);
	    }   
	    
			
			
		}
	
	 

	public void btnhinabilitar(boolean valor){
			btnGuardar.setEnabled(valor);
			btnGuardar.setVisible(valor);
	}

}
