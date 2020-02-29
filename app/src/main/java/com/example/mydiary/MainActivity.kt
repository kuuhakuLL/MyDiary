package com.example.mydiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
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
        val addActivity = Intent(this, Add::class.java)

//        val currentPager = viewPager.getCurrentItem()
//        addActivity.putExtra(Add.whatAdd, currentPager)
        startActivity(addActivity)
    }
}
