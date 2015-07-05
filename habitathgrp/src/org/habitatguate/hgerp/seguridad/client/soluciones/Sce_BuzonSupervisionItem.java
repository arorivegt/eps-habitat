package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.AdministracionService;
import org.habitatguate.hgerp.seguridad.client.api.AdministracionServiceAsync;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosService;
import org.habitatguate.hgerp.seguridad.client.api.RecursosHumanosServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxUsuarioPermiso;
import org.habitatguate.hgerp.seguridad.client.principal.Loading;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.rrhh.BuscadorEmpleados;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.SimpleCheckBox;

public class Sce_BuzonSupervisionItem extends Composite {

	private Sce_BuzonSupervisionLista a;
	private Long id_Formulario = 0L;
	private Sce_BuzonSupervision BE;
    private Loading load ;
    private AbsolutePanel absolutePanel;
    private TextBox txtNombreSolicitante;
    private ListBox listSolucionConstruir;
    private Button btnVer;
    private Label lblPrimeraSupervision;
    private SimpleCheckBox checkPrimeraSupervision;
    private SimpleCheckBox checkSegundaSupervision;
    private SimpleCheckBox checkTerceraSupervision;
    private SimpleCheckBox checkCuartaSupervision;
    
	// Llaves
	private Long idRol = 0L;
	
	private Mensaje mensaje; 
    
	private final RecursosHumanosServiceAsync recursosHumanosService = GWT.create(RecursosHumanosService.class);
    private final AdministracionServiceAsync AdministracionService = GWT.create(AdministracionService.class);
    
	// Valor Escritura-Lectura
	private boolean valor;
    
	public Sce_BuzonSupervisionItem(Sce_BuzonSupervision b, Sce_BuzonSupervisionLista a, 
			Long idFormulario, String nombreSolicitante, String solucionConstruir,
			Boolean primeraSupervision, Boolean segundaSupervision, Boolean terceraSupervision, Boolean cuartaSupervision, boolean valor) {
		
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		// Obtener Id Rol
		recursosHumanosService.obtenerIdRol(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				idRol = result;
				System.out.println("Id Rol: " + idRol);
			}
			@Override
			public void onFailure(Throwable caught) {
				mensaje.setMensaje("alert alert-error", "Error devolviendo ID de Usuario");
			}
		});
		
		this.id_Formulario = idFormulario;
		this.BE = b;
    	load = new Loading();
        load.Mostrar();
        load.invisible();
		this.setA(a);
		absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Label-new");
		initWidget(absolutePanel);
		absolutePanel.setSize("1500px", "20px");
		
		Label lblNombreSolicitante = new Label("Nombre Solicitante");
		lblNombreSolicitante.setStyleName("label");
		absolutePanel.add(lblNombreSolicitante, 10, 0);
		lblNombreSolicitante.setSize("192px", "13px");
		
		Label lblTipoVivienda = new Label("Tipo Solucion");
		lblTipoVivienda.setStyleName("label");
		absolutePanel.add(lblTipoVivienda, 350, 0);
		lblTipoVivienda.setSize("150px", "13px");
		
		lblPrimeraSupervision = new Label("Primera Supervision");
		lblPrimeraSupervision.setStyleName("label");
		absolutePanel.add(lblPrimeraSupervision, 509, 0);
		lblPrimeraSupervision.setSize("153px", "13px");
		
		Label lblSegundaSupervision = new Label("Segunda Supervision");
		lblSegundaSupervision.setStyleName("label");
		absolutePanel.add(lblSegundaSupervision, 687, 0);
		lblSegundaSupervision.setSize("153px", "13px");
		
		Label lblTerceraSupervision = new Label("Tercera Supervision");
		lblTerceraSupervision.setStyleName("label");
		absolutePanel.add(lblTerceraSupervision, 875, 0);
		lblTerceraSupervision.setSize("153px", "13px");
		
		Label lblCuartaSupervision = new Label("Cuarta Supervision");
		lblCuartaSupervision.setStyleName("label");
		absolutePanel.add(lblCuartaSupervision, 1060, 0);
		lblCuartaSupervision.setSize("153px", "13px");
		
		txtNombreSolicitante = new TextBox();
		txtNombreSolicitante.setEnabled(false);
		txtNombreSolicitante.setStyleName("gwt-TextBox2");
		txtNombreSolicitante.setMaxLength(100);
		absolutePanel.add(txtNombreSolicitante, 10, 20);
		txtNombreSolicitante.setSize("303px", "34px");
		txtNombreSolicitante.setText(nombreSolicitante);

		listSolucionConstruir = new ListBox();
		listSolucionConstruir.setEnabled(false);
		listSolucionConstruir.addItem("-","-1");
		listSolucionConstruir.addItem("Nueva","1");
		listSolucionConstruir.addItem("Mejoramiento","2");
		listSolucionConstruir.addItem("Adiciones Menores","3");
		listSolucionConstruir.setStyleName("gwt-TextBox2");
		absolutePanel.add(listSolucionConstruir, 350, 22);
		listSolucionConstruir.setSize("125px", "34px");;
		
        Boolean bandera = true;
	    for(int i=0; i < this.listSolucionConstruir.getItemCount() && bandera; i++){
	       bandera = !this.listSolucionConstruir.getValue(i).equals(solucionConstruir);
	       this.listSolucionConstruir.setSelectedIndex(i);
	    }
		
		checkPrimeraSupervision = new SimpleCheckBox();
		checkPrimeraSupervision.setEnabled(false);
		absolutePanel.add(checkPrimeraSupervision, 561, 20);
		checkPrimeraSupervision.setValue(primeraSupervision);
		
		checkSegundaSupervision = new SimpleCheckBox();
		checkSegundaSupervision.setEnabled(false);
		absolutePanel.add(checkSegundaSupervision, 745, 20);
		checkSegundaSupervision.setValue(segundaSupervision);
		
		checkTerceraSupervision = new SimpleCheckBox();
		checkTerceraSupervision.setEnabled(false);
		absolutePanel.add(checkTerceraSupervision, 936, 20);
		checkTerceraSupervision.setValue(terceraSupervision);
		
		checkCuartaSupervision = new SimpleCheckBox();
		checkCuartaSupervision.setEnabled(false);
		absolutePanel.add(checkCuartaSupervision, 1125, 20);
		checkCuartaSupervision.setValue(cuartaSupervision);
		
		// Boton - Ver Solicitud
		
		btnVer = new Button("Send");
		
		if(this.valor) {
			btnVer.setVisible(true);
		}else{
			btnVer.setVisible(false);
		}
		
		btnVer.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				AdministracionService.ObtenerUsuarioPermisoNombre("Primera-Supervision-Soluciones", idRol, new AsyncCallback<List<AuxUsuarioPermiso>>()
				{
					public void onFailure(Throwable caught) 
					{	
					}

					@Override
					public void onSuccess(List<AuxUsuarioPermiso> results)
					{
						if(results.get(0).getPermiso().equals("RW")){

							BE.cargarFormulario(id_Formulario, true);
							System.out.println("Primera Supervision - Lectura/Escritura");
							
						}else if(results.get(0).getPermiso().equals("R")){
							
							BE.cargarFormulario(id_Formulario, false);
							System.out.println("Primera Supervision - Solo Lectura");

						}
					}
				});
				
			}
		});
		btnVer.setText("Verificar Supervision");
		btnVer.setStylePrimaryName("sendButton");
		btnVer.setStyleName("sendButton");
		absolutePanel.add(btnVer, 1287, 20);
		btnVer.setSize("253px", "34px");
		
	}
	
	public Sce_BuzonSupervisionLista getA() {
		return a;
	}
	
	public void setA(Sce_BuzonSupervisionLista a) {
		this.a = a;
	}
}
