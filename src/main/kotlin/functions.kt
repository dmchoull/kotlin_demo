// Functional types
val double: (Int) -> Int = { it * 2 }

fun printIfTrue(s: String, predicate: (String) -> Boolean) {
    if (predicate(s)) println(s)
}

// Nullable function type
fun callMeMaybe(callback: (() -> Unit)?) {
    callback?.invoke()
}

// Lambda with receiver
fun buildString(build: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    builder.build()
    return builder.toString()
}

// "Conventional" alternative to lambda with receiver
fun buildString2(build: (StringBuilder) -> Unit): String {
    val builder = StringBuilder()
    build(builder)
    return builder.toString()
}

fun main(args: Array<String>) {
    printIfTrue("foo") { it.startsWith("f") }

    // passing a lambda with a receiver type to change the scope of "this" inside the lambda to be an instance of StringBuilder
    val abc = buildString {
        append("a,")
        append("b,")
        append("c")
    }
    println(abc)

    // passing a traditional lambda with no receiver type resulting in repetition of the argument
    println(buildString2 { builder ->
        builder.append("1")
        builder.append("2")
        builder.append("3")
    })
}
