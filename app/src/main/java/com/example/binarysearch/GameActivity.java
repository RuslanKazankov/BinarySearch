package com.example.binarysearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private int begin, end;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        message = findViewById(R.id.message);

        Intent i = getIntent();
        begin = i.getIntExtra("begin", 0);
        end = i.getIntExtra("end", 100);

        if (end < begin){
            message.setText("Диапозон указан не верно!");
            hideButtons();
        }else{
            int mid = begin + (end - begin) / 2;
            message.setText("Ваше число больше чем " + mid  + " ?");
        }

    }

    public void onClick(View v){
        if (v.getId() == R.id.yesButton) {
            begin = begin + (end - begin + 1) / 2;
        } else if (v.getId() == R.id.noButton) {
            end = begin + (end - begin) / 2;
        }
        updateMessage();
    }

    private void updateMessage(){
        if (end - begin > 1){
            int mid = begin + (end - begin) / 2;
            message.setText("Ваше число больше чем " + mid  + " ?");
        }
        else if (end - begin == 1){
            message.setText("Ваше число " + end  + " ?");
        }
        else {
            message.setText("Ваше число " + begin  + " !");
            hideButtons();
        }
    }

    private void hideButtons(){
        Button yesB = findViewById(R.id.yesButton);
        yesB.setVisibility(View.GONE);;
        Button noB = findViewById(R.id.noButton);
        noB.setVisibility(View.GONE);
    }

    public void onBack(View view) {
        finish();
    }
}