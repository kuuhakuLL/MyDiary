package com.example.mydiary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding

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

        var table = fragmentWeek.findViewById<TableLayout>(R.id.weekTable)

        val days: Array<String> = arrayOf("Пн", "Вт", "Ср", "Чт","Пт","Сб","Вс")

        var tableRow = TableRow(context)

        var layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT)

        for (day in days){
            var cell = TextView(context)
            cell.text = day
            cell.apply {
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                setPadding(5)
                textSize = 20f
            }
            tableRow.addView(cell,layoutParams)
        }
        table.addView(tableRow)

        for(hour in 7..23){
            var tableRow = TableRow(context)

            for (day in days){
                var cell = TextView(context)
                cell.text = "$hour"
                cell.apply {
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    setPadding(5)
                }
                tableRow.addView(cell,layoutParams)
            }
            layoutParams.width = TableRow.LayoutParams.MATCH_PARENT
            table.addView(tableRow, layoutParams)

        }
        return fragmentWeek
    }


}
