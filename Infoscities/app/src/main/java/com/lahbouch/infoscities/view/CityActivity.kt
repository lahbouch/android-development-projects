package com.lahbouch.infoscities.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.adapters.CityAdapter
import com.lahbouch.infoscities.model.Country
import com.lahbouch.infoscities.viewModel.CityViewModel

class CityActivity : AppCompatActivity() , Contracts.CityContract {

    lateinit var viewPager : ViewPager2
    lateinit var err_layout : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
supportActionBar?.apply {
    setBackgroundDrawable(ColorDrawable(getColor(R.color.black)))
    setElevation(0F)
}
        viewPager = findViewById(R.id.cityViewPager)
        err_layout = findViewById(R.id.errorLayout)
        val country_name = intent.getStringExtra("contry")
        supportActionBar?.title = country_name
        val vm = CityViewModel(this)
        if (country_name != null) {
            vm.onStart(country_name)
        }





    }

    override fun bindViewPager(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
        viewPager.adapter = adapter
    }

    override fun showErrorLayout() {
        err_layout.visibility = View.VISIBLE
    }

    override fun HideErrorLayout() {
        err_layout.visibility = View.GONE
    }
}