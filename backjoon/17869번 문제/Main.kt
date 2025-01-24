fun main() {
    val br = System.`in`.bufferedReader()
    var number = br.readLine().toBigInteger()
    var result = 0
    val one = 1.toBigInteger()
    val two = 2.toBigInteger()
    val zero = 0.toBigInteger()
    while (number != one) {
        result++
        number = if(number.rem(two) == zero) number.div(two) else number.plus(one)
    }
    println(result)
}