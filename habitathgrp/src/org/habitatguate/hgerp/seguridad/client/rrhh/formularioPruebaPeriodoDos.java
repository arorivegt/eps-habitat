package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDTest;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
public class formularioPruebaPeriodoDos extends Composite {

	 	private Long empleado;
		private Long id_prueba = 0L;
		private Long id_BDprueba = 0L;
		private boolean bandera = true;
	    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
		
	    private ListBox listPregunta1;
		private ListBox listPregunta2;
		private ListBox listPregunta3;
		private ListBox listPregunta4;
		private ListBox listPregunta5;
		private ListBox listPregunta6;
		private ListBox listPregunta7;
		private ListBox listPregunta8;
		private ListBox listPregunta9;
		private ListBox listPregunta10;
		private TextBox txtEvaluador;
		private DoubleBox txtPunteoTotal;
		private DateBox dateFecha ;
		private ListBox listTest;
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
		private Evaluacion evaluacion;
		private Label lblEvaluacionQueSe;
		private Button btnEliminar;
		private Button btnCompartir;
        private Loading load ;
   	 private Mensaje mensaje; 
		
	public formularioPruebaPeriodoDos(Evaluacion evaluacion, Long e) {

		this.empleado = e;
		mensaje = new Mensaje();
		this.evaluacion = evaluacion;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
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
		absolutePanel.add(listPregunta1, 548, 428);
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
		absolutePanel.add(listPregunta2, 548, 468);
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
		absolutePanel.add(listPregunta3, 548, 508);
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
		absolutePanel.add(listPregunta4, 548, 548);
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
		absolutePanel.add(listPregunta5, 548, 588);
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
		absolutePanel.add(listPregunta6, 548, 628);
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
		absolutePanel.add(listPregunta7, 548, 668);
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
		absolutePanel.add(listPregunta8, 548, 708);
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
		absolutePanel.add(listPregunta9, 548, 748);
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
		absolutePanel.add(listPregunta10, 548, 788);
		listPregunta10.setSize("198px", "34px");
		
		txtPunteoTotal = new DoubleBox();
		txtPunteoTotal.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtPunteoTotal, 546, 939);
		txtPunteoTotal.setSize("198px", "34px");
		
		txtEvaluador = new TextBox();
		txtEvaluador.setMaxLength(500);
		txtEvaluador.setStyleName("gwt-TextBox2");
		absolutePanel.add(txtEvaluador, 37, 939);
		txtEvaluador.setSize("198px", "34px");
		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date());
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 284, 939);
		dateFecha.setSize("198px", "34px");
		
		Button btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        load.visible();
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
							txtEvaluador.getText(),id_BDprueba, true,"2", new AsyncCallback<Long>(){
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
							id_prueba= result;
							bandera = false;
							mensaje.setMensaje("alert alert-success", 
                        			"Datos Guardados\n exitosamente!!!");
                        }

                 });
		}else{
			loginService.Actualizar_Test(empleado,id_prueba, Integer.parseInt(listPregunta1.getItemText(listPregunta1.getSelectedIndex())), 
					Integer.parseInt(listPregunta2.getItemText(listPregunta2.getSelectedIndex())), Integer.parseInt(listPregunta3.getItemText(listPregunta3.getSelectedIndex())), 
					Integer.parseInt(listPregunta4.getItemText(listPregunta4.getSelectedIndex())), Integer.parseInt(listPregunta5.getItemText(listPregunta5.getSelectedIndex())), 
					Integer.parseInt(listPregunta6.getItemText(listPregunta6.getSelectedIndex())), Integer.parseInt(listPregunta7.getItemText(listPregunta7.getSelectedIndex())), 
					Integer.parseInt(listPregunta8.getItemText(listPregunta8.getSelectedIndex())), Integer.parseInt(listPregunta9.getItemText(listPregunta9.getSelectedIndex())), 
					Integer.parseInt(listPregunta10.getItemText(listPregunta10.getSelectedIndex())), dateFecha.getValue(), 
					txtEvaluador.getText(),id_BDprueba,true, "2", new AsyncCallback<Long>(){
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
		}}else{

			mensaje.setMensaje("alert alert-error", 
        			"Error !! \nDebe seleccionar un test \nasociado a este formulario");
		}
		        load.invisible();
			}
		});
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		absolutePanel.add(btnGuardar, 39, 1114);
		btnGuardar.setSize("198px", "32px");
		
		Label lblNivelAcademico = new Label("Evaluación de Período de Prueba realizada en Oficina Nacional");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 115, 10);
		lblNivelAcademico.setSize("456px", "13px");
		
		Label lblInstruccionesParaRealizar = new Label("Instrucciones para realizar objetiva y eficientemente la evaluación de Período de Prueba de los nuevos colaboradores de Fundación Hábitat para la Humanidad Guatemala.");
		lblInstruccionesParaRealizar.setStyleName("label");
		absolutePanel.add(lblInstruccionesParaRealizar, 37, 29);
		lblInstruccionesParaRealizar.setSize("667px", "13px");
		
		Label lblObjetivoevaluarElDesempeo = new Label("Objetivo: Evaluar el desempeño del nuevo colaborador durante los primeros tres meses de labores dentro de la Fundación, y emitir un juicio objetivo para poder confirmarlo o no en el puesto de trabajo para el que ha sido contratado.");
		lblObjetivoevaluarElDesempeo.setStyleName("label");
		absolutePanel.add(lblObjetivoevaluarElDesempeo, 37, 67);
		lblObjetivoevaluarElDesempeo.setSize("676px", "13px");
		
		Label lblProcedimientoParaLa = new Label("Procedimiento para la aplicación de la herramienta:");
		lblProcedimientoParaLa.setStyleName("label");
		absolutePanel.add(lblProcedimientoParaLa, 37, 122);
		lblProcedimientoParaLa.setSize("676px", "13px");
		
		Label lblPosteriorA = new Label("1. \tPosterior a los 2 meses y medio de trabajo, el personal de Oficina Nacional (Directores, Coordinadores) realizará una única evaluación de período de prueba a los nuevos colaboradores de la Fundación, con los que haya tenido contacto.\t\t\t\t\t\n\t\t\t\t\t\t\n2.\tLos aspectos a evaluar son 10, siendo estos los más generales, pero al mismo tiempo importantes para emitir un juicio justo.\t\t\t\t\t\n\t\t\t\t\t\t\n3\tEl puntaje irá de 1 a 10 en cada uno de los aspectos, lo que dará un total de 100 puntos.\t\t\t\t\t\n\t\t\t\t\t\t\n4\tPara que el colaborador sea confirmado en el puesto de trabajo, deberá aprobar la evluación con un mínimo de 71 puntos.\t\t\t\t\t\n\t\t\t\t\t\t\n5\tEl evaluador deberá entregar la herramienta a la Coordinación de Recursos Humanos, cuando le sea solicitada. \t\t\t\t\t\n\t\t\t\t\t\t\n6\tLa Coordinación de Recursos Humanos procederá adjuntar la evaluación hecha por Oficina Nacional, a la hecha por el jefe inmediato superior para promediar su puntaje y determinar las acciones a tomar en base a los resultados.\t\t\t\t\t\n\t\t\t\t\t\t\n7\tLa evaluación deberá basarse en datos objetivos y no desde un punto de vista personal\t\t\t\t\t\n\t\t\t\t\t\t\n8\tNo puede deajarse ninguno de los aspectos sin calificación, ya que esto perjudicará el puntaje final del trabajador.\t\t\t\t\t\n\t\t\t\t\t\t\n9\tSe recomienda contar con toda la información necesaria previo a aplicar la herramienta, con el propósito que el resultado sea lo más objetivo posible.\t\t\t\t\t\n\t\t\t\t\t\t\n10\tLa Coordinación de Recursos Humanos apoyará directamente a los colaboradores que deban aplicar la herramienta, para poder cumplir con el objetivo para el que fue creada.\t\t\t\t\t\n\t\t\t\t\t\t");
		lblPosteriorA.setStyleName("label");
		absolutePanel.add(lblPosteriorA, 37, 141);
		lblPosteriorA.setSize("667px", "13px");

		lblPregunta1 = new Label("pregunta ");
		lblPregunta1.setStyleName("label");
		absolutePanel.add(lblPregunta1, 40, 428);
		lblPregunta1.setSize("482px", "34px");
		
		lblPregunta2 = new Label("pregunta");
		lblPregunta2.setStyleName("label");
		absolutePanel.add(lblPregunta2, 40, 468);
		lblPregunta2.setSize("482px", "34px");
		
		lblPregunta3 = new Label("pregunta");
		lblPregunta3.setStyleName("label");
		absolutePanel.add(lblPregunta3, 40, 503);
		lblPregunta3.setSize("482px", "34px");
		
		lblPregunta4 = new Label("pregunta");
		lblPregunta4.setStyleName("label");
		absolutePanel.add(lblPregunta4, 41, 548);
		lblPregunta4.setSize("482px", "34px");
		
		lblPregunta5 = new Label("pregunta");
		lblPregunta5.setStyleName("label");
		absolutePanel.add(lblPregunta5, 41, 588);
		lblPregunta5.setSize("482px", "34px");
		
		lblPregunta6 = new Label("pregunta");
		lblPregunta6.setStyleName("label");
		absolutePanel.add(lblPregunta6, 41, 628);
		lblPregunta6.setSize("482px", "34px");
		
		lblPregunta7 = new Label("pregunta");
		lblPregunta7.setStyleName("label");
		absolutePanel.add(lblPregunta7, 42, 668);
		lblPregunta7.setSize("482px", "34px");
		
		lblPregunta8 = new Label("pregunta");
		lblPregunta8.setStyleName("label");
		absolutePanel.add(lblPregunta8, 42, 708);
		lblPregunta8.setSize("482px", "34px");
		
		lblPregunta9 = new Label("pregunta");
		lblPregunta9.setStyleName("label");
		absolutePanel.add(lblPregunta9, 39, 744);
		lblPregunta9.setSize("482px", "34px");
		
		lblPregunta10 = new Label("pregunta");
		lblPregunta10.setStyleName("label");
		absolutePanel.add(lblPregunta10, 39, 783);
		lblPregunta10.setSize("482px", "34px");
		Label lblPunteoTotal = new Label("Punteo Total");
		lblPunteoTotal.setStyleName("label");
		absolutePanel.add(lblPunteoTotal, 585, 918);
		lblPunteoTotal.setSize("143px", "13px");
		
		Label lblEvaluador = new Label("Evaluador");
		lblEvaluador.setStyleName("label");
		absolutePanel.add(lblEvaluador, 62, 904);
		lblEvaluador.setSize("75px", "13px");
		
		Label lblFecha = new Label("Fecha");
		lblFecha.setStyleName("label");
		absolutePanel.add(lblFecha, 294, 904);
		lblFecha.setSize("75px", "13px");
		
		listTest = new ListBox();
		listTest.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				if(listTest.getSelectedIndex()!=0)
					BuscarBDtest(Long.valueOf(listTest.getValue(listTest.getSelectedIndex())));
			}
		});
		listTest.addItem("nada seleccionado");
		listTest.setStyleName("gwt-TextBox2");
		absolutePanel.add(listTest, 37, 1045);
		listTest.setSize("198px", "34px");
		
		lblEvaluacionQueSe = new Label("Elija la evaluacion que se asignara a este formulario permanentemente:");
		lblEvaluacionQueSe.setStyleName("label");
		absolutePanel.add(lblEvaluacionQueSe, 39, 993);
		lblEvaluacionQueSe.setSize("198px", "18px");
		
		btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormulario_SinDatos();
				}else{
			        load.invisible();
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 284, 1114);
		btnEliminar.setSize("200px", "34px");
		
		btnCompartir = new Button("Send");
		btnCompartir.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(!bandera){
					MensajeCompartir(id_prueba,empleado);
				}else{
			        load.invisible();
			        mensaje.setMensaje("alert alert-error", 
                			" \nAun no se ha guardo el formulario");
				}
			}
		});
		btnCompartir.setText("Compartir");
		btnCompartir.setStylePrimaryName("sendButton");
		btnCompartir.setStyleName("sendButton");
		absolutePanel.add(btnCompartir, 546, 1112);
		btnCompartir.setSize("200px", "34px");

		for (AuxBDTest p : this.evaluacion.BDresult) {
	    	listTest.addItem(""+p.getNombreTest(),""+p.getId_test());
	    }
		botonesVisibles(true);
	}
	
	private void EliminarFormulario_SinDatos(){
		evaluacion.EliminarFormulario(this);
	}
	
	private void EliminarFormulario(){
		evaluacion.EliminarFormulario(this,empleado,id_prueba);
	}
	
	public  void LlenarDatos(Long id, String listPregunta1,
			String listPregunta2, String listPregunta3,
			String listPregunta4, String listPregunta5,
			String listPregunta6, String listPregunta7,
			String listPregunta8, String listPregunta9,
			String listPregunta10, String txtEvaluador, Long id_BDPuestos, Long dateFecha) {

		Window.alert(""+id_BDPuestos);
		this.id_prueba = id;
		this.id_BDprueba =id_BDPuestos;
		this.listTest.setVisible(false);
		this.lblEvaluacionQueSe.setVisible(false);
		BuscarBDtest(id_BDPuestos);

		boolean bandera = true;
		for(int i=0; i < this.listTest.getItemCount() && bandera; i++){
			bandera = !this.listTest.getValue(i).equals(""+id_BDprueba);
			this.listTest.setSelectedIndex(i);
		}
		bandera = true;
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
    
    
    public void BuscarBDtest(long lg)
	{
		this.id_BDprueba = lg;
		for (AuxBDTest p : evaluacion.BDresult ) 
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
	public void botonesVisibles(boolean valor)
	{
		btnCompartir.setVisible(valor);
		btnEliminar.setVisible(valor);
		
		btnCompartir.setEnabled(valor);
		btnEliminar.setEnabled(valor);
	}
	
	  public void MensajeCompartir(Long idtest,Long idEmpleadoCompartido){
          final DialogBox Registro2 = new DialogBox();
          final HTML serverResponseLabel = new HTML();
          final Button close= new Button("x");
          Compartir inicio = new Compartir(idtest,idEmpleadoCompartido);
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

