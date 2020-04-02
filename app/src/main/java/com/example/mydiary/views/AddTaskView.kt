package com.example.mydiary.views

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value =  OneExecutionStateStrategy::class)
interface AddTaskView: MvpView {
    fun startSending()
    fun endSending()
    fun showError(message: Int)
    fun showSuccess()
}