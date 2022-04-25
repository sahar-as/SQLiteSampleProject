package ir.saharapps.sqlitesampleproject.models;

import java.util.List;

public class Movie {
    private String name;
    private double imdbRate;
    private String creator;
    private int imageUrl;
    private List<MovieDescription> description;

    public Movie(String name, double imdbRate, String creator, int imageUrl) {
        this.name = name;
        this.imdbRate = imdbRate;
        this.creator = creator;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImdbRate() {
        return imdbRate;
    }

    public void setImdbRate(double imdbRate) {
        this.imdbRate = imdbRate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<MovieDescription> getDescription() {
        return description;
    }

    public void setDescription(List<MovieDescription> description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", imdbRate=" + imdbRate +
                ", creator='" + creator + '\'' +
                '}';
    }
}
