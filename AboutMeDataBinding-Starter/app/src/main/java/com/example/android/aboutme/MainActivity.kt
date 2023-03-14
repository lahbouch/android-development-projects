/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.myName = myName
        val a  : MutableList<String>
        binding.doneButton.setOnClickListener {
            addNickname()
        }
    }

    /** Click handler for the Done button. */
    private fun addNickname() {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)
    }
}
