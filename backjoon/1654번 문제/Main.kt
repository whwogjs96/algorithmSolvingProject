import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (K, N) = br.readLine().split(' ').map { it.toInt() }
    var (max, min) = Pair(0L, 0L)
    val cableList = ArrayList<Long>()
    for(i : Int in 0 until K) {
        val cable = br.readLine().toLong()
        max = max.coerceAtLeast(cable + 1)
        cableList.add(cable)
    }
    while (min + 1 < max) {
        var count = 0L
        val middle = (max + min)/2
        cableList.forEach { count += it/middle }
        if(count < N) max = middle
        else min = middle
    }
    println(min)
}
