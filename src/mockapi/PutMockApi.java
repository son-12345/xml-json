package mockapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Scanner;

public class PutMockApi {
    private static final String BASE_URL = "https://6650a288ec9b4a4a6032cf91.mockapi.io/users";

    public static void put(Scanner scanner) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        System.out.print("Enter user ID to update: ");
        String userId = scanner.nextLine();
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        String json = String.format("{\"name\": \"%s\", \"email\": \"%s\"}", name, email);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + userId))
                .header("Content-Type", "application/json")
                .PUT(BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());
    }
}
