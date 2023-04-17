package com.example.msg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText message = findViewById(R.id.editTextMessage);
        Button btn = findViewById(R.id.buttonSendMsg);

        Intent intent = new Intent(this,MainActivity2.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("messageDeyalna",message.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:drobix@gmail.com"));
                startActivity(intent);
            }
        });



    }
}