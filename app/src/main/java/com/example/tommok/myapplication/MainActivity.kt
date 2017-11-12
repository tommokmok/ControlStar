package com.example.tommok.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG:String="ControlStart"
    //Note:different char with have different number of char in one line
    private val MAX_CHAR_IN_ONE_LINE =35
    private val MAX_NUM_OF_ROW=10
    private val space='_'
    private val starChar='*'
    private val starStr="*"
    private var textBuff=StringBuilder(MAX_NUM_OF_ROW*MAX_CHAR_IN_ONE_LINE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var starPos:Int
        /*
        Init the buffer
         */
        for(i:Int in 0..(MAX_NUM_OF_ROW*MAX_CHAR_IN_ONE_LINE-1)) textBuff.insert(0,space)
        textBuff.setCharAt(0,starChar)
        testView.setText(textBuff,TextView.BufferType.EDITABLE)
        Log.d(TAG,"String buffer Length=${textBuff.length}")
        Log.d(TAG,"TextView Length=${testView.length()}")
        /*
         Button Onclick event Listener
         */
        ctrlLeft.setOnClickListener{
            //Find the position of the *
            starPos=textBuff.indexOf(starStr)
            Log.d(TAG,"[Left Button] StarPos=${starPos}")


            //Boundary Check and Set new Value
            //Only update the * position if * is not on the 1st col
            if(starPos%MAX_CHAR_IN_ONE_LINE!=0) {
                //Update the char value
                textBuff.setCharAt(starPos,space)
                textBuff.setCharAt(starPos-1,starChar)
                //Print the ouput
                testView.setText(textBuff,TextView.BufferType.EDITABLE)
            }



//            Log.d(TAG,"[Left Button] TextView Length=${testView.length()}")
        }
        ctrlRight.setOnClickListener{
            //Find the position of the *
            starPos=textBuff.indexOf(starStr)
            val row:Int=starPos/MAX_CHAR_IN_ONE_LINE+1
            Log.d(TAG,"[Right Button] StarPos=${starPos}")

            //Boundary Check and Set new Value
            //Only update the * position if * is not on the last col
            //The last col, index is (35*n-1), n=1,2,3....10
            if(starPos!=(row*MAX_CHAR_IN_ONE_LINE-1)) {
                //Update the char value
                textBuff.setCharAt(starPos,space)
                textBuff.setCharAt(starPos+1,starChar)
                //Print the ouput
                testView.setText(textBuff,TextView.BufferType.EDITABLE)
            }

//            Log.d(TAG,"[Right Button] TextView Length=${testView.length()}")
        }
        ctrlUp.setOnClickListener{
            //Find the position of the *
            starPos=textBuff.indexOf(starStr)
            Log.d(TAG,"[Up Button] StarPos=$starPos")
            val row:Int=starPos/MAX_CHAR_IN_ONE_LINE
            //Update the char value
            textBuff.setCharAt(starPos,space)
            //Boundary Check and Set new Value
            if(row!=0) textBuff.setCharAt(starPos-MAX_CHAR_IN_ONE_LINE,starChar)
            //Return to 0 row if star is on the last row
            else {
                starPos+=MAX_CHAR_IN_ONE_LINE*(MAX_NUM_OF_ROW-1)
                textBuff.setCharAt(starPos,starChar)
            }

            //Print the output
            testView.setText(textBuff,TextView.BufferType.EDITABLE)
//            Log.d(TAG,"[Up Button] TextView Length=${testView.length()}")

        }
        ctrlDown.setOnClickListener{
            //Find the position of the *
            starPos=textBuff.indexOf(starStr)
            Log.d(TAG,"[Down Button] StarPos=$starPos")
            val row:Int=starPos/MAX_CHAR_IN_ONE_LINE
            //Update the char value
            textBuff.setCharAt(starPos,space)
            //Boundary Check and Set new Value
            if(row!=MAX_NUM_OF_ROW-1) textBuff.setCharAt(MAX_CHAR_IN_ONE_LINE+starPos,starChar)
            //Return to 0 row if star is on the last row
            else {
                starPos-=MAX_CHAR_IN_ONE_LINE*(MAX_NUM_OF_ROW-1)
                textBuff.setCharAt(starPos,starChar)
            }

            //Print the output
            testView.setText(textBuff,TextView.BufferType.EDITABLE)
//            Log.d(TAG,"[Down Button] TextView Length=${testView.length()}")

        }

    }
}
