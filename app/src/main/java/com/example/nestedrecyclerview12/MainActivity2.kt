package com.example.nestedrecyclerview12

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.nestedrecyclerview12.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding2 by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    private val textView : TextView by lazy {
        findViewById(R.id.numberText)
    }

    var spinnerData1 : String = ""
    //var spinnerData1 = StringBuffer()
    var spinnerData2 : String = ""
    var spinnerData3 : String = ""
    var spinnerData4 : String = ""
    var spinnerData5 : String = ""
    var spinnerData6 : String = ""

    //var editData1 : String = ""
    var editData1 = StringBuffer()
    var editData2 : String = ""
    var editData3 : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)
        //setContentView(R.layout.activity_main2)

        val abcd = intent.getStringExtra("abcd")
        binding2.numberText.text = abcd

        val roomSize = intent.getIntExtra("roomsize",0)
        Toast.makeText(this,"$roomSize",Toast.LENGTH_SHORT).show()

        val spinnerAdapter1 = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item)
        binding2.spinner1.adapter = spinnerAdapter1
        binding2.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerData1 = binding2.spinner1.getItemAtPosition(p2).toString()
                //spinnerData1.append(binding2.spinner1.getItemAtPosition(p2).toString())
                Log.d("asdf main2", binding2.spinner1.getItemAtPosition(p2).toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val spinnerAdapter2 = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item)
        binding2.spinner2.adapter = spinnerAdapter2
        binding2.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerData2 = binding2.spinner2.getItemAtPosition(p2).toString()
                Log.d("asdf main2", binding2.spinner2.getItemAtPosition(p2).toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val spinnerAdapter3 = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item)
        binding2.spinner3.adapter = spinnerAdapter3
        binding2.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerData3 = binding2.spinner3.getItemAtPosition(p2).toString()
                Log.d("asdf main2", binding2.spinner3.getItemAtPosition(p2).toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val spinnerAdapter4 = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item)
        binding2.spinner4.adapter = spinnerAdapter4
        binding2.spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerData4 = binding2.spinner4.getItemAtPosition(p2).toString()
                Log.d("asdf main2", binding2.spinner4.getItemAtPosition(p2).toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val spinnerAdapter5 = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item)
        binding2.spinner5.adapter = spinnerAdapter5
        binding2.spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerData5 = binding2.spinner5.getItemAtPosition(p2).toString()
                Log.d("asdf main2", binding2.spinner5.getItemAtPosition(p2).toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val spinnerAdapter6 = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item)
        binding2.spinner6.adapter = spinnerAdapter6
        binding2.spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerData6 = binding2.spinner6.getItemAtPosition(p2).toString()
                Log.d("asdf main2", binding2.spinner6.getItemAtPosition(p2).toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding2.checkbox2.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked == true) {
                Log.d("asdf","check")
                binding2.editText2.isVisible = true
                binding2.spinner2.isVisible = true
                binding2.deviceLayout2.isVisible = true
                binding2.deviceNumber2.isVisible = true
            } else if(checked == false) {
                binding2.editText2.isVisible = false
                binding2.spinner2.isVisible = false
                binding2.deviceLayout2.isVisible = false
                binding2.deviceNumber2.isVisible = false
                binding2.editText2.text = null
                spinnerData2 = ""
            }
        }

        binding2.checkbox3.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked == true) {
                Log.d("asdf","check")
                with(binding2) {
                    editText3.isVisible = true
                    spinner3.isVisible = true
                    deviceLayout3.isVisible = true
                    deviceNumber3.isVisible = true
                }
            } else if(checked == false) {
                with(binding2) {
                    editText3.isVisible = false
                    spinner3.isVisible = false
                    deviceLayout3.isVisible = false
                    deviceNumber3.isVisible = false
                    editText3.text = null
                }
                spinnerData3 = ""
            }
        }

        binding2.checkbox4.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked == true) {
                Log.d("asdf","check")
                with(binding2) {
                    editText4.isVisible = true
                    spinner4.isVisible = true
                    deviceLayout4.isVisible = true
                    deviceNumber4.isVisible = true
                }
            } else if(checked == false) {
                with(binding2) {
                    editText4.isVisible = false
                    spinner4.isVisible = false
                    deviceLayout4.isVisible = false
                    deviceNumber4.isVisible = false
                    editText4.text = null
                }
                spinnerData4 = ""
            }
        }

        binding2.checkbox5.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked == true) {
                Log.d("asdf","check")
                with(binding2) {
                    editText5.isVisible = true
                    spinner5.isVisible = true
                    deviceLayout5.isVisible = true
                    deviceNumber5.isVisible = true
                }
            } else if(checked == false) {
                with(binding2) {
                    editText5.isVisible = false
                    spinner5.isVisible = false
                    deviceLayout5.isVisible = false
                    deviceNumber5.isVisible = false
                    editText5.text = null
                }
                spinnerData5 = ""
            }
        }

        binding2.checkbox6.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked == true) {
                Log.d("asdf","check")
                with(binding2) {
                    editText6.isVisible = true
                    spinner6.isVisible = true
                    deviceLayout6.isVisible = true
                    deviceNumber6.isVisible = true
                }
            } else if(checked == false) {
                with(binding2) {
                    editText6.isVisible = false
                    spinner6.isVisible = false
                    deviceLayout6.isVisible = false
                    deviceNumber6.isVisible = false
                    editText6.text = null
                }
                spinnerData6 = ""
            }
        }

        binding2.btnSave.setOnClickListener {
            //editData1 = binding2.editText1.text.toString()
            editData1.append(binding2.editText1.text).append(binding2.editText2.text).append(binding2.editText3.text).append(binding2.editText4.text).append(binding2.editText5.text).append(binding2.editText6.text)
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("spinner1","$spinnerData1, $spinnerData2, $spinnerData3, $spinnerData4, $spinnerData5, $spinnerData6")
            //intent.putExtra("spinner1",spinnerData1.append(spinnerData2).append(spinnerData3).toString())
            intent.putExtra("editdata1",editData1.toString())
            intent.putExtra("roomSizeValue",roomSize)
            //startActivity(intent)
            setResult(RESULT_OK, intent)
            finish()

        }

    }

}



































