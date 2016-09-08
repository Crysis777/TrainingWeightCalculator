package com.example.trainingweightcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

    }

    public void calculate(View view) {
        Toast.makeText(this, "This device got toasted", Toast.LENGTH_SHORT).show();
    }
}
