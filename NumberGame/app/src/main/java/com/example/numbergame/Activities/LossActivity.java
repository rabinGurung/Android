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

public class LossActivity extends AppCompatActivity {
    TextView ltvMistakes;
    Button btnloss;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lossscreen);

        ltvMistakes = findViewById(R.id.ltvMistakes);
        btnloss = findViewById(R.id.btnloss);
        show();
        Listen();

    }

    public void Listen(){
        btnloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void show(){

        Bundle bun = getIntent().getExtras();
        ArrayList<Integer> Items = bun.getIntegerArrayList("key");

        ltvMistakes.setText("You Made "+Items.size()+" mistakes");

    }
}
