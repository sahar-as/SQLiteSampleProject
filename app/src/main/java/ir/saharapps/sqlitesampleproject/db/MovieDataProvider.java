package ir.saharapps.sqlitesampleproject.db;

import java.util.ArrayList;
import java.util.List;

import ir.saharapps.sqlitesampleproject.models.Movie;

public class MovieDataProvider {
    public static List<Movie> moviesList;

    public MovieDataProvider() {
        moviesList= new ArrayList<>();
    }

    public void addingToList(){
        moviesList.clear();
        moviesList.add(new Movie("Turning Red", 7.0, "Domee Shi"));
        moviesList.add(new Movie("x", 2.0, "Shamsi"));
        moviesList.add(new Movie("x", 2.0, "Shamsi"));
        moviesList.add(new Movie("x", 2.0, "Shamsi"));
    }



}
