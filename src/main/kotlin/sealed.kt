sealed class Expr

class Num(val value: Int) : Expr()

class Sum(val left: Expr, val right: Expr) : Expr()

// if another subclass is added, then when expression below will no longer be exhaustive and will fail to compile
//class Mult(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int =
        // forces us to handle all possible subclasses of the sealed class but allowed to leave out the else branch
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
//            is Mult -> eval(e.right) * eval(e.left)
        }

fun main(args: Array<String>) {
    val result = eval(Sum(Sum(Num(1), Num(2)), Num(4)))
    println(result)
}
