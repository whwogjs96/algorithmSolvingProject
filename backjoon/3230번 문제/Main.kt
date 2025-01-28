fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val oneGameResult = ArrayList<Int>()
    repeat(n) { playerNumber -> // playerNumber는 1부터 시작이므로 출력시 1 더하기
        val ranking = br.readLine().toInt() - 1 //ranking도 1부터 시작이므로 더할 때 1 빼기
        oneGameResult.add(ranking, playerNumber)
    }
    val twoGameResult = ArrayList<Int>()
    for (prevGameRank in m - 1 downTo 0) {
        val ranking = br.readLine().toInt() - 1 //ranking도 1부터 시작이므로 더할 때 1 빼기
        twoGameResult.add(ranking, oneGameResult[prevGameRank])
    }

    for (i in 0 ..< 3) {
        println(twoGameResult[i] + 1)
    }
}