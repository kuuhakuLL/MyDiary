package com.example.mydiary.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mydiary.fragment.DayTaskFragment
import com.example.mydiary.fragment.MonthTaskFragment
import com.example.mydiary.fragment.WeekTaskFragment

class PagerAdapter(fragment: FragmentManager): FragmentPagerAdapter(fragment){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> DayTaskFragment()
            1 -> WeekTaskFragment()
            else -> MonthTaskFragment()
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