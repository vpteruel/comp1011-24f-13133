package com.vinicius.rickandmorty;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.List;

public class Location extends ApiEntity {
    private int id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private String created;

    // Constructor
    public Location() {
        super("https://rickandmortyapi.com/api/location");
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getDimension() { return dimension; }
    public List<String> getResidents() { return residents; }
    public String getUrl() { return url; }
    public String getCreated() { return created; }

    @Override
    protected ApiEntity fromJson(JsonElement element, Gson gson) {
        return gson.fromJson(element, Location.class);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dimension='" + dimension + '\'' +
                ", residents=" + residents +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
