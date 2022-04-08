package com.example.nestedrecyclerview12

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.nestedrecyclerview12.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding2 by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    private val textView : TextView by lazy {
        findViewById(R.id.numberText)
    }

    var spinnerData1 : String = ""
    var spinnerData2 : String = ""
    var spinnerData3 : String = ""

    var editData1 : String = ""
    var editData2 : String = ""
    var editData3 : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)
        //setContentView(R.layout.activity_main2)

        val abcd = intent.getStringExtra("abcd")
        binding2.numberText.text = abcd
        //textView.text = abcd

        val spinnerAdapter1 = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item)
        binding2.spinner1.adapter = spinnerAdapter1
        binding2.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerData1 = binding2.spinner1.getItemAtPosition(p2).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }



        binding2.btnSave.setOnClickListener {
            editData1 = binding2.editText1.text.toString()
            val intent = Intent()
            intent.putExtra("spinner1",spinnerData1)
            intent.putExtra("editdata1",editData1)
            setResult(Activity.RESULT_OK,intent)

            finish()
        }

    }

}



































