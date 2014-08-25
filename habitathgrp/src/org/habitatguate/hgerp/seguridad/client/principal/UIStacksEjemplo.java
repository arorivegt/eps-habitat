package org.habitatguate.hgerp.seguridad.client.principal;

import org.habitatguate.hgerp.seguridad.client.finanzas.Buscador_Parametro_Inv;
import org.habitatguate.hgerp.seguridad.client.rrhh.BDpuestos;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;
import org.habitatguate.hgerp.seguridad.client.rrhh.Empleados;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
 
public class UIStacksEjemplo extends ResizeComposite {
	 private Panel nuevo;
	 private static UiStackEjemploUiBinder uiBinder = GWT.create(UiStackEjemploUiBinder.class);
	 @UiField Label label_1;

   public UIStacksEjemplo(Panel nuevo) {
     initWidget(uiBinder.createAndBindUi(this));
     this.nuevo = nuevo;
   }

   
   interface UiStackEjemploUiBinder extends UiBinder<Widget, UIStacksEjemplo> {
   }
 	@UiHandler("label_1")
 	void onLabel_1Click(ClickEvent event) {
 		BuscadorEmpleados buscador = new BuscadorEmpleados();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(buscador, 0, 0);
 	}
 	@UiHandler("label_2")
 	void onLabel_2Click(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_3")
 	void onLabel_3Click(ClickEvent event) {

 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_4")
 	void onLabel_4Click(ClickEvent event) {

 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_1_Finan")
 	void onLabel_1_FinanClick(ClickEvent event) {
 		Buscador_Parametro_Inv buscador = new Buscador_Parametro_Inv();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(buscador, 0, 0);
 	}
 	@UiHandler("label_2_Finan")
 	void onLabel_2_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_3_Finan")
 	void onLabel_3_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
 	@UiHandler("label_4_Finan")
 	void onLabel_4_FinanClick(ClickEvent event) {
 		Window.alert("no esta disponible");
 	}
	@UiHandler("label_5")
	void onLabel_5Click(ClickEvent event) {
		Empleados e = new Empleados(1);
		e.inavilidarDatosYPestanas();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(e, 0, 0);
	}
	@UiHandler("label_6")
	void onLabel_6Click(ClickEvent event) {
		BDpuestos e = new BDpuestos();
 		this.nuevo.getAbsolutePanel_1().clear();
 		this.nuevo.getAbsolutePanel_1().add(e, 0, 0);
		
	}
 }

