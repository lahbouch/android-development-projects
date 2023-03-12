package com.example.whowroteit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.asynctaskloaderdemo.R

class MainActivity : AppCompatActivity() {
    private lateinit var mBookInput: EditText
    private lateinit var mTitleText: TextView
    private lateinit var mAuteurText: TextView
    private lateinit var mSearchBtn: Button
    private lateinit var mThumbnailImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBookInput = findViewById(R.id.bookInput)
        mTitleText = findViewById(R.id.titleText)
        mAuteurText = findViewById(R.id.authorText)
        mSearchBtn = findViewById(R.id.searchButton)
        mThumbnailImg = findViewById(R.id.thumbnail)

        mSearchBtn.setOnClickListener {
            searchBooks()
        }

    }

    private fun searchBooks() {
        val q = mBookInput.text.toString()
        if (q.isEmpty()){
            Toast.makeText(this, "enter a book name", Toast.LENGTH_SHORT).show()
            return
        }
        FetchBook(mTitleText,mAuteurText,mThumbnailImg).execute(q)
    }
}