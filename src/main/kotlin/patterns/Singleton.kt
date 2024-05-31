package org.example.patterns

object Singleton {

    var value = "VALUE"


    fun changeValue(value: String) {
        Singleton.value = value
    }

}


fun main() {

    // The following cannot be invoked. An object is a Singleton, and cannot be instantiated
    // Singleton()

    println(Singleton.value)
    Singleton.changeValue("Ratepay")
    println(Singleton.value)
}