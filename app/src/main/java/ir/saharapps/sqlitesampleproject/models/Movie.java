package ir.saharapps.sqlitesampleproject.models;

import java.util.List;

public class Movie {
    private String name;
    private double imdbRate;
    private String creator;
    private String description;

    public Movie(String name, double imdbRate, String creator) {
        this.name = name;
        this.imdbRate = imdbRate;
        this.creator = creator;
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

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", imdbRate=" + imdbRate +
                ", creator='" + creator + '\'' +
                '}';
    }
}
