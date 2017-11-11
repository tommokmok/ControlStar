package com.example.tommok.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testView.setText("*",TextView.BufferType.EDITABLE)
//        testView.text
        ctrlLeft.setOnClickListener{
//            Toast.makeText(this,"button Left is clicked!",Toast.LENGTH_LONG).show()
            var text=testView.editableText
            text.delete(text.length-2,text.length-1)
            testView.setText(text,TextView.BufferType.EDITABLE)

        }
        ctrlRight.setOnClickListener{
//            Toast.makeText(this,"Button Right is clicked",Toast.LENGTH_LONG).show()
            var text=testView.editableText.insert(0,"$")
            testView.setText(text,TextView.BufferType.EDITABLE)
        }
        ctrlUp.setOnClickListener{
//            Toast.makeText(this,"Button Up is clicked",Toast.LENGTH_SHORT).show()
            testView.append("APPEND")
        }
        ctrlDown.setOnClickListener{
            Toast.makeText(this,"Button Down is clicked",Toast.LENGTH_SHORT).show()
        }

    }
}
