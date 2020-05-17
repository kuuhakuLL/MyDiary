package com.example.data.remote.models

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
class TaskDb(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "Start") val start: String,
    @ColumnInfo(name = "Timer") val timer: String,
    @ColumnInfo(name = "Date") val date: String
) {

}