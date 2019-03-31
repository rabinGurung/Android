package com.example.numbergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.numbergame.Activities.LossActivity;
import com.example.numbergame.Activities.WinActivity;
import com.example.numbergame.Controller.Controller;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Controller cont;
    Button btnFirst;
    Button btnSecond;
    TextView tv;
    TextView tvTurn;
    TextView tvMistakes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        tv = findViewById(R.id.tv);
        tvTurn = findViewById(R.id.tvTurns);
        tvMistakes = findViewById(R.id.tvMistakes);
        cont = new Controller(this,btnFirst,btnSecond);

    }

    public void setValue(int first, int second){
        btnFirst.setText(Integer.toString(first));
        btnSecond.setText(Integer.toString(second));
    }



    public void setTvTurn(int num){
        tvTurn.setText("Turns:"+Integer.toString(num));
    }

    public void setTvMistakes(int num){
        tvMistakes.setText("Mistakes:"+Integer.toString(num));
    }

    public void setTV(int score){
        tv.setText("Score:"+Integer.toString(score));
    }

    public int getFirst(){
        return Integer.parseInt(btnFirst.getText().toString());
    }

    public int getSecond(){
        return Integer.parseInt(btnSecond.getText().toString());
    }

    public void Intender(Boolean i,ArrayList<Integer> mistakesValue){
        if(i){
            Intent in =  new Intent(getApplicationContext(), WinActivity.class);
            in.putExtra("key",mistakesValue);
            startActivity(in);
            return;
        }
        Intent ins = new Intent(getApplicationContext(), LossActivity.class);
        ins.putExtra("key",mistakesValue);
        startActivity(ins);
    }
}
