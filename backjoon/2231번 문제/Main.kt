import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var result : Int? = null
    for(i : Int in 1 until N) {
        if(getConstructor(i) == N) {
            result = i
            break
        }
    }
    result?.let { println(result) }?: run { println(0) }
}

fun getConstructor(number: Int): Int {
    var temp = number
    var result = 0
    while (temp > 0) {
        result += temp % 10
        temp /= 10
    }
    return result + number
}

//fun getConstructor(number: Int): Int {
//    return number.toString().map { it.toString().toInt() }.sum() + number
//}
