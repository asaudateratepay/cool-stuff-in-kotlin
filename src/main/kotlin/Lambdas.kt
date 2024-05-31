package org.example

import kotlin.math.pow

class PowerOfTwo: (Int) -> Int {
    override fun invoke(p1: Int): Int {
        return p1.times(p1)
    }
}


class Power(val powerValue: Int) : (Int) -> Int{

    override fun invoke(p1: Int): Int {
        return p1.toDouble().pow(powerValue.toDouble()).toInt()
    }

}

object LambdaAsParams {


    fun changeInt(number: Int , usingFunction: (Int) -> Int): Int {
        return usingFunction(number)
    }


}


fun String.doSomething(function: (String) -> Unit) = function(this)


fun main() {
    val number = 5
    val powerOfTwo = PowerOfTwo()

    println(powerOfTwo(number))


    val power = Power(4)
    println(power(number))

    val changedNumber = LambdaAsParams.changeInt(number) {it * 2 }
    println(changedNumber)


    "123456".doSomething {
        println("Lambda as an extension function being performed on $it")
    }

}