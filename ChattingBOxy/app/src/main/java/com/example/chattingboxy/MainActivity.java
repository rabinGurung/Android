package com.example.chattingboxy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etFirst;
    Button btnSub;
    Palaindrome palaindrome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirst = findViewById(R.id.eTFirst);
        btnSub = findViewById(R.id.btnSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etFirst.getText().toString())){
                    etFirst.setError("Please Enter number");
                    return;
                }
                DoSomething(etFirst.getText().toString());
            }
        });

    }

    public void DoSomething(String number){
        palaindrome = new Palaindrome();
        palaindrome.setNumber(Integer.parseInt(number));
        int rev = palaindrome.getReverse();
        String message = palaindrome.checkPalaindrome(rev);
        Intender(message);
    }

    public void Intender( String message){
        Intent i = new Intent(getApplicationContext(),AnotherActivity.class);
        i.putExtra("message",message);
        startActivity(i);
    }
}
