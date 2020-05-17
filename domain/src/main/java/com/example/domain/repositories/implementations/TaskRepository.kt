package com.example.domain.repositories.implementations

import com.example.domain.models.Task

interface TaskRepository {
    fun getTask()
    fun getAllTaskFromDay(data: String)
    fun insert(data: Task)
    fun update(data: Task)
}
