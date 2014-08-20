 /**
 * 
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * @author anibaljose
 *
 */
public class Empleados extends Composite {

	private TabPanel tabPanel;
	public Long id_empleado = 0L;
	
	private academico a;
	private familiares f;
	private historiales h;
	private Idioma i;
	private puestos p;
	private referencia_laboral rl ;
	private referencia_personal rp;
	private vacaciones v;
	private formulario_datos fd;
	private formulario_entrevista fe ;
	private formulario_prueba_periodo fpp;
	private formulario_prueba_periodo_dos fppd;
	public Empleados() {
		
		tabPanel = new TabPanel();
		tabPanel.setVisible(true);
		initWidget(tabPanel);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel, "Datos",true);
		scrollPanel.setSize("1200px", "480px");
		fd = new formulario_datos(this);
		scrollPanel.setWidget(fd);
		
		
	}	
	
	public void NuevasPestanas(){
		ScrollPanel scrollPanel_1 = new ScrollPanel();
		scrollPanel_1.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_1, "Familia",true);
		scrollPanel_1.setSize("1200px", "489px");
		f = new familiares(this);
		scrollPanel_1.setWidget(f);

		
		ScrollPanel scrollPanel_2 = new ScrollPanel();
		scrollPanel_2.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_2, "Academico", true);
		scrollPanel_2.setSize("1200px", "480px");
		a = new academico(this);
		scrollPanel_2.setWidget(a);
		
		ScrollPanel scrollPanel_3 = new ScrollPanel();
		scrollPanel_3.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_3, "Referencia Laboral", true);
		scrollPanel_3.setSize("1200px", "480px");
		rl = new referencia_laboral(this);///
		scrollPanel_3.setWidget(rl);
		rl.setHeight("236px");
		
		ScrollPanel scrollPanel_5 = new ScrollPanel();
		scrollPanel_5.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_5, "Referencia Personal", true);
		scrollPanel_5.setSize("1200px", "480px");
		rp = new referencia_personal(this);///
		scrollPanel_5.setWidget(rp);
		
		ScrollPanel scrollPanel_4 = new ScrollPanel();
		scrollPanel_4.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_4, "Idiomas", true);
		scrollPanel_4.setSize("1200px", "480px");
		setStyleName("");
		i = new Idioma(this);
		scrollPanel_4.setWidget(i);
		
		ScrollPanel scrollPanel_6 = new ScrollPanel();
		scrollPanel_6.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_6, "Evaluacion", true);
		scrollPanel_6.setSize("1200px", "480px");
		fpp = new formulario_prueba_periodo(this);
		scrollPanel_6.setWidget(fpp);
		
		ScrollPanel scrollPanel_7 = new ScrollPanel();
		scrollPanel_7.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_7, "Desempeño", true);
		scrollPanel_7.setSize("1200px", "480px");
		fppd = new formulario_prueba_periodo_dos(this);
		scrollPanel_7.setWidget(fppd);
		
		ScrollPanel scrollPanel_8 = new ScrollPanel();
		scrollPanel_8.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_8, "Puestos ", true);
		scrollPanel_8.setSize("1200px", "480px");
		p = new puestos(this);
		scrollPanel_8.setWidget(p);
		
		ScrollPanel scrollPanel_9 = new ScrollPanel();
		scrollPanel_9.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_9, "Entrevista", true);
		scrollPanel_9.setSize("1200px", "480px");
		fe = new formulario_entrevista(this);
		scrollPanel_9.setWidget(fe);
		
		ScrollPanel scrollPanel_10 = new ScrollPanel();
		scrollPanel_10.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_10, "Historial", true);
		scrollPanel_10.setSize("1200px", "480px");
		h = new historiales(this);
		scrollPanel_10.setWidget(h);

		ScrollPanel scrollPanel_11 = new ScrollPanel();
		scrollPanel_11.setAlwaysShowScrollBars(true);
		tabPanel.add(scrollPanel_11, "vacaciones", true);
		scrollPanel_11.setSize("1200px", "480px");
		v = new vacaciones(this);
		scrollPanel_11.setWidget(v);
	}

	public void setA(List<AuxHistorialAcademico> results) {
		a.agregarFormulario_lleno(results);
	}

	public void setF(List<AuxFamilia> results) {
		f.agregarFormulario_lleno(results);
	}

	public void setH(List<AuxHistorial> results) {
		h.agregarFormulario_lleno(results);
	}

	public void setI(List<AuxIdioma> results) {
		i.agregarFormulario_lleno(results);
	}

	public void setP(List<AuxPuesto> results) {
		p.agregarFormulario_lleno(results);
	}

	public void setRL(List<AuxReferenciaLaboral> results) {
		rl.agregarFormulario_lleno(results);
	}

	public void setRP(List<AuxReferenciaPersonal> results) {
		rp.agregarFormulario_lleno(results);
	}
	public void setV(List<AuxVacaciones> results) {
		v.agregarFormulario_lleno(results);
	}

	public void setFD(AuxEmpleado r) {

	 String[] numerosComoArray  = r.getDepto_municipio_cedula().split(",");
	 String deptocedula ="";
	 String deptodir  ="";
	 String municedula ="";
	 String munidir ="";
	 
	 for (int i = 0; i < numerosComoArray.length; i++) {
		 if(i == 0)
			 deptocedula = numerosComoArray[i];
		 if(i == 1)
			 municedula = numerosComoArray[i];
     }	

	 String[] numerosComoArray2  = r.getDepto_municipio_residencia().split(",");
	 for (int i = 0; i < numerosComoArray2.length; i++) {
		 if(i == 0)
			 deptodir = numerosComoArray2[i];
		 if(i == 1)
			 munidir = numerosComoArray2[i];
     }	
	 this.id_empleado = r.getId_empleado();
			fd.LlenarDatos(r.getId_empleado(),r.getEstado_civil(), r.getSexo(), r.getPrimer_apellido(), r.getSegundo_apellido(), 
					r.getApellido_casada(), ""+r.getAfiliacion_igss(), r.getPrimer_nombre(), r.getSegundo_nombre(), 
					r.getPais(), ""+r.getNo_Dependientes(), r.getTipo_pasaporte(), municedula, r.getDireccion_actual(), 
					munidir,r.getEmail(), r.getTipo_licencia(), r.getFecha_nacimiento(),r.getOcupacion(), r.getCentro_trabajo(), 
					""+r.getCodigo_ingreso(), r.getProfesion(), r.getTipo_planilla(),r.getFecha_ingreso(), ""+r.getNo_registro(), 
					""+r.getNo_orden(),""+ r.getCui(), ""+r.getTelefono(), ""+r.getCelular(), ""+r.getNo_licencia(), r.getNit(), ""+r.getNo_pasaporte(), 
					""+r.getSalario_base(), ""+r.getBonificacion(), ""+r.getTotal(), deptocedula, deptodir, r.getConIVS(), r.getSinIVS());
	
	}
	
	public void setFE(AuxEntrevista r) {

        	String valorA = "No";
        	String valorB = "No";
        	String valorC = "No";
        	String valorE = "No";
        	String valorF = "No";
        	String valorG = "No";
        	String valorH = "No";
        	String valorI = "No";
        	String valorJ = "No";
        	String valorDeudas = "No";
        	String valorAlquila = "No";
        	if(r.getDisponibilidad_inmediata()){ valorA = "Si";}
        	if(r.getDisposicion_a_viajar()){ valorB = "Si";}
        	if(r.getFlexibilidad_horario()){ valorC = "Si";}
        	if(r.getAntecedentes_penales()){ valorE = "Si";}
        	if(r.getAntecedentes_policiacos()){ valorF = "Si";}
        	if(r.getCarta_recomendacion_laboral()){ valorG = "Si";}
        	if(r.getCarta_recomendacion_personal()){ valorH = "Si";}
        	if(r.getVive_con_familia()){ valorI = "Si";}
        	if(r.getVive_con_familia()){ valorJ = "Si";}
        	if(r.getTiene_deudas()){ valorDeudas = "Si";}
        	if(r.getAlquila()){ valorAlquila = "Si";}
        	
		    	fe.LlenarDatos(r.getId_entrevista(),r.getQue_conoces(), r.getPor_que_trabajas_aqui(), r.getComo_se_describe(),r.getMetas(), 
		    			valorA, valorB, valorC, valorE, valorF, valorG, valorH, valorI, valorJ, r.getEnfermedades(), 
				r.getTrabajar_por_presion(), r.getEmpresa_credito(), valorDeudas, ""+r.getNo_dependientes(), valorAlquila, 
				r.getOtros_Ingresos(), r.getEntrevisto(), r.getFecha_entrevista(),""+""+r.getAporte_casa(),""+ r.getAmortizacion(), 
				""+r.getPago_alquiler(),""+r.getPretencion_salarial_minimo());
	
		    }

	public void setFPP(List<AuxTest> r) {
		if(!r.isEmpty()){
			for (AuxTest n : r) {
				System.out.println("n.getTipo_test() "+n.getTipo_test().equals("1") );
				if(n.getTipo_test().equals("1")){
					fpp.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
							""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
							""+n.getPregunta10(), n.getEvaluador(), n.getFecha_test());
				}else{
					fppd.LlenarDatos(n.getId_test(),""+n.getPregunta1(),""+ n.getPregunt2(), ""+n.getPregunta3(),""+ n.getPregunta4(), 
							""+n.getPregunta5(), ""+n.getPregunta6(), ""+n.getPregunta7(),""+ n.getPregunta8(),""+n.getPregunta9(), 
							""+n.getPregunta10(), n.getEvaluador(), n.getFecha_test());
				}
			}//fin del for
		}//fin del if r.isEmpty
	}
	
	public void familia_unica()
	{
		f.agregar_parientes_unicos();
	}

}
