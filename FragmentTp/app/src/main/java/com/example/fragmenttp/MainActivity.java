package com.example.fragmenttp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button frg1 = findViewById(R.id.btnFrgOne);
        Button frg2 = findViewById(R.id.btnFrgTwo);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentBoss,new FirstFragment()).commit();


        SecondFragment fragment2 = new SecondFragment();
        FirstFragment fragment1 = new FirstFragment();

        getSupportFragmentManager().setFragmentResultListener("msg", this, new FragmentResultListener() {
        @Override
        public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
            fragment2.setArguments(result);
        }
    });





        frg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentBoss,fragment1).commit();
            }
        });

        frg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentBoss,fragment2).commit();
            }
        });



    }
}