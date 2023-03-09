package com.example.randomimg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randomimg.databinding.ActivityMainBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Picasso.get()
            .load("https://picsum.photos/200/300")
            .into(binding.ivMain);
        binding.btnGetImg.setOnClickListener {
           getImg()
    }

        }


fun getImg(){
    Picasso.get()
        .load("https://picsum.photos/200/300")
        .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
        .placeholder(R.drawable.loading)
        .error(R.drawable.no)
        .into(binding.ivMain)
}
}