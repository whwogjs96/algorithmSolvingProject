import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Arrays
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().split(" ")[1].toInt()
    val cardList = br.readLine().split(" ").map { it.toInt() }.sorted()
    val size = cardList.size
    var result = 0
    for(i in 0 until size - 2) {
        if(cardList[i] + cardList[i + 1] + cardList[i + 2] > m) break
        for(j in i + 1 until size - 1) {
            if (cardList[i] + cardList[j] + cardList[j + 1] > m) break
            for (k in j + 1 until size) {
                val sum = cardList[i] + cardList[j] + cardList[k]
                if(sum in (result + 1)..m) { result = sum }
                if(result == m) {
                    println(result)
                    return
                }
            }
        }
    }
    println(result)
}