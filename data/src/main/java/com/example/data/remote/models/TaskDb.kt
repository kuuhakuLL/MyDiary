package com.example.data.remote.models

import androidx.room.Dao
import androidx.room.PrimaryKey

@Dao
class TaskDb(
    @PrimaryKey var id: Int,
    var name: String,
    var description: String,
    var start: String,
    var timer: String,
    var date: String
) {

}