class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 45
        numbers.forEach { data -> answer -= data }
        return answer
    }
}