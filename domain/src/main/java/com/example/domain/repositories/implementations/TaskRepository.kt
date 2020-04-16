package com.example.domain.repositories.implementations

import com.example.domain.models.Task

interface TaskRepository {
    fun getTask()
    fun getAllDayTask(data: String)
    fun setTask(data: Task)
    fun updateTask(data: Task)
}
