package com.example.nestedrecyclerview12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        roomList = mutableListOf<Room>()
        roomList.add(Room("room 1"))

        val roomAdapter = RoomAdapter(this,roomList)
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

//            Log.d("qwer", roomList.size.toString())
//            binding.dataText.text = spinnerData
//            binding.dataText2.text = editData
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data.let {
            val spinner1 = data?.getStringExtra("spinner1")
            val editdata1 = data?.getStringExtra("editdata1")

            binding.dataText.text = spinner1
            binding.dataText2.text = editdata1
        }
    }

}





























