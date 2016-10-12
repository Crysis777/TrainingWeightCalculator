package com.example.trainingweightcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView rmView = (TextView) findViewById(R.id.textView3);
        TextView wView = (TextView) findViewById(R.id.textView4);
        TextView rView = (TextView) findViewById(R.id.textView5);

        Intent i = getIntent();

        String RM = i.getStringExtra("RM");
        String W = i.getStringExtra("Weight");
        String R = i.getStringExtra("Repetitions");

        rmView.setText(RM);
        wView.setText(W);
        rView.setText(R);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        menu.findItem(R.id.menu_option_reset).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_option_hilfe:
                help();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void help() {
        Intent i = new Intent(getApplicationContext(), HelpActivity.class);
        startActivity(i);
    }
}
