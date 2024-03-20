import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stack = Stack<Int>()
    val result = mutableListOf<String>()
    val arr = IntArray(br.readLine().toInt()) { br.readLine().toInt() }
    var currentPosition = 1
    for(n in arr) {
        while (currentPosition <= n) {
            stack.push(currentPosition++)
            result.add("+")
        }
        if(stack.peek() == n) {
            stack.pop()
            result.add("-")
        } else {
            println("NO")
            return
        }
    }
    println(result.joinToString("\n"))
}