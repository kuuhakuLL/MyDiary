package com.example.data.remote.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.remote.models.TaskDb
import io.reactivex.Single

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task WHERE Date = :date")
    fun getAllTaskFromDay(date: String): Single<List<TaskDb>>

    @Query("SELECT * FROM Task WHERE id = :id")
    fun getTask(id: Int):Single<TaskDb>

    @Insert
    fun insert(data: TaskDb)

    @Update
    fun update(data: TaskDb)


}