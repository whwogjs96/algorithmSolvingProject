import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (playerCount, game) = br.readLine().split(' ')
    val players = mutableSetOf<String>()

    repeat(playerCount.toInt()) {
        players.add(br.readLine())
    }
    println(players.size / (when(game) {
        "Y" -> 1
        "F" -> 2
        else -> 3 // 여기서는 입력이 무조건 Y, F, O 밖에 없으므로 else는 O
    }))
}