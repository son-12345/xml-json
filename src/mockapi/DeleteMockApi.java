package mockapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class DeleteMockApi {
    private static final String BASE_URL = "https://6650a288ec9b4a4a6032cf91.mockapi.io/users";

    public static void delete(Scanner scanner) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        System.out.print("Enter user ID to delete: ");
        String userId = scanner.nextLine();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + userId))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());
    }
}
