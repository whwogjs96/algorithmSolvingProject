import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    repeat(t) { i ->
        val b = br.readLine().toInt()
        val result = binaryToAscii(
            br.readLine()
                .replace('I', '1')
                .replace('O', '0')
                .trim()
        )
        println("Case #${i + 1}: $result")
    }
}

fun binaryToAscii(binaryString: String): String {
    // 8비트씩 나눠 처리
    return binaryString.chunked(8) // 8비트로 나눔
        .map { it.toInt(2) } // 2진수를 10진수로 변환
        .map { it.toChar() } // 10진수를 문자로 변환
        .joinToString("") // 변환된 문자들을 합침
}