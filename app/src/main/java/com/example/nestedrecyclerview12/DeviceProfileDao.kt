package com.example.nestedrecyclerview12

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface DeviceProfileDao {

    @Insert(onConflict = REPLACE)
    fun insert(deviceProfile: DeviceProfile)

    @Query("DELETE FROM deviceprofile WHERE roomNumber = :roomNumber")
    fun delete(roomNumber : String)

    @Query("SELECT * FROM deviceprofile")
    fun getAll() : List<DeviceProfile>
}





































