package org.example.dsl


data class Role(val workingHours: Int)

data class Employee(val name: String, val role: Role) {

    infix fun worksFullTimeAs(role: Role): Boolean {
        return role.workingHours >= 8
    }

}



fun main() {
    val softwareEngineer = Role(workingHours = 8)
    val alexandre = Employee("Alexandre", softwareEngineer)


    if (alexandre worksFullTimeAs softwareEngineer) {
        println("Alexandre works full time")
    }
}

