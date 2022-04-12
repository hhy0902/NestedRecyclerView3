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
import androidx.room.Room
import com.example.nestedrecyclerview12.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding2 by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    var spinnerData1 : String = ""
    //var spinnerData1 = StringBuffer()
    var spinnerData2 : String = ""
    var spinnerData3 : String = ""
    var spinnerData4 : String = ""
    var spinnerData5 : String = ""
    var spinnerData6 : String = ""


    //var editData1 = StringBuffer()
    var editData1 : String = ""
    var editData2 : String = ""
    var editData3 : String = ""
    var editData4 : String = ""
    var editData5 : String = ""
    var editData6 : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)

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
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

//
//        binding2.checkbox2.setOnCheckedChangeListener { compoundButton, checked ->
//            if (checked == true) {
//                Log.d("asdf","check")
//                binding2.editText2.isVisible = true
//                binding2.spinner2.isVisible = true
//                binding2.deviceLayout2.isVisible = true
//                binding2.deviceNumber2.isVisible = true
//            } else if(checked == false) {
//                binding2.editText2.isVisible = false
//                binding2.spinner2.isVisible = false
//                binding2.deviceLayout2.isVisible = false
//                binding2.deviceNumber2.isVisible = false
//                binding2.editText2.text = null
//                spinnerData2 = ""
//            }
//        }

        val database = Room.databaseBuilder(applicationContext,
            DeviceDatabase::class.java,
            "device-database"
        ).allowMainThreadQueries().build()

        val deviceProfiles = database.deviceProfileDao().getAll()
        deviceProfiles.forEach {
            Log.d("asdf db","${it.roomNumber}, ${it.deviceName}, ${it.spinnerValue}, ${it.editTextValue}")

        }

        Log.d("asdf", deviceProfiles.size.toString())



        binding2.btnSave.setOnClickListener {
            editData1 = binding2.editText1.text.toString()
            editData2 = binding2.editText2.text.toString()
            editData3 = binding2.editText3.text.toString()
            editData4 = binding2.editText4.text.toString()
            editData5 = binding2.editText5.text.toString()
            editData6 = binding2.editText6.text.toString()

            val deviceProfile = DeviceProfile(binding2.numberText.text.toString(),
                binding2.deviceNumber.text.toString(), spinnerData1, editData1)
            database.deviceProfileDao().insert(deviceProfile)

            //editData1.append(binding2.editText1.text).append(binding2.editText2.text).append(binding2.editText3.text).append(binding2.editText4.text).append(binding2.editText5.text).append(binding2.editText6.text)
            //intent.putExtra("editdata1",editData1.toString())

            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("spinner1","$spinnerData1, $spinnerData2, $spinnerData3, $spinnerData4, $spinnerData5, $spinnerData6")
            intent.putExtra("editdata1","$editData1, $editData2, $editData3, $editData4, $editData5, $editData6")
            intent.putExtra("roomSizeValue",roomSize)

            setResult(RESULT_OK, intent)
            finish()

        }

    }

}



































