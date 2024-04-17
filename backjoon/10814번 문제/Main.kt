import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val list = Array<ArrayList<String>>(201) {
        ArrayList()
    }
    repeat(br.readLine().toInt()) {
        val line = br.readLine().split(' ')
        list[line[0].toInt()].add(line[1])
    }
    repeat(201) {age ->
        list[age].forEach { name -> bw.write("$age $name\n") }
    }
    bw.flush()
    bw.close()
}