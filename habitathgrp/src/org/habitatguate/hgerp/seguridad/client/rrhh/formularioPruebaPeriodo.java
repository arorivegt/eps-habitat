package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class formularioPruebaPeriodo extends Composite {

	 	private Long empleado;
		private Long id_prueba = 0L;
		private boolean bandera = true;
	    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);

		private Long id_BDprueba = 0L;
	    private ListBox listPregunta1;
		private ListBox listPregunta2;
		private ListBox listPregunta3;
		private ListBox listPregunta4;
		private ListBox listPregunta5;
		private ListBox listPregunta6;
		private ListBox listTest;
		private ListBox listPregunta7;
		private ListBox listPregunta8;
		private ListBox listPregunta9;
		private ListBox listPregunta10;
		private TextBox txtEvaluador;
		private DoubleBox txtPunteoTotal;
		private DateBox dateFecha ;
		private Desempeno d;
		
		private Label lblPregunta1;
		private Label lblPregunta2;
		private Label lblPregunta3;
		private Label lblPregunta4;
		private Label lblPregunta5;
		private Label lblPregunta6;
		private Label lblPregunta7;
		private Label lblPregunta8;
		private Label lblPregunta9;
		private Label lblPregunta10;
		private Label lblElijaLaEvaluacion;
		private Button btnCompartir;
		private Button btnEliminar;
		
	public formularioPruebaPeriodo(final Desempeno d, Long e) {
		this.d = d;
		this.empleado = e;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("700px", "1190px");
		listPregunta1 = new ListBox();
		listPregunta1.addItem("0");
		listPregunta1.addItem("1");
		listPregunta1.addItem("2");
		listPregunta1.addItem("3");
		listPregunta1.addItem("4");
		listPregunta1.addItem("5");
		listPregunta1.addItem("6");
		listPregunta1.addItem("7");
		listPregunta1.addItem("8");
		listPregunta1.addItem("9");
		listPregunta1.addItem("10");
		listPregunta1.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta1, 562, 519);
		listPregunta1.setSize("198px", "34px");
		
		listPregunta2 = new ListBox();
		listPregunta2.addItem("0");
		listPregunta2.addItem("1");
		listPregunta2.addItem("2");
		listPregunta2.addItem("3");
		listPregunta2.addItem("4");
		listPregunta2.addItem("5");
		listPregunta2.addItem("6");
		listPregunta2.addItem("7");
		listPregunta2.addItem("8");
		listPregunta2.addItem("9");
		listPregunta2.addItem("10");
		listPregunta2.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta2, 562, 559);
		listPregunta2.setSize("198px", "34px");
		
		listPregunta3 = new ListBox();
		listPregunta3.addItem("0");
		listPregunta3.addItem("1");
		listPregunta3.addItem("2");
		listPregunta3.addItem("3");
		listPregunta3.addItem("4");
		listPregunta3.addItem("5");
		listPregunta3.addItem("6");
		listPregunta3.addItem("7");
		listPregunta3.addItem("8");
		listPregunta3.addItem("9");
		listPregunta3.addItem("10");
		listPregunta3.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta3, 562, 599);
		listPregunta3.setSize("198px", "34px");
		
		 listPregunta4 = new ListBox();
		 listPregunta4.addItem("0");
		 listPregunta4.addItem("1");
		 listPregunta4.addItem("2");
		 listPregunta4.addItem("3");
		 listPregunta4.addItem("4");
		 listPregunta4.addItem("5");
		 listPregunta4.addItem("6");
		 listPregunta4.addItem("7");
		 listPregunta4.addItem("8");
		 listPregunta4.addItem("9");
		 listPregunta4.addItem("10");
		 listPregunta4.setStyleName("gwt-TextBox2");
		 absolutePanel.add(listPregunta4, 562, 639);
		 listPregunta4.setSize("198px", "34px");
		
		listPregunta5 = new ListBox();
		listPregunta5.addItem("0");
		listPregunta5.addItem("1");
		listPregunta5.addItem("2");
		listPregunta5.addItem("3");
		listPregunta5.addItem("4");
		listPregunta5.addItem("5");
		listPregunta5.addItem("6");
		listPregunta5.addItem("7");
		listPregunta5.addItem("8");
		listPregunta5.addItem("9");
		listPregunta5.addItem("10");
		listPregunta5.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta5, 562, 679);
		listPregunta5.setSize("198px", "34px");
		
		listPregunta6 = new ListBox();
		listPregunta6.addItem("0");
		listPregunta6.addItem("1");
		listPregunta6.addItem("2");
		listPregunta6.addItem("3");
		listPregunta6.addItem("4");
		listPregunta6.addItem("5");
		listPregunta6.addItem("6");
		listPregunta6.addItem("7");
		listPregunta6.addItem("8");
		listPregunta6.addItem("9");
		listPregunta6.addItem("10");
		listPregunta6.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta6, 562, 719);
		listPregunta6.setSize("198px", "34px");
		
		listPregunta7 = new ListBox();
		listPregunta7.addItem("0");
		listPregunta7.addItem("1");
		listPregunta7.addItem("2");
		listPregunta7.addItem("3");
		listPregunta7.addItem("4");
		listPregunta7.addItem("5");
		listPregunta7.addItem("6");
		listPregunta7.addItem("7");
		listPregunta7.addItem("8");
		listPregunta7.addItem("9");
		listPregunta7.addItem("10");
		listPregunta7.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta7, 562, 759);
		listPregunta7.setSize("198px", "34px");
		
		listPregunta8 = new ListBox();
		listPregunta8.addItem("0");
		listPregunta8.addItem("1");
		listPregunta8.addItem("2");
		listPregunta8.addItem("3");
		listPregunta8.addItem("4");
		listPregunta8.addItem("5");
		listPregunta8.addItem("6");
		listPregunta8.addItem("7");
		listPregunta8.addItem("8");
		listPregunta8.addItem("9");
		listPregunta8.addItem("10");
		listPregunta8.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta8, 562, 799);
		listPregunta8.setSize("198px", "34px");
		
		listPregunta9 = new ListBox();
		listPregunta9.addItem("0");
		listPregunta9.addItem("1");
		listPregunta9.addItem("2");
		listPregunta9.addItem("3");
		listPregunta9.addItem("4");
		listPregunta9.addItem("5");
		listPregunta9.addItem("6");
		listPregunta9.addItem("7");
		listPregunta9.addItem("8");
		listPregunta9.addItem("9");
		listPregunta9.addItem("10");
		listPregunta9.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta9, 562, 839);
		listPregunta9.setSize("198px", "34px");
		
		listPregunta10 = new ListBox();
		listPregunta10.addItem("0");
		listPregunta10.addItem("1");
		listPregunta10.addItem("2");
		listPregunta10.addItem("3");
		listPregunta10.addItem("4");
		listPregunta10.addItem("5");
		listPregunta10.addItem("6");
		listPregunta10.addItem("7");
		listPregunta10.addItem("8");
		listPregunta10.addItem("9");
		listPregunta10.addItem("10");
		listPregunta10.setStyleName("gwt-TextBox2");
		absolutePanel.add(listPregunta10, 562, 879);
		listPregunta10.setSize("198px", "34px");
		
		txtEvaluador = new TextBox();
		txtEvaluador.setMaxLength(500);
		txtEvaluador.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEvaluador, 26, 1019);
		txtEvaluador.setSize("218px", "34px");
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407518999395L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 283, 1019);
		dateFecha.setSize("227px", "32px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
				if(listTest.getSelectedIndex() != 0){
				if(bandera) {
					loginService.Insertar_Test(empleado, Integer.parseInt(listPregunta1.getItemText(listPregunta1.getSelectedIndex())), 
							Integer.parseInt(listPregunta2.getItemText(listPregunta2.getSelectedIndex())), Integer.parseInt(listPregunta3.getItemText(listPregunta3.getSelectedIndex())), 
							Integer.parseInt(listPregunta4.getItemText(listPregunta4.getSelectedIndex())), Integer.parseInt(listPregunta5.getItemText(listPregunta5.getSelectedIndex())), 
							Integer.parseInt(listPregunta6.getItemText(listPregunta6.getSelectedIndex())), Integer.parseInt(listPregunta7.getItemText(listPregunta7.getSelectedIndex())), 
							Integer.parseInt(listPregunta8.getItemText(listPregunta8.getSelectedIndex())), Integer.parseInt(listPregunta9.getItemText(listPregunta9.getSelectedIndex())), 
							Integer.parseInt(listPregunta10.getItemText(listPregunta10.getSelectedIndex())), dateFecha.getValue(), 
							txtEvaluador.getText(),id_BDprueba,true, "1", new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                           // Window.alert("Error  al Guardar Datos"+caught);
                        }

						@Override
                        public void onSuccess(Long result)
                        {
							id_prueba= result;
							bandera = false;
                        	setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        	//Window.alert("Datos Guardados exitosamente!!! ");
                        }

                 });
		}else{
			loginService.Actualizar_Test(empleado,id_prueba, Integer.parseInt(listPregunta1.getItemText(listPregunta1.getSelectedIndex())), 
					Integer.parseInt(listPregunta2.getItemText(listPregunta2.getSelectedIndex())), Integer.parseInt(listPregunta3.getItemText(listPregunta3.getSelectedIndex())), 
					Integer.parseInt(listPregunta4.getItemText(listPregunta4.getSelectedIndex())), Integer.parseInt(listPregunta5.getItemText(listPregunta5.getSelectedIndex())), 
					Integer.parseInt(listPregunta6.getItemText(listPregunta6.getSelectedIndex())), Integer.parseInt(listPregunta7.getItemText(listPregunta7.getSelectedIndex())), 
					Integer.parseInt(listPregunta8.getItemText(listPregunta8.getSelectedIndex())), Integer.parseInt(listPregunta9.getItemText(listPregunta9.getSelectedIndex())), 
					Integer.parseInt(listPregunta10.getItemText(listPregunta10.getSelectedIndex())), dateFecha.getValue(), 
					txtEvaluador.getText(),id_BDprueba, true,"1", new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) 
                {
                	setMensaje("alert alert-error", 
                			"Error !! \nal Actualizar Datos");
                   //Window.alert("Error  al Actualizar Datos"+caught);
                }

				@Override
                public void onSuccess(Long result)
                {
					bandera = false;
                	setMensaje("alert alert-success", 
                			"Datos Actualizados\n exitosamente!!!");
                	//Window.alert("Datos Actualizados exitosamente!!! ");
                }

         });
		}}else{

			setMensaje("alert alert-error", 
        			"Error !! \nDebe seleccionar un test \nasociado a este formulario");
		}
			}
		});
		
		txtPunteoTotal = new DoubleBox();
		txtPunteoTotal.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPunteoTotal, 547, 1019);
		txtPunteoTotal.setSize("211px", "34px");
		
		listTest = new ListBox();
		listTest.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTest, 26, 1112);
		listTest.setSize("220px", "48px");
		listTest.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(listTest.getSelectedIndex()!=0)
					BuscarBDtest(Long.valueOf(listTest.getValue(listTest.getSelectedIndex())));
			}
		});
		
		listTest.addItem("nada seleccionado");
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 26, 1180);
		btnGuardar.setSize("227px", "34px");
		
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormulario_SinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 283, 1180);
		btnEliminar.setSize("227px", "34px");
		
		btnCompartir = new Button("Send");
		btnCompartir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(!bandera){
					MensajeCompartir(id_prueba,empleado);
				}else{
                	setMensaje("alert alert-error", 
                			" \nAun no se ha guardo el formulario");
				}
			}
		});
		btnCompartir.setText("Compartir");
		btnCompartir.setStylePrimaryName("sendButton");
		btnCompartir.setStyleName("sendButton");
		absolutePanel.add(btnCompartir, 547, 1180);
		btnCompartir.setSize("213px", "34px");
		
		Label lblNivelAcademico = new Label("Evaluación de Período de Prueba realizada en Oficina Nacional");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 115, 10);
		lblNivelAcademico.setSize("456px", "13px");
		
		Label lblInstruccionesParaRealizar = new Label("Instrucciones para realizar objetiva y eficientemente la evaluación de Período de Prueba de los nuevos colaboradores de Fundación Hábitat para la Humanidad Guatemala.");
		lblInstruccionesParaRealizar.setStyleName("label");
		absolutePanel.add(lblInstruccionesParaRealizar, 37, 42);
		lblInstruccionesParaRealizar.setSize("667px", "13px");
		
		Label lblObjetivoevaluarElDesempeo = new Label("Objetivo: Evaluar el desempeño del nuevo colaborador durante los primeros tres meses de labores dentro de la Fundación, y emitir un juicio objetivo para poder confirmarlo o no en el puesto de trabajo para el que ha sido contratado.  Es imprescindible hacer notar que esta herramienta nos permitirá como organización, contar con el personal mejor calificado, obtener resultados positivos y brindar un mejor servicio a nuestros clientes internos y externos a través de la satisfacción de sus demandas.");
		lblObjetivoevaluarElDesempeo.setStyleName("label");
		absolutePanel.add(lblObjetivoevaluarElDesempeo, 37, 76);
		lblObjetivoevaluarElDesempeo.setSize("676px", "13px");
		
		Label lblProcedimientoParaLa = new Label("Procedimiento para la aplicación de la herramienta:");
		lblProcedimientoParaLa.setStyleName("label");
		absolutePanel.add(lblProcedimientoParaLa, 37, 178);
		lblProcedimientoParaLa.setSize("676px", "13px");
		
		Label lblPosteriorA = new Label("1. \tPosterior a los 2 meses y medio de trabajo, el personal de Oficina Nacional (Directores, Coordinadores) realizará una única evaluación de período de prueba a los nuevos colaboradores de la Fundación, con los que haya tenido contacto.\t\t\t\t\t\n\t\t\t\t\t\t\n2.\tLos aspectos a evaluar son 10, siendo estos los más generales, pero al mismo tiempo importantes para emitir un juicio justo.\t\t\t\t\t\n\t\t\t\t\t\t\n3\tEl puntaje irá de 1 a 10 en cada uno de los aspectos, lo que dará un total de 100 puntos.\t\t\t\t\t\n\t\t\t\t\t\t\n4\tPara que el colaborador sea confirmado en el puesto de trabajo, deberá aprobar la evluación con un mínimo de 71 puntos.\t\t\t\t\t\n\t\t\t\t\t\t\n5\tEl evaluador deberá entregar la herramienta a la Coordinación de Recursos Humanos, cuando le sea solicitada. \t\t\t\t\t\n\t\t\t\t\t\t\n6\tLa Coordinación de Recursos Humanos procederá adjuntar la evaluación hecha por Oficina Nacional, a la hecha por el jefe inmediato superior para promediar su puntaje y determinar las acciones a tomar en base a los resultados.\t\t\t\t\t\n\t\t\t\t\t\t\n7\tLa evaluación deberá basarse en datos objetivos y no desde un punto de vista personal\t\t\t\t\t\n\t\t\t\t\t\t\n8\tNo puede deajarse ninguno de los aspectos sin calificación, ya que esto perjudicará el puntaje final del trabajador.\t\t\t\t\t\n\t\t\t\t\t\t\n9\tSe recomienda contar con toda la información necesaria previo a aplicar la herramienta, con el propósito que el resultado sea lo más objetivo posible.\t\t\t\t\t\n\t\t\t\t\t\t\n10\tLa Coordinación de Recursos Humanos apoyará directamente a los colaboradores que deban aplicar la herramienta, para poder cumplir con el objetivo para el que fue creada.\t\t\t\t\t\n\t\t\t\t\t\t");
		lblPosteriorA.setStyleName("label");
		absolutePanel.add(lblPosteriorA, 37, 212);
		lblPosteriorA.setSize("667px", "13px");
		
		Label lblPunteoTotal = new Label("Punteo Total");
		lblPunteoTotal.setStyleName("label");
		absolutePanel.add(lblPunteoTotal, 562, 996);
		lblPunteoTotal.setSize("132px", "13px");
		
		Label lblEvaluador = new Label("Evaluador");
		lblEvaluador.setStyleName("label");
		absolutePanel.add(lblEvaluador, 26, 996);
		lblEvaluador.setSize("75px", "13px");
		
		Label lblFecha = new Label("Fecha");
		lblFecha.setStyleName("label");
		absolutePanel.add(lblFecha, 283, 996);
		lblFecha.setSize("75px", "13px");
		lblElijaLaEvaluacion = new Label("Elija la evaluacion que se asignara a este formulario permanentemente:");
		lblElijaLaEvaluacion.setStyleName("label");
		absolutePanel.add(lblElijaLaEvaluacion, 26, 1061);
		lblElijaLaEvaluacion.setSize("227px", "18px");
		
		lblPregunta1 = new Label("pregunta ");
		lblPregunta1.setStyleName("label");
		absolutePanel.add(lblPregunta1, 48, 524);
		lblPregunta1.setSize("482px", "34px");
		
		lblPregunta2 = new Label("pregunta");
		lblPregunta2.setStyleName("label");
		absolutePanel.add(lblPregunta2, 48, 564);
		lblPregunta2.setSize("482px", "34px");
		
		lblPregunta3 = new Label("pregunta");
		lblPregunta3.setStyleName("label");
		absolutePanel.add(lblPregunta3, 48, 599);
		lblPregunta3.setSize("482px", "34px");
		
		lblPregunta4 = new Label("pregunta");
		lblPregunta4.setStyleName("label");
		absolutePanel.add(lblPregunta4, 49, 644);
		lblPregunta4.setSize("482px", "34px");
		
		lblPregunta5 = new Label("pregunta");
		lblPregunta5.setStyleName("label");
		absolutePanel.add(lblPregunta5, 49, 684);
		lblPregunta5.setSize("482px", "34px");
		
		lblPregunta6 = new Label("pregunta");
		lblPregunta6.setStyleName("label");
		absolutePanel.add(lblPregunta6, 49, 724);
		lblPregunta6.setSize("482px", "34px");
		
		lblPregunta7 = new Label("pregunta");
		lblPregunta7.setStyleName("label");
		absolutePanel.add(lblPregunta7, 50, 764);
		lblPregunta7.setSize("482px", "34px");
		
		lblPregunta8 = new Label("pregunta");
		lblPregunta8.setStyleName("label");
		absolutePanel.add(lblPregunta8, 50, 804);
		lblPregunta8.setSize("482px", "34px");
		
		lblPregunta9 = new Label("pregunta");
		lblPregunta9.setStyleName("label");
		absolutePanel.add(lblPregunta9, 47, 840);
		lblPregunta9.setSize("482px", "34px");
		
		lblPregunta10 = new Label("pregunta");
		lblPregunta10.setStyleName("label");
		absolutePanel.add(lblPregunta10, 47, 879);
		lblPregunta10.setSize("482px", "34px");
		
		for (AuxBDTest p : this.d.BDresult) {
	    	listTest.addItem(""+p.getNombreTest(),""+p.getId_test());
	    }
		botonesVisibles(true);
	}
	private void EliminarFormulario_SinDatos(){
		d.EliminarFormulario(this);
	}
	
	private void EliminarFormulario(){
        d.EliminarFormulario(this,empleado,id_prueba);
	}
	
	public  void LlenarDatos(Long id, String listPregunta1,
			String listPregunta2, String listPregunta3,
			String listPregunta4, String listPregunta5,
			String listPregunta6, String listPregunta7,
			String listPregunta8, String listPregunta9,
			String listPregunta10, String txtEvaluador,Long id_BDpuestos, Long dateFecha) {
		this.id_prueba = id;
		this.bandera = false;
		this.id_BDprueba = id_BDpuestos;
		boolean bandera = true;
		this.listTest.setVisible(false);
		this.lblElijaLaEvaluacion.setVisible(false);
		BuscarBDtest(id_BDpuestos);
		
		for(int i=0; i < this.listTest.getItemCount() && bandera; i++){
			bandera = !this.listTest.getValue(i).equals(""+id_BDpuestos);
			this.listTest.setSelectedIndex(i);
		}

		Window.alert(""+listTest.getSelectedIndex());
		for(int i=0; i < this.listPregunta1.getItemCount() && bandera; i++){
			bandera = !this.listPregunta1.getItemText(i).equals(listPregunta1);
			this.listPregunta1.setSelectedIndex(i);
		}
		
		for(int i=0; i < this.listPregunta1.getItemCount() && bandera; i++){
			bandera = !this.listPregunta1.getItemText(i).equals(listPregunta1);
			this.listPregunta1.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta2.getItemCount() && bandera; i++){
			bandera = !this.listPregunta2.getItemText(i).equals(listPregunta2);
			this.listPregunta2.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta3.getItemCount() && bandera; i++){
			bandera = !this.listPregunta3.getItemText(i).equals(listPregunta3);
			this.listPregunta3.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta4.getItemCount() && bandera; i++){
			bandera = !this.listPregunta4.getItemText(i).equals(listPregunta4);
			this.listPregunta4.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta5.getItemCount() && bandera; i++){
			bandera = !this.listPregunta5.getItemText(i).equals(listPregunta5);
			this.listPregunta5.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta6.getItemCount() && bandera; i++){
			bandera = !this.listPregunta6.getItemText(i).equals(listPregunta6);
			this.listPregunta6.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta7.getItemCount() && bandera; i++){
			bandera = !this.listPregunta7.getItemText(i).equals(listPregunta7);
			this.listPregunta7.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta8.getItemCount() && bandera; i++){
			bandera = !this.listPregunta8.getItemText(i).equals(listPregunta8);
			this.listPregunta8.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta9.getItemCount() && bandera; i++){
			bandera = !this.listPregunta9.getItemText(i).equals(listPregunta9);
			this.listPregunta9.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPregunta10.getItemCount() && bandera; i++){
			bandera = !this.listPregunta10.getItemText(i).equals(listPregunta10);
			this.listPregunta10.setSelectedIndex(i);
		}
		this.txtEvaluador.setText(txtEvaluador);
		this.dateFecha.setValue(new Date(dateFecha));
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
	
	public void botonesVisibles(boolean valor)
	{
		btnCompartir.setVisible(valor);
		btnEliminar.setVisible(valor);
		
		btnCompartir.setEnabled(valor);
		btnEliminar.setEnabled(valor);
	}
	
	public void BuscarBDtest(long lg)
	{
		this.id_BDprueba = lg;
		for (AuxBDTest p : d.BDresult ) 
		{
			if(lg == p.getId_test())
			{
				lblPregunta1.setText(p.getPregunta1());
				lblPregunta2.setText(p.getPregunt2());
				lblPregunta3.setText(p.getPregunta3());
				lblPregunta4.setText(p.getPregunta4());
				lblPregunta5.setText(p.getPregunta5());
				lblPregunta6.setText(p.getPregunta6());
				lblPregunta7.setText(p.getPregunta7());
				lblPregunta8.setText(p.getPregunta8());
				lblPregunta9.setText(p.getPregunta9());
				lblPregunta10.setText(p.getPregunta10());
				break;
			}
	    }
			
	}
	public void MensajeCompartir(Long idtest,Long idEmpleadoCompartido){
        final DialogBox Registro2 = new DialogBox();
        final HTML serverResponseLabel = new HTML();
        final Button close= new Button("x");
        Compartir inicio = new Compartir(idtest, idEmpleadoCompartido);
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
