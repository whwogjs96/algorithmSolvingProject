fun main() {
    val l = readln().toInt()
    val m = 1234567891
    val message = readln()

    var r = 1L
    var result = 0L

    repeat(l) { index ->
        val s = message[index] - 'a' + 1
        result = (result + (r * s) % m) % m
        r = (r * 31) % m
    }

    println(result)
}