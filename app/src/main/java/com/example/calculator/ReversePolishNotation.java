package com.example.calculator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotation {
    String expression = new String();
    ArrayList<String> work = new ArrayList<String>();
    private Stack<String> Texas = new Stack<String>();
    private ArrayList<String>  Kalifornia = new ArrayList<String>();

    public ReversePolishNotation(){}

    public ReversePolishNotation(String expression){
        this.expression = expression;
    }

    void deleteLastSymbol(){
        if (expression.length() < 1) return;
        expression.substring(0, expression.length() - 1);
    }

    Double equally(){

        return 0.0;
    }

    String analiseExpression() {
        String regex = "((^|([\\(]+)|([\\*\\/]))(\\-[\\d\\.]+))|([\\d\\.]+)|(\\()|(\\))|([+\\-])|([\\/*])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);


        while (matcher.find()) {
            work.add(matcher.group(0));
            Boolean isAgain = true;
            while (isAgain) {
                if (matcher.group(3) != "") { // откр скобка
                    Texas.push(matcher.group(3));
                }
                if (matcher.group(7) != "") { // откр скобка
                    Texas.push(matcher.group(7));
                }
                if (matcher.group(4) != "") { // /*
                    if (Texas.empty() || Texas.peek() == "(") {
                        Texas.push(matcher.group(4));
                        isAgain = false;
                    }
                    if (Texas.peek() == "+" || Texas.peek() == "-") {
                        Texas.push(matcher.group(4));
                        isAgain = false;
                    }
                    if (Texas.peek() == "*" || Texas.peek() == "/") Kalifornia.push(Texas.pop());
                }

                if (matcher.group(10) != "") { // / *
                    if (Texas.empty() || Texas.peek() == "(") {
                        Texas.push(matcher.group(10));
                        isAgain = false;
                    }
                    if (Texas.peek() == "+" || Texas.peek() == "-") {
                        Texas.push(matcher.group(10));
                        isAgain = false;
                    }
                    if (Texas.peek() == "*" || Texas.peek() == "/") Kalifornia.push(Texas.pop());
                }

                if (matcher.group(5) != "") {
                    Kalifornia.push(matcher.group(5));  // отриц число
                    isAgain = false;
                }
                if (matcher.group(6) != "") {
                    Kalifornia.push(matcher.group(6)); // число
                    isAgain = false;
                }

                if (matcher.group(8) != "") { // закр скобка
                    if (Texas.empty()) return "error";
                    if (Texas.peek() == "(") {
                        Texas.pop();
                        isAgain = false;
                    } else Kalifornia.push(Texas.pop());
                }
                if (matcher.group(9) != "") { // +-
                    if (Texas.empty()) {
                        Texas.push(matcher.group(9));
                        isAgain = false;
                    }
                    if (Texas.peek() == "+" || Texas.peek() == "-") Kalifornia.push(Texas.pop());
                    if (Texas.peek() == "*" || Texas.peek() == "/") Kalifornia.push(Texas.pop());
                }
            }
        }
        return "";
    }
    Double calculate(){


        return 0.0;
    }

};


