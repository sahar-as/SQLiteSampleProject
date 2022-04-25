package ir.saharapps.sqlitesampleproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ir.saharapps.sqlitesampleproject.R;
import ir.saharapps.sqlitesampleproject.db.ApplicationDataSource;

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
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }
}