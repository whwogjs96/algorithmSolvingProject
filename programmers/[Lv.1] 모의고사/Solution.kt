import kotlin.math.*

class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = ArrayList<Int>()
        val onePerson = arrayOf(1, 2, 3, 4, 5)
        val twoPerson = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val ThreePerson = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        var answerCount = arrayListOf(0, 0, 0)
        for(index in 0 until answers.size) {
            if(answers[index] == onePerson[index%onePerson.size]) answerCount[0]++
            if(answers[index] == twoPerson[index%twoPerson.size]) answerCount[1]++
            if(answers[index] == ThreePerson[index%ThreePerson.size]) answerCount[2]++
        }
        var max = 0
        for(count in answerCount) {
            if(max < count) max = count
        }
        for(index in 0 until answerCount.size) {
            if(max <= answerCount[index]) answer.add(index+1)
        }
        return answer.toIntArray()
    }
}