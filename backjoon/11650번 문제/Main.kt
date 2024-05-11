import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val map : HashMap<Int, ArrayList<Int>> = LinkedHashMap()
    repeat(br.readLine().toInt()) {
        val (x, y) = br.readLine().split(' ')
        val list : ArrayList<Int> = map.getOrElse(x.toInt()) {
            val newList = ArrayList<Int>()
            map[x.toInt()] = newList
            newList
        }
        list.add(y.toInt())
    }
    map.toSortedMap().forEach { (x, yList) ->
        yList.sorted().forEach { y -> sb.append("$x $y").appendLine() }
    }
    println(sb)
}