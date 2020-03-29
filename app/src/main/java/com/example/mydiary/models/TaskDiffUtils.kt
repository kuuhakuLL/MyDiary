package com.example.mydiary.models

import androidx.recyclerview.widget.DiffUtil

class TaskDiffUtils(private val oldList: List<Task>, private val newList: List<Task>): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].date == newList[newItemPosition].date &&
                oldList[oldItemPosition].name == newList[newItemPosition].name &&
                oldList[oldItemPosition].description == newList[newItemPosition].description &&
                oldList[oldItemPosition].start == newList[newItemPosition].start &&
                oldList[oldItemPosition].timer == newList[newItemPosition].timer)
    }
}