fun main() {
    val n = readln().toInt()
    val potatoList = readln().split(" ").map { it.toInt() }.sorted()
    val sungwoo = potatoList.subList(0, potatoList.size / 2).sum()
    val park = potatoList.subList(potatoList.size / 2, potatoList.size).sum()
    println("$sungwoo $park")
}