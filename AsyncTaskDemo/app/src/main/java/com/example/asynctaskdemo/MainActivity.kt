package com.example.asynctaskdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tv : TextView
    lateinit var btn : Button
    lateinit var pb : ProgressBar
    private val TEXT = "currentText"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textview1)
        btn = findViewById(R.id.button)
        pb = findViewById(R.id.progressBar)

    }

    fun startTask(view: View) {
        tv.text = getString(R.string.napping)
        val asyncTask = SimpleAsyncTask(tv,pb).execute()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT,tv.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState != null){
            tv.text = savedInstanceState.getString(TEXT)
        }
    }

}