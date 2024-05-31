package org.example

import org.example.Currency.EUR
import org.example.Currency.USD
import java.math.BigDecimal


enum class Currency {
    EUR, USD
}

class Money(value: BigDecimal, private val currency: Currency = EUR) {

    private val value: BigDecimal

    init {
        require(value.scale() <= 2) {
            "Money must be precise only up to a scale of 2, not more than that. Value is $value"
        }
        this.value = value.setScale(2)
    }

    operator fun plus(another: Money): Money {
        verify(another)
        return Money(value + another.value)
    }

    operator fun minus(another: Money): Money {
        verify(another)
        return Money(value - another.value)
    }

    operator fun div(i: Int): List<Money> {
        val divideAndRemainder = value.divideAndRemainder(i.toBigDecimal()).onEach {
            it.setScale(2)
        }
        val installmentValue = divideAndRemainder[0]
        val remainder = divideAndRemainder[1]

        val installments = mutableListOf<Money>().also {
            (1..< i).map { _ -> it += Money(installmentValue, currency) }
            it += Money(installmentValue + remainder, currency)
        }

        return installments
    }

    private fun verify(another: Money) {
        require(this.currency == another.currency) {
            "You cannot add money from different currencies. Make sure to convert them before executing this operation"
        }
    }

    override fun toString(): String {
        return "$value $currency"
    }

}


fun main() {
    val ten = Money(BigDecimal.TEN)
    val one = Money(BigDecimal.ONE)


    println(ten + one)
    println(ten - one - one)


    val installments = Money(BigDecimal("5.04"), USD) / 5
    println(installments)
}