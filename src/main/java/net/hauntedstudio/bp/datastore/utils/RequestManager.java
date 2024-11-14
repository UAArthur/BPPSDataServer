package net.hauntedstudio.bp.datastore.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RequestManager {

    public static String sendPostRequest(String targetUrl, String codeValue) throws IOException {
        // Prepare URL and connection
        URL url = new URL(targetUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set request method to POST
        connection.setRequestMethod("POST");

        // Set content type for x-www-form-urlencoded
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Enable input/output streams
        connection.setDoOutput(true);

        // Prepare the data to send in the POST request body
        String urlParameters = "code=" + codeValue;

        // Send the data
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = urlParameters.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Read the response
        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        // Parse the JSON response to extract the UUID using Gson
        JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
        String uuid = jsonResponse.get("uuid").getAsString();

        // Return the UUID
        return uuid;
    }
}