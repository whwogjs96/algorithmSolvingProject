import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val deck = ArrayDeque<Int>()
    repeat(br.readLine().toInt()) {
        val line = br.readLine().split(' ')
        val command = line[0]
        val data = line.getOrNull(1)
        when(command) {
            "push_front" -> { deck.addFirst(data!!.toInt()) }
            "push_back" -> { deck.addLast(data!!.toInt()) }
            "pop_front" -> { sb.appendLine(if(deck.isNotEmpty())deck.removeFirst() else -1) }
            "pop_back" -> { sb.appendLine(if(deck.isNotEmpty()) deck.removeLast() else -1) }
            "size" -> { sb.appendLine(deck.size) }
            "empty" -> { sb.appendLine(if(deck.isEmpty()) 1 else 0) }
            "front" -> { sb.appendLine(if(deck.isNotEmpty())deck.first() else -1) }
            "back" -> { sb.appendLine(if(deck.isNotEmpty())deck.last() else -1) }
            else -> { /* Nothing */ }
        }
    }
    println(sb)
}