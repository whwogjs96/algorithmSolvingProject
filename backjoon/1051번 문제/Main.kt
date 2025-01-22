import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val (n , m) = br.readLine().split(' ').map { it.toInt() }
    val array = Array(n) {
        br.readLine().map { it.digitToInt() }.toIntArray()
    }
    var maxSide = 1 // 최대 변의 길이 초기화

    for (i in 0..<n) {
        for (j in 0..<m) {
            val maxDistance = minOf(n - i, m - j) - 1 // i, j에서 만들 수 있는 최대 거리 계산
            for (distance in maxSide..maxDistance) {
                if (array[i][j] == array[i][j + distance] && // 좌상단 == 우상단
                    array[i][j] == array[i + distance][j] && // 좌상단 == 좌하단
                    array[i][j] == array[i + distance][j + distance] // 좌상단 == 우하단
                ) {
                    maxSide = maxOf(maxSide, distance + 1) // 최대 변 길이 갱신
                }
            }
        }
    }

    println(maxSide * maxSide) // 정사각형의 넓이 출력
}