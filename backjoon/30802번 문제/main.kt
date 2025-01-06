import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val totalParticipants = br.readLine().toInt()
    val sizeBundle = br.readLine().split(' ').map { it.toInt() } // 사이즈 6개
    val (tShirtBundleSize, penBundleSize) = br.readLine().split(' ').map { it.toInt() } // 사이즈 2개

    val tShirtSize = sizeBundle.sumOf { (it + tShirtBundleSize - 1) / tShirtBundleSize }
    
    val bundleCount = totalParticipants / penBundleSize
    val remainingPens = totalParticipants % penBundleSize

    println(tShirtSize)
    println("$bundleCount $remainingPens")
}