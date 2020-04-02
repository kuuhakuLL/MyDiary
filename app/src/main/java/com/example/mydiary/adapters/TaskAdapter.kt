package com.example.mydiary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mydiary.R
import com.example.mydiary.models.TaskModel

class TaskAdapter : BaseAdapter<TaskModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TaskModel> {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_task, parent, false)
        )
    }

    class ViewHolder(itemView: View) : BaseViewHolder<TaskModel>(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtName)
        var txtStart: TextView = itemView.findViewById(R.id.txtStart)

        override fun bind(model: TaskModel) {
            txtName.text = model.name
            txtStart.text = model.start
        }
    }
}