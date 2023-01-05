class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLength = t.length();
        int pLength = p.length();
        for(int i = 0; i< tLength; i++) {
            if(i + pLength <= tLength && p.compareTo(t.substring(i, i + pLength))>=0) {
                answer++;
            }
        }
        return answer;
    }
}