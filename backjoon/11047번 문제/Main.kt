import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, k) = readLine().split(" ").map { it.toInt() }
    val coinList = IntArray(n) { readLine().toInt() }
    var result = 0
    for (index in coinList.size - 1 downTo 0) {
        val coin = coinList[index]
        if(coin <= k) {
            result += k / coin
            k %= coin
        }
        if(k == 0) break
    }
    println(result)
}