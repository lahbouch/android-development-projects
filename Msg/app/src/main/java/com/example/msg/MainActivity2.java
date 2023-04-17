package com.example.msg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView messageTextView = findViewById(R.id.textViewMessage);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("messageDeyalna");
        if (msg.length() == 0){
            msg = "no message";
        }
        messageTextView.setText(msg);


        Intent intentReturn = new Intent(this,MainActivity.class);
        messageTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentReturn);
            }
        });

    }
}