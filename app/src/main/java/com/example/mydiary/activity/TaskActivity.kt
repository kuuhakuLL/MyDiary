package com.example.mydiary.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.domain.models.Task
import com.example.domain.repositories.implementations.TaskRepositoryApi
import com.example.mydiary.R
import com.example.mydiary.presenters.TaskPresenter
import com.example.mydiary.views.TaskView
import kotlinx.android.synthetic.main.activity_task.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class TaskActivity : MvpAppCompatActivity(), TaskView {
    private val TAG = TaskActivity::class.java.simpleName

    @InjectPresenter
    lateinit var taskPresenter: TaskPresenter
    private var isTimerOn = false

    @ProvidePresenter
    fun taskPresenter():TaskPresenter {
      return TaskPresenter(TaskRepositoryApi(context = applicationContext))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        val model : Task? = intent?.getParcelableExtra("Task")
          if (model != null)
            taskPresenter.fetchTask(model)
        else
            taskPresenter.openError()
    }

    fun btnOnClick(v :View){
        isTimerOn = !isTimerOn
        taskPresenter.onTimer(isTimerOn)
    }

    //View implement
    override fun presentTask(task: Task) {
        txtTaskName.text = task.name
        txtTaskDescription.text = task.description
        val timer = task.timer.split(':')
        val milliseconds = 60000*(timer[0].toLong()*60+timer[1].toLong())
        chronometerTask.base = System.currentTimeMillis() + milliseconds
    }

    override fun startLoad() {
        txtTaskName.visibility = View.GONE
        txtTaskDescription.visibility = View.GONE
        chronometerTask.visibility = View.GONE
        btnTask.visibility = View.GONE
        cpvTask.visibility = View.VISIBLE
    }

    override fun endLoad() {
        txtTaskName.visibility = View.VISIBLE
        txtTaskDescription.visibility = View.VISIBLE
        chronometerTask.visibility = View.VISIBLE
        btnTask.visibility = View.VISIBLE
        cpvTask.visibility = View.GONE
    }

    override fun startTimer(milliseconds: Long) {
        cpvTask.visibility = View.VISIBLE
        chronometerTask.start()
    }

    override fun endTimer() {
        cpvTask.visibility = View.GONE
        chronometerTask.stop()
    }

    override fun showError(message: Int) {
        Toast.makeText(applicationContext, getString(message), Toast.LENGTH_SHORT).show()
    }
}
