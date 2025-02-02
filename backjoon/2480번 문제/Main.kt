fun main() {
    val data = readln().split(' ').map(String::toInt)
    val numbers = data.groupingBy { it }.eachCount()

    numbers.entries.firstOrNull { it.value == 3 }?.let {
        println(10000 + it.key * 1000)
        return
    }

    numbers.entries.firstOrNull { it.value == 2 }?.let {
        println(1000 + it.key * 100)
        return
    }

    println((numbers.keys.maxOrNull() ?: 0) * 100)
}