package org.example

class PowerOfTwo: (Int) -> Int {
    override fun invoke(p1: Int): Int {
        return p1.times(p1)
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


    val changedNumber = LambdaAsParams.changeInt(number) {it * 2 }
    println(changedNumber)


    "123456".doSomething {
        println("Lambda as an extension function being performed on $it")
    }

}