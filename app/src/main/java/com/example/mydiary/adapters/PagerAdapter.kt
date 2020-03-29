package com.example.mydiary.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mydiary.fragment.DayFragment
import com.example.mydiary.fragment.MonthFragment
import com.example.mydiary.fragment.WeekFragment

class PagerAdapter(fragment: FragmentManager): FragmentPagerAdapter(fragment){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> DayFragment()
            1 -> WeekFragment()
            else -> MonthFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0-> "День"
            1-> "Неделя"
            else ->{
                return "Месяц"
            }
        }
    }
}