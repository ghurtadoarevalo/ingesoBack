package mingeso.mingeso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class MingesoApplication {
	public static void main(String[] args)
	{
		Date a = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(a);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);


		System.out.println(cal.getTime().toString());
	}

}
