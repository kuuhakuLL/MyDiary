package com.example.mydiary.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.domain.repositories.implementations.TaskRepositoryApi
import com.example.mydiary.R
import com.example.mydiary.adapters.PagerAdapter
import com.example.mydiary.presenters.DayTaskPresenter
import com.example.mydiary.presenters.MainPresenter
import com.example.mydiary.views.MainView
import com.google.android.material.tabs.TabLayout
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class MainActivity : MvpAppCompatActivity(), MainView {
    lateinit var taskRepositoryApi: TaskRepositoryApi

    @InjectPresenter
    lateinit var mMainActivityPresenter: MainPresenter

    @ProvidePresenter
    fun mMainActivityPresenter(): DayTaskPresenter {
        return DayTaskPresenter(repository = taskRepositoryApi)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskRepositoryApi = TaskRepositoryApi(context = applicationContext)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        if (viewPager != null) {
            val adapter = PagerAdapter(supportFragmentManager)
            viewPager.adapter = adapter
        }
        var  tabLayout = findViewById<TabLayout>(R.id.tabs)
        showNotification()
        tabLayout.setupWithViewPager(viewPager)
    }

    fun onAdd(view: View){
        val addActivity = Intent(this, AddTaskActivity::class.java)
        startActivity(addActivity)
    }

    override fun showNotification() {

    }

    override fun startLoad() {
        TODO("Not yet implemented")
    }

    override fun endLoad() {
        TODO("Not yet implemented")
    }

    override fun showError(message: Int) {
        TODO("Not yet implemented")
    }

}
