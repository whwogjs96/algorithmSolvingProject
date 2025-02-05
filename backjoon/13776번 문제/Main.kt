fun main() {
    val br = System.`in`.bufferedReader()
    val resultMap = linkedMapOf<Char, Int>()

    repeat(br.readLine().toInt()) {
        br.readLine().forEach { resultMap.putIfAbsent(it, resultMap.size) }
    }

    println(resultMap.keys.joinToString("").replace(" ", ""))
}