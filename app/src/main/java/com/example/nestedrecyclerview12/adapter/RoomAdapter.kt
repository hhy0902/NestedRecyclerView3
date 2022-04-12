package com.example.nestedrecyclerview12.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview12.MainActivity2
import com.example.nestedrecyclerview12.R
import com.example.nestedrecyclerview12.model.Room

class RoomAdapter(val context: Context, val roomList: MutableList<Room>,
    val startActivityLauncher : ActivityResultLauncher<Intent>) :
    RecyclerView.Adapter<RoomAdapter.ViewHolder>(){

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val roomText : TextView
        val btn_del : ImageButton

        init {
            roomText = itemView.findViewById(R.id.roomText)
            btn_del = itemView.findViewById(R.id.btn_del)

            btn_del.setOnClickListener {
                val position : Int = adapterPosition
                Log.d("asdf","delete room $position")
                roomList.removeAt(position)
                notifyItemRemoved(position)
            }

            itemView.setOnClickListener {

                val position : Int = adapterPosition
                val intent = Intent(itemView.context,MainActivity2::class.java)
                intent.putExtra("abcd",roomList.get(position).name)
                intent.putExtra("roomsize",roomList.size)
                //itemView.context.startActivity(intent)
                startActivityLauncher.launch(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.room_item,parent,false))
    }

    override fun onBindViewHolder(holder: RoomAdapter.ViewHolder, position: Int) {
        holder.roomText.text = roomList.get(position).name
    }

    override fun getItemCount(): Int {
        return roomList.size
    }

}






























