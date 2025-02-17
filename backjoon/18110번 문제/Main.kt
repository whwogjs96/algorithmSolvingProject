import java.io.*
import kotlin.math.roundToInt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    if(n == 0) {
        println(0)
        return@with
    }
    val list = List(n) { readLine().toInt() }.sorted()
    val trimmed = (n * 0.15).roundToInt()
    println(list.drop(trimmed).dropLast(trimmed).average().roundToInt())
}