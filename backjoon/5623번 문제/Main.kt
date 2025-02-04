fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val array = Array(n) { br.readLine().split(' ').map(String::toInt) }

    if (n == 2) return println("1 1")

    val first = (array[0][1] + array[0][2] - array[1][2]) / 2
    println(buildString {
        append(first)
        repeat(n - 1) { append(" ${array[0][it + 1] - first}") }
    })
}