package com.lahbouch.infoscities.view

import android.app.Notification.Action
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.viewModel.CityViewModel
import org.w3c.dom.Text

class FullDesc : AppCompatActivity()  {


    lateinit var infoDesc : TextView
    lateinit var btnWebsite : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_desc)



        supportActionBar?.apply {
            setBackgroundDrawable(ColorDrawable(getColor(R.color.black)))
            setElevation(0F)
            title = "plus d'info"
    }



        val cityFullDesc = getIntent().getIntExtra("fullDesc",0)
        val cityWebsite = getIntent().getIntExtra("website",0)


        infoDesc = findViewById(R.id.infoDesc)
        btnWebsite = findViewById(R.id.btnWebSite)




        infoDesc.text = getString(cityFullDesc)
        btnWebsite.setOnClickListener {
            val url = Uri.parse(getString(cityWebsite))
            val intent = Intent(Intent.ACTION_VIEW,url)
            startActivity(intent)
        }







}


}