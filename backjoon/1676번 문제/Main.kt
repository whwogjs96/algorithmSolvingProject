import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()
    var count = generateSequence(5) { it * 5 }.take(500).sumOf { N / it }
    println(count)
}