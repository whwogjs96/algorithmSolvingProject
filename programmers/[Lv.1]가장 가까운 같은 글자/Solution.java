import java.util.*;

class Solution {
    public int[] solution(String s) {
        char[] sData = s.toCharArray();
        int[] answer = new int[sData.length];
        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        for(int i = 0; i < sData.length; i++) {
            if(index.containsKey(sData[i])) {
                int preIndex = index.get(sData[i]);
                answer[i] = i - preIndex;
            } else {
                answer[i] = -1;
            }
            index.put(sData[i],i);
        }
        return answer;
    }
}