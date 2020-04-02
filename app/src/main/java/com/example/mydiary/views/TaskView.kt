package com.example.mydiary.views

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value =  OneExecutionStateStrategy::class)
interface TaskView: MvpView {
    fun loadTask()
    fun showError(message: Int)

}