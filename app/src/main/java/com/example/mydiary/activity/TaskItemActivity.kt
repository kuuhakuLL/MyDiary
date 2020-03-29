package com.example.mydiary.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mydiary.R
import com.example.mydiary.models.Task
import kotlinx.android.synthetic.main.activity_task_item.*

class TaskItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_item)
        showTask()
    }

    private fun showTask(){
        val task = intent?.getParcelableExtra<Task>("Task")
        if(task != null ) {
            textName.text = task.name
            textDescription.text =task.description
        }
        else{
            Toast.makeText(applicationContext,"Произошла ошибка", Toast.LENGTH_SHORT).show()
        }

    }
}
