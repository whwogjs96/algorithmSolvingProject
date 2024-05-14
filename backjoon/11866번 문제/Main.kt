import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, k) = br.readLine().split(" ").map(String::toInt)
    val personList = LinkedList((1..n).toList())
    var index = 0
    bw.write("<")
    while (personList.size > 1) {
        index = (index + k - 1) % personList.size
        bw.write("${personList.removeAt(index)}, ")
    }
    bw.write("${personList[0]}>")
    bw.flush()
    bw.close()
}