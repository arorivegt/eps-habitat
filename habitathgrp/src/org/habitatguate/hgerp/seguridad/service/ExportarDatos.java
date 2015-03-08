package org.habitatguate.hgerp.seguridad.service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.habitatguate.hgerp.seguridad.client.auxjdo.AuxEmpleado;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ExportAs
 */
@WebServlet("/ExportarDatos")
public class ExportarDatos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static final int BYTES_DOWNLOAD = 1024;
    private RecursosHumanosServiceImpl recursosHumanosService = new  RecursosHumanosServiceImpl();
    private AuxEmpleado auxEmpleado 			= new AuxEmpleado();
	
    public ExportarDatos() {
        super();
    }

    @SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session 			 = request.getSession(false);
 		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		
        if(session.getAttribute("usserHabitat") != null)
        {  
        	System.out.println("ingreso");
        	long abracadabra 			= Long.parseLong(request.getParameter("abracadabra"));
	        auxEmpleado 				= recursosHumanosService.Empleado_Registrado(abracadabra);
        	
        	response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment;filename=Datos.txt");

			JSONObject jsonEmpleado = new JSONObject();		
			jsonEmpleado.put("id", abracadabra);		
			jsonEmpleado.put("No IGGS", auxEmpleado.getAfiliado());	
            if(auxEmpleado.getSexo().equals("0")){
    			jsonEmpleado.put("Sexo", "femenino");	
            }else if(auxEmpleado.getSexo().equals("1")){
    			jsonEmpleado.put("Sexo", "masculino");	
            }
            if(auxEmpleado.getEstado_civil().equals("0")){
    			jsonEmpleado.put("Estado Civil", "Soltero(a)");	
            }else if(auxEmpleado.getEstado_civil().equals("1")){
    			jsonEmpleado.put("Estado Civil", "Casado(a)/Unida(a)");	
            }else if(auxEmpleado.getEstado_civil().equals("2")){
    			jsonEmpleado.put("Estado Civil", "Viudo(a)");	
            }else if(auxEmpleado.getEstado_civil().equals("3")){
    			jsonEmpleado.put("Estado Civil", "Divorciado(a)");	            	
            }
			jsonEmpleado.put("Primer Apellido", auxEmpleado.getPrimer_apellido());
			jsonEmpleado.put("Segundo Apellido", auxEmpleado.getSegundo_apellido());
			jsonEmpleado.put("Apellido Casada", auxEmpleado.getApellido_casada());
			jsonEmpleado.put("Primer Nombre", auxEmpleado.getPrimer_nombre());
			jsonEmpleado.put("Segundo Nombre", auxEmpleado.getSegundo_nombre());
			jsonEmpleado.put("IVS", auxEmpleado.getIVS());
			jsonEmpleado.put("Pais", getPais(auxEmpleado.getPais()));
			jsonEmpleado.put("NIT", auxEmpleado.getNit());
			jsonEmpleado.put("No. Dependientes", auxEmpleado.getNo_Dependientes());
			jsonEmpleado.put("No. Cuenta", auxEmpleado.getNoCuenta());
			jsonEmpleado.put("Tipo Cuenta", auxEmpleado.getTipoCuenta());
			jsonEmpleado.put("Nombre Banco", auxEmpleado.getNombreBanco());
			jsonEmpleado.put("DPI", auxEmpleado.getCui());
			jsonEmpleado.put("Tipo Pasaporte", auxEmpleado.getTipo_pasaporte());
			jsonEmpleado.put("Direccion", auxEmpleado.getDireccion_actual());
			jsonEmpleado.put("Deptartamento_Municipio_Nacimiento", auxEmpleado.getDepto_municipio_nacimiento());
			jsonEmpleado.put("Correo", auxEmpleado.getEmail());
			jsonEmpleado.put("Telefono Casa", auxEmpleado.getTelefono());
			jsonEmpleado.put("Telefono Celular", auxEmpleado.getCelular());
			jsonEmpleado.put("Año Nacimiento",fecha.format(new Date(auxEmpleado.getFecha_nacimiento())));
			jsonEmpleado.put("Tipo Licencia", auxEmpleado.getTipo_licencia());
			jsonEmpleado.put("No Licencia", auxEmpleado.getNo_licencia());
			jsonEmpleado.put("Centro de Trabajo", auxEmpleado.getCentro_trabajo());
			jsonEmpleado.put("Ocupacion",  auxEmpleado.getOcupacion());
			jsonEmpleado.put("Fecha Ingreso",  fecha.format(new Date(auxEmpleado.getFecha_ingreso())) );
			jsonEmpleado.put("Codigo Ocupacion",  auxEmpleado.getCodigo_ingreso());
			jsonEmpleado.put("Profesion",  auxEmpleado.getProfesion());
			jsonEmpleado.put("Planilla",  auxEmpleado.getTipo_planilla());
			jsonEmpleado.put("Salario",  auxEmpleado.getSalario_base());
			jsonEmpleado.put("Dias Vacaciones",  auxEmpleado.getDiasDeVacaciones());
			jsonEmpleado.put("Bonificacion",  auxEmpleado.getBonificacion());
			jsonEmpleado.put("Estado",  auxEmpleado.getEstado());
			jsonEmpleado.put("No. Pasaporte",  auxEmpleado.getNo_pasaporte());
			jsonEmpleado.put("listTienePasaporte",  auxEmpleado.getPasaporte());
			jsonEmpleado.put("Licencia",  auxEmpleado.getLicencia());
			jsonEmpleado.put("Etnia",  getEtnia(auxEmpleado.getEtnia()));
			jsonEmpleado.put("Nombre Emergencia",  auxEmpleado.getNombreEmergencia());
			jsonEmpleado.put("Telefono Emergencia",  auxEmpleado.getTelefonoEmergencia());
			jsonEmpleado.put("Nombre Emergencia2",  auxEmpleado.getNombreEmergencia2());
			jsonEmpleado.put("Telefono Emergencia2",  auxEmpleado.getTelefonoEmergencia2());
			jsonEmpleado.put("Deptartamento_Municipio_Direccion", auxEmpleado.getDepto_municipio_residencia());
			
            String s = jsonEmpleado.toJSONString();
            InputStream input = new ByteArrayInputStream(s.getBytes("UTF8"));

            int read = 0;
            byte[] bytes = new byte[BYTES_DOWNLOAD];
            OutputStream os = response.getOutputStream();

            while ((read = input.read(bytes)) != -1) {
                os.write(bytes, 0, read);
            }
            os.flush();
            os.close();
			
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
        return "Este servlet genera texto";
    }
    
    private String getEtnia(String codigoEtnia){
    	String etnia = "Mestiza";
    	if(codigoEtnia.equals("1")){etnia =  "Xinca"; }
    	else if(codigoEtnia.equals("2")){etnia = "Maya"; }
    	else if(codigoEtnia.equals("3")){etnia = "Garifuna"; }
    	else if(codigoEtnia.equals("4")){etnia = "Mestiza"; }
    	else if(codigoEtnia.equals("5")){etnia = "Extranjeros"; }
    	return etnia;
    }
    private String getPais(String codigoPais){
    	String pais = "GUATEMALA";
    	if(codigoPais.equals("1")){pais =  "ABUDABI"; }
    	else if(codigoPais.equals("2")){pais = "AFGANISTÁN"; }
    	else if(codigoPais.equals("143")){pais = "ALASKA"; }
    	else if(codigoPais.equals("3")){pais = "ALBANIA"; }
    	else if(codigoPais.equals("4")){pais = "ALEMANIA"; }
    	else if(codigoPais.equals("5")){pais = "ALGERIA"; }
    	else if(codigoPais.equals("198")){pais = "ALMIRANTES"; }
    	else if(codigoPais.equals("199")){pais = "ALTO VOLTA"; }
    	else if(codigoPais.equals("6")){pais = "ANDORRA"; }
    	else if(codigoPais.equals("196")){pais = "ANGLONORMANDAS"; }
    	else if(codigoPais.equals("7")){pais = "ANGOLA"; }
    	else if(codigoPais.equals("8")){pais = "ANGUILLA"; }
    	else if(codigoPais.equals("9")){pais = "ANTARCTICA"; }
    	else if(codigoPais.equals("10")){pais = "ANTIGUA Y BARBUDA"; }
    	else if(codigoPais.equals("195")){pais = "ANTILLAS HOLANDESAS"; }
    	else if(codigoPais.equals("11")){pais = "ARABIA SAUDITA"; }
    	else if(codigoPais.equals("200")){pais = "ARGELIA"; }
    	else if(codigoPais.equals("12")){pais = "ARGENTINA"; }
    	else if(codigoPais.equals("13")){pais = "ARMENIA"; }
    	else if(codigoPais.equals("14")){pais = "ARUBA"; }
    	else if(codigoPais.equals("15")){pais = "AUSTRALIA"; }
    	else if(codigoPais.equals("16")){pais = "AUSTRIA"; }
    	else if(codigoPais.equals("17")){pais = "AZERBAIJAN"; }
    	else if(codigoPais.equals("197")){pais = "AZORES"; }
    	else if(codigoPais.equals("18")){pais = "BAHAMAS"; }
    	else if(codigoPais.equals("19")){pais = "BAHREIN"; }
    	else if(codigoPais.equals("20")){pais = "BANGLADESH"; }
    	else if(codigoPais.equals("21")){pais = "BARBADOS"; }
    	else if(codigoPais.equals("204")){pais = "BARBUDA"; }
    	else if(codigoPais.equals("22")){pais = "BELARUS"; }
    	else if(codigoPais.equals("203")){pais = "BELAU"; }
    	else if(codigoPais.equals("23")){pais = "BÉLGICA"; }
    	else if(codigoPais.equals("24")){pais = "BELIZE"; }
    	else if(codigoPais.equals("25")){pais = "BENIN"; }
    	else if(codigoPais.equals("26")){pais = "BERMUDA"; }
    	else if(codigoPais.equals("27")){pais = "BHUTÁN"; }
    	else if(codigoPais.equals("202")){pais = "BIRMANIA"; }
    	else if(codigoPais.equals("28")){pais = "BOLIVIA"; }
    	else if(codigoPais.equals("201")){pais = "BORNEO"; }
    	else if(codigoPais.equals("29")){pais = "BOSNIA Y HERZEGOVINA"; }
    	else if(codigoPais.equals("30")){pais = "BOTSWANA"; }
    	else if(codigoPais.equals("31")){pais = "BRASIL"; }
    	else if(codigoPais.equals("32")){pais = "BRUNEI"; }
    	else if(codigoPais.equals("33")){pais = "BULGARIA"; }
    	else if(codigoPais.equals("34")){pais = "BURKINA FASO"; }
    	else if(codigoPais.equals("35")){pais = "BURUNDI"; }
    	else if(codigoPais.equals("206")){pais = "CAIMAN"; }
    	else if(codigoPais.equals("207")){pais = "CALPE"; }
    	else if(codigoPais.equals("36")){pais = "CAMBOYA"; }
    	else if(codigoPais.equals("37")){pais = "CAMERÚN"; }
    	else if(codigoPais.equals("38")){pais = "CANADÁ"; }
    	else if(codigoPais.equals("213")){pais = "CANARIAS"; }
    	else if(codigoPais.equals("39")){pais = "CAPO VERDE"; }
    	else if(codigoPais.equals("215")){pais = "CEBELES"; }
    	else if(codigoPais.equals("209")){pais = "CEILAN"; }
    	else if(codigoPais.equals("214")){pais = "CEUTA"; }
    	else if(codigoPais.equals("41")){pais = "CHAD"; }
    	else if(codigoPais.equals("208")){pais = "CHECOSLOVAQUIA"; }
    	else if(codigoPais.equals("42")){pais = "CHILE"; }
    	else if(codigoPais.equals("43")){pais = "CHINA"; }
    	else if(codigoPais.equals("52")){pais = "CHIPRE"; }
    	else if(codigoPais.equals("211")){pais = "CLIPPERTON"; }
    	else if(codigoPais.equals("210")){pais = "COCOS"; }
    	else if(codigoPais.equals("44")){pais = "COLOMBIA"; }
    	else if(codigoPais.equals("45")){pais = "COMORO"; }
    	else if(codigoPais.equals("46")){pais = "CONGO"; }
    	else if(codigoPais.equals("212")){pais = "COOK"; }
    	else if(codigoPais.equals("48")){pais = "COREA"; }
    	else if(codigoPais.equals("47")){pais = "COREA DEL SUR"; }
    	else if(codigoPais.equals("50")){pais = "COSTA DE MARFIL"; }
    	else if(codigoPais.equals("49")){pais = "COSTA RICA"; }
    	else if(codigoPais.equals("53")){pais = "CROATIA"; }
    	else if(codigoPais.equals("54")){pais = "DINAMARCA"; }
    	else if(codigoPais.equals("55")){pais = "DJIBOUTI"; }
    	else if(codigoPais.equals("56")){pais = "DOMINICA"; }
    	else if(codigoPais.equals("58")){pais = "DUBAI"; }
    	else if(codigoPais.equals("59")){pais = "ECUADOR"; }
    	else if(codigoPais.equals("60")){pais = "EGIPTO"; }
    	else if(codigoPais.equals("61")){pais = "EL SALVADOR"; }
    	else if(codigoPais.equals("62")){pais = "EMIRATOS ÁRABES UNIDOS"; }
    	else if(codigoPais.equals("63")){pais = "ERITREA"; }
    	else if(codigoPais.equals("216")){pais = "ESCOCIA"; }
    	else if(codigoPais.equals("64")){pais = "ESLOVAQUIA"; }
    	else if(codigoPais.equals("65")){pais = "ESLOVENIA"; }
    	else if(codigoPais.equals("109")){pais = "ESOTHO"; }
    	else if(codigoPais.equals("66")){pais = "ESPAÑA"; }
    	else if(codigoPais.equals("67")){pais = "ESTADOS UNIDOS DE AMERICA"; }
    	else if(codigoPais.equals("68")){pais = "ESTONIA"; }
    	else if(codigoPais.equals("69")){pais = "ETIOPÍA"; }
    	else if(codigoPais.equals("217")){pais = "FEDERACION DE MALAYSIA"; }
    	else if(codigoPais.equals("219")){pais = "FEROE"; }
    	else if(codigoPais.equals("70")){pais = "FIJI"; }
    	else if(codigoPais.equals("71")){pais = "FILIPINAS"; }
    	else if(codigoPais.equals("72")){pais = "FINLANDIA"; }
    	else if(codigoPais.equals("218")){pais = "FORMOSA"; }
    	else if(codigoPais.equals("73")){pais = "FRANCIA"; }
    	else if(codigoPais.equals("74")){pais = "GABÓN"; }
    	else if(codigoPais.equals("75")){pais = "GAMBIA"; }
    	else if(codigoPais.equals("76")){pais = "GEORGIA"; }
    	else if(codigoPais.equals("77")){pais = "GHANA"; }
    	else if(codigoPais.equals("78")){pais = "GIBRALTAR"; }
    	else if(codigoPais.equals("223")){pais = "GILBERT"; }
    	else if(codigoPais.equals("220")){pais = "GRAN BRETAÑA"; }
    	else if(codigoPais.equals("79")){pais = "GRECIA"; }
    	else if(codigoPais.equals("81")){pais = "GRENADA"; }
    	else if(codigoPais.equals("80")){pais = "GROENLANDIA"; }
    	else if(codigoPais.equals("82")){pais = "GUADELUPE"; }
    	else if(codigoPais.equals("222")){pais = "GUAM"; }
    	else if(codigoPais.equals("83")){pais = "GUATEMALA"; }
    	else if(codigoPais.equals("221")){pais = "GUAYANA INGLESA"; }
    	else if(codigoPais.equals("84")){pais = "GUINEA"; }
    	else if(codigoPais.equals("85")){pais = "GUINEA ECUATORIAL"; }
    	else if(codigoPais.equals("224")){pais = "GUINEA PORTUGUESA"; }
    	else if(codigoPais.equals("86")){pais = "GUYANA"; }
    	else if(codigoPais.equals("87")){pais = "HAITI"; }
    	else if(codigoPais.equals("225")){pais = "HAWAI"; }
    	else if(codigoPais.equals("88")){pais = "HOLANDA"; }
    	else if(codigoPais.equals("89")){pais = "HONDURAS"; }
    	else if(codigoPais.equals("90")){pais = "HONG KONG"; }
    	else if(codigoPais.equals("91")){pais = "HUNGRÍA"; }
    	else if(codigoPais.equals("93")){pais = "INDIA"; }
    	else if(codigoPais.equals("94")){pais = "INDONESIA"; }
    	else if(codigoPais.equals("226")){pais = "INGLATERRA"; }
    	else if(codigoPais.equals("95")){pais = "IRAN"; }
    	else if(codigoPais.equals("96")){pais = "IRAQ"; }
    	else if(codigoPais.equals("227")){pais = "IRIAN JAYA"; }
    	else if(codigoPais.equals("97")){pais = "IRLANDA"; }
    	else if(codigoPais.equals("228")){pais = "ISLA HONG KONG"; }
    	else if(codigoPais.equals("92")){pais = "ISLANDIA"; }
    	else if(codigoPais.equals("98")){pais = "ISRAEL"; }
    	else if(codigoPais.equals("99")){pais = "ITALIA"; }
    	else if(codigoPais.equals("100")){pais = "JAMAICA"; }
    	else if(codigoPais.equals("101")){pais = "JAPÓN"; }
    	else if(codigoPais.equals("102")){pais = "JORDANIA"; }
    	else if(codigoPais.equals("230")){pais = "KATAR"; }
    	else if(codigoPais.equals("103")){pais = "KAZAKHSTAN"; }
    	else if(codigoPais.equals("104")){pais = "KENIA"; }
    	else if(codigoPais.equals("229")){pais = "KOWEIT"; }
    	else if(codigoPais.equals("105")){pais = "KUWAIT"; }
    	else if(codigoPais.equals("106")){pais = "KYRGYZSTAN"; }
    	else if(codigoPais.equals("107")){pais = "LATVIA"; }
    	else if(codigoPais.equals("231")){pais = "LESHOTO"; }
    	else if(codigoPais.equals("110")){pais = "LETONIA"; }
    	else if(codigoPais.equals("108")){pais = "LÍBANO"; }
    	else if(codigoPais.equals("111")){pais = "LIBERIA"; }
    	else if(codigoPais.equals("112")){pais = "LIBIA"; }
    	else if(codigoPais.equals("113")){pais = "LIECHTENSTEIN"; }
    	else if(codigoPais.equals("114")){pais = "LITUANIA"; }
    	else if(codigoPais.equals("115")){pais = "LUXEMBURGO"; }
    	else if(codigoPais.equals("116")){pais = "MACEDONIA"; }
    	else if(codigoPais.equals("235")){pais = "MACQUARIE"; }
    	else if(codigoPais.equals("117")){pais = "MADAGASCAR"; }
    	else if(codigoPais.equals("236")){pais = "MADEITA"; }
    	else if(codigoPais.equals("119")){pais = "MALASIA"; }
    	else if(codigoPais.equals("118")){pais = "MALAWI"; }
    	else if(codigoPais.equals("232")){pais = "MALAYSIA"; }
    	else if(codigoPais.equals("120")){pais = "MALDIVES"; }
    	else if(codigoPais.equals("121")){pais = "MALI"; }
    	else if(codigoPais.equals("122")){pais = "MALTA"; }
    	else if(codigoPais.equals("238")){pais = "MAN"; }
    	else if(codigoPais.equals("133")){pais = "MARRUECOS"; }
    	else if(codigoPais.equals("123")){pais = "MARTINICA"; }
    	else if(codigoPais.equals("124")){pais = "MAURITANIA"; }
    	else if(codigoPais.equals("125")){pais = "MAURITIUS"; }
    	else if(codigoPais.equals("126")){pais = "MAYOTTE"; }
    	else if(codigoPais.equals("233")){pais = "MELILLA"; }
    	else if(codigoPais.equals("127")){pais = "MÉXICO"; }
    	else if(codigoPais.equals("128")){pais = "MICRONESIA"; }
    	else if(codigoPais.equals("237")){pais = "MIDWAY"; }
    	else if(codigoPais.equals("129")){pais = "MOLDOVA"; }
    	else if(codigoPais.equals("234")){pais = "MOLUCA"; }
    	else if(codigoPais.equals("130")){pais = "MÓNACO"; }
    	else if(codigoPais.equals("131")){pais = "MONGOLIA"; }
    	else if(codigoPais.equals("132")){pais = "MONTSERRAT"; }
    	else if(codigoPais.equals("134")){pais = "MOZAMBIQUE"; }
    	else if(codigoPais.equals("135")){pais = "NAMIBIA"; }
    	else if(codigoPais.equals("136")){pais = "NEPAL"; }
    	else if(codigoPais.equals("138")){pais = "NICARAGUA"; }
    	else if(codigoPais.equals("139")){pais = "NIGER"; }
    	else if(codigoPais.equals("140")){pais = "NIGERIA"; }
    	else if(codigoPais.equals("239")){pais = "NORFOLK"; }
    	else if(codigoPais.equals("141")){pais = "NORUEGA"; }
    	else if(codigoPais.equals("240")){pais = "NUEVA CALEDONIA"; }
    	else if(codigoPais.equals("137")){pais = "NUEVA ZELANDIA"; }
    	else if(codigoPais.equals("142")){pais = "OMÁN"; }
    	else if(codigoPais.equals("243")){pais = "PALAU"; }
    	else if(codigoPais.equals("145")){pais = "PALESTINA"; }
    	else if(codigoPais.equals("146")){pais = "PANAMÁ"; }
    	else if(codigoPais.equals("147")){pais = "PAPUA NUEVA GUINEA"; }
    	else if(codigoPais.equals("144")){pais = "PAQUISTÁN"; }
    	else if(codigoPais.equals("148")){pais = "PARAGUAY"; }
    	else if(codigoPais.equals("244")){pais = "PASCUA"; }
    	else if(codigoPais.equals("149")){pais = "PERÚ"; }
    	else if(codigoPais.equals("245")){pais = "PITCAIRN"; }
    	else if(codigoPais.equals("246")){pais = "POLONESIA FRANCESA"; }
    	else if(codigoPais.equals("150")){pais = "POLONIA"; }
    	else if(codigoPais.equals("241")){pais = "POPULAR DE CHINA"; }
    	else if(codigoPais.equals("242")){pais = "POPULAR DE COREA"; }
    	else if(codigoPais.equals("151")){pais = "PORTUGAL"; }
    	else if(codigoPais.equals("152")){pais = "PUERTO RICO"; }
    	else if(codigoPais.equals("153")){pais = "QATAR"; }
    	else if(codigoPais.equals("154")){pais = "REINO UNIDO"; }
    	else if(codigoPais.equals("247")){pais = "REPUBLICA ARABE DE EJIPTO"; }
    	else if(codigoPais.equals("40")){pais = "REPÚBLICA CENTROAFRICANA"; }
    	else if(codigoPais.equals("51")){pais = "REPÚBLICA CHECA"; }
    	else if(codigoPais.equals("248")){pais = "REPUBLICA DE AFRICA ECUATORIAL"; }
    	else if(codigoPais.equals("57")){pais = "REPÚBLICA DOMINICANA"; }
    	else if(codigoPais.equals("155")){pais = "REUNION"; }
    	else if(codigoPais.equals("156")){pais = "ROMANIA"; }
    	else if(codigoPais.equals("157")){pais = "RUSSIA"; }
    	else if(codigoPais.equals("158")){pais = "RWANDA"; }
    	else if(codigoPais.equals("250")){pais = "SALOMON DEL SUR"; }
    	else if(codigoPais.equals("159")){pais = "SAMOA"; }
    	else if(codigoPais.equals("160")){pais = "SAN MARINO"; }
    	else if(codigoPais.equals("251")){pais = "SANTA LUCIA"; }
    	else if(codigoPais.equals("161")){pais = "SAO TOME Y PRÍNCIPE"; }
    	else if(codigoPais.equals("162")){pais = "SENEGAL"; }
    	else if(codigoPais.equals("163")){pais = "SEYCHELLES"; }
    	else if(codigoPais.equals("164")){pais = "SIERRA LEONA"; }
    	else if(codigoPais.equals("165")){pais = "SINGAPUR"; }
    	else if(codigoPais.equals("166")){pais = "SIRIA"; }
    	else if(codigoPais.equals("249")){pais = "SOCOTORRA"; }
    	else if(codigoPais.equals("167")){pais = "SOMALIA"; }
    	else if(codigoPais.equals("169")){pais = "SRI LANKA"; }
    	else if(codigoPais.equals("170")){pais = "SUDÁN"; }
    	else if(codigoPais.equals("173")){pais = "SUECIA"; }
    	else if(codigoPais.equals("174")){pais = "SUIZA"; }
    	else if(codigoPais.equals("168")){pais = "SURÁFRICA"; }
    	else if(codigoPais.equals("171")){pais = "SURINAME"; }
    	else if(codigoPais.equals("172")){pais = "SWAZILANDIA"; }
    	else if(codigoPais.equals("178")){pais = "TAILANDIA"; }
    	else if(codigoPais.equals("175")){pais = "TAIWÁN"; }
    	else if(codigoPais.equals("176")){pais = "TAJIKISTAN"; }
    	else if(codigoPais.equals("177")){pais = "TANZANIA"; }
    	else if(codigoPais.equals("252")){pais = "TIMOR"; }
    	else if(codigoPais.equals("179")){pais = "TOGO"; }
    	else if(codigoPais.equals("253")){pais = "TOKELAU"; }
    	else if(codigoPais.equals("181")){pais = "TONGA"; }
    	else if(codigoPais.equals("181")){pais = "TRINIDAD Y TOBAGO"; }
    	else if(codigoPais.equals("182")){pais = "TÚNEZ"; }
    	else if(codigoPais.equals("184")){pais = "3TURKMENISTAN"; }
    	else if(codigoPais.equals("183")){pais = "TURQUÍA"; }
    	else if(codigoPais.equals("254")){pais = "TUVALU"; }
    	else if(codigoPais.equals("185")){pais = "UCRANIA"; }
    	else if(codigoPais.equals("186")){pais = "UGANDA"; }
    	else if(codigoPais.equals("187")){pais = "URUGUAY"; }
    	else if(codigoPais.equals("188")){pais = "UZBEKISTAN"; }
    	else if(codigoPais.equals("257")){pais = "VATICANO"; }
    	else if(codigoPais.equals("189")){pais = "VENEZUELA"; }
    	else if(codigoPais.equals("190")){pais = "VIETNAM"; }
    	else if(codigoPais.equals("256")){pais = "VIRGENES AMERICAS"; }
    	else if(codigoPais.equals("255")){pais = "VIRGENES BRITANICAS"; }
    	else if(codigoPais.equals("258")){pais = "WAKE"; }
    	else if(codigoPais.equals("259")){pais = "WALLIS"; }
    	else if(codigoPais.equals("191")){pais = "YEMEN"; }
    	else if(codigoPais.equals("192")){pais = "YUGOSLAVIA"; }
    	else if(codigoPais.equals("183")){pais = "ZAMBIA"; }
    	else if(codigoPais.equals("194")){pais = "ZIMBABWE"; }
    	
		return pais;

    }
	
	
}
