package exam2;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteWeatherJSON {
    public static void main(String[] args) throws IOException {
        // Tạo ra dòng Ghi dữ liệu (Writer)
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("weather.json"));

        // Tạo đối tượng coord
        JsonObject coord = new JsonObject();
        coord.put("lon", 105.8412);
        coord.put("lat", 21.0245);

        // Tạo đối tượng weather
        JsonArray weatherArray = new JsonArray();
        JsonObject weather = new JsonObject();
        weather.put("id", 804);
        weather.put("main", "Clouds");
        weather.put("description", "overcast clouds");
        weather.put("icon", "04d");
        weatherArray.add(weather);

        // Tạo đối tượng main
        JsonObject main = new JsonObject();
        main.put("temp", 305.15);
        main.put("feels_like", 306.6);
        main.put("temp_min", 305.15);
        main.put("temp_max", 305.15);
        main.put("pressure", 1005);
        main.put("humidity", 46);
        main.put("sea_level", 1005);
        main.put("grnd_level", 1003);

        // Tạo đối tượng wind
        JsonObject wind = new JsonObject();
        wind.put("speed", 1.62);
        wind.put("deg", 2);
        wind.put("gust", 3.17);

        // Tạo đối tượng clouds
        JsonObject clouds = new JsonObject();
        clouds.put("all", 98);

        // Tạo đối tượng sys
        JsonObject sys = new JsonObject();
        sys.put("type", 1);
        sys.put("id", 9308);
        sys.put("country", "VN");
        sys.put("sunrise", 1716243420L);
        sys.put("sunset", 1716290985L);

        // Tạo đối tượng chính (main object)
        JsonObject weatherData = new JsonObject();
        weatherData.put("coord", coord);
        weatherData.put("weather", weatherArray);
        weatherData.put("base", "stations");
        weatherData.put("main", main);
        weatherData.put("visibility", 10000);
        weatherData.put("wind", wind);
        weatherData.put("clouds", clouds);
        weatherData.put("dt", 1716277690L);
        weatherData.put("sys", sys);
        weatherData.put("timezone", 25200);
        weatherData.put("id", 1581130);
        weatherData.put("name", "Hanoi");
        weatherData.put("cod", 200);

        // Ghi file json
        Jsoner.serialize(weatherData, writer);

        // Sau khi ghi xong thì close dòng writer
        writer.close();
    }
}
