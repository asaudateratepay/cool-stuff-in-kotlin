package org.example.patterns

class ListDelegate<E>(
    val delegate: MutableList<E>,
    val addListener: (E) -> Unit,
) : MutableList<E> by delegate {


    override fun add(element: E): Boolean {
        return delegate.add(element).also {
            addListener(element)
        }
    }

    override fun toString(): String {
        return delegate.toString()
    }

}


fun main() {
    val listeningList = ListDelegate<String>(mutableListOf()) {
        println("Added to list: $it")
    }

    listeningList.add("Ratepay")
    listeningList.add("Snowball")
    listeningList.add("pAPI")
    listeningList.add("Alexandre")

    println(listeningList)

}