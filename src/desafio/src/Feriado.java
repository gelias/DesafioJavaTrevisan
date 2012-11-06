package desafio.src;

import java.util.ArrayList;
import java.util.Calendar;

public class Feriado {

	public static ArrayList<Calendar> feriadosNacionais = new ArrayList<Calendar>();

	public static boolean isFeriadoNacional(Calendar data) {
		return feriadosNacionais.contains(data);
	}

	public static ArrayList<Calendar> getFeriadosNacionais() {

		if (feriadosNacionais.size() == 0) {
			feriadosNacionais.add(CalendarHelper
					.criarCalendarComData("2012-01-01"));
			feriadosNacionais.add(CalendarHelper
					.criarCalendarComData("2012-05-01"));
			feriadosNacionais.add(CalendarHelper
					.criarCalendarComData("2012-09-07"));
			feriadosNacionais.add(CalendarHelper
					.criarCalendarComData("2012-11-15"));
			feriadosNacionais.add(CalendarHelper
					.criarCalendarComData("2012-12-25"));
		}

		return feriadosNacionais;
	}
}
