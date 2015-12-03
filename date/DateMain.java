
import java.time.*;

public class DateMain {

	public static void main(String[] args) {
		LocalDateTime coffeBreak = LocalDateTime.now()
								  		  .plusHours(5)
								  		  .plusMinutes(30);
		System.out.println(coffeBreak);

		// flight time
		ZoneId lodz = ZoneId.of("Europe/Warsaw");
		LocalDate nov1 = LocalDate.of(2015, Month.NOVEMBER, 1);
		LocalTime early = LocalTime.parse("02:25");
		ZonedDateTime flightDeparture = ZonedDateTime.of(nov1, early, lodz);
		System.out.println(flightDeparture);
		LocalTime from = LocalTime.from(flightDeparture);
		System.out.println(from);
		ZonedDateTime touchDown = ZonedDateTime.of(nov1.plusDays(1), LocalTime.of(9, 35), ZoneId.of("Asia/Calcutta"));
		Duration flightLength = Duration.between(flightDeparture, touchDown);
		System.out.println(flightLength);
	}
}