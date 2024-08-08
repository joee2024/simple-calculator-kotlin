package com.example.mycalculator

fun read_number(prompt: String) : Double {
    while (true) {
        print(prompt)
        val input = readLine()
        try {
            return input!!.toDouble()
        } catch (e: NumberFormatException) {
            println("Invalid input. Please enter a number.")
        }
    }
}

fun read_operator (prompt: String) : String {
    val symbol = setOf ("+", "-", "*", "/")
    while (true) {
        print(prompt)
        val input = readLine()
        if (input in symbol) {
            return input!!
        } else {
            println("Invalid input.Please enter one of this : +, -, *, /")
        }
    }
}

fun calculate(first_num: Double, second_num: Double, symbol: String): Double? {
    return when (symbol) {
        "+" -> first_num + second_num
        "-" -> first_num - second_num
        "*" -> first_num * second_num
        "/" -> {
            if (second_num ==0.0){
                println("Error: Division by 0 is not allowed")
                null
            } else {
                first_num / second_num
            }
        }
        else -> {
            println("Invalid operator")
            null
        }
    }
}

fun read_decision (prompt: String) : String {
    val option = setOf ("Y", "y", "N", "n")
    while (true) {
        print(prompt)
        val input = readLine()
        if (input in option) {
            return input!!
        } else {
            println("Invalid input.Please enter one of this : Y or N")
        }
    }
}

fun main() {
    while (true) {
        print("*** Simple Calculator ***")
        println()
        val first_num =  read_number("Enter the first number: ")
        val second_num = read_number("Enter the second number: ")
        val symbol = read_operator("Select the operation (+, -, *, /): ")

        val result = calculate(first_num, second_num, symbol)

        if (result != null) {
            println("Result: $first_num $symbol $second_num = $result")
        }

        val decision = read_decision("Do you want to perform another operation? (Y/N): ")
        if (decision == "N" || decision == "n") {
            println("Thank you for using the calculator!")
            break
        }
    }
}
