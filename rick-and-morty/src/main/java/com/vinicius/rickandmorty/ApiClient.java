package com.vinicius.rickandmorty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ApiClient {
    private final Gson gson;
    private final String mockCharacterJsonPath = "/com/vinicius/rickandmorty/json/character.json";
    private final String mockEpisodeJsonPath = "/com/vinicius/rickandmorty/json/episode.json";
    private final String mockLocationJsonPath = "/com/vinicius/rickandmorty/json/location.json";

    public ApiClient() {
        this(false);
    }

    public ApiClient(boolean useMock) {
        // Configure Gson for better handling of JSON
        this.gson = new GsonBuilder()
                .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
                .enableComplexMapKeySerialization()
                .create();
    }

    public String fetchJson(String apiUrl) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestProperty("Accept", "application/json");

        // Read the response
        StringBuilder response = new StringBuilder();
        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

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

    public List<Character> getAllCharacters() {
        try (InputStream inputStream = ApiClient.class.getResourceAsStream(mockCharacterJsonPath);
             InputStreamReader reader = new InputStreamReader(inputStream)) {

            // Check if the file exists in the resources
            if (inputStream == null) {
                throw new IOException("Mock JSON file not found at " + mockCharacterJsonPath);
            }

            // Parse the JSON using Gson to get the "results" array
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(reader, JsonObject.class);
            JsonArray results = jsonResponse.getAsJsonArray("results");

            // Convert the "results" array into a list of Character objects
            Type listType = new TypeToken<List<Character>>() {}.getType();
            return gson.fromJson(results, listType);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Character> getByName(String name) {
        List<Character> allCharacters = new ArrayList<>();
        String url = "https://rickandmortyapi.com/api/character/?name=" + URLEncoder.encode(name, StandardCharsets.UTF_8);;

        try {
            String json = fetchJson(url);
            List<Character> characters = convertToCharacterList(json);
            allCharacters.addAll(characters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allCharacters.stream().findFirst();
    }
}
