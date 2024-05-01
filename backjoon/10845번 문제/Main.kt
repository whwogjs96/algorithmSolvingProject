import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val queue = LinkedList<Int>()
    repeat(n) {
        val line = br.readLine().split(" ")
        when(line[0]) {
            "push" -> {
                queue.offer(line[1].toInt())
            }
            "pop" -> {
                bw.write("${if(queue.isNotEmpty()) queue.poll() else -1}\n")
            }
            "size" -> {
                bw.write("${queue.size}\n")
            }
            "empty" -> {
                bw.write("${if(queue.isEmpty()) 1 else 0}\n")
            }
            "front" -> {
                bw.write("${if(queue.isNotEmpty()) queue.peek() else -1}\n")
            }
            "back" -> {
                bw.write("${if(queue.isNotEmpty()) queue.peekLast() else -1}\n")
            }
        }
    }
    bw.flush()
    bw.close()
}