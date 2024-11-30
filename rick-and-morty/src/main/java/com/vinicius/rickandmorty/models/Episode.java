package com.vinicius.rickandmorty.models;

import java.util.List;

public class Episode {
    public int id;
    public String name;
    public String airDate;
    public String episode;
    public List<String> characters;
    public String url;
    public String created;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAirDate() { return airDate; }
    public void setAirDate(String type) { this.airDate = airDate; }
    public String getEpisode() { return episode; }
    public void setEpisode(String episode) { this.episode = episode; }
    public List<String> getCharacters() { return characters; }
    public void setCharacters(List<String> characters) { this.characters = characters; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", airDate='" + airDate + '\'' +
                ", episode='" + episode + '\'' +
                ", characters=" + characters +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
