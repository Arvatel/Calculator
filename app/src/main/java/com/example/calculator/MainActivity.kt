package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var inputExpression = ""
    private val myCalculator = MyCalculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        for (view in buttonLayout.children)
        {
            view.setOnClickListener {
                addToInput((view as Button).text.toString())
            }
        }

        bt_all_delete.setOnClickListener {
            textExpression.text = ""
            inputExpression = ""
            update(false)
        }
        bt_delete.setOnClickListener {
            if (inputExpression.isNotEmpty()) {
                inputExpression = inputExpression.substring(0, inputExpression.length - 1)
                textExpression.text = textExpression.text.substring(0, textExpression.text.length - 1)
                update(false)
            }
        }
        bt_equally.setOnClickListener {
            update(true)
        }

    }
    private fun addToInput(char: String)
    {
        when(char) {
            "×" -> inputExpression += "*"
            "÷" -> inputExpression += "/"
            else -> inputExpression += char
        }
        textExpression.append(char)
        update(false)
    }

    private fun update(showError: Boolean)
    {
        if (inputExpression == ""){
            textAnswer.text = ""
            return
        }
        try {
            var temp = myCalculator.calculate(inputExpression)
            textAnswer.setTextColor(0xff272727.toInt())
            if (temp.toString() == "Infinity") {
                textAnswer.text = "∞"
                return
            }
            if (temp.toString() == "-Infinity") {
                textAnswer.text = "-∞"
                return
            }
            if (temp.toString() == "NaN") {
                textAnswer.text = "Not a number"
                textAnswer.setTextColor(0xffd5004e.toInt())
                return
            }
            textAnswer.text = temp.toString()

        }
        catch (e: ArithmeticException)
        {
            textAnswer.setTextColor(0xff939393.toInt())
            if(showError){
                textAnswer.text = "Error"
                textAnswer.setTextColor(0xffd5004e.toInt())
            }
        }
    }
}


