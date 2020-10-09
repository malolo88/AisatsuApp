package com.example.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import kotlin.time.minutes

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button){
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                if(2 <= hour && hour < 10){
                    textView.text = "おはよう"
                }else if(10 <= hour && hour < 18){
                    textView.text = "こんにちは"
                }else if(18 <= hour && hour < 24){
                    textView.text = "こんばんは"
                }else if(0 <= hour && hour < 2){
                    textView.text = "こんばんは"
                }
            },
            13, 0, true)

        timePickerDialog.show()

    }
}
