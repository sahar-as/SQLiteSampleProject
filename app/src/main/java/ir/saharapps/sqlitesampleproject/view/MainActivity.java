package ir.saharapps.sqlitesampleproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ir.saharapps.sqlitesampleproject.R;
import ir.saharapps.sqlitesampleproject.db.ApplicationDataSource;
import ir.saharapps.sqlitesampleproject.db.MovieDataProvider;
import ir.saharapps.sqlitesampleproject.models.Movie;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ApplicationDataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataSource = new ApplicationDataSource(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
        //just for first time to insert data to the tables
//        MovieDataProvider movieDataProvider = new MovieDataProvider();
//        for(Movie movie : movieDataProvider.moviesList){
//            mDataSource.insertMovie(movie);
//        }
        mDataSource.getAllMovies();

        //Getting all movie data update and delete method:
//        List<Movie> movies = mDataSource.getAllMovies();
//        Movie movie = movies.get(0);
//        movie.setName("Turning Red");
//        mDataSource.updateMovie(movie);
//        mDataSource.getAllMovies();
//        mDataSource.deleteMovie(movie);
//        mDataSource.getAllMovies();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }
}