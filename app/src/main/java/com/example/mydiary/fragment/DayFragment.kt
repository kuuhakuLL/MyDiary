package com.example.mydiary.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydiary.R
import com.example.mydiary.activity.TaskItemActivity
import com.example.mydiary.adapters.BaseAdapterCallback
import com.example.mydiary.adapters.TaskAdapter
import com.example.mydiary.helpers.DBHelper
import com.example.mydiary.models.Task
import kotlinx.android.synthetic.main.fragment_day.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 **/
class DayFragment : Fragment() {

    private lateinit var tAdapter: TaskAdapter
    private val taskDate: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    private var tasks: MutableList<Task> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_day, container, false)

    private fun setAdapter(){
        var dbHelper = DBHelper(context)
        var date: String = dateFormat.format(taskDate.time)
        tasks = dbHelper.getDayTasks(date)
        tAdapter = TaskAdapter()
        tAdapter.setData(tasks)
        recyclerTask.layoutManager = LinearLayoutManager(context)
        tAdapter.attachCallback(object: BaseAdapterCallback<Task> {
            override fun onItemClick(model: Task, v: View) {
                val taskActivity = Intent(context, TaskItemActivity::class.java)
                taskActivity.putExtra("Task", model)
                startActivity(taskActivity)
            }
        })
        recyclerTask.adapter = tAdapter
    }

    private fun updateTasks(){
        var dbHelper = DBHelper(context)
        var date: String = dateFormat.format(taskDate.time)
        var updateTask = dbHelper.getDayTasks(date)
        tAdapter.setData(updateTask)
    }

    override fun onResume() {
        super.onResume()
        updateTasks()
    }
}

