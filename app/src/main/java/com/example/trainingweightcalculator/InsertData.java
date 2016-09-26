package com.example.trainingweightcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class InsertData extends AppCompatActivity {
    static EditText s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        s = (EditText)findViewById(R.id.editTextWeight);

        getTextFromEditText();
    }

    static private void getTextFromEditText() {
        System.out.println(s.getText().toString());
    }
}
