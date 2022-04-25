package ir.saharapps.sqlitesampleproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import ir.saharapps.sqlitesampleproject.models.Movie;

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
        Log.d(TAG, "insertMovie: row id is: " + rowId);
    }
}
