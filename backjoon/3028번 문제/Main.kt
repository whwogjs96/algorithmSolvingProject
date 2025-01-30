import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val methods = br.readLine()

    var ballPosition = 1

    for (method in methods) {
        when (method) {
            'A' -> if (ballPosition == 1) ballPosition = 2 else if (ballPosition == 2) ballPosition = 1
            'B' -> if (ballPosition == 2) ballPosition = 3 else if (ballPosition == 3) ballPosition = 2
            'C' -> if (ballPosition == 1) ballPosition = 3 else if (ballPosition == 3) ballPosition = 1
        }
    }

    println(ballPosition)
 }