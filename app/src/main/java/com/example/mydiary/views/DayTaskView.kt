package com.example.mydiary.views

import com.example.mydiary.models.Task
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface DayTaskView: BaseView {
    fun presetTasks(data: List<Task>)
    fun presentNoTask()
    fun openTask(data: Task)
}