package app;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Component {
	public static int getAge(String dataNasc) {
		String[] partes = dataNasc.split("/");
		int diaNasc = Integer.valueOf(partes[0]);
		int mesNasc = Integer.valueOf(partes[1]);
		int anoNasc = Integer.valueOf(partes[2]);
		
		GregorianCalendar hoje = new GregorianCalendar();
		int diaH = hoje.get(Calendar.DAY_OF_MONTH);
		int mesH = hoje.get(Calendar.MONTH)+ 1;
		int anoH = hoje.get(Calendar.YEAR);
		
		int idade;
		idade = anoH - anoNasc;
		if((mesH < mesNasc) || ((mesH == mesNasc) && (diaH < diaNasc))) {
			idade--;
		}
		return idade;
	}
}
