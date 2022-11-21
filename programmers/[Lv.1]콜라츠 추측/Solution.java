class Solution {
    public int solution(int num) {
        return collatzGuess(num, 0);
    }
    
    public int collatzGuess(long num, int count) {
        if(num == 1) return count;
        if(count > 500) return -1;
        if(num %2 ==0) {
            return collatzGuess(num/2, ++count);
        } else {
            return collatzGuess(num*3+1, ++count);
        }
    }
}