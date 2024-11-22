package com.vinicius.rickandmorty;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.*;

public abstract class ApiEntity {
    private final String apiUrl;

    public ApiEntity(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    // Method to fetch all entities (Characters or Locations)
    public List<? extends ApiEntity> getAll() {
        List<ApiEntity> entities = new ArrayList<>();
        String url = apiUrl;

        try {
            while (url != null) {
                // Make the API request
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Accept", "application/json");

                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON response
                JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
                JsonArray results = jsonResponse.getAsJsonArray("results");

                // Deserialize the JSON array into the appropriate objects
                Gson gson = new Gson();
                for (JsonElement element : results) {
                    ApiEntity entity = fromJson(element, gson);
                    if (entity != null) {
                        entities.add(entity);
                    }
                }

                // Get the next page URL if available
                url = jsonResponse.getAsJsonObject("info").has("next") ? jsonResponse.getAsJsonObject("info").get("next").getAsString() : null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    // Abstract method to convert JSON element into the appropriate object type (Character, Location)
    protected abstract ApiEntity fromJson(JsonElement element, Gson gson);
}

