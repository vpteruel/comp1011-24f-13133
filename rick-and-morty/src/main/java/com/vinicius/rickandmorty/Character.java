package com.vinicius.rickandmorty;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.List;

public class Character extends ApiEntity {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    // Constructor
    public Character() {
        super("https://rickandmortyapi.com/api/character");
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }

    public String getStatus() { return status; }
    public String getSpecies() { return species; }
    public String getType() { return type; }
    public String getGender() { return gender; }
    public Location getOrigin() { return origin; }
    public Location getLocation() { return location; }
    public String getImage() { return image; }
    public List<String> getEpisode() { return episode; }
    public String getUrl() { return url; }
    public String getCreated() { return created; }

    @Override
    protected ApiEntity fromJson(JsonElement element, Gson gson) {
        return gson.fromJson(element, Character.class);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", origin=" + origin +
                ", location=" + location +
                ", image='" + image + '\'' +
                ", episode=" + episode +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
