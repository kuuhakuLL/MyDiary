package com.example.domain.converters

import com.example.data.remote.models.TaskDb
import com.example.domain.models.Task
import java.util.ArrayList


class TaskConverter() {
    fun fromDbToUi(model: TaskDb): Task {
        return Task(
            id = model.id ,name = model.name, description = model.description,
            start = model.start, timer = model.timer, date = model.date)
    }

    fun fromDbToUi(listModel: List<TaskDb>): List<Task> {
        var listData = ArrayList<Task>()
        listModel.forEach{listData.add(fromDbToUi(it))}
        return listData
    }

    fun fromUiToDb(model: Task): TaskDb {
        return TaskDb(
            id = 0, name = model.name, description = model.description,
            start = model.start, timer = model.timer, date = model.date)
    }

}