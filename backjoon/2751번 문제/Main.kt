import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Arrays
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = ArrayList<Int>()
    repeat(br.readLine().toInt()) {
        result.add(br.readLine().toInt())
    }
    result.sort()
    val sb = StringBuilder()
    result.forEach {
        sb.append(it)
        sb.appendLine()
    }
    println(sb)
}