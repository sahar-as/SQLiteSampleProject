package ir.saharapps.sqlitesampleproject.db;

import android.provider.BaseColumns;

public class dbContract {

    public static class movieEntry implements BaseColumns{
        public static final String TABLE_NAME = "movie";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMDB_RATE = "imdb";
        public static final String COLUMN_CREATOR = "creator";
    }

    public static class descriptionEntry implements BaseColumns{
        public static final String TABLE_NAME = "descriptions";
        public static final String COLUMN_description = "description";
    }
}
