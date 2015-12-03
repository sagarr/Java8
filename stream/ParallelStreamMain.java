import java.util.*;
import java.time.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ParallelStreamMain {
	public static void main(String[] args) {
		List<String> cities = Arrays.asList("London", "Lodz", "Ghent", "Pune");
		Instant start = Instant.now();
		System.out.println("Lowest temp is: " + findDeclratively(cities));
		Instant stop = Instant.now();
		System.out.println("Time taken in millis: " + Duration.between(start, stop).toMillis());
	}

	private static Double findImperatively(List<String> cities) {
		// find all temps
		List<Double> temps = new ArrayList<>();
		for (String city : cities) {
			temps.add(WeatherFinder.findTempByCity(city));
		}

		// find temp less than 10
		List<Double> tempsLessThan10 = new ArrayList<>();
		for (Double temp : temps) {
			if(temp < 10) {
				tempsLessThan10.add(temp);
			}
		}

		// find lowest temp 
		Double lowestTemp = 100000d;
		for (Double temp : temps) {
			lowestTemp = findLowestTemp(lowestTemp, temp);
		}

		return lowestTemp;
	}

	private static Double findDeclratively(List<String> cities) {		
		return cities.parallelStream()
			  .map(WeatherFinder::findTempByCity)
			  .filter(t -> t < 10)
			  .reduce(1000d, ParallelStreamMain::findLowestTemp);
	}

	private static Double findLowestTemp(Double temp1, Double temp2) {
		System.out.println(Thread.currentThread());
		return temp1 > temp2 ? temp2 : temp1;
	}
}