package com.vinicius.hotelbookingsystem.users;

import java.util.prefs.Preferences;

public class UserPreferences {

    private static final String USERNAME_KEY = "username";

    public static String getUsername() {
        try {
            Preferences prefs = Preferences.userNodeForPackage(UserPreferences.class);
            String username = prefs.get(USERNAME_KEY, "");
            System.out.println("Reading preferences [" + USERNAME_KEY + "]: " + username);
            return username;
        } catch (Exception e) {
            System.err.println("Error reading preferences: " + e.getMessage());
            return "";
        }
    }

    public static void setUsername(String username) {
        try {
            Preferences prefs = Preferences.userNodeForPackage(UserPreferences.class);
            prefs.put(USERNAME_KEY, username);
            System.out.println("Writing preferences [" + USERNAME_KEY + "]: " + username);
        } catch (Exception e) {
            System.err.println("Error writing preferences: " + e.getMessage());
        }
    }

    public static void removeUsername() {
        try {
            Preferences prefs = Preferences.userNodeForPackage(UserPreferences.class);
            prefs.remove(USERNAME_KEY);
            System.out.println("Removing preferences [" + USERNAME_KEY + "]");
        } catch (Exception e) {
            System.err.println("Error removing preferences: " + e.getMessage());
        }
    }
}
