package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class formulario_entrevista extends Composite {

	public formulario_entrevista() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "1090px");
		
		Label lblNivelAcademico = new Label("Informe Entrevista");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 115, 10);
		lblNivelAcademico.setSize("456px", "13px");
		
		TextArea textArea = new TextArea();
		textArea.setStyleName("gwt-TextBox2");
		absolutePanel.add(textArea, 10, 48);
		textArea.setSize("318px", "61px");
		
		Label lblQueConoce = new Label("1. Qué conoces de la Fundación?");
		lblQueConoce.setStyleName("label");
		absolutePanel.add(lblQueConoce, 10, 29);
		lblQueConoce.setSize("338px", "13px");
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(textArea_1, 379, 48);
		textArea_1.setSize("318px", "61px");
		
		Label lblPorQu = new Label("2. Por qué desea trabajar en la Fundación?");
		lblPorQu.setStyleName("label");
		absolutePanel.add(lblPorQu, 379, 29);
		lblPorQu.setSize("338px", "13px");
		
		TextArea textArea_2 = new TextArea();
		textArea_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(textArea_2, 10, 157);
		textArea_2.setSize("318px", "61px");
		
		Label lblCmoSe = new Label("3. Cómo se describe así mismo?");
		lblCmoSe.setStyleName("label");
		absolutePanel.add(lblCmoSe, 10, 138);
		lblCmoSe.setSize("338px", "13px");
		
		TextArea textArea_3 = new TextArea();
		textArea_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(textArea_3, 379, 157);
		textArea_3.setSize("318px", "61px");
		
		Label lblpuedesTrabajar = new Label("4. ¿Puedes trabajar bajo presión?");
		lblpuedesTrabajar.setStyleName("label");
		absolutePanel.add(lblpuedesTrabajar, 379, 138);
		lblpuedesTrabajar.setSize("338px", "13px");
		
		TextArea textArea_4 = new TextArea();
		textArea_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(textArea_4, 10, 263);
		textArea_4.setSize("687px", "100px");
		
		Label lblMetas = new Label("Metas");
		lblMetas.setStyleName("label");
		absolutePanel.add(lblMetas, 10, 244);
		lblMetas.setSize("338px", "13px");
		
		Label lblATieneDisponibilidad = new Label("a) Tiene disponibilidad inmediata");
		lblATieneDisponibilidad.setStyleName("label");
		absolutePanel.add(lblATieneDisponibilidad, 37, 399);
		lblATieneDisponibilidad.setSize("293px", "13px");
		
		ListBox listBox = new ListBox();
		listBox.addItem("Si");
		listBox.addItem("No");
		listBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox, 567, 393);
		listBox.setSize("137px", "19px");
		
		Label lblBTieneDisposicin = new Label("b) Tiene disposición de viajar incluso fines de semana");
		lblBTieneDisposicin.setStyleName("label");
		absolutePanel.add(lblBTieneDisposicin, 37, 424);
		lblBTieneDisposicin.setSize("511px", "13px");
		
		ListBox listBox_1 = new ListBox();
		listBox_1.addItem("Si");
		listBox_1.addItem("No");
		listBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_1, 567, 418);
		listBox_1.setSize("137px", "19px");
		
		Label lblCTieneFlexibilidad = new Label("c) Tiene flexibilidad en el horario");
		lblCTieneFlexibilidad.setStyleName("label");
		absolutePanel.add(lblCTieneFlexibilidad, 37, 449);
		lblCTieneFlexibilidad.setSize("524px", "13px");
		
		ListBox listBox_2 = new ListBox();
		listBox_2.addItem("Si");
		listBox_2.addItem("No");
		listBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_2, 567, 443);
		listBox_2.setSize("137px", "19px");
		
		Label lblDSuPretensin = new Label("d) Su pretensión salarial mínima es");
		lblDSuPretensin.setStyleName("label");
		absolutePanel.add(lblDSuPretensin, 37, 474);
		lblDSuPretensin.setSize("293px", "13px");
		
		Label lblETieneAntecedentes = new Label("e) Tiene antecedentes penales");
		lblETieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblETieneAntecedentes, 37, 502);
		lblETieneAntecedentes.setSize("511px", "13px");
		
		Label lblFTieneAntecedentes = new Label("f) Tiene antecedentes policíacos");
		lblFTieneAntecedentes.setStyleName("label");
		absolutePanel.add(lblFTieneAntecedentes, 37, 527);
		lblFTieneAntecedentes.setSize("511px", "13px");
		
		Label lblGCartasDe = new Label("g) Cartas de recomendación laborales");
		lblGCartasDe.setStyleName("label");
		absolutePanel.add(lblGCartasDe, 37, 552);
		lblGCartasDe.setSize("511px", "13px");
		
		Label lblHCartasDe = new Label("h) Cartas de recomendación personales");
		lblHCartasDe.setStyleName("label");
		absolutePanel.add(lblHCartasDe, 37, 577);
		lblHCartasDe.setSize("511px", "13px");
		
		ListBox listBox_3 = new ListBox();
		listBox_3.addItem("Si");
		listBox_3.addItem("No");
		listBox_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_3, 567, 468);
		listBox_3.setSize("137px", "19px");
		
		ListBox listBox_4 = new ListBox();
		listBox_4.addItem("Si");
		listBox_4.addItem("No");
		listBox_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_4, 567, 496);
		listBox_4.setSize("137px", "19px");
		
		ListBox listBox_5 = new ListBox();
		listBox_5.addItem("Si");
		listBox_5.addItem("No");
		listBox_5.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_5, 567, 521);
		listBox_5.setSize("137px", "19px");
		
		ListBox listBox_6 = new ListBox();
		listBox_6.addItem("Si");
		listBox_6.addItem("No");
		listBox_6.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_6, 567, 546);
		listBox_6.setSize("137px", "19px");
		
		ListBox listBox_7 = new ListBox();
		listBox_7.addItem("Si");
		listBox_7.addItem("No");
		listBox_7.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_7, 567, 571);
		listBox_7.setSize("137px", "19px");
		
		Label lblEnfermedades = new Label("Enfermedades");
		lblEnfermedades.setStyleName("label");
		absolutePanel.add(lblEnfermedades, 10, 654);
		lblEnfermedades.setSize("338px", "13px");
		
		TextArea textArea_5 = new TextArea();
		textArea_5.setStyleName("gwt-TextBox2");
		absolutePanel.add(textArea_5, 10, 673);
		textArea_5.setSize("687px", "100px");
		
		Label lblI = new Label("i) Vive con familia");
		lblI.setStyleName("label");
		absolutePanel.add(lblI, 37, 602);
		lblI.setSize("511px", "13px");
		
		ListBox listBox_8 = new ListBox();
		listBox_8.addItem("Si");
		listBox_8.addItem("No");
		listBox_8.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_8, 567, 596);
		listBox_8.setSize("137px", "19px");
		
		Label lblAporteCasa = new Label("Aporte Casa");
		lblAporteCasa.setStyleName("label");
		absolutePanel.add(lblAporteCasa, 20, 787);
		lblAporteCasa.setSize("75px", "13px");
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox, 20, 812);
		textBox.setSize("117px", "11px");
		
		ListBox listBox_10 = new ListBox();
		listBox_10.addItem("Si");
		listBox_10.addItem("No");
		listBox_10.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_10, 175, 812);
		listBox_10.setSize("137px", "19px");
		
		Label lblTieneDeudas = new Label("Tiene deudas");
		lblTieneDeudas.setStyleName("label");
		absolutePanel.add(lblTieneDeudas, 175, 787);
		lblTieneDeudas.setSize("81px", "13px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_1, 330, 812);
		textBox_1.setSize("117px", "11px");
		
		Label lblAmortizacinMensual = new Label("Amortización mensual");
		lblAmortizacinMensual.setStyleName("label");
		absolutePanel.add(lblAmortizacinMensual, 330, 787);
		lblAmortizacinMensual.setSize("137px", "13px");
		
		Label lblNombreDeLa = new Label("Nombre de la institución donde tiene el crédito");
		lblNombreDeLa.setStyleName("label");
		absolutePanel.add(lblNombreDeLa, 488, 787);
		lblNombreDeLa.setSize("229px", "13px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_2, 488, 812);
		textBox_2.setSize("209px", "11px");
		
		ListBox listBox_9 = new ListBox();
		listBox_9.addItem("0");
		listBox_9.addItem("1");
		listBox_9.addItem("2");
		listBox_9.addItem("2");
		listBox_9.addItem("3");
		listBox_9.addItem("4");
		listBox_9.addItem("5");
		listBox_9.addItem("6");
		listBox_9.addItem("7");
		listBox_9.addItem("8");
		listBox_9.addItem("9");
		listBox_9.addItem("10");
		listBox_9.addItem("11");
		listBox_9.addItem("12");
		listBox_9.addItem("13");
		listBox_9.addItem("14");
		listBox_9.addItem("15");
		listBox_9.addItem("16");
		listBox_9.addItem("17");
		listBox_9.addItem("18");
		listBox_9.addItem("19");
		listBox_9.addItem("20");
		listBox_9.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_9, 20, 862);
		listBox_9.setSize("137px", "19px");
		
		Label lblNoDependientes = new Label("No. Dependientes");
		lblNoDependientes.setStyleName("label");
		absolutePanel.add(lblNoDependientes, 20, 837);
		lblNoDependientes.setSize("137px", "13px");
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_3, 175, 862);
		textBox_3.setSize("117px", "11px");
		
		Label label = new Label("Fecha");
		label.setStyleName("label");
		absolutePanel.add(label, 175, 837);
		label.setSize("75px", "13px");
		
		TextBox textBox_4 = new TextBox();
		textBox_4.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_4, 485, 862);
		textBox_4.setSize("117px", "11px");
		
		Label lblPagoMensual = new Label("Pago mensual");
		lblPagoMensual.setStyleName("label");
		absolutePanel.add(lblPagoMensual, 485, 837);
		lblPagoMensual.setSize("137px", "13px");
		
		ListBox listBox_11 = new ListBox();
		listBox_11.addItem("Si");
		listBox_11.addItem("No");
		listBox_11.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_11, 330, 862);
		listBox_11.setSize("137px", "19px");
		
		Label lblAlquila = new Label("Alquila");
		lblAlquila.setStyleName("label");
		absolutePanel.add(lblAlquila, 330, 837);
		lblAlquila.setSize("81px", "13px");
		
		ListBox listBox_12 = new ListBox();
		listBox_12.addItem("Si");
		listBox_12.addItem("No");
		listBox_12.setStyleName("gwt-TextBox2");
		absolutePanel.add(listBox_12, 567, 621);
		listBox_12.setSize("137px", "19px");
		
		Label lblKCasaPropia = new Label("k) Casa Propia");
		lblKCasaPropia.setStyleName("label");
		absolutePanel.add(lblKCasaPropia, 37, 627);
		lblKCasaPropia.setSize("511px", "13px");
		
		Label lblPretencionSalarial = new Label("Pretencion Salarial");
		lblPretencionSalarial.setStyleName("label");
		absolutePanel.add(lblPretencionSalarial, 20, 887);
		lblPretencionSalarial.setSize("137px", "13px");
		
		TextBox textBox_5 = new TextBox();
		textBox_5.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_5, 20, 906);
		textBox_5.setSize("117px", "11px");
		
		Label lblOtrosIngresos = new Label("Otros Ingresos");
		lblOtrosIngresos.setStyleName("label");
		absolutePanel.add(lblOtrosIngresos, 10, 939);
		lblOtrosIngresos.setSize("338px", "13px");
		
		TextArea textArea_6 = new TextArea();
		textArea_6.setStyleName("gwt-TextBox2");
		absolutePanel.add(textArea_6, 10, 958);
		textArea_6.setSize("687px", "100px");
		
		TextBox textBox_6 = new TextBox();
		textBox_6.setStyleName("gwt-TextBox2");
		absolutePanel.add(textBox_6, 175, 906);
		textBox_6.setSize("117px", "11px");
		
		Label lblEntrevisto = new Label("Entrevisto");
		lblEntrevisto.setStyleName("label");
		absolutePanel.add(lblEntrevisto, 175, 887);
		lblEntrevisto.setSize("137px", "13px");
	}

}
