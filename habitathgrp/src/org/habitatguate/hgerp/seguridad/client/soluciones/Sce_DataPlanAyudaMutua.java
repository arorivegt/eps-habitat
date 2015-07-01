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
	
	}
}
