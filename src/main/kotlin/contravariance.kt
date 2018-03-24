val anyComparator = Comparator<Any> { o1, o2 ->
    o1.hashCode() - o2.hashCode()
}

fun main(args: Array<String>) {
    val strings = listOf("b", "c", "a")
    println(strings.sortedWith(anyComparator))
}
