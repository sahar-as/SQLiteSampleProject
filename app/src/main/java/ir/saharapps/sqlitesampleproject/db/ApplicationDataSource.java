package ir.saharapps.sqlitesampleproject.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ir.saharapps.sqlitesampleproject.models.Movie;
import ir.saharapps.sqlitesampleproject.models.MovieDescription;

//Design and implemented by Sahar Asadian

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
        value.put(dbContract.movieEntry.COLUMN_IMAGE, movie.getImageUrl());

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

    @SuppressLint("Range")
    public List<Movie> getAllMovies(){
        Log.d(TAG, "getAllMovies: 22222222222222");
        List<Movie> movieList = new ArrayList<>();
        String select_query = "SELECT * FROM " + dbContract.movieEntry.TABLE_NAME;
        Cursor cursor = mDatabase.rawQuery(select_query,null);
        try{
            Log.d(TAG, "getAllMovies: 33333333333333 ");
            while (cursor.moveToNext()){
                Log.d(TAG, "getAllMovies: 444444444444444");
                Movie movie = new Movie(
                        cursor.getString(cursor.getColumnIndex(dbContract.movieEntry.COLUMN_NAME)),
                        cursor.getDouble(cursor.getColumnIndex(dbContract.movieEntry.COLUMN_IMDB_RATE)),
                        cursor.getString(cursor.getColumnIndex(dbContract.movieEntry.COLUMN_CREATOR)),
                        cursor.getInt(cursor.getColumnIndex(dbContract.movieEntry.COLUMN_IMAGE))

                );
                movie.setId(cursor.getLong(cursor.getColumnIndex(dbContract.movieEntry._ID)));
                movieList.add(movie);
                Log.d(TAG, "getAllMovies: 1111111111 " + movie);
            }
        }finally {
            if(cursor!= null && !cursor.isClosed()){
                cursor.close();
            }
        }
        return movieList;
    }


    public void updateMovie(Movie movie) {
        ContentValues value = new ContentValues();
        value.put(dbContract.movieEntry.COLUMN_NAME, movie.getName());
        value.put(dbContract.movieEntry.COLUMN_IMDB_RATE, movie.getImdbRate());
        value.put(dbContract.movieEntry.COLUMN_CREATOR, movie.getCreator());
        value.put(dbContract.movieEntry.COLUMN_IMAGE, movie.getImageUrl());

        String selection =  dbContract.movieEntry._ID + " = ?";
        String[] selectionArgs = {String.valueOf(movie.getId())};

        int count = mDatabase.update(dbContract.movieEntry.TABLE_NAME, value, selection, selectionArgs);
        Log.d(TAG, "number of updated rows: 11111111111111: " + count);
    }

    public void deleteMovie(Movie movie) {
        String selection =  dbContract.movieEntry._ID + " = ?";
        String[] selectionArgs = {String.valueOf(movie.getId())};

        int count = mDatabase.delete(dbContract.movieEntry.TABLE_NAME, selection, selectionArgs);
        Log.d(TAG, "number of deleted rows: 11111111111111: " + count);
    }
}
