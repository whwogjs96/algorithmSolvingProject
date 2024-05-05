fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val cnt = br.readLine().toInt()
    val arr = IntArray(cnt) { br.readLine().toInt() }
    br.close()
    arr.sort()
    arr.forEach { bw.write("$it\n") }
    bw.flush()
    bw.close()
}