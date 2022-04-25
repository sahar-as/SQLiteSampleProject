package ir.saharapps.sqlitesampleproject.db;

import android.provider.BaseColumns;

import ir.saharapps.sqlitesampleproject.models.Movie;

public class dbContract {

    public static final String CREATE_MOVIE_TABLE =
            "CREATE TABLE " + movieEntry.TABLE_NAME + " ( " +
                    movieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    movieEntry.COLUMN_NAME + " TEXT NOT NULL " +
                    movieEntry.COLUMN_IMDB_RATE + " REAL NOT NULL " +
                    movieEntry.COLUMN_CREATOR + " TEXT NOT NULL " +
                    "UNIQUE ( " + movieEntry._ID + " ) ON CONFLICT REPLACE )";

    public static final String CREATE_DESCRIPTIONS_TABLE =
            "CREATE TABLE " + descriptionEntry.TABLE_NAME + " ( " +
                    descriptionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    descriptionEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL REFERENCES " +
                    movieEntry._ID + ", " +
                    descriptionEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL " +
                    "UNIQUE ( " + descriptionEntry._ID + " ) ON CONFLICT REPLACE )"; //This is an standard way of handling duplicate id insertions

    public static class movieEntry implements BaseColumns{
        public static final String TABLE_NAME = "movie";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMDB_RATE = "imdb";
        public static final String COLUMN_CREATOR = "creator";
    }

    public static class descriptionEntry implements BaseColumns{
        public static final String TABLE_NAME = "descriptions";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_DESCRIPTION = "movie_description";
    }
}
