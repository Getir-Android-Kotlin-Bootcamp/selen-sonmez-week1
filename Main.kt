package com.example.getir_bootcamp_homework

import java.io.File
import java.lang.NumberFormatException

    fun main() {
        // Printing statements demonstrating various code snippets
        println("Sayfa 9) Bootcamp Homework 1")
        print("Sayfa 9) Print Bootcamp Homework 1")
        println()
        println("Sayfa 10) Sum of 10 and 5 = ${10.sum(5)}")
        println("Sayfa 11) Increment 10 by 1 =  ${increment(10)}")
        println(
            "Sayfa 12-13) Instance of a class Car and accessing field brand = ${
                Car(
                    "Mazda",
                    "3",
                    2010
                ).brand
            }"
        )
        println("Sayfa 15) Between 10 and 5, greater one is = ${maxOf(5, 10)}")
        println("Sayfa 16-17) Items in a list:")
        listOf("apple", "banana", "kiwi").forEach { item ->
            println(item)
        }
        println("Sayfa 16-17) Items in a list using ListIterator:")
        printItemsUsingListIterator(listOf("mazda", "mercedes"))
        println("Sayfa 18) When function= ${whenFunction("1")}")
        println("Sayfa 19) Range from 1-5= ${range(1, 5)}")
        setExample(setOf(1, 2, 3))
        printNullableString()
        println("Sayfa 22) Type check=  ${typeCheck("String")}")
        println("Sayfa 46) Extension Function. Is 5 even=  ${5.isEven()}")
        println("Sayfa 47) Current count: ${counterExample()}")
        println("Sayfa 48) Area of Circle= ${Circle(5.0).area()} ")
        println("Sayfa 48) Area of Rectangle= ${Rectangle(4.0, 6.0).area()}")
        println("Sayfa 49) ${nullableExample()}")
        println("Sayfa 50) Directory size: ${printFilesSize("Text")}")
        println(
            "Sayfa 52) First or null example: ${
                firstOrNullExample(
                    listOf<String>(
                        "First element of the List",
                        "Second Element"
                    )
                )
            }"
        )
        println("Sayfa 53-54) If not null example: ${ifNotNullExample("Hello")}")
        println("Sayfa 56-57) Try catch example: ${tryCatchExample("10")}")
        println("Sayfa 58) The number 8 is ${ifCondition(8)}")
        println("Sayfa 59) Array of minus ones example: ${arrayOfMinusOnesExample(5).contentToString()}")
        println("Sayfa 60) The word radar is ${if (singleExpression("radar")) "" else "not "}a palindrome")
        operateTurtle(Turtle())
        println("Sayfa 61) Also example: ${alsoExample("lowercase sentence to uppercase")}")
        printGenericLists()
        alsoExample()
        parametersExample()
        println("Sayfa 68) Greeting message: ${"Hello" greet "Selen"}")
        println("Sayfa 69) Sum of vectors: ${Pair(3, 4) + Pair(1, 2)}")
        println("Sayfa 70) Maximum of numbers: ${findMax(10, 20, 30)}")
        immutableAndMutableExample()
        nullSafetyExample("Hello")
        nullSafetyExample(null)
        getSurpriseBoxContents()
        println("Sayfa 76) Nullable content: ${printContent("10")}, ${printContent(10)}")
        println("Sayfa 77-78-79) Vehicle information: ${vehicleInformation()}")
        println("Sayfa 82) For loop example: ${forLoopExample("Hello")} ")
        println("Sayfa 83) Countdown from 5: ${countdown(5)}")
        println("Sayfa 84) Countdown from 5 in do-while loop: ${doWhileCountdown(5)}")
        controlFlowRangesExamples()
        equality()
        printBookDetails()
    }

    // Function to demonstrate null safety
    fun nullSafetyExample(str: String?) {
        println("Sayfa 72) ")
        if (str != null) {
            println("Length of the string is: ${str.length}")
        } else {
            println("String is null")
        }
    }

    // Function to demonstrate immutable and mutable variables
    fun immutableAndMutableExample() {
        println("Sayfa 71)")
        // mutable variable
        var mutableVariable: Int = 10
        mutableVariable = 20 // Reassigning the value
        println("Mutable variable: $mutableVariable")

        // immutable variable
        val immutableVariable: Int = 30
        // immutableVariable = 40 // Error: Val cannot be reassigned
        println("Immutable variable: $immutableVariable")
    }

    // Function to greet with default or specified parameters
    fun greet(name: String = "World", greeting: String = "Hello") {
        println("$greeting, $name!")
    }

    // Function to demonstrate parameter usage
    fun parametersExample() {
        println("Sayfa 67)")
        // no arguments
        greet() // Output: Hello, World!

        // only the 'name' parameter specified
        greet("Selen")

        // only the 'greeting' parameter specified
        greet(greeting = "Hi")

        // both parameters specified
        greet("Jane", "Merhaba")

        // named parameters
        greet(greeting = "Hola", name = "Maria")
    }

    // Function to demonstrate also function
    fun alsoExample() {
        println("Sayfa 65) ")
        var age = 18

        var modifiedAge = age.also {
            it.inc()
        }

        println("Original Age: $age")
        println("Modified Age: $modifiedAge")
    }

    // Function to find the maximum element in a list
    fun <T : Comparable<T>> findMax(list: List<T>): T? {
        if (list.isEmpty()) {
            return null
        }
        var max = list[0]
        for (element in list) {
            if (element > max) {
                max = element
            }
        }
        return max
    }

    // Function to print max elements of different types of lists
    fun printGenericLists() {
        println("Sayfa 64) ")
        val intList = listOf(3, 7, 2, 9, 5)
        val maxInt = findMax(intList)
        println("Max int: $maxInt")

        val doubleList = listOf(3.5, 1.2, 5.6, 2.8)
        val maxDouble = findMax(doubleList)
        println("Max double: $maxDouble")

        val stringList = listOf("apple", "banana", "orange", "kiwi")
        val maxString = findMax(stringList)
        println("Max string: $maxString")
    }

    // Function to check if a string is a palindrome
    fun singleExpression(input: String): Boolean = input == input.reversed()

    // Function to check if a number is even
    fun ifCondition(number: Int): String {
        val result = if (number % 2 == 0) {
            "even"
        } else {
            "odd"
        }

        return result
    }

    // Function to demonstrate nullable types
    fun nullableExample(): Int? {
        val nullableString: String? = "Hello, Kotlin"

        val length: Int? = nullableString?.length
        return length
    }

    // Function to increment a counter
    fun counterExample(): Int {
        Counter.increment()
        Counter.increment()
        return Counter.getCount()
    }

    // Counter object to demonstrate object declaration
    object Counter {
        private var count = 0

        fun increment() {
            count++
        }

        fun getCount(): Int {
            return count
        }
    }

    // Data class to represent Book
    data class Book(val title: String, val genre: String)

    // Function to print book details
    fun printBookDetails() {
        println("Sayfa 90-91-92) ")
        val book2 = Book("Dune", genre = "Sci-fi")
        println("Book 2: Title: ${book2.title}, Genre: ${book2.genre}")
        val copiedBook = book2.copy()
        println("Copied book: $copiedBook")
        println("Are books equal? ${book2 == copiedBook}")
    }

    fun equality() {
        println("Sayfa 88) ")
        val str1 = "hello"
        val str2 = "hello"
        val str3 = str1

        println("Referential equality:")
        println("str1 === str2: ${str1 === str2}")
        println("str1 === str3: ${str1 === str3}")
    }

    fun controlFlowRangesExamples() {
        println("Sayfa 86-87) ")
        println("Closed Range:")
        for (i in 1..5) {
            print("$i ")
        }

        println("\nHalf-Open Range:")
        for (i in 1 until 5) {
            print("$i ")
        }

        println("\nReverse Range:")
        for (i in 5 downTo 1) {
            print("$i ")
        }

        println("\nStep Range:")
        for (i in 1..10 step 2) {
            print("$i ")
        }
        println()
    }

    fun doWhileCountdown(seconds: Int): ArrayList<Int> {
        val countdownNumbers = ArrayList<Int>()
        var count = 0
        do {
            countdownNumbers.add(count)
            count++
        } while (count < seconds)
        return countdownNumbers
    }

    fun countdown(seconds: Int): ArrayList<Int> {
        var remainingSeconds = seconds
        val countdownNumbers = ArrayList<Int>()
        while (remainingSeconds > 0) {
            countdownNumbers.add(remainingSeconds)
            remainingSeconds--
        }
        return countdownNumbers
    }

    fun forLoopExample(word: String): List<Char> {
        val charArray = ArrayList<Char>()
        for (ch in word) {
            charArray.add(ch)
        }
        return charArray
    }

    open class Vehicle(val brand: String) {
        open fun drive(): String {
            return "$brand vehicle has started driving"
        }
    }

    class Motorcycle(brand: String, val model: String) : Vehicle(brand) {
        override fun drive(): String {
            return "$brand $model is driving on the road"
        }
    }

    fun vehicleInformation(): String {
        val vehicle = Vehicle("Honda")
        val motorcycle = Motorcycle("Mazda", "3")
        return "${motorcycle.drive()} ${vehicle.drive()}"
    }

    fun <T> printContent(content: T): String {
        return "Content: $content"
    }

    class SurpriseBox<T>(val content: T) {
        fun getContents(): T {
            return content
        }
    }

    fun getSurpriseBoxContents() {
        val integerBox = SurpriseBox(10)
        val stringBox = SurpriseBox("Hello")

        val intValue: Int = integerBox.getContents()
        val stringValue: String = stringBox.getContents()
        println("Sayfa 75) $intValue, $stringValue")
    }

    fun findMax(vararg numbers: Int): Int {
        return numbers.maxOrNull() ?: throw IllegalArgumentException("No numbers provided")
    }

    operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(this.first + other.first, this.second + other.second)
    }

    infix fun String.greet(name: String): String {
        return "$this, $name! Welcome"
    }

    fun alsoExample(variable: String): String {
        variable.let {
            return it.uppercase()
        }
    }

    class Turtle {
        fun function1(): String {
            return "calling function 1"
        }

        fun function2(): String {
            return "calling function 2"
        }
    }

    fun operateTurtle(turtle: Turtle) {
        turtle.apply {
            println("Sayfa 61) ${function1()}")
            repeat(2) {
                println("Sayfa 61) ${function2()}")
            }
        }
    }

    fun arrayOfMinusOnesExample(size: Int): IntArray {
        return IntArray(size) { -1 }
    }

    fun tryCatchExample(input: String): String {
        return try {
            val number = input.toInt()
            "Parsed number: $number"
        } catch (e: NumberFormatException) {
            "Input is not a valid number"
        }
    }

    fun ifNotNullExample(text: String?): String {
        text?.run {
            return "Value of nullable Variable: $this"
        }
        return ""
    }

    fun firstOrNullExample(list: List<String>): String {
        return list.getOrElse(0) { "" }
    }

    fun printFilesSize(directoryPath: String): String {
        val files = File(directoryPath).listFiles()
        return files?.let {
            it.size.toString()
        } ?: "Empty"
    }

    abstract class Shape {
        abstract fun area(): Double
    }

    class Circle(private val radius: Double) : Shape() {
        override fun area(): Double {
            return Math.PI * radius * radius
        }
    }

    class Rectangle(private val width: Double, private val height: Double) : Shape() {
        override fun area(): Double {
            return width * height
        }
    }

    fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    fun typeCheck(obj: Any): String {
        return when (obj) {
            is String -> "$obj is String"
            is Int -> "$obj is int"
            is Double -> "$obj is Double"
            else -> "$obj is of unknown type"
        }
    }

    fun printNullableString() {
        val b: String? = null
        b?.let {
            println("Sayfa 21) Variable b is not null: $it")
        } ?: run {
            println("Sayfa 21) Variable b is null")
        }
    }

    fun setExample(numbers: Set<Int>) {
        for (number in numbers) {
            println("Sayfa 20) $number")
        }
    }

    fun range(start: Int, end: Int): IntRange {
        return start..end
    }

    fun Int.sum(other: Int): Int {
        return this + other
    }

    fun increment(number: Int) = number + 1

    class Car(var brand: String, var model: String, var year: Int)

    fun maxOf(a: Int, b: Int): Int = run {
        if (a > b) a else b
    }

    fun printItemsUsingListIterator(items: List<String>) {
        val iterator = items.listIterator()
        while (iterator.hasNext()) {
            iterator.next()
        }
    }

    fun whenFunction(obj: Any): Int = when (obj) {
        "1" -> 1
        "2" -> 2
        "3" -> 3
        else -> -1
    }
