class Solution {
    fun solution(array: IntArray): Int {
        return array.map { it.toString().count {it == '7'} }.sum()
    }
}