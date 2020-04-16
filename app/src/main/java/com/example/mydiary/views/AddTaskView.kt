package com.example.mydiary.views

import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AddTaskView: BaseView {
    fun startSending()
    fun endSending()
    fun showSuccess()
}