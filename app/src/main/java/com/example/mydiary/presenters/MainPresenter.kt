package com.example.mydiary.presenters

import android.app.Activity
import com.example.domain.models.Task
import com.example.domain.repositories.implementations.TaskRepositoryApi
import com.example.mydiary.R
import com.example.mydiary.helpers.NotificationUtils
import com.example.mydiary.views.MainView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import java.util.*

class MainPresenter(val repository: TaskRepositoryApi): MvpPresenter<MainView>() {
    private val mNotificationTime = Calendar.getInstance().timeInMillis + 5000
    private var mNotified = false
    private lateinit var mData: Flowable<Task>

    fun createNotified(activity: Activity){
        mData = repository.getTask()
        mData.
            subscribeOn(Schedulers.computation()).
            observeOn(AndroidSchedulers.mainThread()).
            subscribe({
                var start = it.start.split("")
                if (!mNotified) {
                    NotificationUtils().setNotification(mNotificationTime, activity =  activity)
                }
            },{
                viewState.showError(R.string.error_show_task)
            },{
                viewState.endLoad()
            })


    }
}