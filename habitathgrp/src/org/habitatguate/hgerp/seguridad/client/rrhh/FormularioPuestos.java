/**
 * Anibal Jose Rodriguez Orive
 * Ingenieria Ciencias y Sistemas
 * Universidad de San Carlos de Guatemala
 * Modulo Recursos Humanos
 */
package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;




/**
 * 
 */
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.datepicker.client.DateBox;

public class FormularioPuestos extends Composite {

	private Puestos puesto;
	private Empleado empleado;
	private Long id_puesto = 0L;
	private boolean bandera = true;
	private AbsolutePanel absolutePanel;
    
    private DateBox dateFecha;
    private ListBox listActivo;
	private ListBox listPuesto ;
	private ListBox listJornada ;
	private ListBox listHorasTrabajadas;
	private Button btnGuardar;
	private Button btnEliminar;
	private TextArea txtFunciones;
	private TextArea txtMotivoPuesto;
	private Mensaje mensaje; 
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    private Label lblHorasATrabajar;
    private Label lblJornada;
    private Label lblDiasDeDescando;
    private Label lblViernes;
    private Label lblSabado;
    private Label lblDomingo;
    private Loading load ;
    private ListBox listLunes;
    private ListBox listMartes;
    private ListBox listMiercoles;
    private ListBox listJueves;
    private ListBox listViernes;
    private ListBox listSabado;
    private ListBox listDomingo;
	
    /**
     * 
     * @param puest
     * @param emplead
     */
	public FormularioPuestos(Puestos puest,Empleado emplead) {

		mensaje = new Mensaje();
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.empleado = emplead;
		this.puesto = puest;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		absolutePanel.setSize("950px", "210px");
		initWidget(absolutePanel);

		listPuesto = new ListBox();
		listPuesto.addItem("nada seleccionado");
		listPuesto.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) 
			{
				long lg;
				for (AuxBDPuesto p : puesto.BDpuestos) 
				{
					lg  = Long.valueOf(listPuesto.getValue(listPuesto.getSelectedIndex()));
					if(lg == p.getId_puesto())
					{
						txtFunciones.setText(p.getFunciones());
						break;
					}
			    }
					
			}
		});
		listPuesto.setStyleName("gwt-TextBox2");
		listPuesto.setSize("132px", "34px");
		absolutePanel.add(listPuesto, 10, 29);
		
		dateFecha = new DateBox();
		dateFecha.getTextBox().setReadOnly(true);
		dateFecha.setValue(new Date());
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		dateFecha.setSize("91px", "34px");
		absolutePanel.add(dateFecha, 166, 27);
		
		
		listJornada = new ListBox();
		listJornada.addItem("Diurna","0");
		listJornada.addItem("Nocturna","1");
		listJornada.addItem("Mixta","2");
		listJornada.setStyleName("gwt-TextBox2");
		listJornada.setSize("132px", "34px");
		absolutePanel.add(listJornada, 10, 91);
		

		listHorasTrabajadas = new ListBox();
		listHorasTrabajadas.addItem("0");
		listHorasTrabajadas.addItem("1");
		listHorasTrabajadas.addItem("2");
		listHorasTrabajadas.addItem("3");
		listHorasTrabajadas.addItem("4");
		listHorasTrabajadas.addItem("5");
		listHorasTrabajadas.addItem("6");
		listHorasTrabajadas.addItem("7");
		listHorasTrabajadas.addItem("8");
		listHorasTrabajadas.addItem("9");
		listHorasTrabajadas.addItem("10");
		listHorasTrabajadas.addItem("11");
		listHorasTrabajadas.addItem("12");
		listHorasTrabajadas.addItem("13");
		listHorasTrabajadas.addItem("14");
		listHorasTrabajadas.addItem("15");
		listHorasTrabajadas.addItem("16");
		listHorasTrabajadas.addItem("17");
		listHorasTrabajadas.addItem("18");
		listHorasTrabajadas.addItem("19");
		listHorasTrabajadas.addItem("20");
		listHorasTrabajadas.addItem("21");
		listHorasTrabajadas.addItem("22");
		listHorasTrabajadas.addItem("23");
		listHorasTrabajadas.addItem("24");
		listHorasTrabajadas.setStyleName("gwt-TextBox2");
		listHorasTrabajadas.setSize("93px", "34px");
		absolutePanel.add(listHorasTrabajadas, 166, 91);
		
		txtFunciones = new TextArea();
		txtFunciones.setReadOnly(true);
		txtFunciones.getElement().setAttribute("maxlength", "500");
		txtFunciones.setStyleName("gwt-TextBox2");
		txtFunciones.setSize("218px", "92px");
		absolutePanel.add(txtFunciones, 286, 29);
		
		txtMotivoPuesto = new TextArea();
		txtMotivoPuesto.setText("");
		txtMotivoPuesto.setStyleName("gwt-TextBox2");
		txtMotivoPuesto.setSize("227px", "92px");
		absolutePanel.add(txtMotivoPuesto, 539, 29);
		
		btnGuardar = new Button("Send");
		btnGuardar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        load.visible();
				try{
					new Date(dateFecha.getValue().getTime());
				}catch(Exception e){
					dateFecha.setValue(new Date(1407518124684L));
				}
			
				if(bandera) {		
					
					loginService.Insertar_Puesto(empleado.id_empleado, dateFecha.getValue(), listPuesto.getValue(listPuesto.getSelectedIndex()), 
							txtFunciones.getText(), txtMotivoPuesto.getText(), listActivo.getValue(listActivo.getSelectedIndex()).equals("1"),
							listJornada.getValue(listJornada.getSelectedIndex()),listHorasTrabajadas.getValue(listHorasTrabajadas.getSelectedIndex())
							,listLunes.getValue(listLunes.getSelectedIndex()),listMartes.getValue(listMartes.getSelectedIndex()),
							listMiercoles.getValue(listMiercoles.getSelectedIndex()),listJueves.getValue(listJueves.getSelectedIndex()),listViernes.getValue(listViernes.getSelectedIndex()),
							listSabado.getValue(listSabado.getSelectedIndex()),listDomingo.getValue(listDomingo.getSelectedIndex()), new AsyncCallback<Long>(){
				            public void onFailure(Throwable caught) 
				            {
						        load.invisible();
				            	mensaje.setMensaje("alert alert-error", "Error !! \nal Guardar Datos");
				            }
				
									@Override
				            public void onSuccess(Long result)
				            {
									id_puesto = result;
									bandera = false;
									mensaje.setMensaje("alert alert-success", "Datos Guardados\n exitosamente!!!");
									//se actualiza el Puesto a Activo, si en caso eligio activarlo
									if(listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si") && bandera == false)
									{
										loginService.Actualizar_Estado_Puesto(empleado.id_empleado, id_puesto,new AsyncCallback<String>(){
											public void onFailure(Throwable caught) 
								            {
										        load.invisible();
								            	//mensaje.setMensaje("alert alert-error", caught.getMessage());
								            }
											@Override
								            public void onSuccess(String result)
								            {
										        load.invisible();
												//mensaje.setMensaje("alert alert-success", result);
								            }
										});
									}
										
										
				            }
						});
				}else{
					loginService.Actualizar_Puesto(empleado.id_empleado,id_puesto, dateFecha.getValue(), listPuesto.getValue(listPuesto.getSelectedIndex()), 
						txtFunciones.getText(), txtMotivoPuesto.getText(), listActivo.getValue(listActivo.getSelectedIndex()).equals("1"),
						listJornada.getValue(listJornada.getSelectedIndex()),listHorasTrabajadas.getItemText(listHorasTrabajadas.getSelectedIndex())
						,listLunes.getValue(listLunes.getSelectedIndex()),listMartes.getValue(listMartes.getSelectedIndex()),
						listMiercoles.getValue(listMiercoles.getSelectedIndex()),listJueves.getValue(listJueves.getSelectedIndex()),listViernes.getValue(listViernes.getSelectedIndex()),
						listSabado.getValue(listSabado.getSelectedIndex()),listDomingo.getValue(listDomingo.getSelectedIndex()), new AsyncCallback<Long>(){
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
				}
		        load.invisible();
			}
		});
		
		btnGuardar.setText("Guardar");
		btnGuardar.setStylePrimaryName("sendButton");
		btnGuardar.setStyleName("sendButton");
		btnGuardar.setSize("118px", "34px");
		absolutePanel.add(btnGuardar, 788, 29);
		
		btnEliminar = new Button("Send");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		btnEliminar.setSize("118px", "34px");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormularioSinDatos();
				}else{
			        load.invisible();
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		absolutePanel.add(btnEliminar, 788, 91);
		
		listActivo = new ListBox();
		listActivo.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
		        load.visible();
				if(listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si") && bandera == false)
				{
					loginService.Actualizar_Estado_Puesto(empleado.id_empleado, id_puesto,new AsyncCallback<String>(){
						public void onFailure(Throwable caught) 
			            {
					        load.invisible();
			            	mensaje.setMensaje("alert alert-error", caught.getMessage());
			            }
						@Override
			            public void onSuccess(String result)
			            {
					        load.invisible();
							mensaje.setMensaje("alert alert-success", result);
			            }
					});
				}
		        load.invisible();
			}
		});
		listActivo.addItem("Si","1");
		listActivo.addItem("No","0");
		listActivo.setStyleName("gwt-TextBox2");
		listActivo.setSize("47px", "34px");
		absolutePanel.add(listActivo, 924, 67);
		
		listLunes = new ListBox();
		listLunes.addItem("No Trabajado","0");
		listLunes.addItem("Medio Dia","1");
		listLunes.addItem("Dia Completo","2");
		listLunes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listLunes, 10, 196);
		listLunes.setSize("118px", "34px");
		
		listMartes = new ListBox();
		listMartes.addItem("No Trabajado","0");
		listMartes.addItem("Medio Dia","1");
		listMartes.addItem("Dia Completo","2");
		listMartes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listMartes, 141, 196);
		listMartes.setSize("118px", "34px");
		
		listMiercoles = new ListBox();
		listMiercoles.addItem("No Trabajado","0");
		listMiercoles.addItem("Medio Dia","1");
		listMiercoles.addItem("Dia Completo","2");
		listMiercoles.setStyleName("gwt-TextBox2");
		absolutePanel.add(listMiercoles, 276, 196);
		listMiercoles.setSize("118px", "34px");
		
		listJueves = new ListBox();
		listJueves.addItem("No Trabajado","0");
		listJueves.addItem("Medio Dia","1");
		listJueves.addItem("Dia Completo","2");
		listJueves.setStyleName("gwt-TextBox2");
		absolutePanel.add(listJueves, 408, 196);
		listJueves.setSize("118px", "34px");
		
		listViernes = new ListBox();
		listViernes.addItem("No Trabajado","0");
		listViernes.addItem("Medio Dia","1");
		listViernes.addItem("Dia Completo","2");
		listViernes.setStyleName("gwt-TextBox2");
		absolutePanel.add(listViernes, 547, 196);
		listViernes.setSize("118px", "34px");
		
		listSabado = new ListBox();
		listSabado.addItem("No Trabajado","0");
		listSabado.addItem("Medio Dia","1");
		listSabado.addItem("Dia Completo","2");
		listSabado.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSabado, 685, 196);
		listSabado.setSize("118px", "34px");
		
		listDomingo = new ListBox();
		listDomingo.addItem("No Trabajado","0");
		listDomingo.addItem("Medio Dia","1");
		listDomingo.addItem("Dia Completo","2");
		listDomingo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listDomingo, 821, 196);
		listDomingo.setSize("118px", "34px");
		
		
		Label lblNivelAcademico = new Label("Puesto");
		lblNivelAcademico.setStyleName("label");
		lblNivelAcademico.setSize("192px", "13px");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		
		Label lblTitulodiploma = new Label("Fecha");
		lblTitulodiploma.setStyleName("label");
		lblTitulodiploma.setSize("81px", "13px");
		absolutePanel.add(lblTitulodiploma, 166, 8);
		
		Label lblMotivoPuesto = new Label("Motivo del Puesto:");
		lblMotivoPuesto.setStyleName("label");
		lblMotivoPuesto.setSize("192px", "13px");
		absolutePanel.add(lblMotivoPuesto, 539, 10);
		
		Label lblActivo = new Label("Activo");
		lblActivo.setStyleName("label");
		lblActivo.setSize("67px", "13px");
		absolutePanel.add(lblActivo, 924, 45);
		
		Label lblFunciones = new Label("Funciones");
		lblFunciones.setStyleName("label");
		lblFunciones.setSize("192px", "18px");
		absolutePanel.add(lblFunciones, 276, 5);
		
		lblHorasATrabajar = new Label("Horas");
		lblHorasATrabajar.setStyleName("label");
		absolutePanel.add(lblHorasATrabajar, 166, 72);
		lblHorasATrabajar.setSize("60px", "13px");
		
		lblJornada = new Label("Jornada");
		lblJornada.setStyleName("label");
		absolutePanel.add(lblJornada, 10, 72);
		lblJornada.setSize("60px", "13px");
		
		lblDiasDeDescando = new Label("Dias de descando en la semana:");
		lblDiasDeDescando.setStyleName("label");
		absolutePanel.add(lblDiasDeDescando, 10, 148);
		lblDiasDeDescando.setSize("484px", "18px");
		
		Label lblLunes = new Label("Lunes");
		lblLunes.setStyleName("label");
		absolutePanel.add(lblLunes, 10, 172);
		lblLunes.setSize("52px", "18px");
		
		Label lblMartes = new Label("Martes");
		lblMartes.setStyleName("label");
		absolutePanel.add(lblMartes, 141, 172);
		lblMartes.setSize("52px", "18px");
		
		Label lblMiercoles = new Label("Miercoles");
		lblMiercoles.setStyleName("label");
		absolutePanel.add(lblMiercoles, 276, 172);
		lblMiercoles.setSize("52px", "18px");
		
		Label lblJueves = new Label("Jueves");
		lblJueves.setStyleName("label");
		absolutePanel.add(lblJueves, 408, 172);
		lblJueves.setSize("52px", "18px");
		
		lblViernes = new Label("Viernes");
		lblViernes.setStyleName("label");
		absolutePanel.add(lblViernes, 547, 172);
		lblViernes.setSize("52px", "18px");
		
		lblSabado = new Label("Sabado");
		lblSabado.setStyleName("label");
		absolutePanel.add(lblSabado, 685, 172);
		lblSabado.setSize("52px", "18px");
		
		lblDomingo = new Label("Domingo");
		lblDomingo.setStyleName("label");
		absolutePanel.add(lblDomingo, 821, 172);
		lblDomingo.setSize("52px", "18px");

	    for (AuxBDPuesto p : this.puesto.BDpuestos) 
	    {
	    	listPuesto.addItem(p.getNombre_puesto(),""+p.getId_puesto());
	    }
		
		
	}
	/**
	 * elimina este formulario tanto en el forma visual, como en datastore
	 */
	private void EliminarFormulario(){
        puesto.EliminarFormulario(this,empleado.id_empleado,id_puesto);
    }
	/**
	 * elimina el formulario, no del datastore, ya que este no esta guardado en el
	 */
	private void EliminarFormularioSinDatos(){
        puesto.EliminarFormulario(this);
    }
	/**
	 * llena los datos, que vienen del datastore
	 * @param id
	 * @param dateFecha
	 * @param listActivo
	 * @param txtPuesto
	 * @param txtFunciones
	 * @param txtMotivoPuesto
	 * @param listJornada
	 * @param listhorasTrabajadas
	 * @param Lunes
	 * @param Martes
	 * @param Miercoles
	 * @param Jueves
	 * @param Viernres
	 * @param Sabado
	 * @param Domingo
	 */
	public void LlenarDatos(Long id, Long dateFecha,
		     String listActivo,
			 String txtPuesto,
			 String txtFunciones,
			 String txtMotivoPuesto,
			 String listJornada,
			 String listhorasTrabajadas,
			 String Lunes, String Martes, 
			 String Miercoles, String Jueves, 
			 String Viernes, String Sabado,
			 String Domingo)
	{
	    
		if(listActivo.equals("1"))
		{
			this.listActivo.setVisible(false);
			this.listActivo.setEnabled(false);
		}
		this.id_puesto = id;
		this.bandera = false;
		this.dateFecha.setValue(new Date(dateFecha));
		boolean bandera = true;
		for(int i=0; i < this.listActivo.getItemCount() && bandera; i++){
			bandera = !this.listActivo.getValue(i).equals(listActivo);
		    this.listActivo.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listPuesto.getItemCount() && bandera; i++){
			bandera = !this.listPuesto.getValue(i).equals(txtPuesto);
		    this.listPuesto.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listJornada.getItemCount() && bandera; i++){
			bandera = !this.listJornada.getValue(i).equals(listJornada);
		    this.listJornada.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listHorasTrabajadas.getItemCount() && bandera; i++){
			bandera = !this.listHorasTrabajadas.getItemText(i).equals(listhorasTrabajadas);
		    this.listHorasTrabajadas.setSelectedIndex(i);
		}

		bandera = true;
		for(int i=0; i < this.listLunes.getItemCount() && bandera; i++){
			bandera = !this.listLunes.getValue(i).equals(Lunes);
		    this.listLunes.setSelectedIndex(i);
		}

		bandera = true;
		for(int i=0; i < this.listMartes.getItemCount() && bandera; i++){
			bandera = !this.listMartes.getValue(i).equals(Martes);
		    this.listMartes.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listMiercoles.getItemCount() && bandera; i++){
			bandera = !this.listMiercoles.getValue(i).equals(Miercoles);
		    this.listMiercoles.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listJueves.getItemCount() && bandera; i++){
			bandera = !this.listJueves.getValue(i).equals(Jueves);
		    this.listJueves.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listViernes.getItemCount() && bandera; i++){
			bandera = !this.listViernes.getValue(i).equals(Viernes);
		    this.listViernes.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listSabado.getItemCount() && bandera; i++){
			bandera = !this.listSabado.getValue(i).equals(Sabado);
		    this.listSabado.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.listDomingo.getItemCount() && bandera; i++){
			bandera = !this.listDomingo.getValue(i).equals(Domingo);
		    this.listDomingo.setSelectedIndex(i);
		}
		this.txtFunciones.setText(txtFunciones);
		this.txtMotivoPuesto.setText(txtMotivoPuesto);
	}
	
	public void btnhinabilitar(boolean valor){
		btnGuardar.setEnabled(valor);
		btnGuardar.setVisible(valor);
		btnEliminar.setEnabled(valor);
		btnEliminar.setVisible(valor);
	}
}
