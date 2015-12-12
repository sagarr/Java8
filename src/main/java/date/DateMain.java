package date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateMain {

    public static void main(final String[] args) {
        final LocalDateTime coffeBreak = LocalDateTime.now().plusHours(5).plusMinutes(30);
        System.out.println(coffeBreak);

        // flight time
        final ZoneId lodz = ZoneId.of("Europe/Warsaw");
        final LocalDate nov1 = LocalDate.of(2015, Month.NOVEMBER, 1);
        final LocalTime early = LocalTime.parse("02:25");
        final ZonedDateTime flightDeparture = ZonedDateTime.of(nov1, early, lodz);
        System.out.println(flightDeparture);
        final LocalTime from = LocalTime.from(flightDeparture);
        System.out.println(from);
        final ZonedDateTime touchDown = ZonedDateTime.of(nov1.plusDays(1), LocalTime.of(9, 35), ZoneId.of("Asia/Calcutta"));
        final Duration flightLength = Duration.between(flightDeparture, touchDown);
        System.out.println(flightLength);
    }
}