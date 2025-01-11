fun main() {
    val br = System.`in`.bufferedReader()

    val result = StringBuilder()
    val rules = mapOf(
        "rock" to "scissors",
        "paper" to "rock",
        "scissors" to "paper"
    )
    while (true) {
        val line = br.readLine()
        if(line == "0") break
        val (n, k) = line.split(' ').map { it.toInt() }
        val winCount = IntArray(n) { 0 }
        val loseCount = IntArray(n) { 0 }
        val totalGames = (k * n * (n - 1)) / 2
        for (i in 0..< totalGames) {
            val (p1, m1, p2, m2) = br.readLine().split(' ')
            val player1 = p1.toInt() - 1
            val player2 = p2.toInt() - 1
            when {
                rules[m1] == m2 -> {
                    winCount[player1]++
                    loseCount[player2]++
                }
                rules[m2] == m1 -> {
                    winCount[player2]++
                    loseCount[player1]++
                }
            }
        }
        for (i in 0..< n) {
            val totalCount = (loseCount[i] + winCount[i]).toDouble()
            if(totalCount == 0.0) result.appendLine('-')
            else result.appendLine(String.format("%.3f", winCount[i]/totalCount))
        }
        result.appendLine()
    }
    println(result)
}