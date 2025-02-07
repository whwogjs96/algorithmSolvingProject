import kotlin.math.sqrt

fun main() {
    System.`in`.bufferedReader().use { br ->
        val (m, n) = br.readLine().split(' ').map { it.toInt() }
        val result = buildString {
            for (i in m..n) {
                if (isPrime(i)) appendLine(i)
            }
        }
        print(result)
    }
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    if (num == 2 || num == 3) return true
    if (num % 2 == 0 || num % 3 == 0) return false
    for (i in 5..sqrt(num.toDouble()).toInt() step 6) {
        if (num % i == 0 || num % (i + 2) == 0) return false
    }
    return true
}