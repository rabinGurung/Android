package com.example.chattingboxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotherlayout);

        tv = findViewById(R.id.tV);
        Bundle bun = getIntent().getExtras();
        String message = bun.getString("message");

        if(message.equals("true")){
            tv.setText("The given number is a palaindrome");
        }else{
            tv.setText("The given number is not a palaindrome");
        }



    }
}
