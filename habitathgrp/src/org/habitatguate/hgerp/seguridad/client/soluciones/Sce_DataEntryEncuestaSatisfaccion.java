package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudEncuestaSatisfaccion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudSupervisionPrimera;
import org.habitatguate.hgerp.seguridad.client.principal.Mensaje;
import org.habitatguate.hgerp.seguridad.client.rrhh.FormularioFamilia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;


public class Sce_DataEntryEncuestaSatisfaccion extends Composite {

	private Sce_DataEntryEncuestaSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
    private FlexTable flextable;

    private Sce_DataEncuestaSatisfaccion data;
	 
    // Valor Escritura-Lectura
    private boolean valor;
    
	public Sce_DataEntryEncuestaSatisfaccion(Sce_DataEntryEncuestaSolicitud formulario, boolean valor) {
				
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
	
		data = new Sce_DataEncuestaSatisfaccion(this, this.formularioSolicitud, this.valor);
        flextable.setWidget(flextable.getRowCount(), 0, data);

	}
	
    
    public void setDataEncuestaSatisfaccion(List<AuxSolicitudEncuestaSatisfaccion> results){

    	if (!results.isEmpty()) {

    		for ( AuxSolicitudEncuestaSatisfaccion n2 : results) {

    			System.out.println("ID Encuesta Satisfaccion a Cargar: " + n2.getIdEncuestaSatisfaccion() + ", ID Formulario: " + n2.getIdFormulario());
    			
    			data.LlenarDatos(n2.getIdEncuestaSatisfaccion(), 
    					n2.getPreguntaNo1(), n2.getPreguntaNo2(), n2.getPreguntaNo3(), n2.getPreguntaNo4(),
    					n2.getPreguntaNo5(), n2.getPreguntaNo6(), n2.getPreguntaNo7(), n2.getPreguntaNo8(),
    					n2.getPreguntaNo9(), n2.getPreguntaNo10(), n2.getPreguntaNo11(), n2.getPreguntaNo12(),
    					n2.getPreguntaNo13(), n2.getPreguntaNo14(), n2.getPreguntaNo15(), n2.getPreguntaNo16(),
    					n2.getDepartamento());    		
    		
    		}
    	}
    
    }
    
    
}
