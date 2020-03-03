package com.example.calculator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotation {
    String expression = new String();
    ArrayList<String> work = new ArrayList<String>();
    Stack<String> Texas = new Stack<String>();
    Stack<String> Kalifornia = new Stack<String>();

    void deleteLastSymbol(){
        expression.substring(0, expression.length() - 1);
    }

    Double equally(){

        return 0.0;
    }

    String analiseExpression() {
//        String regex = "(\\()|(\\))|([+\\-])|([\\/*])|([\\d\\.]+)";
        String regex = "((^|([\\(]+)|([\\*\\/]))(\\-[\\d\\.]+))|([\\d\\.]+)|(\\()|(\\))|([+\\-])|([\\/*])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        Boolean first = true;
        while (matcher.find()) {
            work.add(matcher.group(0));
            for (int i = 1; i < 10; i++)
                if (matcher.group(3) != "" || matcher.group(7) != "") { // откр скобка
                    if (first) return "error";
                }
            if (matcher.group(4) != "" || matcher.group(10) != "") { // / *

            }
            if (matcher.group(5) != "") Kalifornia.push(matcher.group(5));  // отриц число| число
            if (matcher.group(6) != "") Kalifornia.push(matcher.group(6));

            if (matcher.group(8) != "") { // закр скобка

            }
            if (matcher.group(9) != "") { // +-

            }
        }
    }
};


