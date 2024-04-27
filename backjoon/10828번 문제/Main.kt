import java.lang.StringBuilder
import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val stack: Stack<Int> = Stack()
    repeat(br.readLine().toInt()) {
        val line = br.readLine().split(' ')
        val command = line[0]
        val data = line.getOrNull(1)
        when(command) {
            "push" -> stack.push(data!!.toInt())
            "pop" -> sb.append(if(stack.isNotEmpty()) stack.pop() else -1).appendLine()
            "size" -> sb.append(stack.size).appendLine()
            "empty" -> sb.append(if(stack.isEmpty()) 1 else 0).appendLine()
            "top" -> sb.append(if(stack.isNotEmpty()) stack.peek() else -1).appendLine()
            else -> { /* Nothing */}
        }
    }
    println(sb)
}