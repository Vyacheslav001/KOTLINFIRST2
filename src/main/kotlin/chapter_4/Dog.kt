package chapter_4

class Dog(
    val name: String,
    weight_param: Int,
    breed_param: String
) {

    private var javaProperty = ""

    fun setJavaProperty1(javaProperty: String){
        if (javaProperty != "fuck") {
//            this.javaProperty = javaProperty
            setJavaProperty1(javaProperty)
        }
    }

    fun getJavaProperty1(): String{
        return javaProperty
    }

    init {
        print("Dog $name has been created. ")
        weight_param
    }

    var activities = arrayOf("Walks")
    private val breed = breed_param.toUpperCase()

    init {
        println("The breed is $breed.")
    }

    var weight = weight_param
        set(value) {
            if (value > 0) field = value
        }
    val weightInKgs: Double
        get() = weight / 2.2

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")

    }
}

fun main(args: Array<String>) {

    val myDog = Dog(name = "Fido", weight_param = 70, breed_param = "Mixed")

    myDog.setJavaProperty1("no fuck")
    myDog.setJavaProperty1("fuck")
    println(myDog.getJavaProperty1())
//    myDog.javaProperty = "fuck"
    println(myDog.getJavaProperty1())

    myDog.bark()
    myDog.weight = 75
    println("Weight in Kgs is ${myDog.weightInKgs}")
    myDog.weight = -2
    println("Weight is ${myDog.weight}")
    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for (item in myDog.activities) {
        println("My dog enjoys $item")
    }
    val dogs = arrayOf(Dog("Kelpie", 20, "Westie"), Dog("Ripper", 10, "Poodle"))
    dogs[1].bark()
    dogs[1].weight = 15
    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")
}