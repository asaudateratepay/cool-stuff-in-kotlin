package org.example

import java.time.LocalDate

data class Person(
    val name: String,
    val dateOfBirth: LocalDate,
    val address: String,
)


fun main() {

    val alexandre = Person(
        name = "Alexandre",
        dateOfBirth = LocalDate.parse("2000-01-01"),
        address = "Ritterstr. 14"
    )
    println(alexandre)

    val other = alexandre.copy(
        name = "Other person"
    )

    println(other)
}