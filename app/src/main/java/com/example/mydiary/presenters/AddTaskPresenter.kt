package com.example.mydiary.presenters

import android.os.Handler
import com.example.mydiary.R
import com.example.mydiary.views.AddTaskView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AddTaskPresenter: MvpPresenter<AddTaskView>() {

    fun addTask(name: String, description: String, start: String, timer: String, date: String){
        Handler().postDelayed({
            if (name==""){
                viewState.showError(message = R.string.add_task_wrong_name_empty)
            }
            viewState.startSending()
        },2000)
    }

}