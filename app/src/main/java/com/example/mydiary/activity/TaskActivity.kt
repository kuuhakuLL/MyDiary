package com.example.mydiary.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mydiary.R
import com.example.mydiary.models.TaskModel
import kotlinx.android.synthetic.main.activity_task_item.*

class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_item)
        showTask()
    }

    private fun showTask(){
        val task = intent?.getParcelableExtra<TaskModel>("Task")
        if(task != null ) {
            textName.text = task.name
            textDescription.text =task.description
            textTimer.text = task.timer
        }
        else{
            Toast.makeText(applicationContext,"Произошла ошибка", Toast.LENGTH_SHORT).show()
        }

    }
}
