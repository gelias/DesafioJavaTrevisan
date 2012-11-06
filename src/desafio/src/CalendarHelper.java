package desafio.src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarHelper {

	public static Calendar criarCalendarComData(String dataCalendar) {
		Date data;
		Calendar cal = null;
		
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(dataCalendar);
			cal = Calendar.getInstance();
			cal.setTime(data);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cal;
	}
	
}
