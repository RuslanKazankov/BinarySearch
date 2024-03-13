package com.example.binarysearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        EditText edBegin = findViewById(R.id.begin);
        EditText edEnd = findViewById(R.id.end);

        String begString = edBegin.getText().toString();
        String endString = edEnd.getText().toString();
        int begin = Integer.parseInt(begString.equals("") ? "0" : begString);
        int end = Integer.parseInt(endString.equals("") ? "100" : endString);

        Intent i = new Intent(getApplicationContext(), GameActivity.class);
        i.putExtra("begin", begin);
        i.putExtra("end", end);
        startActivity(i);
    }
}