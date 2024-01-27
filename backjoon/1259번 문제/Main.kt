import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val s = br.readLine()
        if(s == "0") break
        bw.write("${if(s.reversed() == s) "yes" else "no"}\n")
    }
    bw.flush()
    bw.close()
    br.close()
}