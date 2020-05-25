package com.example.mydiary.views

import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView:BaseView {
    fun showNotification()
}