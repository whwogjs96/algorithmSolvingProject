fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val notListenSet = HashSet<String>(n)
    repeat(n) { notListenSet.add(readln()) }

    val result = mutableListOf<String>()
    repeat(m) {
        val person = readln()
        if (person in notListenSet) {
            result.add(person)
        }
    }

    result.sort()
    println(result.size)
    println(result.joinToString("\n"))
}
