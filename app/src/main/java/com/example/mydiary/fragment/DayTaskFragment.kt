package com.example.mydiary.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Task
import com.example.domain.repositories.implementations.TaskRepositoryApi
import com.example.mydiary.R
import com.example.mydiary.activity.TaskActivity
import com.example.mydiary.adapters.BaseAdapterCallback
import com.example.mydiary.adapters.TaskAdapter
import com.example.mydiary.presenters.DayTaskPresenter
import com.example.mydiary.views.DayTaskView
import kotlinx.android.synthetic.main.fragment_day_task.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

/**
 * A simple [Fragment] subclass.
 **/
class DayTaskFragment : MvpAppCompatFragment(), DayTaskView {

    @InjectPresenter
    lateinit var mDayTaskPresenter: DayTaskPresenter
    lateinit var taskRepositoryApi: TaskRepositoryApi
    private var mAdapter = TaskAdapter()
    private lateinit var recyclerDayTask : RecyclerView


    @ProvidePresenter
    fun mDayTaskPresenter(): DayTaskPresenter {
        taskRepositoryApi = TaskRepositoryApi(context = context!!.applicationContext)
        return DayTaskPresenter(repository = taskRepositoryApi)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragmentDay = inflater.inflate(R.layout.fragment_day_task, container, false)
        if(context != null)
            taskRepositoryApi = TaskRepositoryApi(context = context!!.applicationContext)
        else
            mDayTaskPresenter.errorConnectDb()
        recyclerDayTask = fragmentDay.findViewById(R.id.recyclerDayTask)
        setupAdapter()
        mDayTaskPresenter.loadTasks()
        return fragmentDay
    }

    private fun setupAdapter(){
        recyclerDayTask.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerDayTask.adapter = mAdapter
    }

    override fun presetTasks(data: List<Task>) {
        mAdapter.setData(newData = data)
        mAdapter.attachCallback(object: BaseAdapterCallback<Task> {
            override fun onItemClick(model: Task, v: View) {
                mDayTaskPresenter.openTask(model)
            }
        })
    }

    override fun presentNoTask() {
        cpvDayTask.visibility = View.GONE
        txtDayTaskNoTask.visibility = View.VISIBLE
    }

    override fun openTask(model: Task) {
        val taskActivity = Intent(context, TaskActivity::class.java)
        taskActivity.putExtra("Task", model)
        startActivity(taskActivity)
    }

    override fun startLoad() {
        recyclerDayTask.visibility = View.GONE
        cpvDayTask.visibility = View.VISIBLE
    }

    override fun endLoad() {
        recyclerDayTask.visibility = View.VISIBLE
        cpvDayTask.visibility = View.GONE
    }

    override fun showError(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_SHORT)
    }
}

