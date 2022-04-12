package com.example.nestedrecyclerview12

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [DeviceProfile::class], version = 1)
abstract class DeviceDatabase : RoomDatabase() {
    abstract fun deviceProfileDao() : DeviceProfileDao

}