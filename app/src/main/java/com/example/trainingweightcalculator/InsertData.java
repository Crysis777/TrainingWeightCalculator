package com.example.trainingweightcalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

    }

    public void calculate(View view) {
        EditText wEdit  = (EditText)findViewById(R.id.editText);
        EditText rEdit  = (EditText)findViewById(R.id.editText2);

        if(wEdit.getText().length() == 0 || rEdit.getText().length() == 0) {
            Toast.makeText(this, "Please insert a value.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(Integer.parseInt(wEdit.getText().toString()) <= 0 || Integer.parseInt(rEdit.getText().toString()) <= 0){
            Toast.makeText(this, "Please only insert values greater than zero.", Toast.LENGTH_LONG).show();
            return;
        }

        if(Integer.parseInt(wEdit.getText().toString()) >= 5000 || Integer.parseInt(rEdit.getText().toString()) >= 30){
            Toast.makeText(this, "Weight must be less than 5000, Reputation less than 30.", Toast.LENGTH_LONG).show();
            return;
        }

        //wt. x reps x .0333 + wt.
        double RMcalc = Double.parseDouble(wEdit.getText().toString()) * Double.parseDouble(rEdit.getText().toString()) * 0.0333 + Double.parseDouble(wEdit.getText().toString());
        double RMround = Math.round(RMcalc * 100.0) / 100.0;


        Intent i = new Intent(getApplicationContext(), ResultActivity.class);

        i.putExtra("RM", String.valueOf(RMround));

        startActivity(i);
    }
}
