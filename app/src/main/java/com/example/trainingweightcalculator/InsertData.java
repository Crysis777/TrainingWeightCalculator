package com.example.trainingweightcalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class InsertData extends AppCompatActivity {

    public static final String LOGTAG = "InsertLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        Log.i(LOGTAG, "Optionsmenu was created successfully.");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_option_hilfe:
                help();
                return true;
            case R.id.menu_option_reset:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void help() {
        Intent i = new Intent(getApplicationContext(), HelpActivity.class);
        startActivity(i);
        Log.i(LOGTAG, "Help Activity was displayed.");
    }

    public void reset() {
        EditText wEdit = (EditText) findViewById(R.id.editText);
        EditText rEdit = (EditText) findViewById(R.id.editText2);

        wEdit.setText("");
        rEdit.setText("");

        Log.i(LOGTAG, "Values have been resetted.");
    }

    public void calculate(View view) {
        EditText wEdit = (EditText) findViewById(R.id.editText);
        EditText rEdit = (EditText) findViewById(R.id.editText2);

        if (wEdit.getText().length() == 0 || rEdit.getText().length() == 0) {
            Toast.makeText(this, "Please insert a value.", Toast.LENGTH_SHORT).show();
            Log.w(LOGTAG, "User did not insert a value.");
            return;
        }

        if (Integer.parseInt(wEdit.getText().toString()) <= 0 || Integer.parseInt(rEdit.getText().toString()) <= 0) {
            Toast.makeText(this, "Please only insert values greater than zero.", Toast.LENGTH_LONG).show();
            Log.w(LOGTAG, "User entered a zero value.");
            return;
        }

        if (Integer.parseInt(wEdit.getText().toString()) >= 5000 || Integer.parseInt(rEdit.getText().toString()) >= 30) {
            Toast.makeText(this, "Weight must be less than 5000, Reputation less than 30.", Toast.LENGTH_LONG).show();
            Log.w(LOGTAG, "User entered a wrong value.");
            return;
        }

        //wt. x reps x .0333 + wt.
        double RMcalc = Double.parseDouble(wEdit.getText().toString()) * Double.parseDouble(rEdit.getText().toString()) * 0.0333 + Double.parseDouble(wEdit.getText().toString());
        double RMround = Math.round(RMcalc * 100.0) / 100.0;


        Intent i = new Intent(getApplicationContext(), ResultActivity.class);

        i.putExtra("RM", String.valueOf(RMround));
        i.putExtra("Weight", String.valueOf(wEdit.getText()));
        i.putExtra("Repetitions", String.valueOf(rEdit.getText()));

        startActivity(i);

        Log.i(LOGTAG, "Calculated successfully.");
    }
}
