package com.example.numbergame.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.numbergame.MainActivity;
import com.example.numbergame.R;

import java.util.ArrayList;

public class WinActivity extends AppCompatActivity {
    TextView wtvMistakes;
    Button btnPlayAgain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winscreen);
        wtvMistakes = findViewById(R.id.wtvMistakes);
        btnPlayAgain = findViewById(R.id.btnwin);
        showView();
        Listen();


    }


    public void Listen(){
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void showView(){
        Bundle bun = getIntent().getExtras();
        ArrayList<Integer> Items = bun.getIntegerArrayList("key");
        if(Items.size() == 0){
            wtvMistakes.setText("You Made no Mistake");
        }else{
            wtvMistakes.setText("You Made "+Items.size()+" mistakes");
        }

    }


}
