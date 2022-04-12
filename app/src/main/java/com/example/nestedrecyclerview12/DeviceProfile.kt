package com.example.nestedrecyclerview12

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class DeviceProfile(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    val roomNumber : String,

    val deviceName : String,

    val spinnerValue : String,

    val editTextValue : String

) {
    constructor(roomNumber: String, deviceName: String, spinnerValue: String, editTextValue: String)
        : this(0, roomNumber, deviceName, spinnerValue, editTextValue)
}
