package exam2;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ReadWeatherJSON {
    public static void main(String[] args) throws IOException, JsonException {
        // Tạo dòng Reader
        Reader reader = Files.newBufferedReader(Paths.get("weather.json"));

        // Đọc object từ dòng (stream)
        JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

        // Read coord
        JsonObject coord = (JsonObject) parser.get("coord");
        BigDecimal lon = (BigDecimal) coord.get("lon");
        BigDecimal lat = (BigDecimal) coord.get("lat");
        System.out.println("Coordinates: Lon = " + lon + ", Lat = " + lat);

        // Read weather array
        JsonArray weatherArray = (JsonArray) parser.get("weather");
        weatherArray.forEach(entry -> {
            JsonObject weather = (JsonObject) entry;
            System.out.println("Weather ID: " + weather.get("id"));
            System.out.println("Main: " + weather.get("main"));
            System.out.println("Description: " + weather.get("description"));
            System.out.println("Icon: " + weather.get("icon"));
        });

        // Read main
        JsonObject main = (JsonObject) parser.get("main");
        BigDecimal temp = (BigDecimal) main.get("temp");
        BigDecimal feels_like = (BigDecimal) main.get("feels_like");
        BigDecimal temp_min = (BigDecimal) main.get("temp_min");
        BigDecimal temp_max = (BigDecimal) main.get("temp_max");
        BigDecimal pressure = (BigDecimal) main.get("pressure");
        BigDecimal humidity = (BigDecimal) main.get("humidity");
        BigDecimal sea_level = (BigDecimal) main.get("sea_level");
        BigDecimal grnd_level = (BigDecimal) main.get("grnd_level");
        System.out.println("Temperature: " + temp + "K");
        System.out.println("Feels Like: " + feels_like + "K");
        System.out.println("Min Temperature: " + temp_min + "K");
        System.out.println("Max Temperature: " + temp_max + "K");
        System.out.println("Pressure: " + pressure + " hPa");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Sea Level: " + sea_level + " hPa");
        System.out.println("Ground Level: " + grnd_level + " hPa");

        // Read visibility
        BigDecimal visibility = (BigDecimal) parser.get("visibility");
        System.out.println("Visibility: " + visibility + " meters");

        // Read wind
        JsonObject wind = (JsonObject) parser.get("wind");
        BigDecimal speed = (BigDecimal) wind.get("speed");
        BigDecimal deg = (BigDecimal) wind.get("deg");
        BigDecimal gust = (BigDecimal) wind.get("gust");
        System.out.println("Wind Speed: " + speed + " m/s");
        System.out.println("Wind Degree: " + deg);
        System.out.println("Wind Gust: " + gust + " m/s");

        // Read clouds
        JsonObject clouds = (JsonObject) parser.get("clouds");
        BigDecimal all = (BigDecimal) clouds.get("all");
        System.out.println("Cloudiness: " + all + "%");

        // Read sys
        JsonObject sys = (JsonObject) parser.get("sys");
        BigDecimal type = (BigDecimal) sys.get("type");
        BigDecimal id = (BigDecimal) sys.get("id");
        String country = (String) sys.get("country");
        BigDecimal sunrise = (BigDecimal) sys.get("sunrise");
        BigDecimal sunset = (BigDecimal) sys.get("sunset");
        System.out.println("System Type: " + type);
        System.out.println("System ID: " + id);
        System.out.println("Country: " + country);
        System.out.println("Sunrise: " + sunrise);
        System.out.println("Sunset: " + sunset);

        // Read other top-level fields
        BigDecimal dt = (BigDecimal) parser.get("dt");
        BigDecimal timezone = (BigDecimal) parser.get("timezone");
        BigDecimal idMain = (BigDecimal) parser.get("id");
        String name = (String) parser.get("name");
        BigDecimal cod = (BigDecimal) parser.get("cod");
        System.out.println("Datetime: " + dt);
        System.out.println("Timezone: " + timezone);
        System.out.println("ID: " + idMain);
        System.out.println("Name: " + name);
        System.out.println("Code: " + cod);

        // Đóng lại stream sau khi dùng xong
        reader.close();
    }
}
