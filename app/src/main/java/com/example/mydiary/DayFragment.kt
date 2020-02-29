package com.example.mydiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding

/**
 * A simple [Fragment] subclass.
 **/
class DayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentDay = inflater.inflate(R.layout.fragment_day, container, false)
        var table = fragmentDay.findViewById<TableLayout>(R.id.dayTable)

        for(hour in 7..23){
            var tableRow = TableRow(context)

            var layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT,1f)

            var cell1 = TextView(context)
            cell1.text = "$hour - ${hour+1}"
            cell1.apply {
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                setPadding(5)
            }
            tableRow.addView(cell1,layoutParams)

            layoutParams.weight = 2f
            var cell2 = TextView(context)
            cell2.text = "Дело ${hour-6}"
            cell2.apply {
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                setPadding(5)
            }
            tableRow.addView(cell2,layoutParams)

            var cell3 = TextView(context)
            cell3.text = "Замена делу ${hour-6}"
            cell3.apply {
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                setPadding(5)
            }
            tableRow.addView(cell3,layoutParams)


            table!!.addView(tableRow)
        }

        return fragmentDay
    }
}

