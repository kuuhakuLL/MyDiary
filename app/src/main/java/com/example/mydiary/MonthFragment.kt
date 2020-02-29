package com.example.mydiary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView


class MonthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentMonth = inflater.inflate(R.layout.fragment_month, container, false)
        val calendarView = fragmentMonth.findViewById<CalendarView>(R.id.calendarView)
        
        return fragmentMonth
    }


    fun onSelectedDay(){

    }

}
