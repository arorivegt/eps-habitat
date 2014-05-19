package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.Widget;
 
 @SuppressWarnings("deprecation")
public class UIStacksEjemplo extends ResizeComposite {
	 private static UiStackEjemploUiBinder uiBinder = GWT.create(UiStackEjemploUiBinder.class);
	 
   @UiField(provided = true)
   final Tree arbol1 = new Tree();
   {
//     arbol1.addItem("Opción 1");
 //    arbol1.addItem("Opción 2");
  //   arbol1.addItem("Opción 3");
   }
   
   @UiField
   Tree arbol2;
   
   @UiField(provided = true)
   final Tree arbol3 = new Tree();
   {
  //   arbol3.addItem("Opción 7");
  //   arbol3.addItem("Opción 8");
  //   arbol3.addItem("Opción 9");
   }
   
   @UiField(provided = true)
   final Tree arbol4 = new Tree();
   {
//	  arbol4.addItem("Opción 1");
//	  arbol4.addItem("Opción 2");
//	  arbol4.addItem("Opción 3");
	}
   
   public UIStacksEjemplo() {
     initWidget(uiBinder.createAndBindUi(this));
 //    arbol2.addItem("Opción 4");
 //    arbol2.addItem("Opción 5");
 //    arbol2.addItem("Opción 6");
   }
   
   
   interface UiStackEjemploUiBinder extends UiBinder<Widget, UIStacksEjemplo> {
   }
 }