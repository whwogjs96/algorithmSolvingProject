class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        try {
            answer = Integer.parseInt(s);
        } catch(Exception e) {
            for(int i =0; i<english.length;i++) {
                s = s.replaceAll(english[i], Integer.toString(i));
            }
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}