import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        HashMap<Character, Integer> wordList = new HashMap();
        wordList.put('A', 0);
        wordList.put('E', 1);
        wordList.put('I', 2);
        wordList.put('O', 3);
        wordList.put('U', 4);//데이터 저장
        int index = 3905;
        for(int i = 0;i<word.length();i++) {
            char character = word.charAt(i);
            answer += wordList.get(character)*(index/=5)+1;
        }
        return answer;
    }
}