package com.example.mydiary.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiary.R
import com.example.mydiary.activity.TaskItemActivity
import com.example.mydiary.adapters.BaseAdapterCallback
import com.example.mydiary.adapters.TaskAdapter
import com.example.mydiary.helpers.DBHelper
import com.example.mydiary.models.Task
import com.example.mydiary.models.TaskDiffUtils
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 **/
class DayFragment : Fragment() {

    private lateinit var recyclerTask: RecyclerView
    private var tAdapter = TaskAdapter()
    private val taskDate: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    var date: String = dateFormat.format(taskDate.time)

    private var tasks: MutableList<Task> = ArrayList()

    private fun populateData(){
        var dbHelper = DBHelper(context)
        tasks = dbHelper.getDayTasks(date)
        tAdapter.setData(tasks)
        tAdapter.attachCallback(object: BaseAdapterCallback<Task> {
            override fun onItemClick(model: Task, v: View) {
                openTask(model)
            }
        })
    }

    fun openTask(model: Task){
        val taskActivity = Intent(context, TaskItemActivity::class.java)
        taskActivity.putExtra("Task", model)
        startActivity(taskActivity)
    }

    private fun updateTasks(){
        var dbHelper = DBHelper(context)
        var date: String = dateFormat.format(taskDate.time)
        var updateData = dbHelper.getDayTasks(date)
        val utils = TaskDiffUtils(tAdapter.mDataList, updateData)
        val diffRezalt = DiffUtil.calculateDiff(utils)
        tAdapter.setData(updateData)
        diffRezalt.dispatchUpdatesTo(tAdapter)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var fragmentDay = inflater.inflate(R.layout.fragment_day, container, false)
        recyclerTask = fragmentDay.findViewById(R.id.recyclerTask)
        recyclerTask.layoutManager = LinearLayoutManager(context)
        recyclerTask.adapter = tAdapter
        populateData()
        return fragmentDay
    }

    override fun onResume() {
        super.onResume()
        updateTasks()
    }
}

