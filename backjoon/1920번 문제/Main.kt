import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val aList = br.readLine().split(' ').map { it.toInt() }.sorted()
    val M = br.readLine().toInt()
    val mList = br.readLine().split(' ').map { it.toInt() }
    //mList안의 숫자들이 aList내에 존재하는지 여부 파악하기
    val sb = StringBuilder()
    mList.forEach { sb.appendLine(findNumberInList(aList, it)) }
    println(sb.toString())
}

fun findNumberInList(sortedList: List<Int>, number: Int): Int {
    var left = 0
    var right = sortedList.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        when {
            sortedList[mid] == number -> return 1
            sortedList[mid] < number -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return 0
}