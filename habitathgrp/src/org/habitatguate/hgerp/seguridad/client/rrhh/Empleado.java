/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.ArrayList;
import java.util.List;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEntrevista;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorial;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxHistorialAcademico;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxIdioma;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPuesto;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaLaboral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxReferenciaPersonal;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSalario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxTest;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxPermiso;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
/**
 * 
 * @author anibaljose
 *
 */
public class Empleado extends Composite {


	private Idioma idioma;
	private Puestos puesto;
	private Salario salario;
	private Familia familia;
	private Desempeno desempeno;
	private Permiso permisos;
	private Academico academico;
	private Historiales historial;
	private Evaluacion evaluacion;
	private FormularioDatos formularioDatos;
	private ReferenciaLaboral referenciaLaboral ;
	private ReferenciaPersonal referenciaPersonal;
	private FormularioEntrevista formularioEntrevista ;
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
	private Empleado emp = null;
	private TabPanel tabPanel;
	public Long id_empleado = 0L;
	private String formulario = "E";
	
	public Empleado(final int tipo,  final String tipoEmpleado, Long rol) {
		emp = this;
		tabPanel = new TabPanel();
		tabPanel.setSize("100%", "100%");
		initWidget(tabPanel);
		
		if(tipoEmpleado.equals("E")){
			formulario = "Datos-Empleado";
		}else{
			formulario = "Datos-RRHH";
		}
		
		AdministracionService.ObtenerUsuarioPermisoNombre(formulario,rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			
    		}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel = new ScrollPanel();
					tabPanel.add(scrollPanel, "Datos",true);
					scrollPanel.setSize("100%", "100%");
					formularioDatos = new FormularioDatos(emp,tipo);
					scrollPanel.setWidget(formularioDatos);
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel = new ScrollPanel();
					tabPanel.add(scrollPanel, "Datos",true);
					scrollPanel.setSize("100%", "100%");
					formularioDatos = new FormularioDatos(emp,tipo);
					scrollPanel.setWidget(formularioDatos);
					formularioDatos.btnHabilitar(false);
				}
				

				if(tipoEmpleado.equals("E")){
					formulario = "Datos-Empleado";
					inavilidarDatosYPestanas();
				}else{
					formulario = "Datos-RRHH";
				}
			}
		});
	}	
	
	public void NuevasPestanas(Long rol){
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Familia-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			
    		}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_1 = new ScrollPanel();
					scrollPanel_1.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_1, "Familia",true);
					scrollPanel_1.setSize("100%", "1000px");
					familia = new Familia(emp);
					scrollPanel_1.setWidget(familia);
					familia.valor = true;
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_1 = new ScrollPanel();
					scrollPanel_1.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_1, "Familia",true);
					scrollPanel_1.setSize("100%", "1000px");
					familia = new Familia(emp);
					scrollPanel_1.setWidget(familia);
					familia.valor = false;
				}
			}
		});

		
		AdministracionService.ObtenerUsuarioPermisoNombre("Academico-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_2 = new ScrollPanel();
					scrollPanel_2.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_2, "Academico", true);
					scrollPanel_2.setSize("100%", "1000px");
					academico = new Academico(emp);
					scrollPanel_2.setWidget(academico);
					academico.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_2 = new ScrollPanel();
					scrollPanel_2.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_2, "Academico", true);
					scrollPanel_2.setSize("100%", "1000px");
					academico = new Academico(emp);
					scrollPanel_2.setWidget(academico);
					academico.valor = false;
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("RefLaboral-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_3 = new ScrollPanel();
					scrollPanel_3.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_3, "Ref. Laboral", true);
					scrollPanel_3.setSize("100%", "1000px");
					referenciaLaboral = new ReferenciaLaboral(emp);///
					scrollPanel_3.setWidget(referenciaLaboral);
					referenciaLaboral.setHeight("236px");
					referenciaLaboral.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_3 = new ScrollPanel();
					scrollPanel_3.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_3, "Ref. Laboral", true);
					scrollPanel_3.setSize("100%", "1000px");
					referenciaLaboral = new ReferenciaLaboral(emp);///
					scrollPanel_3.setWidget(referenciaLaboral);
					referenciaLaboral.setHeight("236px");
					referenciaLaboral.valor = false;
				}
			}
		});

		AdministracionService.ObtenerUsuarioPermisoNombre("RefPersonal-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_5 = new ScrollPanel();
					scrollPanel_5.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_5, "Ref. Personal", true);
					scrollPanel_5.setSize("100%", "1000px");
					referenciaPersonal = new ReferenciaPersonal(emp);///
					scrollPanel_5.setWidget(referenciaPersonal);
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_5 = new ScrollPanel();
					scrollPanel_5.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_5, "Ref. Personal", true);
					scrollPanel_5.setSize("100%", "1000px");
					referenciaPersonal = new ReferenciaPersonal(emp);///
					scrollPanel_5.setWidget(referenciaPersonal);
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Idiomas-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_4 = new ScrollPanel();
					scrollPanel_4.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_4, "Idiomas", true);
					scrollPanel_4.setSize("100%", "1000px");
					setStyleName("");
					idioma = new Idioma(emp);
					scrollPanel_4.setWidget(idioma);
					idioma.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_4 = new ScrollPanel();
					scrollPanel_4.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_4, "Idiomas", true);
					scrollPanel_4.setSize("100%", "1000px");
					setStyleName("");
					idioma = new Idioma(emp);
					scrollPanel_4.setWidget(idioma);
					idioma.valor = false;
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Desempeno-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_6 = new ScrollPanel();
					scrollPanel_6.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_6, "Desempeño", true);
					scrollPanel_6.setSize("100%", "1000px");
					desempeno = new  Desempeno(id_empleado);
					scrollPanel_6.setWidget(desempeno);
					desempeno.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_6 = new ScrollPanel();
					scrollPanel_6.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_6, "Desempeño", true);
					scrollPanel_6.setSize("100%", "1000px");
					desempeno = new  Desempeno(id_empleado);
					scrollPanel_6.setWidget(desempeno);
					desempeno.valor = false;
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Evaluacion-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_7 = new ScrollPanel();
					scrollPanel_7.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_7, "Evaluacion", true);
					scrollPanel_7.setSize("100%", "1000px");
					evaluacion = new Evaluacion(id_empleado);
					scrollPanel_7.setWidget(evaluacion);
					evaluacion.valorr = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_7 = new ScrollPanel();
					scrollPanel_7.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_7, "Evaluacion", true);
					scrollPanel_7.setSize("100%", "1000px");
					evaluacion = new Evaluacion(id_empleado);
					scrollPanel_7.setWidget(evaluacion);
					evaluacion.valorr = false;
				}
			}
		});

		AdministracionService.ObtenerUsuarioPermisoNombre("Puestos-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_8 = new ScrollPanel();
					scrollPanel_8.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_8, "Puestos ", true);
					scrollPanel_8.setSize("100%", "1000px");
					puesto = new Puestos(emp);
					scrollPanel_8.setWidget(puesto);
					puesto.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_8 = new ScrollPanel();
					scrollPanel_8.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_8, "Puestos ", true);
					scrollPanel_8.setSize("100%", "1000px");
					puesto = new Puestos(emp);
					scrollPanel_8.setWidget(puesto);
					puesto.valor = false;
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Salarios-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_s = new ScrollPanel();
					scrollPanel_s.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_s, "Salarios", true);
					scrollPanel_s.setSize("100%", "1000px");
					salario = new Salario(emp);
					scrollPanel_s.setWidget(salario);
					salario.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_s = new ScrollPanel();
					scrollPanel_s.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_s, "Salarios", true);
					scrollPanel_s.setSize("100%", "1000px");
					salario = new Salario(emp);
					scrollPanel_s.setWidget(salario);
					salario.valor = false;
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Entrevistas-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_9 = new ScrollPanel();
					scrollPanel_9.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_9, "Entrevista", true);
					scrollPanel_9.setSize("100%", "1000px");
					formularioEntrevista = new FormularioEntrevista(emp);
					scrollPanel_9.setWidget(formularioEntrevista);
					formularioEntrevista.btnhinabilitar(true);
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_9 = new ScrollPanel();
					scrollPanel_9.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_9, "Entrevista", true);
					scrollPanel_9.setSize("100%", "1000px");
					formularioEntrevista = new FormularioEntrevista(emp);
					scrollPanel_9.setWidget(formularioEntrevista);
					formularioEntrevista.btnhinabilitar(false);
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Historial-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_10 = new ScrollPanel();
					scrollPanel_10.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_10, "Historial", true);
					scrollPanel_10.setSize("100%", "1000px");
					historial = new Historiales(emp);
					scrollPanel_10.setWidget(historial);
					historial.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_10 = new ScrollPanel();
					scrollPanel_10.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_10, "Historial", true);
					scrollPanel_10.setSize("100%", "1000px");
					historial = new Historiales(emp);
					scrollPanel_10.setWidget(historial);
					historial.valor = false;
				}
			}
		});
		
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Permisos-RRHH",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_11 = new ScrollPanel();
					scrollPanel_11.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_11, "Permisos", true);
					scrollPanel_11.setSize("100%", "1000px");
					permisos = new Permiso(emp);
					permisos.valor = true;
					scrollPanel_11.setWidget(permisos);
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_11 = new ScrollPanel();
					scrollPanel_11.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_11, "Permisos", true);
					scrollPanel_11.setSize("100%", "1000px");
					permisos = new Permiso(emp);
					permisos.valor = false;
					scrollPanel_11.setWidget(permisos);
				}
			}
		});
	}
	public void NuevasPestanasdos(Long rol){
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Familia-Empleado",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
    	{
    		public void onFailure(Throwable caught) 
    		{
    			
    		}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_1 = new ScrollPanel();
					scrollPanel_1.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_1, "Familia",true);
					scrollPanel_1.setSize("100%", "1000px");
					familia = new Familia(emp);
					scrollPanel_1.setWidget(familia);
					familia.valor = true;
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_1 = new ScrollPanel();
					scrollPanel_1.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_1, "Familia",true);
					scrollPanel_1.setSize("100%", "1000px");
					familia = new Familia(emp);
					scrollPanel_1.setWidget(familia);
					familia.valor = false;
				}
			}
		});
		
		AdministracionService.ObtenerUsuarioPermisoNombre("Academico-Empleado",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_2 = new ScrollPanel();
					scrollPanel_2.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_2, "Academico", true);
					scrollPanel_2.setSize("100%", "1000px");
					academico = new Academico(emp);
					scrollPanel_2.setWidget(academico);
					academico.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_2 = new ScrollPanel();
					scrollPanel_2.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_2, "Academico", true);
					scrollPanel_2.setSize("100%", "1000px");
					academico = new Academico(emp);
					scrollPanel_2.setWidget(academico);
					academico.valor = false;
				}
			}
		});

		AdministracionService.ObtenerUsuarioPermisoNombre("RefLaboral-Empleado",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_3 = new ScrollPanel();
					scrollPanel_3.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_3, "Ref. Laboral", true);
					scrollPanel_3.setSize("100%", "1000px");
					referenciaLaboral = new ReferenciaLaboral(emp);///
					scrollPanel_3.setWidget(referenciaLaboral);
					referenciaLaboral.setHeight("236px");
					referenciaLaboral.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_3 = new ScrollPanel();
					scrollPanel_3.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_3, "Ref. Laboral", true);
					scrollPanel_3.setSize("100%", "1000px");
					referenciaLaboral = new ReferenciaLaboral(emp);///
					scrollPanel_3.setWidget(referenciaLaboral);
					referenciaLaboral.setHeight("236px");
					referenciaLaboral.valor = false;
				}
			}
		});

		AdministracionService.ObtenerUsuarioPermisoNombre("RefPersonal-Empleado",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_5 = new ScrollPanel();
					scrollPanel_5.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_5, "Ref. Personal", true);
					scrollPanel_5.setSize("100%", "1000px");
					referenciaPersonal = new ReferenciaPersonal(emp);///
					scrollPanel_5.setWidget(referenciaPersonal);
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_5 = new ScrollPanel();
					scrollPanel_5.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_5, "Ref. Personal", true);
					scrollPanel_5.setSize("100%", "1000px");
					referenciaPersonal = new ReferenciaPersonal(emp);///
					scrollPanel_5.setWidget(referenciaPersonal);
				}
			}
		});

		AdministracionService.ObtenerUsuarioPermisoNombre("Idiomas-Empleado",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_4 = new ScrollPanel();
					scrollPanel_4.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_4, "Idiomas", true);
					scrollPanel_4.setSize("100%", "1000px");
					setStyleName("");
					idioma = new Idioma(emp);
					scrollPanel_4.setWidget(idioma);
					idioma.valor = true;
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_4 = new ScrollPanel();
					scrollPanel_4.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_4, "Idiomas", true);
					scrollPanel_4.setSize("100%", "1000px");
					setStyleName("");
					idioma = new Idioma(emp);
					scrollPanel_4.setWidget(idioma);
					idioma.valor = false;
				}
			}
		});

		AdministracionService.ObtenerUsuarioPermisoNombre("Entrevistas-Empleado",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_9 = new ScrollPanel();
					scrollPanel_9.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_9, "Entrevista", true);
					scrollPanel_9.setSize("100%", "1000px");
					formularioEntrevista = new FormularioEntrevista(emp);
					scrollPanel_9.setWidget(formularioEntrevista);
					formularioEntrevista.btnhinabilitar(true);
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_9 = new ScrollPanel();
					scrollPanel_9.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_9, "Entrevista", true);
					scrollPanel_9.setSize("100%", "1000px");
					formularioEntrevista = new FormularioEntrevista(emp);
					scrollPanel_9.setWidget(formularioEntrevista);
					formularioEntrevista.btnhinabilitar(false);
				}
			}
		});

		AdministracionService.ObtenerUsuarioPermisoNombre("Permisos-Empleado",rol,new AsyncCallback<List<AuxUsuarioPermiso>>()
		{
			public void onFailure(Throwable caught) 
			{
				
			}

			@Override
			public void onSuccess(List<AuxUsuarioPermiso> results)
			{
				if(results.get(0).getPermiso().equals("RW")){
					ScrollPanel scrollPanel_11 = new ScrollPanel();
					scrollPanel_11.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_11, "Permisos", true);
					scrollPanel_11.setSize("100%", "1000px");
					permisos = new Permiso(emp);
					permisos.valor = true;
					scrollPanel_11.setWidget(permisos);
					
				}else if(results.get(0).getPermiso().equals("R")){
					ScrollPanel scrollPanel_11 = new ScrollPanel();
					scrollPanel_11.setAlwaysShowScrollBars(false);
					tabPanel.add(scrollPanel_11, "Permisos", true);
					scrollPanel_11.setSize("100%", "1000px");
					permisos = new Permiso(emp);
					permisos.valor = false;
					scrollPanel_11.setWidget(permisos);
				}
			}
		});
		
	}

	public void EvaluacionesCompartidas()
	{
		ScrollPanel scrollPanel_6 = new ScrollPanel();
		scrollPanel_6.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel_6, "Desempeño", true);
		scrollPanel_6.setSize("100%", "1000px");
		desempeno = new  Desempeno(id_empleado);
		desempeno.btnAgregar.setVisible(false);
		desempeno.btnAgregar.setEnabled(false);
		desempeno.bandera = false;
		scrollPanel_6.setWidget(desempeno);
		
		ScrollPanel scrollPanel_7 = new ScrollPanel();
		scrollPanel_7.setAlwaysShowScrollBars(false);
		tabPanel.add(scrollPanel_7, "Evaluacion", true);
		scrollPanel_7.setSize("100%", "1000px");
		evaluacion = new Evaluacion(id_empleado);
		evaluacion.btnAgregar.setVisible(false);
		evaluacion.btnAgregar.setEnabled(false);
		evaluacion.bandera = false;
		scrollPanel_7.setWidget(evaluacion);
	}
	
	public void setAcademico(List<AuxHistorialAcademico> listAuxHistorialAcademico) {
		academico.agregarFormulario_lleno(listAuxHistorialAcademico);
	}

	public void setFamilia(List<AuxFamilia> listAuxFamilia) {
		familia.agregarFormulario_lleno(listAuxFamilia);
	}

	public void setHistorial(List<AuxHistorial> listAuxHistorial) {
		historial.agregarFormulario_lleno(listAuxHistorial);
	}

	public void setIdioma(List<AuxIdioma> listAuxIdioma) {
		idioma.agregarFormulario_lleno(listAuxIdioma);
	}

	public void setPuesto(List<AuxPuesto> listAuxPuesto) {
		puesto.agregarFormulario_lleno(listAuxPuesto);
	}

	public void setReferenciaLaboral(List<AuxReferenciaLaboral> listAuxReferenciaLaboral) {
		referenciaLaboral.agregarFormulario_lleno(listAuxReferenciaLaboral);
	}

	public void setReferenciaPersonal(List<AuxReferenciaPersonal> listAuxReferenciaPersonal) {
		referenciaPersonal.agregarFormulario_lleno(listAuxReferenciaPersonal);
	}
	public void setPermiso(List<AuxPermiso> lsitAuxPermiso) {
		permisos.agregarFormulario_lleno(lsitAuxPermiso);
	}

	public void setSalario(List<AuxSalario> listAuxSalario) {
		salario.agregarFormulario_lleno(listAuxSalario);
	}

	public void setFormularioDatos(AuxEmpleado auxEmpleado) {
		
	 String deptodir  = "";
	 String munidir   = "";
	 
	 String deptodir2  = "";
	 String munidir2   = "";
	 

	 String[] numerosComoArray2  = auxEmpleado.getDepto_municipio_residencia().split(",");
	 for (int i = 0; i < numerosComoArray2.length; i++) {
		 if(i == 0)
			 deptodir = numerosComoArray2[i];
		 if(i == 1)
			 munidir = numerosComoArray2[i];
     }	
	 
	 String[] numerosComoArray1  = auxEmpleado.getDepto_municipio_nacimiento().split(",");
	 for (int i = 0; i < numerosComoArray1.length; i++) {
		 if(i == 0)
			 deptodir2 = numerosComoArray1[i];
		 if(i == 1)
			 munidir2 = numerosComoArray1[i];
     }
	 this.id_empleado = auxEmpleado.getId_empleado();
			formularioDatos.LlenarDatos(auxEmpleado.getId_empleado(),auxEmpleado.getEstado_civil(), auxEmpleado.getSexo(), auxEmpleado.getPrimer_apellido(), auxEmpleado.getSegundo_apellido(), 
					auxEmpleado.getApellido_casada(), auxEmpleado.getAfiliacion_igss(), auxEmpleado.getPrimer_nombre(), auxEmpleado.getSegundo_nombre(), 
					auxEmpleado.getPais(), auxEmpleado.getNo_Dependientes(), auxEmpleado.getTipo_pasaporte(), munidir,auxEmpleado.getDireccion_actual(), 
					auxEmpleado.getEmail(), auxEmpleado.getTipo_licencia(), auxEmpleado.getFecha_nacimiento(),auxEmpleado.getOcupacion(), auxEmpleado.getCentro_trabajo(), 
					auxEmpleado.getCodigo_ingreso(), auxEmpleado.getProfesion(), auxEmpleado.getTipo_planilla(),auxEmpleado.getFecha_ingreso(), 
					auxEmpleado.getNoCuenta(), auxEmpleado.getTipoCuenta(),auxEmpleado.getNombreBanco(), auxEmpleado.getCui(), auxEmpleado.getTelefono(), auxEmpleado.getCelular(), 
					auxEmpleado.getNo_licencia(), auxEmpleado.getNit(), auxEmpleado.getNo_pasaporte(), ""+auxEmpleado.getSalario_base(), ""+auxEmpleado.getBonificacion(), 
					""+auxEmpleado.getDiasDeVacaciones(), deptodir, auxEmpleado.getIVS(), auxEmpleado.getURLFile(),auxEmpleado.getKeyFile(), auxEmpleado.getEstado(),auxEmpleado.getPasaporte(),
					auxEmpleado.getLicencia(),auxEmpleado.getEtnia(),auxEmpleado.getNombreEmergencia(),auxEmpleado.getTelefonoEmergencia(),auxEmpleado.getNombreEmergencia2(),
					auxEmpleado.getTelefonoEmergencia2(),deptodir2,munidir2,auxEmpleado.getJefe_Inmediato(),auxEmpleado.getAfiliado());
	
	}
	
	public void setFormularioEntrevista(AuxEntrevista auxEntrevista) {

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
        	if(auxEntrevista.getDisponibilidad_inmediata()){ valorA = "Si";}
        	if(auxEntrevista.getDisposicion_a_viajar()){ valorB = "Si";}
        	if(auxEntrevista.getFlexibilidad_horario()){ valorC = "Si";}
        	if(auxEntrevista.getAntecedentes_penales()){ valorE = "Si";}
        	if(auxEntrevista.getAntecedentes_policiacos()){ valorF = "Si";}
        	if(auxEntrevista.getCarta_recomendacion_laboral()){ valorG = "Si";}
        	if(auxEntrevista.getCarta_recomendacion_personal()){ valorH = "Si";}
        	if(auxEntrevista.getVive_con_familia()){ valorI = "Si";}
        	if(auxEntrevista.getVive_con_familia()){ valorJ = "Si";}
        	if(auxEntrevista.getTiene_deudas()){ valorDeudas = "Si";}
        	if(auxEntrevista.getAlquila()){ valorAlquila = "Si";}
        	
		    	formularioEntrevista.LlenarDatos(auxEntrevista.getId_entrevista(),auxEntrevista.getQue_conoces(), auxEntrevista.getPor_que_trabajas_aqui(), auxEntrevista.getComo_se_describe(),auxEntrevista.getMetas(), 
		    			valorA, valorB, valorC, valorE, valorF, valorG, valorH, valorI, valorJ, auxEntrevista.getEnfermedades(), 
				auxEntrevista.getTrabajar_por_presion(), auxEntrevista.getEmpresa_credito(), valorDeudas, ""+auxEntrevista.getNo_dependientes(), valorAlquila, 
				auxEntrevista.getOtros_Ingresos(), auxEntrevista.getEntrevisto(), auxEntrevista.getFecha_entrevista(),""+""+auxEntrevista.getAporte_casa(),""+ auxEntrevista.getAmortizacion(), 
				""+auxEntrevista.getPago_alquiler(),""+auxEntrevista.getPretencion_salarial_minimo(),auxEntrevista.getTxtEntrevistoB(),auxEntrevista.getTxtEntrevistoC(),auxEntrevista.getTxtEntrevistoD(),
				auxEntrevista.getTxtObservacion1(),auxEntrevista.getTxtObservacion2(),auxEntrevista.getTxtObservacion3(),auxEntrevista.getTxtObservacion4(),auxEntrevista.getTxtObservacion5(),
				auxEntrevista.getDateFechaDeudaInicio(),auxEntrevista.getDateFechaDeudaInicio(),auxEntrevista.getMotivoDeuda(),auxEntrevista.getListDeudas());
	
		    }

	public void setFormularioTest(List<AuxTest> r) {
		List<AuxTest> valor = new ArrayList<AuxTest>();
		List<AuxTest> valor2 = new ArrayList<AuxTest>();
		if(!r.isEmpty())
		{
			for (AuxTest n : r) 
			{
				if(n.getTipo_test().equals("1")){
					valor.add(n);
				}else{
					valor2.add(n);
				}
			}
			desempeno.agregar_formularios(valor);
			evaluacion.agregar_formularios(valor2);
		}
	}
	
	public void familia_unica()
	{
		familia.agregar_parientes_unicos();
	}
	
	public void inavilidarDatosYPestanas(){
		formularioDatos.Inavilitar_Casillas();
	}

}
