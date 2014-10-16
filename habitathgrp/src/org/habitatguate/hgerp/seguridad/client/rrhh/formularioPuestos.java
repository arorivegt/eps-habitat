package org.habitatguate.hgerp.seguridad.client.rrhh;

import java.util.Date;

import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBDPuesto;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;

public class formularioPuestos extends Composite {

	private puestos aa;
	private Empleados empleado;
	private Long id_puesto = 0L;
	private boolean bandera = true;
    private final RecursosHumanosServiceAsync loginService = GWT.create(RecursosHumanosService.class);
    
    private DateBox dateFecha;
    private ListBox listActivo;
	private TextArea txtFunciones;
	private TextBox txtSalario;
	private ListBox ListPuesto ;
	
	public formularioPuestos(puestos a,Empleados e) {

		this.empleado = e;
		this.aa = a;
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1024px", "170px");

		ListPuesto = new ListBox();
		ListPuesto.addItem("nada seleccionado");
		ListPuesto.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {

				long lg;
				for (AuxBDPuesto p : aa.BDpuestos) 
				{
					lg  = Long.valueOf(ListPuesto.getValue(ListPuesto.getSelectedIndex()));
					if(lg == p.getId_puesto())
					{
						txtFunciones.setText(p.getFunciones());
						break;
					}
			    }
					
			}
		});
		ListPuesto.setStyleName("gwt-TextBox2");
		absolutePanel.add(ListPuesto, 10, 29);
		ListPuesto.setSize("227px", "34px");
		
		dateFecha = new DateBox();
		dateFecha.setValue(new Date(1407519035556L));
		dateFecha.setFormat(new DateBox.DefaultFormat 
			    (DateTimeFormat.getFormat("dd/MM/yyyy")));
		dateFecha.getDatePicker().setYearArrowsVisible(true);
		dateFecha.getDatePicker().setYearAndMonthDropdownVisible(true);
		dateFecha.getDatePicker().setVisibleYearCount(100);
		dateFecha.setStyleName("gwt-TextBox2");
		absolutePanel.add(dateFecha, 259, 29);
		dateFecha.setSize("227px", "34px");
		
		txtSalario = new TextBox();
		txtSalario.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(txtSalario.getText().equals("")) {txtSalario.setText("0");}
				else if(txtSalario.getText().equals(null)) {txtSalario.setText("0");}
				else{
					try{
						Float.parseFloat(txtSalario.getText());
					}catch(Exception e){
                    	setMensaje("alert alert-error", "salario no valido");
						txtSalario.setText("0.0");
					}
				}
			}
		});
		txtSalario.setText("0.0");
		txtSalario.setStyleName("gwt-TextBox2");
		txtSalario.setMaxLength(100);
		absolutePanel.add(txtSalario, 514, 29);
		txtSalario.setSize("227px", "34px");
		
		listActivo = new ListBox();
		listActivo.addItem("Si");
		listActivo.addItem("No");
		listActivo.setStyleName("gwt-TextBox2");
		absolutePanel.add(listActivo, 761, 29);
		listActivo.setSize("227px", "34px");;
		
				Button btnGuardar = new Button("Send");
				btnGuardar.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						try{
							new Date(dateFecha.getValue().getTime());
						}catch(Exception e){
							dateFecha.setValue(new Date(1407518124684L));
						}
					
						if(bandera) {					
							loginService.Insertar_Puesto(empleado.id_empleado, dateFecha.getValue(), ListPuesto.getItemText(ListPuesto.getSelectedIndex()), 
									txtFunciones.getText(), Float.parseFloat(txtSalario.getText()), listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si")
									, new AsyncCallback<Long>(){
                        public void onFailure(Throwable caught) 
                        {
                        	setMensaje("alert alert-error", 
                        			"Error !! \nal Guardar Datos");
                        }

								@Override
                        public void onSuccess(Long result)
                        {
									id_puesto = result;
									bandera = false;
		                        	setMensaje("alert alert-success", 
		                        			"Datos Guardados\n exitosamente!!!");
                        }
								});
						}else{
							loginService.Actualizar_Puesto(empleado.id_empleado,id_puesto, dateFecha.getValue(), ListPuesto.getItemText(ListPuesto.getSelectedIndex()), 
								txtFunciones.getText(), Float.parseFloat(txtSalario.getText()), listActivo.getItemText(listActivo.getSelectedIndex()).equals("Si")
								, new AsyncCallback<Long>(){
                    public void onFailure(Throwable caught) 
                    {
                    	setMensaje("alert alert-error", 
                    			"Error !! \nal Actualizar Datos");
                    }

							@Override
                    public void onSuccess(Long result)
                    {
								bandera = false;
			                	setMensaje("alert alert-success", 
			                			"Datos Actualizados\n exitosamente!!!");
                    }
							});
						}
					}
				});
				btnGuardar.setText("Guardar");
				btnGuardar.setStylePrimaryName("sendButton");
				btnGuardar.setStyleName("sendButton");
				absolutePanel.add(btnGuardar, 514, 125);
				btnGuardar.setSize("227px", "34px");
		
		Button btnEliminar = new Button("Send");
		btnEliminar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if(bandera){
					EliminarFormularioSinDatos();
				}else{
					if(Window.confirm("Esta Seguro de Eliminar el formulario"))
						EliminarFormulario();
				}
			}
		});
		
		txtFunciones = new TextArea();
		txtFunciones.setReadOnly(true);
		txtFunciones.getElement().setAttribute("maxlength", "500");
		txtFunciones.setStyleName("gwt-TextBox");
		absolutePanel.add(txtFunciones, 10, 97);
		txtFunciones.setSize("428px", "62px");
		btnEliminar.setText("Eliminar");
		btnEliminar.setStylePrimaryName("sendButton");
		btnEliminar.setStyleName("sendButton");
		absolutePanel.add(btnEliminar, 761, 125);
		btnEliminar.setSize("227px", "34px");
		
		Label lblNivelAcademico = new Label("Puesto");
		lblNivelAcademico.setStyleName("label");
		absolutePanel.add(lblNivelAcademico, 10, 10);
		lblNivelAcademico.setSize("192px", "13px");
		
		Label lblTitulodiploma = new Label("Fecha");
		lblTitulodiploma.setStyleName("label");
		absolutePanel.add(lblTitulodiploma, 259, 10);
		lblTitulodiploma.setSize("192px", "13px");
		
		Label lblParentesco = new Label("Salario");
		lblParentesco.setStyleName("label");
		absolutePanel.add(lblParentesco, 514, 10);
		lblParentesco.setSize("192px", "13px");
		
		Label lblActivo = new Label("Activo");
		lblActivo.setStyleName("label");
		absolutePanel.add(lblActivo, 761, 10);
		lblActivo.setSize("192px", "13px");
		
		Label lblFunciones = new Label("Funciones");
		lblFunciones.setStyleName("label");
		absolutePanel.add(lblFunciones, 10, 78);
		lblFunciones.setSize("192px", "13px");

	    for (AuxBDPuesto p : this.aa.BDpuestos) {
	    	ListPuesto.addItem(p.getNombre_puesto(),""+p.getId_puesto());
	    }
		
		
	}
	private void EliminarFormulario(){
        aa.EliminarFormulario(this,empleado.id_empleado,id_puesto);
    }
	private void EliminarFormularioSinDatos(){
        aa.EliminarFormulario(this);
    }
	public void LlenarDatos(Long id, Long dateFecha,
		     String listActivo,
			 String txtPuesto,
			 String txtFunciones,
			 String txtSalario)
	{
		this.id_puesto = id;
		this.bandera = false;
		this.dateFecha.setValue(new Date(dateFecha));
		boolean bandera = true;
		for(int i=0; i < this.listActivo.getItemCount() && bandera; i++){
			bandera = !this.listActivo.getItemText(i).equals(listActivo);
		    this.listActivo.setSelectedIndex(i);
		}
		bandera = true;
		for(int i=0; i < this.ListPuesto.getItemCount() && bandera; i++){
			bandera = !this.ListPuesto.getItemText(i).equals(txtPuesto);
		    this.ListPuesto.setSelectedIndex(i);
		}
		this.txtFunciones.setText(txtFunciones);
		this.txtSalario.setText(txtSalario);
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
}
