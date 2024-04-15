import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.text.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = StringBuilder()
    repeat(br.readLine().toInt()) {
        result.append("${isPs(br.readLine())}\n")
    }
    println(result.toString())
}

fun isPs(data: String) : String {
    var count = 0
    for(char in data.toCharArray()) {
        if(char == '(') count++
        else count--
        if(count < 0) return "NO"
    }
    return if(count == 0) "YES" else "NO"
}