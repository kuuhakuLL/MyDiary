package com.example.mydiary.views

import com.example.domain.models.Task
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface TaskView: BaseView {
    fun presentTask(task: Task)
    fun startTimer(milliseconds: Long)
    fun endTimer()

}