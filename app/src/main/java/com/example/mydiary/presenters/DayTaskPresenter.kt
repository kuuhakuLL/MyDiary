package com.example.mydiary.presenters

import android.os.Handler
import com.example.mydiary.models.Task
import com.example.mydiary.views.DayTaskView
import moxy.InjectViewState
import moxy.MvpPresenter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

@InjectViewState
class DayTaskPresenter: MvpPresenter<DayTaskView>(){

    private val taskDate = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    var date: String = dateFormat.format(taskDate.time)

    fun loadTasks(){
        viewState.startLoad()
        val handler = Handler()
        thread {
            Thread.sleep(3000)
            val mockData = ArrayList<Task>()
            mockData.add(
                    Task(
                        0,
                        "Test task 1",
                        "Test description 1",
                        "13:0",
                        "0:10",
                        "02.04.2020"
                    )
                )
            mockData.add(
                    Task(
                        1,
                        "Test task 2",
                        "Test description 2",
                        "13:10",
                        "0:10",
                        "02.04.2020"
                    )
                )
            mockData.add(
                    Task(
                        2,
                        "Test task 3",
                        "Test description 3",
                        "13:20",
                        "0:10",
                        "02.04.2020"
                    )
                )
            mockData.add(
                    Task(
                        3,
                        "Test task 4",
                        "Test description 4",
                        "13:30",
                        "0:10",
                        "02.04.2020"
                    )
                )
            handler.post {
                    viewState.endLoad()
                    viewState.presetTasks(data = mockData)
            }
        }
    }

    fun openTask(model: Task){
        viewState.startLoad()
        Handler().postDelayed({
            viewState.endLoad()
            viewState.openTask(model)
        },500)
    }

//    private fun populateData(){
//        var dbHelper = DBHelper(context)
//        tasks = dbHelper.getDayTasks(date)
//    }


//    private fun updateTasks(){
//        var dbHelper = DBHelper(context)
//        var date: String = dateFormat.format(taskDate.time)
//        var updateData = dbHelper.getDayTasks(date)
//        val utils = TaskDiffUtils(tAdapter.mDataList, updateData)
//        val diffRezalt = DiffUtil.calculateDiff(utils)
//        tAdapter.setData(updateData)
//        diffRezalt.dispatchUpdatesTo(tAdapter)
//    }
}
