package com.example.domain.repositories.implementations

import android.content.Context
import com.example.data.remote.db.TaskRoomDatabase
import com.example.domain.converters.TaskConverter
import com.example.domain.models.Task
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.schedulers.Schedulers

class TaskRepositoryApi(context: Context): TaskRepository {

    private val taskConverter = TaskConverter()
    private val taskDao = TaskRoomDatabase.getDatabase(context).taskDao()

    override fun getTask():Flowable<Task> {
        return Flowable.create({subscribe ->
            subscribe.onNext(Task(0,"Test task 1","Test description 1",
                "13:0","0:10","06.06.2020"))
            subscribe.onComplete()
        }, BackpressureStrategy.BUFFER)
//        return  Flowable.just(taskConverter.fromDbToUi(taskDao.getTask()))
    }

    override fun getAllTaskFromDay(date: String): Flowable<List<Task>> {
        return Flowable.create({subscribe ->
            subscribe.onNext(listOf(
                Task(0,"Test task 1","Test description 1",
                    "13:0","0:10","06.06.2020"),
                Task(0,"Test task 2", "Test description 2",
                    "13:10","0:10","06.06.2020"),
                Task(0,"Test task 3","Test description 3",
                    "13:20","0:10","06.06.2020"),
                Task(0,"Test task 4","Test description 4",
                    "13:30","0:10","06.06.2020")))
            subscribe.onComplete()
        }, BackpressureStrategy.BUFFER)
        //return Flowable.just(taskConverter.fromDbToUi(taskDao.getAllTaskFromDay(date = date)))
    }

    override fun insert(data: Task) {
        TODO("Not yet implemented")
    }

    override fun update(data: Task) {
        TODO("Not yet implemented")
    }
}