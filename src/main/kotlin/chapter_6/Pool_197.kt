package chapter_6

abstract class Appliance {
    var pluggedIn = true
    abstract val color: String

    abstract fun consumePower()
}

class CoffeeMaker: Appliance(){
    override val color = "white"
    var coffeeLeft = false

    override fun consumePower() {
        println("Consuming power")
    }

    fun fillWithWater() {
        println("Fill with water")
    }
    fun makeCoffee() {
        println("Make the coffee")
    }
}

fun main(){
    val coffeeMaker1 = CoffeeMaker()

    println(coffeeMaker1.coffeeLeft)
    println(coffeeMaker1.color)
    println(coffeeMaker1.pluggedIn)
    coffeeMaker1.consumePower()
    coffeeMaker1.fillWithWater()
    coffeeMaker1.makeCoffee()
}
