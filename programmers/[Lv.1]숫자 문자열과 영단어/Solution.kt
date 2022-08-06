class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val characters = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var temp = s
        for((index, character) in characters.withIndex()) {
            temp = temp.replace(character, index.toString())
        }
        return temp.toInt()
    }
}