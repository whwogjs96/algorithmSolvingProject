class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int quotient = n/3;
        int remainder = n%3;
        while(quotient>0) {
            sb.append(remainder);
            remainder=quotient%3;
            quotient/=3;
        }
        sb.append(remainder);
        answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }
}