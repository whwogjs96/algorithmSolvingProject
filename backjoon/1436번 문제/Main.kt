import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    getTitle(N)
}

fun getSixCount(prevNumber: Int) : Int {
    var count = 0
    var currentNumber = prevNumber
    while (currentNumber % 10 == 6) {
        count++
        currentNumber /= 10
    }
    return count
}

private fun getTitle(N : Int) {
    var prevNumber = 1
    var count = 1
    var result = "666"
    while (N != count) {
        if(prevNumber % 10 != 6) {
            count++
            result = "${prevNumber}666"
        } else {
            val sixCount = getSixCount(prevNumber)
            val middleNumber = when(sixCount) {
                0 -> "666"
                1 -> "66"
                2 -> "6"
                else -> ""
            }
            for (i: Int in 0 until (10.0).pow(sixCount).toInt()) {
                count++
                if(count == N) {
                    result = "${prevNumber}${middleNumber}${i.toString().padStart(sixCount, '0')}"
                    break
                }
            }
        }
        prevNumber++
    }
    println(result)
}