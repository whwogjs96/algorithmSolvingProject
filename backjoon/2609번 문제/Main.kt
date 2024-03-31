import java.io.BufferedReader
import java.io.InputStreamReader
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numbers = br.readLine().split(' ')
    val a = numbers[0].toInt()
    val b = numbers[1].toInt()
    val gcd = getGCD(a, b)
    val lcm = getLCM(a, b, gcd)
    println(gcd)
    println(lcm)

}

fun getGCD(a: Int, b: Int): Int {
    var (num1, num2) = if (a > b) a to b else b to a

    while (num2 > 0) {
        num1 = num2.also { num2 = num1 % num2 }
    }
    return num1
}

fun getLCM(a: Int, b:Int, gcd: Int): Int = (a * b) / gcd