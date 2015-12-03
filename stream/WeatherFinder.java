import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.stream.*;

public class WeatherFinder {

	private static final String WEATHER_API = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=2de143494c0b295cca9337e1e96b00e0&units=metric";

	public static Double findTempByCity(String city) {
		try {
			URL weather = new URL(String.format(WEATHER_API, city));
	        URLConnection yc = weather.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        String data = "";
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) 
	            data += inputLine;
	        in.close();
	        
 			return Double.valueOf(data.split("temp")[1].substring(0, 8)
	        			.chars()	        			
	        			.filter(Character::isDigit)	        			
	        			.limit(2)
	        			.mapToObj(c -> String.valueOf((char)c))	        			
	        			.collect(Collectors.joining()));	        
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	    return null;
    }

}