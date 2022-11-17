class Solution {
    public long solution(int price, int money, int count) {
        long countAnswer = (1+count)*count/2;
        return (money - countAnswer*price > 0) ? 0 : (countAnswer*price - money);
    }
}