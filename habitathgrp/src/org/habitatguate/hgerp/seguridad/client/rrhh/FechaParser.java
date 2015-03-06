package org.habitatguate.hgerp.seguridad.client.rrhh;

public class FechaParser {
	
	public int getDia(int x_nMonth, int x_nDay, int x_nYear){
		if(x_nMonth >= 3){	
			x_nMonth -= 2;
		}
		else {
			x_nMonth += 10;
		}

		if( (x_nMonth == 11) || (x_nMonth == 12) ){
			x_nYear--;
		}

		int  nCentNum = x_nYear / 100;
		int nDYearNum = x_nYear % 100;

		int g = (int) (2.6 * x_nMonth - 0.2);

		g += x_nDay + nDYearNum;
		g += nDYearNum / 4;	
		g  = (int)g;
		g += (int)(nCentNum / 4);
		g -= (int)(2 * nCentNum);
		g %= 7;
		
		if(x_nYear >= 1700 && x_nYear <= 1751) {
			g -= 3;
		}
		else {
			if(x_nYear <= 1699) {
				g -= 4;
			}
		}
		
		if(g < 0){
			g += 7;
		}
		
		return g;
	}
	
	public String getDia(int x_nDayOfWeek){
		String dia = "";
		
		if(x_nDayOfWeek == 0) {
			dia = "Domingo";
		}
		if(x_nDayOfWeek == 1) {
			dia = "Lunes";
		}
		if(x_nDayOfWeek == 2) {
			dia = "Martes";
		}
		if(x_nDayOfWeek == 3) {
			dia = "Miercoles";
		}
		if(x_nDayOfWeek == 4) {
			dia = "Jueves";
		}
		if(x_nDayOfWeek == 5) {
			dia = "Viernes";
		}
		if(x_nDayOfWeek == 6) {
			dia = "SAbado";
		}

		return dia;
	}

}
