package com.example.domain.repositories.implementations

import com.example.domain.models.Task
import io.reactivex.rxjava3.core.Flowable

interface TaskRepository {
    fun getTask()
    fun getAllTaskFromDay(data: String): Flowable<List<Task>>
    fun insert(data: Task)
    fun update(data: Task)
}
