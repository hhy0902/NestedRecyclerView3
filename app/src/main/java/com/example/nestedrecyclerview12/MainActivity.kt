package com.example.nestedrecyclerview12

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview12.adapter.RoomAdapter
import com.example.nestedrecyclerview12.databinding.ActivityMainBinding
import com.example.nestedrecyclerview12.model.Room

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var i = 1
    lateinit var roomList : MutableList<Room>

    var spinnerData = ""
    var editData = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        roomList = mutableListOf<Room>()
        roomList.add(Room("room 1"))

        val database = androidx.room.Room.databaseBuilder(applicationContext,
            DeviceDatabase::class.java,
            "device-database"
        ).allowMainThreadQueries().build()

        val startActivityLauncher : ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                when(it.resultCode) {
                    RESULT_OK -> {
                        Log.d("asdf", it.data?.getStringExtra("roomSizeValue").toString())
                        spinnerData = it.data?.getStringExtra("spinner1").toString()
                        editData = it.data?.getStringExtra("editdata1").toString()
                    }
                }
            }

        val roomAdapter = RoomAdapter(this,roomList, startActivityLauncher)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = roomAdapter

        binding.btnAdd.setOnClickListener {
            i = roomList.size + 1
            roomList.add(Room("room $i"))
            roomAdapter.notifyDataSetChanged()
        }

//        val spinnerData = intent.getStringExtra("spinner1")
//        val editData = intent.getStringExtra("editdata1")

        binding.btnSave.setOnClickListener {
            Log.d("qwer", roomList.size.toString())
            binding.dataText.text = spinnerData
            binding.dataText2.text = editData
        }

        binding.btnLoad.setOnClickListener {
//            val deviceProfiles = database.deviceProfileDao().getAll()
//            deviceProfiles.forEach {
//                Log.d("asdf","${it.roomNumber}, ${it.deviceName}, ${it.spinnerValue}, ${it.editTextValue}")
//            }

            val sharedPreferences = getSharedPreferences("room 3", Context.MODE_PRIVATE)
            val spinnerValue = sharedPreferences.getInt("spinnerSelect1", 0)
            val editTextValue = sharedPreferences.getString("editdata1", "empty")

            Log.d("asdf main share", spinnerValue.toString())
            Log.d("asdf main share", editTextValue.toString())

        }
    }
}










































