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
@WebServlet("/ExportDatosProv")
public class ExportDatosProv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ExportDatosProv() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session 	= request.getSession(false);
        
		if(session.getAttribute("usserHabitat") != null)
        { 
			InfoComparativoPreciosXml n = new  InfoComparativoPreciosXml();
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "inline; Filename=ReporteComprasProv.xls");
			
			String afiliado 				= request.getParameter("idAfiliado");
			String estado 				= request.getParameter("estado");
			String tipo 				= request.getParameter("tipo");

			
			

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
							+ n.ReporteDatosProv(afiliado, estado, tipo);
				
				
			}catch(Exception e){
				System.out.println(e.toString());
				xmlFinal 				= inicio;
			}
			
			PrintWriter out 			= response.getWriter();
			out.write(xmlFinal);
		}
		
	}
	
}
