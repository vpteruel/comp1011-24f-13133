package com.vinicius.rickandmorty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiUtility {
    private final Gson gson;

    public ApiUtility() {
        // Configure Gson for better handling of JSON
        this.gson = new GsonBuilder()
                .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
                .enableComplexMapKeySerialization()
                .create();
    }

    public String fetchJson(String apiUrl) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");
//        connection.setConnectTimeout(5000);
//        connection.setReadTimeout(5000);
        connection.setRequestProperty("Accept", "application/json");

        // Read the response
        StringBuilder response = new StringBuilder();
        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        StringBuilder response = new StringBuilder();
//        String inputLine;
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
        return response.toString();
    }

    public List<Character> convertToCharacterList(String json) {
        List<Character> characters = new ArrayList<>();
        JsonObject jsonResponse = JsonParser.parseString(json).getAsJsonObject();
        JsonArray results = jsonResponse.getAsJsonArray("results");

        for (JsonElement element : results) {
            Character character = gson.fromJson(element, Character.class);
            characters.add(character);
        }

        return characters;
    }

    public List<Character> getAllCharacters(String apiUrl) {
        List<Character> allCharacters = new ArrayList<>();
        String url = apiUrl;

        try {
//            while (url != null) {
                // Fetch JSON from the API
                String json = fetchJson(url);

                // Convert JSON to Character objects and add to the list
                List<Character> characters = convertToCharacterList(json);
                allCharacters.addAll(characters);

                // Determine the next page URL
//                JsonObject jsonResponse = JsonParser.parseString(json).getAsJsonObject();
//                url = jsonResponse.getAsJsonObject("info").has("next")
//                        ? jsonResponse.getAsJsonObject("info").get("next").getAsString()
//                        : null;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allCharacters;
    }
}
