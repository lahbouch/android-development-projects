package com.example.recycleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var nationalities: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nationalities = resources.getStringArray(R.array.nationalites)
        val nationalitesAdapter: ArrayAdapter<CharSequence> =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nationalities)
        binding.spinner.adapter = nationalitesAdapter

        binding.spinner.onItemSelectedListener =
            object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
                override fun onItemClick(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {


                }

                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    Toast.makeText(
                        parent?.context, "${nationalities[position]} selected", Toast.LENGTH_SHORT
                    ).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(parent?.context, "noting Clicked", Toast.LENGTH_SHORT).show()
                }

            }

        val persons = mutableListOf(
            Person("abdelhamid", "MALE", "Morocco"),
            Person("abdelhamid", "MALE", "Morocco"),
            Person("abdelhamid", "MALE", "Morocco")
        )
        val pAdapter = PersonAdapter(
            persons
        )

        binding.rv.adapter = pAdapter


        binding.button.setOnClickListener {
            val pFName = binding.etFirstName.text.toString()
            val pLName = binding.etLastName.text.toString()
            val pGENDER =
                findViewById<RadioButton>(binding.rbGroup.checkedRadioButtonId).text.toString()
            val pNationalite = nationalities[binding.spinner.selectedItemPosition]

            val p = Person("$pFName $pLName", pGENDER, pNationalite)
            persons.add(p)

            pAdapter.notifyDataSetChanged()

        }



    }


}