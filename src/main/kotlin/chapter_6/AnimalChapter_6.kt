package chapter_6

abstract class Animal6 : Roamable6 {
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10
    open val t = 20

    abstract fun makeNoise()
    abstract fun eat()

    override fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

class Hippo6 : Animal6() {
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"
    override var t = 10

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }

    override fun roam() {
        super<Animal6>.roam()
//        super<Roamable6>.roam()
    }
}

abstract class Canine6 : Animal6() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

class Wolf6 : Canine6() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Hooooowl!")
    }

    override fun eat() {
        println("The Wolf is eating $food")
    }
}

class Vehicle6 : Roamable6 {
    override fun roam() {
        println("The Vehicle is roaming")
    }
}

class Vet6 {
    fun giveShot(animal: Animal6) {
        animal.makeNoise()
    }
}

interface Roamable6 {
    fun roam() {
        println("Roamable")
    }

}

class MyRoamable : Roamable6 {
    var r: Roamable6 = Wolf6()
    var animal: Animal6 = Wolf6()

    fun myFunction1() {
        if (r is Wolf6) {
            val wolf = r as Wolf6
            wolf.eat()
        }
    }

    fun myFunction2() {
        if (animal is Wolf6) {
            animal.eat()
        }
    }
}

fun main() {
    val animals: Array<Animal6> = arrayOf(Hippo6(), Wolf6())
    for (item in animals) {
        item.roam()
        item.eat()
    }
    val vet = Vet6()
    val wolf = Wolf6()
    val hippo = Hippo6()
    vet.giveShot(wolf)
    vet.giveShot(hippo)
    hippo.roam()
    println(hippo.t)

    var roamables = arrayOf(Hippo6(), Wolf6(), Vehicle6())
    for (item in roamables) {
        item.roam()
        if (item is Animal6) {
            item.eat()
        }
    }

    println()

    roamables = arrayOf(Hippo6(), Wolf6(), Vehicle6(), MyRoamable())
    for (item in roamables) {
        item.roam()
        if (item is Animal6) {
            item.eat()
        }
    }
}
