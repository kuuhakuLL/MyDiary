package com.example.mydiary.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mydiary.helpers.DBHelper
import com.example.mydiary.R
import com.example.mydiary.models.Task
import kotlinx.android.synthetic.main.activity_add.*
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity() {

    private val taskDate: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    private var dbHelper: DBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        taskStart.setIs24HourView(true)
        taskTimer.setIs24HourView(true)
        taskTimer.hour = 0
        taskTimer.minute = 0
    }

    fun onAdd(v: View){
        var name: String = taskName?.text.toString()
        var description: String = taskDescription?.text.toString()
        var start = "${taskStart.hour}:${taskStart.minute}"
        var timer = "${taskTimer.hour}:${taskTimer.minute}"
        var date: String = dateFormat.format(taskDate.time)

        var task = Task(id = 0,
                name = name,
                description = description,
                start = start,
                timer = timer,
                date = date)

        dbHelper = DBHelper(this)
        if (dbHelper!!.addTask(task)){
            finish()
        }

    }

}