package org.example.patterns

import java.time.Duration


data class ObjectToBuild(
    val propA: Int,
    val propB: String,
    val propC: Duration,
) {


    companion object { // Could also be a separate class

        fun buildObject(
            propA: Int = 10,
            propB: String = "blablbla",
            propC: Duration = Duration.ofMinutes(10),
        ): ObjectToBuild {

            return ObjectToBuild(
                propA = propA,
                propB = propB,
                propC = propC,
            )
        }
    }


}


fun main() {

    val buildObject = ObjectToBuild.buildObject()
    println(buildObject)


    val buildObject2 = ObjectToBuild.buildObject(propB = "Ratepay")
    println(buildObject2)


    val changedObject = buildObject.copy(propC = Duration.ofMinutes(1L))
    println(changedObject)

}