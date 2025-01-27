// Simple REST API Client in Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiClient {
    public static void main(String[] args) {
        try {
            // Define the API URL (Example: JSONPlaceholder API for sample data)
            String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set request headers if needed
            connection.setRequestProperty("Accept", "application/json");

            // Check the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) { // Success
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                reader.close();

                // Print the response
                System.out.println("Response from API:");
                System.out.println(response.toString());
            } else {
                System.out.println("Failed to connect. HTTP Response Code: " + responseCode);
            }

            // Disconnect the connection
            connection.disconnect();

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
