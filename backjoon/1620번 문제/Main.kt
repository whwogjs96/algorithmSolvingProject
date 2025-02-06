fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val indexMap = Array(n) { br.readLine() }
    val nameMap = indexMap.withIndex().associate { it.value to it.index + 1 }

    val result = List(m) {
        val query = br.readLine()
        query.toIntOrNull()?.let { indexMap[it - 1] } ?: nameMap[query]
    }.joinToString("\n")

    println(result)
}