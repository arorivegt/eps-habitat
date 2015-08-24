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
@WebServlet("/ExportRerporteCuentasAPagar")
public class ExportReporteCuentasAPagar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ExportReporteCuentasAPagar() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session 	= request.getSession(false);
        
		if(session.getAttribute("usserHabitat") != null)
        { 
			InfoComparativoPreciosXml n = new  InfoComparativoPreciosXml();
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "inline; Filename=ReportePagosProv.xls");
			
			String idAfiliado 				= request.getParameter("idAfiliado");
			String filter 				= request.getParameter("filter");
			String idProveedor 				= request.getParameter("idProveedor");
			String anioFin 				= request.getParameter("anioFin");
			String trimestre 				= request.getParameter("trimestre");
			String fechaInicio 				= request.getParameter("fechaInicio");
			String fechaFIn 				= request.getParameter("fechaFIn");
			String checkRange 				= request.getParameter("checkRange");
			String estado 				= request.getParameter("estado");

			
			

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
							+ n.ReporteCuentasAPagar(idAfiliado, filter, idProveedor, anioFin, trimestre, fechaInicio, fechaFIn, estado, Boolean.valueOf(checkRange));
				
				
			}catch(Exception e){
				System.out.println(e.toString());
				xmlFinal 				= inicio;
			}
			
			PrintWriter out 			= response.getWriter();
			out.write(xmlFinal);
		}
		
	}
	
}
