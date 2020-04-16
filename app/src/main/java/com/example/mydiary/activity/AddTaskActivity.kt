package com.example.mydiary.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mydiary.R
import com.example.mydiary.presenters.AddTaskPresenter
import com.example.mydiary.views.AddTaskView
import kotlinx.android.synthetic.main.activity_add_task.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class AddTaskActivity: MvpAppCompatActivity(), AddTaskView{

//    private val taskDate: Calendar = Calendar.getInstance()
//    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")
//    lateinit var taskRepository: TaskRepository

    @InjectPresenter
    lateinit var addTaskPresenter: AddTaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        taskStart.setIs24HourView(true)
        taskTimer.setIs24HourView(true)
        taskTimer.hour = 0
        taskTimer.minute = 0
    }

    fun onAdd(v: View){
        //addTaskPresenter.addTask()
//        var name: String = taskName?.text.toString()
//        var description: String = taskDescription?.text.toString()
//        var start = "${taskStart.hour}:${taskStart.minute}"
//        var timer = "${taskTimer.hour}:${taskTimer.minute}"
//        var date: String = dateFormat.format(taskDate.time)
//
//        var task = Task(id = 0,
//                name = name,
//                description = description,
//                start = start,
//                timer = timer,
//                date = date)
    }


    // View implementation
    override fun startSending() {
        btnAddTask.visibility = View.GONE
        cpvAdd.visibility = View.VISIBLE
        taskName.isEnabled = false
        taskDescription.isEnabled = false
        taskStart.isEnabled = false
        taskTimer.isEnabled = false
    }

    override fun endSending() {
        btnAddTask.visibility = View.VISIBLE
        cpvAdd.visibility= View.GONE
        taskName.isEnabled = true
        taskDescription.isEnabled = true
        taskStart.isEnabled = true
        taskTimer.isEnabled = true
    }

    override fun showError(message: Int) {
        Toast.makeText(applicationContext, getString(message), Toast.LENGTH_SHORT)
    }

    override fun showSuccess() {
        Toast.makeText(applicationContext, R.string.add_task_success, Toast.LENGTH_SHORT)
    }

    override fun startLoad() {
        TODO("Not yet implemented")
    }

    override fun endLoad() {
        TODO("Not yet implemented")
    }

}