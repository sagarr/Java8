package stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class WeatherFinder {

    private static final String WEATHER_API =
        "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=2de143494c0b295cca9337e1e96b00e0&units=metric";

    public static Double findTempByCity(final String city) {
        try {
            final URL weather = new URL(String.format(WEATHER_API, city));
            final URLConnection yc = weather.openConnection();
            final BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String data = "";
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                data += inputLine;
            }
            in.close();

            return Double.valueOf(data.split("temp")[1].substring(0, 8).chars().filter(Character::isDigit).limit(2)
                .mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining()));
        } catch (final Exception e) {
            System.out.println(e);
        }
        return null;
    }

}