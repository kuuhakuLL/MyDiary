package com.example.mydiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import com.example.mydiary.R


class MonthTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentMonth = inflater.inflate(R.layout.fragment_month_task, container, false)
        val calendarView = fragmentMonth.findViewById<CalendarView>(R.id.calendarView)
        
        return fragmentMonth
    }


    fun onSelectedDay(){

    }

}
