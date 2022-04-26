class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var count = 0
        var zeroCount = 0
        for(number in lottos) {
            if(number == 0) {
                zeroCount++
                continue
            }
            if(win_nums.find { it == number } != null) count++
        }
        return intArrayOf(isRank(count+zeroCount), isRank(count))
    }

    fun isRank(score : Int) : Int {
        return if(score > 1) 7 - score
        else 6
    }
}