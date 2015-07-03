package org.habitatguate.hgerp.seguridad.client.soluciones;

import java.util.List;

import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasService;
import org.habitatguate.hgerp.seguridad.client.api.SolucionesConstruidasServiceAsync;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxFamilia;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudDatosVivienda;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGarantiaHipotecaria;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudGeneral;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxSolicitudReferenciaFamiliar;
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


public class Sce_DataEntryGarantiaHipotecaria extends Composite {

	private Sce_DataEntryGarantiaSolicitud formularioSolicitud;
    private VerticalPanel panel = new VerticalPanel();
    
	 private FlexTable flextable;
    
	 private Sce_DataGarantiaHipotecaria data;
	 
	 // Valor Escritura-Lectura
	 private boolean valor;
	 
	public Sce_DataEntryGarantiaHipotecaria(Sce_DataEntryGarantiaSolicitud formulario, boolean valor) {
				
		this.valor = valor;					// Variable de valor de Lectura/Escritura
		
		this.formularioSolicitud = formulario;
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        initWidget(panel);
        panel.setSize("761px", "79px");
        flextable = new FlexTable();
        panel.add(flextable);
	
		data = new Sce_DataGarantiaHipotecaria(this, this.formularioSolicitud, this.valor);
        flextable.setWidget(flextable.getRowCount(), 0, data);

	}
	
    
	public void setDataGarantiaHipotecaria(List<AuxSolicitudGarantiaHipotecaria> results){

		if (!results.isEmpty()) {

			for ( AuxSolicitudGarantiaHipotecaria n2 : results) {

				System.out.println("ID Garantia Hipotecaria a Cargar: " + n2.getIdGarantiaHipotecaria() + ", ID Formulario: " + n2.getIdFormulario());

				String deptoDireccionPersona  = "";
				String municipioDireccionPersona   = "";			 

				String[] numerosComoArray2  = n2.getDepartamentoMunicipioDireccionPersona().split(",");
				for (int i = 0; i < numerosComoArray2.length; i++) {
					if(i == 0)
						deptoDireccionPersona = numerosComoArray2[i];
					if(i == 1)
						municipioDireccionPersona = numerosComoArray2[i];
				}	
				
				String deptoDireccionGarantia  = "";
				String municipioDireccionGarantia  = "";			 

				String[] numerosComoArray3  = n2.getDepartamentoMunicipioDireccionGarantia().split(",");
				for (int i = 0; i < numerosComoArray3.length; i++) {
					if(i == 0)
						deptoDireccionGarantia = numerosComoArray3[i];
					if(i == 1)
						municipioDireccionGarantia = numerosComoArray3[i];
				}


				data.LlenarDatos(n2.getIdGarantiaHipotecaria(), 
						n2.getEscrituraNoRegistrada(), n2.getEscrituraRegistrada(), n2.getFolioEscritura(), n2.getLibroEscritura(), n2.getFincaEscritura(),
						n2.getNombreNotario(), n2.getAreaTerreno(), n2.getValorEstimado(), 
						n2.getCheckSi(), n2.getCheckNo(),
						n2.getNombrePersona(), n2.getTelefonoPersona(),
						n2.getNumDpiPersona(), 
						n2.getDireccionTerrenoPersona(), n2.getAldeaPersona(),
						deptoDireccionPersona, municipioDireccionPersona,
						n2.getDireccionTerrenoGarantia(), n2.getAldeaGarantia(),
						deptoDireccionGarantia, municipioDireccionGarantia);  

			}
		}

	}
    
    
}
