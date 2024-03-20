package com.example.getir_bootcamp_homework

import java.io.File
import java.lang.NumberFormatException

class Main {

    fun main(){

        println("Sayfa 9) Bootcamp Homework 1")
        println("Sayfa 10) Sum of 10 and 5 = ${10.sum(5)}")
        println("Sayfa 11) Increment 10 by 1 =  ${increment(10)}")
        println("Sayfa 12-13) Instance of a class Car and accessing field brand = ${Car("Mazda","3",2010).brand}")
        println("Sayfa 15) Between 10 and 5, greater one is = ${maxOf(5,10)}")
        println("Sayfa 16-17) Items in a list:")

        listOf("apple","banana","kiwi").forEach { item ->
            println(item)
        }

        println("Sayfa 16-17) Items in a list using ListIterator:")
        printItemsUsingListIterator(listOf("mazda","mercedes"))
        println("Sayfa 18) When function= ${whenFunction("1")}")
        println("Sayfa 19) Range from 1-5= ${range(1,5)}")
        setExample(setOf(1,2,3))
        printNullableString()
        println("Sayfa 22) Type check=  ${typeCheck("String")}")
        println("Sayfa 46) Extension Function. Is 5 even=  ${5.isEven()}")
        println("Sayfa 48) Area of Circle= ${Circle(5.0).area()} ")
        println("Sayfa 48) Area of Rectangle= ${Rectangle(4.0,6.0).area()}")
        println("Sayfa 50) Directory size: ${printFilesSize("Text")}")
        println("Sayfa 52) First or null example: ${firstOrNullExample(listOf<String>("First element of the List", "Second Element"))}")
        println("Sayfa 53-54) If not null example: ${ifNotNullExample("Hello")}")
        println("Sayfa 56-57) Try catch example: ${tryCatchExample("10")}")
        println("Sayfa 59) Array of minus ones example: ${arrayOfMinusOnesExample(5).contentToString()}" )
        operateTurtle(Turtle())
        println("Sayfa 61) Also example: ${alsoExample("lowercase sentence to uppercase")}")
        println("Sayfa 68) Greeting message: ${"Hello" greet "Selen"}")
        println("Sayfa 69) Sum of vectors: ${Pair(3,4) + Pair(1,2)}")
        println("Sayfa 70) Maximum of numbers: ${findMax(10,20,30)}")
        getSurpriseBoxContents()
        println("Sayfa 76) Nullable content: ${printContent("10")}, ${printContent(10)}")
        println("Sayfa 77) Vehicle information: ${vehicleInformation()}")
        println("Sayfa 82) For loop example: ${forLoopExample("Hello")} ")
        println("Sayfa 83) Countdown from 5: ${countdown(5)}")
        println("Sayfa 84) Countdown from 5 in do-while loop: ${doWhileCountdown(5)}")
        controlFlowRangesExamples()
        equality()
        printBookDetails()
    }

    data class Book(val title: String, val genre: String)

    fun printBookDetails() {
        println("Sayfa 92) ")
        val book2 = Book("Dune",genre = "Sci-fi")
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
        }  while (count < seconds)
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

}
