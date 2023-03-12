package com.example.eventsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.eventsdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener,
    TextWatcher, View.OnKeyListener {
    lateinit var holder: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        holder = ActivityMainBinding.inflate(layoutInflater)

        setContentView(holder.root)

        //onClick events

//        holder.btn1.setOnClickListener {
//            Toast.makeText(this, "btn1 clicked", Toast.LENGTH_SHORT).show()
//        }

        holder.btn1.setOnClickListener(this)
        holder.btn1.setOnLongClickListener(this)

        //Text Changed Events

//        holder.et1.addTextChangedListener(this)
        holder.et1.addTextChangedListener {
            Toast.makeText(this, "Current text : ${it.toString()}", Toast.LENGTH_SHORT).show()
        }

        //menu select item
        holder.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if (position == 0) {
                    onNothingSelected(parent)
                    return
                }

                Toast.makeText(
                    parent?.context,
                    holder.spinner.selectedItem.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(parent?.context, "noting selected", Toast.LENGTH_SHORT).show()
            }

        }

        //key press
        holder.btn1.setOnKeyListener(this)

        //focus
        holder.btn1.setOnFocusChangeListener { v, hasFocus ->
    //            if (hasFocus) {
    //                Toast.makeText(this, "write your first Name", Toast.LENGTH_SHORT).show()
    //            }
            if (!hasFocus) {
                Toast.makeText(this, "By", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(v: View?) {
        Toast.makeText(this, "btn1 clicked", Toast.LENGTH_SHORT).show()


    }

//    override fun onKeyMultiple(keyCode: Int, repeatCount: Int, event: KeyEvent?): Boolean {
//        Toast.makeText(this, "salam", Toast.LENGTH_SHORT).show()
//        return true
//    }

    override fun onLongClick(v: View?): Boolean {
        Toast.makeText(this, "btn1 long Clicked", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Toast.makeText(this, "$s start : $start before: $before count: $count", Toast.LENGTH_SHORT)
            .show()
    }

    override fun afterTextChanged(s: Editable?) {

    }

    var i = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && i == 0) {
            i++;
            Toast.makeText(this, "clicker deux fois pour exit!", Toast.LENGTH_SHORT).show()
            return true

        } else {
            i = 0
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {

//            Toast.makeText(this, "${event.toString()}", Toast.LENGTH_SHORT).show()
            holder.btn1.performClick()

        }

        if (keyCode == KeyEvent.KEYCODE_SPACE) {
            holder.et1.requestFocus()
        }

        if (keyCode == KeyEvent.KEYCODE_O) {
            holder.btn1.performClick()
        }
        return true
    }
}