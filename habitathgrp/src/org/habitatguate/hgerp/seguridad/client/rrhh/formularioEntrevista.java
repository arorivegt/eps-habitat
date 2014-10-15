package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.LoginService;
import org.habitatguate.hgerp.seguridad.client.api.LoginServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class formularioEntrevista extends Composite {

	 private Empleados empleado;
	 private boolean bandera = true;
     private Long id_entrevista = 0L;
	 private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	
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
	 private TextArea txtEnfermedades;
	 private TextArea txtPresion;
	 private TextBox txtNombreEmpresa ;
	 private ListBox listDeudas ;
	 private ListBox listNoDependientes ;
	 private ListBox listAlquila ;
	 private TextArea txtOtrosIngresos ;
	 private TextBox txtEntrevisto;
	 private DateBox dateFecha ;
	 private DoubleBox txtAporteCasa;
	 private DoubleBox txtAmortizacion ;
	 private DoubleBox txtPagoMensual ;
	 private DoubleBox txtPretencionSalarial;
	 
   

	public formularioEntrevista(Empleados e) {

		this.empleado = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("918px", "1253px");
		
		txtQueConoces = new TextArea();
		//txtQueConoces.getElement().setAttribute("maxlength", "500");
		txtQueConoces.setStyleName("gwt-TextBox");
		absolutePanel.add(txtQueConoces, 10, 48);
		txtQueConoces.setSize("272px", "39px");
		
		txtPorque_Trabajar = new TextArea();
		//txtPorque_Trabajar.getElement().setAttribute("maxlength", "500");
		txtPorque_Trabajar.setStyleName("gwt-TextBox");
		absolutePanel.add(txtPorque_Trabajar, 458, 48);
		txtPorque_Trabajar.setSize("272px", "39px");
		
		txtComoDescribe = new TextArea();
		//txtComoDescribe.getElement().setAttribute("maxlength", "500");
		txtComoDescribe.setStyleName("gwt-TextBox");
		absolutePanel.add(txtComoDescribe, 10, 157);
		txtComoDescribe.setSize("272px", "39px");
		
		txtPresion = new TextArea();
		//txtPresion.getElement().setAttribute("maxlength", "500");
		txtPresion.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtPresion, 458, 157);
		txtPresion.setSize("272px", "39px");
		
		txtMetas = new TextArea();
		//txtMetas.getElement().setAttribute("maxlength", "1000");
		txtMetas.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtMetas, 10, 263);
		txtMetas.setSize("720px", "83px");
		
		listA = new ListBox();
		listA.addItem("Si");
		listA.addItem("No");
		listA.setStyleName("gwt-TextBox2");
		absolutePanel.add(listA, 643, 395);
		listA.setSize("137px", "26px");
		
		listB = new ListBox();
		listB.addItem("Si");
		listB.addItem("No");
		listB.setStyleName("gwt-TextBox2");
		absolutePanel.add(listB, 643, 427);
		listB.setSize("137px", "26px");
		
		listC = new ListBox();
		listC.addItem("Si");
		listC.addItem("No");
		listC.setStyleName("gwt-TextBox2");
		absolutePanel.add(listC, 643, 459);
		listC.setSize("137px", "26px");
		
		listE = new ListBox();
		listE.addItem("Si");
		listE.addItem("No");
		listE.setStyleName("gwt-TextBox2");
		absolutePanel.add(listE, 643, 491);
		listE.setSize("137px", "26px");
		
		listF = new ListBox();
		listF.addItem("Si");
		listF.addItem("No");
		listF.setStyleName("gwt-TextBox2");
		absolutePanel.add(listF, 643, 525);
		listF.setSize("137px", "26px");
		
		listG = new ListBox();
		listG.addItem("Si");
		listG.addItem("No");
		listG.setStyleName("gwt-TextBox2");
		absolutePanel.add(listG, 643, 557);
		listG.setSize("137px", "26px");
		
		listH = new ListBox();
		listH.addItem("Si");
		listH.addItem("No");
		listH.setStyleName("gwt-TextBox2");
		absolutePanel.add(listH, 643, 589);
		listH.setSize("137px", "26px");
		
		listI = new ListBox();
		listI.addItem("Si");
		listI.addItem("No");
		listI.setStyleName("gwt-TextBox2");
		absolutePanel.add(listI, 643, 621);
		listI.setSize("137px", "26px");
		
		listJ = new ListBox();
		listJ.addItem("Si");
		listJ.addItem("No");
		listJ.setStyleName("gwt-TextBox2");
		absolutePanel.add(listJ, 643, 653);
		listJ.setSize("137px", "26px");
		
		txtEnfermedades = new TextArea();
		txtEnfermedades.getElement().setAttribute("maxlength", "500");
		txtEnfermedades.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtEnfermedades, 10, 715);
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
                    	setMensaje("alert alert-error", 
                    			"Error !! \nAporte a Casa no valido");
						txtAporteCasa.setText("0.0");
					}
				}
			}
		});
		txtAporteCasa.setText("0.0");
		txtAporteCasa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtAporteCasa, 10, 867);
		txtAporteCasa.setSize("227px", "34px");
		
		listDeudas = new ListBox();
		listDeudas.addItem("Si");
		listDeudas.addItem("No");
		listDeudas.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDeudas, 485, 867);
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
                    	setMensaje("alert alert-error", 
                    			"Error !! \nAmortizacion no valido");
						txtAmortizacion.setText("0.0");
					}
				}
			}
		});
		txtAmortizacion.setText("0.0");
		txtAmortizacion.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtAmortizacion, 551, 867);
		txtAmortizacion.setSize("227px", "34px");
		
		txtNombreEmpresa = new TextBox();
		txtNombreEmpresa.setMaxLength(200);
		txtNombreEmpresa.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtNombreEmpresa, 245, 867);
		txtNombreEmpresa.setSize("227px", "34px");
		
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
		absolutePanel.add(listNoDependientes, 10, 939);
		listNoDependientes.setSize("229px", "41px");
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407518819070L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy"))); 
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 250, 939);
		dateFecha.setSize("222px", "34px");
		
		listAlquila = new ListBox();
		listAlquila.addItem("Si");
		listAlquila.addItem("No");
		listAlquila.setStyleName("gwt-TextBox2");
		absolutePanel.add(listAlquila, 485, 939);
		listAlquila.setSize("47px", "36px");
		
		txtPagoMensual = new DoubleBox();
		txtPagoMensual.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPagoMensual.getText().equals("")) {txtPagoMensual.setText("0");}
				else if(txtPagoMensual.getText().equals(null)) {txtPagoMensual.setText("0");}
				else{
					try{
						Float.parseFloat(txtPagoMensual.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nPago Mensual no valido");
						txtPagoMensual.setText("0.0");
					}
				}
			}
		});
		txtPagoMensual.setText("0.0");
		txtPagoMensual.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPagoMensual, 551, 939);
		txtPagoMensual.setSize("227px", "34px");
		
		txtPretencionSalarial = new DoubleBox();
		txtPretencionSalarial.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtPretencionSalarial.getText().equals("")) {txtPretencionSalarial.setText("0");}
				else if(txtPretencionSalarial.getText().equals(null)) {txtPretencionSalarial.setText("0");}
				else{
					try{
						Float.parseFloat(txtPretencionSalarial.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", 
                    			"Error !! \nPretencion Salarial no valido");
						txtPretencionSalarial.setText("0.0");
					}
				}
			}
		});
		txtPretencionSalarial.setText("0.0");
		txtPretencionSalarial.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPretencionSalarial, 10, 1005);
		txtPretencionSalarial.setSize("227px", "34px");
		
		txtEntrevisto = new TextBox();
		txtEntrevisto.setMaxLength(500);
		txtEntrevisto.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEntrevisto, 245, 1005);
		txtEntrevisto.setSize("227px", "34px");
		
		txtOtrosIngresos = new TextArea();
		//txtOtrosIngresos.getElement().setAttribute("maxlength", "500");
		txtOtrosIngresos.setStyleName("gwt-TextBox ");
		absolutePanel.add(txtOtrosIngresos, 13, 1078);
		txtOtrosIngresos.setSize("717px", "100px");
		
		Button button = new Button("Send");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
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
                            listJ.getItemText(listJ.getSelectedIndex()).equals("Si"), txtEntrevisto.getText(), txtEnfermedades.getText(),  
                            Float.parseFloat(txtAporteCasa.getText()),listDeudas.getItemText(listDeudas.getSelectedIndex()).equals("Si"), 
                            Integer.parseInt(listNoDependientes.getItemText(listNoDependientes.getSelectedIndex())), txtNombreEmpresa.getText(),  
                            listAlquila.getItemText(listAlquila.getSelectedIndex()).equals("Si"),Float.parseFloat(txtPagoMensual.getText()),
			                txtOtrosIngresos.getTitle(),Float.parseFloat(txtAmortizacion.getText()), new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_entrevista = result;
							bandera = false;
                        	setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        }

                 });
					}else{
						loginService.Actualizar_Entrevista(empleado.id_empleado,id_entrevista, dateFecha.getValue(), txtQueConoces.getText(), 
								txtPorque_Trabajar.getText(),txtComoDescribe.getText(), txtPresion.getText(), txtMetas.getText(),
								listA.getItemText(listA.getSelectedIndex()).equals("Si"), 
	                            listB.getItemText(listB.getSelectedIndex()).equals("Si"), listC.getItemText(listC.getSelectedIndex()).equals("Si"), 
	                            Float.parseFloat(txtPretencionSalarial.getText()), listE.getItemText(listE.getSelectedIndex()).equals("Si"), 
	                            listF.getItemText(listF.getSelectedIndex()).equals("Si"),listG.getItemText(listG.getSelectedIndex()).equals("Si"), 
	                            listH.getItemText(listH.getSelectedIndex()).equals("Si"), listI.getItemText(listI.getSelectedIndex()).equals("Si"), 
	                            listJ.getItemText(listJ.getSelectedIndex()).equals("Si"), txtEntrevisto.getText(), txtEnfermedades.getText(),  
	                            Float.parseFloat(txtAporteCasa.getText()),listDeudas.getItemText(listDeudas.getSelectedIndex()).equals("Si"), 
	                            Integer.parseInt(listNoDependientes.getItemText(listNoDependientes.getSelectedIndex())), txtNombreEmpresa.getText(),  
	                            listAlquila.getItemText(listAlquila.getSelectedIndex()).equals("Si"),Float.parseFloat(txtPagoMensual.getText()),
				                txtOtrosIngresos.getTitle(),Float.parseFloat(txtAmortizacion.getText()),new AsyncCallback<Long>(){
	                        public void onFailure(Throwable caught) 
	                        {
	                        	setMensaje("alert alert-error", 
	                        			"Error !! \nal Actualizar Datos");
	                        }

							@Override
	                        public void onSuccess(Long result)
	                        {
								bandera = false;
			                	setMensaje("alert alert-success", 
			                			"Datos Actualizados\n exitosamente!!!");
	                        }

	                 });
					}
			}
		});
		button.setText("Guardar");
		button.setStylePrimaryName("sendButton");
		button.setStyleName("sendButton");
		absolutePanel.add(button, 290, 1231);
		button.setSize("227px", "34px");
		
		Label lblNivelAcademico = new Label("Informe Entrevista");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 290, 10);
		lblNivelAcademico.setSize("150px", "13px");
		
		Label lblQueConoce = new Label("1. Qué conoces de la Fundación?");
		lblQueConoce.setStyleName("label");
		absolutePanel.add(lblQueConoce, 10, 29);
		lblQueConoce.setSize("338px", "13px");
		
		Label lblPorQu = new Label("2. Por qué desea trabajar en la Fundación?");
		lblPorQu.setStyleName("label");
		absolutePanel.add(lblPorQu, 458, 29);
		lblPorQu.setSize("338px", "13px");
		
		Label lblCmoSe = new Label("3. Cómo se describe así mismo?");
		lblCmoSe.setStyleName("label");
		absolutePanel.add(lblCmoSe, 10, 138);
		lblCmoSe.setSize("338px", "13px");
		
		Label lblpuedesTrabajar = new Label("4. ¿Puedes trabajar bajo presión?");
		lblpuedesTrabajar.setStyleName("label");
		absolutePanel.add(lblpuedesTrabajar, 458, 138);
		lblpuedesTrabajar.setSize("338px", "13px");
		
		Label lblMetas = new Label("Metas");
		lblMetas.setStyleName("label");
		absolutePanel.add(lblMetas, 10, 244);
		lblMetas.setSize("338px", "13px");
		
		Label lblATieneDisponibilidad = new Label("a) Tiene disponibilidad inmediata");
		lblATieneDisponibilidad.setStyleName("label");
		absolutePanel.add(lblATieneDisponibilidad, 37, 395);
		lblATieneDisponibilidad.setSize("293px", "13px");
		
		Label lblBTieneDisposicin = new Label("b) Tiene disposición de viajar incluso fines de semana");
		lblBTieneDisposicin.setStyleName("label");
		absolutePanel.add(lblBTieneDisposicin, 37, 427);
		lblBTieneDisposicin.setSize("511px", "13px");
		
		Label lblCTieneFlexibilidad = new Label("c) Tiene flexibilidad en el horario");
		lblCTieneFlexibilidad.setStyleName("label");
		absolutePanel.add(lblCTieneFlexibilidad, 37, 459);
		lblCTieneFlexibilidad.setSize("524px", "13px");
		
		Label lblETieneAntecedentes = new Label("e) Tiene antecedentes penales");
		lblETieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblETieneAntecedentes, 37, 491);
		lblETieneAntecedentes.setSize("511px", "13px");
		
		Label lblFTieneAntecedentes = new Label("f) Tiene antecedentes policíacos");
		lblFTieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblFTieneAntecedentes, 37, 525);
		lblFTieneAntecedentes.setSize("511px", "13px");
		
		Label lblGCartasDe = new Label("g) Cartas de recomendación laborales");
		lblGCartasDe.setStyleName("label");
		absolutePanel.add(lblGCartasDe, 37, 557);
		lblGCartasDe.setSize("511px", "13px");
		
		Label lblHCartasDe = new Label("h) Cartas de recomendación personales");
		lblHCartasDe.setStyleName("label");
		absolutePanel.add(lblHCartasDe, 37, 589);
		lblHCartasDe.setSize("511px", "13px");
		
		Label lblEnfermedades = new Label("Enfermedades");
		lblEnfermedades.setStyleName("label");
		absolutePanel.add(lblEnfermedades, 10, 685);
		lblEnfermedades.setSize("338px", "13px");
		
		Label lblI = new Label("i) Vive con familia");
		lblI.setStyleName("label");
		absolutePanel.add(lblI, 34, 627);
		lblI.setSize("511px", "13px");
		
		Label lblAporteCasa = new Label("Aporte Casa");
		lblAporteCasa.setStyleName("label");
		absolutePanel.add(lblAporteCasa, 13, 848);
		lblAporteCasa.setSize("149px", "13px");
		
		Label lblTieneDeudas = new Label("Tiene deudas");
		lblTieneDeudas.setStyleName("label");
		absolutePanel.add(lblTieneDeudas, 485, 825);
		lblTieneDeudas.setSize("81px", "13px");
		
		Label lblAmortizacinMensual = new Label("Amortización mensual");
		lblAmortizacinMensual.setStyleName("label");
		absolutePanel.add(lblAmortizacinMensual, 551, 848);
		lblAmortizacinMensual.setSize("209px", "13px");
		
		Label lblNombreDeLa = new Label("Nombre de la institución donde tiene el crédito");
		lblNombreDeLa.setStyleName("label");
		absolutePanel.add(lblNombreDeLa, 245, 831);
		lblNombreDeLa.setSize("229px", "13px");
		
		Label lblNoDependientes = new Label("No. Dependientes");
		lblNoDependientes.setStyleName("label");
		absolutePanel.add(lblNoDependientes, 10, 920);
		lblNoDependientes.setSize("137px", "13px");
		
		Label label = new Label("Fecha");
		label.setStyleName("label");
		absolutePanel.add(label, 257, 920);
		label.setSize("75px", "13px");
		
		Label lblPagoMensual = new Label("Pago mensual-alquiler");
		lblPagoMensual.setStyleName("label");
		absolutePanel.add(lblPagoMensual, 551, 920);
		lblPagoMensual.setSize("275px", "13px");
		
		Label lblAlquila = new Label("Alquila");
		lblAlquila.setStyleName("label");
		absolutePanel.add(lblAlquila, 480, 920);
		lblAlquila.setSize("81px", "13px");
		
		Label lblKCasaPropia = new Label("J) Casa Propia");
		lblKCasaPropia.setStyleName("label");
		absolutePanel.add(lblKCasaPropia, 34, 659);
		lblKCasaPropia.setSize("511px", "13px");
		
		Label lblPretencionSalarial = new Label("Pretencion Salarial");
		lblPretencionSalarial.setStyleName("label");
		absolutePanel.add(lblPretencionSalarial, 10, 986);
		lblPretencionSalarial.setSize("137px", "13px");
		
		Label lblOtrosIngresos = new Label("Otros Ingresos");
		lblOtrosIngresos.setStyleName("label");
		absolutePanel.add(lblOtrosIngresos, 10, 1059);
		lblOtrosIngresos.setSize("338px", "13px");
		
		Label lblEntrevisto = new Label("Entrevisto");
		lblEntrevisto.setStyleName("label");
		absolutePanel.add(lblEntrevisto, 247, 986);
		lblEntrevisto.setSize("137px", "13px");
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
			String txtPretencionSalarial) {

		this.id_entrevista = id;
		this.bandera = false;
		this.txtQueConoces.setText( txtQueConoces);
		this.txtPorque_Trabajar.setText( txtPorque_Trabajar);
		this.txtComoDescribe.setText( txtComoDescribe);
		this.txtMetas.setText( txtMetas);
		this.txtEnfermedades.setText(txtEnfermedades);
		this.txtPresion.setText(txtPresion);
		this.txtNombreEmpresa.setText(txtNombreEmpresa);
		this.txtOtrosIngresos.setText(txtOtrosIngresos);
		this.txtEntrevisto.setText(txtEntrevisto);
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
    public void setMensaje(String estilo, String mensaje){
        final DialogBox Registro2 = new DialogBox();
        final HTML serverResponseLabel = new HTML();
        final Button close= new Button("x");
        Mensaje inicio = new Mensaje();
        
        Registro2.setStyleName(estilo);
        inicio.mensajeEntrada(mensaje);
        inicio.mensajeEstilo(estilo);
        close.addStyleName("close");
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.add(serverResponseLabel );
        dialogVPanel.add(inicio);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(close);
        Registro2 .setWidget(dialogVPanel);
        Registro2 .setModal(true);
        Registro2 .setGlassEnabled(true);
        Registro2 .setAnimationEnabled(true);
        Registro2 .center();
        Registro2 .show();
        close.setFocus(true);
    
        close.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            Registro2.hide();
        }
    });
    }
}
