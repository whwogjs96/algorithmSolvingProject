fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val gcd = if(a > b)gcd(a, b) else gcd(b, a)
    val result = StringBuilder()
    for(i in 1 .. gcd) {
        if( a % i == 0 && b % i == 0) result.appendLine("$i ${a / i} ${b / i}")
    }
    println(result)
}

fun gcd(big: Int, small: Int): Int {
    val r = big%small
    return if (r == 0) small
    else gcd(small, r)
}