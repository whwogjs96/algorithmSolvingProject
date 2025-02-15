import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val testCase = br.readLine().toInt()
    repeat(testCase) {
        val numberOfCostumes = br.readLine().toInt()
        val clothCount = HashMap<String, Int>()
        repeat(numberOfCostumes) {
            val type = br.readLine().substringAfter(' ')
            clothCount[type] = clothCount.getOrDefault(type, 0) + 1
        }
        val result = clothCount.values.fold(1) { acc, v -> acc * (v + 1) } - 1
        bw.write("$result\n")
    }

    bw.flush()
    bw.close()
}