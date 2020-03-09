# Calculator
This is just normal calculator

## Used languages and technologies:
1. Java
1. Kotlin
1. XML
1. Regular expression
1. Android studio
1. [Shunting-yard algorithm]

## Features
* You can use
   * Brackets
   * Four operations ("+", "-", "×", "÷")
   * Numbers with point
* Calculating after adding each symbol

<img src="./images/calculator.jpg" alt="screenShot" width="300"/>

## How to download
1. Download file calculator.apk from directory download-app/
2. Run this file on your device
	* You should agree to install from unknown sources
1. Done!

## How is it works
I used [Shunting-yard algorithm] that's why it possible to use brackets and correctly calculate with priority of operations. 
For reorganization text from expression I used regex `(\\()|(\\))|([*\\/])|(?:(?<=[\\d\\)])\\ *)([+-])|(\\-?\\ *[\\d.]+)|(\\S)` it separated symbols into *six* groups.


[Shunting-yard algorithm]: https://en.m.wikipedia.org/wiki/Shunting-yard_algorithm
