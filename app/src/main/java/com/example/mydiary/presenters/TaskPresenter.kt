package com.example.mydiary.presenters

import android.os.Handler
import com.example.domain.models.Task
import com.example.domain.repositories.implementations.TaskRepositoryApi
import com.example.mydiary.R
import com.example.mydiary.views.TaskView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class TaskPresenter(private val repository: TaskRepositoryApi): MvpPresenter<TaskView>() {

    lateinit var  mTask: Task

    fun fetchTask(data: Task?) {
        viewState.startLoad()
        Handler().postDelayed({
            if (data!= null) {
                mTask = data
                viewState.presentTask(mTask)
            }
            else viewState.showError(R.string.error_show_task)
        },500)
        viewState.endLoad()
    }

    fun onTimer(isTimerOn: Boolean) {
        if(isTimerOn) {
            val timer = mTask.timer.split(':')
            val milliseconds = 60000*(timer[0].toLong()*60+timer[1].toLong())
            viewState.startTimer(milliseconds = milliseconds)
        }
        else viewState.endTimer()
    }

}