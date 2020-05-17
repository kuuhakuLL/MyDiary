package com.example.domain.repositories.implementations

import android.app.Application
import com.example.data.remote.dao.TaskDao
import com.example.data.remote.db.TaskRoomDatabase
import com.example.domain.models.Task

class TaskRepositoryApi(application: Application): TaskRepository {

    val taskDao = TaskRoomDatabase.getDatabase(application).taskDao()

    override fun getTask() {
        TODO("Not yet implemented")
    }

    override fun getAllTaskFromDay(data: String) {
        TODO("Not yet implemented")
    }

    override fun insert(data: Task) {
        TODO("Not yet implemented")
    }

    override fun update(data: Task) {
        TODO("Not yet implemented")
    }
}