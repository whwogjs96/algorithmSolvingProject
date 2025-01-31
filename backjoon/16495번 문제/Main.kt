fun main() {
    var power = 1L
    println(readln().reversed().sumOf { (it - 'A' + 1) * power.also { power *= 26 } })
}