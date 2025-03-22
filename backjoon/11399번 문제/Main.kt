import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val pList = br.readLine().split(" ").map { it.toInt() }.sorted()

    var result = 0
    var sum = 0
    for (time in pList) {
        sum += time
        result += sum
    }

    bw.write("$result")
    bw.flush()
    bw.close()
}
