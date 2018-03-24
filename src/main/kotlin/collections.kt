fun List<Int>.mean() = sum() / size.toFloat()

fun main(args: Array<String>) {
    val list: List<Int> = listOf(1, 2, 3)

    // joinToString is one of many built in extension functions to add operations not found in Java but still allow
    // the Java collection classes to be used in Kotlin
    println(list.joinToString(separator = "#!", prefix = "numbers "))

    // using our own extension function of List<Int>
    println(list.mean())
}

