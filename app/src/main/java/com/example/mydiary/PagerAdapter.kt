package com.example.mydiary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.w3c.dom.DocumentFragment

class PagerAdapter(fragment: FragmentManager): FragmentPagerAdapter(fragment){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> {
                DayFragment()
            }
            1->{
                WeekFragment()
            }
            else ->{
                MonthFragment()
            }
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