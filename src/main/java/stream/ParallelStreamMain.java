package stream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamMain {

    public static void main(final String[] args) {
        final List<String> cities = Arrays.asList("London", "Lodz", "Ghent", "Pune");
        final Instant start = Instant.now();
        System.out.println("Lowest temp is: " + findDeclratively(cities));
        final Instant stop = Instant.now();
        System.out.println("Time taken in millis: " + Duration.between(start, stop).toMillis());
    }

    private static Double findImperatively(final List<String> cities) {
        // find all temps
        final List<Double> temps = new ArrayList<>();
        for (final String city : cities) {
            temps.add(WeatherFinder.findTempByCity(city));
        }

        // find temp less than 10
        final List<Double> tempsLessThan10 = new ArrayList<>();
        for (final Double temp : temps) {
            if (temp < 10) {
                tempsLessThan10.add(temp);
            }
        }

        // find lowest temp
        Double lowestTemp = 100000d;
        for (final Double temp : temps) {
            lowestTemp = findLowestTemp(lowestTemp, temp);
        }

        return lowestTemp;
    }

    private static Double findDeclratively(final List<String> cities) {
        return cities.parallelStream().map(WeatherFinder::findTempByCity).filter(t -> t < 10).reduce(1000d,
            ParallelStreamMain::findLowestTemp);
    }

    private static Double findLowestTemp(final Double temp1, final Double temp2) {
        System.out.println(Thread.currentThread());
        return temp1 > temp2 ? temp2 : temp1;
    }
}