package org.habitatguate.hgerp.seguridad.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tools.ant.taskdefs.Concat;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxBeneficiario;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxContactoProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxCuentaBancariaProv;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxDetalleSolucion;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxProveedor;
import org.habitatguate.hgerp.seguridad.service.jdo.SegPersonalAfiliado;
import org.habitatguate.hgerp.seguridad.service.jdo.SegProveedor;

import com.gargoylesoftware.htmlunit.Page;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable; 

@WebServlet("/FinanInformacionProveedorPDF")
public class FinanInformacionProveedorPDF extends HttpServlet{
	private static final long serialVersionUID 	= 1L;
    private Font catFont 						= new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.NORMAL,BaseColor.BLACK);
    private Font catFont2 						= new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD,BaseColor.BLACK);
    private Font catFont3 						= new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL,BaseColor.BLACK);
    private Font catFont4 						= new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD,BaseColor.BLACK);
    
    private SegProveedor auxProv = new SegProveedor();
    private List<AuxContactoProv> auxContact = new ArrayList<AuxContactoProv>();
    private List<AuxCuentaBancariaProv> auxPago = new ArrayList<AuxCuentaBancariaProv>();
    private SqlServiceImpl finanzasService = new  SqlServiceImpl();
    private SegPersonalAfiliado auxPersonal		= new SegPersonalAfiliado();
	/**
	 * Metodo para crear el pdf del perfil de la persona en cuestion
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        response.setContentType("application/pdf");

		HttpSession session = request.getSession(false);
		
        if(session.getAttribute("usserHabitat") != null)
        {  
    		long idAfiliado 			= Long.parseLong(request.getParameter("idAfiliado"));
        	long idProveedor			= Long.valueOf(request.getParameter("idProveedor"));
        	String nomGerente 			= request.getParameter("nomGerente");
        	String puestoGerente 			= request.getParameter("puestoGerente");
        	String nomCompras 			= request.getParameter("nomCompras");
        	String nomDesarrollo 			= request.getParameter("nomDesarrollo");
        	String nomOpe 			= request.getParameter("nomOpe");
        	auxProv						= finanzasService.GetInfoProveedor(idProveedor,idAfiliado);
			auxContact					= finanzasService.Consultar_ContactosProv(auxProv.getIdProveedor().getId());
			auxPago 					= finanzasService.Consultar_FormasPago(auxProv.getIdProveedor().getId());
			auxPersonal					= finanzasService.GetPersonalAfiliado(idAfiliado);
	        OutputStream out 			= response.getOutputStream();
	       
		        try {
		            Document document 	= new Document(PageSize.LETTER,15,15,15,35);
		            final PdfWriter write = PdfWriter.getInstance(document, out);
		            write.setPageEvent(new PageStamper(auxProv.getNomProveedor()));
		            Image image1 		= null ;
		            
	            	image1 			= Image.getInstance("images/imagenempresa.png");
		            
		            document.open();
		            
		            image1.setAlignment(Element.ALIGN_LEFT);
		            image1.scaleAbsolute(120.0f, 50.0f);
		            document.add(image1);
		            
		            String proveedor = "";
		            
		            SimpleDateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
		            
	            
		            

		            
		            document.add(new Paragraph("FUNDACIÓN HABITAT PARA LA HUMANIDAD GUATEMALA",catFont4));
		            document.add(new Paragraph("FORMULARIO DE APROBACIÓN DE PROVEEDORES",catFont));
		            document.add(new Paragraph("Fecha: "+fechaFormat.format(new Date()) ,catFont));
		            document.add(new Paragraph("\t",catFont));

		            PdfPTable table = createTable1(auxProv,catFont2);
		            document.add(table);
		            table = createTable2(auxContact,catFont2);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable3(auxProv,catFont2);
		            document.add(table);
		            table = createTable4(auxPago,catFont2);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable5(auxProv,catFont2);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable6(auxProv,catFont2);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable7(auxProv,catFont2);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            document.add(new Paragraph("El presente convenio es por tiempo indefinido, existiendo el compromiso de ambas partes en el cumplimiento de los términos antes descritos; pudiéndose dar por terminado en cualquier momento por cualquiera de las partes o por mutuo consentimiento.",catFont3));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("\t",catFont));
		            table = createTable8(auxProv,nomGerente,puestoGerente);
		            document.add(table);
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("\t",catFont));
		            table = createTable9(auxProv,nomCompras,nomDesarrollo,nomOpe,auxPersonal.getNombreAdministrador());
		            document.add(table);
		            
		            
		            //Tabla del vale                       
	
	


			 	/*	document.add(new Paragraph("Nombre: "+auxProv.getNomProveedor()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Dirección "+auxProv.getDirProveedor()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Teléfono :"+auxProv.getTelProveedor()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Número de NIT: "+auxProv.getNumeroNit()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Página Web: "+auxProv.getPaginaWeb()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Persona Jurídica: "+auxProv.getPersonaJuridica()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Regimen Tributario: "+auxProv.getRegimenTributario()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Departamentos donde distribuye: "+auxProv.getDepartamentos()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Municipios donde distribuye: "+auxProv.getMunicipios()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Afiliado donde distribuye: "+auxProv.getAfiliado().getNomAfiliado()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Razón Social: "+auxProv.getRazonSocial()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Productos que ofrece: "+auxProv.getProductosfrece()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Tipo de Proveedor"+auxProv.getTipoProveedor()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Relación con el proveedor: "+auxProv.getRelacionConProv()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Ubicación de sus sucursales: "+auxProv.getUbicacionSucursales()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Disponibilidad de productos: "+auxProv.getDisponibilidadProd()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Acepta Exención: "+auxProv.getAceptaExencion()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Tiempo de trabajar con Habitat: "+auxProv.getTiempoDeTrabajarConHG()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Observaciones"+auxProv.getObservaciones()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Acepta otorgar Donación: "+auxProv.getAceptaDonacion()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Porcentaje Donación: "+auxProv.getPorcentDonacion()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Forma de donación: "+auxProv.getFormaDonacion()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Frecuencia de donación: "+auxProv.getFrecuenciaDonacion()));
		            
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Posee servicio de entrega: "+auxProv.getServicioEntrega()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Acepta crédito: "+auxProv.getAceptaCredito()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Monto Máximo: "+auxProv.getMontoMaximo()));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("Tiempo Máximo: "+auxProv.getTiempoMaximo()));*/
		            
		            
		            
		            
		            document.close();
		        }catch (DocumentException exc){
		        	throw new IOException(exc.getMessage());
		        }
		        finally {            
		            out.close();
		        }
		
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This Servlet Generates PDF Using iText Library";
    }
	
	
	public FinanInformacionProveedorPDF(){
		
	}
	
    /**
     * Creates a table; widths are set with setWidths().
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable1(SegProveedor aux, Font font) throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 2, 1,1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("1. DATOS GENERALES DE LA EMPRESA",font));
        cell.setColspan(4);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        cell = new PdfPCell(new Phrase("Nombre de la Empresa:"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getNomProveedor().equals("") ? "--------------" : aux.getNomProveedor());
        cell = new PdfPCell(new Phrase("Estado del proveedor"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getAprobadoComision() == true ? "Activo": "Inactivo");
        cell = new PdfPCell(new Phrase("Razón Social "));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getRazonSocial().equals("") ? "-------------------" : aux.getRazonSocial());
        cell = new PdfPCell(new Phrase("NIT"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getNumeroNit().equals("") ? "-------------------" : aux.getNumeroNit());
        cell = new PdfPCell(new Phrase("Dirección"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(aux.getDirProveedor().equals("") ? "-------------------" : aux.getDirProveedor()));
        cell.setColspan(3);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Pagina Web"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getPaginaWeb().equals("") ? "-------------------" : aux.getPaginaWeb());
        cell = new PdfPCell(new Phrase("Personeria Jurídica"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getPersonaJuridica().equals("") ? "-------------------" : aux.getPersonaJuridica());
        cell = new PdfPCell(new Phrase("Actividad Comercial o Categorización"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getActividadEcono().equals("") ? "-------------------" : aux.getActividadEcono());
        cell = new PdfPCell(new Phrase("Teléfono"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getTelProveedor().equals("") ? "-------------------" : aux.getTelProveedor());
        cell = new PdfPCell(new Phrase("Régimen Tributario"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getRegimenTributario().equals("") ? "-------------------" : aux.getRegimenTributario());
        cell = new PdfPCell(new Phrase("Acepta Exencion de IVA"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getAceptaExencion().equals("") ? "-------------------" : aux.getAceptaExencion());
        return table;
    }
 
    /**
     * Creates a table; widths are set with setWidths().
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable2(List<AuxContactoProv> aux, Font font) throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 2, 1,1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("2. DATOS DEL CONTACTO",font));
        cell.setColspan(4);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        for (AuxContactoProv escribir : aux){
        	cell = new PdfPCell(new Phrase("Nombre Contacto Directo"));
        	cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            table.addCell(escribir.getNomContacto().equals("") ? "-------------------" : escribir.getNomContacto());
            cell = new PdfPCell(new Phrase("Puesto que ocupa"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            table.addCell(escribir.getPuestoContacto().equals("") ? "-------------------" : escribir.getPuestoContacto());
            cell = new PdfPCell(new Phrase("Correo Electrónico"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            table.addCell(escribir.getCorreoContacto().equals("") ? "-------------------" : escribir.getCorreoContacto());
            cell = new PdfPCell(new Phrase("Celular"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            table.addCell(escribir.getCellphoneContacto().equals("") ? "-------------------" : escribir.getCellphoneContacto());
        }
        return table;
    }
 
    /**
     * Creates a table; widths are set in the constructor.
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable3(SegProveedor aux, Font font) throws DocumentException {
    	  PdfPTable table = new PdfPTable(4);
          table.setWidthPercentage(500 / 5.23f);
          table.setWidths(new int[]{1, 2, 1,1});
          PdfPCell cell;
          cell = new PdfPCell(new Phrase("3. INFORMACIÓN DE LA RELACIÓN CON EL PROVEEDOR",font));
          cell.setColspan(4);
          cell.setBackgroundColor(BaseColor.GRAY);
          table.addCell(cell);
          //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
          //cell.setRowspan(2);
          //table.addCell(cell);
          cell = new PdfPCell(new Phrase("Relación con el proveedor"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          table.addCell(aux.getRelacionConProv().equals("") ? "-------------------" : aux.getRelacionConProv());
          cell = new PdfPCell(new Phrase("Tiempo de tener la relación comercial"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          table.addCell(aux.getTiempoDeTrabajarConHG().equals("") ? "-------------------" : aux.getTiempoDeTrabajarConHG());
          cell = new PdfPCell(new Phrase("Afiliado que atiende"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          table.addCell(aux.getAfiliado().getNomAfiliado().equals("") ? "-------------------" : aux.getAfiliado().getNomAfiliado());
          cell = new PdfPCell(new Phrase("Ofrece Distribución"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          table.addCell(aux.getServicioEntrega() == true ? "Si" : "No");
          cell = new PdfPCell(new Phrase("Sucursales"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          cell = new PdfPCell(new Phrase(aux.getUbicacionSucursales().equals("") ?  "--------------" : aux.getUbicacionSucursales()));
          cell.setColspan(3);
          table.addCell(cell);
          cell = new PdfPCell(new Phrase("Productos que ofrece"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          table.addCell(aux.getProductosfrece().equals("") ? "-------------------" : aux.getProductosfrece());
          cell = new PdfPCell(new Phrase("Disponibilidad de productos"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          table.addCell(aux.getDisponibilidadProd().equals("") ? "-------------------" : aux.getDisponibilidadProd());
          cell = new PdfPCell(new Phrase("Tiempo de entrega"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          table.addCell(aux.getTiempoEntrega().equals("") ? "-------------------" : aux.getTiempoEntrega());
          cell = new PdfPCell(new Phrase("Observaciones de Distribución"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          if (aux.getObservacionDistribucion() != null)
        	  table.addCell(aux.getObservacionDistribucion().equals("") ? "-------------------" : aux.getObservacionDistribucion());
          else
        	  table.addCell("----------------------");
          cell = new PdfPCell(new Phrase("Observaciones Generales"));
          cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
          table.addCell(cell);
          cell = new PdfPCell(new Phrase(aux.getObservaciones().equals("") ?  "--------------" : aux.getObservaciones()));
          cell.setColspan(3);
          table.addCell(cell);
          return table;
    }
 
    /**
     * Creates a table; widths are set with special setWidthPercentage() method.
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable4(List<AuxCuentaBancariaProv> aux, Font font) throws DocumentException {
    	 PdfPTable table = new PdfPTable(4);
         table.setWidthPercentage(500 / 5.23f);
         table.setWidths(new int[]{1, 2, 1,1});
         PdfPCell cell;
         cell = new PdfPCell(new Phrase("4. FORMAS DE PAGO",font));
         cell.setColspan(4);
         cell.setBackgroundColor(BaseColor.GRAY);
         table.addCell(cell);
         //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
         //cell.setRowspan(2);
         //table.addCell(cell);
         for (AuxCuentaBancariaProv escribir : aux){
         	cell = new PdfPCell(new Phrase("Forma de Pago"));
         	cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
             table.addCell(escribir.getTipoPago().equals("1")? "Cheque" : "Transferencia");
             cell = new PdfPCell(new Phrase("Numero de Cuenta para transferencia"));
             cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
             table.addCell(cell);
             table.addCell(escribir.getTipoPago().equals("1")?  "Ninguno":escribir.getNumeroCuentaBancaria());
             cell = new PdfPCell(new Phrase("Nombre de la cuenta"));
             cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
             table.addCell(cell);
             table.addCell(escribir.getNombrePropietario().equals("") ? "-------------------" : escribir.getNombrePropietario());
             cell = new PdfPCell(new Phrase("Banco Emisor"));
             cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
             table.addCell(cell);
             table.addCell(escribir.getBancoCuentaBancaria().equals("") ? "-------------------" : escribir.getBancoCuentaBancaria());
         }
         return table;
    }
 
    /**
     * Creates a table; widths are set with setTotalWidth().
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable5(SegProveedor aux, Font font) throws DocumentException {
    	PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 1, 1,2});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("5. DESARROLLO DE RECURSOS",font));
        cell.setColspan(4);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        cell = new PdfPCell(new Phrase("Contribuye con el desarrollo de recursos"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getAceptaDonacion().equals("true")? "Si" : "No");
        cell = new PdfPCell(new Phrase("Forma de realizar donaciones"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getFormaDonacion().equals("") ? "-------------------" : aux.getFormaDonacion());
        cell = new PdfPCell(new Phrase("Porcentaje de donación"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(""+aux.getPorcentDonacion()+"%");
        cell = new PdfPCell(new Phrase("Fecuencia de donación"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getFrecuenciaDonacion().equals("") ? "-------------------" : aux.getFrecuenciaDonacion());;
        cell = new PdfPCell(new Phrase("Contribuirá con eventos especiales"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getContribuyeEventos() == true ? "Si": "No");
        cell = new PdfPCell(new Phrase("Cúales y de que forma"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getCualesyComoEventos().equals("") ? "-------------------" : aux.getCualesyComoEventos());
        return table;
    }
    
    public static PdfPTable createTable6(SegProveedor aux, Font font) throws DocumentException {
    	PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 1, 1,1,1,1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("6. CREDITO",font));
        cell.setColspan(6);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        cell = new PdfPCell(new Phrase("Ofrece acceso a Crédito"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getAceptaCredito() == true ? "Si" : "No");
        cell = new PdfPCell(new Phrase("Monto"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell("Q"+aux.getMontoMaximo());
        cell = new PdfPCell(new Phrase("Tiempo de Crédito"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(""+aux.getTiempoMaximo()+" dias");
        return table;
    }
    
    public static PdfPTable createTable7(SegProveedor aux, Font font) throws DocumentException {
    	PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{3, 1, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("7. DOCUMENTOS REQUERIDOS",font));
        cell.setColspan(3);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        cell = new PdfPCell(new Phrase("Descripción"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell("SI");
        table.addCell("NO");
        cell = new PdfPCell(new Phrase("Copia RTU"));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.addCell(aux.getKeyFileRTU().equals("")? "": "X" );
        table.addCell(aux.getKeyFileRTU().equals("")? "X": "");
        return table;
    }
    
    
    public static PdfPTable createTable8(SegProveedor aux,String nomGerente,String puestoGerente) throws DocumentException {
    	PdfPTable tbl = new PdfPTable(2);
        tbl.setWidthPercentage(500 / 5.23f);
        tbl.setWidths(new int[]{1,1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Firma y Sello:"));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase("________________________"));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase(""));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase(nomGerente));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase(""));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase(puestoGerente));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase(""));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase(aux.getNomProveedor()));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        return tbl;
    }
    
    public static PdfPTable createTable9(SegProveedor aux,String nomCompras, String nomDesarrollo, String nomOpe, String adminAfi) throws DocumentException {
    	PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 1, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Vo. Bo. De la comisión de compra de materiales de construcción de Fundación Hábitat para la Humanidad Guatemala."));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Coordinador Nacional de Compras"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(nomCompras));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Firma:____________________"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Coordinador de Desarrollo de Recursos:"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(nomDesarrollo));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Firma:_____________________"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Departamento de Operaciones:"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(nomOpe));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Firma:_____________________"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Administrador de Afiliado"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(adminAfi));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Firma:____________________"));
        cell.disableBorderSide(Rectangle.BOX);
        cell.setFixedHeight(45f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(cell);
        return table;
    }
	
	
	
}
