package com.example.calculator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCalculator
{
    // with space (\()|(\))|([*\/])|(?:(?<=[\d\)])\ *)([+-])|((?:\-\ *[\d.]+)|(?:[\d.]+))|(\S)
    private String regex = "(\\()|(\\))|([*\\/])|(?:(?<=[\\d\\)])\\ *)([+-])|(\\-?\\ *[\\d.]+)|(\\S)";
    private Pattern pattern = Pattern.compile(regex);
    private Stack<Double> result = new Stack<Double>();
    private Stack<String> RPN = new Stack<String>();

    double calculate(String data) throws ArithmeticException
    {
        Matcher matcher = pattern.matcher(data);
        while (matcher.find())
        {
            if (matcher.group(6) != null) throw new ArithmeticException();
            String token = "0";
            int group = 0;
            for (int i = 1; i <= 5; i++)
            {
                if (matcher.group(i) == null) continue;
                group = i;
                token = matcher.group(i);
            }

            if (group == 1)
            {
                RPN.push(token);
                continue;
            }
            if (group == 2)
            {
                while(!RPN.empty() && !RPN.peek().equals("(")) calc(RPN.pop());
                if (RPN.empty()) throw new ArithmeticException();
                RPN.pop();
                continue;
            }
            if (group == 5)
            {
                try
                {
                    result.push(Double.valueOf(token));
                }
                catch (NumberFormatException e)
                {
                    throw new ArithmeticException();
                }

                continue;
            }

            int flag = (group == 4) ? 1 : 2;
            while(!RPN.empty() && priority(RPN.peek()) >= flag)
            {
                calc(RPN.pop());
            }
            RPN.push(token);
        }
        while(!RPN.empty()) calc(RPN.pop());
        if (result.size() != 1) throw new ArithmeticException();
        return result.pop();
    }

    private void calc(String temp)
    {
        if (result.empty()) throw new ArithmeticException();
        double b = result.pop();
        if (result.empty()) throw new ArithmeticException();
        double a = result.pop();

        if(temp.equals("+")) result.push(a + b);
        if(temp.equals("-")) result.push(a - b);
        if(temp.equals("*")) result.push(a * b);
        if(temp.equals("/")) result.push(a / b);
    }
    int priority(String temp)
    {
        if (temp.equals("*") || temp.equals("/")) return 2;
        if (temp.equals("+") || temp.equals("-")) return 1;
        return 0;
    }
}


