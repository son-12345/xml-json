package exam2;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OpenWeatherMapAPI {

    private static final String API_KEY = "ee104aaadde22dfc94bbfa77eefb8ab0";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the city name: ");
        String cityName = scanner.nextLine().trim();
        if (cityName.isEmpty()) {
            System.out.println("City name cannot be empty. Please enter a valid city name.");
        } else {
            getCurrentWeather(cityName);
        }
    }

    public static void getCurrentWeather(String cityName) {
        try {
            // Create URL with query parameters
            String urlString = String.format("%s?q=%s&appid=%s&units=metric", BASE_URL, cityName, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON from the response
                JsonObject jsonResponse = (JsonObject) Jsoner.deserialize(response.toString(), new JsonObject());

                // Get weather description
                JsonArray weatherArray = (JsonArray) jsonResponse.get("weather");
                JsonObject weatherObject = (JsonObject) weatherArray.get(0);
                String weatherDescription = (String) weatherObject.get("description");

                // Get other weather information
                JsonObject mainObject = (JsonObject) jsonResponse.get("main");
                double temp = ((Number) mainObject.get("temp")).doubleValue();
                int humidity = ((Number) mainObject.get("humidity")).intValue();

                JsonObject windObject = (JsonObject) jsonResponse.get("wind");
                double windSpeed = ((Number) windObject.get("speed")).doubleValue();

                // Display weather information
                System.out.println("Weather in " + cityName + ":");
                System.out.println("Description: " + weatherDescription);
                System.out.println("Temperature: " + temp + "°C");
                System.out.println("Humidity: " + humidity + "%");
                System.out.println("Wind Speed: " + windSpeed + " m/s");
            } else {
                System.out.println("Failed to get weather data: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while fetching the weather data.");
            e.printStackTrace();
        }
    }
}
