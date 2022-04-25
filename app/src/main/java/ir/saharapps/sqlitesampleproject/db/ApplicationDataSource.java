package ir.saharapps.sqlitesampleproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import ir.saharapps.sqlitesampleproject.models.Movie;
import ir.saharapps.sqlitesampleproject.models.MovieDescription;

public class ApplicationDataSource {
    private static final String TAG = "ApplicationDataSource";

    private SQLiteDatabase mDatabase;
    private DatabaseSQLiteOpenHelper dbHelper;

    public ApplicationDataSource(Context context) {
        this.dbHelper = new DatabaseSQLiteOpenHelper(context);
    }

    public void open(){
        mDatabase = dbHelper.getWritableDatabase();
        Log.d(TAG, "create: db is opened");
    }

    public void close(){
        dbHelper.close();
        Log.d(TAG, "close: db is closed");
    }

    public void insertMovie(Movie movie){
        ContentValues value = new ContentValues();
        value.put(dbContract.movieEntry.COLUMN_NAME , movie.getName());
        value.put(dbContract.movieEntry.COLUMN_IMDB_RATE , movie.getImdbRate());
        value.put(dbContract.movieEntry.COLUMN_CREATOR , movie.getCreator());

        long rowId = mDatabase.insert(dbContract.movieEntry.TABLE_NAME, null, value);
        Log.d(TAG, "insertMovie: 11111111111111: " + rowId);

        List<MovieDescription> movieDescriptionList = movie.getDescription();
        if(movieDescriptionList != null && movieDescriptionList.size()>0){
            for(MovieDescription md: movieDescriptionList){
                insertDescription(md,rowId);
            }
        }

    }

    public void insertDescription(MovieDescription movieDescription, long movieId){
        ContentValues value = new ContentValues();
        value.put(dbContract.descriptionEntry.COLUMN_MOVIE_ID, movieId);
        value.put(dbContract.descriptionEntry.COLUMN_DESCRIPTION , movieDescription.getDescription());

        long rowId = mDatabase.insert(dbContract.descriptionEntry.TABLE_NAME, null, value);
        Log.d(TAG, "insertMovie: 1111111111111111: " + rowId);
    }
}
