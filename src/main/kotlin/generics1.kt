fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

fun main(args: Array<String>) {
    val list: List<String> = mutableListOf("abc", "bac")

    // accepts List<String> as a subtype of List<Any>
    printContents(list)

    // doesn't accept MutableList<String> as subtype of MutableList<Any>
    val list2: MutableList<String> = mutableListOf("abc", "bac")
    addAnswer(list2)

    // force it to add anyway and let it crash
//    addAnswer(list2 as MutableList<Any>)
//    list2.forEach({ s: String -> s.toUpperCase() })
}
