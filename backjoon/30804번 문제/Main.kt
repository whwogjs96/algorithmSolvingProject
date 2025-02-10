import kotlin.math.max

fun main() {
    readln()
    val fruit = readln().split(' ').map { it.toInt() }
    var max = 0
    var left = 0
    val countMap = HashMap<Int, Int>()
    for (right in fruit.indices) {
        countMap[fruit[right]] = countMap.getOrDefault(fruit[right], 0) + 1

        while (countMap.size > 2) {
            countMap[fruit[left]] = countMap[fruit[left]]!! - 1
            if (countMap[fruit[left]] == 0) countMap.remove(fruit[left])
            left++
        }
        max = max(max, right - left + 1)
    }
    println(max)
}