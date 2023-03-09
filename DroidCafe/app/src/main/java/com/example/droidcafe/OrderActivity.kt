package com.example.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var userOrder: TextView
    lateinit var orderDetailsLayout: ConstraintLayout
    lateinit var spinner : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        userOrder = findViewById(
            R.id.order_textview
        )
        orderDetailsLayout = findViewById(R.id.order_details)
        spinner = findViewById(R.id.label_spinner)

        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.labels_array,android.R.layout.simple_spinner_item)

        spinner.adapter = adapter

        val order = intent.getStringExtra("order")


        if (order == "No Order!") orderDetailsLayout.visibility =
            View.GONE else orderDetailsLayout.visibility = View.VISIBLE

        userOrder.text = order
    }

    fun displayMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }

    fun onRadioButtonClicked(view: View) {
        val isChecked: Boolean = (view as RadioButton).isChecked
        when (view.id) {
            R.id.nextday -> displayMsg(getString(R.string.next_day_ground_delivery))
            R.id.sameday -> displayMsg(getString(R.string.same_day_messenger_service))
            R.id.pickup -> displayMsg(getString(R.string.pick_up))
            else -> {}
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}