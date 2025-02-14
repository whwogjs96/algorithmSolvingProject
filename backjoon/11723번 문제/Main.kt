import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val m = br.readLine().toInt()
    var bitSet = 0
    val allSet = (1 shl 21) - 1  // 21비트 (0~20) 모두 1

    repeat(m) {
        val input = br.readLine()
        when {
            input.startsWith("add") -> {
                val num = input.substring(4).toInt()
                bitSet = bitSet or (1 shl num)
            }
            input.startsWith("remove") -> {
                val num = input.substring(7).toInt()
                bitSet = bitSet and (1 shl num).inv()
            }
            input.startsWith("check") -> {
                val num = input.substring(6).toInt()
                bw.write(if (bitSet and (1 shl num) != 0) "1\n" else "0\n")
            }
            input.startsWith("toggle") -> {
                val num = input.substring(7).toInt()
                bitSet = bitSet xor (1 shl num)
            }
            input == "all" -> bitSet = allSet
            input == "empty" -> bitSet = 0
        }
    }

    bw.flush()
    bw.close()
}
