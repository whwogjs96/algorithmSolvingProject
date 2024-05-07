fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(' ').map { it.toInt() }

    println("${factorial(n)/(factorial(k)*factorial(n - k))}")
}

fun factorial(number: Int) : Int {
    return if(number <= 1) 1
    else factorial(number - 1) * number
}