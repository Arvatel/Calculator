package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_zero.setOnClickListener(this)
        bt_one.setOnClickListener(this)
        bt_two.setOnClickListener(this)
        bt_three.setOnClickListener(this)
        bt_four.setOnClickListener(this)
        bt_five.setOnClickListener(this)
        bt_six.setOnClickListener(this)
        bt_seven.setOnClickListener(this)
        bt_eight.setOnClickListener(this)
        bt_nine.setOnClickListener(this)
        bt_plus.setOnClickListener(this)
        bt_minus.setOnClickListener(this)
        bt_multiplication.setOnClickListener(this)
        bt_division.setOnClickListener(this)
        bt_open_bracket.setOnClickListener(this)
        bt_close_bracket.setOnClickListener(this)
        bt_delete.setOnClickListener(this)
        bt_equally.setOnClickListener(this)
        bt_point.setOnClickListener(this)
        bt_all_delete.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.bt_zero -> textExpression.text = !textExpression.text + !bt_zero.text
            R.id.bt_one -> textExpression.text = bt_one.text
            R.id.bt_two -> textExpression.text = bt_two.text
            R.id.bt_three -> textExpression.text = bt_three.text
            R.id.bt_four -> textExpression.text = bt_four.text
            R.id.bt_five -> textExpression.text = bt_five.text
            R.id.bt_six -> textExpression.text = bt_six.text
            R.id.bt_seven -> textExpression.text = bt_seven.text
            R.id.bt_eight -> textExpression.text = bt_eight.text
            R.id.bt_nine -> textExpression.text = bt_nine.text
            R.id.bt_plus -> textExpression.text = bt_plus.text
            R.id.bt_minus -> textExpression.text = bt_minus.text
            R.id.bt_multiplication -> textExpression.text = bt_multiplication.text
            R.id.bt_division -> textExpression.text = bt_division.text
            R.id.bt_open_bracket -> textExpression.text = bt_open_bracket.text
            R.id.bt_close_bracket -> textExpression.text = bt_close_bracket.text
            R.id.bt_delete -> textExpression.text = bt_delete.text
            R.id.bt_point -> textExpression.text = bt_point.text
            R.id.bt_all_delete -> textExpression.text = bt_all_delete.text



            R.id.bt_equally -> textExpression.text = bt_equally.text
        }
    }
    operator fun plus(other: Any?): String {} (source){}
}

