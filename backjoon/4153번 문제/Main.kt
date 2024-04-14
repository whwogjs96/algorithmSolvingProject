import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val (x, y, z) = br.readLine().split(' ').map { it.toDouble() }
        if(x + y + z == 0.0) break
        if(isRightTriangle(x, y, z)) bw.write("right\n")
        else bw.write("wrong\n")
    }
    bw.flush()
}

fun isRightTriangle(x: Double, y: Double, z: Double): Boolean {
    val sortedSides = listOf(x, y, z).sorted()
    return sortedSides[0].pow(2) + sortedSides[1].pow(2) == sortedSides[2].pow(2)
}