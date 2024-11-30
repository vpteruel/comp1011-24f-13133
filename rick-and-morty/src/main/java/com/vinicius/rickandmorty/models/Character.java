package com.vinicius.rickandmorty.models;

import java.util.List;

public class Character {
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Location origin;
    public Location location;
    public String image;
    public List<String> episode;
    public String url;
    public String created;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Location getOrigin() { return origin; }
    public void setOrigin(Location origin) { this.origin = origin; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public List<String> getEpisode() { return episode; }
    public void setEpisode(List<String> episode) { this.episode = episode; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }

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
