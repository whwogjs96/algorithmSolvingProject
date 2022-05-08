class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int number : absolutes) {
            answer+= (signs[i]) ? number : -number;
        }
        return answer;
    }
}