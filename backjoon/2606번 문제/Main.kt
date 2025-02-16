import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val computerCount = br.readLine().toInt()
    val graph = Array(computerCount + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(computerCount + 1) { false }
    repeat(br.readLine().toInt()) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        graph[start].add(end)
        graph[end].add(start)
    }
    dfs(visited, graph, 1)
    bw.write("${visited.count { it } - 1}\n")
    bw.flush()
    bw.close()
}

fun dfs(visited: BooleanArray, graph: Array<MutableList<Int>>, next: Int) {
    visited[next] = true
    graph[next].forEach {
        if (!visited[it]) {
            dfs(visited, graph, it)
        }
    }
}