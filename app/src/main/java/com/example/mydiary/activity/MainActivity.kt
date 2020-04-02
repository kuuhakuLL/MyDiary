package com.example.mydiary.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.mydiary.adapters.PagerAdapter
import com.example.mydiary.R
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        if (viewPager != null) {
            val adapter = PagerAdapter(supportFragmentManager)
            viewPager.adapter = adapter
        }

        var  tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
    }

    fun onAdd(view: View){
        val addActivity = Intent(this, AddTaskActivity::class.java)
        startActivity(addActivity)
    }
}
