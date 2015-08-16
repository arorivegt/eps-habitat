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
    private Font catFont2 						= new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD,BaseColor.BLACK);
    private Font catFont3 						= new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL,BaseColor.BLACK);
    
    private SegProveedor auxProv = new SegProveedor();
    private List<AuxContactoProv> auxContact = new ArrayList<AuxContactoProv>();
    private List<AuxCuentaBancariaProv> auxPago = new ArrayList<AuxCuentaBancariaProv>();
    private SqlServiceImpl finanzasService = new  SqlServiceImpl();
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
    		long idAfiliado 			= Long.parseLong(session.getAttribute("idAfiliadoHabitat").toString());
        	long idProveedor			= Long.valueOf(request.getParameter("idProveedor"));
        	auxProv						= finanzasService.GetInfoProveedor(idProveedor,idAfiliado);
			auxContact					= finanzasService.Consultar_ContactosProv(auxProv.getIdProveedor().getId());
			auxPago 					= finanzasService.Consultar_FormasPago(auxProv.getIdProveedor().getId());
	        OutputStream out 			= response.getOutputStream();
	       
		        try {
		            Document document 	= new Document(PageSize.LETTER,15,15,15,15);
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
		            
	            
		            

		            
		            document.add(new Paragraph("FUNDACIÓN HABITAT PARA LA HUMANIDAD GUATEMALA",catFont2));
		            document.add(new Paragraph("FORMULARIO DE APROBACIÓN DE PROVEEDORES",catFont));
		            document.add(new Paragraph("Fecha: "+fechaFormat.format(new Date()) ,catFont));
		            document.add(new Paragraph("\t",catFont));

		            PdfPTable table = createTable1(auxProv);
		            document.add(table);
		            table = createTable2(auxContact);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable3(auxProv);
		            document.add(table);
		            table = createTable4(auxPago);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable5(auxProv);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable6(auxProv);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            table = createTable7(auxProv);
		            table.setSpacingBefore(5);
		            table.setSpacingAfter(5);
		            document.add(table);
		            document.add(new Paragraph("El presente convenio es por tiempo indefinido, existiendo el compromiso de ambas partes en el cumplimiento de los términos antes descritos; pudiéndose dar por terminado en cualquier momento por cualquiera de las partes o por mutuo consentimiento, derivado del incumplimiento total o parcial de lo convenido.",catFont3));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("\t",catFont));
		            table = createTable8(auxProv);
		            document.add(table);
		            document.add(new Paragraph("\t",catFont));
		            document.add(new Paragraph("\t",catFont));
		            table = createTable9(auxProv);
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
    public static PdfPTable createTable1(SegProveedor aux) throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 2, 1,1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("1. DATOS GENERALES DE LA EMPRESA"));
        cell.setColspan(4);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        table.addCell("Nombre de la Empresa:");
        table.addCell(aux.getNomProveedor());
        table.addCell("Estado del proveedor");
        table.addCell(aux.getAprobadoComision() == true ? "Activo": "Inactivo");
        table.addCell("Razón Social ");
        table.addCell(aux.getRazonSocial());
        table.addCell("NIT");
        table.addCell(aux.getNumeroNit());
        table.addCell("Dirección");
        cell = new PdfPCell(new Phrase(aux.getDirProveedor()));
        cell.setColspan(3);
        table.addCell(cell);
        table.addCell("Pagina Web");
        table.addCell(aux.getPaginaWeb());
        table.addCell("Personeria Jurídica");
        table.addCell(aux.getPersonaJuridica());
        table.addCell("Actividad Comercial o Categorización");
        table.addCell(aux.getActividadEcono());
        table.addCell("Teléfono");
        table.addCell(aux.getTelProveedor());
        table.addCell("Régimen Tributario");
        table.addCell(aux.getRegimenTributario());
        table.addCell("Acepta Exencion de IVA");
        table.addCell(aux.getAceptaExencion());
        return table;
    }
 
    /**
     * Creates a table; widths are set with setWidths().
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable2(List<AuxContactoProv> aux) throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 2, 1,1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("2. DATOS DEL CONTACTO"));
        cell.setColspan(4);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        for (AuxContactoProv escribir : aux){
        	table.addCell("Nombre Contacto Directo");
            table.addCell(escribir.getNomContacto());
            table.addCell("Puesto que ocupa");
            table.addCell(escribir.getPuestoContacto());
            table.addCell("Correo Electrónico");
            table.addCell(escribir.getCorreoContacto());
            table.addCell("Celular");
            table.addCell(escribir.getCellphoneContacto());
        }
        return table;
    }
 
    /**
     * Creates a table; widths are set in the constructor.
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable3(SegProveedor aux) throws DocumentException {
    	  PdfPTable table = new PdfPTable(4);
          table.setWidthPercentage(500 / 5.23f);
          table.setWidths(new int[]{1, 2, 1,1});
          PdfPCell cell;
          cell = new PdfPCell(new Phrase("3. INFORMACIÓN DE LA RELACIÓN CON EL PROVEEDOR"));
          cell.setColspan(4);
          table.addCell(cell);
          //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
          //cell.setRowspan(2);
          //table.addCell(cell);
          table.addCell("Relación con el proveedor");
          table.addCell(aux.getRelacionConProv());
          table.addCell("Tiempo de tener la relación comercial");
          table.addCell(aux.getTiempoDeTrabajarConHG());
          table.addCell("Afiliado que atiende");
          table.addCell(aux.getAfiliado().getNomAfiliado());
          table.addCell("Ofrece Distribución");
          table.addCell(aux.getServicioEntrega() == true ? "Si" : "No");
          table.addCell("Sucursales");
          cell = new PdfPCell(new Phrase(aux.getUbicacionSucursales()));
          cell.setColspan(3);
          table.addCell(cell);
          table.addCell("Productos que ofrece");
          table.addCell(aux.getProductosfrece());
          table.addCell("Disponibilidad de productos");
          table.addCell(aux.getDisponibilidadProd());
          table.addCell("Tiempo de entrega");
          table.addCell(aux.getTiempoEntrega());
          table.addCell("Observaciones");
          table.addCell(aux.getObservaciones());
          
          return table;
    }
 
    /**
     * Creates a table; widths are set with special setWidthPercentage() method.
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable4(List<AuxCuentaBancariaProv> aux) throws DocumentException {
    	 PdfPTable table = new PdfPTable(4);
         table.setWidthPercentage(500 / 5.23f);
         table.setWidths(new int[]{1, 2, 1,1});
         PdfPCell cell;
         cell = new PdfPCell(new Phrase("4. FORMAS DE PAGO"));
         cell.setColspan(4);
         table.addCell(cell);
         //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
         //cell.setRowspan(2);
         //table.addCell(cell);
         for (AuxCuentaBancariaProv escribir : aux){
         	table.addCell("Forma de Pago");
             table.addCell(escribir.getTipoPago().equals("1")? "Cheque" : "Transferencia");
             table.addCell("Numero de Cuenta para transferencia");
             table.addCell(escribir.getTipoPago().equals("1")?  "Ninguno":escribir.getNumeroCuentaBancaria());
             table.addCell("Nombre de la cuenta");
             table.addCell(escribir.getNombrePropietario());
             table.addCell("Banco Emisor");
             table.addCell(escribir.getBancoCuentaBancaria());
         }
         return table;
    }
 
    /**
     * Creates a table; widths are set with setTotalWidth().
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable5(SegProveedor aux) throws DocumentException {
    	PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 1, 1,2});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("5. DESARROLLO DE RECURSOS"));
        cell.setColspan(4);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        table.addCell("Contribuye con el desarrollo de recursos");
        table.addCell(aux.getAceptaDonacion().equals("true")? "Si" : "No");
        table.addCell("Forma de realizar donaciones");
        table.addCell(aux.getFormaDonacion());
        table.addCell("Porcentaje de donación");
        table.addCell(""+aux.getPorcentDonacion()+"%");
        table.addCell("Fecuencia de donación");
        table.addCell(aux.getFrecuenciaDonacion());;
        table.addCell("Contribuirá con eventos especiales");
        table.addCell(aux.getContribuyeEventos() == true ? "Si": "No");
        table.addCell("Cúales y de que forma");
        table.addCell(aux.getCualesyComoEventos());
        return table;
    }
    
    public static PdfPTable createTable6(SegProveedor aux) throws DocumentException {
    	PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{1, 1, 1,1,1,1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("6. CREDITO"));
        cell.setColspan(6);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        table.addCell("Ofrece acceso a Crédito");
        table.addCell(aux.getAceptaCredito() == true ? "Si" : "No");
        table.addCell("Monto");
        table.addCell("Q"+aux.getMontoMaximo());
        table.addCell("Tiempo de Crédito");
        table.addCell(""+aux.getTiempoMaximo()+" dias");
        return table;
    }
    
    public static PdfPTable createTable7(SegProveedor aux) throws DocumentException {
    	PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(500 / 5.23f);
        table.setWidths(new int[]{3, 1, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("7. DOCUMENTOS REQUERIDOS"));
        cell.setColspan(3);
        table.addCell(cell);
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        table.addCell("Descripción");
        table.addCell("SI");
        table.addCell("NO");
        table.addCell("Copia RTU");
        table.addCell(aux.getKeyFileRTU().equals("")? "X": "" );
        table.addCell(aux.getKeyFileRTU().equals("")? "": "X");
        return table;
    }
    
    
    public static PdfPTable createTable8(SegProveedor aux) throws DocumentException {
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
        cell = new PdfPCell(new Phrase("Nombre"));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase(""));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.disableBorderSide(Rectangle.BOX);
        tbl.addCell(cell);
        cell = new PdfPCell(new Phrase("Puesto"));
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
    
    public static PdfPTable createTable9(SegProveedor aux) throws DocumentException {
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
        cell = new PdfPCell(new Phrase("William Franklin Barrios"));
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
        cell = new PdfPCell(new Phrase("Carlos Alfredo Mejia Leiva"));
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
        cell = new PdfPCell(new Phrase("Nombre"));
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
        cell = new PdfPCell(new Phrase("Nombre"));
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
