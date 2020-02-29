package com.example.mydiary

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Add : AppCompatActivity() {

//    var taskStartTime: Button? = null
    private var dateAndTime = Calendar.getInstance()
//    private var taskTime = Time()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
//        taskStartTime=findViewById(R.id.taskStartTime)
        setInitialDateTime()
    }

//    fun setTime(v: View?) {
//        TimePickerDialog(
//            this, t,
//            dateAndTime[Calendar.HOUR_OF_DAY],
//            dateAndTime[Calendar.MINUTE], true
//        )
//            .show()
//    }

    private fun setInitialDateTime() {
//        taskStartTime!!.text = "00:00"
    }

    var t = OnTimeSetListener { view, hourOfDay, minute ->
                dateAndTime[Calendar.HOUR_OF_DAY] = hourOfDay
                dateAndTime[Calendar.MINUTE] = minute
                setInitialDateTime()
            }
}