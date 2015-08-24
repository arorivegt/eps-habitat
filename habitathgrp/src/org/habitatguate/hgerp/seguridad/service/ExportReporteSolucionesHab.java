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
@WebServlet("/ExportRerporteSolucionesHab")
public class ExportReporteSolucionesHab extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ExportReporteSolucionesHab() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session 	= request.getSession(false);
        
		if(session.getAttribute("usserHabitat") != null)
        { 
			InfoComparativoPreciosXml n = new  InfoComparativoPreciosXml();
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "inline; Filename=ReporteComprasProv.xls");
			
			String idAfiliado 				= request.getParameter("idAfiliado");
			String trimestre 				= request.getParameter("trimestre");
			String tipoSolucion 				= request.getParameter("tipoSolucion");
			String anioFin 				= request.getParameter("anioFin");
			String anio 				= request.getParameter("anio");
			String montoMin 				= request.getParameter("montoMin");
			String montoMax 				= request.getParameter("montoMax");
			String codDep					= request.getParameter("codDep");
			String codMun					= request.getParameter("codMun");
			String estadoSolucion				= request.getParameter("estadoSolucion");
			String filter					="";

			
			

			String  xmlFinal 			= "";
			String inicio				= "<html xmlns:o='urn:schemas-microsoft-com:office:office' "
										+ "xmlns:x='urn:schemas-microsoft-com:office:excel' "
										+ "xmlns='http://www.w3.org/TR/REC-html40'><head><!--[if gte mso 9]>"
										+ "<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>"
										+ "<x:Name>name</x:Name><x:WorksheetOptions><x:DisplayGridlines/>"
										+ "</x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets>"
										+ "</x:ExcelWorkbook></xml><![endif]--></head><body>";
			try{
				
				if (!tipoSolucion.equals("0")){
					filter = filter + " && disenio =='"+tipoSolucion+"' ";
					
				}
				if (!trimestre.equals("0")){
					filter = filter + " && trimestre =="+trimestre;
				}
				
				if (!codDep.equals("0") && codMun.equals("0")){
					filter = filter + " && departamentoSolucion == '"+codDep+"'";
				}else if (!codDep.equals("0") && !codMun.equals("0")){
					filter = filter + " && departamentoSolucion == '"+codDep + "' && municipioSolucion == '"+codMun+"'";
				}
				
				if (!estadoSolucion.equals("0")){
					filter = filter + " && estadoSolucion == "+estadoSolucion;
				}
				
				
				
					xmlFinal 				= inicio
							+ n.SolucionesHab(idAfiliado, anio, anioFin, montoMin, montoMax, filter);
				
				
			}catch(Exception e){
				System.out.println(e.toString());
				xmlFinal 				= inicio;
			}
			
			PrintWriter out 			= response.getWriter();
			out.write(xmlFinal);
		}
		
	}
	
}
