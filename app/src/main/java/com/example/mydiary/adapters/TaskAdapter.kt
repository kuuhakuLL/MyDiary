package com.example.mydiary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.domain.models.Task
import com.example.mydiary.R

class TaskAdapter : BaseAdapter<Task>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Task> {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_task, parent, false)
        )
    }

    class ViewHolder(itemView: View) : BaseViewHolder<Task>(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtName)
        var txtStart: TextView = itemView.findViewById(R.id.txtStart)

        override fun bind(model: Task) {
            txtName.text = model.name
            txtStart.text = model.start
        }
    }
}