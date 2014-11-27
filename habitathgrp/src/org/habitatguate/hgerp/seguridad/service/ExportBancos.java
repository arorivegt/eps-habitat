package org.habitatguate.hgerp.seguridad.service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExportAs
 */
@WebServlet("/ExportBancos")
public class ExportBancos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ExportBancos() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session 	= request.getSession(false);
        
		if(session.getAttribute("usserHabitat") != null)
        { 
			InformBancosXml n 			= new InformBancosXml();
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "inline; Filename=document_name.xls");
			
			String tipo 				= request.getParameter("tipo");
			String primer_nombre 		= request.getParameter("primer_nombre");
			String segundo_nombre 		= request.getParameter("segundo_nombre");
			String primer_apellido 		= request.getParameter("primer_apellido");
			String segundo_apellido 	= request.getParameter("segundo_apellido");
			String DPI 					= request.getParameter("DPI");
			String Pasaporte 			= request.getParameter("Pasaporte");
			String listMes 				= request.getParameter("listMes");
			String estado 				= request.getParameter("estado");
			String listAnio			 	= request.getParameter("annio");
			String  xmlFinal 			= "";
			String inicio				= "<html xmlns:o='urn:schemas-microsoft-com:office:office' "
										+ "xmlns:x='urn:schemas-microsoft-com:office:excel' "
										+ "xmlns='http://www.w3.org/TR/REC-html40'><head><!--[if gte mso 9]>"
										+ "<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>"
										+ "<x:Name>name</x:Name><x:WorksheetOptions><x:DisplayGridlines/>"
										+ "</x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets>"
										+ "</x:ExcelWorkbook></xml><![endif]--></head><body>";
			try{
				xmlFinal 				= inicio 
										+ n.Bancos(tipo.charAt(0), primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, DPI, Pasaporte, estado, listMes, listAnio);
			}catch(Exception e){
				xmlFinal 				= inicio;
			}
			
			PrintWriter out 			= response.getWriter();
			out.write(xmlFinal);
		}
		
	}
	
}
