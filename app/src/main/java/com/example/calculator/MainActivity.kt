package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var inputExpression = ReversePolishNotation("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        for (view in constraintLayout.children)
        {
            view.setOnClickListener {
                addToInput((view as Button).text.toString())
            }
        }

        bt_all_delete.setOnClickListener {
            textExpression.text = ""
            inputExpression.expression = ""
        }
        bt_delete.setOnClickListener {
            inputExpression.deleteLastSymbol()
            textExpression.text = inputExpression.expression
        }
        bt_equally.setOnClickListener {
            var temp = inputExpression.equally().toString()
            if (temp.matches(Regex(pattern = "[.][0]*\\b"))) {
                textAnswer.text = temp.matches(Regex(pattern = "(\\d)\\.")).toString()
            }
            else {
                textAnswer.text = temp
            }
        }

    }
    private fun addToInput(char: String)
    {
        textExpression.append(char)
        inputExpression.expression = inputExpression.expression + char
    }
}


