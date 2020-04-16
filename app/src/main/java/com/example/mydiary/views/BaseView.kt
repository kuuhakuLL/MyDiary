package com.example.mydiary.views

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface BaseView: MvpView {
    fun startLoad()
    fun endLoad()
    fun showError(message: Int)
}