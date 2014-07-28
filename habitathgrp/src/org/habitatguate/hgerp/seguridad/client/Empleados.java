 /**
 * 
 */
package org.habitatguate.hgerp.seguridad.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * @author anibaljose
 *
 */
public class Empleados extends Composite {

	public Long id_empleado = 0L;
	private TabPanel tabPanel;
	
	public Empleados() {
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel, "Datos",true);
		scrollPanel.setSize("1200px", "480px");
		formulario_datos fd = new formulario_datos(this);
		scrollPanel.setWidget(fd);
		
		
	}	
	
	public void Nuevas_Pestañas(){
		ScrollPanel scrollPanel_1 = new ScrollPanel();
		scrollPanel_1.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_1, "Familia",true);
		scrollPanel_1.setSize("1200px", "489px");
		familiares f = new familiares(this);
		scrollPanel_1.setWidget(f);

		
		ScrollPanel scrollPanel_2 = new ScrollPanel();
		scrollPanel_2.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_2, "Academico", true);
		scrollPanel_2.setSize("1200px", "480px");
		academico a = new academico(this);
		scrollPanel_2.setWidget(a);
		
		ScrollPanel scrollPanel_3 = new ScrollPanel();
		scrollPanel_3.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_3, "Referencia Laboral", true);
		scrollPanel_3.setSize("1200px", "480px");
		referencia_laboral rl = new referencia_laboral();
		scrollPanel_3.setWidget(rl);
		rl.setHeight("236px");
		
		ScrollPanel scrollPanel_5 = new ScrollPanel();
		scrollPanel_5.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_5, "Referencia Personal", true);
		scrollPanel_5.setSize("1200px", "480px");
		referencia_personal rp = new referencia_personal();
		scrollPanel_5.setWidget(rp);
		
		ScrollPanel scrollPanel_4 = new ScrollPanel();
		scrollPanel_4.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_4, "Idiomas", true);
		scrollPanel_4.setSize("1200px", "480px");
		setStyleName("");
		Idioma i = new Idioma();
		scrollPanel_4.setWidget(i);
		
		ScrollPanel scrollPanel_6 = new ScrollPanel();
		scrollPanel_6.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_6, "Evaluacion", true);
		scrollPanel_6.setSize("1200px", "480px");
		formulario_prueba_periodo fpp = new formulario_prueba_periodo();
		scrollPanel_6.setWidget(fpp);
		
		ScrollPanel scrollPanel_7 = new ScrollPanel();
		scrollPanel_7.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_7, "Desempeño", true);
		scrollPanel_7.setSize("1200px", "480px");
		formulario_prueba_periodo_dos fppd = new formulario_prueba_periodo_dos();
		scrollPanel_7.setWidget(fppd);
		
		ScrollPanel scrollPanel_8 = new ScrollPanel();
		scrollPanel_8.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_8, "Puestos ", true);
		scrollPanel_8.setSize("1200px", "480px");
		puestos p = new puestos();
		scrollPanel_8.setWidget(p);
		
		ScrollPanel scrollPanel_9 = new ScrollPanel();
		scrollPanel_9.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_9, "Entrevista", true);
		scrollPanel_9.setSize("1200px", "480px");
		formulario_entrevista fe = new formulario_entrevista();
		scrollPanel_9.setWidget(fe);
		
		ScrollPanel scrollPanel_10 = new ScrollPanel();
		scrollPanel_10.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_10, "Historial", true);
		scrollPanel_10.setSize("1200px", "480px");
		
		historiales h = new historiales();
		scrollPanel_10.setWidget(h);
		
		ScrollPanel scrollPanel_11 = new ScrollPanel();
		scrollPanel_11.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_11, "vacaciones", true);
		scrollPanel_11.setSize("1200px", "480px");
		vacaciones v = new vacaciones();
		scrollPanel_11.setWidget(v);
	}

}
