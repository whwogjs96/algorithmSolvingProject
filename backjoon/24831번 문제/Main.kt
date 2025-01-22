fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val result = StringBuilder()
    repeat(t) {
        val (x, y, a, b) = br.readLine().split(' ').map { it.toInt() }
        val distance = y - x
        val moveDistancePerSecond = a + b
        if(distance % moveDistancePerSecond != 0) result.appendLine("-1")
        else result.appendLine("${distance / moveDistancePerSecond}")
    }
    println(result)
}