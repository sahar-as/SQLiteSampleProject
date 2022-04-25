package ir.saharapps.sqlitesampleproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "movie_info.db";
    public static final int VERSION_NUMBER = 1;

    public DatabaseSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dbContract.CREATE_MOVIE_TABLE);
        db.execSQL(dbContract.CREATE_DESCRIPTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
