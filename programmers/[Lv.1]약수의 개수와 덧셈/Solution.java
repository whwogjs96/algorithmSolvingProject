class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int s = (int)Math.ceil(Math.sqrt(left));
        int ss = s * s;
        for (int i = left; i <= right; i++) {
            if (i == ss) {
                answer -= i;
                s++;
                ss = s * s;
            } else answer += i;
        }
        return answer;
    }
}