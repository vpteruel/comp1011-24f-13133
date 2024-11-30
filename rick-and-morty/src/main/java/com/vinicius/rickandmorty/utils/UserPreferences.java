package com.vinicius.rickandmorty.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vinicius.rickandmorty.models.Character;

import java.util.prefs.Preferences;

public class UserPreferences {

    private final Gson gson;
    private final String CHARACTER_KEY = "character";

    public UserPreferences() {
        gson = new GsonBuilder()
                .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
                .enableComplexMapKeySerialization()
                .create();
    }

    public Character getCharacter() {
        try {
            Preferences preferences = Preferences.userNodeForPackage(UserPreferences.class);
            String json = preferences.get(CHARACTER_KEY, "");
            Character character = gson.fromJson(json, Character.class);
            System.out.println("Reading preferences [" + CHARACTER_KEY + "]: " + json);
            return character;
        } catch (Exception e) {
            System.err.println("Error reading preferences: " + e.getMessage());
            return null;
        }
    }

    public void setCharacter(Character character) {
        try {
            Preferences preferences = Preferences.userNodeForPackage(UserPreferences.class);
            String json = gson.toJson(character);
            preferences.put(CHARACTER_KEY, json);
            System.out.println("Writing preferences [" + CHARACTER_KEY + "]: " + json);
        } catch (Exception e) {
            System.err.println("Error writing preferences: " + e.getMessage());
        }
    }

    public void removeCharacter() {
        try {
            Preferences preferences = Preferences.userNodeForPackage(UserPreferences.class);
            preferences.remove(CHARACTER_KEY);
            System.out.println("Removing preferences [" + CHARACTER_KEY + "]");
        } catch (Exception e) {
            System.err.println("Error removing preferences: " + e.getMessage());
        }
    }

    public boolean hasSearchSomething() {
        Character character = getCharacter();
        boolean isEmpty = character == null || character.getName().isEmpty();
        return !isEmpty;
    }
}
