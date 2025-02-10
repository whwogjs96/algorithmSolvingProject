fun main() {
    val result = List(3) { readln().toIntOrNull() }
        .withIndex()
        .firstNotNullOfOrNull { (index, x) -> x?.plus(3 - index) }
        ?: 0

    println(when {
        result % 15 == 0 -> "FizzBuzz"
        result % 5 == 0 -> "Buzz"
        result % 3 == 0 -> "Fizz"
        else -> result
    })
}