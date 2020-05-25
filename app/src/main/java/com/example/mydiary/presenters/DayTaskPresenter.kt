package com.example.mydiary.presenters

import com.example.domain.models.Task
import com.example.domain.repositories.implementations.TaskRepositoryApi
import com.example.mydiary.R
import com.example.mydiary.views.DayTaskView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import java.text.SimpleDateFormat
import java.util.*

@InjectViewState
class DayTaskPresenter(val repository: TaskRepositoryApi): MvpPresenter<DayTaskView>(){
    private val TAG = DayTaskPresenter::class.java.simpleName

    private val taskDate = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    private lateinit var mData: Flowable<List<Task>>
    var date: String = dateFormat.format(taskDate.time)

    fun loadTasks(){
        viewState.startLoad()
        mData = repository.getAllTaskFromDay(date = "06.06.2020")
        mData.
        subscribeOn(Schedulers.computation()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe({
            viewState.presetTasks(it)
        },{
            viewState.showError(R.string.error_show_task)
        },{
            viewState.endLoad()
        })
    }

    fun resumeTasks(){
        viewState.startLoad()
        mData.subscribeOn(Schedulers.computation()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe({
            viewState.presetTasks(it)
        },{
            viewState.showError(R.string.error_show_task)
        },{
            viewState.endLoad()
        })
    }

    fun openTask(model: Task){
        viewState.startLoad()
        viewState.openTask(model)
        viewState.endLoad()
    }

    fun errorConnectDb(){

        viewState.showError(R.string.error_connect_db)
    }

//    fun getAllTaskFromDay(date: String): Flowable<List<Task>> {
//        return Flowable.create({subscribe -> subscribe.onNext(listOf(
//            Task("Test task 1","Test description 1",
//                "13:0","0:10","06.06.2020"),
//            Task("Test task 2", "Test description 2",
//                "13:10","0:10","06.06.2020"),
//            Task("Test task 3","Test description 3",
//                "13:20","0:10","06.06.2020"),
//            Task("Test task 4","Test description 4",
//                "13:30","0:10","06.06.2020")))
//            subscribe.onComplete()}, BackpressureStrategy.BUFFER)
//        //return Flowable.just(taskConverter.fromDbToUi(taskDao.getAllTaskFromDay(date = date)))
//    }

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

