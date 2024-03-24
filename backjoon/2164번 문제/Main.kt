import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val queue:Queue<Int> = LinkedList()
    queue.addAll(1 .. N)
    while (queue.size > 1) {
        step(queue)
    }
    println(queue.poll())
}

fun step(queue: Queue<Int>) {
    queue.poll()
    queue.add(queue.poll())
}