class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long count = Math.abs(a - b);
        if(a == b) return a;
        if(count % 2 == 0) {
            return (a + b) * (count/2) + (a + b)/2;
        } else {
            return (a + b) *(count/2 + 1);
        }
    }
}