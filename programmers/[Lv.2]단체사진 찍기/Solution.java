import java.util.*;

class Solution {
    //각 캐릭터들의 이니셜을 담을 맵
    static HashMap<Character, Integer> character = new HashMap<Character, Integer>();
    static boolean[] visit;
    static int answer;
    static int[] charLocation;
    static String[] condition;


    public int solution(int n, String[] data) {
        answer = 0;
        visit = new boolean[8];
        charLocation = new int[8];
        condition = data;
        character.put('A', 0);
        character.put('C', 1);
        character.put('F', 2);
        character.put('J', 3);
        character.put('M', 4);
        character.put('N', 5);
        character.put('R', 6);
        character.put('T', 7);
        answerAlgorithm(0);
        return answer;
    }

    public static void answerAlgorithm(int index) {
        if(index == 8){
            //모든 위치에 캐릭터를 담은 후, 조건을 만족하는지 확인하고 만족하는 경우 answer 추가
            if(conditionCheck()) answer++;
        }
        else {
            //각 위치에 모든 캐릭터를 배치해보는 형태로 작성
            for(int i=0; i<8;i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    charLocation[index] = i;
                    answerAlgorithm(index+1);
                    visit[i] = false;
                }
            }
        }
    }

    //모든 조건을 만족하는 형태인지 확인
    public static boolean conditionCheck() {
        for(String data: condition) {
            int one = charLocation[character.get(data.charAt(0))];
            int two = charLocation[character.get(data.charAt(2))];
            char operation = data.charAt(3);
            int conditionData = data.charAt(4) - '0' + 1;
            if(operation == '=') {
                if(Math.abs(one - two) != conditionData) return false;
            } else if(operation == '>') {
                if(Math.abs(one - two) <= conditionData) return false;
            } else if(operation == '<') {
                if(Math.abs(one - two) >= conditionData) return false;
            }
        }
        return true;
    }
}