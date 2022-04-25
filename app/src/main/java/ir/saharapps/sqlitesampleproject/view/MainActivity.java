package ir.saharapps.sqlitesampleproject.view;

//Design and implemented by Sahar Asadian
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import ir.saharapps.sqlitesampleproject.R;
import ir.saharapps.sqlitesampleproject.db.ApplicationDataSource;
import ir.saharapps.sqlitesampleproject.models.Movie;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ApplicationDataSource mDataSource;
    List<Movie> movies;
    private MovieAdapter adapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_MainActivity_recycler);

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
        movies = mDataSource.getAllMovies();

        adapter = new MovieAdapter(movies,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }
    //Design and implemented by Sahar Asadian

}