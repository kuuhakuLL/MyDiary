package com.example.mydiary.adapters

import android.view.View

interface BaseAdapterCallback<T> {
    fun onItemClick(model: T, v: View)
}