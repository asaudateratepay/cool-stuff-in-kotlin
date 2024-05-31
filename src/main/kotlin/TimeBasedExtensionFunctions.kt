package org.example

import java.time.Duration

fun Int.days() = Duration.ofDays(toLong())

fun Int.seconds() = Duration.ofSeconds(toLong())

fun Int.minutes() = Duration.ofMinutes(toLong())

fun Int.hours() = Duration.ofMinutes(toLong())

fun Duration.prettyPrint() = toString().substring(2).replace("(\\d[HMS])(?!$)".toRegex(), "$1 ").lowercase()


fun main() {

    val twoDaysTwoHoursAndTenSeconds = 2.days() + 2.hours() + 10.seconds()

    println(twoDaysTwoHoursAndTenSeconds)
    println(twoDaysTwoHoursAndTenSeconds.prettyPrint())

}