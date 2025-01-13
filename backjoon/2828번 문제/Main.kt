fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val j = br.readLine().toInt()
    var leftPosition = 1
    var result = 0
    repeat(j) {
        val location = br.readLine().toInt()
        var moveCount = 0
        if(location >= leftPosition + m) {
            moveCount = (location - leftPosition) - (m - 1)
            leftPosition += moveCount
        } else if(location < leftPosition){
            moveCount = leftPosition - location
            leftPosition -= moveCount
        }
        result += moveCount
    }
    println(result)
}