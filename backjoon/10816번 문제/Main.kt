import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val cardCountList : HashMap<Int, Int> = HashMap()
    br.readLine()
    br.readLine().split(' ').forEach {
        val position = it.toInt()
        cardCountList[position] = cardCountList.getOrDefault(position, 0) + 1
    }
    br.readLine()
    br.readLine().split(' ').forEach {
        bw.write("${cardCountList.getOrDefault(it.toInt(), 0)} ")
    }
    bw.flush()
    bw.close()
}