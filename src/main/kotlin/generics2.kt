abstract class Animal(val name: String) {
    fun feed() = println("feeding $name")
}

class Cat(name: String) : Animal(name) {
    fun cleanLitter() = println("cleaning $name's litter")
}

class Dog(name: String) : Animal(name)

// if type param is declared as <out T : Animal> only then will Herd<Cat> be a subtype of Herd<Animal>
class Herd<T : Animal>(private val animals: List<T>) {
    val size = animals.size

    operator fun get(index: Int): T = animals[index]
}

fun main(args: Array<String>) {
    val dogs = listOf(Dog("rover"), Dog("spike"))
    val cats = listOf(Cat("mittens"), Cat("whiskers"))

    val catHerd: Herd<Cat> = Herd(cats)
    // try to use catHerd when Herd<Animal> is required
    feedAll(catHerd)
    takeCareOfCats(catHerd)

    val dogHerd: Herd<Dog> = Herd(dogs)
    // try to use dogHerd when Herd<Animal> is required
    feedAll(dogHerd)
}

fun feedAll(herd: Herd<Animal>) {
    for (i in 0 until herd.size) {
        herd[i].feed()
    }
}

// requires cats to be of type Herd<Cat> and then pass them to a function expecting a Herd<Animal>
fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    feedAll(cats)
}
