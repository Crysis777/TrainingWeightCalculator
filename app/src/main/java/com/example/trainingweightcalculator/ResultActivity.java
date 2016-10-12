package com.example.trainingweightcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtRM = (TextView) findViewById(R.id.textView3);

        Intent i = getIntent();

        String RM = i.getStringExtra("RM");
        Log.e("Result Activity", RM);


        txtRM.setText(RM);

    }
}
