import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val p = br.readLine().toInt()
    val result = StringBuilder()
    repeat(p) {
        var prev = 1
        var current = 1
        val (n , m) = br.readLine().split(' ').map { it.toInt() }
        var index = 2 // 3부터 시작이 맞으나 시작순서가 0이므로 3 - 1 해서 2
        while (true) {
            val next = (prev + current) % m
            prev = current
            current = next
            if(current == 1 && prev == 1) {
                result.appendLine("$n ${index - 1}")
                break
            }
            index++
        }
    }
    println(result)
}