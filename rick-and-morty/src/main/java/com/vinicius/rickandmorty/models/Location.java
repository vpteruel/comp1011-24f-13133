package com.vinicius.rickandmorty.models;

import java.util.List;

public class Location {
    public int id;
    public String name;
    public String type;
    public String dimension;
    public List<String> residents;
    public String url;
    public String created;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDimension() { return dimension; }
    public void setDimension(String dimension) { this.dimension = dimension; }
    public List<String> getResidents() { return residents; }
    public void setResidents(List<String> residents) { this.residents = residents; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }

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
