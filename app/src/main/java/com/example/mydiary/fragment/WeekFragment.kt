package com.example.mydiary.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mydiary.R

/**
 * A simple [Fragment] subclass.
 */
class WeekFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentWeek = inflater.inflate(R.layout.fragment_week, container, false)

        return fragmentWeek
    }


}
