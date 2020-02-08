package com.example.mydiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class Add : AppCompatActivity() {

    companion object{
        const val whatAdd = "whatAdd"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val count = intent.getIntExtra(whatAdd,0)
        viewWhatAdd.text = Integer.toString(count)

    }

}
